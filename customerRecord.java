import java.util.Scanner;


public class customerRecord{

    private String fName, lName, email, pNum, address, id;
    private int age;
    private Scanner scanner = new Scanner(System.in);  

    public customerRecord(String empty){
        this.id = empty;
    }

    public customerRecord(String fName, String lName, String email, String phone, String address, int age, String id)
    {
        this.fName = fName;
        this.lName = lName;
        this.email = email;
        this.pNum = phone;
        this.address = address;
        this.age = age;
        this.id = id;
    }
    public String getfName() {
        return this.fName;
    }
    public String getlName() {
        return this.lName;
    }
    public String getEmail() {
        return this.email;
    }
    public String getPhone() {
        return this.pNum;
    }
    public String getAddress() {
        return this.address;
    }
    public int getAge() {
        return this.age;
    }
    public String getID() {
        return this.id;
    }

}
