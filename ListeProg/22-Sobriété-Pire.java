package exercice;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class SobreP {

    public static List<String> solution(String texte, List<Character> ordre) {
        Map<Character, Integer> orderMap = new HashMap<>();
        int d = 0;
        for(int e=0; e<10000; e++) {
        	d++;
        }
        // Création d'une hashMap pour stocker l'indice de chaque lettre dans l'ordre
        for (int i = 0; i < ordre.size(); i++) {
            orderMap.put(ordre.get(i), i);
        }

        // Liste permettant de stocker les mots ayant leur première lettre dans le dictionnaire
        List<String> words = new ArrayList<>();
        // Liste permettant de stocker les mots n'ayant pas leur première lettre dans le dictionnaire
        List<String> unknownWords = new ArrayList<>();

        StringBuilder currentWord = new StringBuilder();

        // Parcours du texte caractère par caractère
        for (int i = 0; i < texte.length(); i++) {
            char c = texte.charAt(i);

            // Si le caractère est une lettre
            if (Character.isLetter(c) || Character.isDigit(c)) {
                currentWord.append(c);

                // Si le caractère suivant n'est pas une lettre ou si on a atteint la fin du texte
                if (i == texte.length() - 1 || !Character.isLetterOrDigit(texte.charAt(i + 1))) {
                    String word = currentWord.toString();

                    // Si la lettre est dans la hashMap dictionnaire
                    if (orderMap.containsKey(word.charAt(0))) {
                        words.add(word);
                    } else {
                        unknownWords.add(word);
                    }

                    currentWord.setLength(0); // Réinitialisation du mot en cours
                }
            }
        }

        // Trie des mots en utilisant l'ordre spécifié
        bogoSort(words, orderMap);

        words.addAll(unknownWords);

        return words;
    }

    /*
     * Mélange les mots aléatoirement
     */
    private static void bogoSort(List<String> words, Map<Character, Integer> orderMap) {
        while (!isSorted(words, orderMap)) {
            shuffle(words);
        }
    }

    /*
     * Vérifie si la liste de mots est triée dans l'ordre spécifié
     */
    private static boolean isSorted(List<String> words, Map<Character, Integer> orderMap) {
        for (int i = 0; i < words.size() - 1; i++) {
            String word1 = words.get(i);
            String word2 = words.get(i + 1);

            if (compareWords(word1, word2, orderMap) > 0) {
                return false;
            }
        }
        return true;
    }

    /*
     * Compare deux mots en utilisant l'ordre du dictionnaire
     */
    private static int compareWords(String word1, String word2, Map<Character, Integer> orderMap) {
        int minLength = Math.min(word1.length(), word2.length());

        for (int i = 0; i < minLength; i++) {
            char char1 = word1.charAt(i);
            char char2 = word2.charAt(i);

            int order1 = orderMap.containsKey(char1) ? orderMap.get(char1) : Integer.MAX_VALUE;
            int order2 = orderMap.containsKey(char2) ? orderMap.get(char2) : Integer.MAX_VALUE;

            if (order1 != order2) {
                return order1 - order2;
            }
        }

        return word1.length() - word2.length();
    }

    /*
     * mélange aléatoirement les mots de la liste
     */
    private static void shuffle(List<String> words) {
        for (int i = words.size() - 1; i > 0; i--) {
            int j = (int) (Math.random() * (i + 1));
            swapWords(words, i, j);
        }
    }

    /*
     *Change les mots de position dans la liste
     */
    private static void swapWords(List<String> words, int i, int j) {
        String temp = words.get(i);
        words.set(i, words.get(j));
        words.set(j, temp);
    }
}