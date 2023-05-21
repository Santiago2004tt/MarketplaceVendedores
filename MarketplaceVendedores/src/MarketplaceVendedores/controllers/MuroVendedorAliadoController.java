package MarketplaceVendedores.controllers;

import MarketplaceVendedores.model.MarketplaceVendedores;
import MarketplaceVendedores.model.Producto;
import MarketplaceVendedores.model.Vendedor;
import com.sun.webkit.Timer;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;

import java.io.PipedReader;
import java.io.Serializable;
import java.util.ArrayList;

public class MuroVendedorAliadoController implements Serializable {
    private static final long serialVersioUID = 1L;

    Vendedor vendedorLogeado;
    Vendedor vendedorVisitante;
    Producto productoSeleccionado = null;
    ObservableList<Producto> listaProductosObservable = FXCollections.observableArrayList();
    @FXML
    private Button btnSalir;

    @FXML
    private Label txtNombre;

    @FXML
    private Label txtDireccion;

    @FXML
    private Label txtApellido;

    @FXML
    private TableView<Producto> tableListaProductos;

    @FXML
    private TableColumn<Producto, String> columnNombre;

    @FXML
    private TableColumn<Producto, Double> columnPrecio;

    @FXML
    private TableColumn<Producto, String > columnCategoria;

    @FXML
    private Button btnProducto;

    @FXML
    void salirMuroVendedor(ActionEvent event) {
        salirMuro();
    }

    private void salirMuro() {
        ModelFactoryController.getInstance().accederCuenta(vendedorLogeado);
    }

    @FXML
    void accederVerProducto(ActionEvent event) {
        accederVerProductoAliado();
    }

    private void accederVerProductoAliado() {
        if(productoSeleccionado != null){
            ModelFactoryController.getInstance().accederProductoAliado(vendedorLogeado, vendedorVisitante, productoSeleccionado);
        }
    }

    public void inicializarVendedor(Vendedor vendedorLogeado, Vendedor vendedorVisitante) {
        this.vendedorLogeado = vendedorLogeado;
        this.vendedorVisitante = vendedorVisitante;
        tableListaProductos.setItems(obtenerProductos());
        aniadirDatos();
    }

    private ObservableList<Producto> obtenerProductos() {
        tableListaProductos.getItems().clear();
        listaProductosObservable.addAll(vendedorVisitante.getListaProductos());
        return listaProductosObservable;
    }

    private void aniadirDatos() {
        txtNombre.setText("Nombre: "+vendedorVisitante.getNombre());
        txtApellido.setText("Apellido: "+vendedorVisitante.getApellido());
        txtDireccion.setText("Direccion: "+vendedorVisitante.getDireccion());
    }

    @FXML
    void initialize(){
        this.columnNombre.setCellValueFactory(new PropertyValueFactory<>("nombre"));
        this.columnCategoria.setCellValueFactory(new PropertyValueFactory<>("categoria"));
        this.columnPrecio.setCellValueFactory(new PropertyValueFactory<>("precio"));
        tableListaProductos.getSelectionModel().selectedItemProperty().addListener((obs,oldSelection, newSelection) -> {
            productoSeleccionado = newSelection;
        });
    }

}
