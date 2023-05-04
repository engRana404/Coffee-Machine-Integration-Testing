package TopBottom;

import org.junit.jupiter.api.Test;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

import static org.junit.jupiter.api.Assertions.assertEquals;


class CoffeeTestTopDown {

    // 1: Status of Ingredient Test
    @Test
    void testStart1Status() {
        String userInput = String.format("1",
                System.lineSeparator(),
                System.lineSeparator());
        ByteArrayInputStream bais = new ByteArrayInputStream(userInput.getBytes());
        System.setIn(bais);

        String expected = " ----------------------------------------------------------------"
                + "\n|                   Coffee Machine By Manikant                   |"
                + "\n ----------------------------------------------------------------\n"
                + "\nCurrent Status: "
                + "\nAvailable Coffee Power(Gram) 0.0"
                + "\nAvailable Milk(Liter) 0.0"
                + "\nAvailable Water(Liter) 0.0\n"
                + "\n -------------------------------- "
                + "\n|1:     Status of Ingredient     |"
                + "\n -------------------------------- "
                + "\n|2:      Fill Ingredient         |"
                + "\n -------------------------------- "
                + "\n|3:       Clean Machine          |"
                + "\n -------------------------------- "
                + "\n|4:        Make Coffee           |"
                + "\n -------------------------------- "
                + "\n|5: How many Coffee We have made?|"
                + "\n -------------------------------- "
                + "\n|6:        Exit                  |"
                + "\n -------------------------------- "
                + "\n\n"
                + "\n------------- Status ------------"
                + "\nAvailable Coffee Power(Gram) 0.0"
                + "\nAvailable Milk(Liter) 0.0"
                + "\nAvailable Water(Liter) 0.0"
                + "\n---------------------------------\n";

        ByteArrayOutputStream baos = new ByteArrayOutputStream();
        PrintStream printStream = new PrintStream(baos);
        System.setOut(printStream);
        CoffeeMachineStubs ch = new CoffeeMachineStubs(); // call the main method
        ch.start();
        String[] lines = baos.toString().split(System.lineSeparator());
        String data = "";
        for (String e : lines) {
            if (e != "\n")
                data += (e + "\n");
        }
        String actual = data;

        // checkout output
        assertEquals(expected, actual);
    }

    // 2: Testing SetIngredient function
    @Test
    void testStart2Fill() {
        String userInput = String.format("2",
                System.lineSeparator(),
                System.lineSeparator());
        ByteArrayInputStream bais = new ByteArrayInputStream(userInput.getBytes());
        System.setIn(bais);

        String expected = " ----------------------------------------------------------------"
                + "\n|                   Coffee Machine By Manikant                   |"
                + "\n ----------------------------------------------------------------\n"
                + "\nCurrent Status: "
                + "\nAvailable Coffee Power(Gram) 0.0"
                + "\nAvailable Milk(Liter) 0.0"
                + "\nAvailable Water(Liter) 0.0\n"
                + "\n -------------------------------- "
                + "\n|1:     Status of Ingredient     |"
                + "\n -------------------------------- "
                + "\n|2:      Fill Ingredient         |"
                + "\n -------------------------------- "
                + "\n|3:       Clean Machine          |"
                + "\n -------------------------------- "
                + "\n|4:        Make Coffee           |"
                + "\n -------------------------------- "
                + "\n|5: How many Coffee We have made?|"
                + "\n -------------------------------- "
                + "\n|6:        Exit                  |"
                + "\n -------------------------------- "
                + "\n\n"
                + "\n\nFilling...\nFilling Completed.\n";

        ByteArrayOutputStream baos = new ByteArrayOutputStream();
        PrintStream printStream = new PrintStream(baos);
        System.setOut(printStream);
        CoffeeMachineStubs ch = new CoffeeMachineStubs(); // call the main method
        ch.start();
        String[] lines = baos.toString().split(System.lineSeparator());
        String data = "";
        for (String e : lines) {
            data += (e + "\n");
        }
        String actual = data;

        // checkout output
        assertEquals(expected, actual);
        assertEquals(500, ch.getCoffee_powder());
        assertEquals(1, ch.getMilk());
        assertEquals(2, ch.getWater());
    }

    // 3: Testing CleanMachine function
    @Test
    void testStart3Clean() {
        String userInput = String.format("3",
                System.lineSeparator(),
                System.lineSeparator());
        ByteArrayInputStream bais = new ByteArrayInputStream(userInput.getBytes());
        System.setIn(bais);

        String expected = " ----------------------------------------------------------------"
                + "\n|                   Coffee Machine By Manikant                   |"
                + "\n ----------------------------------------------------------------\n"
                + "\nCurrent Status: "
                + "\nAvailable Coffee Power(Gram) 0.0"
                + "\nAvailable Milk(Liter) 0.0"
                + "\nAvailable Water(Liter) 0.0\n"
                + "\n -------------------------------- "
                + "\n|1:     Status of Ingredient     |"
                + "\n -------------------------------- "
                + "\n|2:      Fill Ingredient         |"
                + "\n -------------------------------- "
                + "\n|3:       Clean Machine          |"
                + "\n -------------------------------- "
                + "\n|4:        Make Coffee           |"
                + "\n -------------------------------- "
                + "\n|5: How many Coffee We have made?|"
                + "\n -------------------------------- "
                + "\n|6:        Exit                  |"
                + "\n -------------------------------- "
                + "\n\n"
                + "\n\nCleaning Machine...\nCleaning Completed.\n";

        ByteArrayOutputStream baos = new ByteArrayOutputStream();
        PrintStream printStream = new PrintStream(baos);
        System.setOut(printStream);
        CoffeeMachineStubs ch = new CoffeeMachineStubs(); // call the main method
        ch.start();
        String[] lines = baos.toString().split(System.lineSeparator());
        String data = "";
        for (String e : lines) {
            data += (e + "\n");
        }
        String actual = data;

        // checkout output
        assertEquals(expected, actual);
        assertEquals(0, ch.getCoffee_powder());
        assertEquals(0, ch.getMilk());
        assertEquals(0, ch.getWater());
    }

    // 4: Making a Black Coffee else condition
    @Test
    void testStart4BlackFail() {
        String userInput = String.format("4%s1",
                System.lineSeparator(),
                System.lineSeparator());
        ByteArrayInputStream bais = new ByteArrayInputStream(userInput.getBytes());
        System.setIn(bais);

        String expected = " ----------------------------------------------------------------"
                + "\n|                   Coffee Machine By Manikant                   |"
                + "\n ----------------------------------------------------------------\n"
                + "\nCurrent Status: "
                + "\nAvailable Coffee Power(Gram) 0.0"
                + "\nAvailable Milk(Liter) 0.0"
                + "\nAvailable Water(Liter) 0.0\n"
                + "\n -------------------------------- "
                + "\n|1:     Status of Ingredient     |"
                + "\n -------------------------------- "
                + "\n|2:      Fill Ingredient         |"
                + "\n -------------------------------- "
                + "\n|3:       Clean Machine          |"
                + "\n -------------------------------- "
                + "\n|4:        Make Coffee           |"
                + "\n -------------------------------- "
                + "\n|5: How many Coffee We have made?|"
                + "\n -------------------------------- "
                + "\n|6:        Exit                  |"
                + "\n -------------------------------- "
                + "\n\n"
                + "\n\n ------------------ \n|   Select Type:   |"
                + "\n ------------------ "
                + "\n| 1:  Black Coffee |"
                + "\n| 2:  Milk Coffee  |"
                + "\n| 0   to Discard   |"
                + "\n ------------------ "
                + "\n\n"
                + "\nAvailable Coffee Power(Gram) 0.0"
                + "\nAvailable Water(Liter) 0.0\n"
                + "\nSome Items Are Not Available, Please Fill before Making Coffee.\n";

        ByteArrayOutputStream baos = new ByteArrayOutputStream();
        PrintStream printStream = new PrintStream(baos);
        System.setOut(printStream);
        CoffeeMachineStubs ch = new CoffeeMachineStubs(); // call the main method
        ch.start();
        String[] lines = baos.toString().split(System.lineSeparator());
        String data = "";
        for (String e : lines) {
            data += (e + "\n");
        }
        String actual = data;

        // checkout output
        assertEquals(expected, actual);
    }

    // 5: Making a Black Coffee success condition
    @Test
    void testStart5BlackSuccess() {
        String userInput = String.format("4%s1",
                System.lineSeparator(),
                System.lineSeparator());
        ByteArrayInputStream bais = new ByteArrayInputStream(userInput.getBytes());
        System.setIn(bais);

        String expected = " ----------------------------------------------------------------"
                + "\n|                   Coffee Machine By Manikant                   |"
                + "\n ----------------------------------------------------------------\n"
                + "\nCurrent Status: "
                + "\nAvailable Coffee Power(Gram) 500.0"
                + "\nAvailable Milk(Liter) 1.0"
                + "\nAvailable Water(Liter) 2.0\n"
                + "\n -------------------------------- "
                + "\n|1:     Status of Ingredient     |"
                + "\n -------------------------------- "
                + "\n|2:      Fill Ingredient         |"
                + "\n -------------------------------- "
                + "\n|3:       Clean Machine          |"
                + "\n -------------------------------- "
                + "\n|4:        Make Coffee           |"
                + "\n -------------------------------- "
                + "\n|5: How many Coffee We have made?|"
                + "\n -------------------------------- "
                + "\n|6:        Exit                  |"
                + "\n -------------------------------- "
                + "\n\n"
                + "\n\n ------------------ "
                + "\n|   Select Type:   |"
                + "\n ------------------ "
                + "\n| 1:  Black Coffee |"
                + "\n| 2:  Milk Coffee  |"
                + "\n| 0   to Discard   |\n ------------------ "
                + "\n\n"
                + "\nMaking Black Coffee...\n"
                + "\nTaking 10gm of Coffee Powder."
                + "\nTaking 0.2 liter of Water.\n"
                + "\nYour Black Coffee is Ready.\n";

        ByteArrayOutputStream baos = new ByteArrayOutputStream();
        PrintStream printStream = new PrintStream(baos);
        System.setOut(printStream);

        CoffeeMachineStubs ch = new CoffeeMachineStubs(); // call the main method
        ch.setCoffee_powder(500);
        ch.setMilk(1);
        ch.setWater(2);
        ch.start();

        String[] lines = baos.toString().split(System.lineSeparator());

        String data = "";
        for (String e : lines) {
            data += (e + "\n");
        }

        String actual = data;

        // checkout output
        assertEquals(expected, actual);
        assertEquals(490, ch.getCoffee_powder());
        assertEquals(1, ch.getMilk());
        assertEquals(1.8, ch.getWater());
        assertEquals(1, ch.getCoffee_Count());
    }

    // 6: Making a Milk Coffee success condition
    @Test
    void testStart6MilkSuccess() {
        String userInput = String.format("4%s2",
                System.lineSeparator(),
                System.lineSeparator());
        ByteArrayInputStream bais = new ByteArrayInputStream(userInput.getBytes());
        System.setIn(bais);

        String expected = " ----------------------------------------------------------------"
                + "\n|                   Coffee Machine By Manikant                   |"
                + "\n ----------------------------------------------------------------\n"
                + "\nCurrent Status: "
                + "\nAvailable Coffee Power(Gram) 0.0"
                + "\nAvailable Milk(Liter) 0.0"
                + "\nAvailable Water(Liter) 0.0\n"
                + "\n -------------------------------- "
                + "\n|1:     Status of Ingredient     |"
                + "\n -------------------------------- "
                + "\n|2:      Fill Ingredient         |"
                + "\n -------------------------------- "
                + "\n|3:       Clean Machine          |"
                + "\n -------------------------------- "
                + "\n|4:        Make Coffee           |"
                + "\n -------------------------------- "
                + "\n|5: How many Coffee We have made?|"
                + "\n -------------------------------- "
                + "\n|6:        Exit                  |"
                + "\n -------------------------------- "
                + "\n\n"
                + "\n\n ------------------ \n|   Select Type:   |"
                + "\n ------------------ "
                + "\n| 1:  Black Coffee |"
                + "\n| 2:  Milk Coffee  |"
                + "\n| 0   to Discard   |"
                + "\n ------------------ "
                + "\n\n"
                + "\nAvailable Coffee Power(Gram) 0.0"
                + "\nAvailable Milk(Liter) 0.0"
                + "\nAvailable Water(Liter) 0.0\n"
                + "\nSome Items Are Not Available, Please Fill before Making Coffee.\n";

        ByteArrayOutputStream baos = new ByteArrayOutputStream();
        PrintStream printStream = new PrintStream(baos);
        System.setOut(printStream);
        CoffeeMachineStubs ch = new CoffeeMachineStubs(); // call the main method
        ch.start();

        String[] lines = baos.toString().split(System.lineSeparator());
        String data = "";
        for (String e : lines) {
            data += (e + "\n");
        }
        String actual = data;

        // checkout output
        assertEquals(expected, actual);
    }

    // 7: Making a Milk Coffee success condition
    @Test
    void testStart7MilkSuccess() {
        String userInput = String.format("4%s2",
                System.lineSeparator(),
                System.lineSeparator());
        ByteArrayInputStream bais = new ByteArrayInputStream(userInput.getBytes());
        System.setIn(bais);

        String expected = " ----------------------------------------------------------------"
                + "\n|                   Coffee Machine By Manikant                   |"
                + "\n ----------------------------------------------------------------\n"
                + "\nCurrent Status: "
                + "\nAvailable Coffee Power(Gram) 500.0"
                + "\nAvailable Milk(Liter) 1.0"
                + "\nAvailable Water(Liter) 2.0\n"
                + "\n -------------------------------- "
                + "\n|1:     Status of Ingredient     |"
                + "\n -------------------------------- "
                + "\n|2:      Fill Ingredient         |"
                + "\n -------------------------------- "
                + "\n|3:       Clean Machine          |"
                + "\n -------------------------------- "
                + "\n|4:        Make Coffee           |"
                + "\n -------------------------------- "
                + "\n|5: How many Coffee We have made?|"
                + "\n -------------------------------- "
                + "\n|6:        Exit                  |"
                + "\n -------------------------------- "
                + "\n\n"
                + "\n\n ------------------ \n|   Select Type:   |"
                + "\n ------------------ "
                + "\n| 1:  Black Coffee |"
                + "\n| 2:  Milk Coffee  |"
                + "\n| 0   to Discard   |\n ------------------ "
                + "\n\n"
                + "\nMaking Milk Coffee...\n"
                + "\nTaking 10gm of Coffee Powder."
                + "\nTaking 0.4 Liter of Milk."
                + "\nTaking 0.2 liter of Water.\n"
                + "\nYour Milk Coffee is Ready.\n";

        ByteArrayOutputStream baos = new ByteArrayOutputStream();
        PrintStream printStream = new PrintStream(baos);
        System.setOut(printStream);
        CoffeeMachineStubs ch = new CoffeeMachineStubs(); // call the main method
        ch.setCoffee_powder(500);
        ch.setMilk(1);
        ch.setWater(2);
        ch.start();

        String[] lines = baos.toString().split(System.lineSeparator());
        String data = "";
        for (String e : lines) {
            data += (e + "\n");
        }
        String actual = data;

        // checkout output
        assertEquals(expected, actual);
        assertEquals(490, ch.getCoffee_powder());
        assertEquals(0.6, ch.getMilk());
        assertEquals(1.8, ch.getWater());
        assertEquals(1, ch.getCoffee_Count());
    }

    // 8: Number of made coffee
    @Test
    void testStart8Made() {
        String userInput = String.format("5",
                System.lineSeparator(),
                System.lineSeparator());
        ByteArrayInputStream bais = new ByteArrayInputStream(userInput.getBytes());
        System.setIn(bais);

        String expected = " ----------------------------------------------------------------"
                + "\n|                   Coffee Machine By Manikant                   |"
                + "\n ----------------------------------------------------------------\n"
                + "\nCurrent Status: "
                + "\nAvailable Coffee Power(Gram) 0.0"
                + "\nAvailable Milk(Liter) 0.0"
                + "\nAvailable Water(Liter) 0.0\n"
                + "\n -------------------------------- "
                + "\n|1:     Status of Ingredient     |"
                + "\n -------------------------------- "
                + "\n|2:      Fill Ingredient         |"
                + "\n -------------------------------- "
                + "\n|3:       Clean Machine          |"
                + "\n -------------------------------- "
                + "\n|4:        Make Coffee           |"
                + "\n -------------------------------- "
                + "\n|5: How many Coffee We have made?|"
                + "\n -------------------------------- "
                + "\n|6:        Exit                  |"
                + "\n -------------------------------- "
                + "\n\n"
                + "\n\nWe Have Made 0 Coffees.\n";

        ByteArrayOutputStream baos = new ByteArrayOutputStream();
        PrintStream printStream = new PrintStream(baos);
        System.setOut(printStream);
        CoffeeMachineStubs ch = new CoffeeMachineStubs(); // call the main method
        ch.start();

        String[] lines = baos.toString().split(System.lineSeparator());
        String data = "";
        for (String e : lines) {
            data += (e + "\n");
        }
        String actual = data;

        // checkout output
        assertEquals(expected, actual);
    }

    // 9: Exiting Function
    @Test
    void testStart9Exit() {
        String userInput = String.format("6",
                System.lineSeparator(),
                System.lineSeparator());
        ByteArrayInputStream bais = new ByteArrayInputStream(userInput.getBytes());
        System.setIn(bais);

        String expected = " ----------------------------------------------------------------"
                + "\n|                   Coffee Machine By Manikant                   |"
                + "\n ----------------------------------------------------------------\n"
                + "\nCurrent Status: "
                + "\nAvailable Coffee Power(Gram) 0.0"
                + "\nAvailable Milk(Liter) 0.0"
                + "\nAvailable Water(Liter) 0.0\n"
                + "\n -------------------------------- "
                + "\n|1:     Status of Ingredient     |"
                + "\n -------------------------------- "
                + "\n|2:      Fill Ingredient         |"
                + "\n -------------------------------- "
                + "\n|3:       Clean Machine          |"
                + "\n -------------------------------- "
                + "\n|4:        Make Coffee           |"
                + "\n -------------------------------- "
                + "\n|5: How many Coffee We have made?|"
                + "\n -------------------------------- "
                + "\n|6:        Exit                  |"
                + "\n -------------------------------- "
                + "\n\n"
                + "\n\n"
                + "Exiting...\n";

        ByteArrayOutputStream baos = new ByteArrayOutputStream();
        PrintStream printStream = new PrintStream(baos);
        System.setOut(printStream);
        CoffeeMachineStubs ch = new CoffeeMachineStubs(); // call the main method
        ch.start();

        String[] lines = baos.toString().split(System.lineSeparator());
        String data = "";
        for (String e : lines) {
            data += (e + "\n");
        }
        String actual = data;

        // checkout output
        assertEquals(expected, actual);
    }
}