package itmo.aulouu.inf.sec.lab1.dto;

import itmo.aulouu.inf.sec.lab1.entity.Role;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import lombok.*;

@Data
@Builder(toBuilder = true)
@Getter
@AllArgsConstructor
@NoArgsConstructor
public class SignUpRequest {
    private String username;
    private String password;
    @Enumerated(EnumType.STRING)
    private Role role;
}
