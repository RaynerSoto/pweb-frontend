package cu.edu.cujae.pweb.serviceImplement;

import cu.edu.cujae.pweb.dto.CombustibleDto;
import cu.edu.cujae.pweb.dto.MarcaDto;
import cu.edu.cujae.pweb.service.MarcaService;
import cu.edu.cujae.pweb.util.ResponseReciboUtil;
import cu.edu.cujae.pweb.utils.ApiRestMapper;
import cu.edu.cujae.pweb.utils.RestService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.LinkedMultiValueMap;
import org.springframework.util.MultiValueMap;
import org.springframework.web.util.UriTemplate;

import java.util.ArrayList;
import java.util.stream.Collectors;

@Service
public class MarcaServiceImpl implements MarcaService {

    @Autowired
    private RestService restService;

    @Override
    public ResponseReciboUtil inserta_marca(MarcaDto marcaDto) throws Exception {
        ResponseReciboUtil responseReciboUtil = new ResponseReciboUtil();
        ApiRestMapper<ResponseReciboUtil> apiRestMapper = new ApiRestMapper<>();
        String respuesta = (String) restService.POST("/api/v1/marcas/",marcaDto,String.class).getBody();
        responseReciboUtil = apiRestMapper.mapOne(respuesta, ResponseReciboUtil.class);
        return responseReciboUtil;
    }

    @Override
    public ResponseReciboUtil modificar_marca(MarcaDto marcaDto) throws Exception {
        ResponseReciboUtil responseReciboUtil = new ResponseReciboUtil();
        ApiRestMapper<ResponseReciboUtil> apiRestMapper = new ApiRestMapper<>();
        MultiValueMap<String, String> params = new LinkedMultiValueMap<>();
        String respuesta = (String) restService.PUT("/api/v1/marcas/",params,marcaDto, String.class).getBody();
        responseReciboUtil = apiRestMapper.mapOne(respuesta,ResponseReciboUtil.class);
        return responseReciboUtil;
    }

    @Override
    public ResponseReciboUtil eliminar_marca(MarcaDto marcaDto) throws Exception {
        ResponseReciboUtil responseReciboUtil = new ResponseReciboUtil();
        ApiRestMapper<ResponseReciboUtil> apiRestMapper = new ApiRestMapper<>();
        MultiValueMap<String, String> params = new LinkedMultiValueMap<>();
        UriTemplate template = new UriTemplate("/api/v1/marcas/{id}");
        String uri = template.expand(marcaDto.getIdentificador()).toString();
        String respuesta = (String) restService.DELETE(uri, params, String.class, null).getBody();
        responseReciboUtil = apiRestMapper.mapOne(respuesta, ResponseReciboUtil.class);
        return responseReciboUtil;
    }

    @Override
    public ArrayList<MarcaDto> listado_marcas() throws Exception {
        ArrayList<MarcaDto> listado_marcas = new ArrayList<>();
        MultiValueMap<String, String> params = new LinkedMultiValueMap<>();
        ApiRestMapper<MarcaDto> apiRestMapper = new ApiRestMapper<>();
        String respuesta = (String) restService.GET("/api/v1/marcas/",params,String.class).getBody();
        listado_marcas = (ArrayList<MarcaDto>) apiRestMapper.mapList(respuesta,MarcaDto.class);
        return listado_marcas;
    }

    public ArrayList<String>listado_marcas_nombre() throws Exception{
        ArrayList<String> listado_marcas = new ArrayList<>();
        MultiValueMap<String, String> params = new LinkedMultiValueMap<>();
        ApiRestMapper<String> apiRestMapper = new ApiRestMapper<>();
        String respuesta = (String) restService.GET("/api/v1/marcas/nombre",params,String.class).getBody();
        listado_marcas = (ArrayList<String>) apiRestMapper.mapList(respuesta,String.class);
        return listado_marcas;
    }

    @Override
    public MarcaDto obtener_marca(long id) throws Exception {
        return null;
    }
}
