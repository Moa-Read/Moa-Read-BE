package dongduk.cs.moaread.dto.account.response;

import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class SignupResDto {
    private int result;

    public SignupResDto(int result) {
        this.result = result;
    }
}