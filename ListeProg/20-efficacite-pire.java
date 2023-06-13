package exercice;

import java.util.ArrayList;
import java.util.List;

public class Exercice {
    public static List<String> solution(String str, List<Character> ordre) {
        // Contient le texte splité en mots
        String[] splited = str.split("[^a-zA-Z0-9]+");

        // Liste qui va contenir le résultat
        List<String> result = new ArrayList<>();

        // Tableau d’array list de string qui va permettre de stocker les mots dans le bon ordre
        ArrayList<String>[] tab = new ArrayList[ordre.size()+1];
        // Initialise les array lists
        for (int i = 0; i < tab.length; i++) {
            tab[i] = new ArrayList<>();
        }

        // Liste des mots qui ne commencent pas par un caractère de l’ordre
        List<String> notfound = new ArrayList<>();
        for (String s : splited) {
            // vérifie si la première lettre du mot est dans l’ordre, si oui, on l’ajoute a la liste correspondante
            // Si il n’y est pas, on l’ajoute a la liste des mots qui ne sont pas ordonné
            if (ordre.contains(s.charAt(0))){
                tab[ordre.indexOf(s.charAt(0))].add(s);
            }else{
                notfound.add(s);
            }
        }

        // Trie les mots dans les listes avec un a bulle

        for (int i = 0; i < tab.length; i++) {
            for (int j = 0; j < tab[i].size(); j++) {
                for (int k = 0; k < tab[i].size()-j-1; k++) {
                    if (compare(tab[i].get(k), tab[i].get(k+1), ordre) > 0){
                        String temp = tab[i].get(k);
                        tab[i].set(k, tab[i].get(k+1));
                        tab[i].set(k+1, temp);
                    }
                }
            }
        }


        // Ajoute le contenu des listes a la liste de sortie
        for (ArrayList<String> list : tab) {
            result.addAll(list);
        }

        // ajoute la liste des mots inconnu a la liste de sortie
        result.addAll(notfound);

        // retourne la liste de sortie
        return result;
    }

    public static int compare(String mot1, String mot3, List<Character> ordre){
        int i = 0;
        while (i < mot1.length() && i < mot3.length()){
            if (ordre.indexOf(mot1.charAt(i)) < ordre.indexOf(mot3.charAt(i))){
                return -1;
            }else if (ordre.indexOf(mot1.charAt(i)) > ordre.indexOf(mot3.charAt(i))){
                return 1;
            }
            i++;
        }
        if (mot1.length() < mot3.length()){
            return -1;
        }else if (mot1.length() > mot3.length()){
            return 1;
        }
        return 0;
    }
}
