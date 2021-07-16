/*
 * NOT A SABINO'S SAGA - MS_C ©2021
 * This is surely not a Sabino's Saga. Anyway, Sabino is still here...
 */

 /*
TODO: IMPORTANTE! Gestire la presenza del personaggio nelle stanze dosi.
TODO: Comando OPEN modificato;
       [ Nel momento in cui il personaggio esegue il comando OPEN, si entra in un ciclo while
         dal quale è possibile uscire solo con il comando CLOSE.
         All'interno è possibile eseguire i comandi PICK_UP, LOOK_UP e HINT un numero indefinito
         di volte. ]
TODO: Inserire tramite END o QUIT la chiusura del gioco tra i comandi, usando exit(0);
TODO: Per comando OPEN, usare condizione con istanceof per capire se è un ContainerObject
TODO: Attributo booleano save?
 */
package mainPackage.game;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.PrintStream;
import java.sql.SQLException;
import mainPackage.parser.ParserFilter;
import mainPackage.GameDescription;
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

    private Inventory alternativeInventory = new Inventory(3); //TODO: cambiare slot

    private DoseGun gun = new DoseGun(16, 8);

    private boolean guardUniform = false;

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
        setInRoom(corridoioIniziale);
    }

    @Override
    public void nextMove(ParserFilter funnel, PrintStream out) {
        out.println();

        //Switch sul tipo di comando
        if (funnel.getCommand() != null) {

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
                        setInRoom(getInRoom().getWest());
                        getInRoom().printRoom();
                    }
                    break;

                case OPEN:
                    break;

                case CLOSE:
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
                            if (!getInventory().isFull()) {
                                getInventory().add(funnel.getObject());
                                getInRoom().removeObj(funnel.getObject());
                                out.println("----------------------------------------");
                                out.println("Hai messo in tasca: " + funnel.getObject().getName() + ".");
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

                case DROP:
                    if (funnel.getInventoryObj() != null) {
                        getInventory().remove(funnel.getInventoryObj());
                        getInRoom().addObj(funnel.getInventoryObj());
                        out.println("----------------------------------------");
                        out.println("Hai lasciato: " + funnel.getInventoryObj().getName() + " in questa stanza.");
                    } else {
                        out.println("Non hai questo oggetto nelle tasche...");
                    }
                    break;

                case USE:
                    break;

                case GIVE:
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
                            if(getInRoom().getObj().isEmpty()){
                                out.println("Non ci sono oggetti nella stanza da poter raccogliere.");
                            } else{
                                out.println("Nella stanza ci sono questi oggetti da poter raccogliere:");
                                for(GameObject item : getInRoom().getObj()){
                                    out.println(item.getName());
                                }
                            }
                        }
                    }
                    break;

                case INTERACT:
                    break;

                case THINK_ABOUT:
                    
                    break;

                case DOSE:
                    break;

                case SAVE:
                    break;

                case LOAD:
                    break;

                case END:
                    printEnd();
                    break;

                case HELP:
                    try {
                    help();
                } catch (InterruptedException ex) {
                    System.err.println("In questo momento non riesco ad aiutarti");
                }

                break;

                default: //Non dovrebbe servire, perché l'if iniziale esclude a priori comandi non validi
                    out.println("Non hai messo un comando valido!");
                    break;
            }
        } else {
            out.println("Non hai messo un comando valido!");
        }

        out.println();
    }

    @Override
    public void printStart() {
        //  TODO sistemare la formattazione
        System.out.println(""
                + "============================================================\n"
                + "    BENVENUTO IN NASS                                       \n"
                + "    In quest'avventura, sfortunatamente, non vestirai i     \n"
                + "    panni di Sabino Ciampa, ma del suo coinquilino che,     \n"
                + "    pur essendo innocente, è stato incastrato e rinchiuso   \n"
                + "    nel QGFC, il carcere di ''''''massima'''''' sicurezza   \n"
                + "    della città di...vabbè dai, chi se ne frega di dove     \n"
                + "    siamo!                                                  \n"
                + "                                                            \n"
                + "    Il problema è serio: tra poche ore vedrai la tua        \n"
                + "    ultima alba, visto che verrai giustiziato...con         \n"
                + "    la dannata ghigliottina! Ti rendi conto?                \n"
                + "    Nel 21esimo secolo, ancora appresso alle cagate         \n"
                + "    medievali!                                              \n"
                + "                                                            \n"
                + "    Comunque... il tuo obiettivo è quello di riuscire ad    \n"
                + "    evadere e, per farlo, ti verrà in aiuto una speciale    \n"
                + "    ehm...droga...che ha creato il caro Sabino.             \n"
                + "                                                            \n"
                + "    Che poi, chi cazz è Sabino!? Mah...                     \n"
                + "                                                            \n"
                + "    Attento però! Non sarà così semplice! Non tutto è       \n"
                + "    quello che sembra! Vabbè tranquillo, tanto ora Sabino   \n"
                + "    ti spiega tutto, ciao ciao...                           \n"
                + "    Ah, dimenticavo, hai solo x minuti per evadere! Siiii,  \n"
                + "    lo so, prima avevo parlato di 'ore', ma che vuoi da me: \n"
                + "    gli sviluppatori di sto gioco sono dei cani e non lo    \n"
                + "    hanno fatto durare nemmeno il tempo di una              \n"
                + "    pennichella...                                          \n"
                + "============================================================\n");
        System.out.println("[ Premi INVIO per continuare ]");

        try {
            System.in.read();
        } catch (IOException ex) {
            System.err.println("Errore nella lettura dell'invio. " + ex.getMessage());
        }
    }

    @Override
    public boolean save() throws IOException {
        ObjectOutputStream outStream = new ObjectOutputStream(new FileOutputStream("./saves/NASS.dat"));
        outStream.writeObject(this);
        outStream.close();

        return true; //Indica se il file è stato salvato
    }

    @Override
    public GameDescription load() throws IOException, ClassNotFoundException {
        ObjectInputStream inStream = new ObjectInputStream(new FileInputStream("./saves/NASS.dat"));
        NASS game = (NASS) inStream.readObject();
        inStream.close();

        return game;
    }

    @Override
    public void printEnd() {
        //Finale
        System.exit(0);
    }

    @Override
    public void gameOver() {
        //Stamperà il messaggio di game over
        System.exit(0);
    }

    @Override
    public void help() throws InterruptedException {
        System.out.println(""
                + "Lo so, lo so, la brutta aria che emana questo postaccio e\n"
                + "il pensiero che, se non ti sbrigassi, ci resteresti secco\n"
                + "non sono amici della concentrazione, quindi ecco un paio \n"
                + "di indicazioni, nel caso in cui ti dovessero sfuggire... \n");

        Thread.sleep(3000);

        System.out.println(""
                + "===========================================================================================================================\n"
                + "                                                      AIUTO COMANDI                                                        \n"
                + "  Per muoverti all'interno del gioco, usa i seguenti comandi:                                                              \n"
                + "    >> NORD -> Spostati in direzione NORD                                                                                  \n"
                + "    >> SUD -> Spostati in direzione SUD                                                                                    \n"
                + "    >> EST -> Spostati in direzione EST                                                                                    \n"
                + "    >> OVEST -> Spostati in direzione OVEST                                                                                \n"
                + "    >> APRI <contenitore> -> Apre un contenitore                                                                           \n"
                + "    >> CHIUDI <contenitore> -> Chiude un contenitore                                                                       \n"
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

        System.out.println(""
                + "Il comando INTERAGISCI è un comando abbastanza universale, usalo con saggezza!\n\n"
                + "Ovviamente potrei aver dimenticato qualcosa,ma sono certo che te la saprai cavare...    \n");

    }
}
