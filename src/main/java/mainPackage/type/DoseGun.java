/*
 * NOT A SABINO'S SAGA - MS_C ©2021
 * This is surely not a Sabino's Saga. Anyway, Sabino is still here...
*/

package mainPackage.type;

/**
 *
 * @author MS_C
 */
public class DoseGun {

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

    // OTHER METHODS
    public boolean isFull() {
        return !(getAmmo() < getMagazine());
    }

    public boolean isEmpty() {
        return !(getAmmo() > 0);
    }

    public boolean addAmmo() {
        if (isFull()) {
            return false;
        } else {
            ++ammo;
            return true;
        }
    }

    public boolean shootAmmo() {
        if (isEmpty()) {
            return false;
        } else {
            --ammo;
            return true;
        }
    }
}
