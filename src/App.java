import java.util.ArrayList;

public class App {
    public static void main(String[] args) throws Exception {
        int opcion = -1;
        ArrayList<Articulos> listaArticulos = new ArrayList<>();
        int codigo = 0;
        String name = "";
        int precioCompra = 0;
        int precioVenta = 0;
        int stock = 0;
        int indice = 0;
        Articulos articulosAux = null;

        listaArticulos.add(new Articulos(++codigo, "Cepillo dientes", 12, 15, 5));
        do {
            System.out.println("""

                        1. Listado
                        2. Alta
                        3. Baja
                        4. Modificación
                        5. Entrada de mercancía
                        6. Salida de mercancía
                        7. Salir

                    """);
            opcion = Integer.parseInt(System.console().readLine("Opcion: "));
            switch (opcion) {
                case 1:
                    for (Articulos articulos : listaArticulos) {
                        System.out.println(articulos);
                    }
                    break;
                case 2:
                    name = System.console().readLine("Nombre: ");
                    precioCompra = Integer.parseInt(System.console().readLine("Precio de compra: "));
                    precioVenta = Integer.parseInt(System.console().readLine("Precio de venta: "));
                    stock = Integer.parseInt(System.console().readLine("Stock: "));
                    listaArticulos.add(new Articulos(++codigo, name, precioCompra, precioVenta, stock));
                    break;
                case 3:
                    codigo = Integer.parseInt(System.console().readLine("Codigo del producto que a eliminar: "));
                    indice = 0;
                    for (Articulos articulos : listaArticulos) {
                        if (articulos.getCodigo() == codigo) {
                            listaArticulos.remove(indice);
                        }
                        indice++;
                    }
                    break;
                case 4:
                    codigo = Integer.parseInt(System.console().readLine("Codigo del producto que a modificar: "));
                    name = System.console().readLine("Nombre: ");
                    precioCompra = Integer.parseInt(System.console().readLine("Precio de compra: "));
                    precioVenta = Integer.parseInt(System.console().readLine("Precio de venta: "));
                    stock = Integer.parseInt(System.console().readLine("Stock: "));
                    for (Articulos articulos : listaArticulos) {
                        if (articulos.getCodigo() == codigo) {
                            articulosAux = articulos;
                        }
                    }
                    listaArticulos.remove(articulosAux.getCodigo() - 1);
                    listaArticulos.add(new Articulos(codigo, name, precioCompra, precioVenta, stock));

                    break;
                case 5:
                    codigo = Integer.parseInt(System.console().readLine("Codigo del producto: "));
                    for (Articulos articulos : listaArticulos) {
                        if (articulos.getCodigo() == codigo) {
                            articulosAux = articulos;
                        }
                    }
                    stock = articulosAux.stock + Integer.parseInt(System.console().readLine("Cantidad a comprada: "));
                    listaArticulos.remove(articulosAux.getCodigo() - 1);
                    listaArticulos.add(new Articulos(codigo, articulosAux.getDescripcion(),
                            articulosAux.getPrecioCompra(), articulosAux.getPrecioVenta(), stock));
                    break;
                case 6:
                    codigo = Integer.parseInt(System.console().readLine("Codigo del producto: "));
                    for (Articulos articulos : listaArticulos) {
                        if (articulos.getCodigo() == codigo) {
                            articulosAux = articulos;
                        }
                    }
                    stock = articulosAux.stock - Integer.parseInt(System.console().readLine("Cantidad a vendida: "));
                    listaArticulos.remove(articulosAux.getCodigo() - 1);
                    listaArticulos.add(new Articulos(codigo, articulosAux.getDescripcion(),
                            articulosAux.getPrecioCompra(), articulosAux.getPrecioVenta(), stock));
                    break;
            }
        } while (opcion != 7);
    }
}
