package main.java.com.nsTest;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class StringCalculator {
    public int add(String numbers) {
        int sum = 0;

        if (numbers==null || numbers.isEmpty())
            return 0;

        try {
            Pattern pattern1 = Pattern.compile ("^//(\\W*)\\n?");
            Matcher matcher = pattern1.matcher(numbers);
            String customDelimiter;
            int  startSplitPosition = 0;
            String separator = ",|\\n";

            if (matcher.find()){
                Pattern pattern2 = Pattern.compile ("\\[?([^]\\w]+)]?");
                Matcher matcher2 = pattern2.matcher(numbers.substring(2, matcher.end()-1));
                while (matcher2.find()){
                    customDelimiter = matcher2.group(1);
                    customDelimiter = customDelimiter.replaceAll("\\*", "\\\\\\*");
                    separator= separator.concat("|").concat(customDelimiter);
                }
                startSplitPosition = matcher.end();
            }

            String[] strings = numbers.substring(startSplitPosition).split(separator);
            String negString = "";
            for(String s : strings){
                if (Integer.parseInt(s) > 0){
                    if(Integer.parseInt(s) <= 1000 ){
                        sum += Integer.parseInt(s);
                    }

                }else{
                    negString = negString.concat(s).concat(";");
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
