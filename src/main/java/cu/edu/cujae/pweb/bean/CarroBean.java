package cu.edu.cujae.pweb.bean;

import java.util.ArrayList;

import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;

import cu.edu.cujae.pweb.service.CarroService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import cu.edu.cujae.pweb.dto.CarroDto;

@Component
@ManagedBean
@ViewScoped
public class CarroBean {

	@Autowired
	private CarroService carroService;

	private CarroDto carro;
	private CarroDto carro_select;
	private ArrayList<CarroDto> listado_carros;
	private ArrayList<String> listado_marcas;
	public CarroBean() {
	}

	
	@PostConstruct
	public void init() {
		
	}


	public CarroDto getCarro() {
		return carro;
	}
	public CarroDto getCarro_select() {
		return carro_select;
	}
	public ArrayList<CarroDto> getListado_carros() {
		return listado_carros;
	}
	public ArrayList<String> getListado_marcas() {
		return listado_marcas;
	}
	public void setCarro(CarroDto carro) {
		this.carro = carro;
	}
	public void setCarro_select(CarroDto carro_select) {
		this.carro_select = carro_select;
	}
	public void setListado_carros(ArrayList<CarroDto> listado_carros) {
		this.listado_carros = listado_carros;
	}
	public void setListado_marcas(ArrayList<String> listado_marcas) {
		this.listado_marcas = listado_marcas;
	}
	// Implementaciones
	// Se ejecuta al dar clic en Nuevo (Crea el boton)
	public void openNew(){
		this.carro_select = new CarroDto();
	}

	//Modificar
	public void openForEdidt(){

	}
	//Salvar
	public void SaveCarro(){

	}
	//Eliminar
	public void deleteCarro(){

	}

}
