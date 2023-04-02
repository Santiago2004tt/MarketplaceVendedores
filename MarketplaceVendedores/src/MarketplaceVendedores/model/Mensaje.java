package MarketplaceVendedores.model;

/**
 * clase mensaje implemento de interfase muro
 * -----------English--------------
 * Message class implemented the wall interface
 */
public class Mensaje implements MuroInterface {

    /**
     * Atributos
     * --------
     * Attributes
     */
    private String mensaje;
    private String mensajeAliado;

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
            this.mensajeAliado = "";
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
