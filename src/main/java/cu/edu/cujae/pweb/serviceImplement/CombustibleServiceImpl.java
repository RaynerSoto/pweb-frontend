package cu.edu.cujae.pweb.serviceImplement;

import cu.edu.cujae.pweb.dto.CombustibleDto;
import cu.edu.cujae.pweb.service.CombustibleService;
import org.springframework.stereotype.Service;
import java.util.ArrayList;

@Service
public class CombustibleServiceImpl implements CombustibleService {

    @Override
    public void inserta_combustible(CombustibleDto combustibleDto) throws Exception {

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
