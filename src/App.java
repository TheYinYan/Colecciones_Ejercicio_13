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
        listaArticulos.add(new Articulos(++codigo, "Coche", 5, 10, 5));
        do {
            System.out.println("""

                        1. Listado
                        2. Alta
                        3. Baja
                        4. Modificación
                        5. Entrada de mercancía
                        6. Venta
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
                    codigo = Integer.parseInt(System.console().readLine("Codigo del producto: "));
                    for (Articulos articulos : listaArticulos) {
                        if (articulos.getCodigo() == codigo) {
                            articulosAux = articulos;
                        }
                    }
                    if (!listaArticulos.contains(articulosAux)) {
                        name = System.console().readLine("Nombre: ");
                        precioCompra = Integer.parseInt(System.console().readLine("Precio de compra: "));
                        precioVenta = Integer.parseInt(System.console().readLine("Precio de venta: "));
                        stock = Integer.parseInt(System.console().readLine("Stock: "));
                        listaArticulos.add(new Articulos(codigo, name, precioCompra, precioVenta, stock));
                    } else {
                        System.out.println("Ese producto ya existe");
                    }
                    break;
                case 3:
                    codigo = Integer.parseInt(System.console().readLine("Codigo del producto que a eliminar: "));
                    for (Articulos articulos : listaArticulos) {
                        if (articulos.getCodigo() == codigo) {
                            articulosAux = articulos;
                        }
                    }
                    if (listaArticulos.contains(articulosAux)) {
                        indice = 0;
                        for (Articulos articulos : listaArticulos) {
                            if (articulos.getCodigo() == codigo) {
                                listaArticulos.remove(indice);
                            }
                            indice++;
                        }
                    } else {
                        System.out.println("Ese producto no existe");
                    }
                    break;
                case 4:
                    codigo = Integer.parseInt(System.console().readLine("Codigo del producto que a modificar: "));
                    for (Articulos articulos : listaArticulos) {
                        if (articulos.getCodigo() == codigo) {
                            articulosAux = articulos;
                        }
                    }
                    if (listaArticulos.contains(articulosAux)) {
                        articulosAux.setDescripcion(System.console().readLine("Nombre: "));
                        articulosAux.setPrecioCompra(Integer.parseInt(System.console().readLine("Precio de compra: ")));
                        articulosAux.setPrecioVenta(Integer.parseInt(System.console().readLine("Precio de venta: ")));
                        articulosAux.setStock(Integer.parseInt(System.console().readLine("Stock: ")));
                    } else {
                        System.out.println("Ese producto no existe");
                    }
                    break;
                case 5:
                    codigo = Integer.parseInt(System.console().readLine("Codigo del producto: "));
                    for (Articulos articulos : listaArticulos) {
                        if (articulos.getCodigo() == codigo) {
                            articulosAux = articulos;
                        }
                    }
                    articulosAux
                            .setStock(articulosAux.getStock() + Integer.parseInt(System.console().readLine("Stock: ")));
                    break;
                case 6:
                    int cantidad = Integer.parseInt(System.console().readLine("Cuantos productos va a comprar: "));
                    ArrayList<Articulos> carrito = new ArrayList<>(cantidad);
                    int total = 0;
                    for (int i = 0; i < cantidad; i++) {
                        System.out.println("""
                                *****************
                                *   Productos   *
                                *****************
                                """);
                        for (Articulos articulos : listaArticulos) {
                            System.out.println(articulos);
                        }
                        codigo = Integer.parseInt(System.console().readLine("Codigo del producto: "));
                        for (Articulos articulos : listaArticulos) {
                            if (articulos.getCodigo() == codigo) {
                                articulosAux = articulos;
                            }
                        }
                        int numArt = Integer.parseInt(System.console().readLine("Cantidad a vendida: "));
                        articulosAux.setStock(articulosAux.stock - numArt);
                        carrito.add(new Articulos(codigo, articulosAux.getDescripcion(),
                                articulosAux.getPrecioCompra(), articulosAux.getPrecioVenta(), numArt));
                    }
                    System.out.println("""
                            **********************
                            *       Factura      *
                            **********************
                                """);
                    for (Articulos articulos : carrito) {
                        System.out.println(articulos.factura());
                        total += articulos.getPrecioVenta() * articulos.getStock();
                    }
                    System.out.printf("""
                            Precio sin IVA(21%%): %d $
                            Precio con IVA(21%%): %.2f $
                                """, total, total * 1.21);
                    break;
            }
        } while (opcion != 7);
    }
}
