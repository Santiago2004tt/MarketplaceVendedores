package MarketplaceVendedores.controllers;

import MarketplaceVendedores.application.Main;
import MarketplaceVendedores.exceptions.AdministradorException;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.*;

import java.io.Serializable;
import java.util.ResourceBundle;

public class LoginAdministradorController implements Serializable {


    @FXML
    private ResourceBundle resources;

    @FXML
    private Button btnLoginAdmin;

    @FXML
    private Button btnVolver;

    @FXML
    private PasswordField txtAdministradorPassword;

    @FXML
    private TextField txtAdministradorUser;

    @FXML
    void volverAction(ActionEvent event) {
        volverLogin();
    }

    private void volverLogin() {
        ModelFactoryController.getInstance().volverLogin();
    }

    @FXML
    void logInAction(ActionEvent event) throws AdministradorException {
        logInActionEvent();
    }

    private void logInActionEvent() throws AdministradorException{
        String usuario = txtAdministradorUser.getText();
        String contrasenia = txtAdministradorPassword.getText();
        if(validarDatos(usuario, contrasenia)){
            ModelFactoryController.getInstance().iniciarSesionAdmin(usuario, contrasenia);
        } else{
            mostrarMensaje("Notificacion admin", "Admin no eliminado", "El admin No ha sido eliminado", Alert.AlertType.ERROR);
        }
    }

    private void mostrarMensaje(String titulo, String header,String contenido, Alert.AlertType alertType) {
        Alert alert = new Alert(alertType);
        alert.setTitle(titulo);
        alert.setHeaderText(header);
        alert.setContentText(contenido);
        DialogPane dialogPane = alert.getDialogPane();
        alert.showAndWait();
    }

    private boolean validarDatos(String usuario, String contrasenia) {
        if(usuario.equals("") || contrasenia.equals("")){
            return false;
        }
        return true;
    }

    public void setMain(Main main) {
        ModelFactoryController.getInstance().aniadirMain(main);
    }

    @FXML
    void initialize() {

    }
}
