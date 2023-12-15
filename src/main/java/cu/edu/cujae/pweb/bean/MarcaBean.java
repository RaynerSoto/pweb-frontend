package cu.edu.cujae.pweb.bean;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import javax.faces.model.SelectItem;

import cu.edu.cujae.pweb.service.CombustibleService;
import cu.edu.cujae.pweb.service.MarcaService;
import cu.edu.cujae.pweb.util.ResponseReciboUtil;
import cu.edu.cujae.pweb.utils.JsfUtils;
import cu.edu.cujae.pweb.utils.Respuesta_Enum;
import org.primefaces.PrimeFaces;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import cu.edu.cujae.pweb.dto.MarcaDto;

@Component
@ManagedBean
@ViewScoped
public class MarcaBean {
	@Autowired
	private CombustibleService combustibleService;
	@Autowired
	private MarcaService marcaService;

	private ArrayList<MarcaDto> listado_marcas = new ArrayList<MarcaDto>();
	private boolean nuevo;
	private MarcaDto marca;
	private List<String> listado_combustibles;

	public CombustibleService getCombustibleService() {
		return combustibleService;
	}

	public List<String> getListado_combustibles() {
		return listado_combustibles;
	}

	public void setListado_combustibles2(List<String> listado_combustibles) {
		this.listado_combustibles = listado_combustibles;
	}

	public void setCombustibleService(CombustibleService combustibleService) {
		this.combustibleService = combustibleService;
	}

	public MarcaService getMarcaService() {
		return marcaService;
	}

	public void setMarcaService(MarcaService marcaService) {
		this.marcaService = marcaService;
	}

	public boolean isEstado() {
		return nuevo;
	}

	public void setEstado(boolean estado) {
		this.nuevo = estado;
	}


	private MarcaDto marca_actual;


	public MarcaBean() {
	}

	@PostConstruct
	public void init() {
		listado_marcas = new ArrayList<MarcaDto>();
		try {
			listado_marcas = marcaService.listado_marcas();
			listado_combustibles = combustibleService.listado_combustibles_nombre();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public ArrayList<MarcaDto> getListado_marcas() {
		try {
			listado_marcas = marcaService.listado_marcas();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return listado_marcas;
	}

	public void setListado_marcas(ArrayList<MarcaDto> listado_marcas) {
		this.listado_marcas = listado_marcas;
	}

	public MarcaDto getMarca_actual() {
		return marca_actual;
	}

	public void setMarca_actual(MarcaDto marca_actual) {
		this.marca_actual = marca_actual;
	}

	public MarcaDto getMarca() {
		return marca;
	}

	public void setMarca(MarcaDto marca) {
		this.marca = marca;
	}

	//Comienzo de las implementaciones
	//Crear nuevo
	public void openNew() {
		this.nuevo = true;
		this.marca_actual = new MarcaDto();
	}

	//Modificar
	public void openForEdit() {
		this.nuevo = false;
	}

	//Salvar
	public void salveMarca() {
		if (nuevo == true) {
			try {
				ResponseReciboUtil responseReciboUtil = marcaService.inserta_marca(this.marca_actual);
				if (responseReciboUtil.comparar_enum(Respuesta_Enum.Buena)) {
					JsfUtils.addMessageFromBundle(null, FacesMessage.SEVERITY_INFO, "marca_insertar_correcta");
					PrimeFaces.current().executeScript("PF('marcaDialog').hide()");//Este code permite cerrar el dialog cuyo id es manageUserDialog. Este identificador es el widgetVar
					PrimeFaces.current().ajax().update("form:dt-marcas");// Este code es para refrescar el componente con id dt-users que se encuentra dentro del formulario con id form
				} else {
					JsfUtils.addMessageFromBundle(null, FacesMessage.SEVERITY_ERROR, "error_operation");
					PrimeFaces.current().executeScript("PF('combustibleDialog').hide()");//Este code permite cerrar el dialog cuyo id es manageUserDialog. Este identificador es el widgetVar
				}
			} catch (Exception e) {
				JsfUtils.addMessageFromBundle(null, FacesMessage.SEVERITY_ERROR, "error_operation");
			}
		} else {
			try {

			} catch (Exception e) {
				e.printStackTrace();
			}
		}
	}

	//Eliminar
	public void deleteMarca() {
		try {
			ResponseReciboUtil responseReciboUtil = marcaService.eliminar_marca(this.marca_actual);
			if (responseReciboUtil.comparar_enum(Respuesta_Enum.Buena)) {
				JsfUtils.addMessageFromBundle(null, FacesMessage.SEVERITY_INFO, "marca_eliminada");
				PrimeFaces.current().executeScript("PF('marcaDialog').hide()");//Este code permite cerrar el dialog cuyo id es manageUserDialog. Este identificador es el widgetVar
				PrimeFaces.current().ajax().update("form:dt-marcas");// Este code es para refrescar el componente con id dt-users que se encuentra dentro del formulario con id form
			} else {
				JsfUtils.addMessageFromBundle(null, FacesMessage.SEVERITY_ERROR, "marca_no_eliminada");
				PrimeFaces.current().executeScript("PF('marcaDialog').hide()");//Este code permite cerrar el dialog cuyo id es manageUserDialog. Este identificador es el widgetVar
				PrimeFaces.current().ajax().update("form:dt-marcas");// Este code es para refrescar el componente con id dt-users que se encuentra dentro del formulario con id form
			}
		} catch (Exception e) {
			e.printStackTrace();
			JsfUtils.addMessageFromBundle(null, FacesMessage.SEVERITY_ERROR, "error_operation");
		}
	}
}
