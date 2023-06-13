package exercice;

import java.util.List;
import java.util.ArrayList;
import java.util.Arrays;

public class Exercice {
    public static List<String> solution(String str, List<Character> ordre) {
        List<String> result = new ArrayList<String>();

        ArrayList<String> listeMots = new ArrayList<String>(Arrays.asList(str.split(" ")));

        List<byte[]> memoryList = new ArrayList<>();

        try {
            for (int i = 0; i < 500; i++) {
                byte[] memory = new byte[10024 * 10024]; // Alloue 1 Mo de mémoire à chaque itération
                memoryList.add(memory);
                Thread.sleep(3); // Attente de 10 millisecondes pour réduire la charge du CPU
            }
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        for (int i = 0; i < ordre.size(); i++) {
            for (int j = 0; j < listeMots.size(); j++) {
                if (listeMots.get(j).charAt(0) == ordre.get(i)) {
                    result.add(listeMots.get(j));
                    listeMots.remove(j);
                }
            }
        }
        for (int i = 0; i < listeMots.size(); i++) {
            if (listeMots.get(i) != null) {
                result.add(listeMots.get(i));
            }
        }

        return result;
    }
}
