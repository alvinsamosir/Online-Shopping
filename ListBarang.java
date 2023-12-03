import java.util.ArrayList;
import java.util.List;


//Kelas untuk mengelola daftar barang dan fungsionalitas keranjang belanja.
class ListBarang {
    private List<Barang> listBarang;
    private List<Barang> listBarangKeranjang;

   public ListBarang() {
        this.listBarang = new ArrayList<>();
        tambahBarang(new Barang("001", "Fan Mini", 55000, 5));
        tambahBarang(new Barang("002", "Botol Minujm", 17000, 5));
        tambahBarang(new Barang("003", "Jam Tangan", 76000, 3));
        tambahBarang(new Barang("004", "NoteBook", 560000, 10));
        tambahBarang(new Barang("005", "Gantungan Kunci", 26000,4));
    }

    public void tambahBarang(Barang barang) {
        listBarang.add(barang);
    }

     public void tampilanTabel() {
        System.out.printf("+--------+----------------------+-------------+--------+%n");
        System.out.printf("| ID     | Nama Barang          | Harga       | stok   |%n");
        System.out.printf("+--------+----------------------+-------------+--------+%n");

        for (Barang barang : listBarang) {
            System.out.printf("| %-6s | %-20s | %-11.0f | %-6d |%n",
                    barang.getKodeBarang(), barang.getNamaBarang(), barang.getHarga(), barang.getStok());
        }

        System.out.println("+--------+----------------------+-------------+--------+");
    }
    
    public List<Barang> getBarang() {
        return listBarang;
    }

    //menghapus barang dari daftar berdasarkan ID-nya.
    public Barang hapusBarang(String id) {
        for (Barang barang : listBarang) {
            if (barang.getKodeBarang().equals(id)) {
                listBarang.remove(barang);
                return barang;
            }
        }
        return null;
    }

    //menghapus barang dari keranjang belanja berdasarkan ID-nya.
    public Barang hapusBarangKeranjang(String id) {
        for (Barang barang : listBarangKeranjang) {
            if (barang.getKodeBarang().equals(id)) {
                listBarangKeranjang.remove(barang);
                return barang;
            }
        }
        return null;
    }

    public Barang cariBarangById(String id) {
        for (Barang barang : listBarang) {
            if (barang.getKodeBarang().equals(id)) {
                return barang;
            }
        }
        return null;
    }

    public void checkout() {
        // Implementation for checkout logic
    }
    public void clear() {
        listBarang.clear();
    }

    public void keranjangBelanja() {
    }

}
