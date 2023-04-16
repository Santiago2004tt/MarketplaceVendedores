package MarketplaceVendedores.test;
import MarketplaceVendedores.application.Main;
import MarketplaceVendedores.controllers.LoginVendedorController;
import MarketplaceVendedores.controllers.MuroVendedorPrincipalController;
import MarketplaceVendedores.model.MarketplaceVendedores;
import MarketplaceVendedores.model.Vendedor;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.layout.BorderPane;
import javafx.stage.Stage;

import java.io.IOException;

public class Miguel {

    MarketplaceVendedores marketplaceVendedores;

    private static class SingletonHolder {
        private final static Miguel eINSTANCE = new Miguel();
    }

    public static Miguel getInstance() {
        return Miguel.SingletonHolder.eINSTANCE;
    }

    public Miguel() {

        if(marketplaceVendedores==null) {
            System.out.println("Marketplace null");
            inicializarDatos();
        }
    }

    private Stage stage;

    private void inicializarDatos(){

        marketplaceVendedores = new MarketplaceVendedores("Market");
    }

    public void started(Stage stage) throws Exception{
        this.stage=stage;
        MostrarLoginVendedor();
    }


    public void mostrarMainVendedor(Vendedor vendedor){
        try {
            FXMLLoader loader = new FXMLLoader();
            loader.setLocation(Main.class.getResource("../views/muroVendedorPrincipal.fxml"));
            BorderPane borderPane = loader.load();
            MuroVendedorPrincipalController controller = loader.getController();
            //controller.setMain(this, vendedor);
            controller.aniadirVendedor(vendedor);
            Scene scene = new Scene(borderPane);
            stage.setScene(scene);
            stage.setTitle("Marketplace Vendedores");
            stage.show();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
    public void MostrarLoginVendedor (){
        try {
            FXMLLoader loader = new FXMLLoader();
            loader.setLocation(Main.class.getResource("../views/LoginVendedor.fxml"));
            BorderPane borderPane = loader.load();
            LoginVendedorController controller = loader.getController();
            //controller.setMain(this);
            Scene scene = new Scene(borderPane);
            stage.setScene(scene);
            stage.setTitle("Marketplace Vendedores");
            stage.show();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    //El metodo requiere que exite cuenta sea publico
    // public boolean verificarVendedor(String usuario, String contrasena){
    //  return marketplaceVendedores.existeCuenta(usuario,contrasena);
    //}
    private boolean verificarCampos(String usuario, String contrasena) {
        if(usuario.equals("")||contrasena.equals("")){
            return false;
        }
        return true;
    }
}
