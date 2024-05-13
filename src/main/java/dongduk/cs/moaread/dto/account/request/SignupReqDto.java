package dongduk.cs.moaread.dto.account.request;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Size;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class SignupReqDto {
    @NotBlank(message = "아이디는 필수 입력값입니다.")
    @Size(min = 2, max = 15, message = "아이디는 2 ~ 15자여야 합니다.")
    private String id;

    @NotBlank(message = "비밀번호는 필수 입력값입니다.")
    @Pattern(regexp = "^(?=.*[a-zA-Z])(?=.*\\d)(?=.*[!@#$%^&*()])[a-zA-Z\\d!@#$%^&*()]{8,15}$",
    message = "비밀번호는 8 ~ 15자 이상이어야 하며, 영문 대소문자, 숫자, 특수 문자를 각각 1개 이상 포함해야 합니다.")
    private String password;

    @NotBlank(message = "비밀번호 확인은 필수 입력값입니다.")
    private String confirmPassword;

    @NotBlank(message = "이름은 필수 입력값입니다.")
    @Size(min = 1, max = 15, message = "이름은 1 ~ 15자여야 합니다.")
    private String name;

    @NotBlank(message = "전화번호는 필수 입력값입니다.")
    @Pattern(regexp = "^01([016789])-\\d{3,4}-\\d{4}$",
    message = "전화번호 형식에 맞게 입력해주세요.")
    private String phone;

    @NotBlank(message = "이메일은 필수 입력값입니다.")
    @Email(message = "이메일 형식에 맞게 입력해주세요.")
    private String email;

    private String address;

    private String detailedAddress;

    @Pattern(regexp = "^\\d{5}$", message = "우편번호 형식에 맞게 입력해주세요.")
    private String zip;
}