package MarketplaceVendedores.controllers;

import MarketplaceVendedores.model.Vendedor;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Tab;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;

public class RecomendadosController {

    private Vendedor vendedorLogeado;

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
    public void inicializarVendedor(Vendedor vendedorLogeado) {
        this.vendedorLogeado = vendedorLogeado;
    }

}

