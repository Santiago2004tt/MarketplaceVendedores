package MarketplaceVendedores.model;

import java.util.ArrayList;

public class Factura {
    // -----------------------Atributos---------------------------------------

    private String fecha, nombreVendedor;
    private double total, subTotal;
    private ArrayList<DetalleFactura> listaDetallesFactura;

    private Vendedor vendedor;

    public Factura(String fecha, String nombreVendedor, double total, double subTotal, double iva) {
        this.fecha = fecha;
        this.nombreVendedor = nombreVendedor;
        this.total = total;
        this.subTotal = subTotal;
        listaDetallesFactura = new ArrayList<>();
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

}
