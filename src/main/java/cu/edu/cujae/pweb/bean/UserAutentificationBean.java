package cu.edu.cujae.pweb.bean;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;

@ManagedBean
@SessionScoped
public class UserAutentificationBean {
	private long id;
	private String nombre;
	private String password;
	private String email;
	private String alias;
	
	
	
	public UserAutentificationBean() {}

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

	public String getAlias() {
		return alias;
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

	public void setAlias(String alias) {
		this.alias = alias;
	}
	
	
	
	
	
}
