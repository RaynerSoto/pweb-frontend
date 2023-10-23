package cu.edu.cujae.pweb.dto;

public class Choferes_fijosDto extends ChoferDto {
	private long id;
	private long id_carro;
	
	
	public Choferes_fijosDto(long identificador, String nombre, String ci, String direccion, String telefono,long id_provincia, long id_marca, long id, long id_carro) {
		super(identificador, nombre, ci, direccion, telefono, id_provincia, id_marca);
		this.id = id;
		this.id_carro = id_carro;
	}

	/**
	 * @return the id
	 */
	public long getId() {
		return id;
	}

	/**
	 * @param id the id to set
	 */
	public void setId(long id) {
		this.id = id;
	}

	/**
	 * @return the id_carro
	 */
	public long getId_carro() {
		return id_carro;
	}

	/**
	 * @param id_carro the id_carro to set
	 */
	public void setId_carro(long id_carro) {
		this.id_carro = id_carro;
	}
	
}
