package dongduk.cs.moaread.dao;

import dongduk.cs.moaread.domain.account.Account;
import org.springframework.dao.DataAccessException;

public interface AccountDao {
    int insertAccount(Account account) throws DataAccessException;

    int insertAccountExcludedAddress(Account account) throws DataAccessException;

    Account findAccountById(String id) throws DataAccessException;
}