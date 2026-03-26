package com.juafedevmaster;

import java.util.ArrayList;

import com.juafedevmaster.exception.ClientException;
import com.juafedevmaster.model.Client;

public class Main {
    public static void main(String[] args) {
        // 1. First Example
        try {
            var x = 100 / 0;
            var list = new ArrayList<Integer>();
            list.get(10);
        } catch (ArithmeticException e) {
            System.out.println("Error: " + e.getMessage());
        } catch (IndexOutOfBoundsException e) {
            System.out.println("Error: " + e.getMessage());
        } catch (Exception e) {
            System.out.println("Error: " + e.getMessage());
        }

        // 2. Continue with the application.
        System.out.println("Application continues...");

        var client1 = new com.juafedevmaster.model.Client("John Doe", "john.doe@example.com", "12345g");
        var client2 = new com.juafedevmaster.model.Client("Jane Smith", "jane.smith.com", "67890");

        var clients = new ArrayList<com.juafedevmaster.model.Client>();
        clients.add(client1);
        clients.add(client2);

        try {

            for (var client : clients) {
                if (!client.getEmail().contains("@")) {
                    throw new ClientException("Invalid email for client: " + client.getName());
                }
                System.out.println("Client Name: " + client.getName());
                System.out.println("Client Email: " + client.getEmail());
            }
        } catch (Exception e) {
            System.out.println("Error: " + e.getMessage());
        }

        // 3. Continue with the application.
        System.out.println("Application continues...");

        try {
            for (Client clientIterable : clients) {
                int id = Integer.parseInt(clientIterable.getId());
                System.out.println("Id for the client " + clientIterable.getName() + " is: " + id);
            }
        } catch (Exception e) {
            // System.out.println("Error: " + e.getMessage());
            // e.printStackTrace();
            throw new NumberFormatException("Error on the id conversion. Error of the system is: " + e.getMessage());
        }
    }
}