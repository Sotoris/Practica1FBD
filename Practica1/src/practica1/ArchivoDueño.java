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
public class ArchivoDueño extends ManipulaArchivo {
    
    public ArchivoDueño(){
        super("dueños.txt");
    }
    
    /**
     * Crea un arreglo que almacena dueños y se puedan guardar en un archivo
     * @param dueño
     */
    public void escribeDueños(Dueño dueño[]){
        String lineadueño = "";
        for (Dueño m : dueño){
            lineadueño += m + "\n";
        }
        super.escribeArchivo(lineadueño);
    }
    
    /**
     * Convierte el arreglo String en un arreglo de dueños
     * @return arreglo de dueños con los datos del archivo
     * @throws ArchivoLecturaNoCreadoException
     */
    
    public Dueño[] leerMedios() throws ArchivoLecturaNoCreadoException{
        String lineas[] = super.leeArchivo();
		Dueño dueños[] = new Dueño[lineas.length];
		for (int i = 0; i < dueños.length; i++) {
			if (!lineas[i].equals("null")) {
				dueños[i] = this.escribeDueño(lineas[i]);
			}
		}
		return dueños;
    }
    
    /**
     * Recibe una cadena y convierte los datos en un objeto dueño
     * @param cadenaDueño la cadena a parsear
     * @return el objeto dueño con los datos de la cadena
    */
    private Dueño escribeDueño(String cadenaDueño){
        String linea[] = cadenaDueño.trim().split(",");
        String nombre = linea[0];
        String domicilio = linea[1];
        int numLicencia = Integer.parseInt(linea[2]);
        String fechaIngreso = linea[3];
        String email = linea[4];
        int numCelular = Integer.parseInt(linea[5]);
        int idTaxi = Integer.parseInt(linea[6]);
        String RFC = linea[7];
        int idDueño = Integer.parseInt(linea[8]);
        return new Dueño (nombre,domicilio,numLicencia,fechaIngreso,email,numCelular,idTaxi,RFC,idDueño);
        
    }
}
