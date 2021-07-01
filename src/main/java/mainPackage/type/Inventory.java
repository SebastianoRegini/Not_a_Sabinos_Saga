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
public class Inventory extends ExternalInventory{
    
    //  ATTRIBUTES
    private int id = -1;

    //  CONSTRUCTOR
    public Inventory(int slots, GameObject[] list, int id) {
        super(slots, list);
        this.id = id;
    }

    //  GETTERS AND SETTERS
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    //  IN-GAME METHODS
    public void add(GameObject obj) {

    }
}
