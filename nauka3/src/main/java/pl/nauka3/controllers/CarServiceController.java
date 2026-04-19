package pl.nauka3.controllers;

import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import pl.nauka3.models.CarService;
import pl.nauka3.services.CarServiceService;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/carServices")
public class CarServiceController {
    public final CarServiceService carServiceService;

    @PostMapping("/add")
    public ResponseEntity<CarService> addCarService(@Valid @RequestBody CarService carService) {
        CarService carService1 = carServiceService.addCarService(carService);
        return ResponseEntity.status(201).body(carService1);
    }

    @DeleteMapping("/{carServiceId}/delete")
    public ResponseEntity<Void> delete(@PathVariable Long carServiceId) {
        carServiceService.deleteCarService(carServiceId);
        return ResponseEntity.noContent().build();
    }

    @PutMapping("/{carServiceId}/newPrice")
    public ResponseEntity<CarService> changeBasePrice(@PathVariable Long carServiceId, @RequestParam Double newBasePrice) {
        CarService carService = carServiceService.changeBasePrice(carServiceId, newBasePrice);
        return ResponseEntity.ok(carService);
    }

    @PutMapping("/{carServiceId}/newTime")
    public ResponseEntity<CarService> changeEstimatedTime(@PathVariable Long carServiceId, @RequestParam Integer newEstimatedTime) {
        CarService carService = carServiceService.changeEstimatedTime(carServiceId, newEstimatedTime);
        return ResponseEntity.ok(carService);
    }

    @GetMapping("/{carServiceId}")
    public ResponseEntity<CarService> findCarServiceById(@PathVariable Long carServiceId){
        CarService carService = carServiceService.findCarServiceById(carServiceId);
        return ResponseEntity.ok(carService);
    }

    @GetMapping
    public ResponseEntity<List<CarService>> findAllCarServices(){
        List<CarService> carServices = carServiceService.findAllCarServices();
        return ResponseEntity.ok(carServices);
    }

    @GetMapping("/byName")
    public ResponseEntity<List<CarService>> findAllByNameEqualsIgnoreCase(@RequestParam String name) {
        List<CarService> carServices = carServiceService.findAllByNameEqualsIgnoreCase(name);
        return ResponseEntity.ok(carServices);
    }

    @GetMapping("/byPriceGreater")
    public ResponseEntity<List<CarService>> findAllByBasePriceIsGreaterThanEqual(@RequestParam Double basePriceIsGreaterThan) {
        List<CarService> carServices = carServiceService.findAllByBasePriceIsGreaterThanEqual(basePriceIsGreaterThan);
        return ResponseEntity.ok(carServices);
    }

    @GetMapping("/byPriceLess")
    public ResponseEntity<List<CarService>> findAllByBasePriceIsLessThanEqual(@RequestParam Double basePriceIsLessThan) {
        List<CarService> carServices = carServiceService.findAllByBasePriceIsLessThanEqual(basePriceIsLessThan);
        return ResponseEntity.ok(carServices);
    }

    @GetMapping("/byPriceBetween")
    public ResponseEntity<List<CarService>> findAllByBasePriceIsBetween(@RequestParam Double basePriceAfter, @RequestParam Double basePriceBefore) {
        List<CarService> carServices = carServiceService.findAllByBasePriceIsBetween(basePriceAfter, basePriceBefore);
        return ResponseEntity.ok(carServices);
    }

    @GetMapping("/byTimeGreater")
    public ResponseEntity<List<CarService>> findAllByEstimatedTimeIsGreaterThanEqual(@RequestParam Integer estimatedTimeIsGreaterThan) {
        List<CarService> carServices = carServiceService.findAllByEstimatedTimeIsGreaterThanEqual(estimatedTimeIsGreaterThan);
        return ResponseEntity.ok(carServices);
    }

    @GetMapping("/byTimeLess")
    public ResponseEntity<List<CarService>> findAllByEstimatedTimeIsLessThanEqual(@RequestParam Integer estimatedTimeIsLessThan) {
        List<CarService> carServices = carServiceService.findAllByEstimatedTimeIsLessThanEqual(estimatedTimeIsLessThan);
        return ResponseEntity.ok(carServices);
    }

    @GetMapping("/byTimeBetween")
    public ResponseEntity<List<CarService>> findAllByEstimatedTimeIsBetween(@RequestParam Integer estimatedTimeAfter, @RequestParam Integer estimatedTimeBefore) {
        List<CarService> carServices = carServiceService.findAllByEstimatedTimeIsBetween(estimatedTimeAfter, estimatedTimeBefore);
        return ResponseEntity.ok(carServices);
    }
}
