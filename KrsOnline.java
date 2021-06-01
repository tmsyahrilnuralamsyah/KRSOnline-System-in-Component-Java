public class KrsOnline implements Confirmation {
    private boolean isiKrs;
    private Database db;

    /**
     * Inisialisasi awal KRS Online
     */
    public KrsOnline() {
        this.isiKrs = false;
        // db = new Database();
    }

    public void connectTo(Database db) {
        this.db = db;
    }

    public void loginKrs(Account acc) {
        db.login(acc.getNpm(), acc.getpass());
        acc.setAuthenticated();
    }

    public void logoutKrs() {
        db.logout();
    }

    /**
     * Aksi yang dilakukan saat tombol ditekan
     */
    public void provided() {
        if (!this.isiKrs) {
            this.isiKrs = true;
            System.out.println("\nBerhasil mengisi KRS...\n");
        } else
            System.out.println("\nAnda sudah mengisi KRS, silahkan menunggu persetujuan dosen wali");
    }

    /**
     * Memberitahu apakah telah mengisi KRS atau belum
     * 
     * @return boolean
     */
    public boolean isiKrs() {
        return this.isiKrs;
    }
}