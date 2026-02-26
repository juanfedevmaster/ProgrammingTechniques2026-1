package com.juanfedevmaster;

public class EBike extends Vehicle implements IVehicle {
    
    public EBike(String license, String brand, String model, String color) {
        super(license, brand, model, color);
    }

    public EBike() {
    }

    @Override
    public void turnOn() {
        System.out.println("EBike is turning on");
    }

    @Override
    public void turnOff() {
        System.out.println("EBike is turning off");
    }

}
