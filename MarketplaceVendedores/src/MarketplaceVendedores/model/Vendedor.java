package MarketplaceVendedores.model;
import java.util.ArrayList;
import java.util.Objects;

/**
 * clase vendedor
 * ----English----
 *  Seller class
 */
public class Vendedor{

    /**
     * atributos
     * ---------
     * Attributes
     */
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

    /**
     * Constructor
     * ----------
     * Builder
     * @param muro
     * @param nombre
     * @param apellido
     * @param cedula
     * @param direccion
     * @param cuenta
     */
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

    /**
     * Constructor vacío
     * ----------------
     * Void builder
     */
    public Vendedor() {
        listaVendedoresAliados = new Vendedor[10];
        listaProductos = new ArrayList<Producto>();
        listaSolicitudes = new ArrayList<Vendedor>();
        listaRecomendados= new ArrayList<Vendedor>();
    }

    /**
     * set y get de lista vendedores aliados
     * ------------------------------------
     * Setter and Getter the list seller allies
     * @return
     */
    public Vendedor[] getListaVendedoresAliados() {
        return listaVendedoresAliados;
    }

    public void setListaVendedoresAliados(Vendedor[] listaVendedoresAliados) {
        this.listaVendedoresAliados = listaVendedoresAliados;
    }

    /**
     * set y get de lista productos
     *  ---------------------------------
     * Setter and Getter the list product
     * @return
     */
    public ArrayList<Producto> getListaProductos() {
        return listaProductos;
    }

    public void setListaProductos(ArrayList<Producto> listaProductos) {
        this.listaProductos = listaProductos;
    }

    /**
     * set y get de lista solicitudes
     *  ----------------------------------
     * Setter and Getter the list requests
     * @return
     */
    public ArrayList<Vendedor> getListaSolicitudes() {
        return listaSolicitudes;
    }

    public void setListaSolicitudes(ArrayList<Vendedor> listaSolicitudes) {
        this.listaSolicitudes = listaSolicitudes;
    }
    /**
     * set y get de lista recomendados
     *  -------------------------------------
     * Setter and Getter the list recommended
     * @return
     */
    public ArrayList<Vendedor> getListaRecomendados() {
        return listaRecomendados;
    }

    public void setListaRecomendados(ArrayList<Vendedor> listaRecomendados) {
        this.listaRecomendados = listaRecomendados;
    }

    /**
     * set y get de muro
     *  -------------------------
     * Setter and Getter the wall
     * @return
     */
    public Muro getMuro() {
        return muro;
    }

    public void setMuro(Muro muro) {
        this.muro = muro;
    }

    /**
     * set y get de nombre
     *  -------------------------
     * Setter and Getter the name
     * @return
     */
    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    /**
     * set y get de apellido
     *  ------------------------------
     * Setter and Getter the last name
     * @return
     */
    public String getApellido() {
        return apellido;
    }

    public void setApellido(String apellido) {
        this.apellido = apellido;
    }

    /**
     * set y get de cédula
     *  -------------------------
     * Setter and Getter the card
     * @return
     */
    public String getCedula() {
        return cedula;
    }

    public void setCedula(String cedula) {
        this.cedula = cedula;
    }

    /**
     * set y get de dirección
     *  ----------------------------
     * Setter and Getter the address
     * @return
     */
    public String getDireccion() {
        return direccion;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    /**
     * set y get de cuenta
     *  ----------------------------
     * Setter and Getter the account
     * @return
     */
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
