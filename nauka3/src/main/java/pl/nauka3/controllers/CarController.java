package pl.nauka3.controllers;

import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import pl.nauka3.models.Car;
import pl.nauka3.services.CarManagerService;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/cars")
public class CarController {
    private final CarManagerService carManagerService;

    @PostMapping("/add")
    public ResponseEntity<Car> addCar(@Valid @RequestBody Car car) {
        Car car1 = carManagerService.addCar(car);
        return ResponseEntity.status(201).body(car1);
    }

    @DeleteMapping("/{carId}/delete")
    public ResponseEntity<Void> deleteCar(@PathVariable Long carId) {
        carManagerService.deleteCar(carId);
        return ResponseEntity.noContent().build();
    }

    @PutMapping("/{carId}/newRegNumber")
    public ResponseEntity<Car> changeRegNumber(@PathVariable Long carId, @RequestParam String newRegNumber) {
        Car car = carManagerService.changeRegNumber(carId, newRegNumber);
        return ResponseEntity.ok(car);
    }


    @GetMapping
    public ResponseEntity<List<Car>> findAllCars() {
        List<Car> cars = carManagerService.findAll();
        return ResponseEntity.ok(cars);
    }

    @GetMapping("/byBrand")
    public ResponseEntity<List<Car>> findAllByBrandEqualsIgnoreCase(@RequestParam String brand) {
        List<Car> cars = carManagerService.findAllByBrandEqualsIgnoreCase(brand);
        return ResponseEntity.ok(cars);
    }

    @GetMapping("/byModel")
    public ResponseEntity<List<Car>> findAllByCarModelEqualsIgnoreCase(@RequestParam String carModel) {
        List<Car> cars = carManagerService.findAllByCarModelEqualsIgnoreCase(carModel);
        return ResponseEntity.ok(cars);
    }

    @GetMapping("/byBrandAndModel")
    public ResponseEntity<List<Car>> findAllByBrandEqualsIgnoreCaseAndCarModelEqualsIgnoreCase(@RequestParam String brand, @RequestParam String carModel) {
        List<Car> cars = carManagerService.findAllByBrandEqualsIgnoreCaseAndCarModelEqualsIgnoreCase(brand, carModel);
        return ResponseEntity.ok(cars);
    }

    @GetMapping("/byYearGreater")
    public ResponseEntity<List<Car>> findAllByYearProductionIsGreaterThanEqual(@RequestParam Integer yearProductionIsGreaterThan) {
        List<Car> cars = carManagerService.findAllByYearProductionIsGreaterThanEqual(yearProductionIsGreaterThan);
        return ResponseEntity.ok(cars);
    }

    @GetMapping("/byYearLess")
    public ResponseEntity<List<Car>> findAllByYearProductionIsLessThanEqual(@RequestParam Integer yearProductionIsLessThan) {
        List<Car> cars = carManagerService.findAllByYearProductionIsLessThanEqual(yearProductionIsLessThan);
        return ResponseEntity.ok(cars);
    }

    @GetMapping("/byYearBetween")
    public ResponseEntity<List<Car>> findAllByYearProductionBetween(@RequestParam Integer yearProductionAfter, @RequestParam Integer yearProductionBefore) {
        List<Car> cars = carManagerService.findAllByYearProductionBetween(yearProductionAfter, yearProductionBefore);
        return ResponseEntity.ok(cars);
    }

    @GetMapping("/byRegNumber")
    public ResponseEntity<Car> findByRegNumberEqualsIgnoreCase(@RequestParam String regNumber) {
        Car car = carManagerService.findByRegNumberEqualsIgnoreCase(regNumber);
        return ResponseEntity.ok(car);
    }
}
