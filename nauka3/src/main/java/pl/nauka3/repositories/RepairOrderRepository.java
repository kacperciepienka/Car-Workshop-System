package pl.nauka3.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import pl.nauka3.models.RepairOrder;
import pl.nauka3.models.Specialization;
import pl.nauka3.models.Status;

import java.util.List;

public interface RepairOrderRepository extends JpaRepository<RepairOrder, Long> {
    List<RepairOrder> findAllByCarService_NameEqualsIgnoreCase(String name);

    List<RepairOrder> findAllByCarService_BasePriceIsBetween(Double priceAfter, Double priceBefore);

    List<RepairOrder> findAllByCarService_BasePriceIsGreaterThanEqual(Double price);

    List<RepairOrder> findAllByCarService_BasePriceIsLessThanEqual(Double price);

    List<RepairOrder> findAllByCarService_EstimatedTimeIsBetween(Integer timeAfter, Integer timeBefore);

    List<RepairOrder> findAllByCarService_EstimatedTimeIsGreaterThanEqual(Integer time);

    List<RepairOrder> findAllByCarService_EstimatedTimeIsLessThanEqual(Integer time);
    
    List<RepairOrder> findAllByTotalCostIsGreaterThanEqual(Double totalCostIsGreaterThan);

    List<RepairOrder> findAllByTotalCostIsLessThanEqual(Double totalCostIsLessThan);

    List<RepairOrder> findAllByTotalCostIsBetween(Double totalCostAfter, Double totalCostBefore);

    List<RepairOrder> findAllByCar_BrandEqualsIgnoreCase(String brand);

    List<RepairOrder> findAllByCar_BrandEqualsIgnoreCaseAndCar_CarModelEqualsIgnoreCase(String carBrand, String carCarModel);

    RepairOrder findByCar_RegNumberEqualsIgnoreCase(String regNumber);

    List<RepairOrder> findAllByCar_CarModelEqualsIgnoreCase(String carCarModel);

    List<RepairOrder> findAllByStatus(Status status);

    List<RepairOrder> findAllByMechanic_FirstNameEqualsIgnoreCase(String mechanicFirstName);

    List<RepairOrder> findAllByMechanic_LastNameEqualsIgnoreCase(String mechanicLastName);

    List<RepairOrder> findAllByMechanic_Specialization(Specialization mechanicSpecialization);
}
