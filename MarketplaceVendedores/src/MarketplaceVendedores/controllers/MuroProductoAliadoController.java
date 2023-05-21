package MarketplaceVendedores.controllers;

import MarketplaceVendedores.model.Comentario;
import MarketplaceVendedores.model.Producto;
import MarketplaceVendedores.model.Vendedor;
import MarketplaceVendedores.test.Test;
import javafx.beans.Observable;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.*;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;

import java.awt.*;
import java.io.Serializable;
import java.util.Locale;


public class MuroProductoAliadoController implements Serializable {
    private static final long serialVersioUID = 1L;
    private Vendedor vendedorLogeado;
    private Vendedor vendedorAliado;
    private Producto producto;

    private Comentario comentarioSeleccionado;
    ObservableList<Comentario> listaComentariosDate = FXCollections.observableArrayList();
    @FXML
    private ImageView imgProducto;

    @FXML
    private Label txtCategoria;

    @FXML
    private Label txtDate;

    @FXML
    private TableView<Comentario> tableComentario;

    @FXML
    private Button btnMeGusta;

    @FXML
    private Label txtPrecio;

    @FXML
    private TableColumn<Comentario, String > columnComentario;

    @FXML
    private Label txtNombre;

    @FXML
    private Button btnRegresar;

    @FXML
    private Button btnPublicarComentario;

    @FXML
    private TextField txtComentario;

    @FXML
    private Label txtMeGusta;

    @FXML
    private Label txtEstado;

    @FXML
    void regresar(ActionEvent event) {
        regresarAction();
    }

    @FXML
    void publicarComentario(ActionEvent event) {
        publicarComentarioAction();
    }

    private void publicarComentarioAction() {
        String comentario = txtComentario.getText();
        if(!comentario.equals("")){
            comentario = vendedorLogeado.getNombre()+" "+vendedorLogeado.getApellido()+": "+comentario;
            ModelFactoryController.getInstance().publicarComentario(producto, comentario);
            mostrarMensaje("Notificacion vendedor", "Comentario se a enviado", "El comentario se a enviado correctamente", Alert.AlertType.INFORMATION);
            tableComentario.getItems().clear();
            tableComentario.setItems(obtenerListaComentarios());
            tableComentario.refresh();
            txtComentario.setText("");
        }else {
            mostrarMensaje("Notificacion vendedor", "Vendedor no se a selecciondao", "El vendedor no ha sido seleccionado", Alert.AlertType.ERROR);
        }
    }

    private void regresarAction() {
        ModelFactoryController.getInstance().visitarVendedorAliado(vendedorLogeado, vendedorAliado);
    }

    @FXML
    void darMeGusta(ActionEvent event) {
        darMeGustaAction();
    }

    private void darMeGustaAction() {
        if(ModelFactoryController.getInstance().verificarExisteMeGusta(vendedorLogeado, producto)){
            ModelFactoryController.getInstance().agregarMeGusta(vendedorLogeado, producto);
            int cantidadMeGusta = producto.getMuro().getListaMeGusta().size();
            txtMeGusta.setText("" + cantidadMeGusta);
        }else{
            ModelFactoryController.getInstance().quitarMeGusta(vendedorLogeado, producto);
            int cantidadMeGusta = producto.getMuro().getListaMeGusta().size();
            txtMeGusta.setText("" + cantidadMeGusta);
        }
    }

    public void aniadirProducto(Producto producto, Vendedor vendedorLogeado, Vendedor vendedorAliado){
        this.producto = producto;
        Image image = new Image(producto.getImage());
        this.vendedorLogeado = vendedorLogeado;
        this.vendedorAliado = vendedorAliado;
        imgProducto.setImage(image);
        txtNombre.setText(producto.getNombre());
        txtCategoria.setText(producto.getCategoria());
        txtPrecio.setText(String.valueOf(producto.getPrecio()));
        txtEstado.setText(String.valueOf(producto.getEstado()));
        txtDate.setText(producto.getDate());

        tableComentario.getItems().clear();
        tableComentario.setItems(obtenerListaComentarios());
    }

    private ObservableList<Comentario> obtenerListaComentarios() {
        listaComentariosDate.addAll(producto.getMuro().getListaComentarios());
        return listaComentariosDate;
    }

    @FXML
    void initialize(){
        this.columnComentario.setCellValueFactory(new PropertyValueFactory<>("mensaje"));

        tableComentario.getSelectionModel().selectedItemProperty().addListener((obs,oldSelection, newSelection) -> {
            comentarioSeleccionado = newSelection;
        });
    }


    public void inicializarVendedor(Vendedor vendedorLogeado, Vendedor vendedorVisitane, Producto producto) {
        this.vendedorLogeado=vendedorLogeado;
        this.vendedorAliado = vendedorVisitane;
        this.producto = producto;
        inicializarProductos();
        tableComentario.setItems(obtenerListaComentarios());
    }

    private void inicializarProductos() {
        Image image = new Image(producto.getImage());
        imgProducto.setImage(image);
        txtNombre.setText("Nombre: "+ producto.getNombre());
        txtDate.setText("Fecha: "+ producto.getDate());
        txtMeGusta.setText(""+producto.getMuro().getListaMeGusta().size());
        txtEstado.setText("Nombre: "+ producto.getEstado());
        txtCategoria.setText("Categoria: "+ producto.getCategoria());
        txtPrecio.setText("Precio: "+ producto.getPrecio());
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
