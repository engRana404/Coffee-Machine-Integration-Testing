package src;

import java.util.Scanner;

public class MakeCoffee {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        System.out.println("\nWants to Start Mechine Y or N ?");
        char d;
        d = scan.next().charAt(0);
        if (d == 'Y' || d == 'y') {
            CoffeeMachine cm = new CoffeeMachine(); // Instances For CoffeMachine
            cm.start(); // In order to call All Private Method Calling Public mathod
            System.out.println("Shutting Down...\n");
        } else
            System.out.println("Shutting Down...\n");
    }
}
