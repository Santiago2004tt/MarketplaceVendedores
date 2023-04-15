package MarketplaceVendedores.application;

import MarketplaceVendedores.controllers.LoginVendedorController;
import MarketplaceVendedores.controllers.MainViewVendedorController;
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

    public void mostrarMainVendedor(){
        try {
            FXMLLoader loader = new FXMLLoader();
            loader.setLocation(Main.class.getResource("../views/MainViewVendedor.fxml"));
            BorderPane borderPane = loader.load();
            MainViewVendedorController controller = loader.getController();
            controller.setMain(this);
            Scene scene = new Scene(borderPane);
            stage.setScene(scene);
            stage.setTitle("Marketplace Vendedores");
            stage.show();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}