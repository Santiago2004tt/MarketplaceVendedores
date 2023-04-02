package MarketplaceVendedores.model;

import MarketplaceVendedores.exceptions.DetalleFacturaException;

import java.util.ArrayList;

public class Factura {
    // -----------------------Atributos---------------------------------------

    private String fecha, nombreVendedor;
    private double total, subTotal;
    private ArrayList<DetalleFactura> listaDetallesFactura;

    private Vendedor vendedor;

    public Factura(String fecha, String nombreVendedor, double total, double subTotal) {
        this.fecha = fecha;
        this.nombreVendedor = nombreVendedor;
        this.total = total;
        this.subTotal = subTotal;
        listaDetallesFactura = new ArrayList<>();
    }
    public Factura(){

    }
    public String getFecha() {
        return fecha;
    }

    public void setFecha(String fecha) {
        this.fecha = fecha;
    }

    public String getNombreVendedor() {
        return nombreVendedor;
    }

    public void setNombreVendedor(String nombreVendedor) {
        this.nombreVendedor = nombreVendedor;
    }

    public double getTotal() {
        return total;
    }

    public void setTotal(double total) {
        this.total = total;
    }

    public double getSubTotal() {
        return subTotal;
    }

    public void setSubTotal(double subTotal) {
        this.subTotal = subTotal;
    }

    public ArrayList<DetalleFactura> getListaDetallesFactura() {
        return listaDetallesFactura;
    }

    public void setListaDetallesFactura(ArrayList<DetalleFactura> listaDetallesFactura) {
        this.listaDetallesFactura = listaDetallesFactura;
    }

    //-----------------------------------CRUD----------------------------------------------------------
    public boolean crearDetalleFactura(int cantidad, double precio, String nombreProducto,String codigo, Double subTotal) throws DetalleFacturaException {
        DetalleFactura detalleFactura = new DetalleFactura();
        detalleFactura.setNombreProducto(nombreProducto);
        detalleFactura.setCantidad(cantidad);
        detalleFactura.setCodigo(codigo);
        detalleFactura.setPrecio(precio);
        detalleFactura.setSubTotal(subTotal);

        if(existeDetalleFactura(codigo)){
            throw new DetalleFacturaException("Detalle Factura Hecho");
        }
        getListaDetallesFactura().add(detalleFactura);
        return true;
    }

    private boolean existeDetalleFactura(String codigo) {
        for (DetalleFactura detalleFactura : listaDetallesFactura) {
            if (detalleFactura.getCodigo().equals(codigo)) {
                return true;
            }
        }
        return false;
    }

    public boolean actualizarDetalleFactura(int cantidad, double precio, String nombreProducto,String codigo, Double subTotal) throws DetalleFacturaException {
        if(existeDetalleFactura(codigo)){
            DetalleFactura detalleFactura = buscarDetalleFactura(codigo);
            detalleFactura.setCodigo(codigo);
            detalleFactura.setPrecio(precio);
            detalleFactura.setSubTotal(subTotal);
            detalleFactura.setCantidad(cantidad);
            detalleFactura.setNombreProducto(nombreProducto);
            return true;
        }
        return false;
    }

    public boolean eliminarDetalleFactura(String codigo) throws DetalleFacturaException {
        if(existeDetalleFactura(codigo)){
            DetalleFactura detalleFactura = buscarDetalleFactura(codigo);
            listaDetallesFactura.remove(detalleFactura);
            return true;
        }
        return false;
    }

    public DetalleFactura buscarDetalleFactura(String codigo) throws DetalleFacturaException {
        DetalleFactura detalleFacturaEncontrado = null;
        if(existeDetalleFactura(codigo)){
            for (DetalleFactura detalle: getListaDetallesFactura()) {
                if(detalle.getCodigo().equals(codigo)){
                    detalleFacturaEncontrado = detalle;
                    return detalleFacturaEncontrado;
                }
            }
        }
        if(detalleFacturaEncontrado == null){
            throw new DetalleFacturaException("Detalle Factura no encontrado");
        }
        return detalleFacturaEncontrado;
    }


}
