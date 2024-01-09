package cu.edu.cujae.pweb.serviceImplement;

import cu.edu.cujae.pweb.dto.CarroDto;
import cu.edu.cujae.pweb.security.CurrentUserUtils;
import cu.edu.cujae.pweb.service.CarroService;
import cu.edu.cujae.pweb.utils.ApiRestMapper;
import cu.edu.cujae.pweb.utils.RestService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.LinkedMultiValueMap;
import org.springframework.util.MultiValueMap;
import org.springframework.web.util.UriTemplate;

import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;

@Service
public class CarroServiceImpl implements CarroService {
    @Autowired
    private RestService restService;

    @Override
    public void insertar_datos(CarroDto car) throws SQLException {
        restService.POST("/api/v1/carros/",car,String.class, CurrentUserUtils.getTokenBearer()).getBody();
    }

    @Override
    public void modificar_datos(CarroDto car) throws SQLException {
        MultiValueMap<String, String> params = new LinkedMultiValueMap<>();
        restService.PUT("/api/v1/carros/",params,car, String.class,CurrentUserUtils.getTokenBearer()).getBody();
    }

    @Override
    public void eliminar_datos(long id) throws SQLException {
        MultiValueMap<String, String> params = new LinkedMultiValueMap<>();
        UriTemplate template = new UriTemplate("/api/v1/carros/{id}");
        String uri = template.expand(id).toString();
        restService.DELETE(uri, params, String.class, CurrentUserUtils.getTokenBearer()).getBody();
    }

    @Override
    public ArrayList<CarroDto> listado_carros() throws SQLException, IOException {
        ArrayList<CarroDto> listado_carros = new ArrayList<CarroDto>();
        MultiValueMap<String ,String> params = new LinkedMultiValueMap<>();
        ApiRestMapper<CarroDto> apiRestMapper = new ApiRestMapper<>();
        String respuesta = (String) restService.GET("/api/v1/carros/",params,String.class,CurrentUserUtils.getTokenBearer()).getBody();
        listado_carros = (ArrayList<CarroDto>) apiRestMapper.mapList(respuesta,CarroDto.class);
        return listado_carros;
    }
}
