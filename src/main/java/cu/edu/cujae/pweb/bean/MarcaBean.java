package cu.edu.cujae.pweb.bean;

import java.util.ArrayList;

import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;

import org.springframework.stereotype.Component;

import cu.edu.cujae.pweb.dto.MarcaDto;

@Component
@ManagedBean
@ViewScoped
public class MarcaBean {
	
	private MarcaDto marca;
	
	private ArrayList<MarcaDto> listado_marcas;
	
	private MarcaDto marca_actual;
	
	
	public MarcaBean() {}
	
	@PostConstruct
	public void init() {
		MarcaDto marca = new MarcaDto(1,"Rayner",34,59,10);
		listado_marcas.add(marca);
	}
	
	
	public ArrayList<MarcaDto> getListado_marcas() {
		return listado_marcas;
	}

	public void setListado_marcas(ArrayList<MarcaDto> listado_marcas) {
		this.listado_marcas = listado_marcas;
	}

	public MarcaDto getMarca_actual() {
		return marca_actual;
	}

	public void setMarca_actual(MarcaDto marca_actual) {
		this.marca_actual = marca_actual;
	}

	public MarcaDto getMarca() {
		return marca;
	}

	public void setMarca(MarcaDto marca) {
		this.marca = marca;
	}
}
