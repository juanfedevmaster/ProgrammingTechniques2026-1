package com.juanfedevmaster;

public class Ship implements IVehicle {
    
    @Override
    public void turnOn() {
        System.out.println("Ship is turning on");
    }

    @Override
    public void turnOff() {
        System.out.println("Ship is turning off");
    }
}
