/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */

package com.juanfedevmaster.firstproject;

import com.juanfedevmaster.firstproject.model.Persona;
import java.util.Scanner;

/**
 *
 * @author jufeq
 */
public class FirstProject {

    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        
        System.out.println("Ingrese su nombre:");
        String nombre = scan.nextLine();
        
        System.out.println("Ingrese su apellido:");
        String apellido = scan.nextLine();
        
        System.out.println("Ingrese su cedula:");
        String cedula = scan.nextLine();
        
        Persona persona = new Persona(nombre, apellido, cedula);

        System.out.println("Nombre de la persona: "+persona.getName()+ " " +persona.getLastName());
                   
    }
}
