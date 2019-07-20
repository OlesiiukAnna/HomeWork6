package org.anna.Task_6;

import java.util.HashSet;
import java.util.Set;

/*
Написать метод который принимает 2 строки - a, b.
Метод должне вернуть количество символов которые у них различаются.
Если строки разной длины то вернуть -1.
Примеры:
a="asdf", b="qwerty" => -1
a="abb", b="bba" => 0
a="abc", b="dca" => 1
a="aaa", b="fga" => 2
a="abc", b="dfg" => 3
 */
public class ExtraTask {
    public static void main(String[] args) {

        System.out.println(returnNumberOfDifferentChars("asdf", "qwerty"));
        System.out.println(returnNumberOfDifferentChars("abb", "bba"));
        System.out.println(returnNumberOfDifferentChars("abc", "dca"));
        System.out.println(returnNumberOfDifferentChars("aaa", "fga"));
        System.out.println(returnNumberOfDifferentChars("abc", "dfg"));
    }

    private static int returnNumberOfDifferentChars(String a, String b) {
        if (hasDifferentLength(a, b)) {
            return -1;
        }
        Set<Character> setA = new HashSet<>();
        Set<Character> setB = new HashSet<>();
        for (int i = 0; i < a.length(); i++) {
            setA.add(a.charAt(i));
            setB.add(b.charAt(i));
        }

        int counterA = numberOfMatches(setA, a, b);
        int counterB = numberOfMatches(setB, b, a);

        return counterA > counterB ? counterA : counterB;
    }

    private static boolean hasDifferentLength(String a, String b) {
        return a.length() != b.length();
    }
    private static int numberOfMatches(Set<Character> set, String stringA, String stringB) {
        int number = stringA.length();
        for (int i = 0; i < stringA.length(); i++) {
            if (set.contains(stringB.charAt(i))) {
                number--;
            }
        }
        return number;
    }
}
