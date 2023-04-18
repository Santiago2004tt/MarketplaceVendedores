package MarketplaceVendedores.controllers;

import java.io.File;
import java.io.Serializable;
import java.net.URL;
import java.util.ResourceBundle;

import MarketplaceVendedores.model.Estado;
import MarketplaceVendedores.model.Vendedor;
import javafx.collections.FXCollections;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.*;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.stage.FileChooser;

public class CrearProductoController implements Serializable {
    private static final long serialVersioUID = 1L;
    private Vendedor vendedorLogeado;
    private Image imageAux;


    @FXML
    private Button crearPublicacionButton;

    @FXML
    private ImageView imageProducto;

    @FXML
    private Button seleccionarButton;

    @FXML
    private TextField txtCategoriaProducto;

    @FXML
    private TextField txtCodigoProducto;

    @FXML
    private ComboBox<Estado> comboBox;

    @FXML
    private DatePicker txtFechaProducto;

    @FXML
    private TextField txtNombreProducto;

    @FXML
    private TextField txtPrecioProducto;

    @FXML
    private Button volverButton;

    @FXML
    void crearPublicacionAction(ActionEvent event) {
        crearPublicacionEvent();
    }

    private void crearPublicacionEvent() {
        String nombre = txtNombreProducto.getText();
        String codigo = txtCodigoProducto.getText();
        String categoria = txtNombreProducto.getText();
        String precio = (txtPrecioProducto.getText());
        Estado estado = comboBox.getValue();
        String fecha = String.valueOf(txtFechaProducto.getValue());

        if(verificarCampos(nombre, codigo, categoria, precio, estado, fecha)){
            if(isNumeric(precio)){
                double precioDefinitivo = Double.parseDouble(precio);
                if(ModelFactoryController.getInstance().crearProducto(nombre, codigo, categoria, precioDefinitivo, estado, fecha, imageAux, vendedorLogeado)){
                    mostrarMensaje("Notificacion vendedor", "Se creo el producto", "el producto se a creado", Alert.AlertType.INFORMATION);
                }
            }else {
                mostrarMensaje("Notificacion vendedor", "datos invalidos", "coloca valores numericos", Alert.AlertType.ERROR);
            }
        }else {
            mostrarMensaje("Notificacion vendedor", "rellenar los datos", "datos incompletos, por favor rellenar", Alert.AlertType.ERROR);
        }
    }

    private boolean verificarCampos(String nombre, String codigo, String categoria, String precio, Estado estado, String fecha) {

        if(nombre.equals("")){
            return false;
        }
        if(codigo.equals("")){
            return false;
        }
        if(categoria.equals("")){
            return false;

        }
        if(precio.equals("")){
            return false;

        }
        if(estado==null){
            return false;
        }
        if(fecha.equals("")){
            return false;

        }
        return true;

    }

    @FXML
    void seleccionarImagenAction(ActionEvent event) {
        seleccionarImagen();
    }

    private void seleccionarImagen() {
        FileChooser fileChooser = new FileChooser();
        fileChooser.setTitle("Buscar Imagen");

        // Agregar filtros para facilitar la búsqueda
        fileChooser.getExtensionFilters().addAll(
                new FileChooser.ExtensionFilter("All Images", "*.*"),
                new FileChooser.ExtensionFilter("JPG", "*.jpg"),
                new FileChooser.ExtensionFilter("PNG", "*.png")
        );

        //Obtener la imagen seleccionada
        File imgFile = fileChooser.showOpenDialog(crearPublicacionButton.getScene().getWindow());

        // Mostar la imagen
        if (imgFile != null) {
            Image image = new Image("file:" + imgFile.getAbsolutePath());
           imageProducto.setImage(image);  //Se llama al objeto de tipo ImagenView y se muestra
            this.imageAux=image;
        }
    }

    @FXML
    void volverAction(ActionEvent event) {
        volverEvent();
    }

    private void volverEvent() {
        ModelFactoryController.getInstance().accederCuenta(vendedorLogeado);
    }

    @FXML
    void initialize() {
        comboBox.setItems(FXCollections.observableArrayList(Estado.values()));
    }

    public void inicializarVendedor(Vendedor vendedorLogeado) {
        this.vendedorLogeado = vendedorLogeado;
    }

    public static boolean isNumeric(String cadena) {

        boolean resultado;

        try {
            Double.parseDouble(cadena);
            resultado = true;
        } catch (NumberFormatException excepcion) {
            resultado = false;
        }
        return resultado;
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
