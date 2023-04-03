package MarketplaceVendedores.model;

/**
 * clase detalle factura
 * ---------------------
 * Bill detail class
 */
public class DetalleFactura {

    /**
     * atributos
     * ---------
     * Attributes
     */
    private int cantidad;
    private double precio;
    private String nombreProducto;
    private Double subTotal;
    private String codigo;

    /**
     * Constructor
     * -----------
     * Builder
     * @param cantidad
     * @param precio
     * @param nombreProducto
     * @param codigo
     * @param subTotal
     */
    public DetalleFactura(int cantidad, double precio, String nombreProducto,String codigo, Double subTotal) {
        this.cantidad = cantidad;
        this.precio = precio;
        this.nombreProducto = nombreProducto;
        this.codigo=codigo;
        this.subTotal = precio*cantidad;
    }

    /**
     * Constructor vacío
     * -----------------
     * void builder
     */
    public DetalleFactura(){
        this.precio= 0;
        this.cantidad=0;
    }

    /**
     * set y get de cantidad
     * ---------------------
     * Setter and Getter the amount
     */
    public int getCantidad() {
        return cantidad;
    }

    public void setCantidad(int cantidad) {
        this.cantidad = cantidad;
    }
    /**
     * set y get de precio
     * ---------------------
     * Setter and Getter the price
     */
    public double getPrecio() {
        return precio;
    }

    public void setPrecio(double precio) {
        this.precio = precio;
    }

    /**
     * set y get de nombre producto
     * ---------------------
     * Setter and Getter the product name
     */
    public String getNombreProducto() {
        return nombreProducto;
    }

    public void setNombreProducto(String nombreProducto) {
        this.nombreProducto = nombreProducto;
    }

    /**
     * set y get de subTotal
     * ---------------------
     * Setter and Getter the subTotal
     */
    public Double getSubTotal() {
        return subTotal;
    }

    public void setSubTotal(Double subTotal) {
        this.subTotal = subTotal;
    }

    /**
     * set y get de código
     * ---------------------
     * Setter and Getter the code
     */
    public String getCodigo() {
        return codigo;
    }

    public void setCodigo(String codigo) {
        this.codigo = codigo;
    }

    /**
     * método comparar producto
     * ---------------------
     * Method compare product
     */
    public boolean compararProducto (Producto producto){
        if(producto.getCodigo().equals(codigo)) return true;
        return false;
    }
}
