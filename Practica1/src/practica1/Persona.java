/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package practica1;

import java.util.Scanner;
import java.util.InputMismatchException;

/**
 *
 * @author toski
 */

public class Persona {
    protected String nombre;
    protected String domicilio;
    protected int numLicencia;
    protected String fechaIngreso;
    protected String email;
    protected int numCelular;
    protected Scanner input;
    
    public Persona(String nombre, String domicilio, int numLicencia, String fechaIngreso, 
            String email, int numCelular){
        this.nombre = nombre;
        this.domicilio = domicilio;
        this.numLicencia = numLicencia;
        this.fechaIngreso = fechaIngreso;
        this.email = email;
        this.numCelular = numCelular;
        
    }
    
    public Persona() {
		pideDatos();
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
                                System.out.println("Ingresa numero celular  .");
                                this.numCelular = input.nextInt();
				bandera = false;
			} catch (InputMismatchException e) {
				input.next();
				bandera = false;
			}
		} while (bandera);
	}


        public void edita(){
            pideDatos();
        }
	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getDomicilio() {
		return domicilio;
	}

	public void setDomicilio(String domicilio) {
		this.domicilio = domicilio;
	}

	public int numLicencia() {
		return numLicencia;
	}

	public void setNumLicencia(int numLicencia) {
		this.numLicencia = numLicencia;
	}
        
        public String getFechaIngreso(){
            return fechaIngreso;
        }
        
        public void setFechaIngreso(String fechaIngreso){
            this.fechaIngreso = fechaIngreso;
        }
        
        public String getEmail(){
            return email;
        }
        
        public void setEmail(String email){
            this.email = email;
        }
        
        public int getNumCelular(){
            return numCelular;
        }
        
        public void setNumCelular(int numCelular){
            this.numCelular = numCelular;
        }

	@Override
	public String toString() {
		return this.nombre + "," + this.domicilio + "," + this.numLicencia
                        + "," + this.fechaIngreso + "," + this.email + "," + this.numCelular;
	}

	public static void main(String[] args) {
		Persona m = new Persona();
		System.out.println(m);
	}


}
