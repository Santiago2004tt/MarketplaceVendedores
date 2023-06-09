package MarketplaceVendedores.model;

import java.io.Serializable;
import java.util.ArrayList;

/**
 * clase muro
 * --English--
 * Wall class
 */
public class Muro implements Serializable {

    /**
     * listas de comentarios, mensajes y me gusta
     * ------------------------------------------
     * list the comments, messages and i likes
     */
    private static final long serialVersioUID = 1L;
    private ArrayList<Comentario> listaComentarios;

    private ArrayList<Mensaje> listaMensajes;

    private ArrayList<Vendedor> listaMeGusta;

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
    public ArrayList<Vendedor> getListaMeGusta() {
        return listaMeGusta;
    }

    public void setListaMeGusta(ArrayList<Vendedor> listaMeGusta) {
        this.listaMeGusta = listaMeGusta;
    }


}
