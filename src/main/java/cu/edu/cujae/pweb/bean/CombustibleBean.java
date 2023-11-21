package cu.edu.cujae.pweb.bean;

import cu.edu.cujae.pweb.dto.CombustibleDto;
import org.primefaces.PrimeFaces;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import java.util.ArrayList;

@Component
@ManagedBean
@ViewScoped
public class CombustibleBean {
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
        }
        else{

        }
    }

    //Permite eliminar un usuario
    public void deleteCombustible() {

    }

}
