package edu.hw1;

public class Task7 {
    /**
     * 7. ÷иклический битовый сдвиг
     * ¬ Java есть базовые битовые операции, но нет циклического сдвига битов.
     * Ќапишите 2 функции:
     * int rotateLeft(int n, int shift)
     * int rotateRight(int n, int shift)
     * где
     * n -- целое число положительное число
     * shift -- размер циклического сдвига
     */
    public static int seventhLeft(int number, int shift) {
        char[] str = seventh(number).toCharArray();
        for (int j = 0; j < shift; j++) {
            char first = str[0];
            for (int i = 0; i < str.length - 1; i++) {
                str[i] = str[i + 1];
            }
            str[str.length - 1] = first;
        }
        String result = new String(str);
        return Integer.parseInt(result,2);
    }

    public static int seventhRight(int number, int shift) {
        char[] str = seventh(number).toCharArray();
        for (int j = 0; j < shift; j++) {
            char lst = str[str.length - 1];
            for (int i = str.length - 1; i > 0; i--) {
                str[i] = str[i - 1];
            }
            str[0] = lst;
        }
        String result = new String(str);
        return Integer.parseInt(result,2);
    }

    public static String seventh(int number) {
        StringBuilder str = new StringBuilder();
        char ch;
        String nstr = "";
        while (number != 1) {
            str.append(number % 2);
            number /= 2;
        }
        str.append(1);
        for (int i = 0; i < str.length(); i++) {
            ch = str.charAt(i);
            nstr = ch + nstr;
        }
        return nstr;
    }
}
