package dongduk.cs.moaread.dao;

import dongduk.cs.moaread.domain.item.Item;
import org.springframework.dao.DataAccessException;

import java.util.List;

public interface ItemDao {
    // 중고도서 등록
    int insertItem(Item item) throws DataAccessException;

    // 중고도서 상세 조회
    Item findItemById(int id) throws DataAccessException;

    // 중고도서 전체 조회
    List<Item> findAllItems() throws DataAccessException;

    // 중고도서 수정
    int updateItem(Item item) throws DataAccessException;

    // 중고도서 삭제
    int deleteItem(int id) throws DataAccessException;
}
