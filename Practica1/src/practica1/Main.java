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
                            System.out.println("Ya no hay lugar disponible para un nuevo médico.");
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
                        System.out.println("Elije el número del médico que deseas editar");
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

                        System.out.println("Elije el número del médico que deseas borrar");
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
}
