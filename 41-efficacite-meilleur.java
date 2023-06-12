/**
 * package exercice;

import java.util.ArrayList;
import java.util.List;

public class Exercice {
     * Fonction renvoyant les mots de la chaîne de caractère entrante trié par l'ordre de caractères donné
     * @param str la chaîne de caractère entrante
     * @param ordre l'ordre de traitement des mots
     * @return les mots de la chaîne triés dans l'ordre demandé
     * @author Louis Penet 2A

    public static List<String> solution(String str, List<Character> ordre) {
        String mot = "";
        ArrayList<String> liste= new ArrayList<>();
        ArrayList<Integer> puissance = new ArrayList<>();
        int iparcours=0;
        int valB;
        String motB;
        int minIndex;
        //On sépare chaque mot de la chaîne donnée et on les mets dans une liste
        for (int i=0;i<str.length();i++){
            //Si le i-ième caractère n'est ni un nombre, ni une lettre, ou que l'on est à la fin de la liste, on ajoute le mot à la liste
            if ((!Character.isDigit(str.charAt(i)) && !Character.isLetter(str.charAt(i)))|| i==str.length()-1){
                if (i==str.length()-1){
                    mot+=str.charAt(i);
                }
                if (mot!=""){
                liste.add(mot);
                puissance.add(getPuissance(mot, ordre,i));
                mot="";
                }
            }
            //On rajoute la lettre actuelle au mot
            else {
                mot+=str.charAt(i);
            }
        }
        //Tant que toute la liste n'est pas triée, on effectue un tri
        while (iparcours != liste.size()) {
            minIndex = iparcours;
            for (int j = iparcours + 1; j < liste.size(); j++) {
                if (puissance.get(j) < puissance.get(minIndex)) {
                    minIndex = j;
                }
            }
            valB = puissance.get(minIndex);
            puissance.set(minIndex, puissance.get(iparcours));
            puissance.set(iparcours, valB);

            motB = liste.get(minIndex);
            liste.set(minIndex, liste.get(iparcours));
            liste.set(iparcours, motB);
            iparcours++;
        }
        return liste;
    }

     * Fonction calculant la "puissance" du mot entré. La puissance d'un mot correspond à son <<rang>> dans la liste ; 
     * plus la puissance d'un mot est élevée, plus il sera loin dans la liste
     * @param mot mot à traiter
     * @param ordre ordre donné
     * @param bonus points à rajouter dans le cas où la première lettre du mot ne soit pas dans l'ordre donné
     * @return un entier indiquant la puissance du mot
     * 
    public static int getPuissance(String mot, List<Character> ordre, int bonus){
        int iparcours=0;
        while (mot.charAt(0)!=ordre.get(iparcours) && iparcours<ordre.size()-1){
            iparcours++;
        }
        if (iparcours==(ordre.size()-1)){
            iparcours+=bonus;
        }
        return iparcours;
    }
    
}
*/
package exercice;

import java.util.ArrayList;
import java.util.List;

public class Exercice {
    public static List<String> solution(String str, List<Character> ordre) {
        String mot = "";
        ArrayList<String> liste = new ArrayList<>();
        ArrayList<Integer> puissance = new ArrayList<>();
        int iparcours = 0;
        int valB;
        String motB;
        int minIndex;

        for (int i = 0; i < str.length(); i++) {
            if ((!Character.isDigit(str.charAt(i)) && !Character.isLetter(str.charAt(i))) || i == str.length() - 1) {
                if (i == str.length() - 1) {
                    mot += str.charAt(i);
                }
                if (!mot.isEmpty()) {
                    liste.add(mot);
                    puissance.add(getPuissance(mot, ordre, ordre.size()));
                    mot = "";
                }
            } else {
                mot += str.charAt(i);
            }
        }

        while (iparcours != liste.size()) {
            minIndex = iparcours;
            for (int j = iparcours + 1; j < liste.size(); j++) {
                if (puissance.get(j) < puissance.get(minIndex)) {
                    minIndex = j;
                }
            }
            valB = puissance.get(minIndex);
            puissance.set(minIndex, puissance.get(iparcours));
            puissance.set(iparcours, valB);

            motB = liste.get(minIndex);
            liste.set(minIndex, liste.get(iparcours));
            liste.set(iparcours, motB);
            iparcours++;
        }
        
        return liste;
    }

    public static int getPuissance(String mot, List<Character> ordre) {
        int puissance = 0;
        for (int i = 0; i < mot.length(); i++) {
            char c = mot.charAt(i);
            if (ordre.contains(c)) {
                puissance = Math.max(puissance, ordre.indexOf(c) + 1);
            }
        }
        return puissance;
    }
}
