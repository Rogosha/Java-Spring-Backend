package hello.Repositories;

import hello.Models.CabinTypes;
import hello.Models.Offices;
import org.springframework.data.repository.CrudRepository;

import java.util.Optional;

public interface CabinTypesRepository extends CrudRepository<CabinTypes, Integer> {
    Optional<CabinTypes> findByName (String name);
}
