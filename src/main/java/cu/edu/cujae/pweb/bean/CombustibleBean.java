package cu.edu.cujae.pweb.bean;

import cu.edu.cujae.pweb.dto.CombustibleDto;
import cu.edu.cujae.pweb.util.GoodException;
import cu.edu.cujae.pweb.service.CombustibleService;
import cu.edu.cujae.pweb.utils.JsfUtils;
import org.primefaces.PrimeFaces;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import java.util.ArrayList;

@Component
@ManagedBean
@ViewScoped
public class CombustibleBean {

    @Autowired
    private CombustibleService combustibleService;

    private CombustibleDto combustibleDto;
    private ArrayList<CombustibleDto>listado_combustibles;
    private CombustibleDto combustibleDto_seleccionado;

    public CombustibleDto getCombustibleDto() {
        return combustibleDto;
    }

    public void setCombustibleDto(CombustibleDto combustibleDto) {
        this.combustibleDto = combustibleDto;
    }

    public ArrayList<CombustibleDto> getListado_combustibles() {
        return listado_combustibles;
    }

    public void setListado_combustibles(ArrayList<CombustibleDto> listado_combustibles) {
        this.listado_combustibles = listado_combustibles;
    }

    public CombustibleDto getCombustibleDto_seleccionado() {
        return combustibleDto_seleccionado;
    }

    public void setCombustibleDto_seleccionado(CombustibleDto combustibleDto_seleccionado) {
        this.combustibleDto_seleccionado = combustibleDto_seleccionado;
    }

    //Esta anotacioon permite que se ejecute code luego de haberse ejecuta el constructor de la clase.
    @PostConstruct
    public void init() {
        listado_combustibles = new ArrayList<>();
        listado_combustibles.add(new CombustibleDto(1,"Gasolina"));
        listado_combustibles.add(new CombustibleDto(1,"Diesel"));
    }

    //Se ejecuta al dar clic en el button Nuevo//siempre asi crea el boton
    public void openNew() {
        this.combustibleDto_seleccionado = new CombustibleDto();
    }

    //Se ejecuta al dar clic en el button con el lapicito
    public void openForEdit() {

    }

    //Se ejecuta al dar clic en el button dentro del dialog para salvar o registrar al usuario
    public void saveCombustible() {
        if(this.combustibleDto_seleccionado.getNombre().trim().equalsIgnoreCase("")){
          System.out.println("Esto está vacío");
          JsfUtils.addMessageFromBundle(null, FacesMessage.SEVERITY_INFO, "combustible_fallo_insertar");
        }
        else{
            try{
                Exception exception = combustibleService.inserta_combustible(combustibleDto_seleccionado);
                if (exception instanceof GoodException){
                    JsfUtils.addMessageFromBundle(null, FacesMessage.SEVERITY_INFO, exception.getMessage());
                    PrimeFaces.current().executeScript("PF('combustibleDialog').hide()");//Este code permite cerrar el dialog cuyo id es manageUserDialog. Este identificador es el widgetVar
                    PrimeFaces.current().ajax().update("form:combustible-content");// Este code es para refrescar el componente con id dt-users que se encuentra dentro del formulario con id form
                }
                else {
                    JsfUtils.addMessageFromBundle(null, FacesMessage.SEVERITY_ERROR, exception.getMessage());
                    PrimeFaces.current().executeScript("PF('combustibleDialog').hide()");//Este code permite cerrar el dialog cuyo id es manageUserDialog. Este identificador es el widgetVar
                }
            }catch (Exception e){
                System.out.println(e.getMessage());
            }

        }
    }

    //Permite eliminar un usuario
    public void deleteCombustible() {

    }

}
