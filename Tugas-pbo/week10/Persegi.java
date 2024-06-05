package week10;

public class Persegi extends BangunDatar {
    private int sisi;

    public Persegi(int sisi) {
        this.sisi = sisi;
    }

    //overriding
    public double luas() {
        return sisi * sisi;
    }

    //overriding
    public double keliling() {
        return 4 * sisi;
    }

    public int getSisi() {
        return sisi;
    }

    public void setSisi(int sisi) {
        this.sisi = sisi;
    }
}
