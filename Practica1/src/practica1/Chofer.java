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
 * @author toski
 */
public class Chofer extends Persona{
    
    protected int idTaxi;
    
    public Chofer(String nombre, String domicilio, int numLicencia, String fechaIngreso, 
            String email, int numCelular, int idTaxi){
        super(nombre, domicilio, numLicencia, fechaIngreso, email, numCelular);
        this.idTaxi = idTaxi;
    }
    
    public Chofer(){
        super();
    }
    
    private void pideDatos() {
		input = new Scanner(System.in);
		boolean bandera = true;
		System.out.println("Ingresa nombre.");
		this.nombre = input.next();
		do {
			try {
				System.out.println("Ingresa domicilio.");
				this.domicilio = input.next();
                                System.out.println("Ingresa numero de licencia");
                                this.numLicencia = input.nextInt();
                                System.out.println("Ingresa fecha de ingreso con formato dd/mm/aaaa.");
                                this.fechaIngreso = input.next();
                                System.out.println("Ingresa email.");
                                this.email = input.next();
                                System.out.println("Ingresa numero celular.");
                                this.numCelular = input.nextInt();
                                System.out.println("Ingresa ID del taxi");
                                this.idTaxi = input.nextInt();
				bandera = false;
			} catch (InputMismatchException e) {
				input.next();
				bandera = false;
			}
		} while (bandera);
	}

    
    @Override
    public void edita(){
        pideDatos();
    }
    
    @Override
    public String getNombre() {
		return nombre;
	}

    @Override
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

    @Override
	public String getDomicilio() {
		return domicilio;
	}

    @Override
	public void setDomicilio(String domicilio) {
		this.domicilio = domicilio;
	}

    @Override
	public int numLicencia() {
		return numLicencia;
	}

    @Override
	public void setNumLicencia(int numLicencia) {
		this.numLicencia = numLicencia;
	}
        
    @Override
        public String getFechaIngreso(){
            return fechaIngreso;
        }
        
    @Override
        public void setFechaIngreso(String fechaIngreso){
            this.fechaIngreso = fechaIngreso;
        }
        
    @Override
        public String getEmail(){
            return email;
        }
        
    @Override
        public void setEmail(String email){
            this.email = email;
        }
        
    @Override
        public int getNumCelular(){
            return numCelular;
        }
        
    @Override
        public void setNumCelular(int numCelular){
            this.numCelular = numCelular;
        }
        
        public int getIdTaxi(){
            return idTaxi;
        }
        
        public void setIdTaxi(int idTaxi){
            this.idTaxi = idTaxi;
        }
        
        @Override
	public String toString() {
		return this.nombre + "," + this.domicilio + "," + this.numLicencia
                        + "," + this.fechaIngreso + "," + this.email + "," + this.numCelular
                        + "," + this.idTaxi;
	}

	public static void main(String[] args) {
		Chofer c = new Chofer();
		System.out.println(c);
	}

}
