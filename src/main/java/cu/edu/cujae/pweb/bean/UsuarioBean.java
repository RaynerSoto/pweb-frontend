package cu.edu.cujae.pweb.bean;

import cu.edu.cujae.pweb.dto.RoleDto;
import cu.edu.cujae.pweb.dto.UsuarioDto;
import cu.edu.cujae.pweb.service.RoleService;
import cu.edu.cujae.pweb.service.UsuarioService;
import cu.edu.cujae.pweb.util.ResponseReciboUtil;
import cu.edu.cujae.pweb.utils.JsfUtils;
import cu.edu.cujae.pweb.utils.Respuesta_Enum;
import org.primefaces.PrimeFaces;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Component;

import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.view.ViewScoped;
import java.util.ArrayList;
import java.util.List;

@Component //Le indica a spring es un componete registrado
@ManagedBean
@ViewScoped //Este es el alcance utilizado para trabajar con Ajax
public class UsuarioBean {
    private UsuarioDto userDto;
    private UsuarioDto selectedUser;
    private ArrayList<UsuarioDto> users = new ArrayList<>();
    private ArrayList<String> roles = new ArrayList<String>();
    private boolean estado;
    BCryptPasswordEncoder encoder = new BCryptPasswordEncoder();



    /* @Autowired es la manera para inyectar una dependencia/clase anotada con @service en spring
     * Tener en cuenta que lo que se inyecta siempre es la interfaz y no la clase
     */
    @Autowired
    private UsuarioService userService;

    @Autowired
    private RoleService roleService;


    public UsuarioBean() {

    }

    //Esta anotacioon permite que se ejecute code luego de haberse ejecuta el constructor de la clase.

    //Se ejecuta al dar clic en el button Nuevo//siempre asi crea el boton
    public void openNew() {
        this.selectedUser = new UsuarioDto();
        estado = true;
    }

    //Se ejecuta al dar clic en el button con el lapicito
    public void openForEdit() {
        estado = false;
    }

    //Se ejecuta al dar clic en el button dentro del dialog para salvar o registrar al usuario
    public void saveUser() {
        if(this.selectedUser.getEmail().trim().equalsIgnoreCase("") || this.selectedUser.getFullName().trim().equalsIgnoreCase("") || this.selectedUser.getRol().trim().equalsIgnoreCase("") || this.selectedUser.getPassword().trim().equalsIgnoreCase("") || this.selectedUser.getUsername().trim().equalsIgnoreCase("")){
            System.out.println("Esto está vacío");
            JsfUtils.addMessageFromBundle(null, FacesMessage.SEVERITY_INFO, "combustible_fallo_insertar");
        }
        else{
            if (this.estado == true){
                try{
                    ResponseReciboUtil responseReciboUtil = userService.createUser(this.selectedUser);
                    if (responseReciboUtil.comparar_enum(Respuesta_Enum.Buena)){
                        JsfUtils.addMessageFromBundle(null, FacesMessage.SEVERITY_INFO,"usuario_insertado");
                        PrimeFaces.current().executeScript("PF('manageUserDialog').hide()");//Este code permite cerrar el dialog cuyo id es manageUserDialog. Este identificador es el widgetVar
                        PrimeFaces.current().ajax().update("form:dt-users");// Este code es para refrescar el componente con id dt-users que se encuentra dentro del formulario con id form
                    }
                    else {
                        if (responseReciboUtil.getMensaje_recibo().trim().equalsIgnoreCase("Nombre completo del usuario vacío")){
                            JsfUtils.addMessageFromBundle(null, FacesMessage.SEVERITY_ERROR, "usuario_nombre_completo_vacio");
                            PrimeFaces.current().executeScript("PF('manageUserDialog').hide()");//Este code permite cerrar el dialog cuyo id es manageUserDialog. Este identificador es el widgetVar
                        }
                        else if (responseReciboUtil.getMensaje_recibo().trim().equalsIgnoreCase("Contraseña vacía")){
                            JsfUtils.addMessageFromBundle(null, FacesMessage.SEVERITY_ERROR, "usuario_contrasenna_vacio");
                            PrimeFaces.current().executeScript("PF('manageUserDialog').hide()");
                        }
                        else if (responseReciboUtil.getMensaje_recibo().trim().equalsIgnoreCase("El nombre de usuario está vacío")){
                            JsfUtils.addMessageFromBundle(null, FacesMessage.SEVERITY_ERROR, "usuario_username_vacio");
                            PrimeFaces.current().executeScript("PF('manageUserDialog').hide()");
                        }
                        else if (responseReciboUtil.getMensaje_recibo().trim().equalsIgnoreCase("El correo está vacío")){
                            JsfUtils.addMessageFromBundle(null, FacesMessage.SEVERITY_ERROR, "usuario_email_vacio");
                            PrimeFaces.current().executeScript("PF('manageUserDialog').hide()");
                        }
                        else if (responseReciboUtil.getMensaje_recibo().trim().equalsIgnoreCase("El rol está vacío")){
                            JsfUtils.addMessageFromBundle(null, FacesMessage.SEVERITY_ERROR, "usuario_rol_vacio");
                            PrimeFaces.current().executeScript("PF('manageUserDialog').hide()");
                        }
                        else {
                            System.out.println(responseReciboUtil.getMensaje_recibo());
                            JsfUtils.addMessageFromBundle(null, FacesMessage.SEVERITY_ERROR, "error_operation");
                            PrimeFaces.current().executeScript("PF('manageUserDialog').hide()");
                        }
                    }
                }catch (Exception e){
                    JsfUtils.addMessageFromBundle(null, FacesMessage.SEVERITY_ERROR,"error_operation");
                }
            }
            else {
                try {
                    ResponseReciboUtil responseReciboUtil = userService.updateUser(this.selectedUser);
                    PrimeFaces.current().executeScript("PF('manageUserDialog').hide()");//Este code permite cerrar el dialog cuyo id es manageUserDialog. Este identificador es el widgetVar
                    PrimeFaces.current().ajax().update("form:dt-users");// Este code es para refrescar el componente con id dt-users que se encuentra dentro del formulario con id form
                }catch (Exception e){
                    JsfUtils.addMessageFromBundle(null, FacesMessage.SEVERITY_ERROR,"error_operation");
                }
            }
        }
        PrimeFaces.current().executeScript("PF('manageUserDialog').hide()");//Este code permite cerrar el dialog cuyo id es manageUserDialog. Este identificador es el widgetVar
        PrimeFaces.current().ajax().update("form:dt-users");// Este code es para refrescar el componente con id dt-users que se encuentra dentro del formulario con id form
    }

    //Permite eliminar un usuario
    public void deleteUser() {
        try {
            this.selectedUser.setPassword(encoder.encode(this.selectedUser.getPassword()));
            ResponseReciboUtil responseReciboUtil = userService.deleteUser(this.selectedUser);
            if (responseReciboUtil.comparar_enum(Respuesta_Enum.Buena)){
                try {
                    users = userService.getUsers();
                    JsfUtils.addMessageFromBundle(null, FacesMessage.SEVERITY_INFO,"combustible_eliminado");
                }catch (Exception e){
                    JsfUtils.addMessageFromBundle(null, FacesMessage.SEVERITY_ERROR,"error_operation");
                }
                PrimeFaces.current().executeScript("PF('manageUserDialog').hide()");//Este code permite cerrar el dialog cuyo id es manageUserDialog. Este identificador es el widgetVar
                PrimeFaces.current().ajax().update("form:dt-users");// Este code es para refrescar el componente con id dt-users que se encuentra dentro del formulario con id form
            }
            else {
                JsfUtils.addMessageFromBundle(null, FacesMessage.SEVERITY_ERROR,"combustible_no_eliminado");
                PrimeFaces.current().executeScript("PF('manageUserDialog').hide()");//Este code permite cerrar el dialog cuyo id es manageUserDialog. Este identificador es el widgetVar
                PrimeFaces.current().ajax().update("form:dt-users");// Este code es para refrescar el componente con id dt-users que se encuentra dentro del formulario con id form
            }
        }catch (Exception e){
            e.printStackTrace();
            JsfUtils.addMessageFromBundle(null, FacesMessage.SEVERITY_ERROR,"error_operation");
        }
    }

    public UsuarioDto getUserDto() {
        return userDto;
    }

    public void setUserDto(UsuarioDto userDto) {
        this.userDto = userDto;
    }

    public UsuarioDto getSelectedUser() {
        return selectedUser;
    }

    public void setSelectedUser(UsuarioDto selectedUser) {
        this.selectedUser = selectedUser;
    }

    public List<UsuarioDto> getUsers() {
        try {
            if (users.size() != userService.getUsers().size()){
                users = userService.getUsers();
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return users;
    }

    public void setUsers(ArrayList<UsuarioDto> users) {
        this.users = users;
    }

    public ArrayList<String> getRoles() {
        try {
            if (this.roles.size() != roleService.getRoles().size()){
                roles = roleService.getRoles();
            }
        }catch (Exception e){
            e.printStackTrace();
        }
        return roles;
    }

    public void setRoles(ArrayList<String> roles) {
        this.roles = roles;
    }

    public boolean isEstado() {
        return estado;
    }

    public void setEstado(boolean estado) {
        this.estado = estado;
    }

    public UsuarioService getUserService() {
        return userService;
    }

    public void setUserService(UsuarioService userService) {
        this.userService = userService;
    }

    public RoleService getRoleService() {
        return roleService;
    }

    public void setRoleService(RoleService roleService) {
        this.roleService = roleService;
    }
}
