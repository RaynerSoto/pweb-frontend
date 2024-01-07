package cu.edu.cujae.pweb.bean;

import cu.edu.cujae.pweb.utils.JsfUtils;

import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;
import java.util.Locale;

@ManagedBean
@SessionScoped
public class LenguageBean {
    private Locale locale;

    public LenguageBean() {

    }

    @PostConstruct
    public void init(){
        locale = JsfUtils.getCurrentLocale();
    }

    public Locale getLocale() {
        return locale;
    }

   public String getLenguage(){
        return locale.getLanguage();
   }

   public void setLenguage(String lenguage){
        locale = new Locale(lenguage);
       FacesContext.getCurrentInstance().getViewRoot().setLocale(locale);
   }
}
