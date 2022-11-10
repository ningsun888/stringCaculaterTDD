package test;

import main.java.com.nsTest.StringCalculator;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

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
}

