package cu.edu.cujae.pweb.dto;

public class CarroDto {
	
	private long id_numero_de_flotilla;
	private String placa;
	private long identificador;
	private long id_marca;
	
	
	public CarroDto(long id_numero_de_flotilla, String placa, long identificador, long id_marca) {
		this.setId_numero_de_flotilla(id_numero_de_flotilla);
		this.placa = placa;
		this.setIdentificador(identificador);
		this.id_marca = id_marca;
	}
	
	/**
	 * @return the id_numero_de_flotilla
	 */
	/**
	 * @return the placa
	 */
	public String getPlaca() {
		return placa;
	}
	/**
	 * @param placa the placa to set
	 */
	public void setPlaca(String placa) {
		placa = placa;
	}
	/**
	 * @return the id_marca
	 */
	public long getId_marca() {
		return id_marca;
	}
	/**
	 * @param id_marca the id_marca to set
	 */
	public void setId_marca(long id_marca) {
		this.id_marca = id_marca;
	}

	public long getId_numero_de_flotilla() {
		return id_numero_de_flotilla;
	}

	public void setId_numero_de_flotilla(long id_numero_de_flotilla) {
		this.id_numero_de_flotilla = id_numero_de_flotilla;
	}

	public long getIdentificador() {
		return identificador;
	}

	public void setIdentificador(long identificador) {
		this.identificador = identificador;
	}
	
	
	
}
