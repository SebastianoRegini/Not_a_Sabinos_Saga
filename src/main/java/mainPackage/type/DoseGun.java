/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mainPackage.type;

import java.util.LinkedList;
import java.util.Queue;

/**
 *
 * @author MS_C
 */
public class DoseGun {

    //  ATTRIBUTES
    private int ammo;
    private Queue<GameObject> load = new LinkedList<>();

    //  CONSTRUCTOR
    public DoseGun(int ammo) {
        this.ammo = ammo;
    }

    //  UTILITY METHOD
    private boolean isFull() {
        return (load.size() >= ammo);
    }

    //  GETTERS AND SETTERS
    public int getAmmo() {
        return ammo;
    }

    public void setAmmo(int ammo) {
        this.ammo = ammo;
    }

    public Queue<GameObject> getLoad() {
        return load;
    }

    public void setLoad(Queue<GameObject> load) {
        this.load = load;
    }

    //  IN-GAME METHODS
    public void add(GameObject obj) {
        if (!this.isFull()) {
            load.add(obj);
        } else {
            System.out.println("La pistola è piena!");
        }
    }

    public void remove(GameObject obj) {
        if (load.isEmpty()) {
            System.out.println("La pistola è scarica!");
        } else {
            load.remove(obj);
        }
    }
}
