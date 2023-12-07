package cu.edu.cujae.pweb.util;
import cu.edu.cujae.pweb.utils.Respuesta_Enum;

public class ResponseReciboUtil {
    private Respuesta_Enum respuestaEnum;
    private String mensaje_recibo;

    public ResponseReciboUtil() {}


    public ResponseReciboUtil(Respuesta_Enum respuestaEnum, String mensaje_recibo) {
        this.respuestaEnum = respuestaEnum;
        this.mensaje_recibo = mensaje_recibo;
    }

    public Respuesta_Enum getRespuestaEnum() {
        return respuestaEnum;
    }

    //Metodo para comparar enums
    public boolean comparar_enum(Respuesta_Enum respuestaEnum1){
        return (respuestaEnum.equals(respuestaEnum1)) ? true:false;
    }

    public void setRespuestaEnum(Respuesta_Enum respuestaEnum) {
        this.respuestaEnum = respuestaEnum;
    }

    public String getMensaje_recibo() {
        return mensaje_recibo;
    }

    public void setMensaje_recibo(String mensaje_recibo) {
        this.mensaje_recibo = mensaje_recibo;
    }
}
