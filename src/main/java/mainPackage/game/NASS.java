/*
 * NOT A SABINO'S SAGA - MS_C ©2021
 * This is surely not a Sabino's Saga. Anyway, Sabino is still here...
 */

 /*
TODO: Boolean per la divisa;
TODO: Inventario dose;
TODO: Assegnare la DoseGun
TODO: Comando OPEN modificato;
       [ Nel momento in cui il personaggio esegue il comando OPEN, si entra in un ciclo while
         dal quale è possibile uscire solo con il comando CLOSE.
         All'interno è possibile eseguire i comandi PICK_UP, LOOK_UP e HINT un numero indefinito
         di volte. ]
TODO: Inserire tramite END o QUIT la chiusura del gioco tra i comandi, usando exit(0);
TODO: Richiamare il costruttore di Inventory per inizializzare gli slots;
TODO: Per comando OPEN, usare condizione con istanceof per capire se è un ContainerObject
 */
package mainPackage.game;

import java.io.IOException;
import java.io.PrintStream;
import java.sql.SQLException;
import mainPackage.parser.ParserFilter;
import mainPackage.GameDescription;
import mainPackage.type.Room;
import static mainPackage.utilities.NassDB.*;

/*
 *
 *
 * @author MS_C
 */
public class NASS extends GameDescription {

    //  OVERRIDED METHODS
    @Override
    public void init() throws SQLException {
        
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
        Room incrocioCorridoioIniziale = initRoom(13, getRooms());
        Room corridoioInterno = initRoom(14, getRooms());
        Room incrocioPrincipale = initRoom(15, getRooms());
        Room corridoioCortile = initRoom(16, getRooms());
        Room cortile = initRoom(17, getRooms());
        Room corridoioIniziale = initRoom(18, getRooms());

        //   ALTERNATIVE ROOMS CONSTRUCTION
        Room ghorigapec = initRoom(19, getRooms());
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

        //   MAP (boundaries)
        initBoundaries(parcheggio,getRooms());
        initBoundaries(ufficio,getRooms());
        initBoundaries(ingressoPrincipale,getRooms());
        initBoundaries(corridoioTorretta,getRooms());
        initBoundaries(passaggioCucina,getRooms());
        initBoundaries(entrataZonaCarcere,getRooms());
        initBoundaries(angoloCorridoio,getRooms());
        initBoundaries(spogliatoio,getRooms());
        initBoundaries(corridoioSpogliatoio,getRooms());
        initBoundaries(cucina,getRooms());
        initBoundaries(mensa,getRooms());
        initBoundaries(corridoioMensa,getRooms());
        initBoundaries(torreOsservazione,getRooms());
        initBoundaries(incrocioCorridoioIniziale,getRooms());
        initBoundaries(corridoioInterno,getRooms());
        initBoundaries(incrocioPrincipale,getRooms());
        initBoundaries(corridoioCortile,getRooms());
        initBoundaries(cortile,getRooms());
        initBoundaries(corridoioIniziale,getRooms());
        
        initBoundaries(ghorigapec,getRooms());
        initBoundaries(ingressoPrincipale_1,getRooms());
        initBoundaries(angoloCorridoio_1,getRooms());
        initBoundaries(corridoioMensa_1,getRooms());
        initBoundaries(torreOsservazione_1,getRooms());
        initBoundaries(incrocioCorridoioIniziale_1,getRooms());
        initBoundaries(corridoioInterno_1,getRooms());
        initBoundaries(incrocioPrincipale_1,getRooms());
        initBoundaries(corridoioCortile_1,getRooms());
        initBoundaries(corridoioCortile_2,getRooms());
        initBoundaries(corridoioIniziale_1,getRooms());
        
        //  OBJECTS IN ROOMS
        
        //  NPC IN ROOMS
        initNpcInRoom(ingressoPrincipale);
        initNpcInRoom(angoloCorridoio);
        initNpcInRoom(corridoioMensa);
        initNpcInRoom(torreOsservazione);
        initNpcInRoom(corridoioInterno);
        initNpcInRoom(corridoioCortile);
        initNpcInRoom(corridoioIniziale);
        
        initNpcInRoom(ingressoPrincipale_1);
        initNpcInRoom(angoloCorridoio_1);
        initNpcInRoom(corridoioMensa_1);
        initNpcInRoom(torreOsservazione_1);
        initNpcInRoom(corridoioInterno_1);
        initNpcInRoom(corridoioCortile_1);
        initNpcInRoom(corridoioIniziale_1);
        
        //Inventario, dose gun (vedi sopra)
        
        setInRoom(corridoioIniziale);
    }

    @Override
    public void nextMove(ParserFilter funnel, PrintStream out) {

    }

    @Override
    public void printStart() {
        //  TODO sistemare la formattazione
        System.out.println(""
                + "==============================================================\n"
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
                + "    pennichella...                                           \n"
                + "==============================================================\n");
        System.out.println("[ Premi INVIO per continuare ]");

        try {
            System.in.read();
        } catch (IOException ex) {
            System.err.println("Errore nella lettura dell'invio. " + ex.getMessage());
        }
    }

    @Override
    public boolean save() {

        return true;    //  MODIFICAREEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEE
    }

    @Override
    public GameDescription load() {

        return null;    //  MODIFICAREEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEE
    }
}
