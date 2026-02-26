package com.juanfedevmaster;

public class Car implements IVehicle {
    
    @Override
    public void turnOn() {
        System.out.println("Car is turning on");
    }

    @Override
    public void turnOff() {
        System.out.println("Car is turning off");
    }

}
