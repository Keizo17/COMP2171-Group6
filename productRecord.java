package logic
import java.util.Scanner;


public class productRecord{

    //private Scanner scanner = new Scanner(System.in);
    private String pName, pNote;
    private int pID, pStock;



    //public productRecord(String empty){
    //    this.operation1= empty;
    //}

    /*public productRecord(String pName, int pID, double pPrice, int pStock, String pNote){
        this.pName=pName;
        this.pID=pID;
        this.pPrice=pPrice;
        this.pStock = pStock;
        this.pNote = pNote;
    */}

    public String getProdName(){
        return this.pName;
    }

    public int getProdID(){
        return this.pID;
    }

    public String getProdNote(ProductDescription pd){
        return this.pNote;
    }

    public int getProdStock(ProductDescription pd){
        return this.pStock;
    }

    public int getProdStock(ProductDescription pd){
        return this.pPrice;
    }


    public void setPDName(String newpName){
        this.pName = newpName;
    }

    public void setPDPrice(int newpPrice){
        this.pPrice = newpPrice;
    }
}
