package hello.Repositories;

import hello.Models.Airports;
import hello.Models.Routes;
import hello.Models.Users;
import org.springframework.data.repository.CrudRepository;

import java.util.List;
import java.util.Optional;

public interface RoutesRepository extends CrudRepository<Routes, Integer> {
    Optional<Routes> findByDepartureAirportAndArrivalAirport(Airports departureAirport, Airports arrivalAirport);
    Iterable<Routes> findByDepartureAirport(Airports departureAirport);
    Iterable<Routes> findByArrivalAirport(Airports arrivalAirport);
}