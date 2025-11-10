package itmo.aulouu.inf.sec.lab1.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;

@Data
@Builder
@AllArgsConstructor
public class SignInRequest {
    private String username;
    private String password;
}