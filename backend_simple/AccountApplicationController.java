import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/applications")
public class AccountApplicationController {
    @Autowired
    private AccountApplicationService applicationService;

    @PostMapping("/submit")
    public AccountApplication submit(@RequestBody AccountApplication application) {
        return applicationService.submitApplication(application);
    }

    @PostMapping("/review/{id}")
    public String review(@PathVariable Long id) {
        return applicationService.reviewApplication(id);
    }
}
