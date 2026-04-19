package pl.nauka3.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import pl.nauka3.models.Car;

import java.util.List;
import java.util.Optional;

public interface CarRepository extends JpaRepository<Car, Long>  {
    Car findByRegNumberEqualsIgnoreCase(String regNumber);

    Boolean existsByRegNumberEqualsIgnoreCase(String regNumber);

    Optional<Car> findByRegNumberEqualsIgnoreCaseOptional(String regNumber);

    List<Car> findAllByBrandEqualsIgnoreCase(String brand);

    List<Car> findAllByBrandEqualsIgnoreCaseAndCarModelEqualsIgnoreCase(String brand, String carModel);

    List<Car> findAllByCarModelEqualsIgnoreCase(String carModel);

    List<Car> findAllByYearProductionIsGreaterThanEqual(Integer yearProductionIsGreaterThan);

    List<Car> findAllByYearProductionIsLessThanEqual(Integer yearProductionIsLessThan);

    List<Car> findAllByYearProductionBetween(Integer yearProductionAfter, Integer yearProductionBefore);
}
