/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package practica1;

import java.util.InputMismatchException;
import java.util.Scanner;

/**
 *
 * @author Luis Rafael Rivera S
 */
public class Main {

    public static void main(String[] args) throws ArchivoLecturaNoCreadoException {
        
         boolean bandera;
        int opcion = 0;
        Scanner input = new Scanner(System.in);
        Practica1 practica1 = new Practica1();
        do {
            bandera = true;
            System.out.println("Ingresa la opción deseada\n" + "1-Taxis\n" + "2-Choferes\n"
                    + "3-Dueños\n" + "4-Salir\n");
            try {
                opcion = input.nextInt();
            } catch (InputMismatchException e) {
                input.next();
                System.out.println("Ingresa un número como opción");
            }
            if (opcion > 0 && opcion < 6) {
                switch (opcion) {
                    case 1:
                        menuTaxi();
                        break;
                    case 2:
                        menuChofer();
                        break;
                    case 3:
                        menuDueño();
                    case 4:
                        System.out.println("Guardando datos....");
                        practica1.guardarTaxis();
                        bandera = false;
                        System.out.println("Datos guardados");
                        System.out.println("Saliendo del sistema...\nHasta pronto.");
                        break;
                    default:
                        break;
                }
            }
        } while (bandera);    
    }
    
    public static void menuTaxi(){
         boolean bandera;
        int opcion = 0;
        Scanner input = new Scanner(System.in);
        Practica1 practica1 = new Practica1();
        do {
            bandera = true;
            System.out.println("Ingresa la opción deseada\n" + "1-Agregar Taxis\n" + "2-Ver taxis\n"
                    + "3-Editar taxi\n" + "4-Borrar taxi\n" + "5-Salir\n");
            try {
                opcion = input.nextInt();
            } catch (InputMismatchException e) {
                input.next();
                System.out.println("Ingresa un número como opción");
            }
            if (opcion > 0 && opcion < 6) {
                switch (opcion) {
                    case 1:
                        try {
                            Taxis taxi = new Taxis();
                            practica1.agregaTaxis(taxi);
                            System.out.println("Taxis guardado correctamente.");
                        } catch (ExcesoTaxiException e) {
                            System.out.println("Ya no hay lugar disponible para un nuevo taxi.");
                        }
                        break;
                    case 2:
//                        String nombreArchivo = "";
//                        ManipulaArchivo man = new ManipulaArchivo(nombreArchivo);
//                        practica1.verTaxis(man.leeArchivo());
                        System.out.println("error");
                        System.exit(0);
                        break;
                    case 3:
                        System.out.println("Elije el número del taxi que deseas editar");
                        bandera = true;
                        do {
                            try {
                                System.out.println(practica1.listadoTaxis());
                                opcion = input.nextInt();
                                practica1.getTaxis(opcion).edita();
                                bandera = false;
                                System.out.println("Taxis editado correctamente");
                            } catch (ExcesoTaxiException e) {
                                System.out.println(e.getMessage());
                                bandera = false;
                            } catch (InputMismatchException i) {
                                System.out.println("Ingresa un número como opción");
                                input.next();
                                bandera = true;
                            }
                        } while (bandera);
                        bandera = true;

                        break;
                    case 4:

                        System.out.println("Elije el número del taxi que deseas borrar");
                        bandera = true;
                        do {
                            try {
                                System.out.println(practica1.listadoTaxis());
                                opcion = input.nextInt();
                                practica1.eliminaTaxi(opcion);
                                bandera = false;
                            } catch (ExcesoTaxiException e) {
                                System.out.println(e.getMessage());
                                bandera = false;
                            } catch (InputMismatchException i) {
                                System.out.println("Ingresa un número como opción");
                                input.next();
                                bandera = true;
                            }
                        } while (bandera);
                        bandera = true;
                        break;
                    case 5:
                        System.out.println("Guardando datos de taxis....");
                        practica1.guardarTaxis();
                        bandera = false;
                        System.out.println("Datos guardados");
                        System.out.println("Saliendo del sistema...\nHasta pronto.");
                        break;
                    default:
                        break;
                }
            }
        } while (bandera);    
    }
    
    public static void menuChofer(){
        boolean bandera;
        int opcion = 0;
        Scanner input = new Scanner(System.in);
        MetodosChoferes chofer = new MetodosChoferes();
        do {
            bandera = true;
            System.out.println("Ingresa la opción deseada\n" + "1-Agregar Chofer\n" + "2-Ver choferes\n"
                    + "3-Editar chofer\n" + "4-Borrar chofer\n" + "5-Salir\n");
            try {
                opcion = input.nextInt();
            } catch (InputMismatchException e) {
                input.next();
                System.out.println("Ingresa un número como opción");
            }
            if (opcion > 0 && opcion < 6) {
                switch (opcion) {
                    case 1:
                        try {
                            Chofer chofer1 = new Chofer();
                            chofer.agregaChofer(chofer1);
                            System.out.println("Choferes guardado correctamente.");
                        } catch (ExcesoTaxiException e) {
                            System.out.println("Ya no hay lugar disponible para un nuevo chofer.");
                        }
                        break;
                    case 2:
//                        String nombreArchivo = "";
//                        ManipulaArchivo man = new ManipulaArchivo(nombreArchivo);
//                        practica1.verTaxis(man.leeArchivo());
                        System.out.println("Error");
                        System.exit(0);
                        break;
                    case 3:
                        System.out.println("Elije el número del chofer que deseas editar");
                        bandera = true;
                        do {
                            try {
                                System.out.println(chofer.listadoChoferes());
                                opcion = input.nextInt();
                                chofer.getChoferes(opcion).edita();
                                bandera = false;
                                System.out.println("Choferes editado correctamente");
                            } catch (ExcesoTaxiException e) {
                                System.out.println(e.getMessage());
                                bandera = false;
                            } catch (InputMismatchException i) {
                                System.out.println("Ingresa un número como opción");
                                input.next();
                                bandera = true;
                            }
                        } while (bandera);
                        bandera = true;

                        break;
                    case 4:

                        System.out.println("Elije el número del chofer que deseas borrar");
                        bandera = true;
                        do {
                            try {
                                System.out.println(chofer.listadoChoferes());
                                opcion = input.nextInt();
                                chofer.eliminaChofer(opcion);
                                bandera = false;
                            } catch (ExcesoTaxiException e) {
                                System.out.println(e.getMessage());
                                bandera = false;
                            } catch (InputMismatchException i) {
                                System.out.println("Ingresa un número como opción");
                                input.next();
                                bandera = true;
                            }
                        } while (bandera);
                        bandera = true;
                        break;
                    case 5:
                        System.out.println("Guardando datos de taxis....");
                        chofer.guardarChoferes();
                        bandera = false;
                        System.out.println("Datos guardados");
                        System.out.println("Saliendo del sistema...\nHasta pronto.");
                        break;
                    default:
                        break;
                }
            }
        } while (bandera);    
    }
    
     public static void menuDueño(){
         boolean bandera;
        int opcion = 0;
        Scanner input = new Scanner(System.in);
        MetodosDueño metodosdueño = new MetodosDueño();
        do {
            bandera = true;
            System.out.println("Ingresa la opción deseada\n" + "1-Agregar Dueño\n" + "2-Ver Dueño\n"
                    + "3-Editar Dueño\n" + "4-Borrar Dueño\n" + "5-Salir\n");
            try {
                opcion = input.nextInt();
            } catch (InputMismatchException e) {
                input.next();
                System.out.println("Ingresa un número como opción");
            }
            if (opcion > 0 && opcion < 6) {
                switch (opcion) {
                    case 1:
                        try {
                            Dueño dueño = new Dueño();
                            metodosdueño.agregaDueños(dueño);
                            System.out.println("Dueño guardado correctamente.");
                        } catch (ExcesoDueñoException e) {
                            System.out.println("Ya no hay lugar disponible para un nuevo dueño.");
                        }
                        break;
                    case 2:
//                        String nombreArchivo = "";
//                        ManipulaArchivo man = new ManipulaArchivo(nombreArchivo);
//                        practica1.verTaxis(man.leeArchivo());
                        System.out.println("error");
                        System.exit(0);
                        break;
                    case 3:
                        System.out.println("Elije el número del dueño que deseas editar");
                        bandera = true;
                        do {
                            try {
                                System.out.println(metodosdueño.listadoDueños());
                                opcion = input.nextInt();
                                metodosdueño.getDueños(opcion).edita();
                                bandera = false;
                                System.out.println("Dueño editado correctamente");
                            } catch (ExcesoDueñoException e) {
                                System.out.println(e.getMessage());
                                bandera = false;
                            } catch (InputMismatchException i) {
                                System.out.println("Ingresa un número como opción");
                                input.next();
                                bandera = true;
                            }
                        } while (bandera);
                        bandera = true;

                        break;
                    case 4:

                        System.out.println("Elije el número del dueño que deseas borrar");
                        bandera = true;
                        do {
                            try {
                                System.out.println(metodosdueño.listadoDueños());
                                opcion = input.nextInt();
                                metodosdueño.eliminaDueño(opcion);
                                bandera = false;
                            } catch (ExcesoDueñoException e) {
                                System.out.println(e.getMessage());
                                bandera = false;
                            } catch (InputMismatchException i) {
                                System.out.println("Ingresa un número como opción");
                                input.next();
                                bandera = true;
                            }
                        } while (bandera);
                        bandera = true;
                        break;
                    case 5:
                        System.out.println("Guardando datos de dueños....");
                        metodosdueño.guardarDueños();
                        bandera = false;
                        System.out.println("Datos guardados");
                        System.out.println("Saliendo del sistema...\nHasta pronto.");
                        break;
                    default:
                        break;
                }
            }
        } while (bandera);    
    }
}
