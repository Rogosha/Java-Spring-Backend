package hello.Repositories;

import hello.Models.Users;
import hello.Models.UsersLogs;
import org.springframework.data.repository.CrudRepository;

import java.util.Optional;

public interface UsersLogsRepository extends CrudRepository<UsersLogs, Integer> {
    Iterable<UsersLogs> findByUser (Users user);
}