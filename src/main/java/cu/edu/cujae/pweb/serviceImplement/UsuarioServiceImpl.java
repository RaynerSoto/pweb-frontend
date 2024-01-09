package cu.edu.cujae.pweb.serviceImplement;

import cu.edu.cujae.pweb.dto.CombustibleDto;
import cu.edu.cujae.pweb.dto.UserDto;
import cu.edu.cujae.pweb.dto.UsuarioDto;
import cu.edu.cujae.pweb.security.CurrentUserUtils;
import cu.edu.cujae.pweb.service.UsuarioService;
import cu.edu.cujae.pweb.util.ResponseReciboUtil;
import cu.edu.cujae.pweb.utils.ApiRestMapper;
import cu.edu.cujae.pweb.utils.RestService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Service;
import org.springframework.util.LinkedMultiValueMap;
import org.springframework.util.MultiValueMap;
import org.springframework.web.util.UriTemplate;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

@Service
public class UsuarioServiceImpl implements UsuarioService {
    @Autowired
    private RestService restService;
    @Override
    public ArrayList<UsuarioDto> getUsers() throws Exception{
        ArrayList<UsuarioDto> listado_usuarios = new ArrayList<>();
        MultiValueMap<String, String> params = new LinkedMultiValueMap<>();
        ApiRestMapper<UsuarioDto> apiRestMapper = new ApiRestMapper<>();
        String respuesta = (String) restService.GET("/api/v1/usuarios/",params,String.class, CurrentUserUtils.getTokenBearer()).getBody();
        listado_usuarios = (ArrayList<UsuarioDto>) apiRestMapper.mapList(respuesta,UsuarioDto.class);
        return listado_usuarios;
    }

    @Override
    public ArrayList<UsuarioDto> getUsers_no_superadmin() throws Exception {
        ArrayList<UsuarioDto> listado_usuarios = new ArrayList<>();
        MultiValueMap<String, String> params = new LinkedMultiValueMap<>();
        ApiRestMapper<UsuarioDto> apiRestMapper = new ApiRestMapper<>();
        String respuesta = (String) restService.GET("/api/v1/usuarios/no_super_administradores",params,String.class,CurrentUserUtils.getTokenBearer()).getBody();
        listado_usuarios = (ArrayList<UsuarioDto>) apiRestMapper.mapList(respuesta,UsuarioDto.class);
        return listado_usuarios;
    }

    @Override
    public UserDto getUserById(String userId) {
        return null;
    }

    @Override
    public ResponseReciboUtil createUser(UsuarioDto user) throws Exception {
        ResponseReciboUtil responseReciboUtil = new ResponseReciboUtil();
        ApiRestMapper<ResponseReciboUtil> apiRestMapper = new ApiRestMapper<>();
        String respuesta = (String) restService.POST("/api/v1/usuarios/",user,String.class,CurrentUserUtils.getTokenBearer()).getBody();
        responseReciboUtil = apiRestMapper.mapOne(respuesta, ResponseReciboUtil.class);
        return responseReciboUtil;
    }

    @Override
    public ResponseReciboUtil updateUser(UsuarioDto user) throws Exception {
        ResponseReciboUtil responseReciboUtil = new ResponseReciboUtil();
        ApiRestMapper<ResponseReciboUtil> apiRestMapper = new ApiRestMapper<>();
        MultiValueMap<String, String> params = new LinkedMultiValueMap<>();
        String respuesta = (String) restService.PUT("/api/v1/usuarios/",params,user, String.class,CurrentUserUtils.getTokenBearer()).getBody();
        responseReciboUtil = apiRestMapper.mapOne(respuesta,ResponseReciboUtil.class);
        return responseReciboUtil;
    }

    @Override
    public ResponseReciboUtil deleteUser(UsuarioDto user) throws Exception {
        ResponseReciboUtil responseReciboUtil = new ResponseReciboUtil();
        ApiRestMapper<ResponseReciboUtil> apiRestMapper = new ApiRestMapper<>();
        MultiValueMap<String, String> params = new LinkedMultiValueMap<>();
        UriTemplate template = new UriTemplate("/api/v1/usuarios/{id}");
        String uri = template.expand(user.getId()).toString();
        String respuesta = (String) restService.DELETE(uri, params, String.class, CurrentUserUtils.getTokenBearer()).getBody();
        responseReciboUtil = apiRestMapper.mapOne(respuesta, ResponseReciboUtil.class);
        return responseReciboUtil;
    }
}
