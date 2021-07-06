/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mainPackage.parser;

import java.util.HashSet;
import java.util.List;
import java.util.Set;
import mainPackage.type.Command;
import mainPackage.type.GameObject;
import mainPackage.type.NPC;

/**
 *
 * @author MS_C
 */
public class Parser {

    //  ATTRIBUTES
    private Set<String> uselessWords;

    //  METHODS
    //  Recognize things
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

    private int whatNPC(String token, List<NPC> NPCs) {
        for (int i = 0; i < NPCs.size(); i++) {
            if (NPCs.get(i).getName().equalsIgnoreCase(token) || NPCs.get(i).getSynonyms().contains(token)) {
                return i;
            }
        }
        return -1;
    }

    //  Parse
    public ParserFilter parse(String player_comm, List<Command> commands, List<GameObject> ext_obj, List<NPC> NPCs, List<GameObject> inventory) {
        List<String> filteredWords = UWManager.removeWords(player_comm, uselessWords);

        if (!filteredWords.isEmpty()) {
            return null;
            
        } else {
            return null;
        }
    }
}

//  GESTIAMO I SEGUENTI COMANDI
/*
     <comando> <oggetto>
     <comando> <oggettoInventario>
     <comando> <oggettoInentario> <NPC>
     <comando> <oggettoInventario> <oggetto>
*/