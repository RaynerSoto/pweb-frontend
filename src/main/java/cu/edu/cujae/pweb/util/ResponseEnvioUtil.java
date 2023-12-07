package cu.edu.cujae.pweb.util;

public class ResponseEnvioUtil {
    private String message_envio;

    public ResponseEnvioUtil(String message_envio) {
        this.message_envio = message_envio;
    }

    public String getMessage_envio() {
        return message_envio;
    }

    public void setMessage_envio(String message_envio) {
        this.message_envio = message_envio;
    }
}
