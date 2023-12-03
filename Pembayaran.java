
// Antarmuka untuk metode pembayaran
interface MetodePembayaran {
    void prosesPembayaran(double jumlah);
}

// Kelas abstrak Pembayaran
abstract class Pembayaran {
    String kodeBarang;

    public Pembayaran(String kodeBarang) {
        this.kodeBarang = kodeBarang;
    }

    // Metode abstrak yang harus diimplementasikan oleh kelas turunan
    public abstract void konfirmasiPembayaran();
}

// // Implementasi metode pembayaran QRIS
// class QRIS extends Pembayaran implements MetodePembayaran {
//     public QRIS(String kodeBarang) {
//         super(kodeBarang);
//     }

//     @Override
//     public void konfirmasiPembayaran() {
//         System.out.println("Konfirmasi pembayaran melalui QRIS dengan ID: " + kodeBarang);
//     }

//     @Override
//     public void prosesPembayaran(double jumlah) {
//         System.out.println("Proses pembayaran QRIS dengan jumlah: " + jumlah);
//     }
// }

// // Implementasi metode pembayaran Bank
// class Bank extends Pembayaran implements MetodePembayaran {
//     public Bank(String kodeBarang) {
//         super(kodeBarang);
//     }

//     @Override
//     public void konfirmasiPembayaran() {
//         System.out.println("Konfirmasi pembayaran melalui transfer bank dengan ID: " + kodeBarang);
//     }

//     @Override
//     public void prosesPembayaran(double jumlah) {
//         System.out.println("Proses pembayaran transfer bank dengan jumlah: " + jumlah);
//     }
// }

// // Implementasi metode pembayaran COD (Cash On Delivery)
// class COD extends Pembayaran implements MetodePembayaran {
//     public COD(String kodeBarang) {
//         super(kodeBarang);
//     }

//     @Override
//     public void konfirmasiPembayaran() {
//         System.out.println("Konfirmasi pembayaran melalui metode Cash On Delivery (COD) dengan ID: " + kodeBarang);
//     }

//     @Override
//     public void prosesPembayaran(double jumlah) {
//         System.out.println("Proses pembayaran COD dengan jumlah: " + jumlah);
//     }
// }

