/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
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

    private final String description_look;

    private Room north = null;
    private boolean north_lock = false;

    private Room south = null;
    private boolean south_lock = false;

    private Room east = null;
    private boolean east_lock = false;

    private Room west = null;
    private boolean west_lock = false;

    private Room toggle_dose = null; //Nella Room normale, sarà la stanza alternativa, nella Dose Room sarà la stanza normale

    private boolean visited = false;

    private final List<GameObject> obj = new ArrayList<>();

    //  CONSTRUCTORS
    public Room(int id, String name, String prefix, String suffix, String description_look) {
        this.id = id;
        this.name = name;
        this.prefix = prefix;
        this.suffix = suffix;
        this.description_look = description_look;
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

    public void setNorth_lock(boolean north_lock) {
        this.north_lock = north_lock;
    }

    public void setSouth_lock(boolean south_lock) {
        this.south_lock = south_lock;
    }

    public void setEast_lock(boolean east_lock) {
        this.east_lock = east_lock;
    }

    public void setWest_lock(boolean west_lock) {
        this.west_lock = west_lock;
    }

    public void setToggle_dose(Room toggle_dose) {
        this.toggle_dose = toggle_dose;
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

    public String getDescription_look() {
        return description_look;
    }

    public Room getNorth() {
        return north;
    }

    public boolean isNorth_lock() {
        return north_lock;
    }

    public Room getSouth() {
        return south;
    }

    public boolean isSouth_lock() {
        return south_lock;
    }

    public Room getEast() {
        return east;
    }

    public boolean isEast_lock() {
        return east_lock;
    }

    public Room getWest() {
        return west;
    }

    public boolean isWest_lock() {
        return west_lock;
    }

    public Room getToggle_dose() {
        return toggle_dose;
    }

    public boolean isVisited() {
        return visited;
    }

    public List<GameObject> getObj() {
        return obj;
    }

    // OURS METHODS
    public void constructBoundary(Room N, Room S, Room E, Room W, Room D, boolean n, boolean s, boolean e, boolean w) {
        //Limiti nord
        setNorth(N);
        setNorth_lock(n);

        //Limiti sud
        setSouth(S);
        setSouth_lock(s);

        //Limiti est
        setEast(E);
        setEast_lock(e);

        //Limiti ovest
        setWest(W);
        setWest_lock(w);

        //Limite alternativo
        setToggle_dose(D);
    }

    public void add(GameObject o) {
        this.getObj().add(o);
    }

    public void remove(GameObject o) {
        this.getObj().remove(o);
    }

    public void printRoom() {
        if (visited) {
            System.out.println("Sei in " + getName() + ".");
        } else {
            System.out.println(getPrefix() + ". Sei in " + getName() + ". " + getSuffix());
            setVisited(true);   //  TODO possiamo cambiare -><-
        }
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
