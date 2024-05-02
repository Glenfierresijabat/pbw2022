package ponsi;

// inherit dari Person
public class Student extends Person{ 
    String nim;
    
// method baru di subclass
    public String getNim() {
        return nim;
    }    

    public void identity()
    {
        System.out.println("NIM: "+ getNim());
        super.identity();
    }
    
    public void hitungPembayaran(double spp, double sks, double modul) {
        double total = spp + sks + modul;
        System.out.println("Total pembayaran: " + total);
    }

}