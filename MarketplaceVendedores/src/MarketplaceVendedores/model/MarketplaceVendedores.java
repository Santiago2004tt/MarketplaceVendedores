package MarketplaceVendedores.model;

import java.awt.*;
import java.util.ArrayList;

public class MarketplaceVendedores {
    private String nombre;
    private ArrayList<Producto> listaProductos;
    private ArrayList<Vendedor> listaVendedores;
    private ArrayList<Cuenta> listaCuentas;

    /**
     * Constructor de la clase MarketplaceVendedores
     * @param nombre
     */

    public MarketplaceVendedores(String nombre) {
        this.nombre = nombre;
        listaVendedores = new ArrayList<Vendedor>();
        listaProductos = new ArrayList<Producto>();
        listaCuentas = new ArrayList<Cuenta>();
    }

    //GETTERS AND SETTERS----------------------------------------------------------------------------
    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public ArrayList<Producto> getListaProductos() {
        return listaProductos;
    }

    public void setListaProductos(ArrayList<Producto> listaProductos) {
        this.listaProductos = listaProductos;
    }

    public ArrayList<Vendedor> getListaVendedores() {
        return listaVendedores;
    }

    public void setListaVendedores(ArrayList<Vendedor> listaVendedores) {
        this.listaVendedores = listaVendedores;
    }

    public ArrayList<Cuenta> getListaCuentas() {
        return listaCuentas;
    }

    public void setListaCuentas(ArrayList<Cuenta> listaCuentas) {
        this.listaCuentas = listaCuentas;
    }

    //--------------------------------------------------------------------------------------------

    //---------------------------------CRUD---------------------------------------------------------

    /**
     * Metodo que permite crear un vendedor teniendo en cuenta sus atributos de clase y lo agrega a la
     * lista de vendedores
     * @param nombre
     * @param apellido
     * @param cedula
     * @param direccion
     * @param cuenta
     * @return
     * @throws Exception
     */
    public boolean crearVendedor(String nombre, String apellido, String cedula, String direccion, Cuenta cuenta) throws Exception {
        Vendedor vendedor = new Vendedor();
        Muro muro = new Muro();
        vendedor.setNombre(nombre);
        vendedor.setApellido(apellido);
        vendedor.setCedula(cedula);
        vendedor.setDireccion(direccion);
        vendedor.setCuenta(cuenta);
        vendedor.setMuro(muro);

        if(existeVendedor(cedula)){
            throw new Exception("Cliente Hecho");
        }
        getListaVendedores().add(vendedor);
        return true;
    }

    /**
     * Metodo que permite verificar la existencia de un vendedor mediante su cedula
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
     * Metodo que permite actualizar un vendedor utilizando sus atributos de clase
     * @param nombre
     * @param apellido
     * @param cedula
     * @param direccion
     * @param email
     * @param cuenta
     * @return
     */
    public boolean actualizarVendedor(String nombre, String apellido, String cedula, String direccion,String email, Cuenta cuenta) {
        //se recorre la lista de vendedores
        for (Vendedor vendedor : listaVendedores) {
            if (vendedor.getCedula().equals(cedula)) {
                vendedor.setNombre(nombre);
                vendedor.setApellido(apellido);
                vendedor.setDireccion(direccion);
                vendedor.setCuenta(cuenta);
                return true;
            }
        }
        return false;
    }

    /**
     * Metodo que permite eliminar un vendedor mediante su cedula
     * @param cedula
     * @return
     */
    public boolean eliminarVendedor(String cedula) {
        if (existeVendedor(cedula)) {
            for (Vendedor vendedor : listaVendedores) {
                if (vendedor.getCedula().equals(cedula)) {
                    getListaVendedores().remove(vendedor);
                    return true;
                }
            }
        }
        return false;
    }

    /**
     * Metodo que permite buscar un vendedor por su cedula
     * @param cedula
     * @return
     * @throws Exception
     */
    public Vendedor buscarVendedor(String cedula) throws Exception {
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
            throw new Exception("Cliente no encontrado");
        }
        return vendedorEncontrado;
    }


    //-----------------------------------------------------------------------------------------------

    /**
     * Metodo que permite crear un producto setteando sus atributos de clase
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
    public boolean crearProducto(String nombre, String codigo, String categoria, double precio, Estado estado, Image image, String date) throws Exception {
        Producto producto = new Producto();
        producto.setNombre(nombre);
        producto.setCodigo(codigo);
        producto.setCategoria(categoria);
        producto.setPrecio(precio);
        producto.setEstado(estado);
        producto.setDate(date);
        producto.setImage(image);

        if(existeProducto(codigo)){
            throw new Exception("producto Hecho");
        }
        getListaProductos().add(producto);
        return true;
    }

    /**
     * Metodo que permite verificar la existencia de un producto mediante su codigo
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
     * Metodo que permite actualizar un producto
     * @param nombre
     * @param codigo
     * @param categoria
     * @param precio
     * @param estado
     * @param image
     * @param date
     * @return
     */
    public boolean actualizarProducto(String nombre, String codigo, String categoria, double precio, Estado estado, Image image, String date) {
        for (Producto producto : listaProductos) {
            if (producto.getCodigo().equals(codigo)) {
                producto.setNombre(nombre);
                producto.setCodigo(codigo);
                producto.setCategoria(categoria);
                producto.setPrecio(precio);
                producto.setEstado(estado);
                producto.setImage(image);
                producto.setDate(date);
                return true;
            }
        }
        return false;
    }

    /**
     * Metodo que permite eliminar un producto por su codigo
     * @param codigo
     * @return
     */
    public boolean eliminarProducto(String codigo) {
        if (existeProducto(codigo)) {
            for (Producto producto : listaProductos) {
                if (producto.getCodigo().equals(codigo)) {
                    getListaVendedores().remove(producto);
                    return true;
                }
            }
        }
        return false;
    }

    /**
     * metodo que permite buscar un producto mediante su codigo
     * @param codigo
     * @return
     * @throws Exception
     */
    public Producto buscarProducto(String codigo) throws Exception {
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
            throw new Exception("Producto no encontrado");
        }
        return productoEncontrado;
    }
}
