package cu.edu.cujae.pweb.serviceImplement;

import cu.edu.cujae.pweb.dto.CarroDto;
import cu.edu.cujae.pweb.service.CarroService;
import cu.edu.cujae.pweb.utils.RestService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.sql.SQLException;
import java.util.ArrayList;

@Service
public class CarroServiceImpl implements CarroService {
    @Autowired
    private RestService restService;

    @Override
    public void insertar_datos(CarroDto car) throws SQLException {
        restService.POST("/api/v1/carros",car,String.class).getBody();

    }

    @Override
    public void modificar_datos(CarroDto car, long id) throws SQLException {

    }

    @Override
    public void eliminar_datos(long id) throws SQLException {

    }

    @Override
    public ArrayList<CarroDto> listado_carros() throws SQLException {
        return null;
    }

}
