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
public enum TypeCommand implements Serializable{

    NORTH(1),
    SOUTH(2),
    EAST(3),
    WEST(4),
    OPEN(5),
    INVENTORY(6),
    PICK_UP(7),
    DROP(8),
    USE(9),
    GIVE(10),
    EXAMINE(11),
    INTERACT(12),
    THINK_ABOUT(13),
    DOSE(14), //Comando esclusivo per la dose e la pistola per dosi
    SAVE(15),
    LOAD(16),
    END(17),
    HELP(18),
    LOOK(19);
     

    private final int code;

    TypeCommand(int code) {
        this.code = code;
    }

    public int getTypeCode() {
        return code;
    }
}
