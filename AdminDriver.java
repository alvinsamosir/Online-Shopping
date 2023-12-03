// import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.Scanner;

/**
 * Kelas yang merepresentasikan objek Driver dengan peran sebagai Admin dalam sistem toko Online.
 * AdminDriver dapat melakukan berbagai operasi terkait pengelolaan barang di toko.
 * Kelas ini merupakan turunan dari kelas Driver.
 */

class AdminDriver extends Driver {
    private int stok;

    public AdminDriver(Akun akun, ListBarang listBarang) {
        super(akun, listBarang);
    }

    @Override
    public void login() {
        System.out.println("Admin " + akun.getId() + " login.");
    }

    @Override
    public void kelolaBarang(Scanner scanner) {
        try {
            while (true) {
                System.out.println("\nList Barang:");
                listBarang.tampilanTabel();
                
                System.out.println("\nMenu Kelola Barang:");
                System.out.println("1. Tambah Barang");
                System.out.println("2. Hapus Barang");
                System.out.println("3. Edit Barang");
                System.out.println("0. Kembali");
                System.out.print("Pilih opsi: ");
                int pilihan = scanner.nextInt();
                switch (pilihan) {
                    case 1:
                    System.out.print("Masukkan ID barang: ");
                    String kodeBarang = scanner.next();
                    System.out.print("Masukkan Nama barang: ");
                    String namaBarang = scanner.next();
                    double harga = 0.0;
                    while (true) {
                        try {
                            System.out.print("Masukkan Harga barang: ");
                            harga = scanner.nextDouble();
                            break;
                        } catch (InputMismatchException e) {
                            System.out.println("Harga tidak valid. Masukkan angka.");
                            scanner.next();
                        }
                    }
                    int jumlahBarang = 0;
                    while (true) {
                        try {
                            System.out.print("Masukkan Jumlah barang: ");
                            jumlahBarang = scanner.nextInt();
                            break;
                        } catch (InputMismatchException e) {
                            System.out.println("Jumlah tidak valid. Masukkan angka.");
                            scanner.next();
                        }
                    }
                    Barang barang = new Barang(kodeBarang, namaBarang, harga, stok);
                    barang.setStok(jumlahBarang); // Set the quantity
                    listBarang.tambahBarang(barang);
                    System.out.println("Barang berhasil ditambahkan: " + barang);
                    break;
                    case 2:
                        System.out.print("Masukkan ID barang yang akan dihapus: ");
                        String idBarangHapus = scanner.next();
                        Barang barangHapus = listBarang.hapusBarang(idBarangHapus);
                        if (barangHapus != null) {
                            System.out.println("Barang berhasil dihapus: " + barangHapus);
                        } else {
                            System.out.println("Barang dengan ID " + idBarangHapus + " tidak ditemukan.");
                        }
                        break;
                    case 3:
                        System.out.print("Masukkan ID barang yang akan diedit: ");
                        String idBarangEdit = scanner.next();
                        Barang barangEdit = listBarang.cariBarangById(idBarangEdit);
                        if (barangEdit != null) {
                            System.out.print("Masukkan Nama barang baru: ");
                            String namaBarangEdit = scanner.next();
                            System.out.print("Masukkan Harga barang baru: ");
                            double hargaBarangEdit = scanner.nextDouble();
                            System.out.print("Masukkan Stok barang baru: ");
                            int stokBarangEdit = scanner.nextInt();
                            barangEdit.setStok(stokBarangEdit);
                            barangEdit.setNamaBarang(namaBarangEdit);
                            barangEdit.setHarga(hargaBarangEdit);
                            System.out.println("Barang berhasil diedit: " + barangEdit);
                        } else {
                            System.out.println("Barang dengan ID " + idBarangEdit + " tidak ditemukan.");
                        }
                        break;

                    case 0:
                        return; // Keluar dari metode jika pilihan adalah 0
                    default:
                        System.out.println("Pilihan tidak valid. Silakan coba lagi.");
                        break;
                }
            }
        }catch (InputMismatchException e) {
            System.out.println("Input tidak valid. Silakan coba lagi.");
            scanner.nextLine(); // Consume the invalid input
        }
    }

    @Override
    public void masukkanKeranjang() {
        // Admin cannot buy items
        System.out.println("Admin tidak dapat melakukan pembelian.");
    }

    @Override
    public void lihatListBarang() {
        // Admin can view the list of items
        System.out.println("\nList Barang:");
        for (Barang barang : listBarang.getBarang()) {
            System.out.println(barang);
        }
    }

    @Override
    public void checkout() {
        // Admin cannot checkout
        System.out.println("Admin tidak dapat melakukan checkout.");
    }

    @Override
    public void pilihMetodePembayaran() {
        // Admin cannot choose a payment method
        System.out.println("Admin tidak dapat memilih metode pembayaran.");
    }
}
