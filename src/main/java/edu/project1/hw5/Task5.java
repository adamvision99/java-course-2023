package edu.hw5;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Task5 {
    public static boolean validateCarNumber(String carNumber) {
        String regex = "^[������������]\\d{3}[������������]{2}\\d{2,3}$";
        Pattern pattern = Pattern.compile(regex);
        Matcher matcher = pattern.matcher(carNumber);

        return matcher.matches();
    }
}
