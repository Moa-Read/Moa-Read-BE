package dongduk.cs.moaread.controller;

import dongduk.cs.moaread.dto.account.request.LoginReqDto;
import dongduk.cs.moaread.dto.account.response.LoginResDto;
import dongduk.cs.moaread.dto.base.BaseResponse;
import dongduk.cs.moaread.dto.account.request.SignupReqDto;
import dongduk.cs.moaread.dto.account.response.SignupResDto;
import dongduk.cs.moaread.service.AccountService;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpSession;
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

    /* 로그인 */
    @PostMapping("/login")
    public BaseResponse<LoginResDto> login(HttpServletRequest httpServletRequest, @Validated @RequestBody LoginReqDto loginReqDto) throws Exception {
        LoginResDto loginResDto = accountService.login(loginReqDto);

        httpServletRequest.getSession().invalidate();
        HttpSession session = httpServletRequest.getSession();
        session.setAttribute("userSession", loginResDto.getUserId());
        session.setMaxInactiveInterval(1800);

        return BaseResponse.onSuccess(loginResDto);
    }

    /* 로그아웃 */
    @PostMapping("/logout")
    public BaseResponse<String> logout(HttpSession session) throws Exception {
        session.removeAttribute("userSession");
        session.invalidate();

        return BaseResponse.onSuccess("로그아웃 성공");
    }
}