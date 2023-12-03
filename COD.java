// class COD implements Pembayaran {
//     private String kodeBarang;

//     public COD(String kodeBarang) {
//         this.kodeBarang = kodeBarang;
//     }

//     @Override
//     public String getkodeBarang() {
//         return kodeBarang;
//     }
// }

class COD extends Pembayaran {
    private String kodeBarang;

    public COD(String kodeBarang) {
        super(kodeBarang);
    }

    @Override
    public void konfirmasiPembayaran() {
        System.out.println("Konfirmasi pembayaran melalui metode Cash On Delivery (COD) dengan ID: " + kodeBarang);
    }

    // @Override
    // public void prosesPembayaran(double jumlah) {
    //     System.out.println("Proses pembayaran COD dengan jumlah: " + jumlah);
    // }

}    
