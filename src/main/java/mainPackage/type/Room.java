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
    
    private Room south = null;
    
    private Room east = null;
    
    private Room west = null;
    
    private Room dose = null;
    
    private boolean accessible = false;
    
    private final List<GameObject> obj = new ArrayList<>();
   
    //  CONSTRUCTORS

    public Room(int id, String name, String prefix, String suffix, String description_look, Room north, Room south, Room east, Room west) {
        this.id = id;
        this.name = name;
        this.prefix = prefix;
        this.suffix = suffix;
        this.description_look = description_look;
        this.north = north;
        this.south = south;
        this.east = east;
        this.west = west;
    }
    
    
}
