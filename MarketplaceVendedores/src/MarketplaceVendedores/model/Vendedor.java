package MarketplaceVendedores.model;

import java.util.ArrayList;

public class Vendedor extends Usuario {

    private ArrayList<Vendedor> listaVendedoresAliados;

    private ArrayList<Producto> listaProductos;

    private  ArrayList<Comentario> listaComentarios;

    private ArrayList<Mensaje> listaMensajes;

    private ArrayList<MeGusta> listaMeGusta;
    private ArrayList<Vendedor> listaSolicitudes;
    private ArrayList<Vendedor> listaRecomendados;


    public Vendedor(String nombre, String apellido, String cedula, String direccion, Cuenta cuenta) {
        super(nombre, apellido, cedula, direccion, cuenta);
        listaVendedoresAliados = new ArrayList<Vendedor>();
        listaProductos = new ArrayList<Producto>();
        listaMeGusta = new ArrayList<MeGusta>();
        listaSolicitudes = new ArrayList<Vendedor>();
        listaComentarios = new ArrayList<Comentario>();
        listaRecomendados= new ArrayList<Vendedor>();
        listaMensajes = new ArrayList<Mensaje>();
    }

    public Vendedor() {
    }

    public ArrayList<Vendedor> getListaVendedoresAliados() {
        return listaVendedoresAliados;
    }

    public void setListaVendedoresAliados(ArrayList<Vendedor> listaVendedoresAliados) {
        this.listaVendedoresAliados = listaVendedoresAliados;
    }

    public ArrayList<Producto> getListaProductos() {
        return listaProductos;
    }

    public void setListaProductos(ArrayList<Producto> listaProductos) {
        this.listaProductos = listaProductos;
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

    public ArrayList<Vendedor> getListaSolicitudes() {
        return listaSolicitudes;
    }

    public void setListaSolicitudes(ArrayList<Vendedor> listaSolicitudes) {
        this.listaSolicitudes = listaSolicitudes;
    }

    public ArrayList<Vendedor> getListaRecomendados() {
        return listaRecomendados;
    }

    public void setListaRecomendados(ArrayList<Vendedor> listaRecomendados) {
        this.listaRecomendados = listaRecomendados;
    }

}
