/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mainPackage;

import java.io.File;
import java.io.IOException;
import java.util.Set;
import mainPackage.parser.Parser;
import mainPackage.parser.UWManager;

/**
 *
 * @author MS_C
 */
public class Starter {

    //  ATTRIBUTES
    private final GameDescription game;
    private Parser parser;

    public Starter(GameDescription game) {

        //  Game initialization
        this.game = game;
        //  TODO gestire l'errore (probabilmente SQLEXCEPTION)
        this.game.init();

        //  Parser initialization
            Set<String> uselessWords = UWManager.loadWords(new File("./resources/UselessWords.dat"));
            parser = new Parser(uselessWords);
    }
    
    public void start(){
        
        //  GAME INTRO
        game.printStart();
        
        //  SABINO DIALOGUE
        
        //  STARTING ROOM
        game.getInRoom().printRoom();
        
    }

    public static void main(String[] args) {

    }

}
