package dongduk.cs.moaread.controller;

import dongduk.cs.moaread.dto.base.BaseResponse;
import dongduk.cs.moaread.dto.account.request.SignupReqDto;
import dongduk.cs.moaread.dto.account.response.SignupResDto;
import dongduk.cs.moaread.service.AccountService;
import lombok.RequiredArgsConstructor;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

@RestController
@RequiredArgsConstructor
@RequestMapping("/user")
public class AccountController {
    private final AccountService accountService;

    /* 회원 가입 */
    @PostMapping
    public BaseResponse<SignupResDto> signup(@Validated @RequestBody SignupReqDto signupReqDto) throws Exception {
        SignupResDto signupResDto = accountService.signup(signupReqDto);
        return BaseResponse.onSuccess(signupResDto);
    }
}