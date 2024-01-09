package cu.edu.cujae.pweb.service;

import java.util.ArrayList;
import cu.edu.cujae.pweb.dto.MarcaDto;
import cu.edu.cujae.pweb.util.ResponseReciboUtil;

/**
 * @author Rayner Alejandro Soto Martínez
 * @version 1.0
 */
public interface MarcaService {
    public ResponseReciboUtil inserta_marca(MarcaDto marcaDto) throws Exception;

    public ResponseReciboUtil modificar_marca(MarcaDto marcaDto) throws Exception;

    public ResponseReciboUtil eliminar_marca(MarcaDto marcaDto) throws Exception;

    public ArrayList<MarcaDto> listado_marcas() throws Exception;

    public MarcaDto obtener_marca(long id) throws Exception;

    public ArrayList<String> listado_marcas_nombre() throws Exception;
}
