package cu.edu.cujae.pweb.bean;


import cu.edu.cujae.pweb.dto.Hoja_de_rutaDto;
import cu.edu.cujae.pweb.service.HojadeRutaService;
import cu.edu.cujae.pweb.utils.JsfUtils;
import org.primefaces.PrimeFaces;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import java.io.IOException;
import java.sql.Date;
import java.sql.SQLException;
import java.util.ArrayList;

@Component
@ManagedBean
@ViewScoped
public class HojaderutaBean {
    @Autowired
    private HojadeRutaService hojadeRutaService;
    private boolean estado;
    private Hoja_de_rutaDto hojaderuta_select;
    private Hoja_de_rutaDto hojaderuta;
    private ArrayList<Hoja_de_rutaDto> listado_rutas;
    private java.util.Date date = new java.util.Date();


    public HojaderutaBean() {

    }

    @PostConstruct
    public void init() throws Exception{
        listado_rutas = new ArrayList<Hoja_de_rutaDto>();
        try{
            listado_rutas = hojadeRutaService.cargar_hoja_de_ruta();
        } catch (Exception e) {
            JsfUtils.addMessageFromBundle(null, FacesMessage.SEVERITY_ERROR, "cargar_mala");
            e.printStackTrace();
        }

    }
    public HojadeRutaService getHojadeRutaService() {
        return hojadeRutaService;
    }

    public void setHojadeRutaService(HojadeRutaService hojadeRutaService) {
        this.hojadeRutaService = hojadeRutaService;
    }

    public boolean isEstado() {
        return estado;
    }

    public void setEstado(boolean estado) {
        this.estado = estado;
    }

    public Hoja_de_rutaDto getHojaderuta_select() {
        return hojaderuta_select;
    }

    public void setHojaderuta_select(Hoja_de_rutaDto hojaderuta_select) {
        this.hojaderuta_select = hojaderuta_select;
    }

    public Hoja_de_rutaDto getHojaderuta() {
        return hojaderuta;
    }

    public void setHojaderuta(Hoja_de_rutaDto hojaderuta) {
        this.hojaderuta = hojaderuta;
    }

    public ArrayList<Hoja_de_rutaDto> getListado_rutas() throws SQLException, IOException {
        if (listado_rutas.size() != hojadeRutaService.cargar_hoja_de_ruta().size()){
            listado_rutas= hojadeRutaService.cargar_hoja_de_ruta();
        }

        return listado_rutas;
    }

    public void setListado_rutas(ArrayList<Hoja_de_rutaDto> listado_rutas) {
        this.listado_rutas = listado_rutas;
    }


    //Implementacion
    public void openNew(){
        this.hojaderuta_select = new Hoja_de_rutaDto();
        estado = true;

    }

    public void openForEdit(){
        estado = false;
    }

    public void SaveRuta() throws InterruptedException {
        if(this.hojaderuta_select.getId_carro().trim().equalsIgnoreCase("")&&this.hojaderuta_select.getCi().trim().equalsIgnoreCase("")){
            System.out.println("Esto está vacío");
            JsfUtils.addMessageFromBundle(null, FacesMessage.SEVERITY_INFO, "carro_fallo_insertar");
        }else{
            if(this.estado == true){
                try{
                    fechas(hojaderuta_select);
                    hojadeRutaService.insertar_hoja_de_ruta(hojaderuta_select);
                    listado_rutas= hojadeRutaService.cargar_hoja_de_ruta();
                    JsfUtils.addMessageFromBundle(null, FacesMessage.SEVERITY_INFO,"message_ruta_insertar_correcto");//revisar erro
                    PrimeFaces.current().executeScript("PF('hojaderutaDialog').hide()");//Este code permite cerrar el dialog cuyo id es manageUserDialog. Este identificador es el widgetVar
                    PrimeFaces.current().ajax().update("form:dt-hojaderuta");// Este code es para refrescar el componente con id dt-users que se encuentra dentro del formulario con id form
                }catch (Exception e){
                    JsfUtils.addMessageFromBundle(null, FacesMessage.SEVERITY_ERROR,"message_ruta_insertar_fallido");
                }
            }else{
                try {
                    fechas(hojaderuta_select);
                    hojadeRutaService.modificar(hojaderuta_select);
                    JsfUtils.addMessageFromBundle(null, FacesMessage.SEVERITY_INFO,"message_ruta_modificar_correcto");
                    PrimeFaces.current().executeScript("PF('hojaderutaDialog').hide()");//Este code permite cerrar el dialog cuyo id es manageUserDialog. Este identificador es el widgetVar
                    PrimeFaces.current().ajax().update("form:dt-hojaderuta");// Este code es para refrescar el componente con id dt-users que se encuentra dentro del formulario con id form
                } catch (Exception e) {
                    JsfUtils.addMessageFromBundle(null, FacesMessage.SEVERITY_ERROR,"message_ruta_modificar_fallido");
                }
            }
        }

    }

    public void deleteRuta(){
        try {
            hojadeRutaService.eliminar(this.hojaderuta_select.getIdentificador());
            this.hojaderuta_select = null;
            listado_rutas= hojadeRutaService.cargar_hoja_de_ruta();
            JsfUtils.addMessageFromBundle(null, FacesMessage.SEVERITY_INFO,"ruta_eliminado");
            PrimeFaces.current().ajax().update("form:dt-hojaderuta");// Este code es para refrescar el componente con id dt-users que se encuentra dentro del formulario con id form
        } catch (Exception e) {
            JsfUtils.addMessageFromBundle(null, FacesMessage.SEVERITY_INFO,"ruta_no_eliminado");
            e.printStackTrace();
        }
    }

    public void fechas(Hoja_de_rutaDto hojaderuta){
        java.sql.Date fecha_conv = new java.sql.Date(hojaderuta.getDate().getTime());
        hojaderuta.setFecha(fecha_conv);
    }
}
