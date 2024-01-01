package Classes;
import java.lang.*;

public  class admin{
    String aname;
    String apassword;
    String agender;
    String adob;
    String aaddress;

    public admin(String aname, String apassword, String agender,String adob,String aaddress){
        this.aname = aname;
        this.apassword = apassword;
        this.agender = agender;
        this.adob = adob;
        this.aaddress = aaddress;
    }

    public void setNAme(String aname){
        this.aname = aname;
    }
    public void setAPassword(String apassword){
        this.apassword = apassword;
    }
    public void setAGender(String agender){
        this.agender = agender;
    }
    public void setADOB(String adob){
        this.adob = adob;
    }
    public void setAAddress(String aaddress){
        this.aaddress = aaddress;
    }

    public String getAName(){
        return aname;
    }
    public String getAPassword(){
        return apassword;
    }
    public String getAGender(){
        return agender;
    }
    public String getADOB(){
        return adob;
    }
    public String getAAddress(){
        return aaddress;
    }
}