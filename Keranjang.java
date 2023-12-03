import java.util.ArrayList;
import java.util.List;

/**
 * Kelas keranjang merepresentasikan keranjang belanja yan berisi daftar barang.
*/
class Keranjang {
    private List<Barang> barang;

    public Keranjang() {
        this.barang = new ArrayList<>();
    }

    /**
     * Method untuk menambahkan barang ke dalam keranjang.
     * 
     * @param barang
     */
    public void tambahBarang(Barang barang) {
        this.barang.add(barang);
    }

    public List<Barang> getBarang() {
        return barang;
    }
}