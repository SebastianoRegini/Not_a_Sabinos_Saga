/*
 * NOT A SABINO'S SAGA - MS_C ©2021
 * This is surely not a Sabino's Saga. Anyway, Sabino is still here...
*/

package mainPackage.parser;

import mainPackage.type.Command;
import mainPackage.type.GameObject;
import mainPackage.type.NPC;

/**
 *
 * @author MS_C
 */
public class ParserFilter {
    
    private Command command;
    
    private GameObject object;
    
    private GameObject inventoryObj;
    
    private NPC person;
    
    private String extraWord;
    
    //TODO: Ci può essere utile un ExtraWords per stringhe che non sono stopwords

    // CONSTRUCTOR
    public ParserFilter(Command command, GameObject object, GameObject inventoryObj, NPC person, String extraWord) {
        this.command = command;
        this.object = object;
        this.inventoryObj = inventoryObj;
        this.person = person;
        this.extraWord = extraWord;
    }
    
    // SETTERS
    public void setCommand(Command command) {
        this.command = command;
    }

    public void setObject(GameObject object) {
        this.object = object;
    }

    public void setInventoryObj(GameObject inventoryObj) {
        this.inventoryObj = inventoryObj;
    }

    public void setPerson(NPC person) {
        this.person = person;
    }

    public void setExtraWord(String extraWord) {
        this.extraWord = extraWord;
    }

    // GETTERS
    public Command getCommand() {
        return command;
    }

    public GameObject getObject() {
        return object;
    }

    public GameObject getInventoryObj() {
        return inventoryObj;
    }

    public NPC getPerson() {
        return person;
    }
    
    public String getExtraWord() {
        return extraWord;
    }
    
}
