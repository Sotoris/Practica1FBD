/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package practica1;

/**
 *
 * @author Miguel
 */
public class Duenio extends Persona  {
    
    protected int idTaxi;
    protected String RFC;
    protected int idDueño;
    
    public Duenio (String nombre, String domicilio, int numLicencia, String fechaIngreso, String email, int numCelular, int idTaxi, String RFC, int idDueño){
            super (nombre,domicilio,numLicencia,fechaIngreso,email,numCelular);
            this.idTaxi = idTaxi;
            this.RFC = RFC;
            this.idDueño = idDueño;
    }
    
    public Duenio(){
        super();
    }

    public String getNombre(){
        return nombre;
    }
    
    public void setNombre(String nombre){
        this.nombre = nombre;
    }
    
    public String getDomicilio(){
        return domicilio;
    }
    
    public void setDomicilio(String domicilio){
        this.domicilio = domicilio ;
    }
    
    public int getNumLicencia(){
        return numLicencia;
    }
    
    public void setNumLicencia(int numero){
        this.numLicencia = numero;
    }
    
    public String getFechaIngreso(){
        return fechaIngreso;
    }
    
    public void setFechaIngreso(String fecha){
        this.fechaIngreso = fecha;
    }
    
    public int getNumCelular(){
        return numCelular;
    }
    
    public void setNumCelular(int numero){
        this.numCelular = numero;
    }
    
    public int getidTaxi(){
        return idTaxi;
    }
    
    public void setidTaxi(int taxi){
        this.idTaxi = taxi;
    }
    
    public String getRFC(){
        return RFC;
    }
    
    public void setRFC(String RFC){
        this.RFC = RFC;
    }
    
    public int getidDueño(){
        return idDueño;
    }
    
    public void setidDueño(int id){
        this.idDueño = id;
    }
    
    public String toString(){
        return this.nombre + "," + this.domicilio + "," + this.numLicencia
                        + "," + this.fechaIngreso + "," + this.email + "," + this.numCelular + "," + this.idTaxi + ","+
                        this.RFC + "," +this.idDueño;
    }
    
    public static void main(String[] args) {
		Persona m = new Persona();
		System.out.println(m);
    }
} 