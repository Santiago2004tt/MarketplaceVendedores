package MarketplaceVendedores.model;

import java.awt.*;
import java.util.Objects;

/**
 * clase producto
 * ---English---
 * Product class
 */
public class Producto {

    /**
     * Atributos
     * ---------
     * Attributes
     */
    private String nombre;
    private String codigo;
    private String categoria;
    private double precio;
    private Estado estado;
    private Image image;
    private String date;

    /**
     * Constructor
     * -----------
     * Builder
     */
    public Producto(String nombre, String codigo, String categoria, double precio, Estado estado, Image image, String date) {
        this.nombre = nombre;
        this.codigo = codigo;
        this.categoria = categoria;
        this.precio = precio;
        this.estado = estado;
        this.image = image;
        this.date = date;
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
     * @return
     */
    public Image getImage() {
        return image;
    }

    public void setImage(Image image) {
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
}
