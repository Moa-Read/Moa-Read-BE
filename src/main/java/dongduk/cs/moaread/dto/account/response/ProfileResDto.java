package dongduk.cs.moaread.dto.account.response;

import dongduk.cs.moaread.domain.account.Status;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class ProfileResDto {
    private String id;
    private String name;
    private String phone;
    private String email;
    private String address;
    private String detailedAddress;
    private String zip;
    private String blogUrl;

    public ProfileResDto(String id, String name, String phone, String email,
                         String address, String detailedAddress, String zip, String blogUrl) {
        this.id = id;
        this.name = name;
        this.phone = phone;
        this.email = email;
        this.address = address;
        this.detailedAddress = detailedAddress;
        this.zip = zip;
        this.blogUrl = blogUrl;
    }
}
