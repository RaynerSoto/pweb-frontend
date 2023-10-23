package cu.edu.cujae.pweb.bean;

import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;
import javax.servlet.http.HttpServletRequest;

@ManagedBean
public class UserBean {
	private String name;
	private String password;
	
	public UserBean() {}
	
	public String getName() {
		return name;
	}
	public String getPassword() {
		return password;
	}
	public void setName(String name) {
		this.name = name;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	
    public void addMessage(FacesMessage.Severity severity, String summary, String detail) {
        FacesContext.getCurrentInstance().
                addMessage(null, new FacesMessage(severity, summary, detail));
    }
    
    public void showError() {
        addMessage(FacesMessage.SEVERITY_ERROR, "Error Message", "Message Content");
    }
	
	protected HttpServletRequest getRequest() {
	    return (HttpServletRequest) getFacesContext().getExternalContext().getRequest();
	}
	
	protected FacesContext getFacesContext() {
	    return FacesContext.getCurrentInstance();
	}
    
	public String login() {
		System.out.println("Comienzo");
		if(name.length() <= 5) {		
			System.out.print("Conseguido");
			showError();
			return "failure";
		}
		else if(password.length() <= 5) {
			System.out.print("Conseguido");
			showError();
			return "failure";
		}
		else {
			try {
				getFacesContext().getExternalContext().redirect(getRequest().getContextPath() +
					    "/pages/web_principales/principal.jsf");
			} catch (Exception e) {
				e.printStackTrace();
			}
			return "success";
		}
	}
	
	
}
