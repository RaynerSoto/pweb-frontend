package cu.edu.cujae.pweb.serviceImplement;
import cu.edu.cujae.pweb.dto.Choferes_fijosDto;
import cu.edu.cujae.pweb.service.ChoferesFijosService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Service;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

@Service
public class ChoferesFijosImpl implements ChoferesFijosService {

    @Override
    public void inserta_chofer(Choferes_fijosDto choferDto) throws Exception {

    }

    @Override
    public void modificar_chofer(Choferes_fijosDto choferDto, String ci) throws Exception {

    }

    @Override
    public void eliminar_chofer(String ci) throws Exception {

    }

    @Override
    public ArrayList<Choferes_fijosDto> listado_choferes_fijos() throws Exception {
        return null;
    }

    @Override
    public Choferes_fijosDto obtener_chofer(String ci) throws Exception {
        return null;
    }
}
