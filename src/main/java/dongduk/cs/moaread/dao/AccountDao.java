package dongduk.cs.moaread.dao;

import dongduk.cs.moaread.domain.account.Account;
import org.springframework.dao.DataAccessException;

public interface AccountDao {
    int insertAccount(Account account) throws DataAccessException;
}