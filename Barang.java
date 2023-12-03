/**
 * Class yang merepresentasikan objek barang dalam sistem toko online.
 * Setiap barang memiliki kode unik, nama, harga, dan jumlah stok.
 * 
 */

 class Barang {
    private String kodeBarang;
    private String namaBarang;
    private double harga;
    private int stok;
    public static int getKodeBarang;

    public Barang(String kodeBarang, String namaBarang, double harga, int stok) {
        this.kodeBarang = kodeBarang;
        this.namaBarang = namaBarang;
        this.harga = harga;
        this.stok = stok;
    }

    public String getKodeBarang() {
        return kodeBarang;
    }

    public void setKodeBarang(String kodeBarang) {
        this.kodeBarang = kodeBarang;
    }

    public void setNamaBarang(String namaBarang) {
        this.namaBarang = namaBarang;
    }

    public String getNamaBarang() {
        return namaBarang;
    }

    public double getHarga() {
        return harga;
    }

    public void setHarga(double hargaBarangEdit) {
        this.harga = hargaBarangEdit;
    }

    public int getStok() {
        return stok;
    }

    public void setStok(int stok) {
        this.stok = stok;
    }

    @Override
    public String toString() {
        return "Barang{" +
                "id='" + kodeBarang+ '\'' +
                ", nama='" + namaBarang + '\'' +
                ", harga=" + harga +
                ", stok=" + stok+
                '}';
    }

    public Object getkodeBarang() {
        return null;
    }

}