package cu.edu.cujae.pweb.service;

import cu.edu.cujae.pweb.dto.UserDto;

import java.util.List;

public interface UsuarioService {
    List<UserDto> getUsers();
    UserDto getUserById(String userId);
    void createUser(UserDto user);
    void updateUser(UserDto user);
    void deleteUser(String id);
}
