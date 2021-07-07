/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
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

    // CONSTRUCTOR
    public ParserFilter(Command command, GameObject object, GameObject inventoryObj, NPC person) {
        this.command = command;
        this.object = object;
        this.inventoryObj = inventoryObj;
        this.person = person;
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
    
}
