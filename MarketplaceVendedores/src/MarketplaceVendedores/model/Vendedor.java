package MarketplaceVendedores.model;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Objects;

/**
 * clase vendedor
 * ----English----
 *  Seller class
 */
public class Vendedor implements Serializable {

    /**
     * atributos
     * ---------
     * Attributes
     */

    private static final long serialVersioUID = 1L;
    private ArrayList<Vendedor> listaVendedoresAliados;
    private ArrayList<Producto> listaProductos;
    private ArrayList<Vendedor> listaSolicitudes;
    private ArrayList<Vendedor> listaRecomendados;
    private ArrayList<Chat> listaChats;
    private String nombre;
    private String apellido;
    private String cedula;
    private String direccion;
    private Cuenta cuenta;

    /**
     * Constructor
     * ----------
     * Builder
     * @param nombre
     * @param apellido
     * @param cedula
     * @param direccion
     * @param cuenta
     */
    public Vendedor( String nombre, String apellido, String cedula, String direccion, Cuenta cuenta) {
        this.nombre = nombre;
        this.apellido = apellido;
        this.cedula = cedula;
        this.direccion = direccion;
        this.cuenta = cuenta;
        listaVendedoresAliados  = new ArrayList<Vendedor>();
        listaProductos = new ArrayList<Producto>();
        listaSolicitudes = new ArrayList<Vendedor>();
        listaRecomendados= new ArrayList<Vendedor>();
        listaChats = new ArrayList<>();
    }

    /**
     * Constructor vacío
     * ----------------
     * Void builder
     */
    public Vendedor() {
        listaVendedoresAliados = new ArrayList<Vendedor>();
        listaProductos = new ArrayList<Producto>();
        listaSolicitudes = new ArrayList<Vendedor>();
        listaRecomendados= new ArrayList<Vendedor>();
        listaChats = new ArrayList<>();
    }

    /**
     * set y get de lista vendedores aliados
     * ------------------------------------
     * Setter and Getter the list seller allies
     * @return
     */
    public ArrayList<Vendedor> getListaVendedoresAliados() {
        return listaVendedoresAliados;
    }

    public void setListaVendedoresAliados(ArrayList<Vendedor> listaVendedoresAliados) {
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

    public ArrayList<Chat> getListaChats() {
        return listaChats;
    }

    public void setListaChats(ArrayList<Chat> listaChats) {
        this.listaChats = listaChats;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Vendedor vendedor = (Vendedor) o;
        return Objects.equals(cedula, vendedor.cedula);
    }

    @Override
    public String toString() {
        return "Vendedor{" +
                ", nombre='" + nombre +
                ", apellido='" + apellido +
                ", cedula='" + cedula +
                ", direccion='" + direccion +
                ", cuenta=" + cuenta.toString() +
                ", listaProductos=" + listaProductos.toString()  +
                '}';
    }

    @Override
    public int hashCode() {
        return Objects.hash(cedula);
    }

    public int contarComentarios() {
        int sumaComentarios = 0;
        for (Producto producto : listaProductos) {
            sumaComentarios += producto.getMuro().getListaComentarios().size();
        }
        return sumaComentarios;
    }

    public int contarLikes() {
        int sumaLikes = 0;
        for (Producto producto : listaProductos) {
            sumaLikes += producto.getMuro().getListaMeGusta().size();
        }
        return sumaLikes;
    }

    public ArrayList<Mensaje> buscarChat(String cedula) {
        ArrayList<Mensaje> listaMensajes = null;
        if(existeChat(cedula)){
            listaMensajes = buscarChatCedula(cedula);
        }else {
            Chat chat = new Chat(cedula);
            listaChats.add(chat);
            listaMensajes = chat.getListaEnviado();
        }
        return listaMensajes;
    }

    private ArrayList<Mensaje> buscarChatCedula(String cedula) {
        ArrayList<Mensaje> listaMensajes = null;
        for (Chat chat: listaChats) {
            if(chat.getId().equals(cedula)){
                listaMensajes = chat.getListaEnviado();
            }
        }
        return listaMensajes;
    }

    private boolean existeChat(String cedula) {
        for (Chat chat: listaChats) {
            if(chat.getId().equals(cedula)){
                return true;
            }
        }
        return false;
    }

    public void enviarMensaje(String cedula, String mensaje) {
        for (Chat chat: listaChats) {
            if(chat.getId().equals(cedula)){
                Mensaje mensaje1 = new Mensaje(mensaje);
                chat.getListaEnviado().add(mensaje1);
            }
        }
    }
}


