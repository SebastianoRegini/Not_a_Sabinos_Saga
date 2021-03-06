/*
 * NOT A SABINO'S SAGA - MS_C ©2021
 * This is surely not a Sabino's Saga. Anyway, Sabino is still here...
 */
package mainPackage.parser;

import java.util.List;
import java.util.Set;
import mainPackage.type.Command;
import mainPackage.type.GameObject;
import mainPackage.type.NPC;
import mainPackage.utilities.UWManager;

/**
 *
 * @author MS_C
 */
public class Parser {

    //  ATTRIBUTES
    private final Set<String> uselessWords;

    //  CONSTRUCTOR
    public Parser(Set<String> uselessWords) {
        this.uselessWords = uselessWords;
    }

    //  METHODS
    private int whatCommand(String token, List<Command> commands) {
        for (int i = 0; i < commands.size(); i++) {
            if (commands.get(i).getSynonyms().contains(token)) {
                return i;
            }
        }
        return -1;
    }

    private int whatObject(String token, List<GameObject> objects) {
        for (int i = 0; i < objects.size(); i++) {
            if (objects.get(i).getName().equalsIgnoreCase(token) || objects.get(i).getSynonyms().contains(token)) {
                return i;
            }
        }
        return -1;
    }

    private int whatNPC(String token, List<NPC> npcs) {
        for (int i = 0; i < npcs.size(); i++) {
            if (npcs.get(i).getName().equalsIgnoreCase(token) || npcs.get(i).getSynonyms().contains(token)) {
                return i;
            }
        }
        return -1;
    }

    public ParserFilter parse(String playerComm, List<Command> commands, List<GameObject> extObj, List<NPC> npcs, List<GameObject> inventory) {
        List<String> filteredWords = UWManager.removeWords(playerComm, uselessWords);

        if (!filteredWords.isEmpty()) {
            int commandIndex = whatCommand(filteredWords.get(0), commands);
            if (commandIndex > -1) {
                if (filteredWords.size() > 1) {
                    //Istanziazione variabili indice
                    int objectIndex;
                    int npcIndex;
                    int inventoryIndex;

                    //Controllo Oggetto
                    objectIndex = whatObject(filteredWords.get(1), extObj);
                    if (objectIndex > -1) {
                        return new ParserFilter(commands.get(commandIndex), extObj.get(objectIndex), null, null, null);
                    }

                    //Controllo NPC
                    npcIndex = whatNPC(filteredWords.get(1), npcs);
                    if (npcIndex > -1) {
                        if (filteredWords.size() > 2) {

                            //Controllo NPC+OggettoInventario
                            inventoryIndex = whatObject(filteredWords.get(2), inventory);
                            if (inventoryIndex > -1) {
                                return new ParserFilter(commands.get(commandIndex), null, inventory.get(inventoryIndex), npcs.get(npcIndex), null);
                            } else {
                                return new ParserFilter(commands.get(commandIndex), null, null, npcs.get(npcIndex), null);
                            }
                        } else {
                            return new ParserFilter(commands.get(commandIndex), null, null, npcs.get(npcIndex), null);
                        }
                    }

                    //Controllo OggettoInventario
                    inventoryIndex = whatObject(filteredWords.get(1), inventory);
                    if (inventoryIndex > -1) {
                        if (filteredWords.size() > 2) {

                            //Controllo OggettoInventario+Oggetto
                            objectIndex = whatObject(filteredWords.get(2), extObj);
                            if (objectIndex > -1) {
                                return new ParserFilter(commands.get(commandIndex), extObj.get(objectIndex), inventory.get(inventoryIndex), null, null);

                            } else if ((npcIndex = whatNPC(filteredWords.get(2), npcs)) > -1) {

                                //Controllo OggettoInventario+NPC
                                return new ParserFilter(commands.get(commandIndex), null, inventory.get(inventoryIndex), npcs.get(npcIndex), null);

                            } else {
                                return new ParserFilter(commands.get(commandIndex), null, inventory.get(inventoryIndex), null, null);
                            }
                        } else {
                            return new ParserFilter(commands.get(commandIndex), null, inventory.get(inventoryIndex), null, null);
                        }
                    }

                    //  Ritorno nel caso in cui non ricopra nessuna delle categorie
                    //  Cattura parola extra
                    return new ParserFilter(commands.get(commandIndex), null, null, null, filteredWords.get(1));

                } else {
                    return new ParserFilter(commands.get(commandIndex), null, null, null, null);
                }
            } else {
                return new ParserFilter(null, null, null, null, null);
            }
        } else {
            return new ParserFilter(null, null, null, null, null);
        }
    }
}

/*  GESTIAMO I SEGUENTI COMANDI
     <comando>
     <comando> <NPC>
     <comando> <NPC> <oggettoInventario>
     <comando> <oggetto>
     <comando> <oggettoInventario>
     <comando> <oggettoInventario> <NPC>
     <comando> <oggettoInventario> <oggetto>
 */
