package MarketplaceVendedores.controllers;

import MarketplaceVendedores.application.Main;
import MarketplaceVendedores.model.Comentario;
import MarketplaceVendedores.model.Producto;
import MarketplaceVendedores.model.Vendedor;
import MarketplaceVendedores.test.Miguel;
import com.sun.webkit.Timer;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;

public class MuroVendedorPrincipalController {

    private Main main;

    Vendedor vendedorLoggeado;
    Producto productosVendedor;

    ObservableList<Producto> listaProductosData = FXCollections.observableArrayList();

    @FXML
    private TableView<Producto> tblProductos;

    @FXML
    private TableColumn<Producto, String> columnCodigo;

    @FXML
    private TableColumn<Producto, String> columnNombre;

    @FXML
    private Button btnVendedoresAliados;

    @FXML
    private Button btnMuroProductos;
    @FXML
    private Button btnSalir;

    @FXML
    private Label labelDirecionVendedor;

    @FXML
    private Label labelBienvenidaVendedor;

    @FXML
    private Label labelNombreVendedor;

    @FXML
    private Label labelApellidoVendedor;

    @FXML
    private Label labelCedulaVendedor;

    @FXML
    void salirVendedorAction(ActionEvent event) {
        salirVendedor();
    }

    private void salirVendedor() {
        ModelFactoryController.getInstance().volverInicioSesion();
    }

    @FXML
    void VendedoresAliadosAction(ActionEvent event) {
        visitarVendedorAction();
    }

    private void visitarVendedorAction() {
        ModelFactoryController.getInstance().visitarVendedoresAction(vendedorLoggeado);
    }

    @FXML
    void MuroProductosAction(ActionEvent event) {
        visitarMuroProducto();
    }

    private void visitarMuroProducto() {
        if(productosVendedor != null){
            ModelFactoryController.getInstance().visitarMuroProducto(productosVendedor, vendedorLoggeado);
        }else{
            mostrarMensaje("Notificacion vendedor", "Vendedor no eliminado", "El vendedor No ha sido eliminado", Alert.AlertType.ERROR);
        }
    }

    @FXML
    void initialize(){
        this.columnNombre.setCellValueFactory(new PropertyValueFactory<>("nombre"));
        this.columnCodigo.setCellValueFactory(new PropertyValueFactory<>("codigo"));
        tblProductos.getSelectionModel().selectedItemProperty().addListener((obs,oldSelection, newSelection) -> {
            productosVendedor = newSelection;
        });
    }

    private ObservableList<Producto> obtenerListaProductos() {
        listaProductosData.addAll(vendedorLoggeado.getListaProductos());
        return listaProductosData;
    }
    public void aniadirVendedor (Vendedor vendedorLoggeado){
        this.vendedorLoggeado = vendedorLoggeado;
        this.labelNombreVendedor.setText("Nombre: " + vendedorLoggeado.getNombre());
        this.labelApellidoVendedor.setText( "Apellido: " + vendedorLoggeado.getApellido());
        this.labelBienvenidaVendedor.setText("Bienvenido Vendedor " + vendedorLoggeado.getNombre());
        this.labelCedulaVendedor.setText("Cedula: " + vendedorLoggeado.getCedula());
        this.labelDirecionVendedor.setText("Direccion: " + vendedorLoggeado.getDireccion());
        tblProductos.getItems().clear();
        tblProductos.setItems(obtenerListaProductos());
    }

    public void mostrarMensaje(String titulo, String header, String contenido, Alert.AlertType alertType) {

        Alert alert = new Alert(alertType);
        alert.setTitle(titulo);
        alert.setHeaderText(header);
        alert.setContentText(contenido);
        DialogPane dialogPane = alert.getDialogPane();
        alert.showAndWait();
    }
}
