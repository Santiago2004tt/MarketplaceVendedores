package MarketplaceVendedores.controllers;

import MarketplaceVendedores.application.Main;
import MarketplaceVendedores.model.Producto;
import MarketplaceVendedores.model.Vendedor;
import MarketplaceVendedores.test.Miguel;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;

public class MuroVendedorPrincipalController {

    private Main main;

    Vendedor vendedorLoggeado=null;
    Producto productosVendedor =null;

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
    void VendedoresAliadosAction(ActionEvent event) {
        //Miguel.getInstance().mostrarMuroVendedorAliado
    }
    @FXML
    void MuroProductosAction(ActionEvent event) {
        //Miguel.getInstance().mostrarMuroProducto
    }

    @FXML
    void initialize(){
        this.columnNombre.setCellValueFactory(new PropertyValueFactory<>("Nombre"));
        this.columnCodigo.setCellValueFactory(new PropertyValueFactory<>("Codigo"));
        tblProductos.getSelectionModel().selectedItemProperty().addListener((obs,oldSelection, newSelection) -> {
            productosVendedor = newSelection;
        });
    }
    public void aniadirVendedor (Vendedor vendedorLoggeado){
        this.vendedorLoggeado = vendedorLoggeado;
        this.labelNombreVendedor.setText("Nombre: " + vendedorLoggeado.getNombre());
        this.labelApellidoVendedor.setText( "Apellido: " + vendedorLoggeado.getApellido());
        this.labelBienvenidaVendedor.setText("Bienvenido Vendedor " + vendedorLoggeado.getNombre());
        this.labelCedulaVendedor.setText("Cedula: " + vendedorLoggeado.getCedula());
        this.labelDirecionVendedor.setText("Direccion: " + vendedorLoggeado.getDireccion());
    }



    public void setMain(Main main , Vendedor vendedor) {
        this.main = main;
        this.vendedorLoggeado = vendedor;
    }
}
