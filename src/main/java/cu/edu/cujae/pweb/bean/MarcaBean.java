package cu.edu.cujae.pweb.bean;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;

@ManagedBean
@ViewScoped
public class MarcaBean {
	private long id;
	private String nombre;
	private int cantidad_asientos;
	private String tipo_combustible;
	private double consumo_combustible;
	
	public MarcaBean() {}
	
	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}
	
	public String getNombre() {
		return nombre;
	}
	public int getCantidad_asientos() {
		return cantidad_asientos;
	}
	public String getTipo_combustible() {
		return tipo_combustible;
	}
	public double getConsumo_combustible() {
		return consumo_combustible;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	public void setCantidad_asientos(int cantidad_asientos) {
		this.cantidad_asientos = cantidad_asientos;
	}
	public void setTipo_combustible(String tipo_combustible) {
		this.tipo_combustible = tipo_combustible;
	}
	public void setConsumo_combustible(double consumo_combustible) {
		this.consumo_combustible = consumo_combustible;
	}
	
	
}
