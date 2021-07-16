/*
 * NOT A SABINO'S SAGA - MS_C ©2021
 * This is surely not a Sabino's Saga. Anyway, Sabino is still here...
 */
package mainPackage;

import java.io.File;
import java.io.IOException;
import java.sql.SQLException;
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
    private GameDescription game;
    private Parser parser;

    public Starter(GameDescription game) {

        //  Game initialization
        this.game = game;
        try {
            this.game.init();
        } catch (SQLException sql) {
            System.err.println("Init SQL Error: " + sql.getMessage());
        }

        //  Parser initialization
        Set<String> uselessWords = UWManager.loadWords(new File("./resources/UselessWords.dat"));
        parser = new Parser(uselessWords);
    }

    public void start() {

        //  GAME INTRO
        game.printStart(System.out);

        //  STARTING ROOM
        game.getInRoom().printRoom();

        //  MANAGING STARTING GAME
        Scanner in = new Scanner(System.in);
        do {
            String newCommand = in.nextLine();

            ParserFilter filter;

            if (game.getInRoom().getId() < 19) {
                filter = parser.parse(newCommand, game.getCommands(), game.getInRoom().getObj(), game.getInRoom().getNpcs(), game.getInventory().getContaining());
            } else {
                filter = parser.parse(newCommand, game.getCommands(), game.getInRoom().getObj(), game.getInRoom().getNpcs(), game.getAlternativeInventory().getContaining());
            }

            //Controllo END, SAVE, LOAD
            if (filter.getCommand() != null) {
                switch (filter.getCommand().getType()) {
                    case SAVE: 
                        try {
                        if (game.isSaved()) {
                            System.out.println("----------------------------------------");
                            System.out.println("Non ci sono modifiche da salvare.");
                        } else {
                            game.save();
                            System.out.println("----------------------------------------");
                            System.out.println("Partita salvata correttamente!");
                        }
                    } catch (IOException ex) {
                        System.err.println("Errore nel salvataggio della partita: " + ex.getMessage());
                    }

                    break;

                    case LOAD:

                        boolean load = true;

                        if (!game.isSaved()) {
                            System.out.println("Ci sono modifiche non salvate, vuoi caricare lo stesso? [Si,No]");
                            String carica = in.nextLine();
                            if (carica.equalsIgnoreCase("NO")) {
                                load = false;
                            } else if (!carica.equalsIgnoreCase("SI")) {
                                System.out.println("Onestamente, non ho capito se vuoi caricare o meno...");
                            }
                        }

                        if (load) {
                            try {
                                game = game.load();
                                System.out.println("----------------------------------------");
                                System.out.println("Partita caricata correttamente!\n");
                                game.getInRoom().printRoom();
                            } catch (IOException | ClassNotFoundException ex) {
                                System.err.println("Errore nel caricamento della partita: " + ex.getMessage());
                            }
                        }
                        break;

                    case END:

                        boolean exit = true;

                        if (!game.isSaved()) {
                            System.out.println("Ci sono modifiche non salvate, vuoi uscire lo stesso? [Si,No]");
                            String esci = in.nextLine();
                            if (esci.equalsIgnoreCase("NO")) {
                                exit = false;

                            } else if (!esci.equalsIgnoreCase("SI")) {
                                System.out.println("Onestamente, non ho capito se vuoi uscire o meno...");
                            }
                        }

                        if (exit) {
                            System.out.println("Arrivederci!");

                            try {
                                Thread.sleep(1000);
                            } catch (InterruptedException ex) {
                                System.err.println("Cavolo, ci siamo messi in attesa per farti leggere l'Arrivederci, ma nemmeno questo ha funzionato...\n Errore: " + ex.getMessage());
                            }

                            System.exit(0);
                        }

                        break;

                    default:
                        game.nextMove(filter, System.out);
                        break;
                }
            } else {
                System.out.println("Non hai messo un comando valido!");
            }

        } while (in.hasNextLine());
    }

    public static void main(String[] args) {
        Starter starter = new Starter(new NASS());
        starter.start();
    }

}
