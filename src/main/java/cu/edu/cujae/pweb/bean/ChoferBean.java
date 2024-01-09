package cu.edu.cujae.pweb.bean;

import cu.edu.cujae.pweb.dto.ChoferDto;
import cu.edu.cujae.pweb.dto.CombustibleDto;
import cu.edu.cujae.pweb.dto.MarcaDto;
import cu.edu.cujae.pweb.service.ChoferesService;
import cu.edu.cujae.pweb.service.MarcaService;
import cu.edu.cujae.pweb.service.ProvinciasService;
import cu.edu.cujae.pweb.util.ResponseEnvioChofer;
import cu.edu.cujae.pweb.util.ResponseReciboUtil;
import cu.edu.cujae.pweb.utils.JsfUtils;
import cu.edu.cujae.pweb.utils.Respuesta_Enum;
import org.primefaces.PrimeFaces;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import java.util.ArrayList;
import java.util.List;

@Component
@ManagedBean
@ViewScoped
public class ChoferBean {
    @Autowired
    private ChoferesService choferesService;
    @Autowired
    private ProvinciasService provinciasService;
    @Autowired
    private MarcaService marcaService;

    private ArrayList<ChoferDto> listado_choferes = new ArrayList<>();
    private ArrayList<String> listado_provincias = new ArrayList<>();
    private ArrayList<String> listado_marcas = new ArrayList<>();
    private ResponseEnvioChofer responseEnvioChofer = new ResponseEnvioChofer();
    private boolean estado;
    private ChoferDto chofer_actual;

    public ChoferBean() {
    }

    public ChoferesService getChoferesService() {
        return choferesService;
    }

    public void setChoferesService(ChoferesService choferesService) {
        this.choferesService = choferesService;
    }

    public ArrayList<ChoferDto> getListado_choferes() {
        try {
            if (listado_choferes.size() != choferesService.listado_choferes_cubre().size())
                listado_choferes = choferesService.listado_choferes_cubre();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return listado_choferes;
    }

    public void openNew() {
        this.chofer_actual = new ChoferDto();
        estado = true;
    }

    //Se ejecuta al dar clic en el button con el lapicito
    public void openForEdit() {
        responseEnvioChofer.setCI(this.chofer_actual.getCi());
        estado = false;
    }

    public void eliminar_chofer() {
        try {
            ResponseReciboUtil responseReciboUtil = choferesService.eliminar_chofer(this.chofer_actual.getCi());
            if (responseReciboUtil.comparar_enum(Respuesta_Enum.Buena)){
                try {
                    listado_choferes = choferesService.listado_choferes_cubre();
                    JsfUtils.addMessageFromBundle(null, FacesMessage.SEVERITY_INFO,"chofer_elimiando");
                }catch (Exception e){
                    e.printStackTrace();
                    JsfUtils.addMessageFromBundle(null, FacesMessage.SEVERITY_ERROR,"error_operation");
                }
                PrimeFaces.current().executeScript("PF('choferDialog').hide()");//Este code permite cerrar el dialog cuyo id es manageUserDialog. Este identificador es el widgetVar
                PrimeFaces.current().ajax().update("form:dt-chofer");// Este code es para refrescar el componente con id dt-users que se encuentra dentro del formulario con id form
            }
            else {
                JsfUtils.addMessageFromBundle(null, FacesMessage.SEVERITY_ERROR,"recurso_utilizado");
                PrimeFaces.current().executeScript("PF('choferDialog').hide()");//Este code permite cerrar el dialog cuyo id es manageUserDialog. Este identificador es el widgetVar
                PrimeFaces.current().ajax().update("form:dt-chofer");// Este code es para refrescar el componente con id dt-users que se encuentra dentro del formulario con id form
            }
        }catch (Exception e){
            e.printStackTrace();
            JsfUtils.addMessageFromBundle(null, FacesMessage.SEVERITY_ERROR,"error_operation");
        }
    }


    public void setListado_choferes(ArrayList<ChoferDto> listado_choferes) {
        this.listado_choferes = listado_choferes;
    }

    public ChoferDto getChofer_actual() {
        return chofer_actual;
    }

    public void setChofer_actual(ChoferDto chofer_actual) {
        this.chofer_actual = chofer_actual;
    }

    public boolean isEstado() {
        return estado;
    }

    public void setEstado(boolean estado) {
        this.estado = estado;
    }

    public ArrayList<String> getListado_provincias() {
        try {
            if (listado_provincias.size() != provinciasService.listado_nombre().size()){
                listado_provincias = provinciasService.listado_nombre();
            }
        }catch (Exception e){
            e.printStackTrace();
        }
        return listado_provincias;
    }

    public void setListado_provincias(ArrayList<String> listado_provincias) {
        this.listado_provincias = listado_provincias;
    }

    public ArrayList<String> getListado_marcas() {
        try {
            if (this.listado_marcas.size() != marcaService.listado_marcas_nombre().size()){
                listado_marcas = marcaService.listado_marcas_nombre();
            }
        }catch (Exception e){
            e.printStackTrace();
        }
        return listado_marcas;
    }

    public void setListado_marcas(ArrayList<String> listado_marcas) {
        this.listado_marcas = listado_marcas;
    }

    public void salveChofer(){
        if (this.chofer_actual.getCi().length() != 11){
            JsfUtils.addMessageFromBundle(null, FacesMessage.SEVERITY_ERROR,"chofer_ci");
        }
        if (estado == true){
            try {
                ResponseReciboUtil responseReciboUtil = choferesService.inserta_chofer(this.chofer_actual);
                if (responseReciboUtil.comparar_enum(Respuesta_Enum.Buena)){
                    JsfUtils.addMessageFromBundle(null, FacesMessage.SEVERITY_INFO,"chofer_insertado");
                    PrimeFaces.current().executeScript("PF('choferDialog').hide()");//Este code permite cerrar el dialog cuyo id es manageUserDialog. Este identificador es el widgetVar
                    PrimeFaces.current().ajax().update("form:dt-chofer");
                }
            }catch (Exception e){
                e.printStackTrace();
                JsfUtils.addMessageFromBundle(null, FacesMessage.SEVERITY_ERROR,"error_operation");
            }
        }else{
            try {
                this.responseEnvioChofer.setChoferDto(this.chofer_actual);
                ResponseReciboUtil responseReciboUtil = choferesService.modificar_chofer(responseEnvioChofer);
                if (responseReciboUtil.comparar_enum(Respuesta_Enum.Buena)){
                    JsfUtils.addMessageFromBundle(null, FacesMessage.SEVERITY_INFO,"chofer_modificado");
                    PrimeFaces.current().executeScript("PF('choferDialog').hide()");//Este code permite cerrar el dialog cuyo id es manageUserDialog. Este identificador es el widgetVar
                    PrimeFaces.current().ajax().update("form:dt-chofer");
                }
            }catch (Exception e){
                e.printStackTrace();
                JsfUtils.addMessageFromBundle(null, FacesMessage.SEVERITY_ERROR,"error_operation");
            }
        }
    }
}
