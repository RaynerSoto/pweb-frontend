package cu.edu.cujae.pweb.serviceImplement;

import cu.edu.cujae.pweb.dto.CarroDto;
import cu.edu.cujae.pweb.dto.Hoja_de_rutaDto;
import cu.edu.cujae.pweb.security.CurrentUserUtils;
import cu.edu.cujae.pweb.service.HojadeRutaService;
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
public class HojaderutaServiceImpl implements HojadeRutaService {
    @Autowired
    private RestService restService;
    @Override
    public void insertar_hoja_de_ruta(Hoja_de_rutaDto hoja_de_ruta) {
        restService.POST("/api/v1/hojas/",hoja_de_ruta,String.class, CurrentUserUtils.getTokenBearer()).getBody();
    }

    @Override
    public void eliminar(long id) {
        MultiValueMap<String, String> params = new LinkedMultiValueMap<>();
        UriTemplate template = new UriTemplate("/api/v1/hojas/{id}");
        String uri = template.expand(id).toString();
        restService.DELETE(uri, params, String.class, CurrentUserUtils.getTokenBearer()).getBody();
    }

    @Override
    public void modificar(Hoja_de_rutaDto hoja_de_ruta_modificada) {
        MultiValueMap<String, String> params = new LinkedMultiValueMap<>();
        restService.PUT("/api/v1/hojas/",params,hoja_de_ruta_modificada, String.class,CurrentUserUtils.getTokenBearer()).getBody();
    }

    @Override
    public ArrayList<Hoja_de_rutaDto> cargar_hoja_de_ruta() throws SQLException, IOException {
        ArrayList<Hoja_de_rutaDto> listado_rutas = new ArrayList<Hoja_de_rutaDto>();
        MultiValueMap<String ,String> params = new LinkedMultiValueMap<>();
        ApiRestMapper<Hoja_de_rutaDto> apiRestMapper = new ApiRestMapper<>();
        String respuesta = (String) restService.GET("/api/v1/hojas/",params,String.class,CurrentUserUtils.getTokenBearer()).getBody();
        listado_rutas = (ArrayList<Hoja_de_rutaDto>) apiRestMapper.mapList(respuesta,Hoja_de_rutaDto.class);
        return listado_rutas;
    }
}
