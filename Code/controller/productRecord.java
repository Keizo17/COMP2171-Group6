package logic
import java.util.Scanner;


public class productRecord{

    private Scanner scanner = new Scanner(System.in);
    private String pName;
    private int sCode;



    public productRecord(String empty){
        this.code=empty;
    }

    public productRecord(String pName, int sCode){
        this.pName=pName;
        this.sCode=sCode;
        this.code=code;
    }

    public String getpName(){
        return this.pName;
    }

    public int getsCode(){
        return this.sCode;
    }

    public String getCode(){
        return this.code;
    }
}
