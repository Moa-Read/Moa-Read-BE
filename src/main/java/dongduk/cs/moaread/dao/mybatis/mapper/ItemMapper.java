package dongduk.cs.moaread.dao.mybatis.mapper;

import dongduk.cs.moaread.domain.item.Item;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

@Mapper
public interface ItemMapper {
    int insertItem(Item item);
    Item findItemById(@Param("id") int id);
    List<Item> findAllItems();
    int updateItem(Item item);
    int deleteItem(@Param("id") int id);
}
