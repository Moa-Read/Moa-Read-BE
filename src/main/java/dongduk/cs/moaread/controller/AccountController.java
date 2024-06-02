package dongduk.cs.moaread.controller;

import dongduk.cs.moaread.dto.account.request.LoginReqDto;
import dongduk.cs.moaread.dto.account.request.UpdateReqDto;
import dongduk.cs.moaread.dto.account.response.LoginResDto;
import dongduk.cs.moaread.dto.account.response.ProfileResDto;
import dongduk.cs.moaread.dto.account.response.UpdateResDto;
import dongduk.cs.moaread.dto.base.BaseResponse;
import dongduk.cs.moaread.dto.account.request.SignupReqDto;
import dongduk.cs.moaread.dto.account.response.SignupResDto;
import dongduk.cs.moaread.exception.BaseException;
import dongduk.cs.moaread.exception.status.ErrorCode;
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

    /* 회원 탈퇴 */
    @PatchMapping()
    public BaseResponse<String> withdraw(HttpServletRequest request) throws Exception {
        // 로그인 확인
        HttpSession session = request.getSession();
        Object object = session.getAttribute("userSession");

        if (object == null) {
            throw new BaseException(ErrorCode.REQUIRED_LOGIN);
        }

        String accountId = object.toString();

        if (accountService.withdraw(accountId) == 0) {
            throw new BaseException(ErrorCode.INTERNAL_SERVER_ERROR);
        }

        return BaseResponse.onSuccess("회원 탈퇴 성공");
    }

    /* 프로필 조회 */
    @GetMapping()
    public BaseResponse<ProfileResDto> getProfile(HttpServletRequest request) throws Exception {
        // 로그인 확인
        HttpSession session = request.getSession();
        Object object = session.getAttribute("userSession");

        if (object == null) {
            throw new BaseException(ErrorCode.REQUIRED_LOGIN);
        }

        String accountId = object.toString();

        ProfileResDto profile = accountService.getProfile(accountId);

        return BaseResponse.onSuccess(profile);
    }

    /* 프로필 수정 */
    @PatchMapping("/update")
    public BaseResponse<UpdateResDto> updateProfile(HttpServletRequest request, @Validated @RequestBody UpdateReqDto updateReqDto) throws Exception {
        // 로그인 확인
        HttpSession session = request.getSession();
        Object object = session.getAttribute("userSession");

        if (object == null) {
            throw new BaseException(ErrorCode.REQUIRED_LOGIN);
        }

        String accountId = object.toString();

        UpdateResDto updateResDto = accountService.updateProfile(accountId, updateReqDto);

        return BaseResponse.onSuccess(updateResDto);
    }
}