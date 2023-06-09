package MarketplaceVendedores.controllers;

import MarketplaceVendedores.model.Vendedor;
import com.sun.webkit.Timer;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;

import java.io.Serializable;
import java.util.ArrayList;

public class RecomendadosController implements Serializable {
    private static final long serialVersioUID = 1L;
    private Vendedor vendedorLogeado;
    ObservableList<Vendedor> listaVendedorRecomendadosData= FXCollections.observableArrayList();
    ObservableList<Vendedor> listaVendedorSolicitudesData= FXCollections.observableArrayList();
    ObservableList<Vendedor> listaVendedorAliadosData= FXCollections.observableArrayList();
    Vendedor vendedorAliado = null;
    Vendedor vendedorRecomendado= null;
    Vendedor vendedorSolicitud = null;

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
        visitarVendedor();
    }

    private void visitarVendedor() {
        if(vendedorAliado != null){
            ModelFactoryController.getInstance().visitarVendedorAliado(vendedorLogeado, vendedorAliado);
        }else {
            mostrarMensaje("Notificacion vendedor", "Vendedor no seleccionado", "El vendedor No ha sido seleccionado", Alert.AlertType.ERROR);
        }
    }

    @FXML
    void chatAction(ActionEvent event) {
        visitarChat();
    }

    private void visitarChat() {
        if(vendedorAliado != null){
            ModelFactoryController.getInstance().visitarChat(vendedorLogeado, vendedorAliado);
        }
    }

    @FXML
    void aceptarSolicitudAction(ActionEvent event) {
        aceptarSolicitudEvent();
    }

    private void aceptarSolicitudEvent() {
        if(vendedorSolicitud != null){
            ModelFactoryController.getInstance().aceptarSolicitud(vendedorLogeado, vendedorSolicitud);
            inicializarTablas(vendedorLogeado);
            tablaSolicitudes.refresh();
            tablaRecomendados.refresh();
            tablaVendedoresAliados.refresh();
            mostrarMensaje("Notificacion vendedor", "Vendedor aceptado", "Se ha aceptado la solicitud", Alert.AlertType.INFORMATION);
        }else {
            mostrarMensaje("Notificacion vendedor", "Vendedor no seleccionado", "El vendedor No ha sido seleccionado", Alert.AlertType.ERROR);
        }
    }

    @FXML
    void rechazarSolicitudAction(ActionEvent event) {
        rechazarSolicitudEvent();
    }

    private void rechazarSolicitudEvent() {
        if(vendedorSolicitud != null){
            ModelFactoryController.getInstance().rechazarSolicitud(vendedorLogeado, vendedorSolicitud);
            inicializarTablas(vendedorLogeado);
            tablaSolicitudes.refresh();
            tablaRecomendados.refresh();
            tablaVendedoresAliados.refresh();
            mostrarMensaje("Notificacion vendedor", "Vendedor rechazado", "Se ha rechazado la solicitud", Alert.AlertType.INFORMATION);
        }else {
            mostrarMensaje("Notificacion vendedor", "Vendedor no seleccionado", "El vendedor No ha sido seleccionado", Alert.AlertType.ERROR);
        }
    }

    @FXML
    void enviarSolicitudAction(ActionEvent event) {
        enviarSolicitudEvent();
    }

    private void enviarSolicitudEvent() {
        if(vendedorRecomendado != null){
            ModelFactoryController.getInstance().enviarSolicitud(vendedorLogeado, vendedorRecomendado);
            tablaRecomendados.setItems(obtenerVendedoresRecomendados(vendedorLogeado));
        }else{
            mostrarMensaje("Notificacion vendedor", "Vendedor no seleccionado", "El vendedor No ha sido seleccionado", Alert.AlertType.ERROR);
        }
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
        dialogPane.getStyleClass().add("dialog");
        alert.showAndWait();
    }

    @FXML
    void initialize(){
        this.columnNombreRecomendados.setCellValueFactory(new PropertyValueFactory<>("nombre"));
        this.columnApellidoRecomendados.setCellValueFactory(new PropertyValueFactory<>("apellido"));

        this.columNombreSolicitud.setCellValueFactory(new PropertyValueFactory<>("nombre"));
        this.columApellidoSolicitud.setCellValueFactory(new PropertyValueFactory<>("apellido"));

        this.columnNombreVendedor.setCellValueFactory(new PropertyValueFactory<>("nombre"));
        this.columnApellidoVendedor.setCellValueFactory(new PropertyValueFactory<>("apellido"));

        tablaVendedoresAliados.getSelectionModel().selectedItemProperty().addListener((obs,oldSelection, newSelection) -> {
            vendedorAliado = newSelection;
        });

        tablaRecomendados.getSelectionModel().selectedItemProperty().addListener((obs,oldSelection, newSelection) -> {
            vendedorRecomendado = newSelection;
        });

        tablaSolicitudes.getSelectionModel().selectedItemProperty().addListener((obs,oldSelection, newSelection) -> {
            vendedorSolicitud = newSelection;
        });
    }

    private ObservableList<Vendedor> obtenerVendedoresAliados(ArrayList<Vendedor> listaVendedores) {
        tablaVendedoresAliados.getItems().clear();
        listaVendedorAliadosData.addAll(listaVendedores);
        return listaVendedorAliadosData;
    }

    private ObservableList<Vendedor> obtenerVendedoresRecomendados(Vendedor vendedor) {
        tablaRecomendados.getItems().clear();
        listaVendedorRecomendadosData.addAll(ModelFactoryController.getInstance().obtenerVendedores(vendedor));
        return listaVendedorRecomendadosData;
    }

    private ObservableList<Vendedor> obtenerVendedoresSolicitudes(ArrayList<Vendedor> listaVendedores) {
        tablaSolicitudes.getItems().clear();
        listaVendedorSolicitudesData.addAll(listaVendedores);
        return listaVendedorSolicitudesData;
    }

    public void inicializarVendedor(Vendedor vendedorLogeado) {
        this.vendedorLogeado = vendedorLogeado;
        inicializarTablas(vendedorLogeado);
    }
    private void inicializarTablas(Vendedor vendedorLogeado) {
        tablaVendedoresAliados.setItems(obtenerVendedoresAliados(vendedorLogeado.getListaVendedoresAliados()));
        tablaRecomendados.setItems(obtenerVendedoresRecomendados(vendedorLogeado));
        tablaSolicitudes.setItems(obtenerVendedoresSolicitudes(vendedorLogeado.getListaSolicitudes()));

    }

}

