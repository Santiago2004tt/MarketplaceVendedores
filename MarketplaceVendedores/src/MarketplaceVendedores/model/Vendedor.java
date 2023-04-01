package MarketplaceVendedores.model;
import java.util.ArrayList;
import java.util.Objects;

public class Vendedor{

    private Vendedor[] listaVendedoresAliados;
    private Muro muro;
    private ArrayList<Producto> listaProductos;
    private ArrayList<Vendedor> listaSolicitudes;
    private ArrayList<Vendedor> listaRecomendados;
    private String nombre;
    private String apellido;
    private String cedula;
    private String direccion;
    private Cuenta cuenta;

    public Vendedor(Muro muro, String nombre, String apellido, String cedula, String direccion, Cuenta cuenta) {
        this.muro = muro;
        this.nombre = nombre;
        this.apellido = apellido;
        this.cedula = cedula;
        this.direccion = direccion;
        this.cuenta = cuenta;
        listaVendedoresAliados  = new Vendedor[10];
        listaProductos = new ArrayList<Producto>();
        listaSolicitudes = new ArrayList<Vendedor>();
        listaRecomendados= new ArrayList<Vendedor>();
        this.muro = muro;
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

    public Muro getMuro() {
        return muro;
    }

    public void setMuro(Muro muro) {
        this.muro = muro;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getApellido() {
        return apellido;
    }

    public void setApellido(String apellido) {
        this.apellido = apellido;
    }

    public String getCedula() {
        return cedula;
    }

    public void setCedula(String cedula) {
        this.cedula = cedula;
    }

    public String getDireccion() {
        return direccion;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    public Cuenta getCuenta() {
        return cuenta;
    }

    public void setCuenta(Cuenta cuenta) {
        this.cuenta = cuenta;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Vendedor vendedor = (Vendedor) o;
        return Objects.equals(cedula, vendedor.cedula);
    }

    @Override
    public int hashCode() {
        return Objects.hash(cedula);
    }
}
