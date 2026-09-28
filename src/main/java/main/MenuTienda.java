/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package main;

import javax.swing.JOptionPane;
import modulo.Inventario;

/**
 *
 * @author jimer
 */
public class MenuTienda {

    private int opcion;

    private Inventario inventario = new Inventario();
    

    //Método que muestra el menú principal de la clase con todas las opciones requeridas
    public void MenuPrincipal() {

        do {

            opcion = Integer.parseInt(JOptionPane.showInputDialog("""
                      ----MENÚ TIENDA----
                      1.Registrar producto
                      2.Mostrar producto
                      3.Buscar producto por código
                      4.Venderr unidadess
                      5.Rebastecer producto
                      6.Calcular valor total del inventario
                      7.Salir
                      
                      """));

            switch (opcion) {

                case 1:
                 int codigo = Integer.parseInt(JOptionPane.showInputDialog("Ingrese el código del producto"));
                 String nombre = JOptionPane.showInputDialog("Ingrese el nombre del producto");
                 double precio = Integer.parseInt(JOptionPane.showInputDialog("Ingrese el precio del producto"));
                 int cantidadDisponible = Integer.parseInt(JOptionPane.showInputDialog("Ingrese la cantidad disponible"));
                 inventario.RegistrarProducto(codigo, nombre, precio, cantidadDisponible);
                    break;
                    
                case 2:
                    inventario.MostrarProductos();
                    break;
                case 3:
                    int buscarCodigo = Integer.parseInt(JOptionPane.showInputDialog("Ingrese el código del producto que desea buscar"));
                    inventario.BuscarProducto(buscarCodigo);
                    break;
                case 4:
                    int codigoVenta = Integer.parseInt(JOptionPane.showInputDialog("Ingrese el código del producto a venderr"));
                    int cantidadVentas = Integer.parseInt(JOptionPane.showInputDialog("Ingrese la cantidad de unidades a vender"));
                    inventario.VenderUnidades(codigoVenta, cantidadVentas);
                    break;
                case 5:
                    int codigoRebastecer = Integer.parseInt(JOptionPane.showInputDialog("Ingrese el código del producto a restablecer: "));
                    int cantRebastecer = Integer.parseInt(JOptionPane.showInputDialog("Ingrese la cantidad de unidades a añadir: "));
                    inventario.RebastecerProductos(codigoRebastecer, cantRebastecer);
                    
                    break;
                case 6:
                    inventario.CalcularValorTotal();
                    break;
                case 7:
                    JOptionPane.showMessageDialog(null, "saliendo del sistema");
                    break;
                default:
                    JOptionPane.showMessageDialog(null, "Ingrese una opción válida");
            }
        }while (opcion != 7);
 
    }//fin método MenuPrincipal

}//Fin de la clase
