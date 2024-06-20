package dongduk.cs.moaread.controller;

import dongduk.cs.moaread.domain.item.ErrorCode;
import dongduk.cs.moaread.dto.base.BaseResponse;
import dongduk.cs.moaread.dto.item.request.CreateItemReqDto;
import dongduk.cs.moaread.dto.item.request.UpdateItemReqDto;
import dongduk.cs.moaread.dto.item.response.ItemResDto;
import dongduk.cs.moaread.exception.BaseException;
import dongduk.cs.moaread.service.ItemService;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpSession;
import lombok.RequiredArgsConstructor;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/item")
public class ItemController {
    private final ItemService itemService;

    @PostMapping
    public BaseResponse<ItemResDto> createItem(HttpServletRequest request, @Validated @RequestBody CreateItemReqDto createItemReqDto) {
        // 관리자 확인 로직
        HttpSession session = request.getSession();
        Object object = session.getAttribute("userSession");
        if (object == null || !object.equals("admin")) {
            throw new BaseException(EErrorCode.REQUIRED_LOGIN);
        }

        return BaseResponse.onSuccess(itemService.createItem(createItemReqDto));
    }

    @GetMapping("/{id}")
    public BaseResponse<ItemResDto> getItem(@PathVariable int id) {
        return BaseResponse.onSuccess(itemService.getItem(id));
    }

    @GetMapping
    public BaseResponse<List<ItemResDto>> getAllItems() {
        return BaseResponse.onSuccess(itemService.getAllItems());
    }

    @PatchMapping("/{id}")
    public BaseResponse<ItemResDto> updateItem(@PathVariable int id, @Validated @RequestBody UpdateItemReqDto updateItemReqDto) {
        return BaseResponse.onSuccess(itemService.updateItem(id, updateItemReqDto));
    }

    @DeleteMapping("/{id}")
    public BaseResponse<String> deleteItem(@PathVariable int id) {
        itemService.deleteItem(id);
        return BaseResponse.onSuccess("Item deleted successfully");
    }
}
