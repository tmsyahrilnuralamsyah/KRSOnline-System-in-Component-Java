import java.io.BufferedReader;
import java.io.FileReader;
import java.io.File;

public class Account implements Authenticate {
    private KrsOnline krs;
    private String name, npm, pass;
    private boolean isValid;

    /**
     * Inisialisasi npm dan password untuk login
     * 
     * @param npm   npm mahasiswa
     * @param pass  password akun
     */
    public Account(String npm, String pass) {
        this.npm = npm;
        this.pass = pass;
        this.isValid = false;
    }

    /**
     * Aksi yang dilakukan saat tombol konfirmasi ditekan
     * 
     */
    public void krsProvided() {
        if (this.krs != null)
            this.krs.provided();
        else {
            System.exit(0);
            System.out.println("\nLogin terlebih dahulu...");
        }
    }

    /**
     * Untuk melakukan login
     * 
     */
    public void login() {
        try {
            if (this.isValid)
                System.out.println("\nAnda sudah login..");
            else if (this.validation()) {
                System.out.println("\nLogin sukses...");
                this.isValid = true;
                this.krs = new KrsOnline();
            } else
                System.out.println("\nNPM atau password anda masukkan salah... ");
        } catch (Exception e) {
            System.out.println("\nDatabase tidak ditemukan...");
        }
    }

    /**
     * Validasi untuk mengecek apakah akun yang ingin login terdaftar di database
     */
    private boolean validation() throws Exception {
        File file = new File("db/account.txt");
        BufferedReader br = new BufferedReader(new FileReader(file));

        String line;
        while ((line = br.readLine()) != null) {
            String[] identity = line.split(":");
            if (identity[0].equals(this.npm) && identity[1].equals(this.pass)) {
                this.name = identity[2];
                return true;
            }
        }
        return false;
    }

    /**
     * Untuk melakukan logout
     */
    public void logout() {
        if (this.isValid) {
            this.krs = null;
            System.out.println("\nLogout sukses...");
        } else
            System.out.println("\nAnda gagal logout...");
        this.isValid = false;
    }

    /**
     * Menampilkan identitas pengguna yang telah login
     */
    public void getIdentity() {
        if (this.isValid) {
            System.out.println("\nNama\t: " + this.name);
            System.out.println("NPM\t: " + this.npm);
            if (this.krs.isiKrs()) {
                System.out.println("Anda Sudah Mengisi KRS");
                System.out.println("Status\t: " + "Aktif");
            } else {
                System.out.println("Anda Belum Mengisi KRS");
                System.out.println("Status\t: " + "Registrasi");
            }
        } else
            System.out.println("\nLogin terlebih dahulu...");
    }
}