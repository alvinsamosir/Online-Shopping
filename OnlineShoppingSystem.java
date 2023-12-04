import java.util.Scanner;

/**
 * Kelas utama untuk sistem belanja online. Program ini memungkinkan pengguna
 * untuk login sebagai admin atau pelanggan, melakukan berbagai tindakan tergantung
 * pada peran yang dimiliki, dan mengaksses fitur-fitur seperti kelola barang,
 * memasukkan barang dalam keranjang, melihat list barang, kelola barang dalam keranjang, dan proses checkout.
 * 
 * @author: Qandila Ahmara, Meutia Aini, dan Muhammad Alvin
 * 
 */

public class OnlineShoppingSystem {
    private static Akun akun;
    private static Driver driverAkun;
    private static ListBarang listBarang = new ListBarang(); // Initialize listBarang
    private static Scanner scanner = new Scanner(System.in); // Create Scanner object

    public static void main(String[] args) {
        boolean running = true;

        while (running) {
            System.out.println("\nMenu:");
            System.out.println("1. Login as Admin");
            System.out.println("2. Login as Customer");
            System.out.println("3. Exit");

            System.out.print("Masukkan pilihan: ");
            int choice = scanner.nextInt();

            switch (choice) {
                case 1:
                    loginAsAdmin();
                    break;
                case 2:
                    loginAsCustomer();
                    break;
                case 3:
                    running = false;
                    break;
                default:
                    System.out.println("Pilihan tidak valid. Silakan coba lagi.");
                    break;
            }
        }

        System.out.println("Terima kasih! Program selesai.");
        scanner.close(); // Close the Scanner when the program is finished
    }
        
    private static void loginAsAdmin() {
        System.out.print("Masukkan ID Admin: "); // ID Admin : 000
        String id = scanner.next();
        System.out.print("Masukkan Password Admin: "); // Password Admin : Admin
        String password = scanner.next();
    
        // Verifikasi ID dan password Admin
        if (id.equals("123") && password.equals("Admin")) {
            System.out.println("Login berhasil!");
            akun = new Admin(id, "Admin");
            driverAkun = new AdminDriver((Admin) akun, listBarang);
    
            // Masuk ke menu Admin
            adminMenu();
        } else {
            System.out.println("ID atau Password salah, silahkan coba lagi!");
        }
    }
    
    private static void loginAsCustomer() {
        System.out.print("Masukkan ID Customer: "); // ID Customer : 001
        String id = scanner.next();
        System.out.print("Masukkan Password Customer: "); //Password Customer : Customer
        String password = scanner.next();
    
        // Verifikasi ID dan password Customer
        if (id.equals("001") && password.equals("Customer")) {
            System.out.println("Login berhasil!");
            akun = new Customer(id, "Customer");
            driverAkun = new CustomerDriver((Customer) akun, listBarang, scanner);
    
            // Masuk ke menu Customer
            userMenu();
        } else {
            System.out.println("ID atau Password salah, silahkan coba lagi!");
        }
    }
    
    
    private static void userMenu() {
        boolean userMenuRunning = true;
        while (userMenuRunning) {
            System.out.println("\nUser Menu:");
            System.out.println("1. Masukkan Barang Dalam Keranjang");
            System.out.println("2. Lihat List Barang");
            System.out.println("3. Kelola Barang pada Keranjang");
            System.out.println("4. Checkout");
            System.out.println("0. Logout");

            System.out.print("Masukkan pilihan: ");
            int userChoice = scanner.nextInt();

            switch (userChoice) {
                case 1:
                    driverAkun.masukkanKeranjang();
                    break;
                case 2:
                    driverAkun.lihatListBarang();
                    break;
                case 3:
                    driverAkun.kelolaBarang(scanner);
                    break;
                case 4:
                    driverAkun.checkout();
                    break;
                case 0:
                    userMenuRunning = false;
                    akun = null;
                    driverAkun = null;
                    break;
                default:
                    System.out.println("Pilihan tidak valid. Silakan coba lagi.");
                    break;
            }
        }
    }

    private static void adminMenu() {
        boolean adminMenuRunning = true;
        while (adminMenuRunning) {
            System.out.println("\nAdmin Menu:");
            System.out.println("1. Kelola Barang");
            System.out.println("2. Logout");

            System.out.print("Masukkan pilihan: ");
            int adminChoice = scanner.nextInt();

            switch (adminChoice) {
                case 1:
                    driverAkun.kelolaBarang(scanner);
                    break;
                case 2:
                    adminMenuRunning = false;
                    akun = null;
                    driverAkun = null;
                    break;
                default:
                    System.out.println("Pilihan tidak valid. Silakan coba lagi.");
                    break;
            }
        }
    }
}
