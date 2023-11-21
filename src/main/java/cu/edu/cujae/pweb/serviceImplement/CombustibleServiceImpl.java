package cu.edu.cujae.pweb.serviceImplement;

import com.fasterxml.jackson.databind.annotation.JsonAppend;
import cu.edu.cujae.pweb.dto.CombustibleDto;
import cu.edu.cujae.pweb.service.CombustibleService;
import cu.edu.cujae.pweb.utils.RestService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.ArrayList;

@Service
public class CombustibleServiceImpl implements CombustibleService {
    @Autowired
    private RestService restService;

    @Override
    public void inserta_combustible(CombustibleDto combustibleDto) throws Exception {
        try {
            String respuesta = (String) restService.POST("/api/vi//api/v1/combustibles",combustibleDto,String.class).getBody();
            System.out.println(respuesta);
        }catch (Exception e){
            e.printStackTrace();
        }
    }

    @Override
    public void modificar_combustible(CombustibleDto combustibleDto) throws Exception {

    }

    @Override
    public void eliminar_combustible(Long id) throws Exception {

    }

    @Override
    public ArrayList<CombustibleDto> listado_combustibles() throws Exception {
        return null;
    }

    @Override
    public CombustibleDto obtener_combustible(long id) throws Exception {
        return null;
    }
}
