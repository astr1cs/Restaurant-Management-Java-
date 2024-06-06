package Classes;

import java.lang.*;
public class user{
    private String name;
    private String password;
    private String gender;
    private String dob;
    private String address;


    public user(String name, String password, String gender,String dob,String address){
        this.name = name;
        this.password = password;
        this.gender = gender;
        this.dob = dob;
        this.address = address;

    }

    public void setName(String name){
        this.name = name;
    }


    public void setPassword(String password){
        this.password = password;
    }
    public void setGender(String gender){
        this.gender = gender;
    }
    public void setDOB(String dob){
        this.dob = dob;
    }
    public void setAddress(String address){
        this.address = address;
    }




    public String getName(){
        return name;
    }
    public String getPassword(){
        return password;
    }
    public String getGender(){
        return gender;
    }
    public String getDOB(){
        return dob;
    }
    public String getAddress(){
        return address;
    }

}