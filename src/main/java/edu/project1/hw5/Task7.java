package edu.hw5;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Task7 {
    public static boolean matchesRegex(String input, String regex) {
        Pattern pattern = Pattern.compile(regex);
        Matcher matcher = pattern.matcher(input);
        return matcher.matches();
    }
}
