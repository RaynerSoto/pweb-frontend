package cu.edu.cujae.pweb.bean;

import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;

import javax.annotation.PostConstruct;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;

import cu.edu.cujae.pweb.dto.MarcaDto;
import cu.edu.cujae.pweb.service.CarroService;
import cu.edu.cujae.pweb.service.MarcaService;
import cu.edu.cujae.pweb.utils.JsfUtils;
import org.primefaces.PrimeFaces;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import cu.edu.cujae.pweb.dto.CarroDto;

@Component
@ManagedBean
@ViewScoped
public class CarroBean {
	@Autowired
	private MarcaService marcaService;
	@Autowired
	private CarroService carroService;


	private CarroDto carro;
	private boolean estado ;
	private CarroDto carro_select;
	private ArrayList<CarroDto> listado_carros = new ArrayList<CarroDto>();
	private ArrayList<MarcaDto> listado_marcas = new ArrayList<MarcaDto>();
	private ArrayList<String> listado_nombre_marca = new ArrayList<String>();
	public CarroBean() {
	}



	public CarroDto getCarro() {
		return carro;
	}
	public CarroDto getCarro_select() {
		return carro_select;
	}
	public ArrayList<CarroDto> getListado_carros() throws SQLException, IOException {
		try {
			if (listado_carros.size() != carroService.listado_carros().size()){
				listado_carros= carroService.listado_carros();
			}
		} catch (Exception e) {
			throw new RuntimeException(e);
		}

		return listado_carros;
	}
	public ArrayList<String> getListado_nombre_marca() {
		try {
			if(listado_marcas.size() != marcaService.listado_marcas().size()){
				listado_marcas = marcaService.listado_marcas();
				for(int i=0; i<listado_marcas.size();i++){
					listado_nombre_marca.add(listado_marcas.get(i).getNombre());
				}
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return listado_nombre_marca;
	}

	public void setCarro(CarroDto carro) {
		this.carro = carro;
	}
	public void setCarro_select(CarroDto carro_select) {
		this.carro_select = carro_select;
	}
	public void setListado_carros(ArrayList<CarroDto> listado_carros) {
		this.listado_carros = listado_carros;
	}
	public void setListado_marcas(ArrayList<MarcaDto> listado_marcas) {
		this.listado_marcas = listado_marcas;
	}
	// Implementaciones
	// Se ejecuta al dar clic en Nuevo (Crea el boton)
	public void openNew(){
		this.carro_select = new CarroDto();
		estado = true;
	}

	//Modificar
	public void openForEdit(){
		this.estado = false;
        System.out.println(estado);

	}
	//Salvar
	public void SaveCarro()throws SQLException {
		if( this.carro_select.getFlotilla().trim().equalsIgnoreCase("")&&this.carro_select.getPlaca().trim().equalsIgnoreCase("")){
			System.out.println("Esto está vacío");
			JsfUtils.addMessageFromBundle(null, FacesMessage.SEVERITY_INFO, "carro_fallo_insertar");
		}else{
			if(this.estado == true){
				try{
				    carroService.insertar_datos(carro_select);
					listado_carros= carroService.listado_carros();
				    JsfUtils.addMessageFromBundle(null, FacesMessage.SEVERITY_INFO,"message_carro_insertar_correcto");//revisar erro
				    PrimeFaces.current().executeScript("PF('CarroDialog').hide()");//Este code permite cerrar el dialog cuyo id es manageUserDialog. Este identificador es el widgetVar
				    PrimeFaces.current().ajax().update("form:dt-carro");// Este code es para refrescar el componente con id dt-users que se encuentra dentro del formulario con id form
				}catch (Exception e){
					JsfUtils.addMessageFromBundle(null, FacesMessage.SEVERITY_ERROR,"message_carro_insertar_fallido");
				}
			}else{
				try {
					carroService.modificar_datos(carro_select);
                    listado_carros= carroService.listado_carros();
					JsfUtils.addMessageFromBundle(null, FacesMessage.SEVERITY_INFO,"message_carro_modificar_correcto");
					PrimeFaces.current().executeScript("PF('CarroDialog').hide()");//Este code permite cerrar el dialog cuyo id es manageUserDialog. Este identificador es el widgetVar
					PrimeFaces.current().ajax().update("form:dt-carro");// Este code es para refrescar el componente con id dt-users que se encuentra dentro del formulario con id form
				} catch (Exception e) {
					JsfUtils.addMessageFromBundle(null, FacesMessage.SEVERITY_ERROR,"message_carro_modificar_fallido");
				}
			}
		}

	}
	//Eliminar
	public void deleteCarro()throws SQLException{
		try {
			carroService.eliminar_datos(this.carro_select.getIdentificador());
			this.carro_select = null;
			listado_carros= carroService.listado_carros();
			JsfUtils.addMessageFromBundle(null, FacesMessage.SEVERITY_INFO,"carro_eliminado");
			PrimeFaces.current().ajax().update("form:dt-carro");// Este code es para refrescar el componente con id dt-users que se encuentra dentro del formulario con id form
		} catch (Exception e) {
			JsfUtils.addMessageFromBundle(null, FacesMessage.SEVERITY_INFO,"carro_no_eliminado");
		}
	}
}
