/*
 * NOT A SABINO'S SAGA - MS_C ©2021
 * This is surely not a Sabino's Saga. Anyway, Sabino is still here...
 */

 /*
TODO: Spostare Castorpio da Cortile a Torre dopo USA PESETTO SU CASTORPIO
TODO: IMPORTANTE! Gestire la presenza del personaggio nelle stanze dosi.
 */
package mainPackage.game;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.PrintStream;
import java.sql.SQLException;
import java.util.Scanner;
import mainPackage.parser.ParserFilter;
import mainPackage.GameDescription;
import mainPackage.type.ContainerObject;
import mainPackage.type.DoseGun;
import mainPackage.type.GameObject;
import mainPackage.type.Inventory;
import mainPackage.type.Room;
import mainPackage.type.TypeCommand;
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

    //  EVENT SWITCHES
    private int eventEnlightRoom = 0;
    private int eventBossQuest = 0;

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

        //  OBJECTS IN ROOMS
        initObjectInRoom(parcheggio);
        initObjectInRoom(ufficio);
        initContainerInRoom(ufficio);
        initObjectInRoom(spogliatoio);
        initContainerInRoom(spogliatoio);
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

        //  NPC IN ROOMS
        initNpcInRoom(ingressoPrincipale);
        initNpcInRoom(angoloCorridoio);
        initNpcInRoom(corridoioMensa);
        initNpcInRoom(corridoioInterno);
        initNpcInRoom(corridoioCortile);
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
        gun = new DoseGun(16, 8);

        setInRoom(spogliatoio);
    }

    @Override
    public void nextMove(ParserFilter funnel, PrintStream out) {
        out.println();

        //Switch sul tipo di comando
        switch (funnel.getCommand().getType()) {

            case NORTH:
                if (getInRoom().getNorth() == null) {
                    out.println("Non è possibile andare a nord!");
                } else if (getInRoom().isNorthLock()) {
                    out.println("La porta a nord è chiusa a chiave!");
                } else {
                    setInRoom(getInRoom().getNorth());
                    getInRoom().printRoom();
                }

                break;

            case SOUTH:
                if (getInRoom().getSouth() == null) {
                    out.println("Non è possibile andare a sud!");
                } else if (getInRoom().isSouthLock()) {
                    out.println("La porta a sud è chiusa a chiave!");
                } else {
                    setInRoom(getInRoom().getSouth());
                    getInRoom().printRoom();
                }

                break;

            case EAST:
                if (getInRoom().getEast() == null) {
                    out.println("Non è possibile andare ad est!");
                } else if (getInRoom().isEastLock()) {
                    out.println("La porta ad est è chiusa a chiave!");
                } else {
                    setInRoom(getInRoom().getEast());
                    getInRoom().printRoom();
                }

                break;

            case WEST:
                if (getInRoom().getWest() == null) {
                    out.println("Non è possibile andare ad ovest!");
                } else if (getInRoom().isWestLock()) {
                    out.println("La porta ad ovest è chiusa a chiave!");
                } else {

                    if (getInRoom().getWest().getId() == 7 && eventEnlightRoom < 2) {
                        out.println("----------------------------------------");
                        if (eventEnlightRoom == 0) {
                            out.println("Apri la porta della stanza accanto, ma ti fermi immediatamente quando\n"
                                    + "vedi, in alto, la spia di una telecamera che punta verso l'interno della stanza stessa.\n"
                                    + "Per fortuna, le luci della stanza sono spente: forse la telecamera non ti ha visto, quindi richiudi velocemente la porta.\n"
                                    + "Bisogna neutralizzare, in qualche modo, quella telecamera prima di poter entrare.");
                            eventEnlightRoom++;
                        } else if (eventEnlightRoom == 1) {
                            out.println("Bisogna neutralizzare, in qualche modo, quella telecamera prima di poter entrare.");
                        }

                    } else {
                        setInRoom(getInRoom().getWest());
                        getInRoom().printRoom();
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

                                    //Contenitore: Scrivania 
                                    case 0:
                                        out.println("Tiri via completamente il cassetto dalla scrivania e ne rovesci il contenuto\n"
                                                + "su quest'ultima. Dopo aver finito, lanci via il cassetto e controlli cosa c'era:\n"
                                                + "insieme a molte cianfrusaglie inutili e cancelleria, trovi un");
                                        break;

                                    //Contenitore: Cassaforte
                                    case 1:
                                        out.println("Infili la chiave e ruoti fino a sentire il rumore della serratura che si sblocca,\n"
                                                + "provi a tirare ma è incastrata. Tiri con un colpo forte e deciso e la porta si\n"
                                                + "spalanca, ma l'urto fa cadere e rotolare un ");
                                        break;

                                    //Contenitore: Tasca
                                    case 2:
                                        out.println("Apri la tasca per vedere cosa c'è dentro, ma il grembiule è vecchio e rovinato:\n"
                                                + "il tuo tirare, unito al peso della roba al suo interno, la fanno strappare\n"
                                                + "e fanno cadere a terra un ");
                                        break;
                                }

                                for (GameObject item : temporaryContObj.getContained()) {
                                    out.println(item.getName());
                                }

                            } else {
                                out.println("È vuota, hai già aperto " + temporaryContObj.getName() + ".");
                            }

                        } else {
                            out.println(temporaryContObj.getName() + " è chiusa a chiave!");
                        }
                    } else {
                        out.println("Non puoi aprire " + funnel.getObject().getName() + ".");
                    }
                } else {
                    out.println("Non penso tu abbia capito come si usa questo comando.\n"
                            + "Se hai bisogno di chiarimenti, usa AIUTO");
                }

                break;

            case INVENTORY:
                if (getInventory().isEmpty()) {
                    out.println("Hai le tasche vuote!");
                } else {
                    out.println("----------------------------------------");
                    out.println("Frugando in tutte le tue " + getInventory().getSlots() + " tasche, trovi:");
                    for (GameObject obj : getInventory().getContaining()) {
                        out.println(obj.getName());
                    }
                }
                out.println();
                break;

            case PICK_UP:
                if (funnel.getObject() != null) {
                    if (funnel.getObject().isPickupable()) {

                        //Controllo se siamo nella stanza alternativa
                        Inventory temporaryInv;
                        if (getInRoom().getId() < 19) {
                            temporaryInv = getInventory();
                        } else {
                            temporaryInv = getAlternativeInventory();
                        }

                        if (!temporaryInv.isFull()) {
                            temporaryInv.add(funnel.getObject());
                            getInRoom().removeObj(funnel.getObject());
                            out.println("----------------------------------------");
                            out.println("Hai messo in tasca: " + funnel.getObject().getName() + ".");
                            if (funnel.getObject().getId() == 18) {
                                guardUniform = true;
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
                            out.println("Hai lasciato: " + funnel.getInventoryObj().getName() + " in questa stanza.");
                        }
                    }
                } else {
                    out.println("Non hai questo oggetto nelle tasche...");
                }
                break;

            case USE:
                if (funnel.getInventoryObj() != null) {
                    if (funnel.getPerson() != null && funnel.getObject() != null) {
                        out.println("Puoi usarlo o su " + funnel.getPerson().getName() + " o su " + funnel.getObject().getName() + ".");
                    } else if (funnel.getPerson() != null) {

                        switch (funnel.getPerson().getId()) {

                            //Se l'NPC è Castorpio (12)
                            case 12:
                                switch (funnel.getInventoryObj().getId()) {

                                    //Fascette (14)
                                    case 14:
                                        out.println(funnel.getPerson().getInteraction(2));
                                        break;

                                    //Pesetto (16)
                                    case 16:
                                        out.println(funnel.getPerson().getInteraction(3));
                                        getInventory().remove(funnel.getInventoryObj());
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
                                } else {
                                    out.println("Non puoi usare " + funnel.getInventoryObj().getName() + " su " + funnel.getPerson().getName() + ".");
                                }
                                break;

                            //Se è chiunque altro    
                            default:
                                out.println("Non puoi usare oggetti su " + funnel.getPerson().getName() + ".");
                                break;
                        }

                    } else if (funnel.getObject() != null) {

                        switch (funnel.getInventoryObj().getId()) {

                            //Telecamera (10) + Stagnola (11)
                            case 11:
                                if (funnel.getObject().getId() == 10) {
                                    eventEnlightRoom = 2;
                                    out.println("Sporgendoti, sei riuscito a coprire l'obiettivo della telecamera con la carta stagnola.\n"
                                            + "Hai acceso la luce e ora, finalmente, ci vedi. La prima cosa che \"fiuti\" è...");
                                }
                                getInventory().remove(funnel.getInventoryObj());
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
                                }
                                break;

                                // TODO: QUI
                            //Cassaforte (1) + Chiave (12)
                            case 12:
                                if (funnel.getObject() instanceof ContainerObject && funnel.getObject().getId() == 1) {
                                    out.println("");
                                }
                                break;

                            //Scrivania (0) + Chiave (4)
                            case 4:
                                if (funnel.getObject() instanceof ContainerObject && funnel.getObject().getId() == 0) {
                                    out.println("");
                                }
                                break;

                            //Altrimenti
                            default:

                        }

                    } else { //Entrambi null
                        //Chiave mensa
                        //Mazzo di chiavi
                    }
                } else {
                    out.println("Non puoi farlo.");
                }

                break;

            case GIVE:
                if (funnel.getPerson() != null && funnel.getInventoryObj() != null) {
                    //Controllo se è Ugo (2)
                    if (funnel.getPerson().getId() == 2) {
                        switch (funnel.getInventoryObj().getId()) {
                            //Oggetto: cellulare (5)
                            case 5:
                                out.println("----------------------------------------");
                                out.println(funnel.getPerson().getInteraction(5));
                                break;

                            //Oggetto: anello (6)
                            case 6:
                                out.println("----------------------------------------");
                                out.println(funnel.getPerson().getInteraction(4));
                                break;

                            //Oggetto: orologio (7)
                            case 7:
                                out.println("----------------------------------------");
                                out.println(funnel.getPerson().getInteraction(3));
                                break;
                        }
                        out.println("Spero tu abbia ascoltato bene, non ripeterò ciò che ho detto!");
                    }

                    //Controllo se è Bambine (11)
                    if (funnel.getPerson().getId() == 11) {
                        //Oggetto: bambola di pezza (18)
                        if (funnel.getInventoryObj().getId() == 18) {
                            out.println("----------------------------------------");
                            out.println(funnel.getPerson().getInteraction(2));
                            guardUniform = false;
                        }
                    }
                    //Altrimenti
                    out.println("----------------------------------------");
                    out.println("Non puoi dare " + funnel.getInventoryObj().getName() + " a " + funnel.getPerson().getName() + ".");
                } else {
                    out.println("Puoi dare solo un oggetto delle tue tasche a qualcuno presente in questa stanza.");
                }
                break;

            case LOOK:
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
                        out.println("----------------------------------------");
                        out.println(funnel.getObject().getDescription());
                    } else if (funnel.getInventoryObj() != null) { //Se hai inserito un oggetto dell'inventario
                        out.println("----------------------------------------");
                        out.println(funnel.getInventoryObj().getDescription());
                    } else if (funnel.getExtraWord() != null) { //Se hai inserito una parola senza significato oppure non presente nelle liste
                        out.println("----------------------------------------");
                        out.println("Circolare, circolare! Non c'è niente da vedere!");
                    } else { //Se non hai inserito nulla oltre al comando
                        out.println("----------------------------------------");
                        out.println(getInRoom().getDescriptionLook());
                        out.println("\n* * * * * * * * * * * * * * * * * * * *");
                        if (getInRoom().getObj().isEmpty()) {
                            out.println("Non ci sono oggetti nella stanza da poter raccogliere.");
                        } else {
                            out.println("Nella stanza ci sono questi oggetti da poter raccogliere:");
                            for (GameObject item : getInRoom().getObj()) {
                                if (item.isPickupable() && item.isVisible()) {
                                    out.println(item.getName());
                                }
                            }
                        }
                    }
                }
                break;

            case INTERACT:
                break;

            case THINK_ABOUT:
                //Se inserisci troppe cose su cui riflettere
                if (funnel.getInventoryObj() != null && funnel.getObject() != null) {
                    out.println("Oh, OH! Troppa roba, con calma giovane! Una cosa alla volta...");

                } else {
                    if (funnel.getObject() != null) { //Se hai inserito un oggetto
                        out.println("----------------------------------------");
                        out.println(funnel.getObject().getHint());
                    } else if (funnel.getInventoryObj() != null) { //Se hai inserito un oggetto dell'inventario
                        out.println("----------------------------------------");
                        out.println(funnel.getInventoryObj().getHint());
                    } else if (funnel.getExtraWord() != null) { //Se hai inserito una parola senza significato oppure non presente nelle liste
                        out.println("----------------------------------------");
                        out.println("Non farti viaggi astrali su qualsiasi cosa, devi sbrigarti ad evadere!");
                    } else { //Se non hai inserito nulla oltre al comando
                        out.println("----------------------------------------");
                        out.println("Devi riflettere su qualche oggetto...");
                    }
                }
                break;

            case DOSE:
                break;

            case HELP:
                    try {
                help(out);
            } catch (InterruptedException ex) {
                System.err.println("Interrupted Exception: " + ex.getMessage());
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
    public void printStart(PrintStream out) {
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
                + "Dovrai affrontare enigmi *coff* difficili *coff* che ti potranno bloccarti o addirittura portarti alla morte!\n"
                + "\n"
                + "Inizi la tua avventura nella tua cella, mentre Sabino ti sta spiegando l'utilizzo di questa sua incredibile invenzione.\n"
                + "========================================================================================================================");
        out.println("\nVuoi leggere l'inizio?");
        Scanner wannaSkip = new Scanner(System.in);
        String decision = wannaSkip.nextLine();

        if (decision.equalsIgnoreCase("SI")) {
            out.println("\"La pistola è sicura se dentro c'è la dose, altrimenti ti fa un bel buco in testa e basta\" spiega Sabino, ridendo.\n"
                    + "\"Ma come funziona?\" domani perplesso.\n"
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
                    + "Placando le risate, il tuo coinquilino conclude: \"Si, ma ora vedi di far presto e trova la via di fuga... in bocca al lupo\"\n"
                    + "\"Ok, vado\" rispondi e, riponendo la pistola nella zona interna della parte posteriore del pantalone, la prima cosa che ti\n"
                    + "chiedi è...");

            waiting(out);

        } else if (decision.equalsIgnoreCase("NO")) {

            out.println("Ok, allora sai già tutto.");
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
    public void printEnd(PrintStream out) {
        //Roba
        System.exit(0);
    }

    @Override
    public void gameOver(PrintStream out) {
        //Stamperà il messaggio di game over
        System.exit(0);
    }

    @Override
    public void help(PrintStream out) throws InterruptedException {
        out.println(""
                + "Lo so, lo so, la brutta aria che emana questo postaccio e\n"
                + "il pensiero che, se non ti sbrigassi, ci resteresti secco\n"
                + "non sono amici della concentrazione, quindi ecco un paio \n"
                + "di indicazioni, nel caso in cui ti dovessero sfuggire... \n");

        Thread.sleep(2000);

        out.println(""
                + "===========================================================================================================================\n"
                + "                                                      AIUTO COMANDI                                                        \n"
                + "  Per muoverti all'interno del gioco, usa i seguenti comandi:                                                              \n"
                + "    >> NORD -> Spostati in direzione NORD                                                                                  \n"
                + "    >> SUD -> Spostati in direzione SUD                                                                                    \n"
                + "    >> EST -> Spostati in direzione EST                                                                                    \n"
                + "    >> OVEST -> Spostati in direzione OVEST                                                                                \n"
                + "    >> APRI <contenitore> -> Apre un contenitore                                                                           \n"
                + "    >> INVENTARIO -> Mostra il contenuto del tuo inventario                                                                \n"
                + "    >> PRENDI <oggetto> -> Metti l'oggetto nell'inventario                                                                 \n"
                + "    >> LASCIA <oggetto> -> Lascia l'oggetto nella stanza                                                                   \n"
                + "    >> USA <ogg_inventario> -> Usa un oggetto presente nell'inventario                                                     \n"
                + "    >> DAI <ogg_inventario A <personaggio> -> Dai un tuo oggetto ad un...soggetto                                          \n"
                + "    >> GUARDA -> Osserva l'ambiente circostante, oppure un oggetto specifico, oppure una persona                           \n"
                + "    >> INTERAGISCI CON <personaggio>/<oggetto> -> Ti permette di interagire con qualcuno o qualcosa                        \n"
                + "    >> RIFLETTI SU <oggetto> -> Ti permette di esaminare meglio un oggetto                                                 \n"
                + "    >> SPARATI UNA DOSE -> Sai l'arma di Sabino? Bene, in questo modo potrai utilizzarla. Niente di illegale eh! O quasi...\n"
                + "    >> SALVA -> Salva la partita                                                                                           \n"
                + "    >> CARICA -> Carica la partita                                                                                         \n"
                + "    >> ESCI -> Esci dal gioco (magari ti avesse fatto uscire dal carcere, eh?)                                             \n"
                + "===========================================================================================================================\n"
        );

        Thread.sleep(3000);

        out.println(""
                + "Il comando INTERAGISCI è un comando abbastanza universale, usalo con saggezza!\n\n"
                + "Ovviamente potrei aver dimenticato qualcosa,ma sono certo che te la saprai cavare...    \n");

    }

    private void waiting(PrintStream out) {
        out.println("\n[ Premi INVIO per continuare ]");
        try {
            System.in.read();
        } catch (IOException ex) {
            System.err.println("Errore nella lettura dell'invio. " + ex.getMessage());
        }
    }
}

/* Da sistemare
 *  - Se prendi la bambola di pezza AND se hai parlato con il Capo
 *      getRooms().get(16).setToggleDose(getRooms().get(28));
 *  - eventBossQuest
 *
*/