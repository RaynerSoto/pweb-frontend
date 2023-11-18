package cu.edu.cujae.pweb.dto;

public class MarcaDto {
	
	private long identificador;
	private String nombre;//Interfaz
	private int cant_asientos;//Interfaz
	private String combustible;//Interfaz
	private double combustible_por_km;//Interfaz
	
	public MarcaDto() {
		// TODO Auto-generated constructor stub
	}
	
	public MarcaDto(long identificador, String nombre, int cant_asientos, String combustible, double combustible_por_km) {
		this.identificador = identificador;
		this.nombre = nombre;
		this.cant_asientos = cant_asientos;
		this.combustible = combustible;
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

	public String getCombustible() {
		return combustible;
	}

	public void setCombustible(String combustible) {
		this.combustible = combustible;
	}
	
	
}
