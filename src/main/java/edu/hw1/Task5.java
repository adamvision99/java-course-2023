package edu.hw1;

public class Task5 {
    /**
     * 5. Особый палиндром
     * Будем называть потомком числа новое число, которое создается путем суммирования каждой пары соседних цифр.
     * Напишите функцию, которая будет возвращать true, если число является палиндромом
     * или если любой из его потомков длиной > 1 (как минимум 2 цифры) является палиндромом.
     */
    public static boolean fifthTask(int number) {
        boolean res = false;
        while (!res || number > 0) {
            int oldNumber = number;
            int reverseNumber = 0;
            int rem = 0;
            while (number > 0) {
                rem = number % 10;
                reverseNumber = (reverseNumber * 10) + rem;
                number = number / 10;
            }
            if (oldNumber == reverseNumber)
                res = true;
            else {
                while (reverseNumber > 0) {
                    rem = reverseNumber % 100 / 10 + reverseNumber % 10;
                    number = (number * 10) + rem;
                    reverseNumber = reverseNumber / 100;
                }
            }
        }
        return res;
    }
}
