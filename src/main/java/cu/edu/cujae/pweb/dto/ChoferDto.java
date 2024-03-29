package cu.edu.cujae.pweb.dto;

public class ChoferDto {
	private String nombre;
	private String ci;
	private String direccion;
	private String telefono;
	private String provincia;
	private String marca;

	public ChoferDto() {}

	public ChoferDto(String nombre, String ci, String direccion, String telefono, String provincia, String marca) {
		this.nombre = nombre;
		this.ci = ci;
		this.direccion = direccion;
		this.telefono = telefono;
		this.provincia = provincia;
		this.marca = marca;
	}

	public String getNombre() {
		return nombre;
	}

	public String getCi() {
		return ci;
	}

	public String getDireccion() {
		return direccion;
	}

	public String getTelefono() {
		return telefono;
	}

	public String getProvincia() {
		return provincia;
	}

	public String getMarca() {
		return marca;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public void setCi(String ci) {
		this.ci = ci;
	}

	public void setDireccion(String direccion) {
		this.direccion = direccion;
	}

	public void setTelefono(String telefono) {
		this.telefono = telefono;
	}

	public void setProvincia(String provincia) {
		this.provincia = provincia;
	}

	public void setMarca(String marca) {
		this.marca = marca;
	}
}
