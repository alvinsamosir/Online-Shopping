/**
 * Class yang merepresentasikan pelanggan dalam sistem toko online.
 * Setiap pelanggan memiliki ID, nama, keranjang belanja (basket), dan informasi pembayaran yang terkait.
 * Kelas ini merupakan turunan dari class Akun.
 */

class Customer extends Akun {
    private ListBarang basket; //basket akan digunakan untuk menyimpan barang-barang yang dipilih oleh pelanggan. 
    //Jadi, jika pelanggan menambahkan barang ke keranjang, itu akan tercermin dalam objek basket ini.

    public Customer(String id, String nama) {
        super(id, nama);
        this.basket = new ListBarang();
    }

    public ListBarang getBasket() {
        return basket;
    }

    @Override
    public void setPembayaran(QRIS qris) {
        super.setPembayaran(qris);
        System.out.println("Pembayaran QRIS telah ditetapkan untuk pelanggan " + getNama());
    }

    @Override
    public void setPembayaran(Bank bank) {
        super.setPembayaran(bank);
        System.out.println("Pembayaran Bank telah ditetapkan untuk pelanggan " + getNama());
    }

    @Override
    public void setPembayaran(COD cod) {
        super.setPembayaran(cod);
        System.out.println("Pembayaran COD telah ditetapkan untuk pelanggan " + getNama());
    }
   
}