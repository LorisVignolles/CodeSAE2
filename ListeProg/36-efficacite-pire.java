package main;

import java.util.ArrayList;
import java.util.List;

public class Exercice {

	public static List<String> solution(String str, List<Character> ordre) {

        List<String> mots = new ArrayList<>();
        StringBuilder motCourant = new StringBuilder();

        for (int i = 0; i < str.length(); i++) {
            char c = str.charAt(i);
            if (Character.isLetterOrDigit(c)) {
                motCourant.append(c);
            } else if (motCourant.length() > 0) {
                mots.add(motCourant.toString());
                motCourant.setLength(0);
            }
        }

        if (motCourant.length() > 0) {
            mots.add(motCourant.toString());
        }

        triParSelection(mots, ordre);

        return mots;
    }

    private static void triParSelection(List<String> mots, List<Character> ordre) {
        for (int i = 0; i < mots.size() - 1; i++) {
            int minIndex = i;
            for (int j = i + 1; j < mots.size(); j++) {
                if (compareWords(mots.get(j), mots.get(minIndex), ordre) < 0) {
                    minIndex = j;
                }
            }
            if (minIndex != i) {
                swap(mots, i, minIndex);
            }
        }
    }

    private static int compareWords(String mot1, String mot2, List<Character> ordre) {
        int minLength = Math.min(mot1.length(), mot2.length());
        for (int i = 0; i < minLength; i++) {
            char c1 = mot1.charAt(i);
            char c2 = mot2.charAt(i);
            int index1 = indexOf(c1, ordre);
            int index2 = indexOf(c2, ordre);
            if (index1 != index2) {
                return Integer.compare(index1, index2);
            }
        }
        return Integer.compare(mot1.length(), mot2.length());
    }

    private static int indexOf(char c, List<Character> ordre) {
        for (int i = 0; i < ordre.size(); i++) {
            if (ordre.get(i) == c) {
                return i;
            }
        }
        return ordre.size();
    }

    private static void swap(List<String> mots, int i, int j) {
        String temp = mots.get(i);
        mots.set(i, mots.get(j));
        mots.set(j, temp);
    }

}
