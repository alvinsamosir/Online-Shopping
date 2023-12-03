/**
 * Kelas yang merepresentasikan objek Admin pada sistem.
 * Admin adalah akun khusus yang memiliki kemampuan untuk menetapkan metode pembayaran
 * seperti QRIS, Bank, dan COD.
 * Kelas ini merupakan turunan dari kelas Akun.
 * 
 * 
*/

class Admin extends Akun {
    public Admin(String id, String nama) {
        super(id, nama);
    }

    @Override
    public void setPembayaran(QRIS qris) {
        super.setPembayaran(qris);
        System.out.println("Pembayaran QRIS telah ditetapkan untuk admin " + getNama());
    }

    @Override
    public void setPembayaran(Bank bank) {
        super.setPembayaran(bank);
        System.out.println("Pembayaran Bank telah ditetapkan untuk admin " + getNama());
    }

    @Override
    public void setPembayaran(COD cod) {
        super.setPembayaran(cod);
        System.out.println("Pembayaran COD telah ditetapkan untuk admin " + getNama());
    }
}
