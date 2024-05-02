package ponsi;
import java.util.Scanner;

public class InheritMain {
    public static void main(String[] args) {
        Student mahasiswa = new Student();
        
        // Menggunakan Scanner untuk mengambil input pengguna
        Scanner scanner = new Scanner(System.in);
        System.out.println("Masukkan nama: ");
        mahasiswa.name = scanner.nextLine();
        System.out.println("Masukkan alamat: ");
        mahasiswa.address = scanner.nextLine();
        System.out.println("Masukkan NIM: ");
        mahasiswa.nim = scanner.nextLine();
        System.out.println("Masukkan hobi: ");
        mahasiswa.setHobby(scanner.nextLine()); 
        System.out.println("Masukkan biaya SPP: ");
        double spp = scanner.nextDouble();
        System.out.println("Masukkan biaya SKS: ");
        double sks = scanner.nextDouble();
        System.out.println("Masukkan biaya Modul: ");
        double modul = scanner.nextDouble();
        scanner.close(); // Jangan lupa menutup Scanner setelah selesai digunakan
        
        // Memanggil metode identity() dari objek mahasiswa untuk mencetak informasi
        mahasiswa.identity();
        mahasiswa.displayHobby();
        mahasiswa.hitungPembayaran(spp, sks, modul);
        
    }
}
