package cu.edu.cujae.pweb.util;

public class ResponseEnvioUtil<T>{
    private T message_envio;

    public ResponseEnvioUtil(){}

    public ResponseEnvioUtil(T message_envio) {
        this.message_envio = message_envio;
    }

    public T getMessage_envio() {
        return message_envio;
    }

    public void setMessage_envio(T message_envio) {
        this.message_envio = message_envio;
    }
}
