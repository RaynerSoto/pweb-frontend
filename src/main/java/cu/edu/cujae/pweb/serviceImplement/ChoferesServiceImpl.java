package cu.edu.cujae.pweb.serviceImplement;

import cu.edu.cujae.pweb.dto.ChoferDto;
import cu.edu.cujae.pweb.dto.UsuarioDto;
import cu.edu.cujae.pweb.security.CurrentUserUtils;
import cu.edu.cujae.pweb.service.ChoferesService;
import cu.edu.cujae.pweb.utils.ApiRestMapper;
import cu.edu.cujae.pweb.utils.RestService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.LinkedMultiValueMap;
import org.springframework.util.MultiValueMap;

import java.util.ArrayList;

/**
 * @author Rayner Alejandro Soto Martínez
 * @version 1.0
 * @apiNote Servicios de los choferes
 */
@Service
public class ChoferesServiceImpl implements ChoferesService {

    @Autowired
    private RestService restService;

    @Override
    public void inserta_chofer(ChoferDto choferDto) throws Exception {

    }

    @Override
    public void modificar_chofer(ChoferDto choferDto,String ci) throws Exception {

    }

    @Override
    public void eliminar_chofer(String ci) throws Exception {

    }

    @Override
    public ArrayList<ChoferDto> listado_choferes_cubre() throws Exception {
        ArrayList<ChoferDto> listado_usuarios = new ArrayList<>();
        MultiValueMap<String, String> params = new LinkedMultiValueMap<>();
        ApiRestMapper<ChoferDto> apiRestMapper = new ApiRestMapper<>();
        String respuesta = (String) restService.GET("/api/v1/choferescubre/",params,String.class, CurrentUserUtils.getTokenBearer()).getBody();
        listado_usuarios = (ArrayList<ChoferDto>) apiRestMapper.mapList(respuesta,ChoferDto.class);
        return listado_usuarios;
    }

    @Override
    public ChoferDto obtener_chofer(String ci) throws Exception {

        return null;
    }
}
