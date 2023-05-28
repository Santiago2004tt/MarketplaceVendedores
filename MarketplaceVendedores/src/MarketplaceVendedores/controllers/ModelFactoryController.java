package MarketplaceVendedores.controllers;


import MarketplaceVendedores.Persistencia.Persistencia;
import MarketplaceVendedores.application.Main;
import MarketplaceVendedores.exceptions.AdministradorException;
import MarketplaceVendedores.exceptions.CuentaException;
import MarketplaceVendedores.exceptions.ProductoExceptions;
import MarketplaceVendedores.exceptions.VendedorException;
import MarketplaceVendedores.model.*;
import javafx.scene.control.Alert;
import javafx.scene.control.DialogPane;
import javafx.scene.image.Image;

import java.io.IOException;
import java.util.ArrayList;

public class ModelFactoryController {

    MarketplaceVendedores marketplaceVendedores;
    Main main;

    public void agregarMeGusta(Vendedor vendedorLogeado, Producto producto) {
        marketplaceVendedores.agregarMeGusta(vendedorLogeado, producto);
    }

    public void visitarCrearProducto(Vendedor vendedorLogeado) {
        main.mostrarCrearProducto(vendedorLogeado);
        iniciarSalvarDatosPrueba();
    }

    public ArrayList<Vendedor> obtenerVendedores(Vendedor vendedor) {
        return marketplaceVendedores.obtenerListaVendedoresRecomendados(vendedor);
    }

    public ArrayList<Vendedor> obtenerDatosVendedores() {
        return marketplaceVendedores.getListaVendedores();
    }

    public void aceptarSolicitud(Vendedor vendedorLogeado, Vendedor vendedorSolicitud) {
        marketplaceVendedores.aceptarSolicitud(vendedorLogeado, vendedorSolicitud);
        iniciarSalvarDatosPrueba();
    }

    public void rechazarSolicitud(Vendedor vendedorLogeado, Vendedor vendedorSolicitud) {
        marketplaceVendedores.rechazarSolicitud(vendedorLogeado, vendedorSolicitud);
        iniciarSalvarDatosPrueba();
    }

    public void accederProductoAliado(Vendedor vendedorLogeado, Vendedor vendedorVisitante, Producto productoSeleccionado) {
        main.mostrarProductoAliado(vendedorLogeado, vendedorVisitante, productoSeleccionado);
        iniciarSalvarDatosPrueba();
    }

    public void publicarComentario(Producto producto, String comentario) {
        marketplaceVendedores.publicarComentario(producto, comentario);
        iniciarSalvarDatosPrueba();

    }

    public boolean verificarExisteMeGusta(Vendedor vendedorLogeado, Producto producto) {
        return marketplaceVendedores.verificarExisteMeGusta(vendedorLogeado, producto);
    }

    public void quitarMeGusta(Vendedor vendedorLogeado, Producto producto) {
        marketplaceVendedores.quitarMeGusta(vendedorLogeado, producto);
    }



    /**
     * singleton holder
     */
    public static class SingletonHolder {
        public final static ModelFactoryController eINSTANCE = new ModelFactoryController();
    }

    /**
     * get del singleton
     * @return
     */
    public static ModelFactoryController getInstance() {
        return SingletonHolder.eINSTANCE;
    }

    /**
     * constructor de model factory controller
     */
    public ModelFactoryController() {
        this.marketplaceVendedores=Persistencia.cargarRecursoBinario();
        if(marketplaceVendedores==null) {
            inicializarDatos();
            iniciarSalvarDatosPrueba();
        }

    }

    /**
     * metodo para inicializar datos
     */
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
        Cuenta cuenta1 = new Cuenta("juan", "2");
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
        producto.setImage(image.getUrl());
        producto.setMuro(muro);


        //aniadir datos al vendedor
        vendedor.setCuenta(cuenta);
        vendedor.setNombre("Jeremias");
        vendedor.setApellido("Gamer");
        vendedor.setCedula("1");
        vendedor.setDireccion("Armenia-Quindio");
        vendedor.getListaProductos().add(producto);
        //admin
        Administrador administrador = new Administrador("huen", "vante","4");
        marketplaceVendedores.getListaAdministradores().add(administrador);
        //vendedor aliado
        Vendedor vendedor1 = new Vendedor();
        vendedor1.setCuenta(cuenta1);
        vendedor1.setNombre("Juan");
        vendedor1.setApellido("Gamer");
        vendedor1.setCedula("0");
        vendedor1.setDireccion("Armenia-Quindio");
        vendedor.getListaVendedoresAliados().add(vendedor1);
        vendedor1.getListaVendedoresAliados().add(vendedor);
        //aniadir datos al marketplace
        marketplaceVendedores.getListaCuentas().add(cuenta);
        marketplaceVendedores.getListaCuentas().add(cuenta1);
        marketplaceVendedores.getListaVendedores().add(vendedor);
        marketplaceVendedores.getListaVendedores().add(vendedor1);
        System.out.println("la empresa: "+marketplaceVendedores.getNombre() +" ya se a inicializado");

    }

    //-------------------------------------------------------------------------------

    /**
     * metodo para guardar los datos
     */
    private void iniciarSalvarDatosPrueba() {

        try {
            Persistencia.guardarVendedores(marketplaceVendedores.getListaVendedores());
            Persistencia.guardarRecursoXML(marketplaceVendedores);
            Persistencia.guardarRecursoBinario(marketplaceVendedores);

        } catch (IOException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
    }

    //---------------------------------------Metodo de iniciar sesion -------------------------------------

    public void iniciarSesion(String usuario, String contrasenia){
        try {
            if(getInstance().marketplaceVendedores.verificarCuenta(usuario, contrasenia)){
                Vendedor vendedor = getInstance().marketplaceVendedores.buscarVendedorCuenta(usuario, contrasenia);
                accederCuenta(vendedor);
                iniciarSalvarDatosPrueba();
                Persistencia.guardaRegistroLog(vendedor.getNombre()+" "+vendedor.getApellido()+" a iniciado sesion", 1, "Inicio Sesion");
            }else{
                mostrarMensaje("Notificacion vendedor", "cuenta no existe", "La cuenta no ha sido encontrada", Alert.AlertType.ERROR);
                Persistencia.guardaRegistroLog("No a iniciado sesion", 2, "Inicio Sesion Fallida");

            }
        }catch (VendedorException e){
            mostrarMensaje("Notificacion vendedor", "Error", "Error", Alert.AlertType.ERROR);

        }
    }

    public void iniciarSesionAdmin(String usuario, String contrasenia){
        try {
            if(getInstance().marketplaceVendedores.verificarCuentaAdmin(usuario, contrasenia)){
                Administrador administrador = getInstance().marketplaceVendedores.buscarAdminCuenta(usuario, contrasenia);
                accederEstadisticas(administrador);
                iniciarSalvarDatosPrueba();
                Persistencia.guardaRegistroLog(administrador.getNombre()+" "+ " a iniciado sesion", 1, "Inicio Sesion");
            }else{
                mostrarMensaje("Notificacion admin", "cuenta no existe", "La cuenta no ha sido encontrada", Alert.AlertType.ERROR);
                Persistencia.guardaRegistroLog("No a iniciado sesion", 2, "Inicio Sesion Fallida");

            }
        }catch (AdministradorException e){
            mostrarMensaje("Notificacion admin", "Error", "Error", Alert.AlertType.ERROR);

        }
    }


    //-------------------------------------Metodos de vendedores-------------------
    public boolean crearVendedor(String nombre, String apellido, String cedula, String direccion, String usuario, String  contrasenia) throws CuentaException, VendedorException {

        try {
            marketplaceVendedores.crearCuenta(usuario, contrasenia);
            Cuenta cuenta =marketplaceVendedores.buscarCuenta(usuario, contrasenia);
            if(marketplaceVendedores.crearVendedor(nombre, apellido, cedula, direccion, cuenta)){
                Persistencia.guardarVendedores(marketplaceVendedores.getListaVendedores());
                Vendedor vendedor = marketplaceVendedores.buscarVendedor(cedula);
                Persistencia.guardaRegistroLog(vendedor.getNombre()+" "+vendedor.getApellido()+" a creado una cuenta", 1, "Creacion de cuenta");
                iniciarSalvarDatosPrueba();
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


    //---------------------------Metodos de producto----------------------------
    public boolean crearProducto(String nombre, String codigo, String categoria, double precioDefinitivo, Estado estado, String fecha, Image image, Vendedor vendedorLogeado) {
        try {
            if(marketplaceVendedores.crearProducto(nombre,codigo,categoria,precioDefinitivo,estado,image,fecha)){
                Producto producto = marketplaceVendedores.buscarProducto(codigo);
                vendedorLogeado.getListaProductos().add(producto);
                Persistencia.guardaRegistroLog(vendedorLogeado.getNombre()+" "+vendedorLogeado.getApellido()+" a creado una publicacion", 1, "Creacion Publicacion");
                iniciarSalvarDatosPrueba();
                return true;
            }
        } catch (ProductoExceptions e) {
            Persistencia.guardaRegistroLog(vendedorLogeado.getNombre()+" "+vendedorLogeado.getApellido()+" no se a creado la publicacion", 3, "Creacion Publicacion");
            mostrarMensaje("Notificacion vendedor", "rellenar los datos", "datos incompletos, por favor rellenar", Alert.AlertType.ERROR);
        }
        return false;
    }

    public void enviarSolicitud(Vendedor vendedorLogeado, Vendedor vendedorSeleccionado) {
        if(marketplaceVendedores.enviarSolicitud(vendedorLogeado, vendedorSeleccionado)){
            mostrarMensaje("Notificacion vendedor", "se a enviado la solicitud", "la solicitud fue enviada exitosamente", Alert.AlertType.INFORMATION);
            Persistencia.guardaRegistroLog("se a enviado la solicitud", 2, "Enviar solicitud");
            iniciarSalvarDatosPrueba();
        }else {
            mostrarMensaje("Notificacion vendedor", "Solicitud ya enviada", "no se puede volver a enviar la solicitud", Alert.AlertType.ERROR);
            Persistencia.guardaRegistroLog("Error al enviar la solicitud", 2, "Enviar solicitud");
        }
    }

    //----------------------------Metodos de cambio de ventana-----------------------

    public void aniadirMain(Main main) {
        this.main = main;
    }
    public void accederCuenta(Vendedor vendedor) {
        main.mostrarMainVendedor(vendedor);
    }

    private void accederEstadisticas(Administrador administrador) {
        main.mostrarEstadisticas(administrador);
    }

    public void accederCrearCuenta() {
        main.mostrarCrearCuenta();
    }

    public void accederLoginAdmin() {
        main.MostrarLoginAdmin();

    }
    public void volverLoginAdmin() {
        main.MostrarLoginAdmin();
    }


    public void volverLogin() {
        main.MostrarLoginVendedor();
    }

    public void volverInicioSesion() {
        main.MostrarLoginVendedor();
    }
    public void visitarVendedoresAction(Vendedor vendedorLoggeado) {
        main.mostrarVendedoresAliadosRecomendado(vendedorLoggeado);
    }
    public void visitarMuroProducto(Producto productosVendedor, Vendedor vendedorLoggeado) {
        main.mostrarMuroProductoLogeado(productosVendedor, vendedorLoggeado);
    }

    public void visitarVendedorAliado(Vendedor vendedorLogeado, Vendedor vendedorAliado) {
        main.mostrarVendedorAliado(vendedorLogeado, vendedorAliado);
    }

    //-------------------------Metodos auxiliares----------------------------------------
    public void mostrarMensaje(String titulo, String header, String contenido, Alert.AlertType alertType) {

        Alert alert = new Alert(alertType);
        alert.setTitle(titulo);
        alert.setHeaderText(header);
        alert.setContentText(contenido);
        DialogPane dialogPane = alert.getDialogPane();
        alert.showAndWait();
    }
}