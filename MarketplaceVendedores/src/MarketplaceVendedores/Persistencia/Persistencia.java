package MarketplaceVendedores.Persistencia;

import MarketplaceVendedores.model.Cuenta;
import MarketplaceVendedores.model.Vendedor;

import java.io.IOException;
import java.util.ArrayList;

public class Persistencia {
    public static final String RUTA_ARCHIVO_EMPLEADOS = "src/resources/archivoEmpleados.txt";

    public static void guardarVendedores(ArrayList<Vendedor> listaVendedores) throws IOException {

        String contenido = "";

        for (Vendedor vendedor : listaVendedores) {
            contenido += vendedor.getNombre() +"\n";
        }
        ArchivoUtil.guardarArchivo(RUTA_ARCHIVO_EMPLEADOS, contenido, false);
    }

//    ----------------------LOADS------------------------

    private static ArrayList<Vendedor> cargarVendedores() throws IOException {

        ArrayList<Vendedor> vendedores = new ArrayList<Vendedor>();

        ArrayList<String> contenido = ArchivoUtil.leerArchivo(RUTA_ARCHIVO_EMPLEADOS);
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
        ArchivoUtil.guardarArchivo(RUTA_ARCHIVO_EMPLEADOS, contenido, false);
    }
}
