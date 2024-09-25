package hello.Repositories;

import hello.Models.Aircrafts;
import org.springframework.data.repository.CrudRepository;

public interface AircraftsRepository extends CrudRepository<Aircrafts, Integer> {
}