package main.java.com.nsTest;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class StringCalculator {
    public int add(String numbers) {
        int sum = 0;

        if (numbers==null || numbers.isEmpty())
            return 0;

        try {
            Pattern pattern1 = Pattern.compile ("^//(\\W)\\n?");
            Matcher matcher = pattern1.matcher(numbers);
            String customDelimiter = (matcher.find())? matcher.group(1): ",";
            Pattern pattern2 = Pattern.compile ("(\\d+)"+ customDelimiter + "?");
            matcher = pattern2.matcher(numbers);
            while (matcher.find()){
                //step4
                sum += Integer.parseInt(matcher.group(1));
            }
            return sum;

        }catch (NumberFormatException numberFormatException){
            throw new IllegalArgumentException("String not allowed " + numberFormatException.getMessage(),
                    numberFormatException);
        }
    }
}
