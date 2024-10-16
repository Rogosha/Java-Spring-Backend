package hello.Repositories;

import hello.Models.Amenities;
import org.springframework.data.repository.CrudRepository;

public interface AmenitiesRepository extends CrudRepository<Amenities, Integer> {
}
