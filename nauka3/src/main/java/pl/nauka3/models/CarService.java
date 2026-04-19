package pl.nauka3.models;

import jakarta.persistence.*;
import jakarta.validation.constraints.DecimalMin;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.Data;

@Entity
@Table(name = "CarServices")
@Data
public class CarService {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotBlank
    @Column(length = 80)
    private String name;

    @DecimalMin(value = "1.00", message = "Price for any service can't be lesser than 1.00$")
    @NotNull(message = "Every service must have price to avoid inaccuracies")
    private Double basePrice;

    @Min(value = 5, message = "Every service takes at least 5 minutes")
    @NotNull(message = "This is only an estimated time, our client needs to know how long it can take")
    private Integer estimatedTime;
}
