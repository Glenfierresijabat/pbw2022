package superr;

class InheritMain {
public static void main(String[] args){
    Student mahasiswa = new Student();

    //pemanggilan method dari superclass
    //no1-mahasiswa.identity();

    //pemanggilan method dari subclass
    mahasiswa.nim = "A11.2000.00001";
    mahasiswa.identity();
    }
}