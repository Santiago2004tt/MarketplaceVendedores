package MarketplaceVendedores.model;

import MarketplaceVendedores.exceptions.*;

import javafx.scene.image.Image;
import java.io.Serializable;
import java.util.ArrayList;

/**
 * clase market place
 * ----------English-----------
 * class market place
 */
public class MarketplaceVendedores implements Serializable {

    /**
     * atributos
     * --------
     * Attributes
     */
    private static final long serialVersioUID = 1L;

    private String nombre;
    private ArrayList<Producto> listaProductos;
    private ArrayList<Vendedor> listaVendedores;
    private ArrayList<Cuenta> listaCuentas;

    private ArrayList<Administrador> listaAdministradores;

    /**
     * Constructor de la clase MarketplaceVendedores
     * --------------------------------------------
     * Builder of the class MarketPlaceSeller
     * @param nombre
     */
    public MarketplaceVendedores(String nombre) {
        this.nombre = nombre;
        listaVendedores = new ArrayList<Vendedor>();
        listaProductos = new ArrayList<Producto>();
        listaCuentas = new ArrayList<Cuenta>();
        listaAdministradores = new ArrayList<Administrador>();
    }

    public MarketplaceVendedores() {
    }

    /**
     * set y get de nombre
     *  -------------------------
     * Setter and Getter the name
     * @return
     */
    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    /**
     * set y get de lista productos
     *  ---------------------------------
     * Setter and Getter the list product
     * @return
     */
    public ArrayList<Producto> getListaProductos() {
        return listaProductos;
    }

    public void setListaProductos(ArrayList<Producto> listaProductos) {
        this.listaProductos = listaProductos;
    }

    /**
     * set y get de lista vendedores
     * ------------------------------------
     * Setter and Getter the seller list
     * @return
     */
    public ArrayList<Vendedor> getListaVendedores() {
        return listaVendedores;
    }

    public void setListaVendedores(ArrayList<Vendedor> listaVendedores) {
        this.listaVendedores = listaVendedores;
    }

    /**
     * set y get de lista cuentas
     * ------------------------------------
     * Setter and Getter the account list
     * @return
     */
    public ArrayList<Cuenta> getListaCuentas() {
        return listaCuentas;
    }

    public void setListaCuentas(ArrayList<Cuenta> listaCuentas) {
        this.listaCuentas = listaCuentas;
    }

    public ArrayList<Administrador> getListaAdministradores() {
        return listaAdministradores;
    }

    public void setListaAdministradores(ArrayList<Administrador> listaAdministradores) {
        this.listaAdministradores = listaAdministradores;
    }

    //---------------------------------CRUD-vendedor--------------------------------------------------------//
    //---------------------------------CRUD-seller--------------------------------------------------------//

    /**
     * Método que permite crear un vendedor teniendo en cuenta sus atributos de clase y lo agrega a la
     * lista de vendedores
     * ------------------------------------------------------------------------------------------------
     * Method that allows creating a vendor taking into account its class attributes and adding it to the
     * seller list
     * @param nombre
     * @param apellido
     * @param cedula
     * @param direccion
     * @param cuenta
     * @return
     * @throws Exception
     */
    public boolean crearVendedor(String nombre, String apellido, String cedula, String direccion, Cuenta cuenta) throws VendedorException {
        Vendedor vendedor = new Vendedor();
        vendedor.setNombre(nombre);
        vendedor.setApellido(apellido);
        vendedor.setCedula(cedula);
        vendedor.setDireccion(direccion);
        vendedor.setCuenta(cuenta);

        if(existeVendedor(cedula)){
            throw new VendedorException("vendedor ya existe");
        }
        getListaVendedores().add(vendedor);
        return true;
    }

    /**
     * Metodo que permite verificar la existencia de un vendedor mediante su cédula
     * ----------------------------------------------------------------------------
     * Method that allows verifying the existence of a seller through his ID
     * @param cedula
     * @return
     */
    private boolean existeVendedor(String cedula) {
        for (Vendedor vendedor : listaVendedores) {
            if (vendedor.getCedula().equals(cedula)) {
                return true;
            }
        }
        return false;
    }

    /**
     * Método que permite actualizar un vendedor utilizando sus atributos de clase
     * ---------------------------------------------------------------------------
     * Method that allows a vendor to be updated using its class attributes
     * @param nombre
     * @param apellido
     * @param cedula
     * @param direccion
     * @param email
     * @param cuenta
     * @return
     */
    public boolean actualizarVendedor(String nombre, String apellido, String cedula, String direccion,String email, Cuenta cuenta) throws VendedorException {

        if (existeVendedor(cedula)) {
            Vendedor vendedor = buscarVendedor(cedula);
            vendedor.setNombre(nombre);
            vendedor.setApellido(apellido);
            vendedor.setDireccion(direccion);
            vendedor.setCuenta(cuenta);
            return true;
        }
        return false;
    }

    /**
     * Método que permite eliminar un vendedor mediante su cédula
     * ----------------------------------------------------------
     * Method that allows to eliminate a seller through his ID
     * @param cedula
     * @return
     */
    public boolean eliminarVendedor(String cedula) throws VendedorException {
        if (existeVendedor(cedula)) {
            Vendedor vendedor = buscarVendedor(cedula);
            getListaVendedores().remove(vendedor);
            return true;
        }
        return false;
    }

    /**
     * Método que permite buscar un vendedor por su cédula
     * ---------------------------------------------------
     * Method that allows you to search for a seller by his ID
     * @param cedula
     * @return
     * @throws Exception
     */
    public Vendedor buscarVendedor(String cedula) throws VendedorException {
        Vendedor vendedorEncontrado = null;
        if (existeVendedor(cedula)) {
            for (Vendedor vendedor : getListaVendedores()) {
                if (vendedor.getCedula().equals(cedula)) {
                    vendedorEncontrado = vendedor;
                    return vendedorEncontrado;
                }
            }
        }
        if (vendedorEncontrado == null) {
            throw new VendedorException("Cliente no encontrado");
        }
        return vendedorEncontrado;
    }


    //-----------------------------------------------CRUD-Producto-----------------------------------------//
    //-----------------------------------------------CRUD-Product-----------------------------------------//

    /**
     * Método que permite crear un producto seteando sus atributos de clase
     * -------------------------------------------------------------------
     * Method that allows creating a product by setting its class attributes
     * @param nombre
     * @param codigo
     * @param categoria
     * @param precio
     * @param estado
     * @param image
     * @param date
     * @return
     * @throws Exception
     */
    public boolean crearProducto(String nombre, String codigo, String categoria, double precio, Estado estado, Image image, String date) throws ProductoExceptions {
        Producto producto = new Producto();
        Muro muro = new Muro();
        producto.setMuro(muro);
        producto.setNombre(nombre);
        producto.setCodigo(codigo);
        producto.setCategoria(categoria);
        producto.setPrecio(precio);
        producto.setEstado(estado);
        producto.setDate(date);
        producto.setImage(image.getUrl());

        if(existeProducto(codigo)){
            throw new ProductoExceptions("producto Hecho");
        }
        getListaProductos().add(producto);
        return true;
    }

    /**
     * Método que permite verificar la existencia de un producto mediante su código
     * ----------------------------------------------------------------------------
     * Method that allows verifying the existence of a product through its code
     * @param codigo
     * @return
     */
    private boolean existeProducto(String codigo) {
        for (Producto producto : listaProductos) {
            if (producto.getCodigo().equals(codigo)) {
                return true;
            }
        }
        return false;
    }

    /**
     * Método que permite actualizar un producto
     * ------------------------------------------
     * Method for updating a product
     * @param nombre
     * @param codigo
     * @param categoria
     * @param precio
     * @param estado
     * @param image
     * @param date
     * @return
     */
    public boolean actualizarProducto(String nombre, String codigo, String categoria, double precio, Estado estado, Image image, String date) throws ProductoExceptions {
        if (existeProducto(codigo)) {
            Producto producto = buscarProducto(codigo);
            producto.setNombre(nombre);
            producto.setCodigo(codigo);
            producto.setCategoria(categoria);
            producto.setPrecio(precio);
            producto.setEstado(estado);
            producto.setImage(image.getUrl());
            producto.setDate(date);
            return true;
        }
        return false;
    }

    /**
     * Método que permite eliminar un producto por su código
     * ----------------------------------------------------
     * Method that allows to eliminate a product by its code
     * @param codigo
     * @return
     */
    public boolean eliminarProducto(String codigo) throws ProductoExceptions {
        if (existeProducto(codigo)) {
            Producto producto = buscarProducto(codigo);
            listaProductos.remove(producto);
            return true;
        }
        return false;
    }

    /**
     * Método que permite buscar un producto mediante su código
     * --------------------------------------------------------
     * Method that allows you to search for a product by its code
     * @param codigo
     * @return
     * @throws Exception
     */
    public Producto buscarProducto(String codigo) throws ProductoExceptions {
        Producto productoEncontrado = null;
        if (existeProducto(codigo)) {
            for (Producto producto : getListaProductos()) {
                if (producto.getCodigo().equals(codigo)) {
                    productoEncontrado = producto;
                    return productoEncontrado;
                }
            }
        }
        if (productoEncontrado == null) {
            throw new ProductoExceptions("Producto no encontrado");
        }
        return productoEncontrado;
    }
    //-------------------------------------------CRUD-Cuenta-----------------------------------------------//
    //-------------------------------------------CRUD-Account-----------------------------------------------//

    /**
     * Método que permite crear un producto seteando sus atributos de clase
     * --------------------------------------------------------------------
     * Method that allows creating a product by setting its class attributes
     * @return
     * @throws Exception
     */
    public boolean crearCuenta(String usuario, String contrasenia) throws CuentaException {
        Cuenta cuenta = new Cuenta();
        cuenta.setUsuario(usuario);
        cuenta.setContrasenia(contrasenia);

        if(existeCuenta(usuario)){
            throw new CuentaException("cuenta Hecha");
        }
        getListaCuentas().add(cuenta);
        return true;
    }

    /**
     * Método que permite verificar la existencia de un producto mediante su código
     * ----------------------------------------------------------------------------
     * Method that allows verifying the existence of a product through its code
     * @return
     */
    private boolean existeCuenta(String usuario) {
        for (Cuenta cuenta : listaCuentas) {
            if (cuenta.getUsuario().equals(usuario)) {
                return true;
            }
        }
        return false;
    }

    /**
     * verifica la cuenta para iniciar sesion
     * @param usuario
     * @param contrasenia
     * @return
     */
    private boolean verificarCuentaContrasenia(String usuario, String contrasenia) {
        for (Cuenta cuenta : listaCuentas) {
            if (cuenta.getUsuario().equals(usuario) && cuenta.getContrasenia().equals(contrasenia)) {
                return true;
            }
        }
        return false;
    }

    /**
     * Método que permite actualizar un producto
     * -----------------------------------------
     * Method for updating a product
     * @return
     */
    public boolean actualizarProducto(String usuario, String contrasenia) throws CuentaException {
        if(existeCuenta(usuario)){
            Cuenta cuenta = buscarCuenta(usuario, contrasenia);
            cuenta.setContrasenia(contrasenia);
            return true;
        }
        return false;
    }

    /**
     * Método que permite eliminar un producto por su código
     * -----------------------------------------------------
     * Method that allows to eliminate a product by its code
     * @return
     */
    public boolean eliminarCuenta(String usuario, String contrasenia) throws CuentaException {
        if (existeCuenta(usuario)) {
            Cuenta cuenta = buscarCuenta(usuario, contrasenia);
            getListaCuentas().remove(cuenta);
            return true;
        }
        return false;
    }

    /**
     * Método que permite buscar un producto mediante su código
     * -------------------------------------------------------
     * Method that allows you to search for a product by its code
     * @return
     * @throws Exception
     */
    public Cuenta buscarCuenta(String usario, String contrasenia) throws CuentaException {
        Cuenta cuentaEncontrado = null;
        if (existeCuenta(usario)) {
            for (Cuenta cuenta : getListaCuentas()) {
                if (cuenta.getUsuario().equals(usario)) {
                    cuentaEncontrado = cuenta;
                    return cuentaEncontrado;
                }
            }
        }
        if (cuentaEncontrado == null) {
            throw new CuentaException("Cuenta no encontrada");
        }
        return cuentaEncontrado;
    }

    public boolean verificarCuenta(String usuario, String contrasenia) {

        return verificarCuentaContrasenia(usuario, contrasenia);
    }

    public boolean verificarCuentaAdmin(String usuario, String contrasenia) {

        return verificarCuentaContraseniaAdmin(usuario, contrasenia);
    }

    public Vendedor buscarVendedorCuenta(String usuario, String contrasenia) throws VendedorException {
        Vendedor vendedorAux = null;

        for (Vendedor vendedor: listaVendedores) {
            if(vendedor.getCuenta().getUsuario().equals(usuario)&&vendedor.getCuenta().getContrasenia().equals(contrasenia)){
                vendedorAux= vendedor;
            }
        }
        if(vendedorAux == null){
            throw new VendedorException("el vendedor no se a encontrado");
        }
        return vendedorAux;
    }

    public ArrayList<Vendedor> obtenerListaVendedoresRecomendados(Vendedor vendedor) {
        ArrayList<Vendedor> listaVendedoresNueva = new ArrayList<>();
        for (Vendedor vendedorAux: listaVendedores) {
            if(verificarVendedorRepetido(vendedor, vendedorAux) && !vendedor.getCedula().equals(vendedorAux.getCedula())){
                listaVendedoresNueva.add(vendedorAux);
            }
        }
        return listaVendedoresNueva;
    }

    private boolean verificarVendedorRepetido(Vendedor vendedor, Vendedor vendedorAux) {

        for (Vendedor vendedor1: vendedor.getListaVendedoresAliados()) {
            if(vendedor1.getCedula().equals(vendedorAux.getCedula())){
                return false;
            }
        }

        for (Vendedor vendedor1: vendedor.getListaSolicitudes()) {
            if(vendedor1.getCedula().equals(vendedorAux.getCedula())){
                return false;
            }
        }

        for (Vendedor vendedor1: vendedorAux.getListaSolicitudes()) {
            if(vendedor1.getCedula().equals(vendedor.getCedula())){
                return false;
            }
        }

        return true;
    }

    public boolean enviarSolicitud(Vendedor vendedorLogeado, Vendedor vendedorSeleccionado) {
        System.out.println(vendedorSeleccionado.getNombre());
        System.out.println(vendedorLogeado.getNombre());
        if(verificarVendedorSolicitud(vendedorLogeado, vendedorSeleccionado) == true){  //verifica si el vendedor tiene una solicitud
            vendedorSeleccionado.getListaSolicitudes().add(vendedorLogeado);
            return true;
        }
        return false;
    }

    private boolean verificarVendedorSolicitud(Vendedor vendedorLogeado, Vendedor vendedorSeleccionado) {
        System.out.println("entra");
        for (Vendedor vendedorAux: vendedorSeleccionado.getListaSolicitudes()) {
            System.out.println(vendedorAux.getCedula());
            System.out.println(vendedorLogeado.getCedula());
            if(vendedorAux.getCedula().equals(vendedorLogeado)){
                return false;
            }
        }
        return true;
    }

    public void aceptarSolicitud(Vendedor vendedorLogeado, Vendedor vendedorSolicitud) {
        vendedorLogeado.getListaVendedoresAliados().add(vendedorSolicitud);
        vendedorSolicitud.getListaVendedoresAliados().add(vendedorLogeado);
        vendedorLogeado.getListaSolicitudes().remove(vendedorSolicitud);
    }

    public void rechazarSolicitud(Vendedor vendedorLogeado, Vendedor vendedorSolicitud) {
        vendedorLogeado.getListaSolicitudes().remove(vendedorSolicitud);
    }

    public void publicarComentario(Producto producto, String comentario) {
        producto.aniadirComentario(comentario);
    }

    public boolean verificarExisteMeGusta(Vendedor vendedorLogeado, Producto producto) {
        return producto.verificarExistencia(vendedorLogeado);
    }


    public void agregarMeGusta(Vendedor vendedorLogeado, Producto producto) {
        producto.aniadirMeGusta(vendedorLogeado);
    }

    public void quitarMeGusta(Vendedor vendedorLogeado, Producto producto) {
        producto.quitarMeGusta(vendedorLogeado);
    }
//----------------------------------------------Admin---------------------------------------------------------//
    public Administrador buscarAdminCuenta(String usuario, String contrasenia) throws AdministradorException{
        Administrador adminAux = null;

        for (Administrador administrador: listaAdministradores) {
            if(administrador.getUsuario().equals(usuario) && administrador.getContrasenia().equals(contrasenia)){
                adminAux= administrador;
            }
        }
        if(adminAux == null){
            throw new AdministradorException("el administrador no se a encontrado");
        }
        return adminAux;
    }

    private boolean verificarCuentaContraseniaAdmin(String usuario, String contrasenia) {
        for (Administrador administrador : listaAdministradores) {
            if (administrador.getUsuario().equals(usuario) && administrador.getContrasenia().equals(contrasenia)) {
                return true;
            }
        }
        return false;
    }
}