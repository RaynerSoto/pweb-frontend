package cu.edu.cujae.pweb.service;

import cu.edu.cujae.pweb.dto.CombustibleDto;
import cu.edu.cujae.pweb.util.ResponseReciboUtil;

import javax.faces.model.SelectItem;
import java.util.ArrayList;
import java.util.List;

/**
 * @author Rayner Alejandro Soto Martínez
 * @version 1.0
 */
public interface CombustibleService {
    public ResponseReciboUtil inserta_combustible(CombustibleDto combustibleDto) throws Exception;
    public ResponseReciboUtil modificar_combustible(CombustibleDto combustibleDto) throws Exception;
    public ResponseReciboUtil eliminar_combustible(CombustibleDto combustibleDto) throws Exception;
    public ArrayList<CombustibleDto>listado_combustibles()throws Exception;
    public ArrayList<String>listado_combustibles_nombre() throws Exception;
    public CombustibleDto obtener_combustible(long id)throws Exception;

}
