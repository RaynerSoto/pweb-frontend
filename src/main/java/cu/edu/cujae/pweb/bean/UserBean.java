package cu.edu.cujae.pweb.bean;

import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.context.FacesContext;
import javax.faces.view.ViewScoped;
import javax.servlet.RequestDispatcher;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Component;

import cu.edu.cujae.pweb.dto.UserAuthenticatedDto;
import cu.edu.cujae.pweb.security.CurrentUserUtils;
import cu.edu.cujae.pweb.security.UserPrincipal;
import cu.edu.cujae.pweb.service.AuthService;
import cu.edu.cujae.pweb.utils.JsfUtils;

@Component
@ManagedBean
@ViewScoped
public class UserBean {
	
	private String username;
	private String password;
	
	@Autowired
	private AuthService authService;
	
	public UserBean() {
		// TODO Auto-generated constructor stub
	}
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	
	public String login() {
		
		try {
			UserAuthenticatedDto userAuthenticated = authService.login(username, password);
			UserDetails userDetails = UserPrincipal.create(userAuthenticated);
			UsernamePasswordAuthenticationToken authentication = new UsernamePasswordAuthenticationToken(userDetails, null, userDetails.getAuthorities());
	        SecurityContextHolder.getContext().setAuthentication(authentication);
			System.out.println("Usuario autentificado");
		} catch (Exception e) {
	        JsfUtils.addMessageFromBundle("securityMessages", FacesMessage.SEVERITY_INFO, "message_invalid_credentials");
			System.out.println("Credenciales no válidas");
	        return null;
		}
		return "login";
	}

	public String logout() {
		return dispatchToUrl("/logout");
	}

	public String getUserLogued() {
		return CurrentUserUtils.getFullName();
	}

	private String dispatchToUrl(String url) {
		FacesContext facesContext = FacesContext.getCurrentInstance();
		HttpServletRequest request = (HttpServletRequest) facesContext.getExternalContext().getRequest();
		HttpServletResponse response = (HttpServletResponse) facesContext.getExternalContext().getResponse();
		RequestDispatcher dispatcher = request.getRequestDispatcher(url);
		try {
			dispatcher.forward(request, response);
			facesContext.responseComplete();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}
}
