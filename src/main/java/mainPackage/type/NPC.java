/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mainPackage.type;

/**
 *
 * @author sebre
 */
public class NPC {
    
    //  ATTRIBUTES
    private ExternalInventory inv;
    
    //  CONSTRUCTORS
    public NPC() {
    }

    public NPC(ExternalInventory inv) {
        this.inv = inv;
    }
    
    //  IN-GAME METHODS
    public void dialog(){
        //TODO: possibile cambiamento di tipo da restituire
    }
}
