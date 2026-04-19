package pl.nauka3.controllers;

import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import pl.nauka3.models.Mechanic;
import pl.nauka3.models.Specialization;
import pl.nauka3.services.MechanicService;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/mechanics")
public class MechanicController {
    public final MechanicService mechanicService;

    @PostMapping("/add")
    public ResponseEntity<Mechanic> addMechanic(@Valid @RequestBody Mechanic mechanic){
        Mechanic mechanic1 = mechanicService.addMechanic(mechanic);
        return ResponseEntity.status(201).body(mechanic1);
    }

    @DeleteMapping("/{mechanicId}/delete")
    public ResponseEntity<Void> deleteMechanic(@PathVariable Long mechanicId){
        mechanicService.deleteMechanic(mechanicId);
        return ResponseEntity.noContent().build();
    }

    @PutMapping("/{mechanicId}/newLastName")
    public ResponseEntity<Mechanic> changeLastName(@PathVariable Long mechanicId, @RequestParam String newLastName){
        Mechanic mechanic = mechanicService.changeLastName(mechanicId, newLastName);
        return ResponseEntity.ok(mechanic);
    }

    @PutMapping("/{mechanicId}/newSpec")
    public ResponseEntity<Mechanic> changeSpecialization(@PathVariable Long mechanicId, @RequestParam Specialization specialization){
        Mechanic mechanic = mechanicService.changeSpecialization(mechanicId, specialization);
        return ResponseEntity.ok(mechanic);
    }


    @GetMapping("/{mechanicId}")
    public ResponseEntity<Mechanic> findMechanicById(@PathVariable Long mechanicId){
        Mechanic mechanic = mechanicService.findMechanicById(mechanicId);
        return ResponseEntity.ok(mechanic);
    }

    @GetMapping
    public ResponseEntity<List<Mechanic>> findAllMechanics(){
        List<Mechanic> mechanics = mechanicService.findAllMechanics();
        return ResponseEntity.ok(mechanics);
    }

    @GetMapping("/byFirstName")
    public ResponseEntity<List<Mechanic>> findAllByFirstNameEqualsIgnoreCase(@RequestParam String firstName){
        List<Mechanic> mechanics = mechanicService.findAllByFirstNameEqualsIgnoreCase(firstName);
        return ResponseEntity.ok(mechanics);
    }

    @GetMapping("/byLastName")
    public ResponseEntity<List<Mechanic>> findAllByLastNameEqualsIgnoreCase(@RequestParam String lastName){
        List<Mechanic> mechanics = mechanicService.findAllByLastNameEqualsIgnoreCase(lastName);
        return ResponseEntity.ok(mechanics);
    }

    @GetMapping("/byFullName")
    public ResponseEntity<List<Mechanic>> findAllByFirstNameEqualsIgnoreCaseAndLastNameEqualsIgnoreCase(@RequestParam String firstName, @RequestParam String lastName){
        List<Mechanic> mechanics = mechanicService.findAllByFirstNameEqualsIgnoreCaseAndLastNameEqualsIgnoreCase(firstName, lastName);
        return ResponseEntity.ok(mechanics);
    }

    @GetMapping("/bySpec")
    public ResponseEntity<List<Mechanic>> findAllBySpecialization(@RequestParam Specialization specialization){
        List<Mechanic> mechanics = mechanicService.findAllBySpecialization(specialization);
        return ResponseEntity.ok(mechanics);
    }
}
