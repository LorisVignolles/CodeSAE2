package exercice;
import java.util.*;

/**
 * Classe simplicitemeilleur contenant une méthode pour trier une phrase en fonction d'un ordre spécifié et placer les mots sans ordre à la fin.
 */
public class simplicitemeilleur {
    
    /**
     * Trie une phrase en fonction d'un ordre spécifié et place les mots sans ordre à la fin.
     *
     * @param texte  La phrase à trier.
     * @param ordre  L'ordre des caractères à utiliser pour le tri.
     * @return       Une liste contenant les mots triés.
     */
    public static List<String> solution(String texte, List<Character> ordre) {
        List<String> mots = Arrays.asList(texte.split(" "));
        List<String> motsAvecOrdre = new ArrayList<>();
        List<String> motsSansOrdre = new ArrayList<>();

        // Sépare les mots avec ordre des mots sans ordre
        for (String mot : mots) {
            if (aUnOrdre(mot, ordre)) {
                motsAvecOrdre.add(mot);
            } else {
                motsSansOrdre.add(mot);
            }
        }

        // Trie les mots avec ordre en utilisant la comparaison personnalisée
        motsAvecOrdre.sort((mot1, mot2) -> comparerMots(mot1, mot2, ordre));

        // Concatène les mots triés avec ordre et les mots sans ordre
        motsAvecOrdre.addAll(motsSansOrdre);
        return motsAvecOrdre;
    }

    /**
     * Vérifie si un mot a un ordre spécifié.
     *
     * @param mot    Le mot à vérifier.
     * @param ordre  L'ordre des caractères à utiliser pour la vérification.
     * @return       {@code true} si le mot a un ordre spécifié, {@code false} sinon.
     */
    private static boolean aUnOrdre(String mot, List<Character> ordre) {
        for (char c : mot.toCharArray()) {
            if (!ordre.contains(c)) {
                return false;
            }
        }
        return true;
    }

    /**
     * Compare deux mots selon l'ordre spécifié.
     *
     * @param mot1   Le premier mot à comparer.
     * @param mot2   Le deuxième mot à comparer.
     * @param ordre  L'ordre des caractères à utiliser pour la comparaison.
     * @return       Une valeur négative si le premier mot est inférieur, une valeur positive si le premier mot est supérieur,
     *               ou zéro si les deux mots sont égaux selon l'ordre spécifié.
     */
    private static int comparerMots(String mot1, String mot2, List<Character> ordre) {
        int longueur1 = mot1.length();
        int longueur2 = mot2.length();
        int longueurMin = Math.min(longueur1, longueur2);

        for (int i = 0; i < longueurMin; i++) {
            char char1 = mot1.charAt(i);
            char char2 = mot2.charAt(i);
            int index1 = ordre.indexOf(char1);
            int index2 = ordre.indexOf(char2);

            if (index1 != -1 && index2 != -1) {
                if (index1 != index2) {
                    return index1 - index2;
                }
            } else if (index1 == -1 && index2 == -1) {
                continue;
            } else if (index1 == -1) {
                return 1;
            } else if (index2 == -1) {
                return -1;
            }
        }

        return longueur1 - longueur2;
    }
}
