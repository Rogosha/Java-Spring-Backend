package hello.Repositories;

import hello.Models.Amenities;
import hello.Models.AmenitiesTickets;
import hello.Models.CabinTypes;
import hello.Models.Tickets;
import org.springframework.data.repository.CrudRepository;

import java.util.Optional;

public interface AmenitiesTicketsRepository extends CrudRepository<AmenitiesTickets, Integer> {
    Iterable<AmenitiesTickets> findByTickets (Tickets tickets);
    Optional<AmenitiesTickets> findByTicketsAndAmenities (Tickets tickets, Amenities amenities);
}
