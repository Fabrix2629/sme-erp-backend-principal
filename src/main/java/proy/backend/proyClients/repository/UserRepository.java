package proy.backend.proyClients.repository;
import org.springframework.data.repository.CrudRepository;
import proy.backend.proyClients.entity.EntityUsuarios.UserEntity;
import java.util.Optional;
public interface UserRepository extends CrudRepository<UserEntity, Integer> {

    Optional<UserEntity> findUserEntityByUsername(String username);
}
