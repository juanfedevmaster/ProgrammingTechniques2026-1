/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.juanfedevmaster.oopexample;

/**
 *
 * @author jufeq
 */
public class Triangle extends Figure {
    
    private double base;
    private double altura;
    private double hipotenusa;
    
    public Triangle() {
        super();
    }

    public Triangle(double base, double altura, double area, double perimeter) {
        super(area, perimeter);
        this.base = base;
        this.altura = altura;
        this.hipotenusa = CalcularHipotenusa();
    }

    public double getBase() {
        return base;
    }

    public void setBase(double base) {
        this.base = base;
    }

    public double getAltura() {
        return altura;
    }

    public void setAltura(double altura) {
        this.altura = altura;
    }

    public double getHipotenusa() {
        return hipotenusa;
    }

    public void setHipotenusa(double hipotenusa) {
        this.hipotenusa = hipotenusa;
    }

    @Override
    public double areaCalculate() {
        double areaCalculada = (this.base * this.altura)/2;
        this.setArea(areaCalculada);
        return this.getArea();
    }
    
    private double CalcularHipotenusa(){
        return Math.sqrt(Math.pow(base, 2) + Math.pow(altura, 2));    
    }    
}
