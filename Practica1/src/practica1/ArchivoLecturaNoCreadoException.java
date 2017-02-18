/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package practica1;

/**
 * ArchivoLecturaNoCreadoException Clase que implementa a una escepcion para
 * cuando un archivo para leer no sea encontrado
 *
 * @author Eduardo Castro
 * @version Noviembre 2016
 */
public class ArchivoLecturaNoCreadoException extends Exception {

    public ArchivoLecturaNoCreadoException(String message) {
        super(message);
    }
}
