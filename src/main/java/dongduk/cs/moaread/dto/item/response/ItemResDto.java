package dongduk.cs.moaread.dto.item.response;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public class ItemResDto {
    private int id;
    private String bookId;
    private String state;
    private long price;
    private int stock;
}
