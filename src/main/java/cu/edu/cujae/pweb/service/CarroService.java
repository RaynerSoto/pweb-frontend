package cu.edu.cujae.pweb.service;

import cu.edu.cujae.pweb.dto.CarroDto;

import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;

public interface CarroService {
    void insertar_datos(CarroDto car) throws SQLException;
    void modificar_datos(CarroDto car,long id) throws SQLException;
    void eliminar_datos(long id) throws SQLException;
    ArrayList<CarroDto> listado_carros() throws SQLException, IOException;

}
