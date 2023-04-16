package MarketplaceVendedores.controllers;


import MarketplaceVendedores.application.Main;
import MarketplaceVendedores.exceptions.CuentaException;
import MarketplaceVendedores.exceptions.ProductoExceptions;
import MarketplaceVendedores.exceptions.VendedorException;
import MarketplaceVendedores.model.*;
import javafx.scene.control.Alert;
import javafx.scene.control.DialogPane;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.stage.Window;

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
        main.mostrarMuroProductoLogeado(productosVendedor, vendedorLoggeado);
    }

    public void visitarCrearProducto(Vendedor vendedorLogeado) {
        main.mostrarCrearProducto(vendedorLogeado);
    }

    public boolean crearProducto(String nombre, String codigo, String categoria, double precioDefinitivo, Estado estado, String fecha, Image image, Vendedor vendedorLogeado) {
        try {
            if(marketplaceVendedores.crearProducto(nombre,codigo,categoria,precioDefinitivo,estado,image,fecha)){
                Producto producto = marketplaceVendedores.buscarProducto(codigo);
                vendedorLogeado.getListaProductos().add(producto);
                return true;
            }
        } catch (ProductoExceptions e) {
            mostrarMensaje("Notificacion vendedor", "rellenar los datos", "datos incompletos, por favor rellenar", Alert.AlertType.ERROR);
        }
        return false;
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

        marketplaceVendedores = new MarketplaceVendedores("Hola");
        Muro muro = new Muro();
        Producto producto = new Producto();
        Comentario comentario = new Comentario();
        Vendedor vendedor = new Vendedor();
        comentario.setMensaje("alguien: hola");
        Cuenta cuenta = new Cuenta("juan", "123");
        producto.setNombre("papas");
        muro.getListaComentarios().add(comentario);
        producto.setMuro(muro);
        vendedor.setCuenta(cuenta);
        vendedor.setNombre("jere");
        vendedor.setCedula("1");
        vendedor.getListaProductos().add(producto);

        marketplaceVendedores.getListaCuentas().add(cuenta);
        marketplaceVendedores.getListaVendedores().add(vendedor);

        System.out.println("la empresa: "+marketplaceVendedores.getNombre() +" ya se a inicializado");

    }

    public void iniciarSesion(String usuario, String contrasenia){
        try {
            if(getInstance().marketplaceVendedores.verificarCuenta(usuario, contrasenia)){
                Vendedor vendedor = getInstance().marketplaceVendedores.buscarVendedorCuenta(usuario, contrasenia);
                getInstance().accederCuenta(vendedor);
            }else{
                mostrarMensaje("Notificacion vendedor", "cuenta no existe", "La cuenta no ha sido encontrada", Alert.AlertType.ERROR);
            }
        }catch (VendedorException e){
            mostrarMensaje("Notificacion vendedor", "Error", "Error", Alert.AlertType.ERROR);

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

    public boolean crearVendedor(String nombre, String apellido, String cedula, String direccion, String usuario, String  contrasenia) throws CuentaException, VendedorException {

        try {
            marketplaceVendedores.crearCuenta(usuario, contrasenia);
            Cuenta cuenta =marketplaceVendedores.buscarCuenta(usuario, contrasenia);
            if(marketplaceVendedores.crearVendedor(nombre, apellido, cedula, direccion, cuenta)){
                return true;
            }

        }catch (CuentaException e){
            mostrarMensaje("Notificacion vendedor", "Cuenta ya existe", "La cuenta ya ha sido creada", Alert.AlertType.ERROR);
        }catch (VendedorException e){
            marketplaceVendedores.eliminarCuenta(usuario, contrasenia);
            mostrarMensaje("Notificacion vendedor", "Vendedor ya existe", "El vendedor ya ha sido creado", Alert.AlertType.ERROR);
        }
        return false;
    }

    public void accederCuenta(Vendedor vendedor) {
        main.mostrarMainVendedor(vendedor);
    }

    public void accederCrearCuenta() {
        main.mostrarCrearCuenta();
    }

    public void volverInicioSesion() {
        main.MostrarLoginVendedor();
    }
}