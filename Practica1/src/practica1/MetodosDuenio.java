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
public class MetodosDuenio {

    /**
     * @param args the command line arguments
     */
    private Duenio duenios[];

    /**
     *
     *
     * @param cantidadDuenios
     */
    public MetodosDuenio(int cantidadDuenios) {
        duenios = new Duenio[cantidadDuenios];
    }

    /**
     * Leeemos la información que hay guardada en los archivos y la cargamos
     */
    public MetodosDuenio() {
        duenios = new Duenio[5];
        setDuenios(new Duenio[5 * 5]);
        ArchivoDuenio archivoduenio = new ArchivoDuenio();
        try {
            System.out.println("Leyendo datos....");
            duenios = archivoduenio.leerMedios();
            System.out.println("Datos leidos....");
        } catch (ArchivoLecturaNoCreadoException e) {
            System.out.println(e.getMessage());
        }
    }

    /**
     * agrega un duenio al arreglo, verifica que hay espacio disponible para que
     * este sea agregado
     *
     * @param taxi
     * @throws ExcesoTaxiException
     */
    public void agregaDuenios(Duenio duenio) throws ExcesoDuenioException {
        if (!lugarDueniosDisponible()) {
            throw new ExcesoDuenioException("Ya no hay espacios disponible para agregar un duenio");
        } else {
            duenios[obtenerCantidadDuenios()] = duenio;
        }

    }

    /**
     * Escribe los duenios en un archivo
     */
    public void guardarDuenios() {
        ArchivoDuenio archivoD = new ArchivoDuenio();
        archivoD.escribeDuenios(duenios);
    }

    /**
     * ]Calcula los lugares ocupados por duenios
     *
     * @return
     */
    private int obtenerCantidadDuenios() {
        int cantidad = 0;
        for (Duenio m : duenios) {
            if (m != null) {
                cantidad++;
            }
        }
        return cantidad;
    }

    /**
     * Verifica que exista lugar para un duenio mas
     *
     * @return
     */
    private boolean lugarDueniosDisponible() {
        return obtenerCantidadDuenios() < duenios.length;
    }

    /**
     * Regresa información de los duenios guardados
     *
     * @return String con la información de los taxis
     */
    public String toStringDuenios() {
        String todoDuenios = "";
        for (int i = 0; i < obtenerCantidadDuenios(); i++) {
            todoDuenios += duenios[i] + "\n";
        }
        return todoDuenios;
    }

    /**
     * Muestra los duenios que existen
     *
     * @return
     * @throws ExcesoTaxiException
     */
    public String listadoDuenios() throws ExcesoDuenioException {
        String DueniosString = "";
        int i = 0;
        for (Duenio duenios : this.duenios) {
            if (duenios != null) {
                DueniosString += i + " - Nombre: " + duenios.getNombre() + " Num.Licencia:" + duenios.getNumLicencia() + "\n";
                i++;
            }
        }
        if (DueniosString.equals("")) {
            throw new ExcesoDuenioException("No existen Duenios registrados");
        }
        return DueniosString;
    }

    public Duenio[] getDuenios() {
        return duenios;
    }

    public Duenio getDuenios(int i) throws ExcesoDuenioException {
        if (i < 0 || i >= this.obtenerCantidadDuenios()) {
            throw new ExcesoDuenioException("Duenio seleccionado incorrectamente");
        }
        return this.duenios[i];
    }

    /**
     * Elimina a un duenio del arreglo de taxis
     *
     * @param i indice del duenio a eliminar
     * @throws ExcesoDuenioException
     */
    public void eliminaDuenio(int i) throws ExcesoDuenioException, ExcesoTaxiException {
        if (i < 0 || i >= this.obtenerCantidadDuenios()) {
            throw new ExcesoDuenioException("Duenio seleccionado incorrectamente");
        }
        Practica1 practica1 = new Practica1();
        Taxis taxis[] = practica1.getTaxis();
        Duenio due = this.duenios[i];
        int k = 0;
        for (Taxis taxi : taxis) {
            if (taxi.getId() == due.getidTaxi()) {
                practica1.eliminaTaxi(k);
            }
            k++;
        }
        this.duenios[i] = null;
        this.recorreDuenios(i);
    }

    /**
     * Se encarga de recorrer los duenios en el arreglo para que no haya nulos en
     * duenios
     */
    private void recorreDuenios(int i) {

        int indiceUltimoT = this.obtenerCantidadDuenios();
        if (i != indiceUltimoT) {
            this.duenios[i] = duenios[indiceUltimoT];
            duenios[indiceUltimoT] = null;
        }
    }

    public void setDuenios(Duenio[] duenios) {
        this.duenios = duenios;
    }

    public void verDuenios(String[] arr) {
        for (int i = 0; i < arr.length; i++) {
            System.out.println(arr[i]);
        }
    }

    /*
    *imprime los duenios
     */
    public void verDuenios() {
        int i = 0;
        for (Duenio duenios : this.duenios) {
            if (duenios != null) {
                System.out.println(i + "  Nombre: " + duenios.getNombre()
                        + "  Num.Licencia: " + duenios.getNumLicencia()
                        + "  Domicilio: " + duenios.getDomicilio() + "  RFC: " + duenios.getRFC()
                        + "  Email: " + duenios.getEmail() + "  Celular " + duenios.getNumCelular()
                        + "  IdTaxi: " + duenios.getidTaxi() + "\n");
                i++;
            }
        }
        if (i == 0) {
            System.out.println("No hay duenios registrados");
        }
    }
}
