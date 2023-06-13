package exercice;

import java.util.ArrayList;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Set;

public class SobrieteMeilleur {

    public static List<String> solution(String str, List<Character> ordre) {
        List<String> result = new ArrayList<>(); // une seule liste pour stocker les mots

        String[] chaine = str.split("[^a-zA-Z0-9]"); // cette ligne de code divise la chaîne str en utilisant tous les
                                                     // caractères
                                                     // qui ne sont pas des lettres ou des chiffres comme séparateurs,
                                                     // et les sous-chaînes résultantes sont stockées dans le tableau
                                                     // chaine.
        for (int i = 0; i < chaine.length; i++) { // remplace les mots vides par un espace
            if (chaine[i].equals("")) { // si le mot est vide
                chaine[i] = " "; // le mot devient un espace
            }
        }

        for (Character letter : ordre) { // parcours les lettres de la liste ordre
            for (String parcours : chaine) { // parcours les mots de la liste chaine
                if (parcours.charAt(0) == letter) { // si la première lettre du mot est égale à la lettre de la liste
                                                    // ordre
                    result.add(parcours); // ajoute le mot à la liste result
                }
            }
        }

        if (str.isEmpty()) { // si la chaine de caractères est vide
            result.add(""); // ajoute un mot vide à la liste result
        } else {
            for (String parc : chaine) { // parcours les mots de la liste chaine
                if (!result.contains(parc) && !parc.equals(" ")) {
                    result.add(parc);
                }
            }
        }

        return result;
    }
}
// Point de vue de la sobriété :
// Il n'y a qu'une seule liste pour stocker les mots et non deux  
// split permet de séparer les mots de la chaine de caractères en fonction des caractères spéciaux et des espaces