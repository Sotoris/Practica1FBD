/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package practica1;

import java.util.InputMismatchException;
import java.util.Scanner;

/**
 *
 * @author Luis Rafael Rivera S
 */
public class Taxis {

    private int id;
    private String modelo;
    private String marca;
    private int año;
    private int numPuertas;
    private char llanta;
    private Scanner input;
    private int idDueño;

    public Taxis() {
        pideDatos();
    }

    public Taxis(int id, String modelo, String marca, int año, int numPuertas, char llanta, int idDueño) {
        this.id = id;
        this.modelo = modelo;
        this.marca = marca;
        this.año = año;
        this.numPuertas = numPuertas;
        this.llanta = llanta;
        this.idDueño = idDueño;
    }

    /**
     * Metodo que pide datos para inicializar la clase
     */
    private void pideDatos() {
        input = new Scanner(System.in);
        boolean bandera = true;
        this.llanta = ' ';
        do {
            try {
                System.out.println("Ingresa id del Taxi.");
                this.id = input.nextInt();
                System.out.println("Ingresa id del Dueño.");
                this.idDueño = input.nextInt();
                System.out.println("Ingresa el año.");
                this.año = input.nextInt();
                System.out.println("Ingresa el numero de Purtas.");
                this.numPuertas = input.nextInt();
                bandera = false;
            } catch (InputMismatchException e) {
                input.next();
                bandera = true;
            }
        } while (bandera);
        input = new Scanner(System.in);
        System.out.println("Ingresa el modelo.");
        this.modelo = input.nextLine();
        System.out.println("Ingresa la marca.");
        this.marca = input.nextLine();
        do {
            System.out.println("Tiene Refacciones\n" + "Si - S\n" + "No - N");
            this.llanta = input.next().toUpperCase().charAt(0);
        } while (this.llanta != ' ' && this.llanta != 'S' && this.llanta != 'N');

    }

    public void edita() {
        pideDatos();
    }

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

    public int getAño() {
        return año;
    }

    public void setAño(int año) {
        this.año = año;
    }

    public int getNumPuertas() {
        return numPuertas;
    }

    public void setNumPuertas(int numPuertas) {
        this.numPuertas = numPuertas;
    }

    public char isLlanta() {
        return llanta;
    }

    public void setLlanta(char llanta) {
        this.llanta = llanta;
    }

    @Override
    public String toString() {
        return this.id + "," + this.modelo + "," + this.marca + "," + this.año + "," + this.numPuertas + "," + this.llanta + "," + this.idDueño;
    }

}
