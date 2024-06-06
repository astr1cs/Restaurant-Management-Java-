package Classes;
import Interface.*;
import java.lang.*;
import java.io.*;
import java.util.Scanner;

public class users {
    user []userList = new user[100];

    static int userCount = 0;

    public users(){
        try{
            File file = new File("Files/userrList.txt");
            Scanner sc = new Scanner(file);
            while(sc.hasNext()){
                String line1 = sc.nextLine();
                String line2 = sc.nextLine();
                String line3 = sc.nextLine();
                String line4 = sc.nextLine();
                String line5 = sc.nextLine();
                String line6 = sc.nextLine();


                String name = line1.substring(6);
                String password = line2.substring(10);
                String gender = line3.substring(8);
                String dob = line4.substring(15);
                String address = line5.substring(9);


                System.out.println(name);
                System.out.println(password);
                System.out.println(gender);
                System.out.println(dob);
                System.out.println(address);


                userList[userCount] = new user(name,password,gender,dob,address);
                userCount++;
                System.out.println(userCount+" User Count-------------------");


            }
            sc.close();
        }
        catch(Exception ex){

            System.out.println("File Problem here not found.");
            return;
        }
    }
    public void addUser(user u){
        userList[userCount]=u;
        userCount++;
        //also adding them in file
        String userDetails="Name: "+ u.getName() + "\n";
        userDetails+="Password: "+ u.getPassword() + "\n";
        userDetails+="Gender: "+ u.getGender() + "\n";
        userDetails+="Date of birth: "+ u.getDOB() + "\n";
        userDetails+="Address: "+u.getAddress() + "\n" + "\n";

        try{
            FileWriter fw = new FileWriter("Files/userrList.txt",true);
            fw.write(userDetails);
            fw.close();
        }catch(Exception ex){
            System.out.println(ex);
        }
    }
    public user checkCredentials(int index, String pass){
        if((userList[index].getPassword().equals(pass))){
            return userList[index];
        }else{return null;}
    }
    //For users
    public int userExists(String name){
        int index = -1;
        for(int i=0;i<userCount;i++){
            if(userList[i] != null &&  userList[i].getName().equals(name)){
                index = i;
                break;
            }
        }
        return index;
    }
   //for user


    ////user Check creds

///

    public user getUser(int index){
        return userList[index];
    }

    public void updateUser(user oldUser, user updatedUser){

        String oldUserDetails="Name: "+ oldUser.getName() + "\n";
        oldUserDetails+="Password: "+ oldUser.getPassword() + "\n";
        oldUserDetails+="Gender: "+ oldUser.getGender() + "\n";
        oldUserDetails+="Date of birth: "+ oldUser.getDOB() + "\n";
        oldUserDetails+="Address: "+oldUser.getAddress() + "\n";


        //deleting from file
        String updatedDetails="Name: "+ updatedUser.getName() + "\n";
        updatedDetails+="Password: "+ updatedUser.getPassword() + "\n";
        updatedDetails+="Gender: "+ updatedUser.getGender() + "\n";
        updatedDetails+="Date of birth: "+ updatedUser.getDOB() + "\n";
        updatedDetails+="Address: "+updatedUser.getAddress() + "\n";


        try{
            String filepath = "Files/userrList.txt";
            File originalFile = new File(filepath);

            String newDetails = "";
            Scanner sc = new Scanner(originalFile);
            while(sc.hasNext()){
                String readUser = sc.nextLine() + "\n";
                readUser += sc.nextLine() + "\n";
                readUser += sc.nextLine() + "\n";
                readUser += sc.nextLine() + "\n";
                readUser += sc.nextLine() +"\n";
                readUser += sc.nextLine();


                System.out.println(readUser);
                System.out.println(oldUserDetails);

                if(readUser.equals(oldUserDetails)){
                    System.out.println("Updated");
                    newDetails += updatedDetails + "\n";
                }else{
                    System.out.println("Writing");
                    newDetails += readUser + "\n";
                }
            } sc.close();
            FileWriter fw = new FileWriter(filepath);
            fw.write(newDetails);
            fw.close();
        }catch(Exception ex){
            System.out.println(ex);
        }
    }

    public void deleteUser(user u){
        int index = userExists(u.getName());
        for(int i=index;i<userCount-1;i++){
            userList[i]=userList[i+1];
        }
        --userCount;
        userList[userCount]=null;

        //deleting from file
        String userDetails="Name: "+ u.getName() + "\n";
        userDetails+="Password: "+ u.getPassword() + "\n";
        userDetails+="Gender: "+ u.getGender() + "\n";
        userDetails+="Date of birth: "+ u.getDOB() + "\n";
        userDetails+="Address: "+u.getAddress() + "\n";


        try{
            String filepath = "Files/userrList.txt";
            File originalFile = new File(filepath);

            String newDetails = "";
            Scanner sc = new Scanner(originalFile);
            while(sc.hasNext()){
                String readUser = sc.nextLine() + "\n";
                readUser += sc.nextLine() + "\n";
                readUser += sc.nextLine() + "\n";
                readUser += sc.nextLine() + "\n";
                readUser += sc.nextLine() +"\n";
                readUser += sc.nextLine();


                System.out.println(readUser);
                System.out.println(userDetails);

                if(readUser.equals(userDetails)){
                    System.out.println("Equal");
                    //newDetails += updatedDetails + "\n";
                    continue;
                }
                System.out.println("Writing");
                newDetails += readUser + "\n";
            } sc.close();
            FileWriter fw = new FileWriter(filepath);
            fw.write(newDetails);
            fw.close();
        }catch(Exception ex){
            System.out.println(ex);
        }
    }
}