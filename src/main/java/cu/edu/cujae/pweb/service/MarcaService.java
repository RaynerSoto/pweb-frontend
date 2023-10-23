package cu.edu.cujae.pweb.service;

import java.util.ArrayList;

import cu.edu.cujae.pweb.dto.MarcaDto;

public interface MarcaService {
	public ArrayList<MarcaDto> cargar_marcar();
    public void annadir_marcas();
    public void eliminar_marcas(long id);
    public void modificar();
	public ArrayList<String> cargar_marcar_nombre();
	public long buscar_marca_ID(String nombre);
}
