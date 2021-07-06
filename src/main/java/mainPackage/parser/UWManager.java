/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mainPackage.parser;

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

        //  Nuovo insieme per inserire le parole da 
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

    public static List<String> removeWords(String player_comm, Set<String> uselessWords) {
        List<String> usefulWords = new ArrayList<>();
        
        String[] single_words = player_comm.trim().toLowerCase().split("\\W+");
        
        for(String temp : single_words){
            if(!uselessWords.contains(temp)){
                usefulWords.add(temp);
            }
        }
        return usefulWords;
    }
}
