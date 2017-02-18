/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package practica1;

/**
 *
 * @author Luis Rafael Rivera S
 */
public class Taxis {
    private int id;
    private String modelo;
    private String marca;
    private String año;
    private int numPuertas;
    private boolean llanta;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getModelo() {
        return modelo;
    }

    public void setModelo(String modelo) {
        this.modelo = modelo;
    }

    public String getMarca() {
        return marca;
    }

    public void setMarca(String marca) {
        this.marca = marca;
    }

    public String getAño() {
        return año;
    }

    public void setAño(String año) {
        this.año = año;
    }

    public int getNumPuertas() {
        return numPuertas;
    }

    public void setNumPuertas(int numPuertas) {
        this.numPuertas = numPuertas;
    }

    public boolean isLlanta() {
        return llanta;
    }

    public void setLlanta(boolean llanta) {
        this.llanta = llanta;
    }

    @Override
    public String toString() {
        return "Taxis{" + "id=" + id + ", modelo=" + modelo + ", marca=" + marca + ", año=" + año + ", numPuertas=" + numPuertas + ", llanta=" + llanta + '}';
    }
}
