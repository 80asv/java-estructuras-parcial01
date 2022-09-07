package newpackage;

import javax.swing.JOptionPane;

public class Producto {
    private String nombre;
    private int valorProducto;
    private int codigoProducto;
    private String tipoProd;

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public int getValorProducto() {
        return valorProducto;
    }

    public void setValorProducto(int valorProducto) {
        this.valorProducto = valorProducto;
    }

    public int getCodigoProducto() {
        return codigoProducto;
    }

    public void setCodigoProducto(int codigoProducto) {
        this.codigoProducto = codigoProducto;
    }

    public Producto(String nombre, int valorProducto, int codigoProducto, String tipoProd) {
        this.nombre = nombre;
        this.valorProducto = valorProducto;
        this.codigoProducto = codigoProducto;
        this.tipoProd = tipoProd;
    }
}
