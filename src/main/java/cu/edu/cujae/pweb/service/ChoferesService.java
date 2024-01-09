package cu.edu.cujae.pweb.service;
import cu.edu.cujae.pweb.dto.ChoferDto;
import cu.edu.cujae.pweb.util.ResponseEnvioChofer;
import cu.edu.cujae.pweb.util.ResponseReciboUtil;


import java.util.ArrayList;

/**
 * @author Rayner Alejandro Soto Martínez
 * @version 1.0
 */
public interface ChoferesService {
    public ResponseReciboUtil inserta_chofer(ChoferDto choferDto) throws Exception;
    public ResponseReciboUtil modificar_chofer(ResponseEnvioChofer choferDto)throws Exception;
    public ResponseReciboUtil eliminar_chofer(String ci)throws Exception;
    public ArrayList<ChoferDto> listado_choferes_cubre()throws Exception;
    public ChoferDto obtener_chofer(String ci)throws Exception;

}
