/*
 * NOT A SABINO'S SAGA - MS_C ©2021
 * This is surely not a Sabino's Saga. Anyway, Sabino is still here...
 */
package mainPackage.type;

import java.io.Serializable;

/**
 *
 * @author MS_C
 */
public class DoseGun implements Serializable {

    //  ATTRIBUTES
    private final int magazine;
    private int ammo;

    //  CONSTRUCTOR
    public DoseGun(int magazine, int ammo) {
        this.magazine = magazine;
        this.ammo = ammo;
    }

    // GETTERS
    public int getMagazine() {
        return magazine;
    }

    public int getAmmo() {
        return ammo;
    }

    // SETTER
    public void setAmmo(int ammo) {
        this.ammo = ammo;
    }

    // OTHER METHODS
    public boolean isEmpty() {
        return !(getAmmo() > 0);
    }

    public boolean shoot() {
        if (isEmpty()) {
            return false;
        } else {
            --ammo;
            return true;
        }
    }
}
