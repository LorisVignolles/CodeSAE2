import java.util.ArrayList;
import java.util.List;

public class Simplicite {

    public static List<String> sortWordsByOrder(String text, List<Character> order) {
        List<String> words = extractWords(text);
        List<String> sortedWords = new ArrayList<>();

        for (Character letter : order) {
            List<String> matchedWords = new ArrayList<>();

            for (String word : words) {
                if (!sortedWords.contains(word) && word.charAt(0) == letter) {
                    matchedWords.add(word);
                }
            }

            sortedWords.addAll(matchedWords);
        }

        sortedWords.addAll(words);

        return sortedWords;
    }

    private static List<String> extractWords(String text) {
        List<String> words = new ArrayList<>();
        String[] wordArray = text.split(" ");

        for (String word : wordArray) {
            words.add(word);
        }

        return words;
    }

    public static void main(String[] args) {
        String text = "Hello world Java code";
        List<Character> order = List.of('J', 'w', 'c', 'H', 'l', 'o', 'd', 'a', 'v', 'e', 'r');

        List<String> sortedWords = sortWordsByOrder(text, order);

        for (String word : sortedWords) {
            System.out.println(word);
        }
    }
}

