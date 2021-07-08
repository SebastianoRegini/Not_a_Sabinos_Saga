/*
 * NOT A SABINO'S SAGA - MS_C ©2021
 * This is surely not a Sabino's Saga. Anyway, Sabino is still here...
*/

package mainPackage;

import java.io.File;
import java.util.Scanner;
import java.util.Set;
import mainPackage.game.NASS;
import mainPackage.parser.Parser;
import mainPackage.parser.ParserFilter;
import mainPackage.utilities.UWManager;

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
        
        //  TODO: SABINO DIALOGUE
        
        //  STARTING ROOM
        game.getInRoom().printRoom();
        
        //  MANAGING STARTING GAME
        Scanner in = new Scanner(System.in);
        do{
          String newCommand = in.nextLine();
          ParserFilter filter = parser.parse(newCommand, game.getCommands(), game.getInRoom().getObj(), game.getInRoom().getNpcs(), game.getInventory().getContaining());
          game.nextMove(filter, System.out);
          System.out.println();
        }while(in.hasNextLine());
    }

    public static void main(String[] args) {
        Starter starter = new Starter(new NASS());
        starter.start();
    }

}
