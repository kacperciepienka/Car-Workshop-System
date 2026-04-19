package pl.nauka3.models;

import jakarta.persistence.*;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.Data;

@Entity
@Table(name = "Cars")
@Data
public class Car {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotBlank(message = "Every car must have a brand")
    @Column(length = 40)
    private String brand;

    @NotBlank
    @Column(length = 50)
    private String carModel;

    @NotBlank(message = "Registration number is required to find a car owner")
    @Column(unique = true, length = 10)
    private String regNumber;

    @Min(value = 1990, message = "our service repairs cars manufactured since 1990")
    @NotNull
    private Integer yearProduction;
}
