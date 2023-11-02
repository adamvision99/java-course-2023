package edu.hw1;

import java.util.Arrays;

public class Task3 {
    /**
     * 3. ��������� ������
     * �������� �������, ������� ���������� true, ���� ������ ������ ����� ���� ������ �� ������, � false � ��������� ������.
     * ������ ����� ���� ������, ����:     *
     * min(a1) ������ ��� min(a2)
     * max(a1) ������, ��� max(a2)
     */
    public static boolean thirdTask(int[] first, int[] second) {
        int minFirst = Arrays.stream(first).min().orElse(0);
        int minSecond = Arrays.stream(second).min().orElse(0);
        int maxFirst = Arrays.stream(first).max().orElse(0);
        int maxSecond = Arrays.stream(second).max().orElse(0);
        return minSecond <= minFirst && maxSecond >= maxFirst;

    }
}
