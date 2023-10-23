package cu.edu.cujae.pweb.dto;


public class TransbusDto {
	private static TransbusDto trans;
	public static final String servidor="localhost";
	public static final String base_datos="transbus";
	public static final String usuario="postgres";
	public static final String contrasenna="0000";
	public static final String puerto="5432";
	
	public long usuario_rol;
	public String usuario_nombre;
	
	private TransbusDto() {}
	
	public static TransbusDto getTransbus(){
		if(trans == null)
			trans = new TransbusDto();
		return trans;
	}

}
