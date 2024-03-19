/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package modelos;

import test.Test;
import java.util.LinkedList;

/**
 *
 * @author Lenovo
 */
public class Cliente {

    private String nombre;
    private String origenViaje;
    private EnumTipoDeCliente tipoDeCliente;
    private LinkedList<Float> listadoPesoMaletas;

    public Cliente(String nombre, String origenViaje, EnumTipoDeCliente tipoCliente) {
        this.nombre = nombre;
        this.origenViaje = origenViaje;
        this.tipoDeCliente = tipoCliente;
        this.listadoPesoMaletas = new LinkedList();
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getOrigenViaje() {
        return origenViaje;
    }

    public void setOrigenViaje(String origenViaje) {
        this.origenViaje = origenViaje;
    }

    public EnumTipoDeCliente getTipoDeCliente() {
        return tipoDeCliente;
    }

    public void setTipoDeCliente(EnumTipoDeCliente tipoDeCliente) {
        this.tipoDeCliente = tipoDeCliente;
    }

    //METODOS
    public void agregarPesoMaleta(float peso) {
        this.listadoPesoMaletas.add(peso);
    }

    public LinkedList<Float> getListadoPesoMaletas() {
        return this.listadoPesoMaletas;
    }

    public float sumarPesoTodasMalestas() {
        float suma = 0;
        for (int i = 0; i < this.listadoPesoMaletas.size(); i++) {
            suma += this.listadoPesoMaletas.get(i);
        }
        return suma;
    }

    public float calcularValorParcial() {
        float valorParcial = 0;
        float kg = 20000;
        valorParcial = sumarPesoTodasMalestas() * kg;
        return valorParcial;
    }

    public float establecerValorSobrecosto() {
        float sobrecosto = 0;
        switch (this.tipoDeCliente) {
            case PLATINO:
                sobrecosto = (float) (calcularValorParcial() * 0.15);
                break;
            case ORO:
                sobrecosto = (float) (calcularValorParcial() * 0.10);
                break;
            case DIAMANTE:
                sobrecosto = (float) (calcularValorParcial() * 0.05);
                break;
        }

        return sobrecosto;
    }

}
