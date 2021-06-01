public class Account {
    private KrsOnline krs;
    private String name, npm, pass;
    private boolean isAuthenticated;

    public String getNpm() {
        return this.npm;
    }

    public String getName() {
        return this.name;
    }

    public String getpass() {
        return this.pass;
    }

    /**
     * Inisialisasi npm dan password untuk login
     * 
     * @param npm   npm mahasiswa
     * @param pass  password akun
     */
    public Account(String npm, String pass) {
        this.npm = npm;
        this.pass = pass;
        this.isAuthenticated = false;
    }
    
    public Account(String npm, String pass, String name) {
        this.npm = npm;
        this.pass = pass;
        this.name = name;
        this.isAuthenticated = false;
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
     * Menampilkan identitas pengguna yang telah login
     */
    public void getIdentity() {
        if (this.isAuthenticated) {
            // System.out.println("\nNama\t: " + this.name);
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

    public void setAuthenticated() {
        this.isAuthenticated = true;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void connectTo(KrsOnline krs) {
        this.krs = krs;
    }
}