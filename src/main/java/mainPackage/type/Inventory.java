/*
 * NOT A SABINO'S SAGA - MS_C ©2021
 * This is surely not a Sabino's Saga. Anyway, Sabino is still here...
 */
package mainPackage.type;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author MS_C
 */
public class Inventory implements Serializable{

    //  ATTRIBUTES
    private final int slots;

    private List<GameObject> containing = new ArrayList<>();

    //  CONSTRUCTOR
    public Inventory(int slots) {
        this.slots = slots;
    }

    //  SETTERS
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
    public boolean isFull() {
        return (containing.size() >= slots);
    }

    public boolean isEmpty() {
        return (containing.isEmpty());
    }

    //  IN-GAME METHODS
    public void add(GameObject obj) {
        containing.add(obj);
    }

    public void remove(GameObject obj) {
            containing.remove(obj);
    }
    
    public boolean contains(GameObject obj){
        return containing.contains(obj);
    }
}
