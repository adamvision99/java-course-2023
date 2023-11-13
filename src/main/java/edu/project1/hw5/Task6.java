package edu.hw5;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Task6 {
    public static boolean isSubsequence(String S, String T) {
        // Построение регулярного выражения для проверки подпоследовательности
        String regex = ".*" + S.chars().mapToObj(c -> (char) c).collect(StringBuilder::new, StringBuilder::append, StringBuilder::append) + ".*";

        Pattern pattern = Pattern.compile(regex);
        Matcher matcher = pattern.matcher(T);

        return matcher.matches();
    }
}
