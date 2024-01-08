package cu.edu.cujae.pweb.serviceImplement;

import java.io.IOException;
import java.util.ArrayList;

import cu.edu.cujae.pweb.security.CurrentUserUtils;
import cu.edu.cujae.pweb.service.RoleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.LinkedMultiValueMap;
import org.springframework.util.MultiValueMap;

import cu.edu.cujae.pweb.utils.ApiRestMapper;
import cu.edu.cujae.pweb.utils.RestService;

@Service
public class RoleServiceImpl implements RoleService {
	
	@Autowired
	private RestService restService;

	@Override
	public ArrayList<String> getRoles(){
		ArrayList<String> roleList = new ArrayList<>();
	    try {
	    	MultiValueMap<String, String> params = new LinkedMultiValueMap<>();
		    ApiRestMapper<String> apiRestMapper = new ApiRestMapper<>();
		    String response = (String)restService.GET("/api/v1/roles/", params, String.class, CurrentUserUtils.getTokenBearer()).getBody();
		    roleList = (ArrayList<String>) apiRestMapper.mapList(response, String.class);
		} catch (IOException e) {
			e.printStackTrace();
		}
		return roleList;
	}
}
