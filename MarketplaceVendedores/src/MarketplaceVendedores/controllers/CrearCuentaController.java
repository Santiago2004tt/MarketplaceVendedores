package MarketplaceVendedores.controllers;

import MarketplaceVendedores.exceptions.CuentaException;
import MarketplaceVendedores.exceptions.VendedorException;
import MarketplaceVendedores.model.Cuenta;
import MarketplaceVendedores.model.Vendedor;
import MarketplaceVendedores.test.Huendy;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;

public class CrearCuentaController {

    private Huendy huendy;

    Vendedor vendedor;

    private Cuenta cuentaLogeada = null;
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
    private TextField txtCedula;

    @FXML
    private TextField txtUsuario;

    @FXML
    private TextField txtContrasenia;

    @FXML
    void crearCuentaAction(ActionEvent event) throws CuentaException, VendedorException {
        crearCuentaVendedorAction();
    }

    private void crearCuentaVendedorAction() throws CuentaException, VendedorException{
        String nombre = txtNombre.getText();
        String apellido = txtApellido.getText();
        String cedula = txtCedula.getText();
        String direccion = txtDireccion.getText();
        String usuario = txtUsuario.getText();
        String contrasenia = txtContrasenia.getText();
        try{
            if (verificarCampos(nombre, apellido, cedula, direccion, usuario, contrasenia)){
                huendy.getInstance().crearCuenta(usuario, contrasenia);
                Cuenta cuenta = huendy.getInstance().buscarCuenta(usuario,contrasenia);
                boolean registroCompleto = huendy.getInstance().crearVendedor(nombre,apellido, cedula,direccion, cuenta);
                System.out.println("funciono");
                if(registroCompleto){
                    Alert alert = new Alert(Alert.AlertType.INFORMATION);
                    alert.setHeaderText("Listo!!");
                    alert.setContentText("registro creado");
                    alert.showAndWait();
                    limpiarCampos();
                }else {
                    Alert alert = new Alert(Alert.AlertType.INFORMATION);
                    alert.setHeaderText("Error");
                    alert.setContentText("no fue posible terminar el registro");
                    alert.showAndWait();
                }
            }else {
                Alert alert = new Alert(Alert.AlertType.INFORMATION);
                alert.setHeaderText("Error");
                alert.setContentText("Rellena los campos de texto faltantes y vuelve a intentar");
                alert.showAndWait();
            }
        } catch (CuentaException e){
            Alert alert = new Alert(Alert.AlertType.INFORMATION);
            alert.setHeaderText("Error");
            alert.setContentText("Rellena los campos de texto faltantes y vuelve a intentar");
            alert.showAndWait();
        }
    }

    private void limpiarCampos() {
        txtNombre.clear();
        txtApellido.clear();
        txtCedula.clear();
        txtDireccion.clear();
        txtUsuario.clear();
        txtContrasenia.clear();
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

    @FXML
    void volverAction(ActionEvent event) {
        huendy.MostrarMuroVendedorPrincipal();
    }

    public void setMain(Huendy huendy) {
        this.huendy = huendy;
    }

    public void obtenerVendedor(Vendedor vendedor) {
        this.vendedor = vendedor;
    }
}