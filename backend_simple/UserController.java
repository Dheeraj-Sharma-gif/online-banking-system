import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/users")
public class UserController {
    @Autowired
    private UserService userService;

    @PostMapping("/register")
    public User register(@RequestBody User user) {
        return userService.register(user);
    }

    @PostMapping("/login")
    public User login(@RequestBody LoginRequest request) {
        User user = userService.login(request.getEmail(), request.getPassword());
        if(user == null) {
            throw new RuntimeException("Invalid credentials");
        }
        return user;
    }
}

class LoginRequest {
    private String email;
    private String password;

    public String getEmail() {return email;}
    public void setEmail(String email) {this.email = email;}
    public String getPassword() {return password;}
    public void setPassword(String password) {this.password = password;}
}
