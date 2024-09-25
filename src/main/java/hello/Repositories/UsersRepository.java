package hello.Repositories;

import hello.Models.Users;
import org.springframework.data.repository.CrudRepository;

public interface UsersRepository extends CrudRepository<Users, Integer> {
}