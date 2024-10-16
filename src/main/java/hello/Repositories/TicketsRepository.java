package hello.Repositories;

import hello.Models.AmenitiesTickets;
import hello.Models.Tickets;
import org.springframework.data.repository.CrudRepository;

public interface TicketsRepository extends CrudRepository<Tickets, Integer> {
    Iterable<Tickets> findByBookingReference (String bookingReference);
}
