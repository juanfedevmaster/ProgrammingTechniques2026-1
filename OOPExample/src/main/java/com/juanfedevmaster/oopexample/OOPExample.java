/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */

package com.juanfedevmaster.oopexample;

import javax.swing.JOptionPane;

/**
 *
 * @author jufeq
 */
public class OOPExample {
    public static void main(String args[]){
        Figure triangle = new Triangle(10, 10, 0, 0);
        System.out.println(triangle.areaCalculate());
    }
}
