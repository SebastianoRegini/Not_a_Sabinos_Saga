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
public class ExternalInventory {
    
    //  ATTRIBUTES
    private int slots = 0;
    private GameObject[] list;

    // CONSTRUCTOR
    public ExternalInventory(int slots, GameObject[] list) {
        this.slots = slots;
        this.list = list;
    }

    //  GETTERS AND SETTERS
    public int getSlots() {
        return slots;
    }

    public void setSlots(int slots) {
        this.slots = slots;
    }

    public GameObject[] getList() {
        return list;
    }

    public void setList(GameObject[] list) {
        this.list = list;
    }

    //  IN-GAME METHODS
    public void remove(GameObject obj){
        
    }
}
