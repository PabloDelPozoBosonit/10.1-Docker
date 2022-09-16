package FormacionBackend0.Docker.user.application;

import FormacionBackend0.Docker.user.domain.User;
import FormacionBackend0.Docker.user.infraestructure.dtos.UserInputDTO;
import FormacionBackend0.Docker.user.infraestructure.dtos.UserOutputDTO;

import java.util.List;

public interface UserService {

    UserOutputDTO createUser(UserInputDTO userInputDTO) throws Exception;
    UserOutputDTO updateUser(UserInputDTO userInputDTO, Integer id) throws Exception;
    UserOutputDTO getUser(Integer id, String tipo) throws Exception;
    void deleteUser(Integer id);

    List<User> findByName(String name);

    List<User> findAll();

}
