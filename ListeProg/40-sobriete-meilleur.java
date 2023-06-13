package exercice;

import java.util.ArrayList;
import java.util.List;

public class Exercice {

	public static List<String> solution(String str, List <Character> ordre) {
		
		List<String> liste = new ArrayList<>();
		StringBuilder motActuel = new StringBuilder();

		//on isole chacun des mots pour pouvoir ensuite les triers	
		for (int i =0; i<str.length(); i++) {
			if (Character.isLetterOrDigit(str.charAt(i))) {
				motActuel.append(str.charAt(i));
			} else if (motActuel.length()>0) {  
				liste.add(motActuel.toString());
				motActuel.setLength(0);
			}
			
			//condition pour ajouter le dernier mot de la chaine str	
		}
		if (motActuel.length() > 0) {
			liste.add(motActuel.toString());
		}
		
	    for (int i = 1; i < liste.size(); i++) {
	        String mot = liste.get(i);
	        int j = i - 1;
	        while (j >= 0 && comparerMots(liste.get(j), mot, ordre) > 0) {
	            liste.set(j + 1, liste.get(j));
	            j--;
	        }
	        liste.set(j + 1, mot);
	        
	       
	    }
	    return liste;
	}

	public static int comparerMots(String mot1, String mot2, List<Character> ordre) {
	    int minLength = Math.min(mot1.length(), mot2.length());
	    for (int i = 0; i < minLength; i++) {
	        char c1 = Character.toLowerCase(mot1.charAt(i));
	        char c2 = Character.toLowerCase(mot2.charAt(i));
	        int index1 = ordre.indexOf(c1);
	        int index2 = ordre.indexOf(c2);
	        if (index1 != -1 && index2 != -1 && index1 != index2) {
	            return Integer.compare(index1, index2);
	        } else if (index1 == -1 && index2 != -1) {
	            return 1; // mot1 commence par une lettre non pr�sente dans l'ordre
	        } else if (index1 != -1 && index2 == -1) {
	            return -1; // mot2 commence par une lettre non pr�sente dans l'ordre
	        }
	    }
	    return Integer.compare(mot1.length(), mot2.length());
	}

}
