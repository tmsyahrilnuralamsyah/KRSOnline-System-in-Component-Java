import java.util.Scanner;
import javax.xml.crypto.Data;

/**
 * Implementasi KRS Online
 * 
 * @author Farhan Karomi, T.M. Syahril Nur A, Izzati Husna, Fathin Shaffa Anwar
 * @version 1.0
 * @since 26-Maret-2021
 */
public class Main {
    /**
     * Menjalankan sistem KRS Online
     * 
     * @param args parameter standar untuk command line
     */
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);

        KrsOnline krs = new KrsOnline();
        Database db = new Database();
        Account acc = new Account("1808107010066", "222000");

        krs.connectTo(db);
        krs.loginKrs(acc);

        acc.connectTo(krs);
        acc.getIdentity();
        acc.krsProvided();
        acc.getIdentity();
        acc.krsProvided();

        krs.logoutKrs();
    }
}