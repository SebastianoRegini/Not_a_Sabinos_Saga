/*
 * NOT A SABINO'S SAGA - MS_C ©2021
 * This is surely not a Sabino's Saga. Anyway, Sabino is still here...
*/

package mainPackage.utilities;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 *
 * @author MS_C
 */
public class UWManager {

    public static Set<String> loadWords(File fW) {

        //  Nuovo insieme per inserire le parole da non considerare
        Set<String> setWords = new HashSet<>();

        try {
            BufferedReader br = new BufferedReader(new FileReader(fW));
            try {
                //  Il metodo ready controlla se il file non è vuoto
                while (br.ready()) {
                    setWords.add(br.readLine().trim().toLowerCase());
                }
                br.close();
            } catch (IOException ex) {
                System.err.println("Errore nella lettura da file: " + ex.getMessage());
            }
        } catch (FileNotFoundException fex) {
            System.err.println("Errore nel caricamento del file: " + fex.getMessage());
        }
        return setWords;
    }

    public static List<String> removeWords(String playerComm, Set<String> uselessWords) {
        List<String> usefulWords = new ArrayList<>();
        
        String[] singleWords = playerComm.trim().toLowerCase().split("[\\W&&[^#]]");
        
        for(String temp : singleWords){
            if(!uselessWords.contains(temp)){ 
               usefulWords.add(temp);
            }
        }
        return usefulWords;
    }
}
