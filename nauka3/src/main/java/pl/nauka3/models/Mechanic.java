package pl.nauka3.models;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import lombok.Data;

@Entity
@Table(name = "Mechanics")
@Data
public class Mechanic {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotBlank(message = "First name is required")
    @Column(length = 50)
    private String firstName;

    @NotBlank(message = "Last name is required")
    @Column(length = 50)
    private String lastName;

    @Enumerated(EnumType.STRING)
    private Specialization specialization;
}
