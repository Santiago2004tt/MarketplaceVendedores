package MarketplaceVendedores.model;

public class Comentario implements MuroInterface{

    private String mensaje;

    public Comentario(String mensaje) {
        this.mensaje = mensaje;
    }

    public String getMensaje() {
        return mensaje;
    }

    public void setMensaje(String mensaje) {
        this.mensaje = mensaje;
    }

    //---------------------------------------------------------------------------------------
    @Override
    public void aniadirMensaje(String mensaje) {
        if(verificarMensaje(mensaje)){
            this.mensaje = mensaje;
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
