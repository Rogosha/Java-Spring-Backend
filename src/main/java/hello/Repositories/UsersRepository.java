package hello.Repositories;

import hello.Models.Schedules;
import hello.Models.Users;
import org.springframework.data.repository.CrudRepository;

import java.time.LocalDate;
import java.util.Optional;

public interface UsersRepository extends CrudRepository<Users, Integer> {
    Optional<Users> findByEmail (String email);
}