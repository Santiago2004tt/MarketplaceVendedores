package MarketplaceVendedores.controllers;

import MarketplaceVendedores.exceptions.CuentaException;
import MarketplaceVendedores.exceptions.VendedorException;
import com.sun.webkit.Timer;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.DialogPane;
import javafx.scene.control.TextField;

import java.io.Serializable;

public class CrearCuentaController implements Serializable {
    private static final long serialVersioUID = 1L;

    @FXML
    private TextField txtNombre;

    @FXML
    private Button btnCrearCuenta;

    @FXML
    private TextField txtDireccion;

    @FXML
    private Button btnVolver;

    @FXML
    private TextField txtApellido;

    @FXML
    private TextField txtContrasenia;

    @FXML
    private TextField txtCedula;

    @FXML
    private TextField txtUsuario;

    @FXML
    void crearCuentaAction(ActionEvent event) throws CuentaException, VendedorException {
        crearCuentaVendedorAction();
    }

    @FXML
    void volverAction(ActionEvent event) {
        ModelFactoryController.getInstance().volverInicioSesion();;
    }

    private void crearCuentaVendedorAction() throws CuentaException, VendedorException {
        String nombre = txtNombre.getText();
        String apellido = txtApellido.getText();
        String cedula = txtCedula.getText();
        String direccion = txtDireccion.getText();
        String usuario = txtUsuario.getText();
        String contrasenia = txtContrasenia.getText();

        if (verificarCampos(nombre, apellido, cedula, direccion, usuario, contrasenia)){
            if(ModelFactoryController.getInstance().crearVendedor(nombre,apellido, cedula,direccion, usuario, contrasenia)){
                limpiarCampos();
                mostrarMensaje("Notificacion vendedor", "Vendedor creado", "El vendedor se a creado", Alert.AlertType.INFORMATION);
            }
        }else {
            mostrarMensaje("Notificacion vendedor", "rellenar los datos", "datos incompletos, por favor rellenar", Alert.AlertType.ERROR);
        }
    }

    private boolean verificarCampos(String nombre, String apellido, String cedula, String direccion, String usuario, String contrasenia) {

        if(nombre.equals("")){
            return false;

        }
        if(apellido.equals("")){
            return false;

        }
        if(cedula.equals("")){
            return false;

        }
        if(direccion.equals("")){
            return false;

        }
        if(usuario.equals("")){
            return false;

        }
        if(contrasenia.equals("")){
            return false;

        }
        return true;
    }

    private void limpiarCampos() {
        txtNombre.clear();
        txtApellido.clear();
        txtCedula.clear();
        txtDireccion.clear();
        txtUsuario.clear();
        txtContrasenia.clear();
    }

    public void mostrarMensaje(String titulo, String header, String contenido, Alert.AlertType alertType) {

        Alert alert = new Alert(alertType);
        alert.setTitle(titulo);
        alert.setHeaderText(header);
        alert.setContentText(contenido);
        DialogPane dialogPane = alert.getDialogPane();
        alert.showAndWait();
    }

}