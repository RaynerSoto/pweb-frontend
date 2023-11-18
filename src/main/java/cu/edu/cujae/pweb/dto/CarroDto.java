package cu.edu.cujae.pwebbackend.core.dto;

public class CarroDto {
    private String flotilla;
    private String placa;
    private long identificador;
    private String marca;

    public CarroDto(String flotilla, String placa, long identificador, String id_marca) {
        super();
        this.flotilla = flotilla;
        this.placa = placa;
        this.identificador = identificador;
        this.marca = id_marca;
    }

    public CarroDto() {

    }

    public String getFlotilla() {
        return flotilla;
    }
    public String getPlaca() {
        return placa;
    }
    public long getIdentificador() {
        return identificador;
    }
    public String getId_marca() {
        return marca;
    }
    public void setFlotilla(String flotilla) {
        this.flotilla = flotilla;
    }
    public void setPlaca(String placa) {
        this.placa = placa;
    }
    public void setIdentificador(long identificador) {
        this.identificador = identificador;
    }
    public void setId_marca(String id_marca) {
        this.marca = id_marca;
    }


}
