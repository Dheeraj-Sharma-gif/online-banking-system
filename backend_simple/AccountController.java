import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/accounts")
public class AccountController {
    @Autowired
    private AccountService accountService;

    @GetMapping("/user/{userId}")
    public List<Account> getUserAccounts(@PathVariable Long userId) {
        return accountService.getAccountsByUser(userId);
    }

    @GetMapping("/count")
    public long getAccountCount() {
        return accountService.countAccounts();
    }
}
