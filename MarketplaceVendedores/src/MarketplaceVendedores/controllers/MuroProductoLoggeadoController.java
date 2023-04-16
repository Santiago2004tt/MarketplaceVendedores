package MarketplaceVendedores.controllers;

import MarketplaceVendedores.model.Producto;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.image.ImageView;

public class MuroProductoLoggeadoController {
    @FXML
    private Label labelEstadoProducto;

    @FXML
    private Button btnRegresar;

    @FXML
    private Label labelNombreProducto;

    @FXML
    private Label labelCategoriaProducto;

    @FXML
    private Label labelPrecioProducto;

    @FXML
    private ImageView imgViewProductoLoggeado;

    @FXML
    private TableView<Producto> tblProductosLoggeados;

    @FXML
    private Label labelCantidadMeGustaProducto;

    @FXML
    private Label labelFechaProducto;
    @FXML
    private TableColumn<Producto, String> columnCodigoProducto;

    @FXML
    private TableColumn<Producto, String> columnNombreProducto;


    @FXML
    void regresarAction(ActionEvent event) {

    }
}
