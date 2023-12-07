package cu.edu.cujae.pweb.service;

import cu.edu.cujae.pweb.dto.CombustibleDto;
import cu.edu.cujae.pweb.util.ResponseReciboUtil;

import java.util.ArrayList;

/**
 * @author Rayner Alejandro Soto Martínez
 * @version 1.0
 */
public interface CombustibleService {
    public ResponseReciboUtil inserta_combustible(CombustibleDto combustibleDto) throws Exception;
    public Exception modificar_combustible(CombustibleDto combustibleDto);
    public ResponseReciboUtil eliminar_combustible(CombustibleDto combustibleDto);
    public ArrayList<CombustibleDto>listado_combustibles()throws Exception;
    public CombustibleDto obtener_combustible(long id)throws Exception;

}
