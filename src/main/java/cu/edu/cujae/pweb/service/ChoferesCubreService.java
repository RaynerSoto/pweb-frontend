package cu.edu.cujae.pweb.service;
import cu.edu.cujae.pweb.dto.ChoferDto;


import java.util.ArrayList;

/**
 * @author Rayner Alejandro Soto Martínez
 * @version 1.0
 */
public interface ChoferesCubreService {
    public void inserta_chofer(ChoferDto choferDto) throws Exception;
    public void modificar_chofer(ChoferDto choferDto,String ci)throws Exception;
    public void eliminar_chofer(String ci)throws Exception;
    public ArrayList<ChoferDto> listado_choferes_cubre()throws Exception;
    public ChoferDto obtener_chofer(String ci)throws Exception;

}
