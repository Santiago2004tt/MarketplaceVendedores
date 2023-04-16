package MarketplaceVendedores.controllers;


import MarketplaceVendedores.Persistencia.Persistencia;
import MarketplaceVendedores.application.Main;
import MarketplaceVendedores.exceptions.CuentaException;
import MarketplaceVendedores.exceptions.VendedorException;
import MarketplaceVendedores.model.*;
import javafx.scene.control.Alert;
import javafx.scene.control.DialogPane;

import java.io.IOException;

public class ModelFactoryController {

    MarketplaceVendedores marketplaceVendedores;
    Main main;

    public void aniadirMain(Main main) {
        this.main = main;
    }

    public void visitarVendedoresAction(Vendedor vendedorLoggeado) {
        main.mostrarVendedoresAliados(vendedorLoggeado);
    }

    public void visitarMuroProducto(Producto productosVendedor, Vendedor vendedorLoggeado) {
        main.mostrarMuroProducto(productosVendedor, vendedorLoggeado);
    }

    public static class SingletonHolder {
        public final static ModelFactoryController eINSTANCE = new ModelFactoryController();
    }

    public static ModelFactoryController getInstance() {
        return SingletonHolder.eINSTANCE;
    }

    public ModelFactoryController() {

        if(marketplaceVendedores==null) {
            inicializarDatos();
        }
    }

    private void inicializarDatos() {

        Muro muro = new Muro();
        marketplaceVendedores = new MarketplaceVendedores("Hola");
        Cuenta cuenta = new Cuenta("juan", "123");
        Producto producto = new Producto();
        producto.setNombre("papas");
        producto.setMuro(muro);
        Vendedor vendedor = new Vendedor();
        vendedor.setCuenta(cuenta);
        vendedor.setNombre("jere");
        vendedor.getListaProductos().add(producto);

        marketplaceVendedores.getListaVendedores().add(vendedor);


        System.out.println("la empresa: "+marketplaceVendedores.getNombre() +" ya se a inicializado");

    }

    public void iniciarSesion(String usuario, String contrasenia) throws VendedorException {
        try {
            if(getInstance().marketplaceVendedores.verificarCuenta(usuario, contrasenia)){
                Vendedor vendedor = getInstance().marketplaceVendedores.buscarVendedorCuenta(usuario, contrasenia);
                getInstance().accederCuenta(vendedor);
            }else{
                mostrarMensaje("Notificacion vendedor", "Vendedor no eliminado", "El vendedor No ha sido eliminado", Alert.AlertType.ERROR);
            }
        }catch (VendedorException e){
            mostrarMensaje("Notificacion vendedor", "Vendedor no eliminado", "El vendedor No ha sido eliminado", Alert.AlertType.ERROR);

        }
    }
    public void mostrarMensaje(String titulo, String header, String contenido, Alert.AlertType alertType) {

        Alert alert = new Alert(alertType);
        alert.setTitle(titulo);
        alert.setHeaderText(header);
        alert.setContentText(contenido);
        DialogPane dialogPane = alert.getDialogPane();
        alert.showAndWait();
    }
    public boolean crearCuenta(String usuario, String contrasenia) throws CuentaException {
        try {
            marketplaceVendedores.crearCuenta(usuario, contrasenia);
            Persistencia.guardarCuentas(marketplaceVendedores.getListaCuentas());
            return true;
        } catch (CuentaException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return false;
    }

    public Cuenta buscarCuenta(String usuario, String contrasenia) throws CuentaException {
        Cuenta cuenta = null;
        try {
            cuenta = marketplaceVendedores.buscarCuenta(usuario, contrasenia);
        } catch (CuentaException e) {
            e.printStackTrace();
        }
        return cuenta;
    }

    public boolean crearVendedor(String nombre, String apellido, String cedula, String direccion, String usuario, String  contrasenia) {
        try {
            crearCuenta(usuario, contrasenia);
            Cuenta cuenta = buscarCuenta(usuario,contrasenia);
            marketplaceVendedores.crearVendedor(nombre, apellido, cedula, direccion, cuenta);
            //Persistencia.guardarVendedores(marketplaceVendedores.getListaVendedores());
            return true;
        } catch (VendedorException | CuentaException e) {
            mostrarMensaje("Notificacion vendedor", "Vendedor no eliminado", "El vendedor No ha sido eliminado", Alert.AlertType.ERROR);
        }
        return false;
    }

    private void accederCuenta(Vendedor vendedor) {
        main.mostrarMainVendedor(vendedor);
    }

    public void accederCrearCuenta() {
        main.mostrarCrearCuenta();
    }

    public void volverInicioSesion() {
        main.MostrarLoginVendedor();
    }
}