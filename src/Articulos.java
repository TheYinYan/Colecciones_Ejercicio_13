public class Articulos {
    int codigo;
    String descripcion;
    int precioCompra;
    int precioVenta;
    int stock;

    public Articulos(int codigo, String descripcion, int precioCompra, int precioVenta, int stock) {
        this.codigo = codigo;
        this.descripcion = descripcion;
        this.precioCompra = precioCompra;
        this.precioVenta = precioVenta;
        this.stock = stock;
    }

    @Override
    public String toString() {
        return String.format("""
                El Articulo %s tiene
                Codigo: %d
                Precio Compra: %d$
                Precio Venta: %d$
                Stock: %d productos
                            """, descripcion,codigo,precioCompra,precioVenta,stock);
    }

    public int getCodigo() {
        return codigo;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public int getPrecioCompra() {
        return precioCompra;
    }

    public int getPrecioVenta() {
        return precioVenta;
    }

    public int getStock() {
        return stock;
    }
}
