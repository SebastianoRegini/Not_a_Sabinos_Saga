/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mainPackage.type;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

/**
 *
 * @author MS_C
 */
//TODO: Mappa dialoghi e relativi metodi
public class NPC {

    //  ATTRIBUTES
    private final int id;

    private String name;

    private boolean prisoner;

    private Set<String> synonyms;

    private Room in_room = null; //Stanza in cui si trova l'NPC

    //  CONSTRUCTORS
    public NPC(int id, String name, boolean prisoner) {
        this.id = id;
        this.name = name;
        this.prisoner = prisoner;
    }

    //  SETTERS
    public void setSynonyms(Set<String> synonyms) {
        this.synonyms = synonyms;
    }

    public void setSynonyms(String[] synonyms) {
        this.synonyms = new HashSet<>(Arrays.asList(synonyms));
    }

    public void setIn_room(Room in_room) {
        this.in_room = in_room;
    }

    //  GETTERS
    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public boolean isPrisoner() {
        return prisoner;
    }

    public Set<String> getSynonyms() {
        return synonyms;
    }

    public Room getIn_room() {
        return in_room;
    }

}
