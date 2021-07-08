/*
 * NOT A SABINO'S SAGA - MS_C ©2021
 * This is surely not a Sabino's Saga. Anyway, Sabino is still here...
*/

 /*
TODO: Boolean per la divisa;
TODO: Inventario dose;
TODO: Metodi per caricamento da DB, con relative SQLException;
TODO: Comando OPEN modificato;
       [ Nel momento in cui il personaggio esegue il comando OPEN, si entra in un ciclo while
         dal quale è possibile uscire solo con il comando CLOSE.
         All'interno è possibile eseguire i comandi PICK_UP, LOOK_UP e HINT un numero indefinito
         di volte. ]
TODO: Inserire tramite END o QUIT la chiusura del gioco tra i comandi, usando exit(0);
TODO: Richiamare il costruttore di Inventory per inizializzare gli slots;
*/
package mainPackage.game;

import java.io.IOException;
import java.io.PrintStream;
import mainPackage.parser.ParserFilter;
import mainPackage.GameDescription;

/*
 *
 *
 * @author MS_C
 */
public class NASS extends GameDescription {

    //  OVERRIDED METHODS
    @Override
    public void init() {

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
