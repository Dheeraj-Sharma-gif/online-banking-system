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

    private String fullName;
    private String aadharNumber;
    private String panNumber;
    private String accountType; // Savings or Current
    private String status;      // APPROVED or REJECTED
}
