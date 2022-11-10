package main.java.com.nsTest;

import java.util.stream.Stream;

public class StringCalculator {
    public int add(String numbers) {
        int sum;
        if (numbers==null || numbers.equals(""))
            return 0;
        try {
            // step 1 & 2
            String[] strings = numbers.split("[,\\n]");
            sum = Stream.of(strings).mapToInt(Integer::valueOf).sum();
        }catch (NumberFormatException numberFormatException){
            throw new IllegalArgumentException("String not allowed " + numberFormatException.getMessage(),
                    numberFormatException);
        }
        return sum;
    }
}
