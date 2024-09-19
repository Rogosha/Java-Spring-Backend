package hello.Repositories;

import hello.Models.Airports;
import org.springframework.data.repository.CrudRepository;

public interface AirportsRepository  extends CrudRepository<Airports, Integer> {
}
