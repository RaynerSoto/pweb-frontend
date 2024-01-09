package cu.edu.cujae.pweb.manager_dto;

import java.util.ArrayList;

public class UsuarioDtoManager {
    public String getIDString(Long id){

        return String.valueOf(id);
    }
    public ArrayList<String> getRolList(String rol){
        ArrayList<String> roles = new ArrayList<>();
        roles.add(rol);
        return roles;
    }
}
