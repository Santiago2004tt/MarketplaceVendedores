package MarketplaceVendedores.model;

import java.io.Serializable;

/**
 * clase comentario implemento de la interface Muro
 * ------------------English----------------------
 * comment class implemented from the Wall interface
 */
public class Comentario implements MuroInterface, Serializable {

    /**
     * Atributos
     * ---------
     * Attributes
     */
    private static final long serialVersioUID = 1L;

    private String mensaje;

    /**
     * Constructor
     * -----------
     * Builder
     * @param mensaje
     */
    public Comentario(String mensaje) {
        this.mensaje = mensaje;
    }

    /**
     * set y get de mensaje
     * ----------------------------
     * Setter and Getter the message
     * @return
     */
    public String getMensaje() {
        return mensaje;
    }

    public void setMensaje(String mensaje) {
        this.mensaje = mensaje;
    }

    //---------------------------------------------------------------------------------------//

    /**
     * Función para añadir un mensaje
     * ----------------------
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
