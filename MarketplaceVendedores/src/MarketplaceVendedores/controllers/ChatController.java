package MarketplaceVendedores.controllers;

import MarketplaceVendedores.model.Comentario;
import MarketplaceVendedores.model.Mensaje;
import MarketplaceVendedores.model.Muro;
import MarketplaceVendedores.model.Vendedor;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;

import java.util.ArrayList;

public class ChatController {

    Vendedor vendedorLogeado;
    Vendedor vendedorVisitante;
    Mensaje mensajeSeleccionado=null;
    ObservableList<Mensaje> listaComentariosLog= FXCollections.observableArrayList();
    ObservableList<Mensaje> listaComentariosVis= FXCollections.observableArrayList();

    @FXML
    private Button btnAtras;

    @FXML
    private TableColumn<Mensaje, String> columnMensajeVisitante;

    @FXML
    private TableView<Mensaje> tblMensajesVisitante;

    @FXML
    private Button btnEnviar;

    @FXML
    private TextField textFieldMensaje;

    @FXML
    private TableView<Mensaje> tblMensajesLog;

    @FXML
    private TableColumn<Mensaje, String> columnMensajeLog;

    @FXML
    void volver(ActionEvent event) {
        ModelFactoryController.getInstance().visitarVendedoresAction(vendedorLogeado);
    }

    @FXML
    void enviar(ActionEvent event) {
        enviarMensaje();
    }

    private void enviarMensaje() {
        String mensaje = textFieldMensaje.getText();
        if(!mensaje.equals("")){
            ModelFactoryController.getInstance().enviarMensajeChat(vendedorVisitante, vendedorLogeado.getCedula(), "");
            ModelFactoryController.getInstance().enviarMensajeChat(vendedorLogeado, vendedorVisitante.getCedula(), mensaje);
            inicializarTablas();
            tblMensajesLog.refresh();
            tblMensajesVisitante.refresh();
            textFieldMensaje.setText("");
        }
    }

    public void anidirVendedores(Vendedor vendedorLogeado, Vendedor vendedorVisitante) {
        this.vendedorLogeado = vendedorLogeado;
        this.vendedorVisitante = vendedorVisitante;
        columnMensajeLog.setText(vendedorLogeado.getNombre()+" "+vendedorLogeado.getApellido());
        columnMensajeVisitante.setText(vendedorVisitante.getNombre()+" "+vendedorVisitante.getApellido());
        inicializarTablas();
    }

    @FXML
    void initialize(){
        this.columnMensajeLog.setCellValueFactory(new PropertyValueFactory<>("mensaje"));

        this.columnMensajeVisitante.setCellValueFactory(new PropertyValueFactory<>("mensaje"));

        tblMensajesLog.getSelectionModel().selectedItemProperty().addListener((obs,oldSelection, newSelection) -> {
            mensajeSeleccionado = newSelection;
        });

        tblMensajesVisitante.getSelectionModel().selectedItemProperty().addListener((obs,oldSelection, newSelection) -> {
            mensajeSeleccionado = newSelection;
        });
    }

    private ObservableList<Mensaje> obtenerListaMensajeLog() {
        tblMensajesLog.getItems().clear();
        listaComentariosLog.addAll(ModelFactoryController.getInstance().obtenerMensajesLog(vendedorLogeado, vendedorVisitante.getCedula()));
        return listaComentariosLog;
    }

    private ObservableList<Mensaje> obtenerListaMensajeVis() {
        tblMensajesVisitante.getItems().clear();
        listaComentariosVis.addAll(ModelFactoryController.getInstance().obtenerMensajesLog(vendedorVisitante, vendedorLogeado.getCedula()));
        return listaComentariosVis;
    }

    private void inicializarTablas() {
        tblMensajesLog.setItems(obtenerListaMensajeLog());
        tblMensajesVisitante.setItems(obtenerListaMensajeVis());
    }
}
