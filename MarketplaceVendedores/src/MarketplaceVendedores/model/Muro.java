package MarketplaceVendedores.model;

import java.util.ArrayList;

public class Muro {

    private ArrayList<Comentario> listaComentarios;

    private ArrayList<Mensaje> listaMensajes;

    private ArrayList<MeGusta> listaMeGusta;

    public Muro() {
        listaComentarios = new ArrayList<>();
        listaMensajes = new ArrayList<>();
        listaMeGusta = new ArrayList<>();
    }

    public ArrayList<Comentario> getListaComentarios() {
        return listaComentarios;
    }

    public void setListaComentarios(ArrayList<Comentario> listaComentarios) {
        this.listaComentarios = listaComentarios;
    }

    public ArrayList<Mensaje> getListaMensajes() {
        return listaMensajes;
    }

    public void setListaMensajes(ArrayList<Mensaje> listaMensajes) {
        this.listaMensajes = listaMensajes;
    }

    public ArrayList<MeGusta> getListaMeGusta() {
        return listaMeGusta;
    }

    public void setListaMeGusta(ArrayList<MeGusta> listaMeGusta) {
        this.listaMeGusta = listaMeGusta;
    }
}
