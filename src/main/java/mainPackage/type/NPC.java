/*
 * NOT A SABINO'S SAGA - MS_C ©2021
 * This is surely not a Sabino's Saga. Anyway, Sabino is still here...
 */
package mainPackage.type;

import java.io.Serializable;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

/**
 *
 * @author MS_C
 */
public class NPC implements Serializable{

    //  ATTRIBUTES
    private final int id;

    private final String name;

    private Set<String> synonyms;

    private Map<Integer, String> interactions;

    //  CONSTRUCTOR
    public NPC(int id, String name) {
        this.id = id;
        this.name = name;
    }

    //  SETTERS
    public void setSynonyms(Set<String> synonyms) {
        this.synonyms = synonyms;
    }

    public void setSynonyms(String[] synonyms) {
        this.synonyms = new HashSet<>(Arrays.asList(synonyms));
    }

    public void setInteractions(Map<Integer, String> interactions) {
        this.interactions = interactions;
    }

    //  GETTERS
    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public Set<String> getSynonyms() {
        return synonyms;
    }

    public Map<Integer, String> getInteractions() {
        return interactions;
    }

    //  OTHER METHOD
    public String getInteraction(Integer index) {
        return getInteractions().get(index);
    }

}
