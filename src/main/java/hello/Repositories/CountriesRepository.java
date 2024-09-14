package hello.Repositories;

import hello.Models.Countries;
import org.springframework.data.repository.CrudRepository;

public interface CountriesRepository extends CrudRepository<Countries, Integer> {
}
