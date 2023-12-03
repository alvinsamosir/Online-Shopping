// class QRIS implements Pembayaran {
//     private String kodeBarang;

//     public QRIS(String kodeBarang) {
//         this.kodeBarang = kodeBarang;
//     }

//     @Override
//     public String getkodeBarang() {
//         return kodeBarang;
//     }
// }

class QRIS extends Pembayaran {
    private String kodeBarang;
    public QRIS(String kodeBarang) {
        super(kodeBarang);
    }


    // @Override
    // public void prosesPembayaran(double jumlah) {
    //     System.out.println("Proses pembayaran QRIS dengan jumlah: " + jumlah);
    // }

     /**
     * method untuk melakukan konfirmasi pembayaran menggunakan QRIS.
     * Menampilkan pesan konfirmasi pembayaran dengan mencantumkan ID QRIS.
     */
    @Override
    public void konfirmasiPembayaran() {
        System.out.println("Konfirmasi pembayaran melalui QRIS dengan ID: " + kodeBarang);
    }

}