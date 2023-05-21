package MarketplaceVendedores.controllers;

import MarketplaceVendedores.model.Vendedor;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.*;

import java.io.Serializable;

public class RecomendadosController implements Serializable {
    private static final long serialVersioUID = 1L;
    private Vendedor vendedorLogeado;
    ObservableList<Vendedor> listaVendedorData= FXCollections.observableArrayList();
    Vendedor vendedorSeleccionado = null;

    @FXML
    private Tab tabRecomendados;

    @FXML
    private TableColumn<Vendedor, String> columNombreSolicitud;

    @FXML
    private TableView<Vendedor> tablaVendedoresAliados;

    @FXML
    private TableColumn<Vendedor, String> columnNombreVendedor;

    @FXML
    private TableView<Vendedor> tablaSolicitudes;

    @FXML
    private Button btnEnviarSolicitud;

    @FXML
    private Button btnVisitar;

    @FXML
    private Tab tabVendedoresAliados;

    @FXML
    private TableColumn<Vendedor, String> columnApellidoVendedor;

    @FXML
    private Tab tabSolicitudes;

    @FXML
    private TableColumn<Vendedor, String> columnApellidoRecomendados;

    @FXML
    private Button btnVolver;

    @FXML
    private Button btnAceptar;

    @FXML
    private Button btnChat;

    @FXML
    private Button btnRechazar;

    @FXML
    private TableColumn<Vendedor, String> columnNombreRecomendados;

    @FXML
    private TableColumn<Vendedor, String> columApellidoSolicitud;

    @FXML
    private TableView<Vendedor> tablaRecomendados;

    @FXML
    void visitarAction(ActionEvent event) {

    }

    @FXML
    void chatAction(ActionEvent event) {

    }

    @FXML
    void aceptarSolicitudAction(ActionEvent event) {

    }

    @FXML
    void rechazarSolicitudAction(ActionEvent event) {

    }

    @FXML
    void enviarSolicitudAction(ActionEvent event) {

    }

    @FXML
    void volverAction(ActionEvent event) {
        volverEvent();
    }

    private void volverEvent(){
        ModelFactoryController.getInstance().accederCuenta(vendedorLogeado);
    }

    public void mostrarMensaje(String titulo, String header, String contenido, Alert.AlertType alertType) {

        Alert alert = new Alert(alertType);
        alert.setTitle(titulo);
        alert.setHeaderText(header);
        alert.setContentText(contenido);
        DialogPane dialogPane = alert.getDialogPane();
        dialogPane.getStylesheets().add(getClass().getResource("../stylesheets/AlertsStylesheets.css").toExternalForm());
        dialogPane.getStyleClass().add("dialog");
        alert.showAndWait();
    }

    public void inicializarVendedor(Vendedor vendedorLogeado) {
        this.vendedorLogeado = vendedorLogeado;
    }

}

