package hello.Repositories;

import hello.Models.Countries;
import hello.Models.UsersBlocking;
import org.springframework.data.repository.CrudRepository;

public interface UsersBlockingRepository extends CrudRepository<UsersBlocking, Integer>{
}
