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
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
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

    }

    @FXML
    void darMeGusta(ActionEvent event) {
        darMeGustaAction();
    }

    private void darMeGustaAction() {
        if(Test.verificarExisteMeGusta(vendedorLogeado, vendedorAliado)){
            boolean meGustaAgregado = Test.agregarMeGusta(vendedorLogeado, vendedorAliado);
            if(meGustaAgregado){
                //int cantidadMeGusta = Test.contarMeGustas(vendedorAliado);
                //txtMeGusta.setText("" + cantidadMeGusta);
            }
        }else{
            //Test.quitarMeGusta(vendedorLogeado, vendedorAliado);
            //int cantidadMeGusta = Test.contarMeGustas(vendedorAliado);
            //txtMeGusta.setText("" + cantidadMeGusta);
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

    void initialize(){
        this.columnComentario.setCellValueFactory(new PropertyValueFactory<>("mensaje"));

        tableComentario.getSelectionModel().selectedItemProperty().addListener((obs,oldSelection, newSelection) -> {
            comentarioSeleccionado = newSelection;
        });
    }


}
