package MarketplaceVendedores.test;

import MarketplaceVendedores.Persistencia.Persistencia;
import MarketplaceVendedores.application.Main;
import MarketplaceVendedores.controllers.MainViewVendedorController;
import MarketplaceVendedores.exceptions.CuentaException;
import MarketplaceVendedores.exceptions.VendedorException;
import MarketplaceVendedores.model.Cuenta;
import MarketplaceVendedores.model.MarketplaceVendedores;
import MarketplaceVendedores.model.Vendedor;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.BorderPane;
import javafx.stage.Stage;

import java.io.IOException;


public class Huendy {

    MarketplaceVendedores marketplaceVendedores;



    //------------------------------  Singleton ------------------------------------------------
    // Clase estatica oculta. Tan solo se instanciara el singleton una vez
    private static class SingletonHolder {
        // El constructor de Singleton puede ser llamado desde aquí al ser protected
        private final static Huendy eINSTANCE = new Huendy();
    }

    // Método para obtener la instancia de nuestra clase
    public static Huendy getInstance() {
        return SingletonHolder.eINSTANCE;
    }

    public Huendy() {
        //Siempre se debe verificar si la raiz del recurso es null
        if (marketplaceVendedores == null) {
            //System.out.println("es null");
            inicializarDatos();
        }
    }

    private void inicializarDatos() {

        marketplaceVendedores = new MarketplaceVendedores();
        Vendedor vendedor = new Vendedor();
        vendedor.setNombre("yo");

        marketplaceVendedores.getListaVendedores().add(vendedor);

        vendedor = new Vendedor();
        vendedor.setNombre("juan");

        marketplaceVendedores.getListaVendedores().add(vendedor);

        System.out.println("Empresa inicializado " + marketplaceVendedores);

    }

    public MarketplaceVendedores getMarketplaceVendedores() {
        return marketplaceVendedores;
    }

    public void setMarketplaceVendedores(MarketplaceVendedores marketplaceVendedores) {
        this.marketplaceVendedores = marketplaceVendedores;
    }

    public void MostrarMuroVendedorPrincipal() {
    }

//////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
    /**
     * parte de crearCuenta  y recomendados para implementar
     */

    public boolean crearVendedor(String nombre, String apellido, String cedula, String direccion, Cuenta cuenta) {
        try {
            marketplaceVendedores.crearVendedor(nombre, apellido, cedula, direccion, cuenta);
            Persistencia.guardarVendedores(marketplaceVendedores.getListaVendedores());
            return true;
        } catch (VendedorException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return false;
    }

    public boolean crearCuenta(String usuario, String contrasenia) throws CuentaException {
        try {
            marketplaceVendedores.crearCuenta(usuario, contrasenia);
            Persistencia.guardarCuentas(marketplaceVendedores.getListaCuentas());
            return true;
        } catch (CuentaException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return false;
    }

    public Cuenta buscarCuenta(String usuario, String contrasenia) throws CuentaException {
        Cuenta cuenta = null;
        try {
            cuenta = marketplaceVendedores.buscarCuenta(usuario, contrasenia);
        } catch (CuentaException e) {
            e.printStackTrace();
        }
        return cuenta;
    }

////////////////////////////////////////////////////////////////////////////////////////////////////////////


}
