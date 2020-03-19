/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package carrera;

import java.util.Date;

/**
 * Clase que establece las variables del equipo y donde se muestra en consola la posición de los corredores
 *
 * @author Lisseth Dahianna Martinez Rodriguez
 * @version 1.1.0
 */
public class Equipo {
    
    private String nombre;
    private int posicion;
    private int posicionCorredor1;
    private int posicionCorredor2;
    private int posicionCorredor3;
    private Date fin;
    
    
    /**
     * Constructor de la clase Equipo
     * @param nombre variable que establece el nombre del equipo
     */
    public Equipo(String nombre) {
        
        this.nombre = nombre;
        this.posicionCorredor1 = 0;
        this.posicionCorredor2 = 33;
        this.posicionCorredor3 = 66;
        fin = null;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public int getPosicionCorredor1() {
        return posicionCorredor1;
    }

    public void setPosicionCorredor1(int posicionCorredor1) {
        this.posicionCorredor1 = posicionCorredor1;
    }

    public int getPosicionCorredor2() {
        return posicionCorredor2;
    }

    public void setPosicionCorredor2(int posicionCorredor2) {
        this.posicionCorredor2 = posicionCorredor2;
    }

    public int getPosicionCorredor3() {
        return posicionCorredor3;
    }

    public void setPosicionCorredor3(int posicionCorredor3) {
        this.posicionCorredor3 = posicionCorredor3;
    }

    public int getPosicion() {
        return posicion;
    }

    public void setPosicion(int posicion) {
        this.posicion = posicion;
    }

    public Date getFin() {
        return fin;
    }

    public void setFin(Date fin) {
        this.fin = fin;
    }
    
    /**
     * Clase encargada de mostrar en consola la posición de los corredores de cada equipo
     * @return void
     */
    public synchronized String mostrarPosicion(){
        
        String posicion = "";
        posicion = nombre + " ";
        
        for (int i = 0; i <= 100; i++) {
            if (i == posicionCorredor1) {
                posicion += "X";
            } else if (i == posicionCorredor2) {
                posicion += "O";
            } else if (i == posicionCorredor3) {
                posicion += "¬";
            } else {
                posicion += ".";
            }
        } 
        return posicion;
    }
    
}
