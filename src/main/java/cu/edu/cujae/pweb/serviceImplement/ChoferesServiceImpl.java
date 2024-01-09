package cu.edu.cujae.pweb.serviceImplement;

import cu.edu.cujae.pweb.dto.ChoferDto;
import cu.edu.cujae.pweb.dto.UsuarioDto;
import cu.edu.cujae.pweb.security.CurrentUserUtils;
import cu.edu.cujae.pweb.service.ChoferesService;
import cu.edu.cujae.pweb.util.ResponseEnvioChofer;
import cu.edu.cujae.pweb.util.ResponseReciboUtil;
import cu.edu.cujae.pweb.utils.ApiRestMapper;
import cu.edu.cujae.pweb.utils.RestService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.LinkedMultiValueMap;
import org.springframework.util.MultiValueMap;
import cu.edu.cujae.pweb.util.ResponseReciboUtil;
import org.springframework.web.util.UriTemplate;

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
    public ResponseReciboUtil inserta_chofer(ChoferDto choferDto) throws Exception {
        ResponseReciboUtil responseReciboUtil = new ResponseReciboUtil();
        ApiRestMapper<ResponseReciboUtil> apiRestMapper = new ApiRestMapper<>();
        String respuesta = (String) restService.POST("/api/v1/chofer/",choferDto,String.class, CurrentUserUtils.getTokenBearer()).getBody();
        responseReciboUtil = apiRestMapper.mapOne(respuesta, ResponseReciboUtil.class);
        return responseReciboUtil;
    }

    @Override
    public ResponseReciboUtil modificar_chofer(ResponseEnvioChofer choferDto) throws Exception {
        ResponseReciboUtil responseReciboUtil = new ResponseReciboUtil();
        ApiRestMapper<ResponseReciboUtil> apiRestMapper = new ApiRestMapper<>();
        MultiValueMap<String, String> params = new LinkedMultiValueMap<>();
        String respuesta = (String) restService.PUT("/api/v1/chofer/",params,choferDto, String.class,CurrentUserUtils.getTokenBearer()).getBody();
        responseReciboUtil = apiRestMapper.mapOne(respuesta,ResponseReciboUtil.class);
        return responseReciboUtil;
    }

    @Override
    public ResponseReciboUtil eliminar_chofer(String ci) throws Exception {
        ResponseReciboUtil responseReciboUtil = new ResponseReciboUtil();
        ApiRestMapper<ResponseReciboUtil> apiRestMapper = new ApiRestMapper<>();
        MultiValueMap<String, String> params = new LinkedMultiValueMap<>();
        UriTemplate template = new UriTemplate("/api/v1/chofer/{ci}");
        String uri = template.expand(ci).toString();
        String respuesta = (String) restService.DELETE(uri, params, String.class, CurrentUserUtils.getTokenBearer()).getBody();
        responseReciboUtil = apiRestMapper.mapOne(respuesta, ResponseReciboUtil.class);
        return responseReciboUtil;
    }

    @Override
    public ArrayList<ChoferDto> listado_choferes_cubre() throws Exception {
        ArrayList<ChoferDto> listado_usuarios = new ArrayList<>();
        MultiValueMap<String, String> params = new LinkedMultiValueMap<>();
        ApiRestMapper<ChoferDto> apiRestMapper = new ApiRestMapper<>();
        String respuesta = (String) restService.GET("/api/v1/chofer/",params,String.class,CurrentUserUtils.getTokenBearer()).getBody();
        listado_usuarios = (ArrayList<ChoferDto>) apiRestMapper.mapList(respuesta,ChoferDto.class);
        return listado_usuarios;
    }

    @Override
    public ChoferDto obtener_chofer(String ci) throws Exception {

        return null;
    }
}
