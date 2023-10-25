package cu.edu.cujae.pweb.service;

import cu.edu.cujae.pweb.dto.Choferes_fijosDto;

public interface Choferes_fijosService {
    public void insertar_chofer_fijo(Choferes_fijosDto chofer_fijo);
    public void eliminar(long id);
    public void modificar(Choferes_fijosDto cofer_fijo_modificado);
    public void cargar_choferes_fijos();
}
