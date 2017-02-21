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
public class MetodosDueño {

    /**
     * @param args the command line arguments
     */
    private Dueño dueños[];

    /**
     *
     *
     * @param cantidadDueños
     */
    public MetodosDueño(int cantidadDueños) {
        dueños = new Dueño[cantidadDueños];
    }

    /**
     * Leeemos la información que hay guardada en los archivos y la cargamos
     */
    public MetodosDueño() {
        dueños = new Dueño[5];
        setDueños(new Dueño[5 * 5]);
        ArchivoDueño archivodueño = new ArchivoDueño();
        try {
            System.out.println("Leyendo datos....");
            dueños = archivodueño.leerMedios();
            System.out.println("Datos leidos....");
        } catch (ArchivoLecturaNoCreadoException e) {
            System.out.println(e.getMessage());
        }
    }

    /**
     * agrega un dueño al arreglo, verifica que hay espacio disponible para que
     * este sea agregado
     *
     * @param taxi
     * @throws ExcesoTaxiException
     */
    public void agregaDueños(Dueño dueño) throws ExcesoDueñoException {
        if (!lugarDueñosDisponible()) {
            throw new ExcesoDueñoException("Ya no hay espacios disponible para agregar un dueño");
        } else {
            dueños[obtenerCantidadDueños()] = dueño;
        }

    }

    /**
     * Escribe los dueños en un archivo
     */
    public void guardarDueños() {
        ArchivoDueño archivoD = new ArchivoDueño();
        archivoD.escribeDueños(dueños);
    }

    /**
     * ]Calcula los lugares ocupados por dueños
     *
     * @return
     */
    private int obtenerCantidadDueños() {
        int cantidad = 0;
        for (Dueño m : dueños) {
            if (m != null) {
                cantidad++;
            }
        }
        return cantidad;
    }

    /**
     * Verifica que exista lugar para un dueño mas
     *
     * @return
     */
    private boolean lugarDueñosDisponible() {
        return obtenerCantidadDueños() < dueños.length;
    }

    /**
     * Regresa información de los dueños guardados
     *
     * @return String con la información de los taxis
     */
    public String toStringDueños() {
        String todoDueños = "";
        for (int i = 0; i < obtenerCantidadDueños(); i++) {
            todoDueños += dueños[i] + "\n";
        }
        return todoDueños;
    }

    /**
     * Muestra los dueños que existen
     *
     * @return
     * @throws ExcesoTaxiException
     */
    public String listadoDueños() throws ExcesoDueñoException {
        String DueñosString = "";
        int i = 0;
        for (Dueño dueños : this.dueños) {
            if (dueños != null) {
                DueñosString += i + " - Nombre: " + dueños.getNombre() + " Num.Licencia:" + dueños.getNumLicencia() + "\n";
                i++;
            }
        }
        if (DueñosString.equals("")) {
            throw new ExcesoDueñoException("No existen Dueños registrados");
        }
        return DueñosString;
    }

    public Dueño[] getDueños() {
        return dueños;
    }

    public Dueño getDueños(int i) throws ExcesoDueñoException {
        if (i < 0 || i >= this.obtenerCantidadDueños()) {
            throw new ExcesoDueñoException("Dueño seleccionado incorrectamente");
        }
        return this.dueños[i];
    }

    /**
     * Elimina a un dueño del arreglo de taxis
     *
     * @param i indice del dueño a eliminar
     * @throws ExcesoDueñoException
     */
    public void eliminaDueño(int i) throws ExcesoDueñoException, ExcesoTaxiException {
        if (i < 0 || i >= this.obtenerCantidadDueños()) {
            throw new ExcesoDueñoException("Dueño seleccionado incorrectamente");
        }
        Practica1 practica1 = new Practica1();
        Taxis taxis[] = practica1.getTaxis();
        Dueño due = this.dueños[i];
        int k = 0;
        for (Taxis taxi : taxis) {
            if (taxi.getId() == due.getidTaxi()) {
                practica1.eliminaTaxi(k);
            }
            k++;
        }
        this.dueños[i] = null;
        this.recorreDueños(i);
    }

    /**
     * Se encarga de recorrer los dueños en el arreglo para que no haya nulos en
     * dueños
     */
    private void recorreDueños(int i) {

        int indiceUltimoT = this.obtenerCantidadDueños();
        if (i != indiceUltimoT) {
            this.dueños[i] = dueños[indiceUltimoT];
            dueños[indiceUltimoT] = null;
        }
    }

    public void setDueños(Dueño[] dueños) {
        this.dueños = dueños;
    }

    public void verDueños(String[] arr) {
        for (int i = 0; i < arr.length; i++) {
            System.out.println(arr[i]);
        }
    }

    /*
    *imprime los dueños
     */
    public void verDueños() {
        int i = 0;
        for (Dueño dueños : this.dueños) {
            if (dueños != null) {
                System.out.println(i + "  Nombre: " + dueños.getNombre()
                        + "  Num.Licencia: " + dueños.getNumLicencia()
                        + "  Domicilio: " + dueños.getDomicilio() + "  RFC: " + dueños.getRFC()
                        + "  Email: " + dueños.getEmail() + "  Celular " + dueños.getNumCelular()
                        + "  IdTaxi: " + dueños.getidTaxi() + "\n");
                i++;
            }
        }
        if (i == 0) {
            System.out.println("No hay dueños registrados");
        }
    }
}
