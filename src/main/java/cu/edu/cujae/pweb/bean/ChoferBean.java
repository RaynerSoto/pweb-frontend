package cu.edu.cujae.pweb.bean;

import cu.edu.cujae.pweb.dto.ChoferDto;
import cu.edu.cujae.pweb.dto.CombustibleDto;
import cu.edu.cujae.pweb.dto.MarcaDto;
import cu.edu.cujae.pweb.service.ChoferesService;
import cu.edu.cujae.pweb.service.MarcaService;
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

    private ArrayList<ChoferDto>  listado_choferes = new ArrayList<>();
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
        try{
            if (listado_choferes.size() != choferesService.listado_choferes_cubre().size())
                listado_choferes = choferesService.listado_choferes_cubre();
        }catch (Exception e){
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
        estado = false;
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
}
