import java.util.ArrayList;
// import java.util.Date;
// import java.util.Map;
import java.util.List;
import java.util.Map;

class Transaksi {
    private Akun akun;
    private List<Barang> barang;
    private Map<Barang, Integer> barangDalamTransaksi;

    public Transaksi(Akun akun) {
        this.akun = akun;
        this.barang = new ArrayList<>();
        // this.barangDalamTransaksi = barangDalamTransaksi;

    }

    public Map<Barang, Integer> getDaftarBarang() {
        return barangDalamTransaksi;
    }

    public double hitungTotal() {
        double total = 0.0;
        for (Map.Entry<Barang, Integer> entry : barangDalamTransaksi.entrySet()) {
            Barang barang = entry.getKey();
            int jumlah = entry.getValue();
            total += barang.getHarga() * jumlah;
        }
        return total;
    }

    public void setBarang(List<Barang> barang) {
        this.barang = barang;
    }

    public List<Barang> getBarang() {
        return barang;
    }

    @Override
    public String toString() {
        return "Transaksi{" + "akun=" + akun.getId() + ", barang=" + barang + '}';
    }
}