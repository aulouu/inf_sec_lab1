package itmo.aulouu.inf.sec.lab1.entity;

import jakarta.persistence.*;
import lombok.*;

@Data
@Entity
@Builder(toBuilder = true)
@Getter
@Setter
@ToString
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "pets")
public class Pet {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(name = "name", nullable = false)
    private String name;
    @Column(name = "species", nullable = false)
    private String species;
    @Column(name = "age", nullable = false)
    private Integer age;
    @Column(name = "owner", nullable = false)
    private String owner;
    @Column(name = "description")
    private String description;
}
