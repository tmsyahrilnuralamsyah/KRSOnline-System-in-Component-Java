public class KrsOnline implements Confirmation {
    private boolean isiKrs;

    /**
     * Inisialisasi awal KRS Online
     */
    public KrsOnline() {
        this.isiKrs = false;
    }

    /**
     * Aksi yang dilakukan saat tombol ditekan
     */
    public void provided() {
        if (!this.isiKrs) {
            this.isiKrs = true;
            System.out.println("\nBerhasil mengisi KRS...");
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