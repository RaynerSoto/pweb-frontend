package cu.edu.cujae.pweb.bean;

import cu.edu.cujae.pweb.dto.CombustibleDto;
import cu.edu.cujae.pweb.service.CombustibleService;

import cu.edu.cujae.pweb.util.ResponseReciboUtil;
import cu.edu.cujae.pweb.utils.JsfUtils;
import cu.edu.cujae.pweb.utils.Respuesta_Enum;
import org.primefaces.PrimeFaces;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;
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
    private boolean estado ;
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
        try {
            if (listado_combustibles.size() != combustibleService.listado_combustibles().size()){
                listado_combustibles = combustibleService.listado_combustibles();
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
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
    @PreDestroy
    public void init() {
        listado_combustibles = new ArrayList<>();
        try{
            listado_combustibles = combustibleService.listado_combustibles();
        }catch (Exception e){
            JsfUtils.addMessageFromBundle(null, FacesMessage.SEVERITY_ERROR, "cargar_mala");
            e.printStackTrace();
        }
    }

    //Se ejecuta al dar clic en el button Nuevo//siempre asi crea el boton
    public void openNew() {
        this.combustibleDto_seleccionado = new CombustibleDto();
        estado = true;
    }

    //Se ejecuta al dar clic en el button con el lapicito
    public void openForEdit() {
        estado = false;
    }

    //Se ejecuta al dar clic en el button dentro del dialog para salvar o registrar al usuario
    public void saveCombustible() {
        if(this.combustibleDto_seleccionado.getNombre().trim().equalsIgnoreCase("")){
          System.out.println("Esto está vacío");
          JsfUtils.addMessageFromBundle(null, FacesMessage.SEVERITY_INFO, "combustible_fallo_insertar");
        }
        else{
            if (this.estado == true){
                try{
                    ResponseReciboUtil responseReciboUtil = combustibleService.inserta_combustible(combustibleDto_seleccionado);
                    if (responseReciboUtil.comparar_enum(Respuesta_Enum.Buena)){
                        JsfUtils.addMessageFromBundle(null, FacesMessage.SEVERITY_INFO,"combustible_bien_insertar");
                        PrimeFaces.current().executeScript("PF('combustibleDialog').hide()");//Este code permite cerrar el dialog cuyo id es manageUserDialog. Este identificador es el widgetVar
                        PrimeFaces.current().ajax().update("form:dt-combustibles");// Este code es para refrescar el componente con id dt-users que se encuentra dentro del formulario con id form
                    }
                    else {
                        JsfUtils.addMessageFromBundle(null, FacesMessage.SEVERITY_ERROR, "combustible_fallo_insertar");
                        PrimeFaces.current().executeScript("PF('combustibleDialog').hide()");//Este code permite cerrar el dialog cuyo id es manageUserDialog. Este identificador es el widgetVar
                    }
                }catch (Exception e){
                    JsfUtils.addMessageFromBundle(null, FacesMessage.SEVERITY_ERROR,"error_operation");
                }
            }
            else {
                try {
                    ResponseReciboUtil responseReciboUtil = combustibleService.modificar_combustible(combustibleDto_seleccionado);
                    PrimeFaces.current().executeScript("PF('combustibleDialog').hide()");//Este code permite cerrar el dialog cuyo id es manageUserDialog. Este identificador es el widgetVar
                    PrimeFaces.current().ajax().update("form:dt-combustibles");// Este code es para refrescar el componente con id dt-users que se encuentra dentro del formulario con id form
                }catch (Exception e){
                    JsfUtils.addMessageFromBundle(null, FacesMessage.SEVERITY_ERROR,"error_operation");
                }
            }
        }
    }

    //Permite eliminar un usuario
    public void deleteCombustible() {
        try {
            ResponseReciboUtil responseReciboUtil = combustibleService.eliminar_combustible(combustibleDto_seleccionado);
            if (responseReciboUtil.comparar_enum(Respuesta_Enum.Buena)){
                try {
                    listado_combustibles = combustibleService.listado_combustibles();
                }catch (Exception e){
                    JsfUtils.addMessageFromBundle(null, FacesMessage.SEVERITY_ERROR,"error_operation");
                }
                JsfUtils.addMessageFromBundle(null, FacesMessage.SEVERITY_INFO,"combustible_eliminado");
                PrimeFaces.current().executeScript("PF('combustibleDialog').hide()");//Este code permite cerrar el dialog cuyo id es manageUserDialog. Este identificador es el widgetVar
                PrimeFaces.current().ajax().update("form:dt-combustibles");// Este code es para refrescar el componente con id dt-users que se encuentra dentro del formulario con id form
            }
            else {
                JsfUtils.addMessageFromBundle(null, FacesMessage.SEVERITY_ERROR,"combustible_no_eliminado");
                PrimeFaces.current().executeScript("PF('combustibleDialog').hide()");//Este code permite cerrar el dialog cuyo id es manageUserDialog. Este identificador es el widgetVar
                PrimeFaces.current().ajax().update("form:dt-combustibles");// Este code es para refrescar el componente con id dt-users que se encuentra dentro del formulario con id form
            }
        }catch (Exception e){
            e.printStackTrace();
            JsfUtils.addMessageFromBundle(null, FacesMessage.SEVERITY_ERROR,"error_operation");
        }
    }
}
