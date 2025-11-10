package itmo.aulouu.inf.sec.lab1.dto;

import lombok.Data;

@Data
public class PetDto {
    private Long id;
    private String name;
    private String species;
    private Integer age;
    private String owner;
    private String description;
}
