package cu.edu.cujae.pweb.dto;

public class Choferes_fijosDto extends ChoferDto {
	private long id;
	private String placa_carro;
	
	
	
	public Choferes_fijosDto(long identificador, String nombre, String ci, String direccion, String telefono,
		String provincia, String marca, long id, String placa_carro) {
		super(identificador, nombre, ci, direccion, telefono, provincia, marca);
		this.id = id;
		this.placa_carro = placa_carro;
	}
	
	public long getId() {
		return id;
	}
	public String getPlaca_carro() {
		return placa_carro;
	}
	public void setId(long id) {
		this.id = id;
	}
	public void setPlaca_carro(String placa_carro) {
		this.placa_carro = placa_carro;
	}
	
	
	
}
