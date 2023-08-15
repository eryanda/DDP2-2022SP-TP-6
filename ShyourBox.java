import java.util.ArrayList;
import java.util.Scanner;

import customer.Customer;
import customer.GoldCustomer;
import order.Order;
import order.OrderItem;
import product.Product;
import product.natural.Fruit;
import product.natural.Veggie;
import product.processed.Diary;

/**
 * Aplikasi ShyourBox, sebuah program sederhana untuk manajemen belanja dan riwayat pembelian.
 */
public class ShyourBox {
    public ArrayList<Product> products = new ArrayList<Product>();
    public ArrayList<Customer> customers = new ArrayList<Customer>();
    public Customer loginCustomer;


    public static void main(String[] args) {
        ShyourBox app = new ShyourBox();
        System.out.println("Welcome to ShyourBox! Yuk beli jangan shy shy!");

        app.initProducts();
        app.initCustomers();

        Scanner scanner = new Scanner(System.in);
        int choice;
        do {
            System.out.println("Menu" +
                    "\n1. Login" +
                    "\n0. Keluar");
            System.out.print("Pilih menu: ");
            choice = scanner.nextInt();
            switch (choice){
                case 1:
                    System.out.println("Masukkan nama pengguna:");
                    String user = scanner.next();
                    //TODO: implement Login
                    app.loginCustomer = app.searchCustomer(user);
                    if (app.loginCustomer != null) {
                        app.customerMenu();
                    } else {
                        System.out.println("Customer tidak ditemukan");
                    }
                    break;
                case 0:
                    System.out.println("Sampai Jumpa!");
                    break;
                default:
                    System.out.println("Pilihan menu tidak valid.");
                    break;
            }

        } while (choice != 0);
        scanner.close();
    }

    /**
     * Menampilkan menu dan melakukan tindakan terkait dengan pelanggan yang telah masuk.
     */
    public void customerMenu(){
        Scanner scanner = new Scanner(System.in);
        PrintGenericList<OrderItem> printOrderItems = new PrintGenericList<>(); // Untuk mencetak order items
        int choice;
        do {
            System.out.println("--------------Customer "+this.loginCustomer.getName()+ " Menu------------------" +
                    "\n1. Lihat Keranjang" +
                    "\n2. Tambah Produk ke Keranjang" +
                    "\n3. Checkout Keranjang" +
                    "\n4. Riwayat Pemebelian" +
                    "\n0. Logout");
            System.out.print("Pilih menu: ");
            choice = scanner.nextInt();
            switch(choice){
                case 1:
                // Implementasi untuk lihat keranjang menggunakan PrintGenericList
                if (loginCustomer.getCart().getOrderList().isEmpty()){
                    System.out.println("Keranjang anda kosong");
                }
                else{
                    System.out.println("Isi Keranjang:");
                    printOrderItems.printToConsole(loginCustomer.getCart().getOrderList());
                }
                break;
                case 2:
                    //TODO : Implement add to cart
                    System.out.println("List Produk Pada ShyourBox");
                    for (Product product : products) {
                        System.out.println("- " + product.getName() + " memiliki stok " + product.getStock());
                    }
                    System.out.print("Nama produk yang ingin dibeli: ");
                    String productName = scanner.next();
                    System.out.print("Masukan jumlah produk yang ingin dibeli: ");
                    int quantity = scanner.nextInt();
                    

                    Product selectedProduct = searchProduct(productName);
                    if (selectedProduct != null) {
                        loginCustomer.addToCard(selectedProduct, quantity);
                    } else {
                        System.out.println("Produk tidak ditemukan.");
                    }
                    break;
                case 3:
                    // TODO: Implement Checkout
                    this.loginCustomer.checkout();
                    break;
                case 4:
                    // Implementasi untuk riwayat pembelian menggunakan PrintGenericList
                    if (loginCustomer.getOrderHistory().isEmpty()) {
                    System.out.println("Belum ada riwayat pembelian.");
                } else {
                    System.out.println("Riwayat Pembelian:");
                    for (Order order : loginCustomer.getOrderHistory()) {
                        System.out.println("Tanggal Checkout: " + order.getOrderDate());
                        System.out.println("Total Harga: " + order.getTotalPrice());
                        System.out.println("Daftar Pembelian:");
                        PrintGenericList<OrderItem> print = new PrintGenericList<>();
                        print.printToConsole(order.getCart().getOrderList());
                        System.out.println();
                    }
                }
                    break;
                case 0:
                    System.err.println("Sampai Jumpa Kembali!");
                    break;
                default:
                    System.out.println("Pilihan menu tidak valid.");
                    break;
            }
        } while (choice !=0);
       
    }

    /**
     * Inisialisasi produk-produk awal dalam aplikasi ShyourBox.
     */
    public void initProducts(){
        this.products.add(new Veggie("Bayam",1000, 20, false));
        this.products.add(new Veggie("Jamur",1000, 15, true));
        this.products.add(new Veggie("Wortel",1000, 15, true));

        this.products.add(new Fruit("Jeruk",10000, 20, false));
        this.products.add(new Fruit("Apel",13000, 50, true));
        this.products.add(new Fruit("Semangka",9000, 23, false));
        
        this.products.add(new Diary("Keju", 30000, 20, "06 08 2023"));
        this.products.add(new Diary("Yogurt", 15000, 10, "06 08 2026"));
    }


    /**
     * Inisialisasi customer dalam aplikasi ShyourBox.
     */
    public void initCustomers(){
        this.customers.add(new Customer("Hana"));
        this.customers.add(new Customer("Sakura"));
        this.customers.add(new Customer("Jennifer"));
        this.customers.add(new GoldCustomer("Anyujin"));
        this.customers.add(new GoldCustomer("Chaewon"));
    }


    /**
     * Method untuk mencari produk berdasarkan nama.
     *
     * @param name Nama produk yang dicari.
     * @return Produk yang sesuai dengan nama atau null jika tidak ditemukan.
     */
    public Product searchProduct(String name) {
        for (Product product : products) {
            if (product.getName().equalsIgnoreCase(name)) {
                return product;
            }
        }
        System.out.println("Produk tidak ditemukan");
        return null;
    }
    

    /**
     * Method untuk mencari pelanggan berdasarkan nama.
     *
     * @param name Nama pelanggan yang dicari.
     * @return Pelanggan yang sesuai dengan nama atau null jika tidak ditemukan.
     */
    public Customer searchCustomer(String name) {
        // TODO: Implement this method.
        for (Customer customer : customers) {
            if(customer.getName().equalsIgnoreCase(name)){
                return customer;
            }
        }
        return null;
    }

}


