package hello.Repositories;

import hello.Models.UsersLogs;
import org.springframework.data.repository.CrudRepository;

public interface UsersInfoRepository extends CrudRepository<UsersLogs, Integer> {
}