/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package carrera;

import Logica.Logica;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * Clase donde se establecen las variables de los corredores y sus posiciones
 *
 * @author Lisseth Dahianna Martinez Rodriguez
 * @version 1.1.0
 */
public class Corredor extends Thread {
    
    Equipo equipo;
    private String nombre;
    private String equipo1;
    private String equipo2;
    private String equipo3;
    private int posicionInicial;
    private int posicionFinal;
       
    public static final String ANSI_BLUE = "\u001B[34m";
    
    /**
     * Constructor de la clase que establece los siguientes parametros:
     * @param equipo objeto de la clase Equipo que almacena a que equipo pertenece cada corredor
     * @param nombre variable de tipo String que almacena el nombre del corredor
     * @param posicionInicial variable de tipo entero que almacena la posición inicial del corredor
     * @param posicionFinal variable de tipo entero que almacena la posición final del corredor
     */
    
    public Corredor(String nombre, int posicionInicial, int posicionFinal, Equipo equipo) {
        this.equipo = equipo;
        this.nombre = nombre;
        this.posicionInicial = posicionInicial;
        this.posicionFinal = posicionFinal;
    }

    Corredor() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
    @Override
    public void run(){
        if (posicionInicial == 0) {
            cicloCorredorUno();
        } else {
            sincronizadoEspera();
        }
        if (posicionInicial == 33) {
            cicloCorredorDos();
        } else {
            sincronizadoEspera();
        }
        if (posicionInicial == 66) {
            cicloCorredorTres();
        } else {
            sincronizadoEspera();
        }
    }
    
    /**
     * Metodo que realiza el ciclo del hilo del primer corredor de cada equipo
     */
    public void cicloCorredorUno(){
        while (true) {
            int pasoActual = avanzar(1);
            if (pasoActual >= 33) {
                equipo.setPosicionCorredor1(33);
                synchronized (equipo) {
                    equipo.notifyAll();
                    posicionInicial = 33;
                }
                break;
            }
        }
    }
    
    /**
     * Metodo que realiza el ciclo del hilo del segundo corredor de cada equipo
     */
    public void cicloCorredorDos(){
        while (true) {
            int pasoActual = avanzar(2);
            if (pasoActual >= 66) {
                equipo.setPosicionCorredor2(66);
                synchronized (equipo) {
                    equipo.notify();
                }
                break;
            }
        }
    }
    
    /**
     * Metodo que realiza el ciclo del hilo del tercer corredor de cada equipo
     * Finalización de la carrera
     */
    
    public  void cicloCorredorTres(){
        while (true) {
            int pasoActual = avanzar(3);
            if (pasoActual >= 100) {
                equipo.setPosicionCorredor3(100);
                if(equipo.getNombre().equals("EQUIPO1")){
                    equipo.setNombre("EQUIPO1");
                }else if(equipo.getNombre().equals("EQUIPO2")){
                    equipo.setNombre("EQUIPO2");
                }else if(equipo.getNombre().equals("EQUIPO3")){
                    equipo.setNombre("EQUIPO3");
                }
                System.out.println("\nEl "+equipo.getNombre()+" fue el primero en llegar a la meta"+ANSI_BLUE);
                Logica l = new Logica();
                l.mostrarGanador(equipo.getNombre());
                break;
            }
        }
    }
    
    /**
     * Metodo que se encarga de que los hilos esperen su turno
     */
    public void sincronizadoEspera(){
        synchronized (equipo) {
            try {
                equipo.wait();
            } catch (InterruptedException ex) {
                Logger.getLogger(Corredor.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }
    
    /**
     * Metodo que sirve para hacer que cada corredor avance y recibe como parametro el numero del corredor
     * @param numCorredor variable de tipo entero que establece el numero del corredor
     * @return int
     */
    public int avanzar(int numCorredor) {
        try {
            Thread.sleep(300);
        } catch (InterruptedException ex) {
            Logger.getLogger(Corredor.class.getName()).log(Level.SEVERE, null, ex);
        }
        int avance = Aleatorio.random();
        if (numCorredor == 1) {
            equipo.setPosicionCorredor1(equipo.getPosicionCorredor1()+ avance);
            equipoPerteneciente();
            return equipo.getPosicionCorredor1();
        }
        if (numCorredor == 2) {
            equipo.setPosicionCorredor2(equipo.getPosicionCorredor2() + avance);
            equipoPerteneciente();
            return equipo.getPosicionCorredor2();
        }
        if (numCorredor == 3) {
            equipo.setPosicionCorredor3(equipo.getPosicionCorredor3()+ avance);
            equipoPerteneciente();
            return equipo.getPosicionCorredor3();
        }
        return 0;
    }
    
    /**
     * Metodo que no recibe ningún parametro y se encarga de validar a que
     * equipo pertenece el jugador
     */
    public void equipoPerteneciente(){
        if(equipo.mostrarPosicion().contains("EQUIPO1")){
            equipo1=equipo.mostrarPosicion();
            if(equipo1!=null){
                System.out.println(equipo1);
            }
        }else if(equipo.mostrarPosicion().contains("EQUIPO2")){
            equipo2=equipo.mostrarPosicion();
            if(equipo2!=null){
                System.out.println(equipo2);
            }
        }else if(equipo.mostrarPosicion().contains("EQUIPO3")){
            equipo3=equipo.mostrarPosicion();
            if(equipo3!=null){
                System.out.println(equipo3);
            }
        }
    }
}
