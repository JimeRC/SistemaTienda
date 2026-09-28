/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package modulo;

import javax.swing.JOptionPane;

/**
 *
 * @author jimer
 */
public class Inventario {

    //Creamos el método producto
    private Producto[] listaProductos = new Producto[10];

    //La variable que indica cuantas posiciones están realmente ocuadas
    private int cantidad = 0;

    //Método para registrar un producto
    public void RegistrarProducto(int codigo, String nombre, double precio, int cantidadDisponible) {

        if (cantidad >= 10) {
            JOptionPane.showMessageDialog(null, "ERROR: El inventario está lleno (máximo 10 productos)");
            return;
        }
        for (int i = 0; i < cantidad; i++) {
            if (listaProductos[i].getCodigo() == codigo) {
                JOptionPane.showMessageDialog(null, "ERROR: El código " + codigo + "ya existe.");
                return;
            }
        }
        if (codigo <= 0) {
            JOptionPane.showMessageDialog(null, "ERROR: los números deeben serr mayores a 0");
            return;

        }
        if (precio <= 0) {
            JOptionPane.showMessageDialog(null, "ERROR: los números deeben serr mayores a 0");
            return;
        }

        if (cantidadDisponible <= 0) {
            JOptionPane.showMessageDialog(null, "ERROR: los números deeben serr mayores a 0");
            return;
        }
        listaProductos[cantidad] = new Producto(codigo, nombre, precio, cantidadDisponible);
        cantidad++;
        JOptionPane.showMessageDialog(null, "Producto registrado con éxito");

    }

    //Método para mostrar productos
    public void MostrarProductos() {
        if (cantidad == 0) {
            JOptionPane.showMessageDialog(null, "El inventario está vacío");
            return;
        }

        String textoLista = "----LISTA DE PRODUCTOS----";

        for (int i = 0; i < cantidad; i++) {

            textoLista += "\nCódigo: " + listaProductos[i].getCodigo()
                    + "\nNombre: " + listaProductos[i].getNombre()
                    + "\nPrecio: " + listaProductos[i].getPrecio()
                    + "\nDisponibles: " + listaProductos[i].getCantidadDisponible();

        }
        JOptionPane.showMessageDialog(null, textoLista);

    }

    //Método para mostrar productos
    public void BuscarProducto(int codigo) {
        for (int i = 0; i < cantidad; i++) {
            if (listaProductos[i].getCodigo() == codigo) {
                JOptionPane.showMessageDialog(null, "----PRODUCTO ENCONTRADO----"
                        + "\nCódigo: " + listaProductos[i].getCodigo() + "\n"
                        + "Nombre: " + listaProductos[i].getNombre() + "\n"
                        + "Precio: " + listaProductos[i].getPrecio() + "\n"
                        + "Cantidad de existencia: " + listaProductos[i].getCantidadDisponible());
                return;

            }
        }
        JOptionPane.showMessageDialog(null, "El producto con el código: " + codigo + " no existe.");

    }

    //Método para vender unidades
    public void VenderUnidades(int codigo, int cantVender) {
        for (int i = 0; i < cantidad; i++) {
            if (listaProductos[i].getCantidadDisponible() < cantVender) {
                JOptionPane.showMessageDialog(null, "No hay suficientes unidades disponibles. Stock actual: " + listaProductos[i].getCantidadDisponible());
                return;
            }
            int nuevoStock = listaProductos[i].getCantidadDisponible() - cantVender;
            listaProductos[i].setCantidadDisponible(nuevoStock);
            JOptionPane.showMessageDialog(null, "Venta realizada con éxito!!  Nuevo stock de: " + listaProductos[i].getNombre() + nuevoStock);
        }
        JOptionPane.showMessageDialog(null, "El producto con el código: " + codigo + " no existe.");
    }

    //Método para rebastecer productos
    public void RebastecerProductos(int codigo, int cantidadNueva) {
        if (cantidadNueva <= 0) {
            JOptionPane.showMessageDialog(null, "La cantidad a rebastecer debe ser mayor a cero");
            return;
        }
        for (int i = 0; i < cantidad; i++) {
            if (listaProductos[i].getCodigo() == codigo) {
                int nuevoStock = listaProductos[i].getCantidadDisponible() + cantidadNueva;
                listaProductos[i].setCantidadDisponible(nuevoStock);
                JOptionPane.showMessageDialog(null, "Restablecimiento existoso! Nuevo stock de: " + listaProductos[i].getNombre() + nuevoStock);
                return;

            }
        }
        JOptionPane.showMessageDialog(null, "El producto con el código: " + codigo + " no existe.");
    }

    //Método para calcular el valor total del inventario
    public void CalcularValorTotal() {
        if (cantidad == 0) {
            JOptionPane.showMessageDialog(null, "El valor total del inventario es de 0.00 colones(no hay productos registrados). ");
            return;

        }
        double sumaTotal = 0.0;
        for (int i = 0; i < cantidad; i++){
            double valorProducto = listaProductos[i].getPrecio() * listaProductos[i].getCantidadDisponible();
            sumaTotal += valorProducto;
            
        }
        double totalFinal = (sumaTotal * 100.0) / 100.0;
        JOptionPane.showMessageDialog(null, "VALOR TOTAL DEL INVENTARIO" + 
                    "\nEl valor total acumulado de todos los productos es de: " + totalFinal);
    }

}
