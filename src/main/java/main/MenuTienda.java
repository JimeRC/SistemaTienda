/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package main;

import javax.swing.JOptionPane;

/**
 *
 * @author jimer
 */
public class MenuTienda {

    private int opcion;

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
        }while(opcion != 7);
    }//fin método MenuPrincipal

}//Fin de la clase
