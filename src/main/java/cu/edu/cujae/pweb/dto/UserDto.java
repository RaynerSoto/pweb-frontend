package cu.edu.cujae.pweb.dto;

public class UserDto {
	private long id;
	private String nombre;
	private String password;
	private String email;
	private String rol;
	
	public UserDto(long id, String nombre, String password, String email, String rol) {
		//Constructor de UserDto
		this.id = id;
		this.nombre = nombre;
		this.password = password;
		this.email = email;
		this.rol = rol;
	}
	
	public UserDto() {
		//Constructor en blanco
	}
	
	public long getId() {
		return id;
	}
	public String getNombre() {
		return nombre;
	}
	public String getPassword() {
		return password;
	}
	public String getEmail() {
		return email;
	}
	public String getRol() {
		return rol;
	}
	public void setId(long id) {
		this.id = id;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public void setRol(String rol) {
		this.rol = rol;
	}
}
