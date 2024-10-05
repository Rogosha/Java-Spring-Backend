package hello.Repositories;

import hello.Models.Airports;
import org.springframework.data.repository.CrudRepository;

import java.util.List;
import java.util.Optional;

public interface AirportsRepository extends CrudRepository<Airports, Integer> {
    Optional<Airports> findByIATACode (String IATACode);
}
