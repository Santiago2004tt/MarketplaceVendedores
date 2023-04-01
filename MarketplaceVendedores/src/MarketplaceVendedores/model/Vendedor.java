package MarketplaceVendedores.model;

import jdk.incubator.vector.VectorMask;

import java.util.ArrayList;

public class Vendedor extends Usuario {

    private Vendedor[] listaVendedoresAliados;

    private ArrayList<Producto> listaProductos;
    private ArrayList<Vendedor> listaSolicitudes;
    private ArrayList<Vendedor> listaRecomendados;


    public Vendedor(String nombre, String apellido, String cedula, String direccion, Cuenta cuenta) {
        super(nombre, apellido, cedula, direccion, cuenta);
        listaVendedoresAliados  = new Vendedor[10];
        listaProductos = new ArrayList<Producto>();
        listaSolicitudes = new ArrayList<Vendedor>();
        listaRecomendados= new ArrayList<Vendedor>();
    }

    public Vendedor() {
        listaVendedoresAliados = new Vendedor[10];
        listaProductos = new ArrayList<Producto>();
        listaSolicitudes = new ArrayList<Vendedor>();
        listaRecomendados= new ArrayList<Vendedor>();
    }

    public Vendedor[] getListaVendedoresAliados() {
        return listaVendedoresAliados;
    }

    public void setListaVendedoresAliados(Vendedor[] listaVendedoresAliados) {
        this.listaVendedoresAliados = listaVendedoresAliados;
    }

    public ArrayList<Producto> getListaProductos() {
        return listaProductos;
    }

    public void setListaProductos(ArrayList<Producto> listaProductos) {
        this.listaProductos = listaProductos;
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
