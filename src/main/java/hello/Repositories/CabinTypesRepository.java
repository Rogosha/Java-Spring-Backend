package hello.Repositories;

import hello.Models.CabinTypes;
import org.springframework.data.repository.CrudRepository;

public interface CabinTypesRepository extends CrudRepository<CabinTypes, Integer> {
}
