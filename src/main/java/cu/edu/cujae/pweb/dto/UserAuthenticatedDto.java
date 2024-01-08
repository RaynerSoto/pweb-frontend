package cu.edu.cujae.pwebbackend.core.dto;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class UserAuthenticatedDto {
	private Long id;
	private String username;
	private String fullName;
	private String password;
	private String email;
	private String rol;
	private String token;
	
	public UserAuthenticatedDto() {
		super();
	}

	public UserAuthenticatedDto(Long id, String username, String fullName, String password, String email, String rol, String token) {
		this.id = id;
		this.username = username;
		this.fullName = fullName;
		this.password = password;
		this.email = email;
		this.rol = rol;
		this.token = token;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getStringId(){
		return String.valueOf(this.id);
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getFullName() {
		return fullName;
	}

	public void setFullName(String fullName) {
		this.fullName = fullName;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getRol() {
		return rol;
	}

	public void setRol(String rol) {
		this.rol = rol;
	}

	public List<String> getRoles(){
		return Arrays.asList(this.rol);
	}

	public String getToken() {
		return token;
	}

	public void setToken(String token) {
		this.token = token;
	}
}
