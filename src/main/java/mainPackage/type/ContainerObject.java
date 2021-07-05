/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mainPackage.type;

/*
        TODO: Mettere dei controlli nell'init del gioco per la rimozione di oggetti
        1) Se il contenitore contiene l'elemento
        2) Se c'è spazio nel tuo inventario
 */
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author MS_C
 */
public class ContainerObject extends GameObject {

    //  ATTRIBUTES
    private boolean open = false;   //  Se è bloccato e necessita di essere aperto con qualcosa

    private List<GameObject> contained = new ArrayList<>();

    //  CONSTRUCTOR
    public ContainerObject(int id, String name, String description, String hint, boolean pickupable, boolean visible, boolean open) {
        super(id, name, description, hint, pickupable, visible);
        this.open = open;
    }

    //  SETTERS
    public void setOpen(boolean open) {
        this.open = open;
    }

    public void setContained(List<GameObject> contained) {
        this.contained = contained;
    }

    //  GETTERS
    public boolean isOpen() {
        return open;
    }

    public List<GameObject> getContained() {
        return contained;
    }

    //  OURS METHODS
    public void add(GameObject o) {
        this.getContained().add(o);
    }

    public void remove(GameObject o) {
        this.getContained().remove(o);
    }

    public boolean contains(GameObject o) {
        return getContained().contains(o);
    }
}
