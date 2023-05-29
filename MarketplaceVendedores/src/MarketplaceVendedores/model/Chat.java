package MarketplaceVendedores.model;

import java.io.Serializable;
import java.util.ArrayList;

public class Chat implements Serializable {

    private static final long serialVersioUID = 1L;
    private String id;
    private ArrayList<Mensaje> listaEnviado;

    public Chat(String id) {
        this.id = id;
        this.listaEnviado = new ArrayList<>();
    }

    public Chat(){
        this.listaEnviado = new ArrayList<>();
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public ArrayList<Mensaje> getListaEnviado() {
        return listaEnviado;
    }

    public void setListaEnviado(ArrayList<Mensaje> listaEnviado) {
        this.listaEnviado = listaEnviado;
    }

}
