package dongduk.cs.moaread.domain.application;

import lombok.Getter;
import lombok.Setter;

import java.sql.Timestamp;

@Getter
@Setter
public class Application {
    private int id;
    private String userId;
    private int totalQuanity;
    private String accountBank;
    private String accountNumber;
    private Timestamp createdAt;
    private String status;
}
