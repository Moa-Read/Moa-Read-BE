package dongduk.cs.moaread.dao.mybatis.mapper;

import dongduk.cs.moaread.domain.account.Account;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface AccountMapper {
    int insertAccount(Account account);

    int insertAccountExcludedAddress(Account account);

    Account findAccountById(String id);

    int updateStatus(String id);

    int updateAccount(Account account);
}