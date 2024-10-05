package hello.Repositories;

import hello.Models.Tickets;
import org.springframework.data.repository.CrudRepository;

public interface TicketsRepository extends CrudRepository<Tickets, Integer> {
}
