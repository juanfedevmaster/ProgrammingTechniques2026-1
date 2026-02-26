package com.juanfedevmaster;

/**
 * Clase principal que demuestra el uso de interfaces y polimorfismo
 * con diferentes tipos de vehículos
 */
public class Main {
    public static void main(String[] args) {
        // Crear array de vehículos usando polimorfismo
        IVehicle[] vehicles = {
            new EBike(),
            new Car(),
            new MotorCicle(),
            new Ship()
        };

        // Encender todos los vehículos
        System.out.println("=== Encendiendo vehículos ===");
        for (IVehicle vehicle : vehicles) {
            vehicle.turnOn();
        }

        System.out.println(); // Línea en blanco para separar

        // Apagar todos los vehículos
        System.out.println("=== Apagando vehículos ===");
        for (IVehicle vehicle : vehicles) {
            vehicle.turnOff();
        }
    }
}