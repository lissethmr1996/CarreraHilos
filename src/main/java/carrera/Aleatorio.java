/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package carrera;

/**
 * Clase que genera un numero aleatorio entre 1 y 3
 *
 * @author Lisseth Dahianna Martinez Rodriguez
 * @version 1.0.0
 */
public class Aleatorio {
    /**
     * Metodo para generar un numero aleatorio
     */
    public static int random(){
        int numero = (int) (Math.random() * 3) + 1;
        return numero;
    }
}
