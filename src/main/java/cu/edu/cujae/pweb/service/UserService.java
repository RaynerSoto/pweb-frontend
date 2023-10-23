package cu.edu.cujae.pweb.service;

import java.util.ArrayList;

import cu.edu.cujae.pweb.dto.UserDto;

public interface UserService {
	public boolean insertar();
	public boolean modificar();
	public boolean eliminar();
	public ArrayList<UserDto> listado_usuarios();
}
