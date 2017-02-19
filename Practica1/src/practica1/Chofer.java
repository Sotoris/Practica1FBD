/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package practica1;


/**
 *
 * @author toski
 */
public class Chofer extends Persona{
    
    public Chofer(String nombre, String domicilio, int numLicencia, String fechaIngreso, 
            String email, int numCelular){
        super(nombre, domicilio, numLicencia, fechaIngreso, email, numCelular);
        
    }
    
    public Chofer(){
        super();
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
