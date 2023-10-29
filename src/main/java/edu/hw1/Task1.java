package edu.hw1;

public class Task1 {
    /**
     * 1. ����� �����
     * ���� ������ � ������ ����� � ������� mm:ss, �������� 12:44.
     * �������� �������, ������� ���������� ����� ����� ����� � ��������.
     */
    public static int firstTask(String str) {
        String[] parts = str.split(":");
        int min = Integer.parseInt(parts[0]);
        int sec = Integer.parseInt(parts[1]);
        if (sec >= 60)
            return -1;
        else
            return min * 60 + sec;
    }
}
