package edu.hw1;

public class Task2 {
    /**
     * 2. ���������� ����
     * �������� �������, ������� ���������� ���������� ���� � ���������� ����� �����.     *
     * ������������ ��������������� � ������ ���������.
     */
    public static int secondTask(int number) {
        if (number == 0)
            return 1;
        int count = 0;
        while (number != 0) {
            number = number / 10;
            count++;
        }
        return count;
    }
}
