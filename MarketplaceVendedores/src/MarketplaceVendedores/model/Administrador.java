package MarketplaceVendedores.model;

/**
 * Clase administrador
 * hereda de Usuario
 * ------English-------
 * class admin
 * class heiress the user
 */
public class Administrador extends Usuario{

    /**
     * atributos clase Usuario
     * ------English-----------
     * attributes the class User
     * @param nombre
     * @param apellido
     * @param cedula
     * @param direccion
     * @param cuenta
     */
    public Administrador(String nombre, String apellido, String cedula, String direccion, Cuenta cuenta) {
        super(nombre, apellido, cedula, direccion, cuenta);
    }

    public Administrador() {

    }
}
