package pl.nauka3.services;

import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;
import pl.nauka3.models.*;
import pl.nauka3.models.CarService;
import pl.nauka3.repositories.CarRepository;
import pl.nauka3.repositories.CarServiceRepository;
import pl.nauka3.repositories.MechanicRepository;
import pl.nauka3.repositories.RepairOrderRepository;

import java.util.List;

@Service
@RequiredArgsConstructor
public class RepairOrderService {
    private final RepairOrderRepository repairOrderRepository;
    private final CarServiceRepository carServiceRepository;
    private final MechanicRepository mechanicRepository;
    private final CarRepository carRepository;

    public RepairOrder addRepairOrder(RepairOrder repairOrder, Long carServiceId, Long mechanicId, String regNumber) {
        Car car = carRepository.findByRegNumberEqualsIgnoreCaseOptional(regNumber)
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND,
                        "Sorry, but there isn't any Car with registration number: " + regNumber + "First you must add this car to the system"));

        CarService carService = carServiceRepository.findById(carServiceId)
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND,
                        "Sorry, but there isn't any Car Service with id: " + carServiceId + "First you must add this new service to the system"));

        Mechanic mechanic = mechanicRepository.findById(mechanicId)
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Sorry, but there isn't any Mechanic with id: " + mechanicId));

        double totalCost;
        switch (mechanic.getSpecialization()) {
            case ENGINE -> totalCost = carService.getBasePrice() + 100.0;
            case SUSPENSION -> totalCost = carService.getBasePrice() + 50.00;
            default -> totalCost = carService.getBasePrice();
        }

        repairOrder.setCar(car);
        repairOrder.setCarService(carService);
        repairOrder.setMechanic(mechanic);
        repairOrder.setTotalCost(totalCost);
        repairOrder.setStatus(Status.OPEN);

        return repairOrderRepository.save(repairOrder);
    }

    public RepairOrder updateStatus(Long repairOrderId, Status status) {
        RepairOrder repairOrder = repairOrderRepository.findById(repairOrderId)
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Sorry, but there isn't any Repair Order with id: " + repairOrderId));

        if (repairOrder.getStatus() == Status.COMPLETED) {
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "You can't edit a repair order with a status of COMPLETED");
        }

        repairOrder.setStatus(status);
        return repairOrderRepository.save(repairOrder);
    }

    public RepairOrder updateDescription(Long repairOrderId, String newDescription) {
        RepairOrder repairOrder = repairOrderRepository.findById(repairOrderId)
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Sorry, but there isn't any Repair Order with id: " + repairOrderId));

        if (newDescription.length() > 1000) {
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "This description is too long (max. 1000 characters)");
        }

        repairOrder.setDescription(newDescription);
        return repairOrderRepository.save(repairOrder);
    }

    public RepairOrder findByCar_RegNumberEqualsIgnoreCase(String regNumber) {
        return repairOrderRepository.findByCar_RegNumberEqualsIgnoreCase(regNumber);
    }

    public List<RepairOrder> findAllRepairOrders() {
        return repairOrderRepository.findAll();
    }

    public List<RepairOrder> findAllByCarService_NameEqualsIgnoreCase(String name) {
        return repairOrderRepository.findAllByCarService_NameEqualsIgnoreCase(name);
    }

    public List<RepairOrder> findAllByCarService_BasePriceIsGreaterThanEqual(Double price) {
        return repairOrderRepository.findAllByCarService_BasePriceIsGreaterThanEqual(price);
    }

    public List<RepairOrder> findAllByCarService_BasePriceIsLessThanEqual(Double price) {
        return repairOrderRepository.findAllByCarService_BasePriceIsLessThanEqual(price);
    }

    public List<RepairOrder> findAllByCarService_BasePriceIsBetween(Double priceAfter, Double priceBefore) {
        return repairOrderRepository.findAllByCarService_BasePriceIsBetween(priceAfter, priceBefore);
    }

    public List<RepairOrder> findAllByCarService_EstimatedTimeIsGreaterThanEqual(Integer time) {
        return repairOrderRepository.findAllByCarService_EstimatedTimeIsGreaterThanEqual(time);
    }

    public List<RepairOrder> findAllByCarService_EstimatedTimeIsLessThanEqual(Integer time) {
        return repairOrderRepository.findAllByCarService_EstimatedTimeIsLessThanEqual(time);
    }

    public List<RepairOrder> findAllByCarService_EstimatedTimeIsBetween(Integer timeAfter, Integer timeBefore) {
        return repairOrderRepository.findAllByCarService_EstimatedTimeIsBetween(timeAfter, timeBefore);
    }

    public List<RepairOrder> findAllByTotalCostIsGreaterThanEqual(Double totalCostIsGreaterThan) {
        return repairOrderRepository.findAllByTotalCostIsGreaterThanEqual(totalCostIsGreaterThan);
    }

    public List<RepairOrder> findAllByTotalCostIsLessThanEqual(Double totalCostIsLessThan) {
        return repairOrderRepository.findAllByTotalCostIsLessThanEqual(totalCostIsLessThan);
    }

    public List<RepairOrder> findAllByTotalCostIsBetween(Double totalCostAfter, Double totalCostBefore) {
        return repairOrderRepository.findAllByTotalCostIsBetween(totalCostAfter, totalCostBefore);
    }

    public List<RepairOrder> findAllByCar_BrandEqualsIgnoreCase(String brand) {
        return repairOrderRepository.findAllByCar_BrandEqualsIgnoreCase(brand);
    }

    public List<RepairOrder> findAllByCar_BrandEqualsIgnoreCaseAndCar_CarModelEqualsIgnoreCase(String carBrand, String carCarModel) {
        return repairOrderRepository.findAllByCar_BrandEqualsIgnoreCaseAndCar_CarModelEqualsIgnoreCase(carBrand, carCarModel);
    }

    public List<RepairOrder> findAllByCar_CarModelEqualsIgnoreCase(String carCarModel) {
        return repairOrderRepository.findAllByCar_CarModelEqualsIgnoreCase(carCarModel);
    }

    public List<RepairOrder> findAllByStatus(Status status) {
        return repairOrderRepository.findAllByStatus(status);
    }

    public List<RepairOrder> findAllByMechanic_FirstNameEqualsIgnoreCase(String mechanicFirstName) {
        return repairOrderRepository.findAllByMechanic_FirstNameEqualsIgnoreCase(mechanicFirstName);
    }

    public List<RepairOrder> findAllByMechanic_LastNameEqualsIgnoreCase(String mechanicLastName) {
        return repairOrderRepository.findAllByMechanic_LastNameEqualsIgnoreCase(mechanicLastName);
    }

    public List<RepairOrder> findAllByMechanic_Specialization(Specialization mechanicSpecialization) {
        return repairOrderRepository.findAllByMechanic_Specialization(mechanicSpecialization);
    }
}
