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
public class Inventory {

    //  ATTRIBUTES
    private int slots;

    private List<GameObject> containing = new ArrayList<>();

    //  CONSTRUCTOR
    public Inventory(int slots) {
        this.slots = slots;
    }

    //  SETTERS
    public void setSlots(int slots) {
        this.slots = slots;
    }

    public void setContaining(List<GameObject> containing) {
        this.containing = containing;
    }

    //  GETTERS
    public int getSlots() {
        return slots;
    }

    public List<GameObject> getContaining() {
        return containing;
    }

    //  UTILITY METHOD
    private boolean isFull() {
        return (containing.size() >= slots);
    }

    //  IN-GAME METHODS
    public void expand(int otherSlots) {
        setSlots(this.slots + otherSlots);
    }

    public void add(GameObject obj) {
        if (!this.isFull()) {
            containing.add(obj);
        } else {
            System.out.println("L'inventario è pieno!");
        }
    }

    public void remove(GameObject obj) {
        if (containing.isEmpty()) {
            System.out.println("L'inventario è vuoto!");
        } else {
            if (containing.contains(obj)) {
                containing.remove(obj);
            } else {
                System.out.println("L'elemento non è presente nell'inventario!");
            }
        }
    }
}
