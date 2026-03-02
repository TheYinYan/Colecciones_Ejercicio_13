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
    public void setCodigo(int codigo) {
        this.codigo = codigo;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public void setPrecioCompra(int precioCompra) {
        this.precioCompra = precioCompra;
    }

    public void setPrecioVenta(int precioVenta) {
        this.precioVenta = precioVenta;
    }

    public void setStock(int stock) {
        this.stock = stock;
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

    public String factura(){
        return String.format("""  
            Codigo: %d - Nombre: %s - Cantidad: %d -  Precio: %d $         
                """, codigo,descripcion,stock,precioVenta);
    }

    @Override
    public String toString() {
        return String.format("""
                El Articulo %s tiene
                Codigo: %d
                Precio Compra: %d $
                Precio Venta: %d $
                Stock: %d productos
                            """, descripcion,codigo,precioCompra,precioVenta,stock);
    }


}
