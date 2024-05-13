package dongduk.cs.moaread.domain.account;

import lombok.Getter;
import lombok.Setter;

import java.sql.Timestamp;

@Getter
@Setter
public class Account {
    private String id;
    private String password;
    private String name;
    private String phone;
    private String email;
    private String address;
    private String detailedAddress;
    private String zip;
    private Status status;
    private Role role;
    private Timestamp createdAt;
    private Timestamp updatedAt;
    private String blogUrl;
}