import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class AccountApplicationService {
    @Autowired
    private AccountApplicationRepository accountApplicationRepository;

    @Autowired
    private AccountRepository accountRepository;

    public AccountApplication submitApplication(AccountApplication application) {
        application.setStatus("PENDING");
        return accountApplicationRepository.save(application);
    }

    public String reviewApplication(Long applicationId) {
        AccountApplication app = accountApplicationRepository.findById(applicationId).orElse(null);
        if(app == null) return "Application not found";

        // Simple validation: length checks
        if(app.getAadharNumber() != null && app.getAadharNumber().length() == 12 &&
           app.getPanNumber() != null && app.getPanNumber().length() == 10) {

            app.setStatus("APPROVED");
            accountApplicationRepository.save(app);

            // Create account immediately
            Account acc = new Account();
            acc.setUserId(app.getUserId());
            acc.setAccountType(app.getAccountType());
            acc.setBalance(0.0);
            accountRepository.save(acc);

            return "Application Approved and Account Created";
        } else {
            app.setStatus("REJECTED");
            accountApplicationRepository.save(app);
            return "Application Rejected due to invalid details";
        }
    }
}
