/*
 * NOT A SABINO'S SAGA - MS_C ©2021
 * This is surely not a Sabino's Saga. Anyway, Sabino is still here...
 */
package mainPackage.game;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.PrintStream;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import mainPackage.parser.ParserFilter;
import mainPackage.GameDescription;
import mainPackage.type.ContainerObject;
import mainPackage.type.DoseGun;
import mainPackage.type.GameObject;
import mainPackage.type.Inventory;
import mainPackage.type.NPC;
import mainPackage.type.Room;
import static mainPackage.utilities.NassDB.*;

/*
 *
 *
 * @author MS_C
 */
public class NASS extends GameDescription {

    private int passcode = 0;

    private DoseGun gun;

    private boolean guardUniform = false;

    //  CONTANTS
    private final int MOVES_GAMEOVER = 17; //  Il numero di mosse entro il quale bisogna legare Barboni, altrimenti game over

    //  EVENT SWITCHES
    private int eventEnlightRoom = 0;
    private int eventBossQuest = 0;
    private int eventCounter = -1;

    private boolean eventExtraDose = false;
    private boolean eventNoTurnBack = false;
    private boolean eventLanternAlive = true;
    private boolean eventCameraTurnedOff = false;

    //  Recurring Dialog Handler
    private boolean eventRecurringAntonio = false;
    private boolean eventRecurringFilippo = true;

    //  Rat Events
    private boolean eventKeyInfo = false;
    private boolean eventTableTape = false;
    private boolean eventRing = false;
    private boolean eventShowInfo = false;

    //  OVERRIDED METHODS
    @Override
    public void init() throws SQLException {

        //  CONNECTION
        connectDB();

        //  COMMANDS
        initCommands(getCommands());

        //   NORMAL ROOMS CONSTRUCTION
        Room parcheggio = initRoom(0, getRooms());
        Room ufficio = initRoom(1, getRooms());
        Room ingressoPrincipale = initRoom(2, getRooms());
        Room corridoioTorretta = initRoom(3, getRooms());
        Room passaggioCucina = initRoom(4, getRooms());
        Room entrataZonaCarcere = initRoom(5, getRooms());
        Room angoloCorridoio = initRoom(6, getRooms());
        Room spogliatoio = initRoom(7, getRooms());
        Room corridoioSpogliatoio = initRoom(8, getRooms());
        Room cucina = initRoom(9, getRooms());
        Room mensa = initRoom(10, getRooms());
        Room corridoioMensa = initRoom(11, getRooms());
        Room torreOsservazione = initRoom(12, getRooms());
        Room angoloCorridoioIniziale = initRoom(13, getRooms());
        Room corridoioInterno = initRoom(14, getRooms());
        Room incrocioPrincipale = initRoom(15, getRooms());
        Room corridoioCortile = initRoom(16, getRooms());
        Room cortile = initRoom(17, getRooms());
        Room corridoioIniziale = initRoom(18, getRooms());

        //   DOSE ROOMS CONSTRUCTION
        Room parcheggio_1 = initRoom(19, getRooms());
        Room ingressoPrincipale_1 = initRoom(20, getRooms());
        Room angoloCorridoio_1 = initRoom(21, getRooms());
        Room corridoioMensa_1 = initRoom(22, getRooms());
        Room torreOsservazione_1 = initRoom(23, getRooms());
        Room incrocioCorridoioIniziale_1 = initRoom(24, getRooms());
        Room corridoioInterno_1 = initRoom(25, getRooms());
        Room incrocioPrincipale_1 = initRoom(26, getRooms());
        Room corridoioCortile_1 = initRoom(27, getRooms());
        Room corridoioCortile_2 = initRoom(28, getRooms());
        Room corridoioIniziale_1 = initRoom(29, getRooms());

        Room incrocioCorridoioIniziale = initRoom(-3, getRooms());

        //   MAP (boundaries)
        initBoundaries(parcheggio, getRooms());
        initBoundaries(ufficio, getRooms());
        initBoundaries(ingressoPrincipale, getRooms());
        initBoundaries(corridoioTorretta, getRooms());
        initBoundaries(passaggioCucina, getRooms());
        initBoundaries(entrataZonaCarcere, getRooms());
        initBoundaries(angoloCorridoio, getRooms());
        initBoundaries(spogliatoio, getRooms());
        initBoundaries(corridoioSpogliatoio, getRooms());
        initBoundaries(cucina, getRooms());
        initBoundaries(mensa, getRooms());
        initBoundaries(corridoioMensa, getRooms());
        initBoundaries(torreOsservazione, getRooms());
        initBoundaries(angoloCorridoioIniziale, getRooms());
        initBoundaries(corridoioInterno, getRooms());
        initBoundaries(incrocioPrincipale, getRooms());
        initBoundaries(corridoioCortile, getRooms());
        initBoundaries(cortile, getRooms());
        initBoundaries(corridoioIniziale, getRooms());

        initBoundaries(parcheggio_1, getRooms());
        initBoundaries(ingressoPrincipale_1, getRooms());
        initBoundaries(angoloCorridoio_1, getRooms());
        initBoundaries(corridoioMensa_1, getRooms());
        initBoundaries(torreOsservazione_1, getRooms());
        initBoundaries(incrocioCorridoioIniziale_1, getRooms());
        initBoundaries(corridoioInterno_1, getRooms());
        initBoundaries(incrocioPrincipale_1, getRooms());
        initBoundaries(corridoioCortile_1, getRooms());
        initBoundaries(corridoioCortile_2, getRooms());
        initBoundaries(corridoioIniziale_1, getRooms());

        initBoundaries(incrocioCorridoioIniziale, getRooms());

        //  OBJECTS IN ROOMS
        initObjectInRoom(parcheggio);
        initObjectInRoom(ufficio);
        initContainerInRoom(ufficio);
        initObjectInRoom(spogliatoio);
        initContainerInRoom(spogliatoio);
        initObjectInRoom(corridoioSpogliatoio);
        initObjectInRoom(cucina);
        initObjectInRoom(mensa);
        initObjectInRoom(torreOsservazione);
        initObjectInRoom(angoloCorridoioIniziale);
        initObjectInRoom(cortile);

        initObjectInRoom(parcheggio_1);
        initObjectInRoom(corridoioMensa_1);
        initObjectInRoom(torreOsservazione_1);
        initObjectInRoom(incrocioCorridoioIniziale_1);
        initObjectInRoom(incrocioPrincipale_1);
        initObjectInRoom(corridoioCortile_1);
        initObjectInRoom(corridoioCortile_2);

        //  NPC IN ROOMS
        initNpcInRoom(ingressoPrincipale);
        initNpcInRoom(angoloCorridoio);
        initNpcInRoom(corridoioMensa);
        initNpcInRoom(corridoioInterno);
        initNpcInRoom(corridoioCortile);
        initNpcInRoom(cortile);
        initNpcInRoom(corridoioIniziale);

        initNpcInRoom(ingressoPrincipale_1);
        initNpcInRoom(angoloCorridoio_1);
        initNpcInRoom(corridoioMensa_1);
        initNpcInRoom(corridoioInterno_1);
        initNpcInRoom(corridoioCortile_2);
        initNpcInRoom(corridoioIniziale_1);

        //  DISCONNECTION
        disconnectDB();

        //  STARTING
        setInventory(new Inventory(6));
        setAlternativeInventory(new Inventory(4));
        gun = new DoseGun(12, 12);

        setInRoom(corridoioIniziale);

    }

    @Override
    public void nextMove(ParserFilter funnel, PrintStream out) {
        out.println();
        Inventory temporaryInv = null;

        //Switch sul tipo di comando
        switch (funnel.getCommand().getType()) {

            case NORTH:
                if (getInRoom().getNorth() == null) {
                    out.println("Non è possibile andare a nord!");
                } else if (getInRoom().isNorthLock()) {
                    if (getInRoom().getNorth().getId() == 12) {
                        out.println("Intravedi, dall'apertura della porta, la guardia Castorpio intenta ad armeggiare\n"
                                + "col suo cellulare. Non è prudente entrare adesso.");
                    } else {
                        out.println("La porta a nord è chiusa a chiave!");
                    }
                } else {
                    if (eventLanternAlive && getInRoom().getId() == 12) {
                        out.println("Non essere imprudente! Potrebbero esserci guardie, telecamere o chissà cos'altro\n"
                                + "dietro questa porta! Trova prima un modo per passare inosservato...");
                    } else {
                        setInRoom(getInRoom().getNorth());
                        getInRoom().printRoom();
                        checkCounter(out);
                    }
                }

                break;

            case SOUTH:
                if (getInRoom().getSouth() == null) {
                    out.println("Non è possibile andare a sud!");
                } else if (getInRoom().isSouthLock()) {

                    if (eventNoTurnBack) {
                        //Evento "non si torna indietro"
                        out.println("Non puoi tornare indietro proprio adesso che sei arrivato fin qui!");
                    } else {
                        out.println("La porta a sud è chiusa a chiave!");
                    }

                } else {
                    setInRoom(getInRoom().getSouth());

                    if (getInRoom().getId() == 17 && !guardUniform) {
                        gameOver(out, 3);
                    }

                    getInRoom().printRoom();
                    checkCounter(out);
                }
                break;

            case EAST:
                if (getInRoom().getEast() == null) {
                    out.println("Non è possibile andare ad est!");
                } else if (getInRoom().isEastLock()) {
                    out.println("La porta ad est è chiusa a chiave!");
                } else {
                    setInRoom(getInRoom().getEast());

                    switch (getInRoom().getId()) {
                        //Mensa
                        case 10:
                            if (!getInRoom().isVisited()) {
                                out.println("Non fai in tempo ad entrare in questa stanza piena di tavoli che senti Antonio urlare dalla sua cella:\n"
                                        + "ha visto, dalla finestrella che si affaccia proprio al corridoio interno, la tua sagoma entrare nella stanza,\n"
                                        + "e le urla hanno attirato una guardia, che vedi passare davanti alla porta ad est.\n\n"
                                        + "Dopo qualche minuto di urla e manganellate, il silenzio.\n"
                                        + "Poi, un rumore provenire da sud-est: una porta che si apre e si richiude.\n\n"
                                        + "Credendo che il peggio sia passato, finalmente accendi le luci della stanza...");
                                waiting(out);
                            }
                            break;

                        //Corridoio Interno
                        case 14:
                            if (!getRooms().get(10).isVisited()) {
                                gameOver(out, 1);
                            }
                            break;

                        //Cortile
                        case 17:
                            if (!getInRoom().isVisited()) {
                                eventNoTurnBack = true;
                            } else {
                                if (!guardUniform) {
                                    gameOver(out, 3);
                                }
                            }
                            break;
                    }

                    getInRoom().printRoom();
                    checkCounter(out);
                }

                break;

            case WEST:
                if (getInRoom().getWest() == null) {
                    out.println("Non è possibile andare ad ovest!");
                } else if (getInRoom().isWestLock()) {
                    if (eventNoTurnBack) {
                        //Evento "non si torna indietro"
                        out.println("Non puoi tornare indietro proprio adesso che sei arrivato fin qui!");
                    } else {
                        out.println("La porta ad ovest è chiusa a chiave!");
                    }
                } else {

                    if (getInRoom().getWest().getId() == 7 && eventEnlightRoom < 2) {
                        out.println("----------------------------------------");
                        if (eventEnlightRoom == 0) {
                            out.println("Apri la porta della stanza accanto, ma ti fermi immediatamente quando vedi, in alto,\n"
                                    + "la spia di una telecamera che punta verso l'interno della stanza stessa.\n"
                                    + "Per fortuna, le luci della stanza sono spente: forse la telecamera non ti ha visto, quindi richiudi velocemente la porta.\n\n"
                                    + "Bisogna neutralizzare, in qualche modo, quella telecamera prima di poter entrare.");
                            eventEnlightRoom++;
                            visibilityChanger(getInRoom(), 10); //Cambia la visibilità della telecamera
                        } else if (eventEnlightRoom == 1) {
                            out.println("Bisogna neutralizzare, in qualche modo, quella telecamera prima di poter entrare.");
                        }

                    } else {
                        setInRoom(getInRoom().getWest());

                        if (getInRoom().getId() == 2 && !getInRoom().isVisited()) {
                            //  Disattiva i trigger e sblocca le serrature
                            getRooms().get(17).setWestLock(false);
                            getRooms().get(12).setSouthLock(false);
                            eventNoTurnBack = false;
                            eventRecurringFilippo = false;

                            //  Incontro con Barboni
                            out.println("Appena entrato nella stanza, ti rendi conto che, davanti a te, c'è una guardia che\n"
                                    + "sta uscendo dalla porta di fronte. Appena ti vede, tira fuori il manganello e si avvicina\n"
                                    + "a te con passo timoroso.");
                            if (!gun.shoot()) {
                                gameOver(out, 5);
                            } else {
                                out.println("Immediatamente, tiri fuori la pistola e ti spari una dose prima che lui possa colpirti.");
                                setInRoom(getInRoom().getToggleDose());
                            }
                        }
                        getInRoom().printRoom();
                        checkCounter(out);
                    }
                }

                break;

            case OPEN:
                if (funnel.getPerson() == null && funnel.getInventoryObj() == null && funnel.getObject() != null) {
                    //Se è un oggetto contenitore
                    if (funnel.getObject() instanceof ContainerObject) {
                        ContainerObject temporaryContObj = (ContainerObject) funnel.getObject();

                        if (temporaryContObj.isOpen()) { //Se non è chiuso a chiave

                            if (!temporaryContObj.getContained().isEmpty()) {

                                out.println("----------------------------------------");

                                switch (temporaryContObj.getId()) {

                                    //Contenitore: Cassetto 
                                    case 27:
                                        out.print("Tiri via completamente il cassetto dalla scrivania e ne rovesci il contenuto\n"
                                                + "su quest'ultima. Dopo aver finito, lanci via il cassetto e controlli cosa c'era:\n"
                                                + "insieme a molte cianfrusaglie inutili e cancelleria, trovi un ");
                                        break;

                                    //Contenitore: Cassaforte
                                    case 28:
                                        out.print("Infili la chiave e ruoti fino a sentire il rumore della serratura che si sblocca,\n"
                                                + "provi a tirare ma è incastrata. Tiri con un colpo forte e deciso e la porta si\n"
                                                + "spalanca, ma l'urto fa cadere e rotolare un ");
                                        break;

                                    //Contenitore: Tasca
                                    case 29:
                                        out.print("Apri la tasca per vedere cosa c'è dentro, ma il grembiule è vecchio e rovinato:\n"
                                                + "il tuo tirare, unito al peso della roba al suo interno, la fanno strappare\n"
                                                + "e fanno cadere a terra un ");
                                        break;
                                }

                                for (GameObject item : temporaryContObj.getContained()) {
                                    out.println(item.getName().toLowerCase());
                                    getInRoom().addObj(item);
                                }
                                temporaryContObj.getContained().clear(); //Svuoto il ContainerObj

                            } else {
                                out.println("Hai già aperto " + temporaryContObj.getName().toLowerCase() + ".");
                            }

                        } else {
                            out.println(temporaryContObj.getName() + " non si può aprire. Serve una chiave...");
                        }
                    } else {
                        out.println("Non puoi aprire " + funnel.getObject().getName().toLowerCase() + ".");
                    }
                } else {
                    out.println("Non penso tu abbia capito come si usa questo comando.\n"
                            + "Se hai bisogno di chiarimenti, usa AIUTO");
                }

                break;

            case INVENTORY:
                //Controllo se siamo nella stanza alternativa
                if (getInRoom().getId() < 19) {
                    temporaryInv = getInventory();
                } else {
                    temporaryInv = getAlternativeInventory();
                }

                if (temporaryInv.isEmpty()) {
                    out.println("Hai le tasche vuote!");
                } else {
                    out.println("----------------------------------------");
                    out.println("Frugando in tutte le tue " + temporaryInv.getSlots() + " tasche, trovi:");
                    for (GameObject obj : temporaryInv.getContaining()) {
                        out.println(obj.getName());
                    }
                }
                out.println();
                break;

            case PICK_UP:
                if (funnel.getObject() != null) {
                    if (funnel.getObject().isPickupable() && funnel.getObject().isVisible()) {

                        //Controllo se siamo nella stanza alternativa
                        if (getInRoom().getId() < 19) {
                            temporaryInv = getInventory();
                        } else {
                            temporaryInv = getAlternativeInventory();
                        }
                        if (!temporaryInv.isFull()) {
                            temporaryInv.add(funnel.getObject());
                            getInRoom().removeObj(funnel.getObject());
                            out.println("----------------------------------------");
                            out.println("Hai messo in tasca " + funnel.getObject().getName().toLowerCase() + ".");
                            if (funnel.getObject().getId() == 18) {
                                guardUniform = true;
                                getInRoom().getToggleDose().moveNpc(getInRoom().getToggleDose().getNpcs().remove(0));

                                eventBossQuest++; //3
                            }
                        } else {
                            out.println("Hai le tasche piene!");
                        }
                    } else {
                        out.println("In un altro gioco magari si, ma in questo non puoi prenderlo...");
                    }
                } else {
                    out.println("Non credo sia un oggetto valido...");
                }
                break;

            //Gli oggetti dell'inventario alternativo non possono essere lasciati
            case DROP:
                if (funnel.getInventoryObj() != null) {
                    if (getInRoom().getId() > 18) {
                        out.println("Non è saggio lasciare oggetti qui...");
                    } else {
                        if (funnel.getInventoryObj().getId() == 14) {
                            out.println("Non puoi lasciare questo oggetto.");
                        } else {
                            getInventory().remove(funnel.getInventoryObj());
                            getInRoom().addObj(funnel.getInventoryObj());
                            out.println("----------------------------------------");
                            out.println("Hai lasciato " + funnel.getInventoryObj().getName().toLowerCase() + " in questa stanza.");
                        }
                    }
                } else {
                    out.println("Non hai questo oggetto nelle tasche...");
                }
                break;

            case USE:
                if (funnel.getInventoryObj() != null) {
                    if (funnel.getPerson() != null && funnel.getObject() != null) {
                        out.println("Puoi usarlo o su " + funnel.getPerson().getName() + " o su " + funnel.getObject().getName().toLowerCase() + ".");
                    } else if (funnel.getPerson() != null) {

                        switch (funnel.getPerson().getId()) {

                            //Se l'NPC è Castorpio (12)
                            case 12:
                                switch (funnel.getInventoryObj().getId()) {

                                    //Fascette (14)
                                    case 14:
                                        out.println(funnel.getPerson().getInteraction(2));
                                        getInRoom().setToggleDose(getRooms().get(23));
                                        break;

                                    //Pesetto (16)
                                    case 16:
                                        out.println(funnel.getPerson().getInteraction(3));
                                        getInventory().remove(funnel.getInventoryObj());
                                        getInRoom().moveNpc(funnel.getPerson());
                                        getInRoom().getNorth().placeNpc(funnel.getPerson());
                                        getInRoom().setNorthLock(false);
                                        break;

                                    default:
                                        out.println("Non puoi usare " + funnel.getInventoryObj().getName() + " su " + funnel.getPerson().getName() + ".");
                                }

                                break;

                            //Se l'NPC è Barboni (13)
                            case 13:
                                //Fascette (14)
                                if (funnel.getInventoryObj().getId() == 14) {
                                    out.println(funnel.getPerson().getInteraction(2));
                                    getInventory().remove(funnel.getInventoryObj());
                                    eventCounter = -1;
                                } else {
                                    out.println("Non puoi usare " + funnel.getInventoryObj().getName().toLowerCase() + " su " + funnel.getPerson().getName() + ".");
                                }
                                break;

                            //Se è chiunque altro    
                            default:
                                out.println("Non puoi usare oggetti su " + funnel.getPerson().getName() + ".");
                        }

                    } else if (funnel.getObject() != null) {

                        switch (funnel.getInventoryObj().getId()) {

                            //Telecamera (10) + Stagnola (11)
                            case 11:
                                if (funnel.getObject().getId() == 10) {
                                    eventEnlightRoom = 2;
                                    funnel.getObject().setVisible(false);
                                    out.println("Sporgendoti, sei riuscito a coprire l'obiettivo della telecamera con la carta stagnola.\n"
                                            + "Hai acceso la luce con l'interruttore proprio vicino alla porta e ora, finalmente, puoi entrare.");

                                    getInventory().remove(funnel.getInventoryObj());
                                }
                                break;

                            //Uks (23) + Porticina (24)
                            case 24:
                                if (funnel.getObject().getId() == 23) {
                                    out.println("Usi la porticina in ferro per \"aprire\" la chiave gigante, che si sblocca e ti permette di attraversare la porta.\n"
                                            + "Appena aperta, riesci a vedere attraverso di essa il CORTILE della prigione, ma non fai in tempo ad oltrepassarla che\n"
                                            + "vieni scagliato verso il cosmo. All'improvviso, sei di nuovo nel mondo reale e la porta per il CORTILE è semi aperta.");
                                    getRooms().get(16).setEastLock(false);
                                    getRooms().get(16).setToggleDose(null);
                                    setInRoom(getInRoom().getToggleDose());
                                    getInRoom().printRoom();

                                    eventBossQuest++; //1 o 2

                                    getAlternativeInventory().remove(funnel.getInventoryObj());
                                }
                                break;

                            //Cassaforte (28) + Chiave (12)
                            case 12:
                                if (funnel.getObject() instanceof ContainerObject && funnel.getObject().getId() == 28) {
                                    unlock((ContainerObject) funnel.getObject(), funnel.getInventoryObj(), out);
                                }

                                break;

                            //Cassetto (27) + Chiave (4)
                            case 4:
                                if (funnel.getObject() instanceof ContainerObject && funnel.getObject().getId() == 27) {
                                    unlock((ContainerObject) funnel.getObject(), funnel.getInventoryObj(), out);
                                }
                                break;

                            //Qualsiasi altro oggetto
                            default:
                                out.println("Non puoi usarlo in questo modo.");

                        }

                    } else { //Entrambi null (solo oggetto dell'inventario
                        switch (funnel.getInventoryObj().getId()) {

                            //Chiave mensa
                            case 9:

                                //Porta est
                                if (getInRoom().getId() == 9 || getInRoom().getId() == 10) {
                                    if (getInRoom().isEastLock() && getInRoom().getEast().isWestLock()) {
                                        getInRoom().setEastLock(false);
                                        getInRoom().getEast().setWestLock(false);
                                        out.println("----------------------------------------");
                                        out.println("Hai sbloccato la porta ad est, ora puoi passare.");
                                    } else {
                                        out.println("----------------------------------------");
                                        out.println("Hai già sbloccato la porta ad est.");
                                    }
                                } else {
                                    out.println("Non puoi usare questa chiave qui!");
                                }

                                break;

                            //Mazzo di chiavi
                            case 25:
                                switch (getInRoom().getId()) {
                                    //Ingresso principale e Corridoio Spogliatoio
                                    case 2:
                                    case 8:
                                        //Porta nord
                                        if (getInRoom().isNorthLock() && getInRoom().getNorth().isSouthLock()) {
                                            getInRoom().setNorthLock(false);
                                            getInRoom().getNorth().setSouthLock(false);
                                            out.println("----------------------------------------");
                                            out.println("Hai sbloccato la porta a nord, ora puoi passare.");
                                        } else {
                                            out.println("----------------------------------------");
                                            out.println("Hai già sbloccato la porta a nord.");
                                        }
                                        break;

                                    //Passaggio per la cucina
                                    case 4:
                                        //Porta est
                                        if (getInRoom().isEastLock() && getInRoom().getEast().isWestLock()) {
                                            getInRoom().setEastLock(false);
                                            getInRoom().getEast().setWestLock(false);
                                            out.println("----------------------------------------");
                                            out.println("Hai sbloccato la porta ad est, ora puoi passare.");
                                        } else {
                                            out.println("----------------------------------------");
                                            out.println("Hai già sbloccato la porta ad est.");
                                        }

                                        //Porta sud
                                        if (getInRoom().isSouthLock() && getInRoom().getSouth().isNorthLock()) {
                                            getInRoom().setSouthLock(false);
                                            getInRoom().getSouth().setNorthLock(false);
                                            out.println("----------------------------------------");
                                            out.println("Hai sbloccato la porta a sud, ora puoi passare.");
                                        } else {
                                            out.println("----------------------------------------");
                                            out.println("Hai già sbloccato la porta a sud.");
                                        }

                                        break;

                                    //Entrata zona carcere
                                    case 5:
                                        //Porta est
                                        if (getInRoom().isEastLock() && getInRoom().getEast().isWestLock()) {
                                            getInRoom().setEastLock(false);
                                            getInRoom().getEast().setWestLock(false);
                                            out.println("----------------------------------------");
                                            out.println("Hai sbloccato la porta ad est, ora puoi passare.");
                                        } else {
                                            out.println("----------------------------------------");
                                            out.println("Hai già sbloccato la porta ad est.");
                                        }

                                        //Porta ovest
                                        if (getInRoom().isWestLock() && getInRoom().getWest().isEastLock()) {
                                            getInRoom().setWestLock(false);
                                            getInRoom().getWest().setEastLock(false);
                                            out.println("----------------------------------------");
                                            out.println("Hai sbloccato la porta ad ovest, ora puoi passare.");
                                        } else {
                                            out.println("----------------------------------------");
                                            out.println("Hai già sbloccato la porta ad ovest.");
                                        }

                                        break;

                                    //Angolo corridoio
                                    case 6:
                                        //Porta ovest
                                        if (getInRoom().isWestLock() && getInRoom().getWest().isEastLock()) {
                                            getInRoom().setWestLock(false);
                                            getInRoom().getWest().setEastLock(false);
                                            out.println("----------------------------------------");
                                            out.println("Hai sbloccato la porta ad ovest, ora puoi passare.");
                                        } else {
                                            out.println("----------------------------------------");
                                            out.println("Hai già sbloccato la porta ad ovest.");
                                        }
                                        break;

                                    default:
                                        out.println("Non puoi usare questa chiave qui!");
                                }
                                break;

                            //Qualsiasi altro oggetto
                            default:
                                out.println("Non puoi usarlo!");
                        }

                    }
                } else {
                    out.println("Non puoi farlo.");
                }

                break;

            case GIVE:
                if (funnel.getPerson() != null && funnel.getInventoryObj() != null) {
                    //Controllo se è Ugo (2)
                    switch (funnel.getPerson().getId()) {
                        case 2:
                            switch (funnel.getInventoryObj().getId()) {
                                //Oggetto: cellulare (5)
                                case 5:
                                    out.println("----------------------------------------");
                                    out.println(funnel.getPerson().getInteraction(7));
                                    eventTableTape = true;
                                    break;

                                //Oggetto: anello (6)
                                case 6:
                                    out.println("----------------------------------------");
                                    out.println(funnel.getPerson().getInteraction(8));
                                    eventRing = true;
                                    break;

                                //Oggetto: orologio (7)
                                case 7:
                                    out.println("----------------------------------------");
                                    out.println(funnel.getPerson().getInteraction(6));
                                    eventKeyInfo = true;
                                    break;
                            }
                            out.println("Spero tu abbia ascoltato bene, non ripeterò ciò che ho detto!");
                            getInventory().remove(funnel.getInventoryObj());
                            break;
                        //Controllo se è Bambine (11)
                        case 11:
                            //Oggetto: bambola di pezza (18)
                            if (funnel.getInventoryObj().getId() == 18) {
                                out.println("----------------------------------------");
                                out.println(funnel.getPerson().getInteraction(2));
                                eventBossQuest = -1;
                                guardUniform = false;

                                getAlternativeInventory().remove(funnel.getInventoryObj());

                                setInRoom(getInRoom().getToggleDose());
                                getInRoom().setToggleDose(null);
                                getInRoom().printRoom();
                            }
                            break;
                        default:
                            //Altrimenti
                            out.println("----------------------------------------");
                            out.println("Non puoi dare " + funnel.getInventoryObj().getName() + " a " + funnel.getPerson().getName() + ".");
                            break;
                    }
                } else {
                    out.println("Puoi dare solo un oggetto delle tue tasche a qualcuno presente in questa stanza.");
                }
                break;

            case EXAMINE:

                //Se inserisci troppe cose da guardare
                if ((funnel.getPerson() != null && funnel.getObject() != null)
                        || (funnel.getInventoryObj() != null && funnel.getObject() != null)
                        || (funnel.getPerson() != null && funnel.getInventoryObj() != null)) {
                    out.println("Oh, OH! Troppa roba, con calma giovane! Una cosa alla volta...");

                } else {

                    if (funnel.getPerson() != null) { //Se hai inserito un NPC
                        out.println("----------------------------------------");
                        out.println(funnel.getPerson().getInteraction(0));
                    } else if (funnel.getObject() != null) { //Se hai inserito un oggetto
                        if (funnel.getObject().isVisible()) {
                            out.println("----------------------------------------");
                            out.println(funnel.getObject().getDescription());
                        } else {
                            out.println("----------------------------------------");
                            out.println("Circolare, circolare! Non c'è niente da vedere!");
                        }
                    } else if (funnel.getInventoryObj() != null) { //Se hai inserito un oggetto dell'inventario
                        out.println("----------------------------------------");
                        out.println(funnel.getInventoryObj().getDescription());
                    } else if (funnel.getExtraWord() != null) { //Se hai inserito qualcosa di non valido
                        out.println("----------------------------------------");
                        out.println("Circolare, circolare! Non c'è niente da vedere!");
                    } else { //Se non hai inserito nulla di valido
                        out.println("----------------------------------------");
                        out.println("Devi riferirti a qualcosa o qualcuno in particolare, sennò non posso aiutarti...");
                    }
                }
                break;

            case INTERACT:
                if (funnel.getObject() != null && funnel.getPerson() != null) {
                    out.println("Madonna con quante cose vuoi interagire insieme! Rilassati, non stai mica cercando di evadere da una prigione!\n"
                            + "Ah no, aspetta... Vabbè, vale comunque la regola \"Una cosa per volta\"");
                } else if (funnel.getObject() != null) {
                    switch (funnel.getObject().getId()) {

                        //  Pad
                        case 0:
                            if (passcode > 3) {
                                gameOver(out, 0);
                            } else {
                                out.println("Credo ci voglia un codice numerico di 4 cifre per aprire il cancello di uscita.");
                            }
                            break;

                        //  Computer
                        case 2:
                            if (!eventCameraTurnedOff) {
                                out.println("Hai spento le telecamere.");
                                eventCameraTurnedOff = true;
                            } else {
                                out.println("Le telecamere sono già spente.");
                            }
                            break;

                        //  Calendario dell'avvento
                        case 3:
                            for (GameObject gO : getInRoom().getObj()) {
                                if (gO.getId() == 4) {
                                    out.println("Cominci a premere su tutte le caselline del calendario per controllare se ci siano dolcetti.\n"
                                            + "Arrivato alla casella 25, dopo averla premuta, esce fuori e cade sulla scrivania una piccola\n"
                                            + "chiave... Maledizione, cerchi cioccolatini e trovi chiavi... che schifo...");
                                    gO.setVisible(true);
                                    getInRoom().removeObj(funnel.getObject());
                                    break;
                                }
                            }
                            break;

                        //  Armadio spogliatoio
                        case 8:
                            if (eventKeyInfo) {
                                for (GameObject gO : getInRoom().getObj()) {
                                    if (gO.getId() == 9) {
                                        out.println("Dalle informazioni recuperate dal Sorcio, inizi a controllare introrno all'armadio e\n"
                                                + "sotto di esso, ma niente. Dopo qualche secondo ti viene il dubbio: controlli sopra\n"
                                                + "l'armadio e, finalmente, trovi la chiave. A questo punto ti chiedi \"Ma come cavolo faceva\n"
                                                + "il Sorcio a sapere dove si trovava?\"\n"
                                                + "Purtroppo non lo sa nessuno, nemmeno gli sviluppatori...");
                                        gO.setVisible(true);
                                        getInRoom().removeObj(funnel.getObject());
                                        break;
                                    }
                                }
                            } else {
                                out.println("L'armadio è chiuso con un lucchetto.");
                            }
                            break;

                        //  Tavoli mensa
                        case 13:
                            if (eventTableTape) {
                                for (GameObject gO : getInRoom().getObj()) {
                                    if (gO.getId() == 12) {
                                        out.println("Stando a quello che ti ha detto il Sorcio, sotto uno di questi tavoli c'è una chiave.\n"
                                                + "Inizi a controllarli uno per uno, finché non trovi, sotto il terzo che controlli, una\n"
                                                + "striscia di nastro adesivo. Lo strappi via e la chiave citata da Ugo cade a terra.");
                                        gO.setVisible(true);
                                        getInRoom().removeObj(funnel.getObject());
                                        break;
                                    }
                                }
                            } else {
                                out.println("Magari c'è qualcosa da fare con uno di questi tavoli, ma non sai cosa...");
                            }
                            break;

                        //Cartello dose
                        case 17:
                            out.println("Qualcosa");
                            //L'interazione con il cartello, se NON HAI PRESO LA BAMBOLA (eventBossQuest >= 0 e <=2) e se TOGGLE DOSE TORRE DI OSSERVAZIONE è visited, ti dà passcode++
                            //Esci dal mondo della dose e ritorni nel parcheggio
                            setInRoom(getInRoom().getToggleDose());
                            getInRoom().setToggleDose(null);
                            getInRoom().printRoom();
                            break;

                        //  Lanterna
                        case 19:
                            out.println("Apri la teca della lanterna e prendi la paglia: stranamente non scotta. Una volta presa, questa\n"
                                    + "si estingue e cala il buio, poi si spegne anche la paglia sul mucchio di fuoco. Non vedi più nulla,\n"
                                    + "così ti accorgi di avere gli occhi chiusi. Li apri e sei tornato nel mondo reale, con la differenza\n"
                                    + "che non vedi più le luci del corridoio a nord: si sono spente...\n");
                            if (guardUniform) {
                                out.println("Noti, inoltre, di avere indosso la divisa da guardia carceraria di Castorpio che,\n"
                                        + "a proposito, non è più nella stanza...\n"
                                        + "Per qualche motivo, non riesci a togliertela... Poco male, almeno puoi passare inosservato...");
                            }
                            setInRoom(getInRoom().getToggleDose());
                            getInRoom().setToggleDose(null);
                            getInRoom().printRoom();
                            eventLanternAlive = false;
                            break;

                        //  Muro di carte
                        case 20:
                            out.println("Cerchi di buttare giù quel muro a spallate, ma niente. Mentre quei cosi rossi maledetti continuano\n"
                                    + "a riderti addosso. Cerchi di non arrabbiarti e fai un bel respiro profondo per calmarti. Mentre butti\n"
                                    + "fuori l'aria, tutte le carte volano via e il muro scompare. Inizialmente stupito, ti volti e ti inoltri\n"
                                    + "verso quell'uscita andando all'indietro e salutando elegantemente i tizi rossi con due dita medie alzate\n"
                                    + "ed un sorriso beffardo.");
                            setInRoom(getInRoom().getToggleDose());
                            getInRoom().printRoom();
                            getInRoom().setToggleDose(null);

                            getRooms().get(13).setId(-4);
                            getRooms().get(30).setId(13);
                            getRooms().remove(13);
                            getRooms().add(13, getRooms().get(29));
                            getRooms().remove(30);
                            getInRoom().setSouth(getRooms().get(13));
                            getRooms().get(18).setNorth(getRooms().get(13));
                            getRooms().get(14).setWest(getRooms().get(13));
                            break;

                        //  Pulsante triangolo
                        case 21:
                            out.println("Premendo il pulsante, senti il tipico suono di un ascensore quando arriva al piano scelto.\n"
                                    + "Davanti a te appare una figura fatta di pochi pixel, che ti apre le porte dell'ascensore e ti\n"
                                    + "augura una buona giornata... \"Sir\"...\n"
                                    + "Sconvolto, abbandoni quel posto e torni nell'INCROCIO PRINCIPALE.");
                            waiting(out);
                            setInRoom(getInRoom().getToggleDose());
                            getInRoom().printRoom();
                            break;

                        //  Pulsante stella
                        case 22:
                            gameOver(out, 2);
                            break;

                        //  Uks
                        case 23:
                            out.println("La chiave inizia a tremare e vieni sbalzato verso il cosmo.\n"
                                    + "Poi, in qualche modo che i programmatori non hanno specificato perché si erano scocciati,\n"
                                    + "ti ritrovi di nuovo nel CORRIDOIO CORTILE.");
                            waiting(out);
                            setInRoom(getInRoom().getToggleDose());
                            getInRoom().printRoom();
                            break;

                        //  Culla
                        case 26:
                            out.println("Appoggi la mano su quel buco nero e vieni immediatamente risucchiato al suo interno.\n"
                                    + "Riesci a vedere la tua intera vita in un millisecondo: la tua nascita, i tempi dell'asilo\n"
                                    + "il primo bacio, il tuo matrimonio, il momento in cui Mary ha programmato i tuoi ricordi\n"
                                    + "in questo videogioco di mer...cavolo, sei già di ritorno nel mondo reale... come vola il\n"
                                    + "tempo!");
                            waiting(out);
                            setInRoom(getInRoom().getToggleDose());
                            getInRoom().printRoom();
                            break;

                        default:
                            out.println("Non puoi interagire con questo oggetto!");
                    }
                } else if (funnel.getPerson() != null) {
                    switch (funnel.getPerson().getId()) {

                        //  Sabino (normale)
                        case 0:
                            if (eventExtraDose) {
                                out.println(funnel.getPerson().getInteraction(2));

                                gun.setAmmo(gun.getMagazine());
                                out.println("Adesso hai " + gun.getAmmo() + " dosi.");

                                eventExtraDose = false;
                            } else {
                                out.println(funnel.getPerson().getInteraction(1));
                            }
                            break;

                        //  Sabino (dose)
                        case 1:
                            out.println(funnel.getPerson().getInteraction(1));

                            setInRoom(getInRoom().getToggleDose());
                            getInRoom().setToggleDose(null);
                            getInRoom().printRoom();

                            passcode++;

                            for (NPC person : getInRoom().getNpcs()) {
                                if (person.getId() == 0) {
                                    getInRoom().moveNpc(person);
                                    break;
                                }
                            }

                            break;

                        //  Ugo
                        case 2:
                            if (!eventShowInfo) {
                                out.println(funnel.getPerson().getInteraction(1));
                                eventShowInfo = true;
                            } else if (!(eventKeyInfo && eventTableTape && eventRing)) {

                                out.println(funnel.getPerson().getInteraction(2));

                                if (!eventKeyInfo) {
                                    out.println(funnel.getPerson().getInteraction(3));
                                }

                                if (!eventTableTape) {
                                    out.println(funnel.getPerson().getInteraction(4));
                                }

                                if (!eventRing) {
                                    out.println(funnel.getPerson().getInteraction(5));
                                }
                            } else {
                                out.println(funnel.getPerson().getInteraction(9));
                            }

                            break;

                        //  Antonio
                        case 3:

                            if (!eventRing) {
                                out.println(funnel.getPerson().getInteraction(1));
                            } else {
                                if (!getRooms().get(25).isVisited()) {

                                    if (getInRoom().getToggleDose() == null) {
                                        out.println(funnel.getPerson().getInteraction(2));
                                        getInRoom().setToggleDose(getRooms().get(25));
                                    } else {
                                        out.println(funnel.getPerson().getInteraction(3));
                                    }

                                } else {

                                    if (eventRecurringAntonio) {
                                        out.println(funnel.getPerson().getInteraction(5));
                                    } else {
                                        out.println(funnel.getPerson().getInteraction(4));
                                        eventRecurringAntonio = true;
                                    }
                                }
                            }

                            break;

                        //  Occhi
                        case 4:
                            out.println(funnel.getPerson().getInteraction(1));

                            setInRoom(getInRoom().getToggleDose());
                            getInRoom().setToggleDose(null);
                            getInRoom().printRoom();

                            passcode++;

                            break;

                        //  Filippo (normale)
                        case 5:
                            if (!getRooms().get(22).isVisited()) {
                                out.println(funnel.getPerson().getInteraction(1));
                            } else {
                                if (eventRecurringFilippo) {
                                    out.println(funnel.getPerson().getInteraction(2));
                                } else {
                                    out.println(funnel.getPerson().getInteraction(3));
                                    passcode++;
                                    eventRecurringFilippo = true;
                                }
                            }

                            break;

                        //  Filippo (dose)
                        case 6:
                            out.println(funnel.getPerson().getInteraction(1));

                            GameObject temporaryObj = getInRoom().getObj().get(0);
                            temporaryObj.setVisible(true);
                            getAlternativeInventory().add(temporaryObj);
                            getInRoom().removeObj(temporaryObj);

                            setInRoom(getInRoom().getToggleDose());
                            getInRoom().setToggleDose(null);
                            getInRoom().printRoom();

                            break;

                        //  Capo
                        case 7:
                            if (eventBossQuest == 0 || (getRooms().get(16).getToggleDose() == null && eventBossQuest == 1)) {
                                out.println(funnel.getPerson().getInteraction(1));
                                eventBossQuest++; //1 o 2
                            } else if (eventBossQuest == -1) {
                                out.println(funnel.getPerson().getInteraction(3));
                                out.println(funnel.getPerson().getInteraction(4));
                                eventBossQuest = -2;
                            } else {
                                out.println(funnel.getPerson().getInteraction(2));
                            }
                            break;

                        //  Dvce
                        case 8:
                            if (eventBossQuest < 0) { //Quest completata
                                out.println(funnel.getPerson().getInteraction(2));

                                setInRoom(getInRoom().getToggleDose());
                                getInRoom().setToggleDose(null);

                                passcode++;
                            } else {
                                out.println(funnel.getPerson().getInteraction(1));
                                setInRoom(getInRoom().getToggleDose());
                            }

                            getInRoom().printRoom();

                            break;

                        //  Michele e Carlo
                        case 9:
                        case 10:
                            if (eventBossQuest < 0) { //Quest completata
                                out.println(funnel.getPerson().getInteraction(2));
                            } else {
                                out.println(funnel.getPerson().getInteraction(1));
                            }
                            break;

                        //  Bambine
                        case 11:
                            out.println(funnel.getPerson().getInteraction(1));
                            break;

                        //  Castorpio
                        case 12:
                            if (getInRoom().getId() == 17) {
                                out.println(funnel.getPerson().getInteraction(4));
                            } else {
                                out.println(funnel.getPerson().getInteraction(1));
                            }
                            break;

                        //  Barboni
                        case 13:
                            out.println(funnel.getPerson().getInteraction(1));
                            break;

                        //  Barbuino
                        case 14:
                            out.println(funnel.getPerson().getInteraction(1));
                            waiting(out);
                            out.println(funnel.getPerson().getInteraction(2));

                            setInRoom(getInRoom().getToggleDose());
                            eventCounter = 0;
                            eventExtraDose = true;
                            getRooms().get(18).setToggleDose(getRooms().get(29));

                            getInRoom().setToggleDose(null);
                            getInRoom().printRoom();

                            break;

                    }
                } else if (funnel.getInventoryObj() != null) {
                    out.println("I programmatori sono stati incompete...troppo buoni, e hanno evitato le interazioni con gli oggetti dell'inventario...");
                } else if (funnel.getExtraWord() != null) {
                    out.println("Non è qualcosa di valido con cui interagire!");
                } else {
                    out.println("Se non mi dici con chi o con cosa vuoi interagire, non posso aiutarti...");
                }

                break;

            case THINK_ABOUT:
                //Se inserisci troppe cose su cui riflettere
                if (funnel.getInventoryObj() != null && funnel.getObject() != null) {
                    out.println("Oh, OH! Troppa roba, con calma giovane! Una cosa alla volta...");

                } else {
                    if (funnel.getObject() != null) { //Se hai inserito un oggetto
                        if (funnel.getObject().isVisible()) {
                            out.println("----------------------------------------");
                            out.println(funnel.getObject().getHint());
                        } else {
                            out.println("----------------------------------------");
                            out.println("Non farti viaggi astrali su qualsiasi cosa, devi sbrigarti ad evadere!");
                        }
                    } else if (funnel.getInventoryObj() != null) { //Se hai inserito un oggetto dell'inventario
                        out.println("----------------------------------------");
                        out.println(funnel.getInventoryObj().getHint());
                    } else if (funnel.getExtraWord() != null) { //Se hai inserito una parola non valida
                        out.println("----------------------------------------");
                        out.println("Non farti viaggi astrali su qualsiasi cosa, devi sbrigarti ad evadere!");
                    } else { //Se non hai inserito nulla
                        out.println("Devi dirmi su cosa vuoi che ti dia indizi... Coraggio, riprova!");
                    }
                }
                break;

            case DOSE:

                if (eventBossQuest > 1 && getInRoom().getId() == 16) {
                    getInRoom().setToggleDose(getRooms().get(28));
                }

                if (getInRoom().getToggleDose() == null || getInRoom().getId() > 18) {
                    out.println("Non puoi usare la dose qui");
                } else {
                    if (gun.shoot()) {
                        setInRoom(getInRoom().getToggleDose());
                        getInRoom().printRoom();
                    } else {
                        gameOver(out, 4);
                    }
                }
                break;

            case HELP:
                help(out);
                break;

            case LOOK:
                if (funnel.getObject() != null || funnel.getInventoryObj() != null || funnel.getPerson() != null || funnel.getExtraWord() != null) {
                    out.println("Questo comando va usato da solo.");
                } else {
                    out.println("----------------------------------------");
                    out.println(getInRoom().getDescriptionLook());
                    out.println("\n* * * * * * * * * * * * * * * * * * * *");
                    //Lista di oggetti Pickupable e Visible nella stanza
                    List<GameObject> pickAndVis = new ArrayList<>();
                    for (GameObject item : getInRoom().getObj()) {
                        if (item.isPickupable() && item.isVisible()) {
                            pickAndVis.add(item);
                        }
                    }

                    if (pickAndVis.isEmpty()) {
                        out.println("Non ci sono oggetti nella stanza da poter raccogliere.");
                    } else {
                        out.println("Nella stanza ci sono questi oggetti da poter raccogliere:");
                        for (GameObject item : pickAndVis) {
                            out.println(item.getName());
                        }
                    }
                }
                break;

        }

        //Appena viene fatta una mossa, il programma "memorizza" che ci sono modifiche non salvate
        if (this.isSaved()) {
            this.setSaved(false);
        }

        out.println();
    }

    @Override
    public void printStart(PrintStream out
    ) {
        out.println("========================================================================================================================\n"
                + "BENVENUTO IN NASS\n"
                + "\n"
                + "In quest'avventura, sfortunatamente, non vestirai i panni di Sabino Ciampa, ma del suo coinquilino che,\n"
                + "pur essendo innocente, è stato incastrato e rinchiuso nel QGFC, il carcere di ''''''massima'''''' sicurezza\n"
                + "della città di... lasciamo perdere dove, arrivo al punto.\n"
                + "Il problema è serio: tra poche ore vedrai la tua ultima alba, visto che verrai giustiziato...\n"
                + "con la dannata ghigliottina! Ma stiamo scherzando? Nel 21esimo secolo?\n"
                + "              \n"
                + "Comunque... il tuo obiettivo è quello di riuscire ad evadere e, per farlo, ti verrà in aiuto una speciale\n"
                + "ehm...droga...che ha creato il caro Sabino.\n"
                + "Aspetta un attimo, torno subito...\n"
                + "\n"
                + "WAGLIÒ, MA MI SPIEGATE CHI È STO SABINO!?\n"
                + "HO CAPITO \"SEGUI IL COPIONE\", MA A STO POVERO CRISTO DEVO SPIEGARE LE ROBE O NO?\n"
                + "SI...SI OK MA... MA COME DIGLI 'LO SCOPRIRAI NEL SECONDO CAPITOLO', MA FIGURATI SE STA ROBACCIA AVRÀ UN...\n"
                + "COSA SIGNIF... OK BASTA, NARRO STA ROBA, VOI MI PAGATE, E NON VOGLIO SAPERNE PIÙ NIENTE!\n"
                + "\n"
                + "Rieccomi.\n"
                + "\n"
                + "Ehm... la vera identità di Sabino ti sarà chiara col progredire della storia...\n"
                + "Attento però! Non sarà così semplice! Non tutto è quello che sembra!\n"
                + "Dovrai affrontare enigmi *coff* difficili *coff* che potranno bloccarti o addirittura portarti alla morte!\n"
                + "\n"
                + "Inizi la tua avventura nella tua cella: sono le 03:00 di notte, orario perfetto per un tentativo di evasione,\n"
                + "anche perché le telecamere non possono vederti grazie al fatto che le luci all'interno dell'area carceraria sono\n"
                + "tutte spente.\n\n"
                + "Ascolta bene, Sabino ti sta spiegando l'utilizzo della sua incredibile invenzione.\n"
                + "========================================================================================================================");
        out.println("\nVuoi leggere l'inizio?");
        Scanner wannaSkip = new Scanner(System.in);
        String decision = wannaSkip.nextLine();

        if (decision.equalsIgnoreCase("SI")) {
            out.println("\"La pistola è sicura se dentro c'è la dose, altrimenti ti fa un bel buco in testa e basta\" spiega Sabino, ridendo.\n"
                    + "\"Ma come funziona?\" domandi perplesso.\n"
                    + "\"Molto semplice: ho comprato una normale pistola da Ugo, poi ho rubato una siringa dall'infermieria al piano di sopra ed\n"
                    + "ho montato tutto insieme. Nel caricatore ci sono le capsule che ho già preparato. Basta puntarti la pistola alla tempia e\n"
                    + "premere il grilletto: l'ago retrattile verrà spinto fuori dalla canna e arriverà direttamente al tuo cervello,\n"
                    + "la dose verrà iniettata e farà effetto. Per fortuna questa sostanza riparerà istantaneamente i danni creati dall'ago della siringa.\"\n"
                    + "\"Ok, e come faccio a capire quante dosi mi rimangono.\"\n"
                    + "\"Eeeeeeeeeeh... non lo puoi sapere.\"\n"
                    + "\"Intendevo come faccio a togliere il caricatore per guardarci dentro, non ho mai usato una pist...\"\n"
                    + "\"Non puoi togliere il caricatore.\"\n"
                    + "\"Cosa? Perché?\"\n"
                    + "\"Perché Seba s'è scordato di implementare il comando per farl...ehm...perché la sostanza è altamente instabile,\n"
                    + "ed il contatto con l'aria potrebbe fare una brutta reazione...\"\n"
                    + "\"Ah...beh allora ringrazio Seba per non aver implementato il comando, così almeno non muoio come un fesso...\n"
                    + "Ma come farò a capire se la dose fa effetto?\"\n"
                    + "\"Credimi, lo capirai...\" termina Sabino, invitandoti ad usare la dose.");

            waiting(out);

            out.println("Prendi la pistola, la punti alla testa, chiudi gli occhi e fai fuoco...\n"
                    + "Senti qualcosa che si muove sotto di te, un rumore di onde del mare e uno strano senso di squilibrio.\n"
                    + "Apri gli occhi e scopri di essere su una tavola da surf a forma di crocifisso! Insieme a te c'è Tatiana Shmailyuk\n"
                    + "che ti sorride e guida il surf verso una gigantesca scolopendra in fiamme!\n"
                    + "Tatiana ti grida: \"ARE YOU READY!?\"\n"
                    + "Tu inciampi con le parole: \"A FAR CHE...A...WHAT DOING...DO...CRISTO SANTO!\"\n"
                    + "La scolopendra vi piomba addosso e passi tra le sue fiamme, ritrovandoti fuori dalla tua cella, con qualche anno in meno\n"
                    + "per lo spavento.\n"
                    + "\n"
                    + "Ti volti e, vedendo Sabino, gli inizi a urlare sottovoce: \"Ma che diavolo è stato!?\", mentre lui non riesce a smettere\n"
                    + "di ridere.\n"
                    + "\"Cosa ridi? Ho avuto un mezzo infarto!\"\n"
                    + "\"Avresti dovuto vedere la tua faccia\" esclama, continuando a ridere.\n"
                    + "\"Ma vai a fare in cu...ehi, aspetta: ma sono fuori dalla cella!\"\n"
                    + "Placando le risate, il tuo coinquilino conclude: \"Si, ma ora vedi di far presto e trova la via di fuga. Ricordati solo\n"
                    + "che hai a disposizione " + gun.getAmmo() + " dosi... in bocca al lupo\"\n"
                    + "\"Ok, vado\" rispondi e, riponendo la pistola nella zona interna della parte posteriore del pantalone, la prima cosa che ti\n"
                    + "chiedi è...");

            waiting(out);

        } else if (decision.equalsIgnoreCase("NO")) {

            out.println("Ok, allora sai già tutto.\nMi raccomando: tieni a mente che hai " + gun.getAmmo() + " dosi.");
            waiting(out);
        } else {
            out.println("Non ho capito, ma faccio finta che tu voglia saltare l'inizio.");
        }
    }

    @Override
    public void save() throws IOException {
        ObjectOutputStream outStream = new ObjectOutputStream(new FileOutputStream("./saves/NASS.dat"));
        outStream.writeObject(this);
        outStream.close();

        this.setSaved(true); //Indica se il file è stato salvato
    }

    @Override
    public GameDescription load() throws IOException, ClassNotFoundException {
        ObjectInputStream inStream = new ObjectInputStream(new FileInputStream("./saves/NASS.dat"));
        NASS game = (NASS) inStream.readObject();
        inStream.close();

        return game;
    }

    @Override
    public void gameOver(PrintStream out, int messageCode
    ) {

        switch (messageCode) {
            case 0:
                //Good Ending
                out.println("----------------------------------------");
                out.println("Finalmente riesci ad evadere! Ti allontani da quel posto maledetto e non ti volti mai indietro.\n"
                        + "Riaffiorano i ricordi del processo, dei giorni interminabili passati nella tua cella, di Sabino\n"
                        + "che ti ha aiutato con la sua strana \"droga\", di tutti i rischi che hai corso e del fatto che sei\n"
                        + "finalmente libero.\n\n"
                        + "Dopo esserti liberato dei vestiti da galeotto, raggiungi una stazione di servizio ma, con orrore\n"
                        + "e stupore, fai una scoperta inquietante...");
                break;

            case 1:
                //Antonio
                out.println("----------------------------------------");
                out.println("Appena Antonio ti vede passare, comincia ad urlare.\n"
                        + "Nel tentare di placarlo, non ti accorgi dell'arrivo di una guardia, che ti immobilizza\n"
                        + "con un colpo di taser...\n\n"
                        + "Ti risvegli, all'alba, nella tua cella. Subito dopo, le guardie vengono a prelevarti e ti\n"
                        + "portano all'esterno. Vieni piazzato sulla ghigliottina ed immobilizzato.\n"
                        + "La paura cresce dentro di te mentre scruti, con la coda dell'occhio, il direttore del carcere\n"
                        + "con la mano sollevata. Un senso di panico ti pervade quando vedi la sua mano cadere verso il basso,\n"
                        + "poi la fredda lama della ghigliottina scivola sulla tua pelle e, un'istante dopo, tutto buio...");
                break;

            case 2:
                //Muro
                out.println("----------------------------------------");
                out.println("Vieni fagocitato dal pulsante, che scopri essere fatto di miele, e ti ritrovi dentro il muro\n"
                        + "a sud dell'INCROCIO PRINCIPALE.\n\n"
                        + "All'alba del giorno della tua esecuzione, le guardie del turno successivo\n"
                        + "ti trovano incastrato nel cemento. Ore dopo aver chiamato una compagnia di costruzioni,\n"
                        + "sono riusciti a tirarti fuori da lì. \n\n"
                        + "Successivamente, per non perdere altro tempo,ti hanno portato alla ghigliottina: dopo averti\n"
                        + "appoggiato su di essa e aver infilato la tua testa nella struttura, hanno azionato il meccanismo.\n\n"
                        + "L'ultima cosa che hai sentito è la fredda lama che ti ha spento con un colpo secco.");
                break;

            case 3:
                //Cecchino
                out.println("----------------------------------------");
                out.println("All'improvviso senti un forte bruciore dietro la testa. Un odore di polvere da sparo\n"
                        + "pervade le tue narici, mentre la vista si annebbia e si oscura.\n\n"
                        + "Il tuo corpo cade a terra senza controllo e, l'ultima cosa che vedi, è la canna di un fucile,\n"
                        + "ancora incandescente, che sporge dalla TORRE DI OSSERVAZIONE. Poi tutto nero...");
                break;

            case 4:
                //Se usi la pistola senza dosi
                out.println("----------------------------------------");
                out.println("Premi il grilletto e senti la classica sensazione dell'ago che perfora il tuo cervello, come quando usi le dosi. \n"
                        + "Questa volta, però, nessun viaggio astrale, nessun mondo parallelo, niente di niente...\n\n"
                        + "Mentre la vista ti si annebbia e la testa comincia a pulsare forte, vedi a terra delle gocce di sangue.\n"
                        + "Ti tocchi il viso e scopri che il sangue sta uscendo dal tuo naso.\n\n"
                        + "Crolli a terra con l'ultimo pensiero che ritorna alle parole di Sabino:\n"
                        + "\"La pistola è sicura se dentro c'è la dose, altrimenti ti fa un bel buco in testa e basta...\"");
                break;

            case 5:
                //Se non hai dosi contro Barboni
                out.println("----------------------------------------");
                out.println("Non avendo più dosi, cerchi di affrontarlo in un combattimento corpo a corpo, ma lui riesce a colpirti e a\n"
                        + "stenderti. Stremato, ti senti trascinare via, poi svieni.\n"
                        + "Ti risvegli, all'alba, nella tua cella. Hai un forte mal di testa per il colpo subito da Barboni.\n"
                        + "Senti la porta della cella aprirsi, ma non distingui le sagome che, nel frattempo, ti trascinano fino all'esterno\n"
                        + "del carcere. Vieni piazzato sulla ghigliottina e ti viene immobilizzata la testa dal congegno di quella macchina\n"
                        + "infernale. Ancora non riesci a percepire bene le figure che ti stanno intorno, ma riesci a vedere una di loro\n"
                        + "con una mano alzata. All'improvviso, il tizio sfocato con la mano alzata la abbassa di colpo. L'ultima cosa che\n"
                        + "senti è la fredda lama che lacera la carne della tua nuca... Poi niente più...");
                break;

            case 6:
                //Se non leghi Barboni entro le mosse consentite
                out.println("----------------------------------------");
                out.println("Cos'è questo rumore?\n\n"
                        + "All'improvviso senti scattare l'allarme e, preso dal panico, cominci a correre in cerca di un posto in cui nasconderti.\n"
                        + "I tuoi tentativi sono vani: vieni bloccato dal cecchino della torretta (per gli amici, Talpone) e da Barboni che, dopo\n"
                        + "essersi ripreso, si è precipitato in ufficio ed ha fatto scattare l'allarme.\n\n"
                        + "Dopo essere stato riaccompagnato in cella, vai a dormire. La mattina successiva le guardie vengono a prenderti e ti\n"
                        + "scortano verso la ghigliottina: vieni immobilizzato su quell'arnese e il direttore del carcere dà il comando per\n"
                        + "attivare il meccanismo. Per tutto il tempo resti apatico, pensando allo stupido errore che hai commesso: non legare\n"
                        + "Barboni. Pensi e ripensi a quello sbaglio, a quella singola cosa a cui non hai prestato attenzione, che ha fatto la\n"
                        + "grande differenza tra la libertà e l'essere ormai su quella macchina di morte.\n"
                        + "Il ripetersi di quel pensiero si spegne bruscamente mentre la lama attraversa la tua nuca e tutto si fa buio...");
                break;
        }

        waiting(out);

        out.println("==========================================================");
        out.println("Grazie per aver giocato a NASS: Not A Sabino's Saga!\n\n"
                + "Ora puoi andare a giocare a giochi migliori...");
        out.println("==========================================================");

        try {
            Thread.sleep(2500);
        } catch (InterruptedException ex) {
            System.err.println("Interrupted Exception: " + ex.getMessage());
        }

        System.exit(0);
    }

    @Override
    public void help(PrintStream out
    ) {
        out.println(""
                + "Lo so, lo so, la brutta aria che emana questo postaccio e il pensiero che, se non ti sbrigassi, ci resteresti secco\n"
                + "non sono amici della concentrazione, quindi ecco un paio di indicazioni, nel caso in cui ti dovessero sfuggire... \n");

        try {
            Thread.sleep(2000);
        } catch (InterruptedException ex) {
            System.err.println("Interrupted Exception: " + ex.getMessage());
        }

        out.println(""
                + "============================================================================================================================\n"
                + "                                                      AIUTO COMANDI                                                         \n"
                + "  Per muoverti all'interno del gioco, usa i seguenti comandi:                                                               \n"
                + "    >> NORD -> Spostati in direzione NORD                                                                                   \n"
                + "    >> SUD -> Spostati in direzione SUD                                                                                     \n"
                + "    >> EST -> Spostati in direzione EST                                                                                     \n"
                + "    >> OVEST -> Spostati in direzione OVEST                                                                                 \n"
                + "    >> APRI <oggetto> -> Apre un oggetto che potrebbe contenere qualcosa                                                    \n"
                + "    >> INVENTARIO -> Mostra il contenuto del tuo inventario                                                                 \n"
                + "    >> PRENDI <oggetto> -> Metti l'oggetto nell'inventario                                                                  \n"
                + "    >> LASCIA <oggetto> -> Lascia l'oggetto nella stanza                                                                    \n"
                + "    >> USA <ogg_inventario> (SU <oggetto>) -> Usa un oggetto presente nell'inventario (da solo o su un altro oggetto)       \n"
                + "    >> DAI <ogg_inventario> A <personaggio> -> Dai un tuo oggetto ad un...soggetto                                          \n"
                + "    >> GUARDA -> Ti permette di guardarti intorno nella stanza, per carpire dettagli aggiuntivi                             \n"
                + "    >> ESAMINA <ogg_inventario>/<personaggio>/<oggetto> -> Osserva più attentamente un oggetto specifico, oppure una persona\n"
                + "    >> INTERAGISCI CON <personaggio>/<oggetto> -> Ti permette di interagire con qualcuno o qualcosa                         \n"
                + "    >> RIFLETTI SU <oggetto>/<ogg_inventario> -> Ti permette di ragionare meglio su un oggetto                              \n"
                + "    >> SPARATI UNA DOSE -> Sai l'arma di Sabino? Bene, in questo modo potrai utilizzarla. Niente di illegale eh! O quasi... \n"
                + "    >> SALVA -> Salva la partita                                                                                            \n"
                + "    >> CARICA -> Carica la partita                                                                                          \n"
                + "    >> ESCI -> Esci dal gioco (magari ti avesse fatto uscire dal carcere, eh?)                                              \n"
                + "    >> AIUTO -> Mostra la schermata di comandi principali (cioè, questa...)                                                 \n"
                + "============================================================================================================================\n"
        );

        try {
            Thread.sleep(3000);
        } catch (InterruptedException ex) {
            System.err.println("Interrupted Exception: " + ex.getMessage());
        }

        out.println(""
                + "Il comando INTERAGISCI è un comando abbastanza universale, usalo con saggezza!\n\n"
                + "Ovviamente potrei aver dimenticato qualcosa,ma sono certo che te la saprai cavare...\n");

    }

    private void waiting(PrintStream out) {
        out.println("\n[ Premi INVIO per continuare ]");
        try {
            System.in.read();
        } catch (IOException ex) {
            System.err.println("Errore nella lettura dell'invio. " + ex.getMessage());
        }
    }

    private void visibilityChanger(Room room, int idObject) {
        for (GameObject obj : room.getObj()) {
            if (obj.getId() == idObject) {
                if (obj.isVisible()) {
                    obj.setVisible(false);
                } else {
                    obj.setVisible(true);
                }
            }
        }
    }

    private void unlock(ContainerObject cObj, GameObject key, PrintStream out) {
        cObj.setOpen(true);
        getInventory().remove(key);
        out.println("Hai sbloccato la serratura di " + cObj.getName() + " con la chiave.\n"
                + key.getName() + " rimossa dall'inventario!");
    }

    private void checkCounter(PrintStream out) {
        if (eventCounter > -1) {
            eventCounter++;
        }

        if (eventCounter >= MOVES_GAMEOVER) {
            gameOver(out, 6);
        }
    }
}

/* Da sistemare
 *  - Se prendi la bambola di pezza AND se hai parlato con il Capo
 *      getRooms().get(16).setToggleDose(getRooms().get(28));
 *  - visibilityChanger(getRooms().get(id),idobj);
 *  - IMPORTANTE! Gestire la presenza del personaggio nelle stanze dosi.
 */
//  NEXT    --------------------------------------------------------------------------------------------------------------------------------------
//  TODO: risolvere problema LOAD e EXIT se non metti nè si nè no
//  TODO: gestire numero combinazione pad aumentato in guarda cartello nel mondo della dose
//  ----------------------------------------------------------------------------------------------------------------------------------------------
//
//  AFTER   --------------------------------------------------------------------------------------------------------------------------------------
//  TODO: trasformare codice ridondante in metodi (se si riesce e se si può, creare delle classi nel caso possa avere senso)
//  TODO: eventualmente, inserire un altro gameover nel caso si recuperino 5 numeri
//  TODO: controllare se effettivamente servono i metodi addAmmo e isFull della DoseGun
//  TODO: stampa delle dosi dopo il loading
//  TODO: sistemare stringhe con gli spazi e i ritorni a capo giusti
//  TODO: sistemare l'ingresso in Cortile se si ha la divisa addosso
//  ----------------------------------------------------------------------------------------------------------------------------------------------
//
//  REFINEMENT  ----------------------------------------------------------------------------------------------------------------------------------
//  TODO: inserire stringa Interact per gli oggetti nel DB
//  TODO: inserire int nella classe NPC per gestire i dialoghi
//  ----------------------------------------------------------------------------------------------------------------------------------------------
// PER CONTROLLI -----
//        for (Room r : getRooms()){
//            System.out.println("Room " + r.getId() + " at position " + getRooms().indexOf(r));
//        }
//        
//        System.exit(0);
