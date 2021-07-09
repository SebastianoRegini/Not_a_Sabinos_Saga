/*
 * NOT A SABINO'S SAGA - MS_C ©2021
 * This is surely not a Sabino's Saga. Anyway, Sabino is still here...
 */

 /*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mainPackage.utilities;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Properties;
import java.util.Set;
import mainPackage.type.ContainerObject;
import mainPackage.type.GameObject;
import mainPackage.type.NPC;
import mainPackage.type.Room;

/**
 *
 * @author MS_C
 */
public class NassDB {

    //  ATTRIBUTES
    private static Connection connection;
    //  CONNECTION STRING
    private static final String CONNECTION_STRING = "jdbc:h2:./resources/dbNASS";

    //  SELECT STRINGS
    //  Rooms and Boundaries
    private static final String SELECT_ROOM = "SELECT * FROM room WHERE id=";
    private static final String SELECT_BOUNDARY = "SELECT * FROM nswe WHERE id=";

    //  Objects and Objects in room
    private static final String SELECT_OBJECT = "SELECT * FROM object WHERE id=";
    private static final String SELECT_OB_ROOM = "SELECT idObj FROM ro WHERE idRoom=";
    private static final String SELECT_CON_ROOM = "SELECT idContainer FROM rc WHERE idRoom=";
    private static final String SELECT_CONTAINER = "SELECT * FROM container WHERE id=";

    //  NPC
    //  Commands
    //  Aliases
    //  MANAGE CONNECTION AND DISCONNECTION
    public static void connectDB() throws SQLException {
        Properties dbProp = new Properties();
        dbProp.setProperty("users", "Sabino");
        dbProp.setProperty("password", "fatto");
        connection = DriverManager.getConnection(CONNECTION_STRING, dbProp);
    }

    public static void disconnectDB() throws SQLException {
        if (connection != null) {
            connection.close();
        }
    }

    //  ROOMS
    public static Room initRoom(int idRoom) throws SQLException {
        PreparedStatement pstm = connection.prepareStatement(SELECT_ROOM + idRoom);
        ResultSet rs = pstm.executeQuery();
        Room r = null;
        while (rs.next()) {
            r = new Room(rs.getInt(1), rs.getString(2), rs.getString(3), rs.getString(4), rs.getString(5));
        }

        rs.close();
        pstm.close();

        return r; //Non stampo nulla in quanto next() dovrebbe lanciare una SQLException se qualcosa non va

    }

    //  BOUNDARIES
    public static void initBoundaries(Room r, List<Room> map) throws SQLException {
        int idN = -2;
        int idS = -2;
        int idW = -2;
        int idE = -2;
        int idTD = -2;

        PreparedStatement pstm = connection.prepareStatement(SELECT_BOUNDARY + r.getId());
        ResultSet rs = pstm.executeQuery();
        while (rs.next()) {
            idN = rs.getInt(2); //Seconda colonna del DB
            r.setNorthLock(rs.getBoolean(3));
            idS = rs.getInt(4); //Quarta colonna del DB
            r.setSouthLock(rs.getBoolean(5));
            idW = rs.getInt(6); //Sesta colonna del DB
            r.setWestLock(rs.getBoolean(7));
            idE = rs.getInt(8); //Ottava colonna del DB
            r.setEastLock(rs.getBoolean(9));
            idTD = rs.getInt(10); //Decima colonna del DB
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

                }
            }
        } else {
            System.out.println("Errore nel caricamento delle stanze!");
        }

    }

    //  GAME OBJECTS in ROOM
    public static void initObjectInRoom(Room room) throws SQLException {

        List<Integer> idObjs = new ArrayList<>();

        //Recupera dalla table 'ro' solo gli id degli oggetti nella stanza passata in input
        PreparedStatement pstm = connection.prepareStatement(SELECT_OB_ROOM + room.getId());
        ResultSet rs = pstm.executeQuery();

        while (rs.next()) {
            idObjs.add(rs.getInt(1));
        }

        rs.close();
        pstm.close();

        //Recupera dalla table 'object' un oggetto alla volta, in base all'id contenuto in idObjs
        for (Integer id : idObjs) {
            pstm = connection.prepareStatement(SELECT_OBJECT + id);
            rs = pstm.executeQuery();

            while (rs.next()) {
                GameObject obj = new GameObject(rs.getInt(1), rs.getString(2), rs.getString(3), rs.getString(4), rs.getBoolean(5), rs.getBoolean(6));
                room.getObj().add(obj);
            }

            rs.close();
            pstm.close();
        }
    }

    //  CONTAINER OBJECTS in ROOM
    public static void initContainerInRoom(Room room) throws SQLException {

        List<Integer> idCont = new ArrayList<>();

        //Recupera dalla table 'rc' solo gli id dei container nella stanza passata in input
        PreparedStatement pstm = connection.prepareStatement(SELECT_CON_ROOM + room.getId());
        ResultSet rs = pstm.executeQuery();

        while (rs.next()) {
            idCont.add(rs.getInt(1));
        }

        rs.close();
        pstm.close();

        //Recupera dalla table 'container' un oggetto alla volta, in base all'id contenuto in idObjs
        for (Integer id : idCont) {
            pstm = connection.prepareStatement(SELECT_CONTAINER + id);
            rs = pstm.executeQuery();

            while (rs.next()) {
                ContainerObject obj = new ContainerObject(rs.getInt(1), rs.getString(2), rs.getString(3), rs.getString(4), rs.getBoolean(5), rs.getBoolean(6), rs.getBoolean(7));
                room.getObj().add(obj);
            }

            rs.close();
            pstm.close();
        }
    }

    // OBJECTS in CONTAINER
    public static void initObjectInContainer() throws SQLException {
        
    }
    
    //  NPC
    public static void initNpc(){
        
    }
}
