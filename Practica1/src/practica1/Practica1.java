/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package practica1;

/**
 *
 * @author Rafita
 * @author yo
 */
public class Practica1 {

    /**
     * @param args the command line arguments
     */
    private Taxis taxis[];

    /**
     *
     *
     * @param cantidadTaxis
     */
    public Practica1(int cantidadTaxis) {
        taxis = new Taxis[cantidadTaxis];
    }

    /**
     * Leeemos la información que hay guardada en los archivos y la cargamos
     */
    public Practica1() {
        taxis = new Taxis[5];
        setTaxis(new Taxis[5 * 5]);
        ArchivoTaxi archivoTaxi = new ArchivoTaxi();
        try {
            System.out.println("Leyendo datos....");
            taxis = archivoTaxi.leeTaxis();
            System.out.println("Datos leidos....");
        } catch (ArchivoLecturaNoCreadoException e) {
            System.out.println(e.getMessage());
        }
    }

    /**
     * agrega un taxi al arreglo, verifica que hay espacio disponible para que
     * este sea agregado
     *
     * @param taxi
     * @throws ExcesoTaxiException
     */
    public void agregaTaxis(Taxis taxi) throws ExcesoTaxiException {
        if (!lugarTaxisDisponible()) {
            throw new ExcesoTaxiException("Ya no hay espacios disponible para agregar un médico");
        } else {
            taxis[obtenerCantidadTaxis()] = taxi;
        }

    }

    /**
     * Escribe los taxis en un archivo
     */
    public void guardarTaxis() {
        ArchivoTaxi archivoT = new ArchivoTaxi();
        archivoT.escribeTaxi(taxis);
    }

    /**
     * ]Calcula los lugares ocupados por taxis
     *
     * @return
     */
    private int obtenerCantidadTaxis() {
        int cantidad = 0;
        for (Taxis m : taxis) {
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
    private boolean lugarTaxisDisponible() {
        return obtenerCantidadTaxis() < taxis.length;
    }

    /**
     * Regresa información de los taxis guardados
     *
     * @return String con la información de los taxis
     */
    public String toStringTaxis() {
        String todoTaxis = "";
        for (int i = 0; i < obtenerCantidadTaxis(); i++) {
            todoTaxis += taxis[i] + "\n";
        }
        return todoTaxis;
    }

    /**
     * Muestra los taxis que existen
     *
     * @return
     * @throws ExcesoTaxiException
     */
    public String listadoTaxis() throws ExcesoTaxiException {
        String taxisString = "";
        int i = 0;
        for (Taxis taxi : this.taxis) {
            if (taxi != null) {
                taxisString += i + " - Marca: " + taxi.getMarca() + " Modelo:" + taxi.getModelo() + "\n";
                i++;
            }
        }
        if (taxisString.equals("")) {
            throw new ExcesoTaxiException("No existen médicos registrados");
        }
        return taxisString;
    }

    public Taxis[] getTaxis() {
        return taxis;
    }

    public Taxis getTaxis(int i) throws ExcesoTaxiException {
        if (i < 0 || i >= this.obtenerCantidadTaxis()) {
            throw new ExcesoTaxiException("Taxi seleccionado incorrectamente");
        }
        return this.taxis[i];
    }

    /**
     * Elimina a un taxi del arreglo de taxis
     *
     * @param i indice del taxi a eliminar
     * @throws ExcesoTaxiException
     */
    public void eliminaTaxi(int i) throws ExcesoTaxiException {
        if (i < 0 || i >= this.obtenerCantidadTaxis()) {
            throw new ExcesoTaxiException("Taxi seleccionado incorrectamente");
        }
        this.taxis[i] = null;
        this.recorreTaxis(i);
    }

    /**
     * Se encarga de recorrer los taxis en el arreglo para que no haya nulos en
     * taxi
     */
    private void recorreTaxis(int i) {

        int indiceUltimoT = this.obtenerCantidadTaxis();
        if (i != indiceUltimoT) {
            this.taxis[i] = taxis[indiceUltimoT];
            taxis[indiceUltimoT] = null;
        }
    }

    public void setTaxis(Taxis[] taxis) {
        this.taxis = taxis;
    }

    /*
    *imprime los taxis
    */
    public void verTaxis() {
        int i = 0;
        for (Taxis taxi : this.taxis) {
            if (taxi != null) {
                System.out.println(i + " Id: " + taxi.getId() + "  Marca: " + taxi.getMarca()
                        + "  Modelo:" + taxi.getModelo() + "  Año: " + taxi.getAño() + "  NumPuertas: "
                        + taxi.getNumPuertas() + " IdDueño " + "\n");

                i++;
            }
        }
        if (i == 0) {
            System.out.println("No hay Taxis");
        }
    }
}
