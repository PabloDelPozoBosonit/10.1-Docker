package FormacionBackend0.Docker.user.infraestructure.controllers;

import FormacionBackend0.Docker.user.application.UserService;
import FormacionBackend0.Docker.user.domain.User;
import FormacionBackend0.Docker.user.infraestructure.dtos.UserInputDTO;
import FormacionBackend0.Docker.user.infraestructure.dtos.UserOutputDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.RestTemplate;

import java.util.List;


@RequestMapping(value = "user")
@RestController
public class ControllerUser {

    @Autowired
    private UserService usuarioService;


    /*
     *
     * Al ser Post, no es necesario indicarle el valor
     * Recibimos un JSON UserinputDTO
     * Se lo mandamos a la capa de servicio
     * */
    @PostMapping
    public UserOutputDTO insertUser(@RequestBody UserInputDTO userInputDTO) throws Exception {

        return usuarioService.createUser(userInputDTO);
    }


    //Recibimos el id y se lo pasamos a la capa bde servicio
    @GetMapping(value = "/obtener/{id}/{tipo}")
    public UserOutputDTO getUser(@PathVariable Integer id, @PathVariable String tipo) throws Exception {

        return usuarioService.getUser(id, tipo);
    }

    //Recibimos los datos a actualizar y el id y se lo pasamos a la capa bde servicio
    @PutMapping(value = "/actualizar/{id}")
    public UserOutputDTO updateUser(@RequestBody UserInputDTO userInputDTO, @PathVariable Integer id) throws Exception {

        return usuarioService.updateUser(userInputDTO, id);

    }


    @DeleteMapping(value = "/eliminar/{id}")
    public void deleteUser(@PathVariable Integer id) {
        usuarioService.deleteUser(id);
    }


    @GetMapping(value = "/findByName/{name}")
    public List<User> findByName(@PathVariable String name) {
        return usuarioService.findByName(name);
    }


    @GetMapping(value = "/findAll")
    public List<User> findAll() {
        return usuarioService.findAll();
    }


}

