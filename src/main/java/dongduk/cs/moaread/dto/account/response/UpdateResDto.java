package dongduk.cs.moaread.dto.account.response;

import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class UpdateResDto {
    int result;

    public UpdateResDto(int result) {
        this.result = result;
    }
}
