package FormacionBackend0.Docker.user.infraestructure.repository;

import FormacionBackend0.Docker.user.domain.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;


public interface UserRepository extends JpaRepository<User, Integer> {

    List<User> findByName(String name);

}
