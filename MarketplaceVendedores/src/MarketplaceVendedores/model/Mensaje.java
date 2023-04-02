package MarketplaceVendedores.model;

public class Mensaje implements MuroInterface {

    private String mensaje;
    private String mensajeAliado;

    @Override
    public void aniadirMensaje(String mensaje) {
        if(verificarMensaje(mensaje)){
            this.mensaje = mensaje;
            this.mensajeAliado = "";
        }
    }

    @Override
    public boolean verificarMensaje(String mensaje) {

        if(mensaje.equals("")){
            return false;
        }
        return true;
    }

}
