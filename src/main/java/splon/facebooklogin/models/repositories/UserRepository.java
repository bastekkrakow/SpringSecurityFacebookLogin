package splon.facebooklogin.models.repositories;

import splon.facebooklogin.models.UserModel;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends CrudRepository<UserModel, Integer> {
    UserModel findByLogin(String login);
}
