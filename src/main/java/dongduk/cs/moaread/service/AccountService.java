package dongduk.cs.moaread.service;

import dongduk.cs.moaread.dao.AccountDao;
import dongduk.cs.moaread.domain.account.Account;
import dongduk.cs.moaread.domain.account.Role;
import dongduk.cs.moaread.domain.account.Status;
import dongduk.cs.moaread.dto.account.request.LoginReqDto;
import dongduk.cs.moaread.dto.account.request.SignupReqDto;
import dongduk.cs.moaread.dto.account.response.LoginResDto;
import dongduk.cs.moaread.dto.account.response.SignupResDto;
import dongduk.cs.moaread.exception.BaseException;
import dongduk.cs.moaread.exception.status.ErrorCode;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.sql.Timestamp;

@Service
@RequiredArgsConstructor
public class AccountService {
    private final AccountDao accountDao;
    private final PasswordEncoder passwordEncoder;

    /* 회원 가입 */
    @Transactional
    public SignupResDto signup(SignupReqDto signupReqDto) {
        Timestamp currentTimestamp = new Timestamp(System.currentTimeMillis());

        Account newAccount = new Account();
        newAccount.setId(signupReqDto.getId());
        newAccount.setPassword(passwordEncoder.encode(signupReqDto.getPassword()));
        newAccount.setName(signupReqDto.getName());
        newAccount.setPhone(signupReqDto.getPhone());
        newAccount.setEmail(signupReqDto.getEmail());
        newAccount.setAddress(signupReqDto.getAddress());
        newAccount.setDetailedAddress(signupReqDto.getDetailedAddress());
        newAccount.setZip(signupReqDto.getZip());
        newAccount.setStatus(Status.ACTIVE);
        newAccount.setRole(Role.USER);
        newAccount.setCreatedAt(currentTimestamp);
        newAccount.setUpdatedAt(currentTimestamp);
        newAccount.setBlogUrl("/blog/" + signupReqDto.getId());

        if (signupReqDto.getAddress() == null || signupReqDto.getDetailedAddress() == null || signupReqDto.getZip() == null) {
            return new SignupResDto(accountDao.insertAccountExcludedAddress(newAccount));
        }

        return new SignupResDto(accountDao.insertAccount(newAccount));
    }

    /* 로그인 */
    @Transactional
    public LoginResDto login(LoginReqDto loginReqDto) {
        Account loginAccount = accountDao.findAccountById(loginReqDto.getId());

        // 아이디가 존재하지 않을 경우
        if (loginAccount == null) {
            throw new BaseException(ErrorCode.BAD_REQUEST, "아이디를 다시 확인해주세요.");
        }

        // 비밀번호가 틀렸을 경우
        if (!passwordEncoder.matches(loginReqDto.getPassword(), loginAccount.getPassword())) {
            throw new BaseException(ErrorCode.BAD_REQUEST, "비밀번호를 다시 확인해주세요.");
        }

        return new LoginResDto(loginAccount.getId());
    }
}