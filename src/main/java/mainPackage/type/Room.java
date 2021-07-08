/*
 * NOT A SABINO'S SAGA - MS_C ©2021
 * This is surely not a Sabino's Saga. Anyway, Sabino is still here...
 */
package mainPackage.type;

import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author MS_C
 */
public class Room {

    //  ATTRIBUTES
    private final int id;

    private final String name;

    private final String prefix;

    private final String suffix;

    private final String descriptionLook;

    private Room north = null;
    private boolean northLock = false;

    private Room south = null;
    private boolean southLock = false;

    private Room east = null;
    private boolean eastLock = false;

    private Room west = null;
    private boolean westLock = false;

    private Room toggleDose = null; //Nella Room normale, sarà la stanza alternativa, nella Dose Room sarà la stanza normale

    private boolean visited = false;

    private final List<GameObject> obj = new ArrayList<>();

    private List<NPC> npcs = new ArrayList<>(); //Rappresenta gli NPC delle stanze adiacenti a this

    //  CONSTRUCTORS
    public Room(int id, String name, String prefix, String suffix, String descriptionLook) {
        this.id = id;
        this.name = name;
        this.prefix = prefix;
        this.suffix = suffix;
        this.descriptionLook = descriptionLook;
    }

    // SETTERS
    public void setNorth(Room north) {
        this.north = north;
    }

    public void setSouth(Room south) {
        this.south = south;
    }

    public void setEast(Room east) {
        this.east = east;
    }

    public void setWest(Room west) {
        this.west = west;
    }

    public void setNorthLock(boolean northLock) {
        this.northLock = northLock;
    }

    public void setSouthLock(boolean southLock) {
        this.southLock = southLock;
    }

    public void setEastLock(boolean eastLock) {
        this.eastLock = eastLock;
    }

    public void setWestLock(boolean westLock) {
        this.westLock = westLock;
    }

    public void setToggleDose(Room toggleDose) {
        this.toggleDose = toggleDose;
    }

    public void setVisited(boolean visited) {
        this.visited = visited;
    }

    // GETTERS
    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getPrefix() {
        return prefix;
    }

    public String getSuffix() {
        return suffix;
    }

    public String getDescriptionLook() {
        return descriptionLook;
    }

    public Room getNorth() {
        return north;
    }

    public boolean isNorthLock() {
        return northLock;
    }

    public Room getSouth() {
        return south;
    }

    public boolean isSouthLock() {
        return southLock;
    }

    public Room getEast() {
        return east;
    }

    public boolean isEastLock() {
        return eastLock;
    }

    public Room getWest() {
        return west;
    }

    public boolean isWestLock() {
        return westLock;
    }

    public Room getToggleDose() {
        return toggleDose;
    }

    public boolean isVisited() {
        return visited;
    }

    public List<GameObject> getObj() {
        return obj;
    }

    public List<NPC> getNpcs() {
        return npcs;
    }

    // OURS METHODS
    public void constructBoundary(Room N, Room S, Room E, Room W, Room D, boolean n, boolean s, boolean e, boolean w) {
        //Limiti nord
        setNorth(N);
        setNorthLock(n);

        //Limiti sud
        setSouth(S);
        setSouthLock(s);

        //Limiti est
        setEast(E);
        setEastLock(e);

        //Limiti ovest
        setWest(W);
        setWestLock(w);

        //Limite alternativo
        setToggleDose(D);
    }

    public void printRoom() {
        if (visited) {
            System.out.println("Sei in " + getName() + ".");
        } else {
            System.out.println(getPrefix() + ". Sei in " + getName() + ". " + getSuffix());
            setVisited(true);
        }
    }

    public void addO(GameObject o) {
        this.getObj().add(o);
    }

    public void removeO(GameObject o) {
        this.getObj().remove(o);
    }

    public void addN(NPC c) {
        this.getNpcs().add(c);
    }

    public void removeN(NPC c) {
        this.getNpcs().remove(c);
    }

    // OVERRIDED METHODS
    @Override
    public int hashCode() {
        int hash = 3;
        hash = 83 * hash + this.id;
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final Room other = (Room) obj;
        if (this.id != other.id) {
            return false;
        }
        return true;
    }

}
