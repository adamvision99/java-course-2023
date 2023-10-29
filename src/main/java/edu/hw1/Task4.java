package edu.hw1;

public class Task4 {
    /**
     * 4. Сломанная строка
     * оПомигети псаривьтс ртко!и
     * Ой, имелось ввиду: "Помогите исправить строки!"
     * Все мои строки перепутались и каждая пара символов поменялась местами.
     * Напишите функцию, которая исправляет такие строки и возвращает правильный порядок.
     */
    public static String fourthTask(String str) {
        char[] charArray = str.toCharArray();
        for (int i = 0; i < charArray.length; i = i + 2) {
            if(i+1< charArray.length){
                char s = charArray[i];
                charArray[i] = charArray[i + 1];
                charArray[i + 1] = s;
            }
        }
        return new String(charArray);
    }
}
