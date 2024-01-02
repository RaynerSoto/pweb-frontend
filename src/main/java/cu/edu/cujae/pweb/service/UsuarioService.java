package cu.edu.cujae.pweb.service;

import cu.edu.cujae.pweb.dto.UserDto;
import cu.edu.cujae.pweb.dto.UsuarioDto;
import cu.edu.cujae.pweb.util.ResponseReciboUtil;
import org.primefaces.component.datatable.export.DataTableExcelXExporter;

import java.util.ArrayList;
import java.util.List;

public interface UsuarioService {
    ArrayList<UsuarioDto> getUsers() throws Exception;
    ArrayList<UsuarioDto> getUsers_no_superadmin() throws Exception;
    UserDto getUserById(String userId) throws Exception;
    ResponseReciboUtil createUser(UsuarioDto user) throws Exception;
    ResponseReciboUtil updateUser(UsuarioDto user) throws Exception;
    ResponseReciboUtil deleteUser(UsuarioDto user) throws Exception;
}
