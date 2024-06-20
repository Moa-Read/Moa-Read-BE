package dongduk.cs.moaread.domain.orderDetail;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class orderDetail {
    private int orderId;
    private int itemId;
    private int price;
    private int quantity;
}