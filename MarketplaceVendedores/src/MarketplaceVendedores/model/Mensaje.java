package MarketplaceVendedores.model;

import java.io.Serializable;

/**
 * clase mensaje implemento de interfase muro
 * -----------English--------------
 * Message class implemented the wall interface
 */
public class Mensaje implements MuroInterface, Serializable {

    /**
     * Atributos
     * --------
     * Attributes
     */
    private static final long serialVersioUID = 1L;

    private String mensaje;

    public Mensaje(String mensaje) {
        this.mensaje = mensaje;
    }

    public Mensaje(){
    }

    public String getMensaje() {
        return mensaje;
    }

    public void setMensaje(String mensaje) {
        this.mensaje = mensaje;
    }

    /**
     * Función para añadir un mensaje
     * ------------------------------
     * function for add in message
     * @param mensaje
     */
    @Override
    public void aniadirMensaje(String mensaje) {
        if(verificarMensaje(mensaje)){
            this.mensaje = mensaje;

        }
    }

    /**
     * Función para verificar el mensaje
     * ---------------------------------
     * function for verify the message
     * @param mensaje
     * @return
     */
    @Override
    public boolean verificarMensaje(String mensaje) {

        if(mensaje.equals("")){
            return false;
        }
        return true;
    }

}
