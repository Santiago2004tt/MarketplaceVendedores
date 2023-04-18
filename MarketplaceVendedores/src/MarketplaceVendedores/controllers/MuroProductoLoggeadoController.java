package MarketplaceVendedores.controllers;

import MarketplaceVendedores.model.Comentario;
import MarketplaceVendedores.model.Producto;
import MarketplaceVendedores.model.Vendedor;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.image.ImageView;

import java.io.Serializable;

public class MuroProductoLoggeadoController implements Serializable {
    private static final long serialVersioUID = 1L;
    private Producto producto;
    private Vendedor vendedorLogeado;

    private Comentario comentarioSeleccionado;
    ObservableList<Comentario> listaComentariosDate = FXCollections.observableArrayList();
    @FXML
    private Label labelEstadoProducto;

    @FXML
    private Button btnRegresar;

    @FXML
    private Label labelNombreProducto;

    @FXML
    private TableView<Comentario> tableComentario;

    @FXML
    private Label labelCategoriaProducto;

    @FXML
    private Label labelPrecioProducto;

    @FXML
    private ImageView imgViewProductoLoggeado;

    @FXML
    private TableColumn<Comentario, String> columnMensaje;

    @FXML
    private Label labelCantidadMeGustaProducto;

    @FXML
    private Label labelFechaProducto;
    @FXML
    void regresarAction(ActionEvent event) {
        regresarEvent();
    }
    private void regresarEvent() {
        ModelFactoryController.getInstance().accederCuenta(vendedorLogeado);
    }

    public void aniadirProducto(Producto producto, Vendedor vendedorLogeado){
        this.producto = producto;
        this.vendedorLogeado = vendedorLogeado;
        imgViewProductoLoggeado.setImage(producto.getImage());
        labelNombreProducto.setText("Nombre: "+producto.getNombre());
        labelCategoriaProducto.setText("Categoria: "+producto.getCategoria());
        labelPrecioProducto.setText("Precio: "+(String.valueOf(producto.getPrecio())));
        labelEstadoProducto.setText("Estado: "+(String.valueOf(producto.getEstado())));
        labelFechaProducto.setText("Fecha: "+producto.getDate());
        labelCantidadMeGustaProducto.setText(contarMeGusta());

        tableComentario.getItems().clear();
        tableComentario.setItems(obtenerListaComentarios());
    }

    private String contarMeGusta() {
        String meGustas="Me gusta: ";
        meGustas+= producto.getMuro().getListaMeGusta().size();
        return meGustas;
    }


    private ObservableList<Comentario> obtenerListaComentarios() {
        listaComentariosDate.addAll(producto.getMuro().getListaComentarios());
        return listaComentariosDate;
    }

    @FXML
    void initialize(){
        this.columnMensaje.setCellValueFactory(new PropertyValueFactory<>("mensaje"));
        tableComentario.getSelectionModel().selectedItemProperty().addListener((obs,oldSelection, newSelection) -> {
            comentarioSeleccionado = newSelection;
        });
    }

}