package MarketplaceVendedores.controllers;

import MarketplaceVendedores.application.Main;
import MarketplaceVendedores.model.Vendedor;
import MarketplaceVendedores.test.Miguel;
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
        Miguel.getInstance().mostrarMainVendedor(new Vendedor());
    }


    public void setMain(Main main) {
        this.main = main;
    }
}
