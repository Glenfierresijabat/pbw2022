package Inheritance;

class InheritMain {
public static void main(String[] args){
    Student mahasiswa = new Student();

    //pemanggilan method dari superclass
    mahasiswa.identity();

    //pemanggilan method dari subclass
    String nim = mahasiswa.getNim();
    System.out.println(nim);
    }
}