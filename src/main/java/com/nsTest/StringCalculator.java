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
            Pattern pattern2 = Pattern.compile ("(-?\\d+)"+ customDelimiter + "?");
            matcher = pattern2.matcher(numbers);
            String negString = "";
            while (matcher.find()){
                //step4
                //sum += Integer.valueOf(matcher.group(1));
                if (Integer.parseInt(matcher.group(1)) > 0){
                    if(Integer.parseInt(matcher.group(1)) <= 1000 ){
                        sum += Integer.parseInt(matcher.group(1));
                    }

                }else{
                    negString = negString.concat(String.valueOf(matcher.group(1))).concat(";");
                }
            }
            if (negString.isEmpty())
                return sum;
            else
                throw new IllegalArgumentException("Negative numbers not allowed: " + negString);

        }catch (NumberFormatException numberFormatException){
            throw new IllegalArgumentException("String not allowed " + numberFormatException.getMessage(),
                    numberFormatException);
        }
    }
}
