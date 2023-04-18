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

    public static final String RUTA_ARCHIVO_LOG = "C:\\td\\persistencia\\log/MarketPlaceLog.txt";

    public static void cargarDatosArchivos(MarketplaceVendedores marketplaceVendedores) throws FileNotFoundException, IOException {

        ArrayList<Vendedor> vendedoresCargados = cargarVendedores();

        if (vendedoresCargados.size() > 0)
            marketplaceVendedores.getListaVendedores().addAll(vendedoresCargados);
    }

        public static void guardarVendedores(ArrayList<Vendedor> listaVendedores) throws IOException {

        String contenido = "";

        for (Vendedor vendedor : listaVendedores) {
            //String datosProducto = obtenerProductos(vendedor);
            contenido += vendedor.toString() +"\n";
        }
        ArchivoUtil.guardarArchivo(RUTA_ARCHIVO_VENDEDOR, contenido, false);
    }

    private static String obtenerProductos(Vendedor vendedor) {
        String datosProducto = "";

        for (int i = 0; i < vendedor.getListaProductos().size(); i++) {
            datosProducto += vendedor.getListaProductos().get(i).toString();
        }
        return datosProducto;
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
    public static MarketplaceVendedores cargarRecursoBinario() {

        MarketplaceVendedores marketplaceVendedores = null;

        try {
            marketplaceVendedores = (MarketplaceVendedores) ArchivoUtil.cargarRecursoSerializado(RUTA_ARCHIVO_MODELO_MARKETPLACEVENDEDORES_BINARIO);
        } catch (Exception e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        return marketplaceVendedores;
    }

    public static void guardarRecursoBinario(MarketplaceVendedores marketplaceVendedores) {

        try {
            ArchivoUtil.salvarRecursoSerializado(RUTA_ARCHIVO_MODELO_MARKETPLACEVENDEDORES_BINARIO, marketplaceVendedores);
        } catch (Exception e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
    }


    public static MarketplaceVendedores cargarRecursoXML() {

        MarketplaceVendedores marketplaceVendedores = null;

        try {
            marketplaceVendedores = (MarketplaceVendedores) ArchivoUtil.cargarRecursoSerializadoXML(RUTA_ARCHIVO_MODELO_MARKETPLACEVENDEDORES_XML);
        } catch (Exception e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        return marketplaceVendedores;

    }

    public static void guardarRecursoXML(MarketplaceVendedores marketplaceVendedores) {

        try {
            ArchivoUtil.salvarRecursoSerializadoXML(RUTA_ARCHIVO_MODELO_MARKETPLACEVENDEDORES_XML, marketplaceVendedores);
        } catch (Exception e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
    }
    public static void guardaRegistroLog(String mensajeLog, int nivel, String accion)
    {

        ArchivoUtil.guardarRegistroLog(mensajeLog, nivel, accion, RUTA_ARCHIVO_LOG);
    }

}
