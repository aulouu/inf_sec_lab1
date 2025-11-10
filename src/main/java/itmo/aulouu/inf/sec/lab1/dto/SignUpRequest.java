package itmo.aulouu.inf.sec.lab1.dto;

import itmo.aulouu.inf.sec.lab1.entity.Role;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;

@Data
@Builder
@AllArgsConstructor
public class SignUpRequest {
    private String username;
    private String password;
    @Enumerated(EnumType.STRING)
    private Role role;
}
