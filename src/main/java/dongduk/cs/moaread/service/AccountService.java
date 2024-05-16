package dongduk.cs.moaread.service;

import dongduk.cs.moaread.dao.AccountDao;
import dongduk.cs.moaread.domain.account.Account;
import dongduk.cs.moaread.domain.account.Role;
import dongduk.cs.moaread.domain.account.Status;
import dongduk.cs.moaread.dto.account.request.SignupReqDto;
import dongduk.cs.moaread.dto.account.response.SignupResDto;
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
}