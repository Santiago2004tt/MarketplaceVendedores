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
    private Image IconMarket = new Image("IconMarket.jpg");
    @Override
    public void start(Stage stage) throws Exception {
        this.stage = stage;
        stage.getIcons().add(IconMarket);
        MostrarLoginVendedor();

    }

    public void MostrarLoginVendedor (){
        try {
            stage.close();
            stage = new Stage();
            stage.getIcons().add(IconMarket);
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
            stage.close();
            stage = new Stage();
            stage.getIcons().add(IconMarket);
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
            stage.close();
            stage = new Stage();
            stage.getIcons().add(IconMarket);
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

    public void mostrarVendedoresAliados(Vendedor vendedorLogeado) {
        try {
            stage.close();
            stage = new Stage();
            stage.getIcons().add(IconMarket);
            FXMLLoader loader = new FXMLLoader();
            loader.setLocation(Main.class.getResource("../views/vendedoresAliadosRecomendados.fxml"));
            AnchorPane rootLayout = loader.load();
            RecomendadosController controller = loader.getController();
            controller.inicializarVendedor(vendedorLogeado);
            Scene scene = new Scene(rootLayout);
            stage.setScene(scene);
            stage.setTitle("Marketplace Vendedores");
            stage.show();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    public void mostrarMuroProductoLogeado(Producto productosVendedor, Vendedor vendedorLoggeado) {
        try {
            stage.close();
            stage = new Stage();
            stage.getIcons().add(IconMarket);
            FXMLLoader loader = new FXMLLoader();
            loader.setLocation(Main.class.getResource("../views/MuroProductoLoggeado.fxml"));
            BorderPane borderPane = loader.load();
            MuroProductoLoggeadoController controller = loader.getController();
            controller.aniadirProducto(productosVendedor, vendedorLoggeado);
            Scene scene = new Scene(borderPane);
            stage.setScene(scene);
            stage.setTitle("Marketplace Vendedores");
            stage.show();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    public void mostrarCrearProducto(Vendedor vendedorLogeado) {
        try {
            stage.close();
            stage = new Stage();
            stage.getIcons().add(IconMarket);
            FXMLLoader loader = new FXMLLoader();
            loader.setLocation(Main.class.getResource("../views/CrearProducto.fxml"));
            AnchorPane rootLayout = loader.load();
            CrearProductoController controller = loader.getController();
            controller.inicializarVendedor(vendedorLogeado);
            Scene scene = new Scene(rootLayout);
            stage.setScene(scene);
            stage.setTitle("Marketplace Vendedores");
            stage.show();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}