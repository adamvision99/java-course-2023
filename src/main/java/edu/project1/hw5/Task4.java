package edu.hw5;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Task4 {
    public static boolean validatePassword(String password) {
        // ���������� ��������� ��� �������� ������� ��������� ��������
        String regex = "[~!@#$%^&*|]";

        Pattern pattern = Pattern.compile(regex);
        Matcher matcher = pattern.matcher(password);

        return matcher.find();
    }
}
