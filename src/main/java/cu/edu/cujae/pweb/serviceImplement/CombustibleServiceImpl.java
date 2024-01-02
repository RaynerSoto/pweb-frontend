package cu.edu.cujae.pweb.serviceImplement;

import cu.edu.cujae.pweb.dto.CombustibleDto;
import cu.edu.cujae.pweb.service.CombustibleService;
import cu.edu.cujae.pweb.util.ResponseReciboUtil;
import cu.edu.cujae.pweb.utils.ApiRestMapper;
import cu.edu.cujae.pweb.utils.RestService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.LinkedMultiValueMap;
import org.springframework.util.MultiValueMap;
import org.springframework.web.util.UriTemplate;

import javax.faces.model.SelectItem;
import java.util.ArrayList;
import java.util.List;

@Service
public class CombustibleServiceImpl implements CombustibleService {
    @Autowired
    private RestService restService;

    @Override
    public ResponseReciboUtil inserta_combustible(CombustibleDto combustibleDto) throws Exception{
        ResponseReciboUtil responseReciboUtil = new ResponseReciboUtil();
        ApiRestMapper<ResponseReciboUtil> apiRestMapper = new ApiRestMapper<>();
        String respuesta = (String) restService.POST("/api/v1/combustibles/",combustibleDto,String.class).getBody();
        responseReciboUtil = apiRestMapper.mapOne(respuesta, ResponseReciboUtil.class);
        return responseReciboUtil;
    }

    @Override
    public ResponseReciboUtil modificar_combustible(CombustibleDto combustibleDto) throws Exception{
        ResponseReciboUtil responseReciboUtil = new ResponseReciboUtil();
        ApiRestMapper<ResponseReciboUtil> apiRestMapper = new ApiRestMapper<>();
        MultiValueMap<String, String> params = new LinkedMultiValueMap<>();
        String respuesta = (String) restService.PUT("/api/v1/combustibles/",params,combustibleDto, String.class).getBody();
        responseReciboUtil = apiRestMapper.mapOne(respuesta,ResponseReciboUtil.class);
        return responseReciboUtil;
    }

    @Override
    public ResponseReciboUtil eliminar_combustible(CombustibleDto combustibleDto) throws Exception{
        ResponseReciboUtil responseReciboUtil = new ResponseReciboUtil();
        ApiRestMapper<ResponseReciboUtil> apiRestMapper = new ApiRestMapper<>();
        MultiValueMap<String, String> params = new LinkedMultiValueMap<>();
        UriTemplate template = new UriTemplate("/api/v1/combustibles/{id}");
        String uri = template.expand(combustibleDto.getId()).toString();
        String respuesta = (String) restService.DELETE(uri, params, String.class, null).getBody();
        responseReciboUtil = apiRestMapper.mapOne(respuesta, ResponseReciboUtil.class);
        return responseReciboUtil;
    }

    @Override
    public ArrayList<CombustibleDto> listado_combustibles() throws Exception {
        ArrayList<CombustibleDto> listado_combustibles = new ArrayList<>();
        MultiValueMap<String, String> params = new LinkedMultiValueMap<>();
        ApiRestMapper<CombustibleDto> apiRestMapper = new ApiRestMapper<>();
        String respuesta = (String) restService.GET("/api/v1/combustibles/",params,String.class).getBody();
        listado_combustibles = (ArrayList<CombustibleDto>) apiRestMapper.mapList(respuesta,CombustibleDto.class);
        return listado_combustibles;
    }

    @Override
    public ArrayList<String> listado_combustibles_nombre() throws Exception {
        ArrayList<String> listado_combustibles = new ArrayList<>();
        MultiValueMap<String, String> params = new LinkedMultiValueMap<>();
        ApiRestMapper<String> apiRestMapper = new ApiRestMapper<>();
        String respuesta = (String) restService.GET("/api/v1/combustibles/nombres",params,String.class).getBody();
        try {
            listado_combustibles = (ArrayList<String>) apiRestMapper.mapList(respuesta,String.class);
        }catch (Exception e){
            e.printStackTrace();
            System.out.println(((ResponseReciboUtil) apiRestMapper.mapList(respuesta,String.class)).toString());
        }finally {
            return listado_combustibles;
        }
    }

    @Override
    public CombustibleDto obtener_combustible(long id) throws Exception {
        return null;
    }
}
