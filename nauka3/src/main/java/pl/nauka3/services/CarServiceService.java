package pl.nauka3.services;

import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;
import pl.nauka3.models.CarService;
import pl.nauka3.repositories.CarServiceRepository;

import java.util.List;

@Service
@RequiredArgsConstructor
public class CarServiceService {
    private final CarServiceRepository carServiceRepository;

    public CarService addCarService(CarService carService){
        return carServiceRepository.save(carService);
    }

    public void deleteCarService(Long carServiceId){
        CarService carService = carServiceRepository.findById(carServiceId)
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Sorry, but there isn't any Car Service with id: " + carServiceId));

        carServiceRepository.delete(carService);
    }

    public CarService changeBasePrice(Long carServiceId, Double newBasePrice){
        CarService carService = carServiceRepository.findById(carServiceId)
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Sorry, but there isn't any Car Service with id: " + carServiceId));

        if (newBasePrice == null || newBasePrice < 1.00){
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "new price is too low (min. 1.00$)");
        }

        carService.setBasePrice(newBasePrice);
        return carServiceRepository.save(carService);
    }

    public CarService changeEstimatedTime(Long carServiceId, Integer newEstimatedTime){
        CarService carService = carServiceRepository.findById(carServiceId)
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Sorry, but there isn't any Car Service with id: " + carServiceId));

        if (newEstimatedTime == null || newEstimatedTime < 5){
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "New estimated is too short (min. 5 minutes)");
        }

        carService.setEstimatedTime(newEstimatedTime);
        return carServiceRepository.save(carService);
    }

    public CarService findCarServiceById(Long carServiceId){
        return carServiceRepository.findById(carServiceId)
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Sorry, but there isn't any Car Service with id: " + carServiceId));
    }

    public List<CarService> findAllCarServices(){
        return carServiceRepository.findAll();
    }

    public List<CarService> findAllByNameEqualsIgnoreCase(String name){
        return carServiceRepository.findAllByNameEqualsIgnoreCase(name);
    }

    public List<CarService> findAllByBasePriceIsGreaterThanEqual(Double basePriceIsGreaterThan){
        return carServiceRepository.findAllByBasePriceIsGreaterThanEqual(basePriceIsGreaterThan);
    }

    public List<CarService> findAllByBasePriceIsLessThanEqual(Double basePriceIsLessThan){
        return carServiceRepository.findAllByBasePriceIsLessThanEqual(basePriceIsLessThan);
    }

    public List<CarService> findAllByBasePriceIsBetween(Double basePriceAfter, Double basePriceBefore){
        return carServiceRepository.findAllByBasePriceIsBetween(basePriceAfter, basePriceBefore);
    }

    public List<CarService> findAllByEstimatedTimeIsGreaterThanEqual(Integer estimatedTimeIsGreaterThan){
        return carServiceRepository.findAllByEstimatedTimeIsGreaterThanEqual(estimatedTimeIsGreaterThan);
    }

    public List<CarService> findAllByEstimatedTimeIsLessThanEqual(Integer estimatedTimeIsLessThan){
        return carServiceRepository.findAllByEstimatedTimeIsLessThanEqual(estimatedTimeIsLessThan);
    }

    public List<CarService> findAllByEstimatedTimeIsBetween(Integer estimatedTimeAfter, Integer estimatedTimeBefore){
        return carServiceRepository.findAllByEstimatedTimeIsBetween(estimatedTimeAfter, estimatedTimeBefore);
    }
}
