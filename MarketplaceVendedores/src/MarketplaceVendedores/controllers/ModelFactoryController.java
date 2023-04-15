package MarketplaceVendedores.controllers;


import MarketplaceVendedores.model.MarketplaceVendedores;

import java.io.IOException;

import static MarketplaceVendedores.Persistencia.Persistencia.*;

public class ModelFactoryController {

    MarketplaceVendedores marketplaceVendedores;

    private static class SingletonHolder {
        private final static ModelFactoryController eINSTANCE = new ModelFactoryController();
    }

    public static ModelFactoryController getInstance() {
        return SingletonHolder.eINSTANCE;
    }

    public ModelFactoryController() {

        if(marketplaceVendedores==null) {
            inicializarDatos();
        }
    }

    private void inicializarDatos() {

        marketplaceVendedores = new MarketplaceVendedores("Hola");



        System.out.println("la empresa: "+marketplaceVendedores.getNombre() +" ya se a inicializado");

    }


}