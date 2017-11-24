package arkhipov.traffic.repositories;

import arkhipov.traffic.models.User;
import org.springframework.data.repository.CrudRepository;

public interface UserRepository extends CrudRepository<User, Integer> {
}
