package MarketplaceVendedores.application;

import MarketplaceVendedores.controllers.*;
import MarketplaceVendedores.model.Producto;
import MarketplaceVendedores.model.Vendedor;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.BorderPane;
import javafx.stage.Stage;

import java.io.IOException;

public class Main extends Application {

    private Stage stage;
    @Override
    public void start(Stage stage) throws Exception {
        this.stage = stage;
        Image IconMarket = new Image("IconMarket.jpg");
        stage.getIcons().add(IconMarket);
        MostrarLoginVendedor();

    }

    public void MostrarLoginVendedor (){
        try {
            FXMLLoader loader = new FXMLLoader();
            loader.setLocation(Main.class.getResource("../views/LoginVendedor.fxml"));
            BorderPane borderPane = loader.load();
            LoginVendedorController controller = loader.getController();
            controller.setMain(this);
            Scene scene = new Scene(borderPane);
            stage.setScene(scene);
            stage.setTitle("Marketplace Vendedores");
            stage.show();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    public void mostrarMainVendedor(Vendedor vendedor){
        try {
            FXMLLoader loader = new FXMLLoader();
            loader.setLocation(Main.class.getResource("../views/muroVendedorPrincipal.fxml"));
            BorderPane borderPane = loader.load();
            MuroVendedorPrincipalController controller = loader.getController();
            controller.aniadirVendedor(vendedor);
            Scene scene = new Scene(borderPane);
            stage.setScene(scene);
            stage.setTitle("Marketplace Vendedores");
            stage.show();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    public void mostrarCrearCuenta() {
        try {
            FXMLLoader loader = new FXMLLoader();
            loader.setLocation(Main.class.getResource("../views/CrearCuenta.fxml"));
            AnchorPane rootLayout = loader.load();
            CrearCuentaController controller = loader.getController();
            Scene scene = new Scene(rootLayout);
            stage.setScene(scene);
            stage.setTitle("Marketplace Vendedores");
            stage.show();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    public void mostrarVendedoresAliados(Vendedor vendedorLoggeado) {
        try {
            FXMLLoader loader = new FXMLLoader();
            loader.setLocation(Main.class.getResource("../views/vendedoresAliadosRecomendados.fxml"));
            AnchorPane rootLayout = loader.load();
            RecomendadosController controller = loader.getController();
            Scene scene = new Scene(rootLayout);
            stage.setScene(scene);
            stage.setTitle("Marketplace Vendedores");
            stage.show();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    public void mostrarMuroProducto(Producto productosVendedor, Vendedor vendedorLoggeado) {
        try {
            FXMLLoader loader = new FXMLLoader();
            loader.setLocation(Main.class.getResource("../views/MuroProductoAliado.fxml"));
            AnchorPane rootLayout = loader.load();
            MuroProductoAliadoController controller = loader.getController();
            controller.aniadirProducto(productosVendedor, vendedorLoggeado, vendedorLoggeado);
            Scene scene = new Scene(rootLayout);
            stage.setScene(scene);
            stage.setTitle("Marketplace Vendedores");
            stage.show();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}