package MarketplaceVendedores.controllers;

import MarketplaceVendedores.model.Administrador;
import MarketplaceVendedores.model.MarketplaceVendedores;
import MarketplaceVendedores.model.Vendedor;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.chart.BarChart;
import javafx.scene.chart.CategoryAxis;
import javafx.scene.chart.NumberAxis;
import javafx.scene.chart.XYChart;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;

import java.io.Serializable;
import java.util.ArrayList;

public class EstadisticaController implements Serializable {

    private static final long serialVersioUID = 1L;
    ObservableList<Vendedor> listaVendedoresData= FXCollections.observableArrayList();

    Administrador administradorLogueado = null;
    Vendedor vendedorSeleccionado = null;
    MarketplaceVendedores marketplaceVendedores;


    @FXML
    private CategoryAxis X;

    @FXML
    private NumberAxis Y;

    @FXML
    private BarChart<?, ?> estadisticasChart;

    @FXML
    private TableView<Vendedor> tablaVendedores;

    @FXML
    private TableColumn<Vendedor, String> columApellidoVendedor;

    @FXML
    private TableColumn<Vendedor, String> columCedulaVendedor;

    @FXML
    private TableColumn<Vendedor, String> columDireccionVendedor;

    @FXML
    private TableColumn<Vendedor, String> columNombreVendedor;

    @FXML
    void consultarAction(ActionEvent event) {
        consultaVendedoresActioon();
    }

    private void consultaVendedoresActioon() {
        vendedorSeleccionado.contarComentarios();
        vendedorSeleccionado.contarLikes();

    }

    @FXML
    void volverAction(ActionEvent event) {
        ModelFactoryController.getInstance().volverLoginAdmin();

    }

    private ObservableList<Vendedor> obtenerVendedoresEstadisticas() {
        tablaVendedores.getItems().clear();
        listaVendedoresData.addAll(ModelFactoryController.getInstance().obtenerDatosVendedores());
        return listaVendedoresData;
    }


    @FXML
    void initialize() {
        //------------------------------------------------------//
        this.columNombreVendedor.setCellValueFactory(new PropertyValueFactory<>("nombre"));
        this.columApellidoVendedor.setCellValueFactory(new PropertyValueFactory<>("apellido"));
        this.columCedulaVendedor.setCellValueFactory(new PropertyValueFactory<>("cedula"));
        this.columDireccionVendedor.setCellValueFactory(new PropertyValueFactory<>("direccion"));
        tablaVendedores.getSelectionModel().selectedItemProperty().addListener((obs,oldSelection, newSelection) -> {
            vendedorSeleccionado = newSelection;
        });
        //--------------------------------------------------------------------------------------------------------//

        XYChart.Series set1 = new XYChart.Series<>();

        set1.getData().add(new XYChart.Data("Publicaciones", vendedorSeleccionado.contarComentarios()));
        set1.getData().add(new XYChart.Data("Likes", vendedorSeleccionado.contarLikes()));
        set1.getData().add(new XYChart.Data("Comentarios",9 ));

        estadisticasChart.getData().addAll(set1);


    }

    public void aniadirAdministrador(Administrador administrador) {
        this.administradorLogueado = administrador;
        tablaVendedores.setItems(obtenerVendedoresEstadisticas());
    }
}
