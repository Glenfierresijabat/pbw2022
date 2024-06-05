package week10;

import java.util.Scanner;

public class mainClass {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        //lingkaran

        System.out.print("Masukkan jari-jari lingkaran: ");
        int radius = scanner.nextInt();
        Lingkaran lingkaran = new Lingkaran(radius);
        System.out.println("Luas lingkaran: " + lingkaran.luas());
        System.out.println("Keliling lingkaran: " + lingkaran.keliling());
        
        //persegi

        System.out.print("Masukkan sisi persegi: ");
        int sisi = scanner.nextInt();
        Persegi persegi = new Persegi(sisi);
        System.out.println("Luas persegi: " + persegi.luas());
        System.out.println("Keliling persegi: " + persegi.keliling());

        //segitiga

        System.out.print("Masukkan alas segitiga: ");
        int alas = scanner.nextInt();
        System.out.print("Masukkan tinggi segitiga: ");
        int tinggi = scanner.nextInt();
        Segitiga segitiga = new Segitiga(alas, tinggi);
        System.out.println("Luas segitiga: " + segitiga.luas());
        System.out.println("Keliling segitiga: " + segitiga.keliling());

    }
}

