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

    //  GETTERS AND SETTERS
    public int getSlots() {
        return slots;
    }

    public void setSlots(int slots) {
        this.slots = slots;
    }

    public List<GameObject> getContaining() {
        return containing;
    }

    public void setContaining(List<GameObject> containing) {
        this.containing = containing;
    }

    //  IN-GAME METHODS
    public void expand(int otherSlots) {
        setSlots(this.slots + otherSlots);
    }

    private boolean isFull() {
        return (containing.size() >= slots);
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
