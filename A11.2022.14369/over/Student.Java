package over;

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
    }

}