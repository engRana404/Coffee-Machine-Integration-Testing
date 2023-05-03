package BottomUpTest;
import static org.junit.Assert.*;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeAll;

import java.io.File;
import java.io.FileNotFoundException;

import java.io.FileReader;
import java.io.IOException;
import java.nio.file.Files;
import java.sql.SQLOutput;
import java.util.ArrayList;

import javax.naming.InvalidNameException;

import java.io.BufferedReader;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

import org.junit.platform.engine.support.descriptor.FileSystemSource;
import src.CoffeeMachine;

public class CoffeeMachineTest {

    private CoffeeMachine coffeeMachine;
    
    @Before
    public void init() {
        coffeeMachine = new CoffeeMachine();
    }

    @Test
    public void testSetIngredient() {
        coffeeMachine.SetIngredient();

        Assertions.assertEquals(500.0, coffeeMachine.getCoffee_powder());
        Assertions.assertEquals(1, coffeeMachine.getMilk());
        Assertions.assertEquals(2, coffeeMachine.getWater());
    }

    @Test
    public void testCleanMachine() {
        coffeeMachine.SetIngredient();

        coffeeMachine.CleanMachine();

        Assertions.assertEquals(0, coffeeMachine.getCoffee_powder());
        Assertions.assertEquals(0, coffeeMachine.getMilk());
        Assertions.assertEquals(0, coffeeMachine.getWater());
    }
    @Test
    public void testBlackCoffee(){
        coffeeMachine.SetIngredient();
        //coffeepowder-10
        //water-0.2
        //count++
        coffeeMachine.BlackCoffee();
        Assertions.assertEquals(490, coffeeMachine.getCoffee_powder());
        Assertions.assertEquals(1, coffeeMachine.getMilk());
        Assertions.assertEquals(1.8, coffeeMachine.getWater());
        Assertions.assertEquals(1, coffeeMachine.getCoffee_Count());

        //testing the else
        coffeeMachine.CleanMachine();

        ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
        System.setOut(new PrintStream(outputStream));

        coffeeMachine.BlackCoffee();
        String actual = outputStream.toString();

        String expected = String.format("\nAvailable Coffee Power(Gram) 0.0%sAvailable Water(Liter) 0.0%s" +
                "\nSome Iteams Are Not Available, Please Fill before Making Coffee.%s",
                System.lineSeparator(), System.lineSeparator(), System.lineSeparator());

        Assert.assertEquals(expected,actual);

    }
    @Test
    public void testMilkCoffee(){
        coffeeMachine.SetIngredient();
        //coffeepowder-10
        //water-0.2
        //milk-0.4
        //count++
        coffeeMachine.MilkCoffee();
        Assertions.assertEquals(490, coffeeMachine.getCoffee_powder());
        Assertions.assertEquals(0.6, coffeeMachine.getMilk());
        Assertions.assertEquals(1.8, coffeeMachine.getWater());
        Assertions.assertEquals(1, coffeeMachine.getCoffee_Count());
        //testing the else
        coffeeMachine.CleanMachine();

        ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
        System.setOut(new PrintStream(outputStream));

        coffeeMachine.BlackCoffee();
        String actual = outputStream.toString();

        String expected = String.format("\nAvailable Coffee Power(Gram) 0.0%sAvailable Water(Liter) 0.0%s" +
                        "\nSome Iteams Are Not Available, Please Fill before Making Coffee.%s",
                System.lineSeparator(), System.lineSeparator(), System.lineSeparator());

        Assert.assertEquals(expected,actual);
    }
    @Test
    public void testStart(){
        //User choose first option
        String userInput = String.format("1", System.lineSeparator());
        ByteArrayInputStream inputStream = new ByteArrayInputStream(userInput.getBytes());
        System.setIn(inputStream);


        ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
        System.setOut(new PrintStream(outputStream));

        coffeeMachine.start();

        //checks the output stream after calling the start funciton
        String[] lines = outputStream.toString().split(System.lineSeparator());
        String actual = String.join("", lines);
        String expected = String.format(" ----------------------------------------------------------------|                   Coffee Machine By Manikant                   |" +
                " ----------------------------------------------------------------\nCurrent Status: " +
                "Available Coffee Power(Gram) 0.0Available Milk(Liter) 0.0Available Water(Liter) 0.0" +
                "\n -------------------------------- |1:     Status of Ingredient     |\n -------------------------------- \n|2:      Fill Ingredient         |\n -------------------------------- \n|3:       Clean Machine          |\n -------------------------------- \n|4:        Make Coffee           |\n -------------------------------- \n|5: How many Coffee We have made?|\n -------------------------------- \n|6:        Exit                  |" +
                " -------------------------------- \n\n");
        Assert.assertEquals(expected,actual);




        //checks the output after the user choose the first option
        System.setOut(new PrintStream(outputStream));
        lines = outputStream.toString().split(System.lineSeparator());
        actual = String.join("", lines);
        expected = String.format("------------- Status ------------Available Coffee Power(Gram) 0.0Available Water(Liter) 0.0---------------------------------");
        Assert.assertEquals(expected,actual);



    }

}
