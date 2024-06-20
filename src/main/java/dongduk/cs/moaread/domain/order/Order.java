package dongduk.cs.moaread.domain.order;

import lombok.Getter;
import lombok.Setter;

import java.sql.Timestamp;

@Getter
@Setter
public class Order {
    private int id;
    private String userId;
    private String receiver;
    private String phone;
    private String address;
    private String detailAddress;
    private String zip;
    private int totalPrice;
    private int totalQuantity;
    private String request;
    private Timestamp createdAt;
    private String status;
    private String trackingNumber;
}
