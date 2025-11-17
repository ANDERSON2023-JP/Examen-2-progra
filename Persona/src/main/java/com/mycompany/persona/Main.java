/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.persona;

/**
 *
 * @author LUIS
 */
public class Main {

    public static void main(String[] args) {

        MiTeleferico mt = new MiTeleferico();

        // Crear cabinas
        mt.agregarCabina("Amarilla");
        mt.agregarCabina("Roja");

        // Personas
        Persona p1 = new Persona("Luis", 20, 60);
        Persona p2 = new Persona("Ana", 30, 55);
        Persona p3 = new Persona("Mario", 70, 70);

        // Agregar personas a cabinas
        mt.agregarPrimeraPersona(1, p1);
        mt.agregarPrimeraPersona(1, p2);
        mt.agregarPrimeraPersona(2, p3);

        // Verificar reglas
        mt.verificarReglasAbordo();

        // Calcular ingreso total
        float total = mt.calcularIngreso();
        System.out.println("Ingreso total: " + total);

        // Mostrar línea con más ingreso regular
        mt.mostrarLineaMasIngreso();
    }
}
