package MarketplaceVendedores.model;

import javafx.scene.image.Image;
import java.io.Serializable;
import java.util.Objects;

/**
 * clase producto
 * ---English---
 * Product class
 */
public class Producto implements Serializable {

    /**
     * Atributos
     * ---------
     * Attributes
     */
    private static final long serialVersioUID = 1L;
    private String nombre;
    private String codigo;
    private String categoria;
    private double precio;
    private Estado estado;
    private String image;
    private String date;
    private Muro muro;

    /**
     * Constructor
     * -----------
     * Builder
     */
    public Producto(String nombre, String codigo, String categoria, double precio, Estado estado, String image, String date, Muro muro) {
        this.nombre = nombre;
        this.codigo = codigo;
        this.categoria = categoria;
        this.precio = precio;
        this.estado = estado;
        this.image = image;
        this.date = date;
        this.muro = muro;
    }

    /**
     * Constructor vacío
     * -----------------
     * Void builder
     */
    public Producto() {

    }

    /**
     * get y set de nombre
     * ------------------
     * Getter and Setter the name
     * @return
     */
    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    /**
     * get y set de código
     * ------------------
     * Getter and Setter the code
     * @return
     */
    public String getCodigo() {
        return codigo;
    }

    public void setCodigo(String codigo) {
        this.codigo = codigo;
    }

    /**
     * get y set de categoría
     * ------------------
     * Getter and Setter the categorize
     * @return
     */
    public String getCategoria() {
        return categoria;
    }

    public void setCategoria(String categoria) {
        this.categoria = categoria;
    }

    /**
     * get y set de precio
     * ------------------
     * Getter and Setter the price
     * @return
     */
    public double getPrecio() {
        return precio;
    }

    public void setPrecio(double precio) {
        this.precio = precio;
    }

    /**
     * get y set de estado
     * ------------------
     * Getter and Setter the state
     * @return
     */
    public Estado getEstado() {
        return estado;
    }

    public void setEstado(Estado estado) {
        this.estado = estado;
    }

    /**
     * get y set de imagen
     * ------------------
     * Getter and Setter the image
     *
     * @return
     */
    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    /**
     * get y set de fecha
     * ------------------
     * Getter and Setter the date
     * @return
     */
    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    /**
     * get y set de muro
     * --------------------
     * Getter and Setter the muro
     * @return
     */
    public Muro getMuro() {
        return muro;
    }

    public void setMuro(Muro muro) {
        this.muro = muro;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Producto producto = (Producto) o;
        return Objects.equals(codigo, producto.codigo);
    }

    @Override
    public int hashCode() {
        return Objects.hash(codigo);
    }

    @Override
    public String toString() {
        return "Producto{" +
                "nombre='" + nombre + '\'' +
                ", codigo='" + codigo + '\'' +
                ", categoria='" + categoria + '\'' +
                ", precio=" + precio +
                ", estado=" + estado +
                ", image=" + image +
                ", date='" + date + '\'' +
                '}';
    }

    public void aniadirComentario(String comentario) {
        Comentario comentario1 = new Comentario(comentario);
        this.muro.getListaComentarios().add(comentario1);
    }

    public boolean verificarExistencia(Vendedor vendedorLogeado) {
        for (Vendedor vendedor: muro.getListaMeGusta()) {
            if(vendedor.getCedula().equals(vendedorLogeado.getCedula())){
                return false;
            }
        }
        return true;
    }

    public void aniadirMeGusta(Vendedor vendedorLogeado ) {
        muro.getListaMeGusta().add(vendedorLogeado);
    }

    public void quitarMeGusta(Vendedor vendedorLogeado) {
        muro.getListaMeGusta().remove(vendedorLogeado);
    }
}
