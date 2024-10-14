package hello.Repositories;

import hello.Models.Routes;
import hello.Models.Schedules;
import org.springframework.data.repository.CrudRepository;

import java.time.LocalDate;
import java.util.Optional;

public interface SchedulesRepository extends CrudRepository<Schedules, Integer> {
    Optional<Schedules> findByFlightNumberAndDate (String flightNumber, LocalDate date);
    Iterable<Schedules> findByRouteAndDate(Routes routes, LocalDate date);
    Iterable<Schedules> findByRoute(Routes routes);
    Iterable<Schedules> findByDate(LocalDate date);

}