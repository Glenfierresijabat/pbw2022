package ponsi;

class Person {
   // atribut dan method super class
    protected String name; 
    protected String address;
    protected String hobby;
    
    public void identity() 
    {
        System.out.println("Nama: "+name);
        System.out.println("Alamat: "+address);
    }

        // metode untuk menampilkan hobi
        public void displayHobby() {
            System.out.println("Hobi: " + hobby);
        }
    
        // getter dan setter untuk hobby
        public String getHobby() {
            return hobby;
        }
    
        public void setHobby(String hobby) {
            this.hobby = hobby;
        }
}
