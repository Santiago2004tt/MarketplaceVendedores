package MarketplaceVendedores.model;

import java.util.ArrayList;

/**
 * clase muro
 * --English--
 * Wall class
 */
public class Muro {

    /**
     * listas de comentarios, mensajes y me gusta
     * ------------------------------------------
     * list the comments, messages and i likes
     */
    private ArrayList<Comentario> listaComentarios;

    private ArrayList<Mensaje> listaMensajes;

    private ArrayList<MeGusta> listaMeGusta;

    /**
     * Constructor
     * -----------
     * Builder
     */
    public Muro() {
        listaComentarios = new ArrayList<>();
        listaMensajes = new ArrayList<>();
        listaMeGusta = new ArrayList<>();
    }

    /**
     * set y get de lista comentarios
     * ------------------------------
     * getter and Setter the list comments
     * @return
     */
    public ArrayList<Comentario> getListaComentarios() {
        return listaComentarios;
    }

    public void setListaComentarios(ArrayList<Comentario> listaComentarios) {
        this.listaComentarios = listaComentarios;
    }

    /**
     * set y get de lista mensajes
     * ------------------------------
     * getter and Setter the list messages
     * @return
     */
    public ArrayList<Mensaje> getListaMensajes() {
        return listaMensajes;
    }

    public void setListaMensajes(ArrayList<Mensaje> listaMensajes) {
        this.listaMensajes = listaMensajes;
    }

    /**
     * set y get de lista me gusta
     * ------------------------------
     * getter and Setter the list i like
     * @return
     */
    public ArrayList<MeGusta> getListaMeGusta() {
        return listaMeGusta;
    }

    public void setListaMeGusta(ArrayList<MeGusta> listaMeGusta) {
        this.listaMeGusta = listaMeGusta;
    }
}
