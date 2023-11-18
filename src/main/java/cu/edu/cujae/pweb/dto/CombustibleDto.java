package cu.edu.cujae.pwebbackend.core.dto;

/**
 * @author Rayner
 * @version 1.0
 */
public class CombustibleDto {
    private long id;
    private String nombre;

    public CombustibleDto() {}

    public CombustibleDto(long id, String nombre) {
        this.id = id;
        this.nombre = nombre;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }
}
