package Simplicite_pire;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Exercice {

    public static List<String> solution(String phrase, List<Character> ordre) {
        List<String> mots = new ArrayList<>();
        Map<Character, Integer> ordreIndex = new HashMap<>();
        for (int i = 0; i < ordre.size(); i++) {
            ordreIndex.put(ordre.get(i), i);
        }

        for (String mot : phrase.split(" ")) {
            mots.add(mot);
        }

        mots.sort(Comparator.comparingInt(mot -> {
            int index = Integer.MAX_VALUE;
            for (char c : mot.toLowerCase().toCharArray()) {
                if (ordreIndex.containsKey(c)) {
                    index = Math.min(index, ordreIndex.get(c));
                }
            }
            return index;
        }));
        return mots;
    }
}
