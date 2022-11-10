package test;

import main.java.com.nsTest.StringCalculator;
import org.junit.Test;

import static org.junit.Assert.*;

public class TestStringCalculator {
    @Test
    public void testAddEmpty(){
        //1-1
        StringCalculator strCalculator = new StringCalculator();
        int result = strCalculator.add("");
        assertEquals(0,result);
    }

    @Test
    public void testAddOneNum(){
        //1-2
        StringCalculator strCalculator = new StringCalculator();
        int result = strCalculator.add("1");
        assertEquals(1,result);
    }

    @Test
    public void testAddTwoNum(){
        //1-3
        StringCalculator strCalculator = new StringCalculator();
        int result = strCalculator.add("1,2");
        assertEquals(3,result);
    }

    @Test
    public void testAddUnknownAmountOfNum(){
        //2 Adjust the add method to handle an unknown amount of numbers
        StringCalculator strCalculator = new StringCalculator();
        int result = strCalculator.add("1,2,3,4");
        assertEquals(10,result);
    }

    @Test
    public void testAddHandleNewline(){
        //3 Update the add method to handle new lines between numbers
        StringCalculator strCalculator = new StringCalculator();
        int result = strCalculator.add("1\n2,3");
        assertEquals(6,result);
    }

    @Test
    public void testAddDiffDelimiter(){
        //4 Allow the add method to support custom delimiters as part of the input
        StringCalculator strCalculator = new StringCalculator();
        int result = strCalculator.add("//;\n1;2");
        assertEquals(3,result);
    }

    @Test
    public void testAddNegativeNum() {
        //5 Handle negatives so that add will throw an exception “Negative numbers not allowed: ”
        // and the negative number that was passed.
        // If there are multiple negatives, show all of them in the exception message
        try{
            StringCalculator strCalculator = new StringCalculator();
            int result = strCalculator.add("1,-2");
            fail("Exception should be thrown.");
        }catch(Exception ex){
            //assertTrue(negativeNumberException);
            assertTrue(ex.getMessage().contains("Negative numbers not allowed: -2;"));
        }
    }

    @Test
    public void testAddLagerThanOneThousand() {
        //6 Change the add method to ignore numbers larger than 1000
        StringCalculator strCalculator = new StringCalculator();
        int result = strCalculator.add("2,1001");
        assertEquals(2,result);
    }
}

