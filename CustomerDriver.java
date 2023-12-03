import java.util.InputMismatchException;
import java.util.NoSuchElementException;
import java.util.Scanner;

/**
 * Kelas CustomerDriver mewakili Driver untuk operasi terkait pelanggan.
 * Ini memperluas kelas Driver dan menyediakan metode untuk mengelola keranjang belanja,
 * checkout item, memilih metode pembayaran, dan menampilkan keranjang belanja.
 */

 class CustomerDriver extends Driver {
    private Scanner scanner;
    public CustomerDriver(Akun akun, ListBarang listBarang, Scanner scanner) {
        super(akun, listBarang);
        this.scanner = scanner;

    }

    @Override
    public void login() {
        System.out.println("Customer " + akun.getId() + " login.");
    }

    @Override
    public void kelolaBarang(Scanner scanner) {
        try {
            while (true) {
                System.out.println("\nList barang di keranjang:");
                 listBarang.keranjangBelanja();

                for (Barang barang : listBarang.getBarang()) {
                    System.out.println(barang);
                }
                System.out.println("\nMenu Kelola Barang pada keranjang:");
                System.out.println("1. Tambah Barang");
                System.out.println("2. Hapus Barang");
                System.out.println("3. Edit Barang");
                System.out.println("0. Kembali");
                System.out.print("Pilih opsi: ");
                int pilihan = scanner.nextInt();
                switch (pilihan) {
                    case 1:
                        System.out.print("Masukkan ID barang yang akan ditambahkan ke keranjang: ");
                        String idBarangTambah = scanner.next();
                        Barang barangTambah = listBarang.cariBarangById(idBarangTambah);
                        if (barangTambah != null) {
                            akun.getBasket().tambahBarang(barangTambah);
                            System.out.println("Barang berhasil ditambahkan ke keranjang.");
                        } else {
                            System.out.println("Barang dengan ID " + idBarangTambah + " tidak ditemukan.");
                        }
                        break;
                    case 2:
                        System.out.print("Masukkan ID barang yang akan dihapus dari keranjang: ");
                        String idBarangHapusKeranjang = scanner.next();
                        Barang barangHapusKeranjang = akun.getBasket().hapusBarang(idBarangHapusKeranjang);
                        if (barangHapusKeranjang != null) {
                            System.out.println("Barang berhasil dihapus dari keranjang: " + barangHapusKeranjang);
                        } else {
                            System.out.println("Barang dengan ID " + idBarangHapusKeranjang + " tidak ditemukan dalam keranjang.");
                        }
                        break;
                    case 3:
                        System.out.print("Masukkan ID barang yang akan diubah jumlahnya dalam keranjang: ");
                        String idBarangEdit = scanner.next();
                        Barang barangEdit = akun.getBasket().cariBarangById(idBarangEdit);
                        if (barangEdit != null) {
                            System.out.print("Masukkan jumlah barang baru: ");
                            int stokBarangEdit = scanner.nextInt();
                            barangEdit.setStok(stokBarangEdit);
                            System.out.println("Jumlah barang dalam keranjang berhasil diubah: " + barangEdit);
                        } else {
                            System.out.println("Barang dengan ID " + idBarangEdit + " tidak ditemukan dalam keranjang.");
                        }
                        break;
                    case 0:
                        return; // Keluar dari metode jika pilihan adalah 0
                    default:
                        System.out.println("Pilihan tidak valid. Silakan coba lagi.");
                        break;
                }
            }
        } catch (InputMismatchException e) {
            System.out.println("Input tidak valid. Silakan coba lagi.");
            scanner.nextLine(); // Consume the invalid input
        }
    }
       @Override
        public void masukkanKeranjang() {
        // Add the provided code here
        if (listBarang == null) {
            System.out.println("Error: listBarang is null");
            return;
        }

        if (akun == null) {
            System.out.println("Error: akun is null");
            return;
        }

        

        System.out.print("Masukkan ID barang yang akan dibeli: ");
        String idBarangBeli = scanner.next();
        Barang barangBeli = listBarang.cariBarangById(idBarangBeli);

        if (barangBeli != null) {
            ListBarang basket = akun.getBasket();
            if (basket != null) {
                basket.tambahBarang(barangBeli);
                System.out.println("Barang berhasil ditambahkan ke keranjang.");
            } else {
                System.out.println("Error: Basket is null");
            }
        } else {
            System.out.println("Barang dengan ID " + idBarangBeli + " tidak ditemukan.");
        }
    }


    @Override
    public void lihatListBarang() {
        // Customer can view the list of items
        System.out.println("\nList Barang:");
        listBarang.tampilanTabel();
    }

        private double calculateTotal() {
            double total = 0;
            for (Barang barang : akun.getBasket().getBarang()) {
                total += barang.getHarga() * barang.getStok();
            }
            return total;
        }

        @Override
        public void checkout() {
        try {
            while (true) {
                System.out.println("\nKeranjang Belanja:");
                listBarang.tampilanTabel();

                System.out.println("\nMenu Checkout:");
                System.out.println("1. Proses Checkout");
                System.out.println("2. Batalkan Checkout");
                System.out.print("Pilih opsi: ");
                int pilihan = scanner.nextInt();
                switch (pilihan) {
                    case 1:
                        double total = calculateTotal();
                        System.out.println("Total Belanja: Rp " + total);

                        // Proceed to payment method selection
                        pilihMetodePembayaran();

                        // Create a new Transaksi object
                        Transaksi transaksi = new Transaksi(akun);
                        transaksi.setBarang(akun.getBasket().getBarang());

                        // Create a new Invoice object
                        Invoice invoice = new Invoice(transaksi, akun.getPembayaran());

                        // Print the invoice
                        invoice.cetakInvoice();

                        // Clear the basket after successful checkout
                        akun.getBasket().clear();

                        System.out.println("Checkout berhasil!");
                        return; // Keluar dari metode jika pilihan adalah 1
                    case 2:
                        akun.getBasket().clear();
                        System.out.println("Checkout dibatalkan. Keranjang belanja dikosongkan.");
                        return; // Keluar dari metode jika pilihan adalah 2
                    default:
                        System.out.println("Pilihan tidak valid. Silakan coba lagi.");
                        break;
                }
            }
        } catch (InputMismatchException e) {
            System.out.println("Input tidak valid. Silakan coba lagi.");
            scanner.nextLine(); // Consume the invalid input
        }
    }


        @Override
        public void pilihMetodePembayaran() {
            try {
                System.out.println("\nMetode Pembayaran:");
                System.out.println("1. QRIS");
                System.out.println("2. Transfer Bank");
                System.out.println("3. COD (Cash on Delivery)");
                System.out.print("Pilih metode pembayaran (1-3): ");
                int metodePembayaran = scanner.nextInt();

                // Consume the newline character
                scanner.nextLine();

                switch (metodePembayaran) {
                    case 1:
                        akun.setPembayaran(new QRIS(generateRandomId()));
                        System.out.println("Metode pembayaran berhasil dipilih: QRIS");
                        break;
                    case 2:
                        akun.setPembayaran(new Bank(generateRandomId()));
                        System.out.println("Metode pembayaran berhasil dipilih: Transfer Bank");
                        break;
                    case 3:
                        akun.setPembayaran(new COD(generateRandomId()));
                        System.out.println("Metode pembayaran berhasil dipilih: COD (Cash on Delivery)");
                        break;
                    default:
                        System.out.println("Metode pembayaran tidak valid. Silakan coba lagi.");
                        break;
                }
            } catch (NoSuchElementException e) {
                System.out.println("Input tidak valid. Silakan coba lagi.");
                scanner.nextLine(); // Consume the invalid input
            }
        }

        public void tampilkanKeranjang() {
            System.out.println("\nKeranjang Belanja:");
            akun.getBasket().keranjangBelanja();
        }
        
    private String generateRandomId() {
        return String.valueOf((int) (Math.random() * 1000000));
    }
}
