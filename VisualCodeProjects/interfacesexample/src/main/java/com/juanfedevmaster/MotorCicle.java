package com.juanfedevmaster;

public class MotorCicle implements IVehicle {
    
    @Override
    public void turnOn() {
        System.out.println("MotorCicle is turning on");
    }

    @Override
    public void turnOff() {
        System.out.println("MotorCicle is turning off");
    }

}
