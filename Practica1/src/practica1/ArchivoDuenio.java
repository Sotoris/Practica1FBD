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
public class ArchivoDuenio extends ManipulaArchivo {
    
    public ArchivoDuenio(){
        super("dueños.txt");
    }
    
    /**
     * Crea un arreglo que almacena duenios y se puedan guardar en un archivo
     * @param duenio
     */
    public void escribeDuenios(Duenio duenio[]){
        String lineaduenio = "";
        for (Duenio m : duenio){
            lineaduenio += m + "\n";
        }
        super.escribeArchivo(lineaduenio);
    }
    
    /**
     * Convierte el arreglo String en un arreglo de duenios
     * @return arreglo de duenios con los datos del archivo
     * @throws ArchivoLecturaNoCreadoException
     */
    
    public Duenio[] leerMedios() throws ArchivoLecturaNoCreadoException{
        String lineas[] = super.leeArchivo();
		Duenio duenios[] = new Duenio[lineas.length];
		for (int i = 0; i < duenios.length; i++) {
			if (!lineas[i].equals("null")) {
				duenios[i] = this.parseaDuenio(lineas[i]);
			}
		}
		return duenios;
    }
    
    /**
     * Recibe una cadena y convierte los datos en un objeto duenio
     * @param cadenaDuenio la cadena a parsear
     * @return el objeto duenio con los datos de la cadena
    */
    private Duenio parseaDuenio(String cadenaDuenio){
        String linea[] = cadenaDuenio.trim().split(",");
        String nombre = linea[0];
        String domicilio = linea[1];
        int numLicencia = Integer.parseInt(linea[2]);
        String fechaIngreso = linea[3];
        String email = linea[4];
        int numCelular = Integer.parseInt(linea[5]);
        int idTaxi = Integer.parseInt(linea[6]);
        String RFC = linea[7];
        int idDuenio = Integer.parseInt(linea[8]);
        return new Duenio (nombre,domicilio,numLicencia,fechaIngreso,email,numCelular,idTaxi,RFC,idDuenio);
        
    }
}
