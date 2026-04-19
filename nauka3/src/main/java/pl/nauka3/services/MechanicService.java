package pl.nauka3.services;

import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;
import pl.nauka3.models.Mechanic;
import pl.nauka3.models.Specialization;
import pl.nauka3.repositories.MechanicRepository;

import java.util.List;

@Service
@RequiredArgsConstructor
public class MechanicService {
    private final MechanicRepository mechanicRepository;

    public Mechanic addMechanic(Mechanic mechanic){
        return mechanicRepository.save(mechanic);
    }

    public void deleteMechanic(Long mechanicId){
        Mechanic mechanic = mechanicRepository.findById(mechanicId)
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Sorry, but there isn't any Mechanic with id: " + mechanicId));

        mechanicRepository.delete(mechanic);
    }

    public Mechanic changeLastName(Long mechanicId, String newLastName){
        if (newLastName == null){
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "New name can't be empty!");
        }

        Mechanic mechanic = mechanicRepository.findById(mechanicId)
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Sorry, but there isn't any Mechanic with id: " + mechanicId));

        mechanic.setLastName(newLastName);
        return mechanicRepository.save(mechanic);
    }

    public Mechanic changeSpecialization(Long mechanicId, Specialization specialization){
        Mechanic mechanic = mechanicRepository.findById(mechanicId)
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Sorry, but there isn't any Mechanic with id: " + mechanicId));

        mechanic.setSpecialization(specialization);
        return mechanicRepository.save(mechanic);
    }

    public Mechanic findMechanicById(Long mechanicId){
        return mechanicRepository.findById(mechanicId)
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Sorry, but there isn't any Mechanic with id: " + mechanicId));
    }

    public List<Mechanic> findAllMechanics(){
        return mechanicRepository.findAll();
    }

    public List<Mechanic> findAllByFirstNameEqualsIgnoreCase(String firstName){
        return mechanicRepository.findAllByFirstNameEqualsIgnoreCase(firstName);
    }

    public List<Mechanic> findAllByLastNameEqualsIgnoreCase(String lastName){
        return mechanicRepository.findAllByLastNameEqualsIgnoreCase(lastName);
    }

    public List<Mechanic> findAllByFirstNameEqualsIgnoreCaseAndLastNameEqualsIgnoreCase(String firstName, String lastName){
        return mechanicRepository.findAllByFirstNameEqualsIgnoreCaseAndLastNameEqualsIgnoreCase(firstName, lastName);
    }

    public List<Mechanic> findAllBySpecialization(Specialization specialization){
        return mechanicRepository.findAllBySpecialization(specialization);
    }

}
