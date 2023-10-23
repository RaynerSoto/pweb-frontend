package cu.edu.cujae.pweb.dto;

public class MarcaDto {
	private long identificador;
	private String nombre;
	private int cant_asientos;
	private long id_combustible;
	private double combustible_por_km;
	
	public MarcaDto(long identificador, String nombre, int cant_asientos, long id_combustible, double combustible_por_km) {
		this.identificador = identificador;
		this.nombre = nombre;
		this.cant_asientos = cant_asientos;
		this.id_combustible = id_combustible;
		this.combustible_por_km = combustible_por_km;
	}

	/**
	 * @return the identificador
	 */
	public long getIdentificador() {
		return identificador;
	}

	/**
	 * @param identificador the identificador to set
	 */
	public void setIdentificador(long identificador) {
		this.identificador = identificador;
	}

	/**
	 * @return the nombre
	 */
	public String getNombre() {
		return nombre;
	}

	/**
	 * @param nombre the nombre to set
	 */
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	/**
	 * @return the cant_asientos
	 */
	public int getCant_asientos() {
		return cant_asientos;
	}

	/**
	 * @param cant_asientos the cant_asientos to set
	 */
	public void setCant_asientos(int cant_asientos) {
		this.cant_asientos = cant_asientos;
	}

	/**
	 * @return the id_combustible
	 */
	public long getId_combustible() {
		return id_combustible;
	}

	/**
	 * @param id_combustible the id_combustible to set
	 */
	public void setId_combustible(long id_combustible) {
		this.id_combustible = id_combustible;
	}

	/**
	 * @return the combustible_por_km
	 */
	public double getCombustible_por_km() {
		return combustible_por_km;
	}

	/**
	 * @param combustible_por_km the combustible_por_km to set
	 */
	public void setCombustible_por_km(double combustible_por_km) {
		this.combustible_por_km = combustible_por_km;
	}
	
	
}
