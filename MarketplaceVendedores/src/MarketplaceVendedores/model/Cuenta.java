package MarketplaceVendedores.model;
import java.io.Serializable;
import java.util.Objects;

/**
 * Clase Cuenta
 * ---English---
 * Account class
 */
public class Cuenta implements Serializable {

    /**
     * Atributos
     * ---------
     * attributes
     */
    private static final long serialVersioUID = 1L;

    private String usuario;
    private String contrasenia;

    /**
     * Constructor
     * -----------
     * Builder
     * @param usuario
     * @param contrasenia
     */
    public Cuenta(String usuario, String contrasenia) {
        this.usuario = usuario;
        this.contrasenia = contrasenia;
    }

    /**
     * Constructor vacío
     * ---------------
     * Void builder
     */
    public Cuenta(){

    }

    /**
     * get y set de usuario
     * -------------------
     * Getter and Setter the user
     * @return
     */
    public String getUsuario() {
        return usuario;
    }

    public void setUsuario(String usuario) {
        this.usuario = usuario;
    }

    /**
     * get y set de contraseña
     * -----------------------
     * getter and Setter the password
     * @return
     */
    public String getContrasenia() {
        return contrasenia;
    }

    public void setContrasenia(String contrasenia) {
        this.contrasenia = contrasenia;
    }

    /**
     *Equals y hashcode con usuario y contraseña
     * ------------------------------
     * equals and Hashcode with user and password
     */
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Cuenta cuenta = (Cuenta) o;
        return Objects.equals(usuario, cuenta.usuario) && Objects.equals(contrasenia, cuenta.contrasenia);
    }

    @Override
    public int hashCode() {
        return Objects.hash(usuario, contrasenia);
    }

    @Override
    public String toString() {
        return "Cuenta{" +
                "usuario='" + usuario  +
                ", contrasenia='" + contrasenia  +
                '}';
    }
}
