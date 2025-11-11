package itmo.aulouu.inf.sec.lab1.dto;

import lombok.*;

@Data
@Builder(toBuilder = true)
@Getter
@AllArgsConstructor
@NoArgsConstructor
public class PetDto {
    private Long id;
    private String name;
    private String species;
    private Integer age;
    private String owner;
    private String description;
}
