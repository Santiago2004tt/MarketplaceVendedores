package MarketplaceVendedores.Persistencia;

import MarketplaceVendedores.model.Cuenta;
import MarketplaceVendedores.model.MarketplaceVendedores;
import MarketplaceVendedores.model.Vendedor;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;

public class Persistencia {
    public static final String RUTA_ARCHIVO_VENDEDOR = "C:\\td\\persistencia\\Archivos/archivoVendedores.txt";
    public static final String RUTA_ARCHIVO_MODELO_MARKETPLACEVENDEDORES_BINARIO = "C:\\td\\persistencia/Model.dat";
    public static final String RUTA_ARCHIVO_MODELO_MARKETPLACEVENDEDORES_XML = "C:\\td\\persistencia/Encript.xml";


    public static void cargarDatosArchivos(MarketplaceVendedores marketplaceVendedores) throws FileNotFoundException, IOException {

        ArrayList<Vendedor> vendedoresCargados = cargarVendedores();

        if (vendedoresCargados.size() > 0)
            marketplaceVendedores.getListaVendedores().addAll(vendedoresCargados);
    }

        public static void guardarVendedores(ArrayList<Vendedor> listaVendedores) throws IOException {

        String contenido = "";

        for (Vendedor vendedor : listaVendedores) {
            contenido += vendedor.getNombre() +"\n" + vendedor.getApellido() + "\n" + vendedor.getCedula() + "\n" + vendedor.getDireccion();
        }
        ArchivoUtil.guardarArchivo(RUTA_ARCHIVO_VENDEDOR, contenido, false);
    }

//    ----------------------LOADS------------------------

    private static ArrayList<Vendedor> cargarVendedores() throws IOException {

        ArrayList<Vendedor> vendedores = new ArrayList<Vendedor>();

        ArrayList<String> contenido = ArchivoUtil.leerArchivo(RUTA_ARCHIVO_VENDEDOR);
        String linea = "";

        for (int i = 0; i < contenido.size(); i++) {
            linea = contenido.get(i);
            Vendedor vendedor = new Vendedor();
            vendedor.setNombre(linea.split(",")[0]);
            vendedores.add(vendedor);
        }
        return vendedores;
    }

//    ---------------------------Cuenta--------------------------

    public static void guardarCuentas(ArrayList<Cuenta> listaCuenta) throws IOException {

        String contenido = "";

        for (Cuenta cuenta : listaCuenta) {
            contenido += cuenta.getUsuario() +"\n";
        }
        ArchivoUtil.guardarArchivo(RUTA_ARCHIVO_VENDEDOR, contenido, false);
    }

    //------------------------SERIALIZACIÓN y XML---------------------------------------------------
    public static MarketplaceVendedores cargarRecursoBancoBinario() {

        MarketplaceVendedores marketplaceVendedores = null;

        try {
            marketplaceVendedores = (MarketplaceVendedores) ArchivoUtil.cargarRecursoSerializado(RUTA_ARCHIVO_MODELO_MARKETPLACEVENDEDORES_BINARIO);
        } catch (Exception e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        return marketplaceVendedores;
    }

    public static void guardarRecursoBancoBinario(MarketplaceVendedores marketplaceVendedores) {

        try {
            ArchivoUtil.salvarRecursoSerializado(RUTA_ARCHIVO_MODELO_MARKETPLACEVENDEDORES_BINARIO, marketplaceVendedores);
        } catch (Exception e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
    }


    public static MarketplaceVendedores cargarRecursoBancoXML() {

        MarketplaceVendedores marketplaceVendedores = null;

        try {
            marketplaceVendedores = (MarketplaceVendedores) ArchivoUtil.cargarRecursoSerializadoXML(RUTA_ARCHIVO_MODELO_MARKETPLACEVENDEDORES_XML);
        } catch (Exception e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        return marketplaceVendedores;

    }

    public static void guardarRecursoBancoXML(MarketplaceVendedores marketplaceVendedores) {

        try {
            ArchivoUtil.salvarRecursoSerializadoXML(RUTA_ARCHIVO_MODELO_MARKETPLACEVENDEDORES_XML, marketplaceVendedores);
        } catch (Exception e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
    }
}
