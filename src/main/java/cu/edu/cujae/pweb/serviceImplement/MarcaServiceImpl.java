package cu.edu.cujae.pweb.serviceImplement;

import cu.edu.cujae.pweb.dto.MarcaDto;
import cu.edu.cujae.pweb.service.MarcaService;
import org.springframework.stereotype.Service;
import java.util.ArrayList;

@Service
public class MarcaServiceImpl implements MarcaService {

    @Override
    public void inserta_marca(MarcaDto marcaDto) throws Exception {

    }

    @Override
    public void modificar_marca(MarcaDto marcaDto) throws Exception {

    }

    @Override
    public void eliminar_marca(Long id) throws Exception {

    }

    @Override
    public ArrayList<MarcaDto> listado_marcas() throws Exception {
        return null;
    }

    @Override
    public MarcaDto obtener_marca(long id) throws Exception {
        return null;
    }
}
