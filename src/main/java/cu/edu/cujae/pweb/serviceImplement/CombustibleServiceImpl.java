package cu.edu.cujae.pweb.serviceImplement;

import cu.edu.cujae.pweb.dto.CombustibleDto;
import cu.edu.cujae.pweb.dto.UserDto;
import cu.edu.cujae.pweb.service.CombustibleService;
import cu.edu.cujae.pweb.util.ResponseReciboUtil;
import cu.edu.cujae.pweb.utils.ApiRestMapper;
import cu.edu.cujae.pweb.utils.Respuesta_Enum;
import cu.edu.cujae.pweb.utils.RestService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.LinkedMultiValueMap;
import org.springframework.util.MultiValueMap;
import org.springframework.web.util.UriTemplate;

import java.util.ArrayList;

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
    public Exception modificar_combustible(CombustibleDto combustibleDto){
        return null;
    }

    @Override
    public ResponseReciboUtil eliminar_combustible(CombustibleDto combustibleDto){
        ResponseReciboUtil responseReciboUtil = new ResponseReciboUtil();
        try {
            ApiRestMapper<ResponseReciboUtil> apiRestMapper = new ApiRestMapper<>();
            MultiValueMap<String, String> params = new LinkedMultiValueMap<>();
            UriTemplate template = new UriTemplate("/api/v1/combustibles/{id}");
            String uri = template.expand(combustibleDto.getId()).toString();
            String respuesta = (String) restService.DELETE(uri, params, String.class, null).getBody();
            responseReciboUtil = apiRestMapper.mapOne(respuesta, ResponseReciboUtil.class);
            return responseReciboUtil;
        }catch (Exception e){
            responseReciboUtil = new ResponseReciboUtil(Respuesta_Enum.Mala,e.getMessage());
            return responseReciboUtil;
        }
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
    public CombustibleDto obtener_combustible(long id) throws Exception {
        return null;
    }
}
