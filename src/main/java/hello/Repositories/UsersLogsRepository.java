package hello.Repositories;

import hello.Models.UsersLogs;
import org.springframework.data.repository.CrudRepository;

public interface UsersLogsRepository extends CrudRepository<UsersLogs, Integer> {
}