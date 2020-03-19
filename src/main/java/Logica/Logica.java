/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Logica;

import carrera.Equipo;
import carrera.Corredor;

/**
 * Clase logica donde se inicializan los hilos
 *
 * @author Lisseth Dahianna Martinez Rodriguez
 * @version 1.1.0
 */
public class Logica {
    
    public static final String ANSI_RED = "\u001B[31m";
    
    Equipo e1 = new Equipo("EQUIPO1");
    Equipo e2 = new Equipo("EQUIPO2");
    Equipo e3 = new Equipo("EQUIPO3");
    
    Corredor c1 = new Corredor("Corredor1", 0, 33, e1);
    Corredor c2 = new Corredor("Corredor2", 33, 66, e1);
    Corredor c3 = new Corredor("Corredor3", 66, 100, e1);
    Corredor c4 = new Corredor("Corredor4", 0, 33, e2);
    Corredor c5 = new Corredor("Corredor5", 33, 66, e2);
    Corredor c6 = new Corredor("Corredor6", 66, 100, e2);
    Corredor c7 = new Corredor("Corredor7", 0, 33, e3);
    Corredor c8 = new Corredor("Corredor8", 33, 66, e3);
    Corredor c9 = new Corredor("Corredor9", 66, 100, e3);
    
    /**
     * Metodo que inicializa los hilos de los corredores
     */
    public void iniciaCarrera(){
        
        c1.start();
        c2.start();
        c3.start();
        c4.start();
        c5.start();
        c6.start();
        c7.start();
        c8.start();
        c9.start();
    }
    
    /**
     * Metodo que muestra en consola el equipo ganador
     * @param equipo variable que captura el nombre del equipo ganador
     */
    public void mostrarGanador(String equipo){
        System.out.println(ANSI_RED +"GANADOR: "+equipo);
        System.exit(0);
    }
    
}
