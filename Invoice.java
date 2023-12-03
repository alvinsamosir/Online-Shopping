// import java.util.List;

/**
 * Kelas invoice merepresentasikan sebuah invoice atau faktur yang berisi
 * informasi tentang transaksi dan pembayaran yang terkait.
*/

class Invoice implements MetodePembayaran{
    private Transaksi transaksi;
    private Pembayaran pembayaran;

    public Invoice(Transaksi transaksi, Pembayaran pembayaran) {
        this.transaksi = transaksi;
        this.pembayaran = pembayaran;
    }

    @Override
    public void prosesPembayaran(double jumlah) {
        System.out.println("Proses pembayaran transfer bank dengan jumlah: " + jumlah);
    }

    /**
     * Metode untuk mencetak informasi invoice, termasuk transaksi, pembayaran,
     * dan daftar barang yang dibeli.
     */
    public void cetakInvoice() {
        System.out.println("======= INVOICE =======");
        System.out.println("Transaksi ID: " + transaksi.hashCode());
        System.out.println("Metode Pembayaran: " + pembayaran.getClass().getSimpleName());
        System.out.println("Barang yang dibeli:");

        for (Barang barang : transaksi.getBarang()) {
            int jumlah = transaksi.getDaftarBarang().get(barang);
            System.out.println("- " + barang.getNamaBarang() + " (Jumlah: " + jumlah + ") - Rp " + barang.getHarga()*jumlah);
        }
        System.out.println("=======================");

        // double transaksi.hitungTotal() = transaksi.hitungTotal();
        System.out.println("Total Harga Transaksi: Rp" + transaksi.hitungTotal());
        System.out.println("------------------------");

        // double totalHargaSemuaTransaksi = transaksi.hitungTotal();
    }

}
// interface Pembayaran {
//     String getClass();
// }