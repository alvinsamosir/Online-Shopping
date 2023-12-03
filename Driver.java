import java.util.Scanner;

/**
 * Kelas abstract Driver adalah kelas dasar untuk pengendara yang berinteraksi
 * dengan sistem. Kelas ini menyediakan metode abstract yang harus diimplementasi
 * oleh kelas turunannya untuk mendefinisikan perilaku khusus.
 * 
 */

 abstract class Driver {
    protected Akun akun;
    protected ListBarang listBarang;

    public Driver(Akun akun, ListBarang listBarang) {
        this.akun = akun;
        this.listBarang = listBarang;
    }

    public abstract void login();

    public abstract void kelolaBarang(Scanner scanner);

    public abstract void masukkanKeranjang();

    public abstract void lihatListBarang();

    public abstract void checkout();

    public abstract void pilihMetodePembayaran();
}
