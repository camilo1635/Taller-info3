/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package test;

import modelos.Cliente;
import modelos.EnumTipoDeCliente;
import java.util.LinkedList;
import java.util.Scanner;

/**
 *
 * @author Lenovo
 */
public class Test {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {

        Scanner objScanner = new Scanner(System.in);
        char opcion;
        System.out.println("Digite su nombre: ");
        String nombres = objScanner.nextLine();
        System.out.println("Digite origen de viaje: ");
        String origenViaje = objScanner.nextLine();
        System.out.println("Eliga tipo de cliente: ");
        System.out.println("1.PLAIINO, 2. ORO, 3. DIAMANTE");
        int seleccion = objScanner.nextInt();
        EnumTipoDeCliente tipoDeClienteSeleccionado = null;
        switch (seleccion) {
            case 1:
                tipoDeClienteSeleccionado = EnumTipoDeCliente.PLATINO;
                break;
            case 2:
                tipoDeClienteSeleccionado = EnumTipoDeCliente.ORO;
                break;
            case 3:
                tipoDeClienteSeleccionado = EnumTipoDeCliente.DIAMANTE;
                break;
        }

        Cliente objCliente1 = new Cliente(nombres, origenViaje, tipoDeClienteSeleccionado);

        do {
            System.out.println("Ingrese peso de la maleta ");
            float maleta = objScanner.nextFloat();
            objScanner.nextLine();
            objCliente1.agregarPesoMaleta(maleta);
            System.out.println("Desea ingresar otra maleta s/n");
            opcion = objScanner.nextLine().charAt(0);
        } while (opcion == 's');

        mostrarDatosBasicos(objCliente1);
        mostrarDatosComplementarios(objCliente1);

    }

    private static void mostrarDatosBasicos(Cliente objCliente) {
        System.out.println("==Factura del cliente==");
        System.out.println("Nombre cliente:: " + objCliente.getNombre());
        System.out.println("Origen Viaje: " + objCliente.getOrigenViaje());
        System.out.println("Tipo de cliente: " + objCliente.getTipoDeCliente());

    }

    private static void mostrarDatosComplementarios(Cliente objCliente) {
        for (int i = 0; i < objCliente.getListadoPesoMaletas().size(); i++) {
            System.out.print("Maleta " + i + " ");
        }
        System.out.println("");
        for (int j = 0; j < objCliente.getListadoPesoMaletas().size(); j++) {
            float peso = objCliente.getListadoPesoMaletas().get(j);
            System.out.print(peso + "Kg    ");
        }
        System.out.println("");
        System.out.println("Peso total: " + objCliente.sumarPesoTodasMalestas() + " KG");
        System.out.println("Valor parcial a pagar: $" + objCliente.calcularValorParcial());
        System.out.println("Valor Sobrecosto: $" + objCliente.establecerValorSobrecosto());
        System.out.println("Valor total: $" + (objCliente.calcularValorParcial() + objCliente.establecerValorSobrecosto()));
    }

}
