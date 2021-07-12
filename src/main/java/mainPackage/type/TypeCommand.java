/*
 * NOT A SABINO'S SAGA - MS_C ©2021
 * This is surely not a Sabino's Saga. Anyway, Sabino is still here...
 */
package mainPackage.type;

/**
 *
 * @author MS_C
 */
public enum TypeCommand {

    NORTH(1),
    SOUTH(2),
    EAST(3),
    WEST(4),
    OPEN(5),
    CLOSE(6),
    INVENTORY(7),
    PICK_UP(8),
    DROP(9),
    USE(10),
    GIVE(11),
    LOOK(12),
    INTERACT(13),
    THINK_ABOUT(14),
    DOSE(15), //Comando esclusivo per la dose e la pistola per dosi
    SAVE(16),
    LOAD(17),
    END(18);
     

    private final int code;

    TypeCommand(int code) {
        this.code = code;
    }

    public int getTypeCode() {
        return code;
    }
}
