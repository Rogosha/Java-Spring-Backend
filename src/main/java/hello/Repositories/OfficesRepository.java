package hello.Repositories;

import hello.Models.Offices;
import org.springframework.data.repository.CrudRepository;

public interface OfficesRepository extends CrudRepository<Offices, Integer> {
}