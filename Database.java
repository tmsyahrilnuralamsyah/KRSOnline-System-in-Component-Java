import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;

public class Database implements Authenticate{
    private boolean isAuthenticated = false;

    public void login(String npm, String pwd) {
        try {
            if (this.isAuthenticated)
            System.out.println("\nAnda sudah login..");
            else if (this.validation(npm, pwd)) {
                System.out.println("\nLogin sukses...\n");
                this.isAuthenticated = true;
                // this.krs = new KrsOnline();
            } else
                System.out.println("\nNPM atau password anda masukkan salah... ");
        } catch (Exception e) {
            System.out.println("\nDatabase tidak ditemukan...");
        }
    }

    /**
     * Validasi untuk mengecek apakah akun yang ingin login terdaftar di database
     */
    private boolean validation(String npm, String pwd) throws Exception {
            for (Account acc : getAccounts()) {
                if (acc.getNpm().equals(npm) && acc.getpass().equals(pwd))
                    return true;
            }
        System.out.println("Gagal");
        return false;
    }

    /**
     * Mengkonfirmasi logout
     */
    public void logout() {
        if (this.isAuthenticated) {
            // this.krs = null;
            System.out.println("\nLogout sukses...");
        } else
            System.out.println("\nAnda gagal logout...");
        this.isAuthenticated = false;
    }

    public ArrayList<Account> getAccounts() throws Exception {
        ArrayList<Account> tmp = new ArrayList<>();
        File file = new File("db/account.txt");
        BufferedReader br;

        br = new BufferedReader(new FileReader(file));
        String line;
        while ((line = br.readLine()) != null) {
            String[] identity = line.split(":");
            tmp.add(new Account(identity[0], identity[1], identity[2]));
        }
        return tmp;
    }

    public boolean isAuthenticated() {
        return this.isAuthenticated;
    }
}