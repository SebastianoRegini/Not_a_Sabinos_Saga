/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mainPackage.type;

/**
 *
 * @author sebre
 */
public class Room {
    
    //  ATTRIBUTES
    private int id;
    private String name;
    private String prefix;
    private String suffix;
    private String description_look;
    private Room north;
    private Room south;
    private Room east;
    private Room west;
    private ExternalInventory in_room;

    //  CONSTRUCTORS
    public Room(){
        
    }
}
