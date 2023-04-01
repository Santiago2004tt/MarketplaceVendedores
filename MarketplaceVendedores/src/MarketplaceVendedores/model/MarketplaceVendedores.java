package MarketplaceVendedores.model;

import java.util.ArrayList;

public class MarketplaceVendedores {

    private String nombre;
    private ArrayList<Producto> listaProductos;
    private ArrayList<Vendedor> listaVendedores;
    private ArrayList<Administrador> listaAdministradores;
    private ArrayList<Cuenta> listaCuentas;

    public MarketplaceVendedores(String nombre) {
        this.nombre = nombre;
        listaVendedores = new ArrayList<Vendedor>();
        listaProductos = new ArrayList<Producto>();
        listaAdministradores = new ArrayList<Administrador>();
        listaCuentas = new ArrayList<Cuenta>();
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public ArrayList<Producto> getListaProductos() {
        return listaProductos;
    }

    public void setListaProductos(ArrayList<Producto> listaProductos) {
        this.listaProductos = listaProductos;
    }

    public ArrayList<Vendedor> getListaVendedores() {
        return listaVendedores;
    }

    public void setListaVendedores(ArrayList<Vendedor> listaVendedores) {
        this.listaVendedores = listaVendedores;
    }

    public ArrayList<Administrador> getListaAdministradores() {
        return listaAdministradores;
    }

    public void setListaAdministradores(ArrayList<Administrador> listaAdministradores) {
        this.listaAdministradores = listaAdministradores;
    }

    public ArrayList<Cuenta> getListaCuentas() {
        return listaCuentas;
    }

    public void setListaCuentas(ArrayList<Cuenta> listaCuentas) {
        this.listaCuentas = listaCuentas;
    }
}
