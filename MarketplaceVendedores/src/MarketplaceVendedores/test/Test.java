package MarketplaceVendedores.test;

import MarketplaceVendedores.controllers.ModelFactoryController;
import MarketplaceVendedores.model.*;
import javafx.scene.control.Alert;
import javafx.scene.control.DialogPane;

import java.io.IOException;

import static MarketplaceVendedores.Persistencia.Persistencia.*;

public class Test {
    MarketplaceVendedores marketplaceVendedores;

    public static boolean agregarMeGusta(Vendedor vendedorLogeado, Vendedor vendedorAliado) {
        return true;
    }


    private static class SingletonHolder {
        private final static ModelFactoryController eINSTANCE = new ModelFactoryController();
    }

    public static ModelFactoryController getInstance() {
        return ModelFactoryController.SingletonHolder.eINSTANCE;
    }

    public Test() {

        if(marketplaceVendedores==null) {
            inicializarDatos();
        }
    }

    private void inicializarDatos() {

        marketplaceVendedores = new MarketplaceVendedores("Hola");



        System.out.println("la empresa: "+marketplaceVendedores.getNombre() +" ya se a inicializado");

    }


    public static boolean verificarExisteMeGusta(Vendedor vendedorLogeado, Vendedor vendedorAliado) {
        //return MarketplaceVendedores.verificarExisteMeGusta(vendedorLogeado, vendedorAliado);
        return false;
    }



}
