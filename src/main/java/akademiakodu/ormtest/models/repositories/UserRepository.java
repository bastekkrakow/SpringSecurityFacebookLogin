package akademiakodu.ormtest.models.repositories;

import akademiakodu.ormtest.models.UserModel;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends CrudRepository<UserModel, Integer> {



}
