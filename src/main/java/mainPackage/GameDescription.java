/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mainPackage;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import mainPackage.parser.ParserFilter;
import mainPackage.type.Command;
import mainPackage.type.GameObject;
import mainPackage.type.Inventory;
import mainPackage.type.Room;

/**
 *
 * @author MS_C
 */
public abstract class GameDescription {

    //  ATTRIBUTES
    private List<Room> rooms = new ArrayList<>();

    private List<Command> commands = new ArrayList<>();

    private Inventory inventory;

    private Room in_room;

    //  SETTERS
    public void setIn_room(Room in_room) {
        this.in_room = in_room;
    }

    //  GETTERS
    public List<Room> getRooms() {
        return rooms;
    }

    public List<Command> getCommands() {
        return commands;
    }

    public Inventory getInventory() {
        return inventory;
    }

    public Room getIn_room() {
        return in_room;
    }

    //  ABSTRACT METHODS
    public abstract void init();
    
    public abstract void nextMove(ParserFilter funnel);
    //TODO: Capire se usare PrintStream o altro
}
