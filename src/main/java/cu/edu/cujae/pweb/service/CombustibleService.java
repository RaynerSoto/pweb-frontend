package cu.edu.cujae.pweb.service;

import cu.edu.cujae.pweb.dto.CombustibleDto;
import java.util.ArrayList;

/**
 * @author Rayner Alejandro Soto Martínez
 * @version 1.0
 */
public interface CombustibleService {
    public void inserta_combustible(CombustibleDto combustibleDto) throws Exception;
    public void modificar_combustible(CombustibleDto combustibleDto)throws Exception;
    public void eliminar_combustible(Long id)throws Exception;
    public ArrayList<CombustibleDto>listado_combustibles()throws Exception;
    public CombustibleDto obtener_combustible(long id)throws Exception;

}
