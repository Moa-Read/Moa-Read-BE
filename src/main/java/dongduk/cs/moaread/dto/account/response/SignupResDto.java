package dongduk.cs.moaread.dto.account.response;

import lombok.Getter;

@Getter
public class SignupResDto {
    private int result;

    public SignupResDto(int result) {
        this.result = result;
    }
}