package cu.edu.cujae.pweb.serviceImplement;

import cu.edu.cujae.pweb.dto.ChoferDto;
import cu.edu.cujae.pweb.service.ChoferesCubreService;
import org.springframework.stereotype.Service;
import java.util.ArrayList;

/**
 * @author Rayner Alejandro Soto Martínez
 * @version 1.0
 * @apiNote Servicios de los choferes Cubre Franco
 */
@Service
public class ChoferesCubreServiceImpl implements ChoferesCubreService {
    @Override
    public void inserta_chofer(ChoferDto choferDto) throws Exception {

    }

    @Override
    public void modificar_chofer(ChoferDto choferDto,String ci) throws Exception {

    }

    @Override
    public void eliminar_chofer(String ci) throws Exception {

    }

    @Override
    public ArrayList<ChoferDto> listado_choferes_cubre() throws Exception {

        return null;
    }

    @Override
    public ChoferDto obtener_chofer(String ci) throws Exception {

        return null;
    }
}
