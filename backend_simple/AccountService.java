import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AccountService {
    @Autowired
    private AccountRepository accountRepository;

    public List<Account> getAccountsByUser(Long userId) {
        return accountRepository.findByUserId(userId);
    }

    public long countAccounts() {
        return accountRepository.count();
    }
}
