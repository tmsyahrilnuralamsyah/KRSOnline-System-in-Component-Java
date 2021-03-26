import java.util.Scanner;

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

        System.out.print("\nNPM\t\t: ");
        String npm = input.nextLine();
        System.out.print("Password\t: ");
        String pass = input.nextLine();

        Account a = new Account(npm, pass);
        a.login();
        a.getIdentity();
        a.krsProvided();
        a.getIdentity();
        // a.krsProvided();
        a.logout();
    }
}