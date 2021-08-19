/*
 * NOT A SABINO'S SAGA - MS_C ©2021
 * This is surely not a Sabino's Saga. Anyway, Sabino is still here...
 */
package mainPackage;

import java.io.IOException;
import java.io.PrintStream;
import java.io.Serializable;
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
public abstract class GameDescription implements Serializable {

    //  ATTRIBUTES
    //  Non inseriamo la lista degli NPC  e degli oggetti/oggetti contenitori
    //  perché verranno piazzati tutti nelle stanze o negli
    //  oggetti contenitori
    private boolean saved = true;

    private final List<Room> rooms = new ArrayList<>();

    private final List<Command> commands = new ArrayList<>();

    private Inventory inventory;

    private Inventory alternativeInventory;

    private Room inRoom;

    //  SETTERS
    public void setSaved(boolean saved) {
        this.saved = saved;
    }

    public void setInRoom(Room inRoom) {
        this.inRoom = inRoom;
    }

    public void setInventory(Inventory inventory) {
        this.inventory = inventory;
    }

    public void setAlternativeInventory(Inventory alternativeInventory) {
        this.alternativeInventory = alternativeInventory;
    }

    //  GETTERS
    public boolean isSaved() {
        return saved;
    }

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

    public Inventory getAlternativeInventory() {
        return alternativeInventory;
    }

    //  ABSTRACT METHODS
    public abstract void init() throws SQLException;

    public abstract void nextMove(ParserFilter funnel, PrintStream out);

    public abstract void printStart(PrintStream out);

    public abstract void save(PrintStream out) throws IOException;

    public abstract GameDescription load(PrintStream out) throws IOException, ClassNotFoundException;

    public abstract void gameOver(PrintStream out, int messageCode);

    public abstract void help(PrintStream out);
}
