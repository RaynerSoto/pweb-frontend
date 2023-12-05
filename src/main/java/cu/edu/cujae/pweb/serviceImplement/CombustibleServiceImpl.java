package cu.edu.cujae.pweb.serviceImplement;

import cu.edu.cujae.pweb.dto.CombustibleDto;
import cu.edu.cujae.pweb.util.BadException;
import cu.edu.cujae.pweb.util.GoodException;
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
    public Exception inserta_combustible(CombustibleDto combustibleDto){
        Exception exception = new Exception();
        try {
            exception = (GoodException) restService.POST("/api/v1/combustibles/",combustibleDto,String.class).getBody();
        }catch (Exception e){
            exception = (BadException) restService.POST("/api/v1/combustibles/",combustibleDto,String.class).getBody();
        }finally {
            return exception;
        }
    }

    @Override
    public Exception modificar_combustible(CombustibleDto combustibleDto){
        return null;
    }

    @Override
    public Exception eliminar_combustible(Long id){
        return null;
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
