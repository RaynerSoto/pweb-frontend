package cu.edu.cujae.pweb.service;

import java.util.List;

import cu.edu.cujae.pweb.dto.RoleDto;

public interface RoleService {
	List<RoleDto> getRoles();
	List<RoleDto> getRolesByUser(String userId);
	RoleDto getRolesById(Long roleId);
}
