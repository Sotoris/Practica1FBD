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
public class MetodosChoferes {

    /**
     */
    protected Chofer choferes[];

    /**
     * Creacinco5 paciente por cada medico
     *
     * @param cantidadChoferes
     */
    public MetodosChoferes(int cantidadChoferes) {
        choferes = new Chofer[cantidadChoferes];
    }

    /**
     * Leeemos la información que hay guardada en los archivos y la cargamos
     */
    public MetodosChoferes() {
        choferes= new Chofer[5];
        setChoferes(new Chofer[5 * 5]);
        ArchivoChofer archivoChofer = new ArchivoChofer();
        try {
            System.out.println("Leyendo datos....");
            choferes = archivoChofer.leeChofer();
            System.out.println("Datos leidos....");
        } catch (ArchivoLecturaNoCreadoException e) {
            System.out.println(e.getMessage());
        }
    }

    /**
     * agrega un taxi al arreglo, verifica que hay espacio disponible para que
     * este sea agregado
     *
     * @param chofer
     * @throws ExcesoTaxiException
     */
    public void agregaChofer(Chofer chofer) throws ExcesoTaxiException {
        if (!choferDisponible()) {
            throw new ExcesoTaxiException("Ya no hay espacios disponible para agregar un chofer");
        } else {
            choferes[obtenerCantidadChoferes()] = chofer;
        }

    }

    /**
     * Escribe los taxis en un archivo
     */
    public void guardarChoferes() {
        ArchivoChofer archivoC = new ArchivoChofer();
        archivoC.escribeChofer(choferes);
    }

    /**
     * ]Calcula los lugares ocupados por taxis
     *
     * @return
     */
    private int obtenerCantidadChoferes() {
        int cantidad = 0;
        for (Chofer m : choferes) {
            if (m != null) {
                cantidad++;
            }
        }
        return cantidad;
    }

    /**
     * Verifica que exista lugar para un taxi mas
     *
     * @return
     */
    private boolean choferDisponible() {
        return obtenerCantidadChoferes() < choferes.length;
    }

    /**
     * Regresa información de los taxis guardados
     *
     * @return String con la información de los taxis
     */
    public String toStringChoferes() {
        String todoChoferes = "";
        for (int i = 0; i < obtenerCantidadChoferes(); i++) {
            todoChoferes += choferes[i] + "\n";
        }
        return todoChoferes;
    }

    /**
     * Muestra los taxis que existen
     *
     * @return
     * @throws ExcesoTaxiException
     */
    public String listadoChoferes() throws ExcesoTaxiException {
        String choferesString = "";
        int i = 0;
        for (Chofer chofer : this.choferes) {
            if (chofer != null) {
                choferesString += i + " - Nombre: " + chofer.getNombre() + " idTaxi:" + chofer.getIdTaxi() + "\n";
                i++;
            }
        }
        if (choferesString.equals("")) {
            throw new ExcesoTaxiException("No existen choferes registrados");
        }
        return choferesString;
    }

    public Chofer[] getChoferes() {
        return choferes;
    }

    public Chofer getChoferes(int i) throws ExcesoTaxiException {
        if (i < 0 || i >= this.obtenerCantidadChoferes()) {
            throw new ExcesoTaxiException("Medico seleccionado incorrectamente");
        }
        return this.choferes[i];
    }

    /**
     * Elimina a un taxi del arreglo de taxis
     *
     * @param i indice del taxi a eliminar
     * @throws ExcesoTaxiException
     */
    public void eliminaChofer(int i) throws ExcesoTaxiException {
        if (i < 0 || i >= this.obtenerCantidadChoferes()) {
            throw new ExcesoTaxiException("Chofere seleccionado incorrectamente");
        }
        this.choferes[i] = null;
        this.recorreChoferes(i);
    }

    /**
     * Se encarga de recorrer los taxis en el arreglo para que no haya nulos en
     * taxi
     */
    private void recorreChoferes(int i) {

        int indiceUltimoC = this.obtenerCantidadChoferes();
        if (i != indiceUltimoC) {
            this.choferes[i] = choferes[indiceUltimoC];
            choferes[indiceUltimoC] = null;
        }
    }

    public void setChoferes(Chofer[] choferes) {
        this.choferes = choferes;
    }
    
    public void verChoferes(String[] arr){
        for(int i = 0 ; i< arr.length; i++){
            System.out.println(arr[i]);
        }
    }

    
}
