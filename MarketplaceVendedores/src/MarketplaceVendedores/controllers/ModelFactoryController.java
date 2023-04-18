package MarketplaceVendedores.controllers;


import MarketplaceVendedores.Persistencia.Persistencia;
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
                Persistencia.guardarVendedores(marketplaceVendedores.getListaVendedores());
                Persistencia.guardaRegistroLog(vendedorLogeado.getNombre()+" "+vendedorLogeado.getApellido()+" a creado una publicacion", 1, "Creacion Publicacion");
                Persistencia.guardarRecursoBinario(marketplaceVendedores);
                return true;
            }
        } catch (ProductoExceptions e) {
            Persistencia.guardaRegistroLog(vendedorLogeado.getNombre()+" "+vendedorLogeado.getApellido()+" no se a creado la publicacion", 3, "Creacion Publicacion");
            mostrarMensaje("Notificacion vendedor", "rellenar los datos", "datos incompletos, por favor rellenar", Alert.AlertType.ERROR);
        } catch (IOException e) {
            throw new RuntimeException(e);
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
        iniciarSalvarDatosPrueba();
        if(marketplaceVendedores==null) {
            inicializarDatos();
            Persistencia.guardarRecursoXML(marketplaceVendedores);
            Persistencia.guardarRecursoBinario(marketplaceVendedores);
        }

    }

    private void inicializarDatos() {

        marketplaceVendedores = new MarketplaceVendedores("sandbox");
        //imagen
        Image image = new Image("iconPapa.jpg");
        //creando las instancias
        Muro muro = new Muro();
        Producto producto = new Producto();
        Comentario comentario = new Comentario();
        Vendedor vendedor = new Vendedor();
        Cuenta cuenta = new Cuenta("jere", "1");
        //crear comentario
        comentario.setMensaje("alguien: hola");
        //obtener mensaje
        muro.getListaComentarios().add(comentario);
        //crear producto
        producto.setNombre("papas");
        producto.setEstado(Estado.PUBLICADO);
        producto.setDate("2023-04-14");
        producto.setCategoria("Verduras");
        producto.setCodigo("1");
        //producto.setImage(image);
        producto.setMuro(muro);
        //aniadir datos al vendedor
        vendedor.setCuenta(cuenta);
        vendedor.setNombre("Jeremias");
        vendedor.setApellido("Gamer");
        vendedor.setCedula("1");
        vendedor.setDireccion("Armenia-Quindio");
        vendedor.getListaProductos().add(producto);

        //aniadir datos al marketplace
        marketplaceVendedores.getListaCuentas().add(cuenta);
        marketplaceVendedores.getListaVendedores().add(vendedor);
        System.out.println("la empresa: "+marketplaceVendedores.getNombre() +" ya se a inicializado");

    }

    //-------------------------------------Serializable y XML------------------------------------------

    private void iniciarSalvarDatosPrueba() {
        this.marketplaceVendedores=Persistencia.cargarRecursoBinario();


        try {
            Persistencia.guardarVendedores(marketplaceVendedores.getListaVendedores());

            //Persistencia.cargarDatosArchivos(getMarketplaceVendedores());

        } catch (IOException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
    }
//    private void cargarDatosDesdeArchivos() {
//        marketplaceVendedores = new MarketplaceVendedores();
//        try {
//            Persistencia.cargarDatosArchivos(getMarketplaceVendedores());
//
//        } catch (IOException e) {
//            // TODO Auto-generated catch block
//            e.printStackTrace();
//        }
//    }

//    public void cargarResourceBinario() {
//
//        marketplaceVendedores = Persistencia.cargarRecursoBancoBinario();
//    }
//    public void guardarResourceBinario() {
//
//        Persistencia.guardarRecursoBancoBinario(marketplaceVendedores);
//    }
//    public void cargarResourceXML() {
//
//        marketplaceVendedores = Persistencia.cargarRecursoBancoXML();
//    }
//    public void guardarResourceXML() {
//
//        Persistencia.guardarRecursoXML(marketplaceVendedores);
//    }
    //--------------------------------------------------------------------------------------------------

    public void iniciarSesion(String usuario, String contrasenia){
        try {
            if(getInstance().marketplaceVendedores.verificarCuenta(usuario, contrasenia)){
                Vendedor vendedor = getInstance().marketplaceVendedores.buscarVendedorCuenta(usuario, contrasenia);
                getInstance().accederCuenta(vendedor);
                Persistencia.guardaRegistroLog(vendedor.getNombre()+" "+vendedor.getApellido()+" a iniciado sesion", 1, "Inicio Sesion");
            }else{
                mostrarMensaje("Notificacion vendedor", "cuenta no existe", "La cuenta no ha sido encontrada", Alert.AlertType.ERROR);
                Persistencia.guardaRegistroLog("No a iniciado sesion", 2, "Inicio Sesion Fallida");

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
                Persistencia.guardarVendedores(marketplaceVendedores.getListaVendedores());
                Vendedor vendedor = marketplaceVendedores.buscarVendedor(cedula);
                Persistencia.guardaRegistroLog(vendedor.getNombre()+" "+vendedor.getApellido()+" a creado una cuenta", 1, "Creacion de cuenta");
                Persistencia.guardarRecursoBinario(marketplaceVendedores);
                return true;
            }
        }catch (CuentaException e){
            Persistencia.guardaRegistroLog("Error al crear una cuenta", 2, "Crear Cuenta");
            mostrarMensaje("Notificacion vendedor", "Cuenta ya existe", "La cuenta ya ha sido creada", Alert.AlertType.ERROR);
        }catch (VendedorException e){
            Persistencia.guardaRegistroLog("Error al crear una cuenta", 2, "Crear Cuenta");
            marketplaceVendedores.eliminarCuenta(usuario, contrasenia);
            mostrarMensaje("Notificacion vendedor", "Vendedor ya existe", "El vendedor ya ha sido creado", Alert.AlertType.ERROR);
        } catch (IOException e) {
            throw new RuntimeException(e);
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