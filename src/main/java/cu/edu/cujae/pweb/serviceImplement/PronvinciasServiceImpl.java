package cu.edu.cujae.pweb.serviceImplement;

import cu.edu.cujae.pweb.security.CurrentUserUtils;
import cu.edu.cujae.pweb.service.ProvinciasService;
import cu.edu.cujae.pweb.util.ResponseReciboUtil;
import cu.edu.cujae.pweb.utils.ApiRestMapper;
import cu.edu.cujae.pweb.utils.RestService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.LinkedMultiValueMap;
import org.springframework.util.MultiValueMap;

import java.util.ArrayList;

@Service
public class PronvinciasServiceImpl implements ProvinciasService {

    @Autowired
    private RestService restService;

    @Override
    public ArrayList<String> listado_nombre() throws Exception {
        ArrayList<String> listado_provincias = new ArrayList<>();
        MultiValueMap<String, String> params = new LinkedMultiValueMap<>();
        ApiRestMapper<String> apiRestMapper = new ApiRestMapper<>();
        String respuesta = (String) restService.GET("/api/v1/provincias/",params,String.class, CurrentUserUtils.getTokenBearer()).getBody();
        try {
            listado_provincias = (ArrayList<String>) apiRestMapper.mapList(respuesta,String.class);
        }catch (Exception e){
            e.printStackTrace();
            System.out.println(((ResponseReciboUtil) apiRestMapper.mapList(respuesta,String.class)).toString());
        }finally {
            return listado_provincias;
        }
    }
}
