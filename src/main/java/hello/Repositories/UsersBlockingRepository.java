package hello.Repositories;

import hello.Models.Schedules;
import hello.Models.Users;
import hello.Models.UsersBlocking;
import org.springframework.data.repository.CrudRepository;

import java.time.LocalDate;
import java.util.Optional;

public interface UsersBlockingRepository extends CrudRepository<UsersBlocking, Integer> {
    Optional<UsersBlocking> findByUser (Users user);
}