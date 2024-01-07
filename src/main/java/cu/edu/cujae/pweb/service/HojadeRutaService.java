package cu.edu.cujae.pweb.service;

import cu.edu.cujae.pweb.dto.Hoja_de_rutaDto;

import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;

public interface HojadeRutaService {
    public void insertar_hoja_de_ruta(Hoja_de_rutaDto hoja_de_ruta) throws SQLException;
    public void eliminar(long id) throws SQLException;
    public void modificar(Hoja_de_rutaDto hoja_de_ruta_modificada)throws SQLException;
    public ArrayList<Hoja_de_rutaDto> cargar_hoja_de_ruta() throws SQLException, IOException;
}
