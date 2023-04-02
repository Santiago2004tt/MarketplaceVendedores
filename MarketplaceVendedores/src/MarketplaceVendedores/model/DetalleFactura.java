package MarketplaceVendedores.model;

public class DetalleFactura {

    //-------------------Atributos------------------------------------
    private int cantidad;
    private double precio;
    private String nombreProducto;
    private Double subTotal;
    private String codigo;


    //-----------------------------------------------------------------

    public DetalleFactura(int cantidad, double precio, String nombreProducto,String codigo, Double subTotal) {
        this.cantidad = cantidad;
        this.precio = precio;
        this.nombreProducto = nombreProducto;
        this.codigo=codigo;
        this.subTotal = precio*cantidad;
    }
    public DetalleFactura(){
        this.precio= 0;
        this.cantidad=0;
    }

    public int getCantidad() {
        return cantidad;
    }

    public void setCantidad(int cantidad) {
        this.cantidad = cantidad;
    }

    public double getPrecio() {
        return precio;
    }

    public void setPrecio(double precio) {
        this.precio = precio;
    }

    public String getNombreProducto() {
        return nombreProducto;
    }

    public void setNombreProducto(String nombreProducto) {
        this.nombreProducto = nombreProducto;
    }

    public Double getSubTotal() {
        return subTotal;
    }

    public void setSubTotal(Double subTotal) {
        this.subTotal = subTotal;
    }

    public String getCodigo() {
        return codigo;
    }

    public void setCodigo(String codigo) {
        this.codigo = codigo;
    }

    public boolean compararProducto (Producto producto){
        if(producto.getCodigo().equals(codigo))return true;
        return false;
    }
}
