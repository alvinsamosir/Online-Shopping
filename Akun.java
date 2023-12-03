/**
 * Kelas abstract yang merepresentasikan akun pengguna dalam sistem toko online.
 * Akun memiliki ID, nama, dan informasi pembayaran yang terkait.
 * Kelas ini menyediakan metode-metode umum yang dapat digunakan oleh berbagai jenis akun.
 * 
*/

abstract class Akun {
    private String id;
    private String nama;
    protected Pembayaran pembayaran;

    public Akun(String id, String nama) {
        this.id = id;
        this.nama = nama;
    }

    public String getId() {
        return id;
    }

    public String getNama() {
        return nama;
    }

    public void setNama(String nama) {
        this.nama = nama;
    }

    public Pembayaran getPembayaran() {
        return pembayaran;
    }

    public void login() {
        // Implementasi login
        System.out.println("Login as: " + getNama());
    }

    public ListBarang getBasket() {
        // Return the basket for the user (Customer)
        return null;
    }
    public void setPembayaran(QRIS qris){
    }

    public void setPembayaran(Bank bank) {
    }

    public void setPembayaran(COD cod) {
    }
}
