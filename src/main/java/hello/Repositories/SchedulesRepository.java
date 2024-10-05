package hello.Repositories;

import hello.Models.Airports;
import hello.Models.Routes;
import hello.Models.Schedules;
import hello.Models.SchedulesDTO;
import org.springframework.data.repository.CrudRepository;

import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.util.Optional;

public interface SchedulesRepository extends CrudRepository<Schedules, Integer> {
    Optional<Schedules> findByFlightNumberAndDate (String flightNumber, LocalDate date);
    Iterable<Schedules> findByRouteAndDate(Routes routes, LocalDate date);
    Iterable<Schedules> findByRoute(Routes routes);
}