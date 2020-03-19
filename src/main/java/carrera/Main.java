/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package carrera;

import Logica.Logica;

/**
 * Clase que ejecuta la logica del programa
 *
 * @author Lisseth Dahianna Martinez Rodriguez
 * @version 1.0.0
 */
public class Main {
    /**
     * Clase Main donde se ejecuta el programa
     * @param args matriz de argumentos de línea de comando pasados ​​a este método
     */
    public static void main(String[] args) {
        Logica l = new Logica();
        l.iniciaCarrera();
    }
}
