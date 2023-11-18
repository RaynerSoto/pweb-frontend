package cu.edu.cujae.pweb.service;

import java.util.ArrayList;
import cu.edu.cujae.pweb.dto.MarcaDto;

/**
 * @author Rayner Alejandro Soto Martínez
 * @version 1.0
 */
public interface MarcaService {
    public void inserta_marca(MarcaDto marcaDto) throws Exception;
    public void modificar_marca(MarcaDto marcaDto)throws Exception;
    public void eliminar_marca(Long id)throws Exception;
    public ArrayList<MarcaDto> listado_marcas()throws Exception;
    public MarcaDto obtener_marca(long id)throws Exception;
}
