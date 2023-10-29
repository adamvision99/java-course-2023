package edu.hw1;

import java.util.Arrays;
import java.util.Collections;

public class Task6 {
    /**
     * 6. ���������� ���������
     * ������� ����� ������������� ����� n, ������ 1000, � ������� �� ��� ����� ���������.
     * ���������� ����� ������� � ������� �����������, ����� � ������� ��������.
     * ������ �� �������� �������. ��������� ������������ ���� � ���������, ���� ������� ���������.
     * ��������� �������� ������ �������� ��������� K(n).
     * �������� ���� ������� � ������������� ����������, �� ����� ��� �� ���� ����� �� ������� ����� 6174, ������� ����� ����� �������������� ���� ����.
     * ��� �������� ����� 6174 ���� ������� � 1949 ����. ��������� ����������� �. �. ����������, � ����� �������� ��� � �������� ��� ��������.
     */
    public static int sixthTask(int number, int count) {
        if (number == 6174)
            return count;
        else {
            Integer[] array = new Integer[4];
            for (int i = 0; i < 4; i++) {
                array[i] = number % 10;
                number /= 10;
            }
            Arrays.sort(array);
            int order = array[0] * 1000 + array[1] * 100 + array[2] * 10 + array[3];
            Arrays.sort(array, Collections.reverseOrder());
            int reorder = array[0] * 1000 + array[1] * 100 + array[2] * 10 + array[3];
            count++;
            return sixthTask(Math.abs(order - reorder), count);
        }
    }
}
