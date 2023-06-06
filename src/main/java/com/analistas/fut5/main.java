/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.analistas.fut5;

import java.util.ArrayList;
import java.util.List;

public class main {

    public static void main(String[] args) {
        // Crear Jugadores
        Jugador Jugador1 = new Jugador(1, "Lionel", "Messi", 170, "Delantero");
        Jugador Jugador2 = new Jugador(2, "Cristiano", "Ronaldo", 187, "Delantero");
        
        // Crear entrenador
        Entrenador entrenador = new Entrenador("Pep", "Guardiola", 50);
        
        // Crear equipo
        Equipo equipo = new Equipo("Equipo A", "2022-01-01");
        
        // Asignar Jugadores y entrenador al equipo
        List<Jugador> Jugadores = new ArrayList<>();
        Jugadores.add(Jugador1);
        Jugadores.add(Jugador2);
        equipo.setJugadores(Jugadores);
        equipo.setEntrenador(entrenador);
        
        // Mostrar información del equipo
        System.out.println("Equipo: " + equipo.getNombre());
        System.out.println("Fecha de creación: " + equipo.getFechaCreacion());
        
        System.out.println("Jugadores:");
        for (Jugador Jugador : equipo.getJugadores()) {
            System.out.println(Jugador.getNombre() + " " + Jugador.getApellido());
        }
        
        System.out.println("Entrenador: " + equipo.getEntrenador().getNombre() + " " + equipo.getEntrenador().getApellido());
    }
}

//