package pl.nauka3.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import pl.nauka3.models.CarService;

import java.util.List;

public interface CarServiceRepository extends JpaRepository<CarService,Long> {

    List<CarService> findAllByNameEqualsIgnoreCase(String name);

    List<CarService> findAllByBasePriceIsGreaterThanEqual(Double basePriceIsGreaterThan);

    List<CarService> findAllByBasePriceIsLessThanEqual(Double basePriceIsLessThan);

    List<CarService> findAllByBasePriceIsBetween(Double basePriceAfter, Double basePriceBefore);

    List<CarService> findAllByEstimatedTimeIsGreaterThanEqual(Integer estimatedTimeIsGreaterThan);

    List<CarService> findAllByEstimatedTimeIsLessThanEqual(Integer estimatedTimeIsLessThan);

    List<CarService> findAllByEstimatedTimeIsBetween(Integer estimatedTimeAfter, Integer estimatedTimeBefore);
}
