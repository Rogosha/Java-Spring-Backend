package hello.Repositories;

import hello.Models.Schedules;
import org.springframework.data.repository.CrudRepository;

public interface SchedulesRepository extends CrudRepository<Schedules, Integer> {
}