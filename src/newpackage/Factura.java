package newpackage;

import java.util.LinkedList;
import java.util.Random;
import javax.swing.JOptionPane;

public class Factura {
    private int codigoFactura;
    int opcionMenu;
    private String nombreProd;
    private int valorProd;
    private int codigoProd;
    private String tipoProd;
    
    //rango de precios
    int precioMinimo;
    int precioMaximo;
    
    LinkedList<Producto> lista = new LinkedList<Producto>();
    
    //constructor
    public Factura() {
    }
    
    
    public void menuCrearFactura(){
        do{
            opcionMenu = Integer.parseInt(JOptionPane.showInputDialog("¿Que desea hacer?\n\n"+
                                                                   "1. Registrar compra\n"+ 
                                                                   "2. Generar Factura\n"+ 
                                                                   "0. Salir\n\n"));
        
        switch(opcionMenu){
            case 1: 
                Random newCodigo = new Random();
                codigoProd = newCodigo.nextInt(1000000)+1;
                int ingresarTipoProducto = Integer.parseInt(JOptionPane.showInputDialog("Ingrese los producto que desea añadir\n\n" + 
                                                                                    "1. Pantalones\n" + 
                                                                                    "2. Bermudas\n" + 
                                                                                    "3. Camisas manga larga\n" + 
                                                                                    "4. Camisas manga corta\n" +
                                                                                    "5. Polos\n"));
                switch(ingresarTipoProducto){
                    case 1: 
                        tipoProd = "Pantalon";
                        precioMinimo = 70000;
                        precioMaximo = 100000;
                    break;
                    case 2: 
                        tipoProd = "Bermuda"; 
                        precioMinimo = 50000;
                        precioMaximo = 70000;
                    break;
                    case 3:
                        tipoProd = "Camisa manga larga";
                        precioMinimo = 50000;
                        precioMaximo = 70000;
                    break;
                    case 4:
                        tipoProd = "Camisa manga corta";
                        precioMinimo = 40000;
                        precioMaximo = 60000;
                    break;
                    case 5:
                        tipoProd = "Polo";
                        precioMinimo = 50000;
                        precioMaximo = 80000;
                    break;
                    default: JOptionPane.showMessageDialog(null, "No ingresaste una opcion válida"); break;
                }
                
                nombreProd = JOptionPane.showInputDialog("Producto tipo '" + tipoProd + "' \n\n" +"Ingrese el nombre del producto");
                valorProd = Integer.parseInt(JOptionPane.showInputDialog("Ingrese el precio de '" + nombreProd + "' (entre $" + precioMinimo +" y $"+precioMaximo+")"));
                
                //validacion precio
                while(valorProd<precioMinimo || valorProd>precioMaximo){
                    JOptionPane.showMessageDialog(null, "PRECIO NO VALIDO, ingresa un precio entre $" + precioMinimo + " y $" + precioMaximo);
                    valorProd = Integer.parseInt(JOptionPane.showInputDialog("Ingrese el precio de '" + nombreProd + "' (entre $" + precioMinimo +" y $"+precioMaximo+")"));
                }
                
                JOptionPane.showMessageDialog(null, "¡Producto '" + nombreProd + "' de tipo '" + tipoProd + "' añadido a la lista!");
                
                Producto p1 = new Producto(nombreProd, valorProd, codigoProd, tipoProd);
                lista.add(p1);       
            break;
                
            case 2:
                Random r1 = new Random();
                codigoFactura = r1.nextInt(100)+1;
                String imprimirListado = "FACTURA N° " + codigoFactura + "\n\n";
                int totalPrecioFactura = 0;
                
                for(int i = 0; i < lista.size() ; i++){
                            imprimirListado += "Articulo N° " + (i+1) + "\n"
                                        + "Codigo de Producto: " + lista.get(i).getCodigoProducto()+"\n"    
                                        + "Nombre: " + lista.get(i).getNombre()+"\n"
                                        + "Precio: $" + lista.get(i).getValorProducto()+"\n"
                                        + "\n";
                            totalPrecioFactura += lista.get(i).getValorProducto();
                }
                
                JOptionPane.showMessageDialog(null, imprimirListado + "\n"
                                                            + "Total articulos registrados: " + lista.size() + "\n\n"
                                                            + "Total a pagar: $" + totalPrecioFactura);
            break;
        }
            
        
        }while(opcionMenu!=0);
    }
}
