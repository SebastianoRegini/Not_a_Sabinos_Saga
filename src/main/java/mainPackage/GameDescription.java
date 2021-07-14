/*
 * NOT A SABINO'S SAGA - MS_C ©2021
 * This is surely not a Sabino's Saga. Anyway, Sabino is still here...
 */
package mainPackage;

import java.io.IOException;
import java.io.PrintStream;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import mainPackage.parser.ParserFilter;
import mainPackage.type.Command;
import mainPackage.type.Inventory;
import mainPackage.type.Room;

/**
 *
 * @author MS_C
 */
public abstract class GameDescription {

    //  ATTRIBUTES
    //  Non inseriamo la lista degli oggetti/oggetti contenitori
    //  perché verranno piazzati tutti nelle stanze o negli
    //  oggetti contenitori
    private final List<Room> rooms = new ArrayList<>();

    private final List<Command> commands = new ArrayList<>();

    private Inventory inventory;

    private Room inRoom;

    //  SETTERS
    public void setInRoom(Room inRoom) {
        this.inRoom = inRoom;
    }

    public void setInventory(Inventory inventory) {
        this.inventory = inventory;
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

    public Room getInRoom() {
        return inRoom;
    }

    //  ABSTRACT METHODS
    public abstract void init() throws SQLException;

    public abstract void nextMove(ParserFilter funnel, PrintStream out);

    public abstract void printStart();

    public abstract boolean save() throws IOException;

    public abstract GameDescription load() throws IOException, ClassNotFoundException;
    
    public abstract void printEnd();
    
    public abstract void gameOver();
    
    public abstract void help() throws InterruptedException;

    //  TODO Inserire metodo astratto per l'epilogo, con vari messaggi a seconda dello score finale
}
