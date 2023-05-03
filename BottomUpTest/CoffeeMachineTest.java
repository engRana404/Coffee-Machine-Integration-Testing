package BottomUpTest;
import static org.junit.Assert.*;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeAll;

import java.io.File;
import java.io.FileNotFoundException;

import java.io.FileReader;
import java.io.IOException;
import java.nio.file.Files;
import java.util.ArrayList;

import javax.naming.InvalidNameException;

import java.io.BufferedReader;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

import src.CoffeeMachine;

public class CoffeeMachineTest {

    private CoffeeMachine coffeeMachine;
    
    @Before
    public void init() {
        coffeeMachine = new CoffeeMachine();
    }

    @Before
    @Test
    public void testSetIngredient() {
        coffeeMachine.SetIngredient();

        Assertions.assertEquals(500.0, coffeeMachine.getCoffee_powder());
        Assertions.assertEquals(1, coffeeMachine.getMilk());
        Assertions.assertEquals(2, coffeeMachine.getWater());
    }

    @Test
    public void testCleanMachine() {
        coffeeMachine.CleanMachine();

        Assertions.assertEquals(0, coffeeMachine.getCoffee_powder());
        Assertions.assertEquals(0, coffeeMachine.getMilk());
        Assertions.assertEquals(0, coffeeMachine.getWater());
    }

}
