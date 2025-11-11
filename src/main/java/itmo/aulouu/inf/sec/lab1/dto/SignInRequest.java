package itmo.aulouu.inf.sec.lab1.dto;

import lombok.*;

@Data
@Builder(toBuilder = true)
@Getter
@AllArgsConstructor
@NoArgsConstructor
public class SignInRequest {
    private String username;
    private String password;
}