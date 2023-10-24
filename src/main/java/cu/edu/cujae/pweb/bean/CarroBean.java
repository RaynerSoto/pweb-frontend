package cu.edu.cujae.pweb.bean;

import java.util.ArrayList;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;

import org.springframework.stereotype.Component;

import cu.edu.cujae.pweb.dto.CarroDto;

@Component
@ManagedBean
@ViewScoped
public class CarroBean {
	
	private CarroDto carro;
	private CarroDto carro_select;
	private ArrayList<CarroDto> listado_carros;
	
	public CarroBean(CarroDto carro, CarroDto carro_select, ArrayList<CarroDto> listado_carros) {
		super();
		this.carro = carro;
		this.carro_select = carro_select;
		this.listado_carros = listado_carros;
	}
	
	public CarroBean() {
		
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
	public void setCarro(CarroDto carro) {
		this.carro = carro;
	}
	public void setCarro_select(CarroDto carro_select) {
		this.carro_select = carro_select;
	}
	public void setListado_carros(ArrayList<CarroDto> listado_carros) {
		this.listado_carros = listado_carros;
	}
	
	

}
