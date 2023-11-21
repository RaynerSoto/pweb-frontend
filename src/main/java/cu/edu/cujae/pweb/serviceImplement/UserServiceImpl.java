package cu.edu.cujae.pweb.serviceImplement;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import cu.edu.cujae.pweb.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.LinkedMultiValueMap;
import org.springframework.util.MultiValueMap;
import org.springframework.web.util.UriTemplate;

import cu.edu.cujae.pweb.dto.UserDto;
import cu.edu.cujae.pweb.utils.ApiRestMapper;
import cu.edu.cujae.pweb.utils.RestService;

@Service
public class UserServiceImpl implements UserService {
	
	@Autowired
	private RestService restService;

	@Override
	public List<UserDto> getUsers(){
		List<UserDto> userList = new ArrayList<UserDto>();
	    try {
	    	MultiValueMap<String, String> params = new LinkedMultiValueMap<>();
		    ApiRestMapper<UserDto> apiRestMapper = new ApiRestMapper<>();
		    String response = (String)restService.GET("/api/v1/users", params, String.class).getBody();
		    userList = apiRestMapper.mapList(response, UserDto.class);
		} catch (IOException e) {
			e.printStackTrace();
		}
		return userList;
	}

	@Override
	public UserDto getUserById(String userId) {
		UserDto user = null;

		try {
			MultiValueMap<String, String> params = new LinkedMultiValueMap<>();
		    ApiRestMapper<UserDto> apiRestMapper = new ApiRestMapper<>();
		    
		    UriTemplate template = new UriTemplate("/api/v1/users/{userId}");
		    String uri = template.expand(userId).toString();
		    String response = (String)restService.GET(uri, params, String.class).getBody();
		    user = apiRestMapper.mapOne(response, UserDto.class);
		} catch (Exception e) {
			// TODO: handle exception
		}
		return user;
	}

	@Override
	public void createUser(UserDto user) {
		restService.POST("/api/v1/users", user, String.class).getBody();
	}

	@Override
	public void updateUser(UserDto user) {
		MultiValueMap<String, String> params = new LinkedMultiValueMap<>();
		restService.PUT("/api/v1/users", params, user, String.class).getBody();
	}

	@Override
	public void deleteUser(String userId) {
		MultiValueMap<String, String> params = new LinkedMultiValueMap<>();
		UriTemplate template = new UriTemplate("/api/v1/users/{userId}");
	    String uri = template.expand(userId).toString();
		restService.DELETE(uri, params, String.class, null).getBody();
	}
	
}
