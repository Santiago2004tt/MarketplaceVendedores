package MarketplaceVendedores.model;

import MarketplaceVendedores.exceptions.DetalleFacturaException;

import java.util.ArrayList;

/**
 * clase factura
 * ---English---
 * bill class
 */
public class Factura {

    /**
     * atributos
     * --------
     * attributes
     */
    private String fecha, nombreVendedor;
    private double total, subTotal;
    private ArrayList<DetalleFactura> listaDetallesFactura;

    private Vendedor vendedor;

    /**
     * Constructor
     * -----------
     * Builder
     * @param fecha
     * @param nombreVendedor
     * @param total
     * @param subTotal
     */
    public Factura(String fecha, String nombreVendedor, double total, double subTotal) {
        this.fecha = fecha;
        this.nombreVendedor = nombreVendedor;
        this.total = total;
        this.subTotal = subTotal;
        listaDetallesFactura = new ArrayList<>();
    }

    /**
     * Constructor vacío
     * ----------------
     * Void builder
     */
    public Factura(){

    }

    /**
     * get y set de fecha
     * --------------------------
     * Getter and Setter the date
     * @return
     */
    public String getFecha() {
        return fecha;
    }

    public void setFecha(String fecha) {
        this.fecha = fecha;
    }

    /**
     * get y set de nombre Vendedor
     * ---------------------------------
     * Getter and Setter the seller name
     * @return
     */
    public String getNombreVendedor() {
        return nombreVendedor;
    }

    public void setNombreVendedor(String nombreVendedor) {
        this.nombreVendedor = nombreVendedor;
    }

    /**
     * get y set de total
     * --------------------------
     * Getter and Setter the total
     * @return
     */
    public double getTotal() {
        return total;
    }

    public void setTotal(double total) {
        this.total = total;
    }

    /**
     * get y set de subtotal
     * ------------------------------
     * Getter and Setter the subtotal
     * @return
     */
    public double getSubTotal() {
        return subTotal;
    }

    public void setSubTotal(double subTotal) {
        this.subTotal = subTotal;
    }

    /**
     * get y set de lista detalle factura
     * ----------------------------------
     * Getter and Setter the bill detail
     * @return
     */
    public ArrayList<DetalleFactura> getListaDetallesFactura() {
        return listaDetallesFactura;
    }

    public void setListaDetallesFactura(ArrayList<DetalleFactura> listaDetallesFactura) {
        this.listaDetallesFactura = listaDetallesFactura;
    }

    //-----------------------------------CRUD-DetalleFactura------------------------------------------------//
    //-----------------------------------CRUD-DetailBill----------------------------------------------------//

    /**
     * Método crear factura
     * --------------------
     * Method bill create
     * @param cantidad
     * @param precio
     * @param nombreProducto
     * @param codigo
     * @param subTotal
     * @return
     * @throws DetalleFacturaException
     */
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

    /**
     * Método existencia de detalle factura
     * -------------------------------------
     * Method existence the bill detail
     * @param codigo
     * @return
     */
    private boolean existeDetalleFactura(String codigo) {
        for (DetalleFactura detalleFactura : listaDetallesFactura) {
            if (detalleFactura.getCodigo().equals(codigo)) {
                return true;
            }
        }
        return false;
    }

    /**
     * actualizar detalle factura
     * --------------------------
     * Update bill detail
     * @param cantidad
     * @param precio
     * @param nombreProducto
     * @param codigo
     * @param subTotal
     * @return
     * @throws DetalleFacturaException
     */
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

    /**
     * Eliminar detalle
     * ----------------
     * Delete detail
     * @param codigo
     * @return
     * @throws DetalleFacturaException
     */
    public boolean eliminarDetalleFactura(String codigo) throws DetalleFacturaException {
        if(existeDetalleFactura(codigo)){
            DetalleFactura detalleFactura = buscarDetalleFactura(codigo);
            listaDetallesFactura.remove(detalleFactura);
            return true;
        }
        return false;
    }

    /**
     * buscar detalle
     * --------------
     * Search detail
     * @param codigo
     * @return
     * @throws DetalleFacturaException
     */
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
