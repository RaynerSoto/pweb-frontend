package cu.edu.cujae.pweb.service;

import java.util.ArrayList;

import cu.edu.cujae.pweb.dto.CarroDto;

public interface CarroService { 
	public void insertar_datos(CarroDto car);
	public void modificar_datos(CarroDto car,long id);
	public void eliminar_datos(long id);
	public ArrayList<CarroDto> listado_carros();
}
