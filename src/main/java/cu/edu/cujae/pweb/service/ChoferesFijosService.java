package cu.edu.cujae.pweb.service;
import cu.edu.cujae.pweb.dto.Choferes_fijosDto;

import java.util.ArrayList;

/**
 * @author Rayner Alejandro Soto Martínez
 * @version 1.0
 */
public interface ChoferesFijosService {
    public void inserta_chofer(Choferes_fijosDto choferDto) throws Exception;
    public void modificar_chofer(Choferes_fijosDto choferDto,String ci)throws Exception;
    public void eliminar_chofer(String ci)throws Exception;
    public ArrayList<Choferes_fijosDto> listado_choferes_fijos()throws Exception;
    public Choferes_fijosDto obtener_chofer(String ci)throws Exception;
}
