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
import javafx.scene.control.DialogPane;
import javafx.scene.control.TextField;

public class CrearCuentaController {

    private ModelFactoryController modelFactoryController;

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
        System.out.println("hola");
        String nombre = txtNombre.getText();
        String apellido = txtApellido.getText();
        String cedula = txtCedula.getText();
        String direccion = txtDireccion.getText();
        String usuario = txtUsuario.getText();
        String contrasenia = txtContrasenia.getText();
        System.out.println("hola");

            if (verificarCampos(nombre, apellido, cedula, direccion, usuario, contrasenia)){
                System.out.println("funciono");
                if(modelFactoryController.getInstance().crearVendedor(nombre,apellido, cedula,direccion, usuario, contrasenia)){
                    limpiarCampos();
                    mostrarMensaje("Notificacion vendedor", "Vendedor no eliminado", "El vendedor No ha sido eliminado", Alert.AlertType.ERROR);
                }else {
                    mostrarMensaje("Notificacion vendedor", "Vendedor no eliminado", "El vendedor No ha sido eliminado", Alert.AlertType.ERROR);
                }
            }else {
                mostrarMensaje("Notificacion vendedor", "Vendedor no eliminado", "El vendedor No ha sido eliminado", Alert.AlertType.ERROR);

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
        volverInicioSesion();
    }

    private void volverInicioSesion() {
        ModelFactoryController.getInstance().volverInicioSesion();
    }

    public void mostrarMensaje(String titulo, String header, String contenido, Alert.AlertType alertType) {

        Alert alert = new Alert(alertType);
        alert.setTitle(titulo);
        alert.setHeaderText(header);
        alert.setContentText(contenido);
        DialogPane dialogPane = alert.getDialogPane();
        alert.showAndWait();
    }


    //crear cuenta esta es bugeada despues se organiza

}