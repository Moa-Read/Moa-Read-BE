package dongduk.cs.moaread.service;

import dongduk.cs.moaread.dao.ItemDao;
import dongduk.cs.moaread.domain.item.Item;
import dongduk.cs.moaread.exception.ErrorCode;
import dongduk.cs.moaread.dto.item.request.CreateItemReqDto;
import dongduk.cs.moaread.dto.item.request.UpdateItemReqDto;
import dongduk.cs.moaread.dto.item.response.ItemResDto;
import dongduk.cs.moaread.exception.BaseException;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class ItemService {
    private final ItemDao itemDao;

    @Transactional
    public ItemResDto createItem(CreateItemReqDto createItemReqDto) {
        Item newItem = new Item();
        newItem.setBookId(createItemReqDto.getBook_isbn());
        newItem.setState(createItemReqDto.getState());
        newItem.setPrice(createItemReqDto.getPrice());
        newItem.setStock(createItemReqDto.getStock());

        int result = itemDao.insertItem(newItem);
        if (result == 0) {
            throw new BaseException(ErrorCode.INTERNAL_SERVER_ERROR, "Item creation failed");
        }

        return new ItemResDto(newItem.getId(), newItem.getBookId(), newItem.getState(), newItem.getPrice(), newItem.getStock());
    }

    @Transactional
    public ItemResDto getItem(int id) {
        Item item = itemDao.findItemById(id);
        if (item == null) {
            throw new BaseException(ErrorCode.ITEM_NOT_FOUND, "Item not found");
        }
        return new ItemResDto(item.getId(), item.getBookId(), item.getState(), item.getPrice(), item.getStock());
    }

    @Transactional
    public List<ItemResDto> getAllItems() {
        List<Item> items = itemDao.findAllItems();
        return items.stream()
                .map(item -> new ItemResDto(item.getId(), item.getBookId(), item.getState(), item.getPrice(), item.getStock()))
                .collect(Collectors.toList());
    }

    @Transactional
    public ItemResDto updateItem(int id, UpdateItemReqDto updateItemReqDto) {
        Item item = itemDao.findItemById(id);
        if (item == null) {
            throw new BaseException(ErrorCode.ITEM_NOT_FOUND, "Item not found");
        }

        item.setPrice(updateItemReqDto.getPrice());
        item.setStock(updateItemReqDto.getStock());
        item.setState(updateItemReqDto.getState());

        int result = itemDao.updateItem(item);
        if (result == 0) {
            throw new BaseException(ErrorCode.INTERNAL_SERVER_ERROR, "Item update failed");
        }

        return new ItemResDto(item.getId(), item.getBookId(), item.getState(), item.getPrice(), item.getStock());
    }

    @Transactional
    public void deleteItem(int id) {
        int result = itemDao.deleteItem(id);
        if (result == 0) {
            throw new BaseException(ErrorCode.INTERNAL_SERVER_ERROR, "Item deletion failed");
        }
    }
}
