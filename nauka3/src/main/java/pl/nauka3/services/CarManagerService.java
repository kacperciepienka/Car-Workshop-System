package pl.nauka3.services;

import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;
import pl.nauka3.models.Car;
import pl.nauka3.repositories.CarRepository;

import java.util.List;

@Service
@RequiredArgsConstructor
public class CarManagerService {
    private final CarRepository carRepository;

    public Car addCar(Car car){
        return carRepository.save(car);
    }

    public void deleteCar(Long carId){
        Car car = carRepository.findById(carId)
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Sorry, but there isn't any Car with id: " + carId));

        carRepository.delete(car);
    }

    public Car changeRegNumber(Long carId, String newRegNumber){
        Car car = carRepository.findById(carId)
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Sorry, but there isn't any Car with id: " + carId));

        if (carRepository.existsByRegNumberEqualsIgnoreCase(newRegNumber)){
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "Sorry, but we already have a Car with register number: " + newRegNumber);
        }

        car.setRegNumber(newRegNumber);
        return carRepository.save(car);
    }

    public Car findByRegNumberEqualsIgnoreCase(String regNumber){
        return carRepository.findByRegNumberEqualsIgnoreCase(regNumber);
    }

    public List<Car> findAll(){
        return carRepository.findAll();
    }

    public List<Car> findAllByBrandEqualsIgnoreCase(String brand){
        return carRepository.findAllByBrandEqualsIgnoreCase(brand);
    }

    public List<Car> findAllByCarModelEqualsIgnoreCase(String carModel){
        return carRepository.findAllByCarModelEqualsIgnoreCase(carModel);
    }

    public List<Car> findAllByBrandEqualsIgnoreCaseAndCarModelEqualsIgnoreCase(String brand, String carModel){
        return carRepository.findAllByBrandEqualsIgnoreCaseAndCarModelEqualsIgnoreCase(brand, carModel);
    }

    public List<Car> findAllByYearProductionIsGreaterThanEqual(Integer yearProductionIsGreaterThan){
        return carRepository.findAllByYearProductionIsGreaterThanEqual(yearProductionIsGreaterThan);
    }

    public List<Car> findAllByYearProductionIsLessThanEqual(Integer yearProductionIsLessThan){
        return carRepository.findAllByYearProductionIsLessThanEqual(yearProductionIsLessThan);
    }

    public List<Car> findAllByYearProductionBetween(Integer yearProductionAfter, Integer yearProductionBefore){
        return carRepository.findAllByYearProductionBetween(yearProductionAfter, yearProductionBefore);
    }

}
