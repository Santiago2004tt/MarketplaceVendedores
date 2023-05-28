package MarketplaceVendedores.model;

import java.io.Serializable;

public class Administrador implements Serializable {

    private String nombre;
    private String usuario;
    private String contrasenia;

    private static final long serialVersioUID = 1L;

    public Administrador(String nombre, String usuario, String contrasenia) {
        this.nombre = nombre;
        this.usuario = usuario;
        this.contrasenia = contrasenia;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getUsuario() {
        return usuario;
    }

    public void setUsuario(String usuario) {
        this.usuario = usuario;
    }

    public String getContrasenia() {
        return contrasenia;
    }

    public void setContrasenia(String contrasenia) {
        this.contrasenia = contrasenia;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Administrador that)) return false;

        if (getUsuario() != null ? !getUsuario().equals(that.getUsuario()) : that.getUsuario() != null) return false;
        return getContrasenia() != null ? getContrasenia().equals(that.getContrasenia()) : that.getContrasenia() == null;
    }

    @Override
    public int hashCode() {
        int result = getUsuario() != null ? getUsuario().hashCode() : 0;
        result = 31 * result + (getContrasenia() != null ? getContrasenia().hashCode() : 0);
        return result;
    }

    @Override
    public String toString() {
        return "Administrador{" +
                "nombre='" + nombre + '\'' +
                ", usuario='" + usuario + '\'' +
                ", contrasenia='" + contrasenia + '\'' +
                '}';
    }
}
