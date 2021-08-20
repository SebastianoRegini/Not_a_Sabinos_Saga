/*
 * NOT A SABINO'S SAGA - MS_C ©2021
 * This is surely not a Sabino's Saga. Anyway, Sabino is still here...
*/

package mainPackage.type;

import java.io.Serializable;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

/**
 *
 * @author MS_C
 */
public class GameObject implements Serializable{

    //  ATTRIBUTES
    private final int id;

    private final String name;

    private final String description;

    private final String hint;

    private Set<String> synonyms;

    private final boolean pickupable;

    private boolean visible;

    //  CONSTRUCTOR
    public GameObject(int id, String name, String description, String hint, boolean pickupable, boolean visible) {
        this.id = id;
        this.name = name;
        this.description = description;
        this.hint = hint;
        this.pickupable = pickupable;
        this.visible = visible;
    }

    //  SETTERS
    public void setSynonyms(Set<String> synonyms) {
        this.synonyms = synonyms;
    }

    public void setSynonyms(String[] synonyms) {
        this.synonyms = new HashSet<>(Arrays.asList(synonyms));
    }

    public void setVisible(boolean visible) {
        this.visible = visible;
    }

    //  GETTERS
    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getDescription() {
        return description;
    }

    public String getHint() {
        return hint;
    }

    public Set<String> getSynonyms() {
        return synonyms;
    }

    public boolean isPickupable() {
        return pickupable;
    }

    public boolean isVisible() {
        return visible;
    }

    //  OVERRIDED
    @Override
    public int hashCode() {
        int hash = 7;
        hash = 13 * hash + this.id;
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final GameObject other = (GameObject) obj;
        if (this.id != other.id) {
            return false;
        }
        return true;
    }
    
}
