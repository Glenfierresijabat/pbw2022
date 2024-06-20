/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package tugaspbo;

/**
 *
 * @author LENOVO
 */
import java.sql.*;

import java.sql.*;
import java.util.Scanner;

public class Tugaspbo{
    static final String JDBC_DRIVER = "com.mysql.cj.jdbc.Driver";
    static final String DB_URL = "jdbc:mysql://127.0.0.1/penjualan";
    static final String USER = "root";
    static final String PASS = "";
    
    static Connection conn;
    static Statement stmt;
    static ResultSet rs;

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        while (true) {
            System.out.println("Menu:");
            System.out.println("1. Input Data");
            System.out.println("2. Edit Data");
            System.out.println("3. Delete Data");
            System.out.println("4. Show Data");
            System.out.println("5. Exit");
            System.out.print("Pilih menu: ");
            int menu = scanner.nextInt();
            scanner.nextLine();  

            switch (menu) {
                case 1:
                    inputData(scanner);
                    break;
                case 2:
                    editData(scanner);
                    break;
                case 3:
                    deleteData(scanner);
                    break;
                case 4:
                    showData();
                    break;
                case 5:
                    System.out.println("Terima kasih telah menggunakan program ini.");
                    scanner.close();
                    System.exit(0);
                    break;
                default:
                    System.out.println("Menu tidak valid. Silakan pilih lagi.");
            }
        }
    }

    public static void inputData(Scanner scanner) {
        System.out.print("Masukkan kode barang: ");
        String kode_brg = scanner.nextLine();
        System.out.print("Masukkan nama barang: ");
        String nama_brg = scanner.nextLine();
        System.out.print("Masukkan satuan: ");
        String satuan = scanner.nextLine();
        System.out.print("Masukkan stok: ");
        int stok = scanner.nextInt();
        System.out.print("Masukkan stok minimal: ");
        int stok_min = scanner.nextInt();
        scanner.nextLine(); 

        try {
            Class.forName(JDBC_DRIVER);
            conn = DriverManager.getConnection(DB_URL, USER, PASS);
            String sql = "INSERT INTO barang (kd_brg, nm_brg, satuan, stok_brg, stok_min) VALUES (?, ?, ?, ?, ?)";
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setString(1, kode_brg);
            ps.setString(2, nama_brg);
            ps.setString(3, satuan);
            ps.setInt(4, stok);
            ps.setInt(5, stok_min);
            ps.executeUpdate();
            System.out.println("Data berhasil ditambahkan.");
            ps.close();
            conn.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static void editData(Scanner scanner) {
        System.out.print("Masukkan kode barang yang akan diubah: ");
        String kode_brg = scanner.nextLine();

        System.out.print("Masukkan nama barang baru: ");
        String nama_brg = scanner.nextLine();
        System.out.print("Masukkan satuan baru: ");
        String satuan = scanner.nextLine();
        System.out.print("Masukkan stok baru: ");
        int stok = scanner.nextInt();
        System.out.print("Masukkan stok minimal baru: ");
        int stok_min = scanner.nextInt();
        scanner.nextLine(); 

        try {
            Class.forName(JDBC_DRIVER);
            conn = DriverManager.getConnection(DB_URL, USER, PASS);
            String sql = "UPDATE barang SET nm_brg = ?, satuan = ?, stok_brg = ?, stok_min = ? WHERE kd_brg = ?";
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setString(1, nama_brg);
            ps.setString(2, satuan);
            ps.setInt(3, stok);
            ps.setInt(4, stok_min);
            ps.setString(5, kode_brg);
            ps.executeUpdate();
            System.out.println("Data berhasil diubah.");
            ps.close();
            conn.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static void deleteData(Scanner scanner) {
        System.out.print("Masukkan kode barang yang akan dihapus: ");
        String kode_brg = scanner.nextLine();

        try {
            Class.forName(JDBC_DRIVER);
            conn = DriverManager.getConnection(DB_URL, USER, PASS);
            String sql = "DELETE FROM barang WHERE kd_brg = ?";
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setString(1, kode_brg);
            ps.executeUpdate();
            System.out.println("Data berhasil dihapus.");
            ps.close();
            conn.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static void showData() {
        try {
            Class.forName(JDBC_DRIVER);
            conn = DriverManager.getConnection(DB_URL, USER, PASS);
            stmt = conn.createStatement();
            rs = stmt.executeQuery("SELECT * FROM barang");
            int i = 1;
            while (rs.next()) {
                System.out.println("Data ke-" + i);
                System.out.println("Kode Barang: " + rs.getString("kd_brg"));
                System.out.println("Nama Barang: " + rs.getString("nm_brg"));
                System.out.println("Satuan: " + rs.getString("satuan"));
                System.out.println("Stok: " + rs.getInt("stok_brg"));
                System.out.println("Stok minimal: " + rs.getInt("stok_min"));
                System.out.println();
                i++;
            }
            rs.close();
            stmt.close();
            conn.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
