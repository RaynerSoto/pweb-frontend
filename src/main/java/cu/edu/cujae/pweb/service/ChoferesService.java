package cu.edu.cujae.pweb.service;

import cu.edu.cujae.pweb.dto.ChoferDto;

public interface ChoferesService {
    public void insertar_chofer(ChoferDto chofer);
    public  void  eliminar_chofer(long id);
    public void modificar_chofer(ChoferDto chofer_modificado);
    public void buscar_chofer(long id);
    public void cargar_chofer();
}
