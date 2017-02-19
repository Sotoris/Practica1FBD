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
public class ArchivoChofer extends ManipulaArchivo{
	
    public ArchivoChofer() {
		super("chofer.txt");
	}

    public void escribeChofer(Chofer chofer[]) {
		String lineaChofer= "";
		for (Chofer m : chofer) {
			lineaChofer += m + "\n";
		}
		super.escribeArchivo(lineaChofer);
	}
	
    public Chofer[] leeChofer() throws ArchivoLecturaNoCreadoException {
		String lineas[] = super.leeArchivo();
		Chofer choferes[] = new Chofer[lineas.length];
		for (int i = 0; i < choferes.length; i++) {
			if (!lineas[i].equals("null")) {
				choferes[i] = this.parseaChofer(lineas[i]);
			}
		}
		return choferes;
	}

	
    private Chofer parseaChofer(String cadenaChofer) {
		String linea[] = cadenaChofer.trim().split(",");
		String nombre = linea[0];
                String domicilio = linea[1];
                int numLicencia = Integer.parseInt(linea[2]);
                String fechaIngreso = linea[3];
                String email = linea[4];
                int numCelular = Integer.parseInt(linea[5]);
		return new Chofer(nombre, domicilio, numLicencia, fechaIngreso,email,numCelular);
	}

    
}
