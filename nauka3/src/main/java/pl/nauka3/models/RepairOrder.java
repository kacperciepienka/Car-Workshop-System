package pl.nauka3.models;

import jakarta.persistence.*;
import jakarta.validation.constraints.DecimalMin;
import jakarta.validation.constraints.NotNull;
import lombok.Data;
import org.hibernate.validator.constraints.Length;

@Entity
@Table(name = "Repair_Orders")
@Data
public class RepairOrder {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "car_service_id")
    private CarService carService;

    @DecimalMin(value = "1.00", message = "Price for any service can't be lesser than 1.00$")
    private Double totalCost;

    @ManyToOne
    @JoinColumn(name = "car_id")
    private Car car;

    @Length(max = 1000)
    private String description;

    @ManyToOne
    @JoinColumn(name = "mechanic_id")
    private Mechanic mechanic;

    @Enumerated(EnumType.STRING)
    private Status status;
}
