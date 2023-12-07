package cu.edu.cujae.pweb.service;

import cu.edu.cujae.pweb.dto.Hoja_de_rutaDto;
import java.util.ArrayList;

public interface HojadeRutaService {
    public void insertar_hoja_de_ruta(Hoja_de_rutaDto hoja_de_ruta);
    public void eliminar(long id);
    public void modificar(Hoja_de_rutaDto hoja_de_ruta_modificada, long id);
    public ArrayList<Hoja_de_rutaDto> cargar_hoja_de_ruta();
}
