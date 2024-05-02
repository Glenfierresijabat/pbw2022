package superr;

// inherit dari Person
public class Student extends Person{ 
    String nim;
    
// method baru di subclass
    public String getNim() {
        return nim;
    }    

   
    public void identity()
    {
        super.identity();
        System.out.println("NIM: "+ getNim());
    }

}