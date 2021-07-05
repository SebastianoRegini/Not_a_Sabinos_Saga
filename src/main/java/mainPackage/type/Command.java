/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mainPackage.type;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Objects;
import java.util.Set;

/**
 *
 * @author MS_C
 */
public class Command {
    
    //  ATTRIBUTES
    private final TypeCommand type;
    private Set<String> synonyms;

    //  CONSTRUCTORS
    public Command(TypeCommand type) {
        this.type = type;
    }

    //  GETTERS
    public TypeCommand getType() {
        return type;
    }

    public Set<String> getSynonyms() {
        return synonyms;
    }

    //  SETTERS
    public void setSynonyms(Set<String> synonyms) {
        this.synonyms = synonyms;
    }
    
    public void setSynonyms(String[] synonyms) {
        this.synonyms = new HashSet<>(Arrays.asList(synonyms));
    }
    
    //  OVERRIDES

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 89 * hash + Objects.hashCode(this.type);
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
        final Command other = (Command) obj;
        if (this.type != other.type) {
            return false;
        }
        return true;
    }

    
}