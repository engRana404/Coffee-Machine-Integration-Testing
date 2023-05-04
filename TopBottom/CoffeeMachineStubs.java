package TopBottom;

import java.util.Scanner;

public class CoffeeMachineStubs {


    private Scanner scan = new Scanner(System.in);
    private double coffee_powder, milk, water;
    private int Coffee_Count = 0;

    public void CoffeeMachineStub() {
        this.coffee_powder = 0;
        this.milk = 0;
        this.water = 0;
    }

    public void SetIngredientStub() {
        System.out.println("\nFilling...");
        this.coffee_powder = 500.0;
        this.milk = 1;
        this.water = 2;
        System.out.println("Filling Completed.");
    }

    public void GetIngredientStub() {
        System.out.println("Available Coffee Power(Gram) " + String.format("%.1f", this.coffee_powder));
        System.out.println("Available Milk(Liter) " + String.format("%.1f", this.milk));
        System.out.println("Available Water(Liter) " + String.format("%.1f", this.water));
    }

    public void CleanMachineStub() {
        System.out.println("\nCleaning Machine...");
        this.coffee_powder = 0;
        this.milk = 0;
        this.water = 0;
        System.out.println("Cleaning Completed.");
    }

    public double getCoffee_powder() {
        return coffee_powder;
    }

    public void setCoffee_powder(double coffee_powder) {
        this.coffee_powder = coffee_powder;
    }

    public double getMilk() {
        return milk;
    }

    public void setMilk(double milk) {
        this.milk = milk;
    }

    public double getWater() {
        return water;
    }

    public void setWater(double water) {
        this.water = water;
    }

    public int getCoffee_Count() {
        return Coffee_Count;
    }

    public void setCoffee_Count(int coffee_Count) {
        Coffee_Count = coffee_Count;
    }

    public void makecoffeeStub() {
        System.out.println("\n ------------------ ");
        System.out.println("|   Select Type:   |\n ------------------ \n| 1:  Black Coffee |\n| 2:  Milk Coffee  |\n| 0   to Discard   |");
        System.out.println(" ------------------ \n");
        char t = scan.next().charAt(0);
        switch (t) {
            case '1':
                this.BlackCoffeeStub();
                break;
            case '2':
                this.MilkCoffeeStub();
                break;
            case '0':
                break;
        }
    }

    public void BlackCoffeeStub() {
        if (this.coffee_powder >= 10 && this.water >= 0.2) {
            System.out.println("\nMaking Black Coffee...");
            System.out.println("\nTaking 10gm of Coffee Powder.");
            this.coffee_powder = 490;
            System.out.println("Taking 0.2 liter of Water.");
            this.water = 1.8;
            System.out.println("\nYour Black Coffee is Ready.");
            this.Coffee_Count++;
        } else {
            System.out.println("\nAvailable Coffee Power(Gram) " + String.format("%.1f", this.coffee_powder));
            System.out.println("Available Water(Liter) " + String.format("%.1f", this.water));
            System.out.println("\nSome Items Are Not Available, Please Fill before Making Coffee.");
        }
    }

    public void MilkCoffeeStub() {
        if (this.coffee_powder >= 10 && this.milk >= 0.4 && this.water >= 0.2) {
            System.out.println("\nMaking Milk Coffee...");
            System.out.println("\nTaking 10gm of Coffee Powder.");
            this.coffee_powder = 490;
            System.out.println("Taking 0.4 Liter of Milk.");
            this.milk = 0.6;
            System.out.println("Taking 0.2 liter of Water.");
            this.water = 1.8;
            System.out.println("\nYour Milk Coffee is Ready.");
            this.Coffee_Count++;
        } else {
            System.out.println("\nAvailable Coffee Power(Gram) " + String.format("%.1f", this.coffee_powder));
            System.out.println("Available Milk(Liter) " + String.format("%.1f", this.milk));
            System.out.println("Available Water(Liter) " + String.format("%.1f", this.water));
            System.out.println("\nSome Items Are Not Available, Please Fill before Making Coffee.");
        }
    }

    public void start() {
        System.out.println(" ----------------------------------------------------------------");
        System.out.println("|                   Coffee Machine By Manikant                   |");
        System.out.println(" ----------------------------------------------------------------");
        System.out.println("\nCurrent Status: ");
        this.GetIngredientStub();
        boolean t = true;
        while (t) {
            System.out.println("\n -------------------------------- ");
            System.out.println("|1:     Status of Ingredient     |" +
                    "\n -------------------------------- " +
                    "\n|2:      Fill Ingredient         |" +
                    "\n -------------------------------- " +
                    "\n|3:       Clean Machine          |" +
                    "\n -------------------------------- " +
                    "\n|4:        Make Coffee           |" +
                    "\n -------------------------------- " +
                    "\n|5: How many Coffee We have made?|" +
                    "\n -------------------------------- " +
                    "\n|6:        Exit                  |");
            System.out.println(" -------------------------------- \n\n");
            char c = scan.next().charAt(0);
            switch (c) {
                case '1':
                    System.out.println("------------- Status ------------");
                    this.GetIngredientStub();
                    System.out.println("---------------------------------");
                    break;
                case '2':
                    this.SetIngredientStub();
                    break;
                case '3':
                    this.CleanMachineStub();
                    break;
                case '4':
                    this.makecoffeeStub();
                    break;
                case '5':
                    System.out.println("\nWe Have Made " + this.Coffee_Count + " Coffees.");
                    break;
                case '6':
                    System.out.println("\nExiting...\n");
                    t = false;
                    break;
            }
            break;
        }
    }


}
