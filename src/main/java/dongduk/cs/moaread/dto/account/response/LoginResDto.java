package dongduk.cs.moaread.dto.account.response;

import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class LoginResDto {
    private String userId;

    public LoginResDto(String userId) {
        this.userId = userId;
    }
}
