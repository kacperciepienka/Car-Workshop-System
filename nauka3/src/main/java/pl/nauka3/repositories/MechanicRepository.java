package pl.nauka3.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import pl.nauka3.models.Mechanic;
import pl.nauka3.models.Specialization;

import java.util.List;

public interface MechanicRepository extends JpaRepository<Mechanic, Long>  {

    List<Mechanic> findAllByFirstNameEqualsIgnoreCase(String firstName);

    List<Mechanic> findAllByLastNameEqualsIgnoreCase(String lastName);

    List<Mechanic> findAllByFirstNameEqualsIgnoreCaseAndLastNameEqualsIgnoreCase(String firstName, String lastName);

    List<Mechanic> findAllBySpecialization(Specialization specialization);
}
