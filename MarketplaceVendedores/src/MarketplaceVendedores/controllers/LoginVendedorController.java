package MarketplaceVendedores.controllers;

import MarketplaceVendedores.application.Main;
import MarketplaceVendedores.exceptions.CuentaException;
import MarketplaceVendedores.exceptions.VendedorException;
import MarketplaceVendedores.model.Cuenta;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.*;

import java.io.Serializable;

public class LoginVendedorController implements Serializable {
    private static final long serialVersioUID = 1L;
    @FXML
    private TextField txtVendedorUser;
    @FXML
    private Button btnLogin;
    @FXML
    private Button btnCrearCuenta;
    @FXML
    private PasswordField txtVendedorPassword;

    @FXML
    void crearCuentaAction(ActionEvent event) {
        accederCrearCuenta();
    }

    private void accederCrearCuenta() {
        ModelFactoryController.getInstance().accederCrearCuenta();
    }

    @FXML
    void logInAction(ActionEvent event) throws VendedorException, CuentaException {
        logInActionEvent();
    }

    private void logInActionEvent() throws VendedorException, CuentaException {
        String usuario = txtVendedorUser.getText();
        String contrasenia = txtVendedorPassword.getText();
        if(validarDatos(usuario, contrasenia)){
            //prueba
            //Cuenta cuenta = ModelFactoryController.getInstance().buscarCuenta("12", "12");
            //System.out.println(cuenta.getUsuario()+ " existe");
            ModelFactoryController.getInstance().iniciarSesion(usuario, contrasenia);
        } else{
            mostrarMensaje("Notificacion vendedor", "Vendedor no eliminado", "El vendedor No ha sido eliminado", Alert.AlertType.ERROR);
        }
    }

    private boolean validarDatos(String usuario, String contrasenia) {
        if(usuario.equals("") || contrasenia.equals("")){
            return false;
        }
        return true;
    }

    public void mostrarMensaje(String titulo, String header, String contenido, Alert.AlertType alertType) {

        Alert alert = new Alert(alertType);
        alert.setTitle(titulo);
        alert.setHeaderText(header);
        alert.setContentText(contenido);
        DialogPane dialogPane = alert.getDialogPane();
        alert.showAndWait();
    }

    public void setMain(Main main) {
        ModelFactoryController.getInstance().aniadirMain(main);
    }
}
