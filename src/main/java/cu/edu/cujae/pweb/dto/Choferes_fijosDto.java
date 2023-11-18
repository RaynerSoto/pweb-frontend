package cu.edu.cujae.pweb.dto;

public class Choferes_fijosDto extends ChoferDto {
	private String placa_carro;

	public Choferes_fijosDto() {}

	public Choferes_fijosDto(String nombre, String ci, String direccion, String telefono,
							 String provincia, String marca, String placa_carro) {
		super(nombre, ci, direccion, telefono, provincia, marca);
		this.placa_carro = placa_carro;
	}

	public String getPlaca_carro() {
		return placa_carro;
	}
	public void setPlaca_carro(String placa_carro) {
		this.placa_carro = placa_carro;
	}
	
	
	
}
