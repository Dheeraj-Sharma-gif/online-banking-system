import jakarta.persistence.*;
import lombok.*;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
public class AccountApplication {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private Long userId;
    private String fullName;
    private String aadharNumber;
    private String panNumber;
    private String accountType;
    private String status;  // APPROVED or REJECTED
}
