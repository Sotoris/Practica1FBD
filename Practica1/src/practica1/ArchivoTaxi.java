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
public class ArchivoTaxi extends ManipulaArchivo {
	public ArchivoTaxi() {
		// coustrimos un file llamado taxis, para poder editar
		super("taxis.txt");
	}

	/**
	 * Prepara un arreglo de Taxis para que pueda ser guardado
	 * 
	 * @param taxi
	 *            los taxis que se desean guardar
	 */
	public void escribeTaxi(Taxis taxi[]) {
		String lineaTaxi = "";
		for (Taxis m : taxi) {
			lineaTaxi += m + "\n";
		}
		super.escribeArchivo(lineaTaxi);
	}
 
	/**
	 * Convierte un arreglo de String a un arreglo de taxis
	 * @return arreglo de Taxis con los datos del archivo
	 * @throws ArchivoLecturaNoCreadoException
	 */
	public Taxis[] leeMedicos() throws ArchivoLecturaNoCreadoException {
		String lineas[] = super.leeArchivo();
		Taxis taxis[] = new Taxis[lineas.length];
		for (int i = 0; i < taxis.length; i++) {
			if (!lineas[i].equals("null")) {
				taxis[i] = this.parseTaxi(lineas[i]);
			}
		}
		return taxis;
	}

	/**
	 * Recibe una cadena y parsea los datos para crear el objeto Taxis
	 * @param cadenaTaxi la cadena a parsear 
	 * @return el objeto con los datos de la cadena
	 */
	private Taxis parseTaxi(String cadenaTaxi) {
		String linea[] = cadenaTaxi.trim().split(",");
		int id = Integer.parseInt(linea[0]);
		String marca = linea[1];
                String modelo = linea[2];
		int año = Integer.parseInt(linea[3]);
		int numPuertas = Integer.parseInt(linea[4]);
                char llanta = linea[5].charAt(0);
                int idDueño = Integer.parseInt(linea[6]);
		return new Taxis(id, marca, modelo, año, numPuertas, llanta, idDueño);
	}

}
