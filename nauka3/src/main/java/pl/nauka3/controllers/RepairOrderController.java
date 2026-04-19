package pl.nauka3.controllers;

import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import pl.nauka3.models.RepairOrder;
import pl.nauka3.models.Specialization;
import pl.nauka3.models.Status;
import pl.nauka3.services.RepairOrderService;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/repairOrders")
public class RepairOrderController {
    private final RepairOrderService repairOrderService;

    @PostMapping("/add/{carServiceId}/{mechanicId}/{regNumber}")
    public ResponseEntity<RepairOrder> addRepairOrder
            (@Valid @RequestBody RepairOrder repairOrder, @PathVariable Long carServiceId, @PathVariable Long mechanicId, @PathVariable String regNumber) {

        RepairOrder repairOrder1 = repairOrderService.addRepairOrder(repairOrder, carServiceId, mechanicId, regNumber);
        return ResponseEntity.status(201).body(repairOrder1);
    }

    @PutMapping("/{repairOrderId}/newStatus")
    public ResponseEntity<RepairOrder> updateStatus(@PathVariable Long repairOrderId, @RequestParam Status status){
        RepairOrder repairOrder = repairOrderService.updateStatus(repairOrderId, status);
        return ResponseEntity.ok(repairOrder);
    }

    @PutMapping("/{repairOrderId}/newDescrip")
    public ResponseEntity<RepairOrder> updateDescription(@PathVariable Long repairOrderId, @RequestParam String newDescription){
        RepairOrder repairOrder = repairOrderService.updateDescription(repairOrderId, newDescription);
        return ResponseEntity.ok(repairOrder);
    }

    @GetMapping("/{regNumber}")
    public ResponseEntity<RepairOrder> findByCar_RegNumberEqualsIgnoreCase(@PathVariable String regNumber){
        RepairOrder repairOrder = repairOrderService.findByCar_RegNumberEqualsIgnoreCase(regNumber);
        return ResponseEntity.ok(repairOrder);
    }

    @GetMapping
    public ResponseEntity<List<RepairOrder>> findAllRepairOrders(){
        List<RepairOrder> repairOrders = repairOrderService.findAllRepairOrders();
        return ResponseEntity.ok(repairOrders);
    }

    @GetMapping("/byName")
    public ResponseEntity<List<RepairOrder>> findAllByCarService_NameEqualsIgnoreCase(@RequestParam String name){
        List<RepairOrder> repairOrders = repairOrderService.findAllByCarService_NameEqualsIgnoreCase(name);
        return ResponseEntity.ok(repairOrders);
    }

    @GetMapping("/basePrice/greater")
    public ResponseEntity<List<RepairOrder>> findAllByCarService_BasePriceIsGreaterThanEqual(@RequestParam Double price){
        List<RepairOrder> repairOrders = repairOrderService.findAllByCarService_BasePriceIsGreaterThanEqual(price);
        return ResponseEntity.ok(repairOrders);
    }

    @GetMapping("/basePrice/less")
    public ResponseEntity<List<RepairOrder>> findAllByCarService_BasePriceIsLessThanEqual(@RequestParam Double price){
        List<RepairOrder> repairOrders = repairOrderService.findAllByCarService_BasePriceIsLessThanEqual(price);
        return ResponseEntity.ok(repairOrders);
    }

    @GetMapping("/basePrice/between")
    public ResponseEntity<List<RepairOrder>> findAllByCarService_BasePriceIsBetween(@RequestParam Double priceAfter, @RequestParam Double priceBefore){
        List<RepairOrder> repairOrders = repairOrderService.findAllByCarService_BasePriceIsBetween(priceAfter, priceBefore);
        return ResponseEntity.ok(repairOrders);
    }

    @GetMapping("/time/greater")
    public ResponseEntity<List<RepairOrder>> findAllByCarService_EstimatedTimeIsGreaterThanEqual(@RequestParam Integer time){
        List<RepairOrder> repairOrders = repairOrderService.findAllByCarService_EstimatedTimeIsGreaterThanEqual(time);
        return ResponseEntity.ok(repairOrders);
    }

    @GetMapping("/time/less")
    public ResponseEntity<List<RepairOrder>> findAllByCarService_EstimatedTimeIsLessThanEqual(@RequestParam Integer time){
        List<RepairOrder> repairOrders = repairOrderService.findAllByCarService_EstimatedTimeIsLessThanEqual(time);
        return ResponseEntity.ok(repairOrders);
    }

    @GetMapping("/time/between")
    public ResponseEntity<List<RepairOrder>> findAllByCarService_EstimatedTimeIsBetween(@RequestParam Integer timeAfter, @RequestParam Integer timeBefore){
        List<RepairOrder> repairOrders = repairOrderService.findAllByCarService_EstimatedTimeIsBetween(timeAfter, timeBefore);
        return ResponseEntity.ok(repairOrders);
    }

    @GetMapping("/totalCost/greater")
    public ResponseEntity<List<RepairOrder>> findAllByTotalCostIsGreaterThanEqual(@RequestParam Double totalCostIsGreaterThan){
        List<RepairOrder> repairOrders = repairOrderService.findAllByTotalCostIsGreaterThanEqual(totalCostIsGreaterThan);
        return ResponseEntity.ok(repairOrders);
    }

    @GetMapping("/totalCost/less")
    public ResponseEntity<List<RepairOrder>> findAllByTotalCostIsLessThanEqual(@RequestParam Double totalCostIsLessThan){
        List<RepairOrder> repairOrders = repairOrderService.findAllByTotalCostIsLessThanEqual(totalCostIsLessThan);
        return ResponseEntity.ok(repairOrders);
    }

    @GetMapping("/totalCost/between")
    public ResponseEntity<List<RepairOrder>> findAllByTotalCostIsBetween(@RequestParam Double totalCostAfter, @RequestParam Double totalCostBefore){
        List<RepairOrder> repairOrders = repairOrderService.findAllByTotalCostIsBetween(totalCostAfter, totalCostBefore);
        return ResponseEntity.ok(repairOrders);
    }

    @GetMapping("/byCarBrand/{brand}")
    public ResponseEntity<List<RepairOrder>> findAllByCar_BrandEqualsIgnoreCase(@PathVariable String brand){
        List<RepairOrder> repairOrders = repairOrderService.findAllByCar_BrandEqualsIgnoreCase(brand);
        return ResponseEntity.ok(repairOrders);
    }

    @GetMapping("/byCarModel/{carCarModel}")
    public ResponseEntity<List<RepairOrder>> findAllByCar_CarModelEqualsIgnoreCase(@PathVariable String carCarModel){
        List<RepairOrder> repairOrders = repairOrderService.findAllByCar_CarModelEqualsIgnoreCase(carCarModel);
        return ResponseEntity.ok(repairOrders);
    }

    @GetMapping("/byCar/{carBrand}/{carCarModel}")
    public ResponseEntity<List<RepairOrder>> findAllByCar_BrandEqualsIgnoreCaseAndCar_CarModelEqualsIgnoreCase(@PathVariable String carBrand, @PathVariable String carCarModel){
        List<RepairOrder> repairOrders = repairOrderService.findAllByCar_BrandEqualsIgnoreCaseAndCar_CarModelEqualsIgnoreCase(carBrand, carCarModel);
        return ResponseEntity.ok(repairOrders);
    }

    @GetMapping("/byStatus")
    public ResponseEntity<List<RepairOrder>> findAllByStatus(@RequestParam Status status){
        List<RepairOrder> repairOrders = repairOrderService.findAllByStatus(status);
        return ResponseEntity.ok(repairOrders);
    }

    @GetMapping("/byMechanic/firstName")
    public ResponseEntity<List<RepairOrder>> findAllByMechanic_FirstNameEqualsIgnoreCase(@RequestParam String mechanicFirstName){
        List<RepairOrder> repairOrders = repairOrderService.findAllByMechanic_FirstNameEqualsIgnoreCase(mechanicFirstName);
        return ResponseEntity.ok(repairOrders);
    }

    @GetMapping("/byMechanic/lastName")
    public ResponseEntity<List<RepairOrder>> findAllByMechanic_LastNameEqualsIgnoreCase(@RequestParam String mechanicLastName){
        List<RepairOrder> repairOrders = repairOrderService.findAllByMechanic_LastNameEqualsIgnoreCase(mechanicLastName);
        return ResponseEntity.ok(repairOrders);
    }

    @GetMapping("/bySpecialization")
    public ResponseEntity<List<RepairOrder>> findAllByMechanic_Specialization(@RequestParam Specialization mechanicSpecialization){
        List<RepairOrder> repairOrders = repairOrderService.findAllByMechanic_Specialization(mechanicSpecialization);
        return ResponseEntity.ok(repairOrders);
    }
}
