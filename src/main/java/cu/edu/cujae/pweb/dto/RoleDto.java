package cu.edu.cujae.pweb.dto;

public class RoleDto {
	private Long id;
	private String roleName;
	private String description;
	
	public RoleDto(Long id, String roleName, String description) {
		this.id = id;
		this.roleName = roleName;
		this.description = description;
	}
	
	public RoleDto() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getRoleName() {
		return roleName;
	}
	public void setRoleName(String roleName) {
		this.roleName = roleName;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
}
