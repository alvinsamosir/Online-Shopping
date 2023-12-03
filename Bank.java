// class Bank implements Pembayaran {
//     private String id;

//     public Bank(String id) {
//         this.id = id;
//     }

//     @Override
//     public String getkodeBarang() {
//         return id;
//     }

// }

class Bank extends Pembayaran  {
    public Bank(String kodeBarang) {
        super(kodeBarang);
    }

    @Override
    public void konfirmasiPembayaran() {
        System.out.println("Konfirmasi pembayaran melalui transfer bank dengan ID: " + kodeBarang);
    }

    // @Override
    // public void prosesPembayaran(double jumlah) {
    //     System.out.println("Proses pembayaran transfer bank dengan jumlah: " + jumlah);
    // }
}