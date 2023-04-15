package MarketplaceVendedores.controllers;

import MarketplaceVendedores.application.Main;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;

public class LoginVendedorController {

    private Main main;

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

    }
    @FXML
    void logInAction(ActionEvent event) {
        main.mostrarMainVendedor();
    }

    private void iniciarSesionVendedor(ActionEvent event){
        String user= "";
        String passWord= "";
        user = txtVendedorUser.getText();
        passWord= txtVendedorPassword.getText();


    }

    private boolean verificarCampos(String usuario, String contrasena) {
        if(usuario.equals("")||contrasena.equals("")){
            return false;
        }
        return true;
    }
    public void setMain(Main main) {
        this.main = main;
    }
}
