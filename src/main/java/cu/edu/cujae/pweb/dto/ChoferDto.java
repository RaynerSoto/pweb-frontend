package cu.edu.cujae.pweb.dto;

public class ChoferDto {
	private long identificador;
	private String nombre;
	private String ci;
	private String direccion;
	private String telefono;
	private long id_provincia;
	private long id_marca;
	
	public ChoferDto(long identificador, String nombre, String ci, String direccion, String telefono, long id_provincia,long id_marca) {
		super();
		this.identificador = identificador;
		this.nombre = nombre;
		this.ci = ci;
		this.direccion = direccion;
		this.telefono= telefono;
		this.id_provincia = id_provincia;
		this.id_marca=id_marca;
	}

	public long getIdentificador() {
		return identificador;
	}

	public void setIdentificador(long identificador) {
		this.identificador = identificador;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getCi() {
		return ci;
	}

	public void setCi(String ci) {
		this.ci = ci;
	}

	public String getDireccion() {
		return direccion;
	}

	public void setDireccion(String direccion) {
		this.direccion = direccion;
	}

	public String getTelefono() {
		return telefono;
	}

	public void setTelefono(String telefono) {
		this.telefono = telefono;
	}

	public long getId_provincia() {
		return id_provincia;
	}

	public void setId_provincia(long id_provincia) {
		this.id_provincia = id_provincia;
	}

	public long getId_marca() {
		return id_marca;
	}

	public void setId_marca(long id_marca) {
		this.id_marca = id_marca;
	}
	
	
}
