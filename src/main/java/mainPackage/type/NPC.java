/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mainPackage.type;

import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

/**
 *
 * @author MS_C
 */
public class NPC {

    //  ATTRIBUTES
    private final int id;

    private final String name;

    private Set<String> synonyms;
    
    private final Map<Integer, String> interactions = new HashMap<>();

    //  CONSTRUCTORS
    public NPC(int id, String name, boolean prisoner) {
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
    
    //  OTHER METHODS
    public void putInteraction(Integer index, String dialogue){
        getInteractions().put(index, dialogue);
    }
    
    public String getInteraction(Integer index){
        return getInteractions().get(index);
    }
    
}
