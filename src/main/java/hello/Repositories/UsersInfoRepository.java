package hello.Repositories;

import hello.Models.UsersInfo;
import org.springframework.data.repository.CrudRepository;

public interface UsersInfoRepository extends CrudRepository<UsersInfo, Integer> {
}
