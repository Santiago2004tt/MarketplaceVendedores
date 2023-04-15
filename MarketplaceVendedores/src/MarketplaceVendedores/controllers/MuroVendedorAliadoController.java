package MarketplaceVendedores.controllers;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;

public class MuroVendedorAliadoController {

    @FXML
    private Button btnSalir;

    @FXML
    private Label txtNombre;

    @FXML
    private Label txtDireccion;

    @FXML
    private Label txtApellido;

    @FXML
    private TableView<?> tableListaProductos;

    @FXML
    private TableColumn<?, ?> columnNombre;

    @FXML
    private TableColumn<?, ?> columnPrecio;

    @FXML
    private TableColumn<?, ?> columnCategoria;

    @FXML
    private Button btnProducto;

    @FXML
    void salirMuroVendedor(ActionEvent event) {

    }

    @FXML
    void accederVerProducto(ActionEvent event) {

    }

}
