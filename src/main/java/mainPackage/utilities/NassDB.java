/*
 * NOT A SABINO'S SAGA - MS_C ©2021
 * This is surely not a Sabino's Saga. Anyway, Sabino is still here...
 */
package mainPackage.utilities;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Properties;
import java.util.Set;
import mainPackage.type.Command;
import mainPackage.type.ContainerObject;
import mainPackage.type.GameObject;
import mainPackage.type.NPC;
import mainPackage.type.Room;
import mainPackage.type.TypeCommand;

/**
 *
 * @author MS_C
 */
public class NassDB {

    //  ATTRIBUTES
    private static Connection connection;
    
    //  Stringa di connessione
    private static final String CONNECTION_STRING = "jdbc:h2:./resources/dbNASS";

    //  Stringhe di SELECT
    //  Comandi
    private static final String SELECT_COMMAND_TYPES = "SELECT DISTINCT type FROM command";

    //  Stanze e Confini
    private static final String SELECT_ROOM = "SELECT * FROM room WHERE id=";
    private static final String SELECT_BOUNDARY = "SELECT * FROM nswe WHERE id=";

    //  Oggetti e collocazione
    private static final String SELECT_OBJECT = "SELECT * FROM object WHERE id=";
    private static final String SELECT_OB_ROOM = "SELECT idObject FROM ro WHERE idRoom=";
    private static final String SELECT_CON_ROOM = "SELECT idContainer FROM rc WHERE idRoom=";
    private static final String SELECT_CONTAINER = "SELECT * FROM container WHERE id=";
    private static final String SELECT_OB_CONT = "SELECT idObject FROM oc WHERE idContainer=";

    //  NPC
    private static final String SELECT_NPC = "SELECT * FROM npc WHERE id=";
    private static final String SELECT_DIALOG = "SELECT idDialog,dialogText FROM npcDialog WHERE idNpc=";
    private static final String SELECT_NPC_ROOM = "SELECT idNpc FROM rn WHERE idRoom=";

    //  Alias
    private static final String SELECT_COMMAND_ALIASES = "SELECT alias FROM command WHERE type=";
    private static final String SELECT_OBJECT_ALIASES = "SELECT alias FROM aliasObject WHERE idObject=";
    private static final String SELECT_CONTAINER_ALIASES = "SELECT alias FROM aliasContainer WHERE id=";
    private static final String SELECT_NPC_ALIASES = "SELECT alias FROM aliasNpc WHERE id=";

    //  METHODS
    //  Gestione Connessione
    public static void connectDB() throws SQLException {
        Properties dbProp = new Properties();
        dbProp.setProperty("user", "Sabino");
        dbProp.setProperty("password", "Ciampa");
        connection = DriverManager.getConnection(CONNECTION_STRING, dbProp);
    }

    //  Gestione Disconnessione
    public static void disconnectDB() throws SQLException {
        if (connection != null) {
            connection.close();
        }
    }

    //  Recupero da DB
    //  Comandi
    public static void initCommands(List<Command> commands) throws SQLException {
        List<Integer> typeCodes = new ArrayList<>();

        //  Recupero i codici dei tipi da DB
        PreparedStatement pstm = connection.prepareStatement(SELECT_COMMAND_TYPES);
        ResultSet rs = pstm.executeQuery();

        while (rs.next()) {
            typeCodes.add(rs.getInt(1));
        }

        rs.close();
        pstm.close();

        /*  Per ogni codice recuperato, associo il codice di TypeCommand
         *  e costruisco il comando, associando il relativo Set di Alias
        */
        for (Integer code : typeCodes) {
            try {
                Set<String> aliases = selectAliases(SELECT_COMMAND_ALIASES, code);

                if (code == TypeCommand.NORTH.getTypeCode()) { //Se il codice è del comando NORD

                    Command north = new Command(TypeCommand.NORTH);
                    north.setSynonyms(aliases);
                    commands.add(north);

                } else if (code == TypeCommand.SOUTH.getTypeCode()) { //Se il codice è del comando SUD

                    Command south = new Command(TypeCommand.SOUTH);
                    south.setSynonyms(aliases);
                    commands.add(south);

                } else if (code == TypeCommand.EAST.getTypeCode()) { //Se il codice è del comando EST

                    Command east = new Command(TypeCommand.EAST);
                    east.setSynonyms(aliases);
                    commands.add(east);

                } else if (code == TypeCommand.WEST.getTypeCode()) { //Se il codice è del comando OVEST

                    Command west = new Command(TypeCommand.WEST);
                    west.setSynonyms(aliases);
                    commands.add(west);

                } else if (code == TypeCommand.OPEN.getTypeCode()) { //Se il codice è del comando APRI

                    Command open = new Command(TypeCommand.OPEN);
                    open.setSynonyms(aliases);
                    commands.add(open);

                } else if (code == TypeCommand.INVENTORY.getTypeCode()) { //Se il codice è del comando INVENTARIO

                    Command inventory = new Command(TypeCommand.INVENTORY);
                    inventory.setSynonyms(aliases);
                    commands.add(inventory);

                } else if (code == TypeCommand.PICK_UP.getTypeCode()) { //Se il codice è del comando PRENDI

                    Command pick = new Command(TypeCommand.PICK_UP);
                    pick.setSynonyms(aliases);
                    commands.add(pick);

                } else if (code == TypeCommand.DROP.getTypeCode()) { //Se il codice è del comando LASCIA

                    Command drop = new Command(TypeCommand.DROP);
                    drop.setSynonyms(aliases);
                    commands.add(drop);

                } else if (code == TypeCommand.USE.getTypeCode()) { //Se il codice è del comando USA

                    Command use = new Command(TypeCommand.USE);
                    use.setSynonyms(aliases);
                    commands.add(use);

                } else if (code == TypeCommand.GIVE.getTypeCode()) { //Se il codice è del comando DAI

                    Command give = new Command(TypeCommand.GIVE);
                    give.setSynonyms(aliases);
                    commands.add(give);

                } else if (code == TypeCommand.EXAMINE.getTypeCode()) { //Se il codice è del comando ESAMINA

                    Command examine = new Command(TypeCommand.EXAMINE);
                    examine.setSynonyms(aliases);
                    commands.add(examine);

                } else if (code == TypeCommand.INTERACT.getTypeCode()) { //Se il codice è del comando INTERAGISCI

                    Command interact = new Command(TypeCommand.INTERACT);
                    interact.setSynonyms(aliases);
                    commands.add(interact);

                } else if (code == TypeCommand.THINK_ABOUT.getTypeCode()) { //Se il codice è del comando RIFLETTI

                    Command think = new Command(TypeCommand.THINK_ABOUT);
                    think.setSynonyms(aliases);
                    commands.add(think);

                } else if (code == TypeCommand.DOSE.getTypeCode()) { //Se il codice è del comando DOSE

                    Command dose = new Command(TypeCommand.DOSE);
                    dose.setSynonyms(aliases);
                    commands.add(dose);

                } else if (code == TypeCommand.SAVE.getTypeCode()) { //Se il codice è del comando SALVA

                    Command save = new Command(TypeCommand.SAVE);
                    save.setSynonyms(aliases);
                    commands.add(save);

                } else if (code == TypeCommand.LOAD.getTypeCode()) { //Se il codice è del comando CARICA

                    Command load = new Command(TypeCommand.LOAD);
                    load.setSynonyms(aliases);
                    commands.add(load);

                } else if (code == TypeCommand.END.getTypeCode()) { //Se il codice è del comando FINE

                    Command end = new Command(TypeCommand.END);
                    end.setSynonyms(aliases);
                    commands.add(end);

                } else if (code == TypeCommand.HELP.getTypeCode()) { //Se il codice è del comando AIUTO

                    Command help = new Command(TypeCommand.HELP);
                    help.setSynonyms(aliases);
                    commands.add(help);
                    
                } else if (code == TypeCommand.LOOK.getTypeCode()) { //Se il codice è del comando GUARDA

                    Command look = new Command(TypeCommand.LOOK);
                    look.setSynonyms(aliases);
                    commands.add(look);

                }
            } catch (SQLException ex) {
                System.err.println("SQL Error: " + ex.getMessage());
            }

        }
    }

    //  Stanze
    public static Room initRoom(int idRoom, List<Room> map) throws SQLException {
        PreparedStatement pstm = connection.prepareStatement(SELECT_ROOM + idRoom);
        ResultSet rs = pstm.executeQuery();
        Room r = null;
        
        while (rs.next()) {
            r = new Room(rs.getInt(1), rs.getString(2).trim(), rs.getString(3).trim(), rs.getString(4).trim(), rs.getString(5).trim());
            map.add(r);
        }

        rs.close();
        pstm.close();

        return r;

    }

    //  Confini della mappa
    public static void initBoundaries(Room r, List<Room> map) throws SQLException {
        //  Sono inizializzate a -2 in quanto nel DB il -1 indica che la stanza non ha adiacenza in quella direzione
        int idN = -2;
        int idS = -2;
        int idW = -2;
        int idE = -2;
        int idTD = -2;

        PreparedStatement pstm = connection.prepareStatement(SELECT_BOUNDARY + r.getId());
        ResultSet rs = pstm.executeQuery();
        while (rs.next()) {
            idN = rs.getInt(2);
            r.setNorthLock(rs.getBoolean(3));
            idS = rs.getInt(4);
            r.setSouthLock(rs.getBoolean(5));
            idW = rs.getInt(6);
            r.setWestLock(rs.getBoolean(7));
            idE = rs.getInt(8);
            r.setEastLock(rs.getBoolean(9));
            idTD = rs.getInt(10);
        }
        
        rs.close();
        pstm.close();

        if ((idN != -2) && (idS != -2) && (idW != -2) && (idE != -2) && (idTD != -2)) {
            for (Room room : map) {

                if (room.getId() == idN) { //Cerca la corrispondente stanza NORD in map con il codice
                    r.setNorth(room);

                } else if (room.getId() == idS) { //Cerca la corrispondente stanza SUD in map con il codice
                    r.setSouth(room);

                } else if (room.getId() == idW) { //Cerca la corrispondente stanza OVEST in map con il codice
                    r.setWest(room);

                } else if (room.getId() == idE) { //Cerca la corrispondente stanza EST in map con il codice
                    r.setEast(room);

                } else if (room.getId() == idTD) { //Cerca la corrispondente stanza DOSE in map con il codice
                    r.setToggleDose(room);

                } //Se non trova corrispondenza, la stanza adiacente (N-S-E-W) o quella alternativa (TD) restano null
            }
        } else {
            System.out.println("Errore nel caricamento delle stanze!");
        }

    }

    //  GameObjects (in Room)
    public static void initObjectInRoom(Room room) throws SQLException {

        List<Integer> idObjsList = new ArrayList<>();

        //  Recupera dalla table 'ro' solo gli id degli oggetti nella stanza passata in input
        PreparedStatement pstm = connection.prepareStatement(SELECT_OB_ROOM + room.getId());
        ResultSet rs = pstm.executeQuery();

        while (rs.next()) {
            idObjsList.add(rs.getInt(1));
        }

        rs.close();
        pstm.close();

        //  Recupera dalla table 'object' un oggetto alla volta, in base all'id contenuto in idObjs
        for (Integer idObj : idObjsList) {
            try {
                Set<String> aliases = selectAliases(SELECT_OBJECT_ALIASES, idObj);

                pstm = connection.prepareStatement(SELECT_OBJECT + idObj);
                rs = pstm.executeQuery();

                while (rs.next()) {
                    GameObject obj = new GameObject(rs.getInt(1), rs.getString(2).trim(), rs.getString(3).trim(), rs.getString(4).trim(), rs.getBoolean(5), rs.getBoolean(6));
                    obj.setSynonyms(aliases);
                    room.addObj(obj);
                }

                rs.close();
                pstm.close();

            } catch (SQLException ex) {
                System.err.println("SQL Error: " + ex.getMessage());
            }

        }
    }

    //  ContainerObjects (in Room)
    public static void initContainerInRoom(Room room) throws SQLException {

        List<Integer> idContainerList = new ArrayList<>();

        //  Recupera dalla table 'rc' solo gli id dei container nella stanza passata in input
        PreparedStatement pstm = connection.prepareStatement(SELECT_CON_ROOM + room.getId());
        ResultSet rs = pstm.executeQuery();

        while (rs.next()) {
            idContainerList.add(rs.getInt(1));
        }

        rs.close();
        pstm.close();

        //  Recupera dalla table 'container' un oggetto alla volta, in base all'id contenuto in idObjs
        for (Integer idCont : idContainerList) {

            try {
                Set<String> aliases = selectAliases(SELECT_CONTAINER_ALIASES, idCont);
                List<GameObject> contained = selectContained(SELECT_OB_CONT, idCont);

                pstm = connection.prepareStatement(SELECT_CONTAINER + idCont);
                rs = pstm.executeQuery();

                while (rs.next()) {
                    ContainerObject objCont = new ContainerObject(rs.getInt(1), rs.getString(2).trim(), rs.getString(3).trim(), rs.getString(4).trim(), rs.getBoolean(5), rs.getBoolean(6), rs.getBoolean(7));
                    objCont.setSynonyms(aliases);
                    objCont.setContained(contained);
                    room.addObj(objCont);
                }

                rs.close();
                pstm.close();

            } catch (SQLException ex) {
                System.err.println("SQL Error: " + ex.getMessage());
            }

        }
    }

    //  NPC (in Room)
    public static void initNpcInRoom(Room room) throws SQLException {
        List<Integer> idNpcsList = new ArrayList<>();

        //  Recupero gli NPC presenti nella stanza passata in input
        PreparedStatement pstm = connection.prepareStatement(SELECT_NPC_ROOM + room.getId());
        ResultSet rs = pstm.executeQuery();

        while (rs.next()) {
            idNpcsList.add(rs.getInt(1));
        }

        rs.close();
        pstm.close();

        //  Recupero le informazioni degli NPC selezionati e li posiziono nella stanza
        for (Integer idNpc : idNpcsList) {

            try {
                Set<String> aliases = selectAliases(SELECT_NPC_ALIASES, idNpc);
                Map<Integer, String> dialogues = selectDialog(SELECT_DIALOG, idNpc);

                pstm = connection.prepareStatement(SELECT_NPC + idNpc);
                rs = pstm.executeQuery();

                while (rs.next()) {
                    NPC npc = new NPC(rs.getInt(1), rs.getString(2).trim());
                    npc.setSynonyms(aliases);
                    npc.setInteractions(dialogues);

                    room.placeNpc(npc);
                }

                rs.close();
                pstm.close();

            } catch (SQLException ex) {
                System.err.println("SQL Error: " + ex.getMessage());
            }
        }
    }

    //  UTILITY METHODS
    private static Set<String> selectAliases(String selectTable, int idSubject) throws SQLException {
        Set<String> aliases = new HashSet<>();

        PreparedStatement pstm = connection.prepareStatement(selectTable + idSubject);
        ResultSet rs = pstm.executeQuery();

        while (rs.next()) {
            aliases.add(rs.getString(1).toLowerCase().trim());
        }

        rs.close();
        pstm.close();

        return aliases;
    }

    private static Map<Integer, String> selectDialog(String selectTable, int idNpc) throws SQLException {
        Map<Integer, String> dialogues = new HashMap<>();

        PreparedStatement pstm = connection.prepareStatement(selectTable + idNpc);
        ResultSet rs = pstm.executeQuery();

        while (rs.next()) {
            dialogues.put(rs.getInt(1), rs.getString(2).trim());
        }

        rs.close();
        pstm.close();

        return dialogues;
    }

    private static List<GameObject> selectContained(String selectTable, int idCont) throws SQLException {
        List<Integer> idContainedList = new ArrayList<>();
        List<GameObject> contained = new ArrayList<>();

        //  Recupero gli ID degli oggetti contenuti
        PreparedStatement pstm = connection.prepareStatement(selectTable + idCont);
        ResultSet rs = pstm.executeQuery();

        while (rs.next()) {
            idContainedList.add(rs.getInt(1));
        }

        rs.close();
        pstm.close();

        //  Recupero le informazioni degli oggetti contenuti
        for (Integer idObj : idContainedList) {
            try {
                Set<String> aliases = selectAliases(SELECT_OBJECT_ALIASES, idObj);

                pstm = connection.prepareStatement(SELECT_OBJECT + idObj);
                rs = pstm.executeQuery();

                while (rs.next()) {
                    GameObject objCont = new GameObject(rs.getInt(1), rs.getString(2).trim(), rs.getString(3).trim(), rs.getString(4).trim(), rs.getBoolean(5), rs.getBoolean(6));
                    objCont.setSynonyms(aliases);
                    contained.add(objCont);
                }

                rs.close();
                pstm.close();

            } catch (SQLException ex) {
                System.err.println("SQL Exception: " + ex.getMessage());
            }
        }

        return contained;
    }
}
