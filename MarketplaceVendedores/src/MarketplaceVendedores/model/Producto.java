package MarketplaceVendedores.model;

import java.awt.*;
import java.util.Objects;

public class Producto {

    private String nombre;
    private String codigo;
    private String categoria;
    private double precio;
    private Estado estado;
    private Image image;
    private String date;

    public Producto(String nombre, String codigo, String categoria, double precio, Estado estado, Image image, String date) {
        this.nombre = nombre;
        this.codigo = codigo;
        this.categoria = categoria;
        this.precio = precio;
        this.estado = estado;
        this.image = image;
        this.date = date;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getCodigo() {
        return codigo;
    }

    public void setCodigo(String codigo) {
        this.codigo = codigo;
    }

    public String getCategoria() {
        return categoria;
    }

    public void setCategoria(String categoria) {
        this.categoria = categoria;
    }

    public double getPrecio() {
        return precio;
    }

    public void setPrecio(double precio) {
        this.precio = precio;
    }

    public Estado getEstado() {
        return estado;
    }

    public void setEstado(Estado estado) {
        this.estado = estado;
    }

    public Image getImage() {
        return image;
    }

    public void setImage(Image image) {
        this.image = image;
    }

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
