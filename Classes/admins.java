package Classes;
import java.lang.*;
import java.io.*;
import java.util.Scanner;

public  class admins{
    admin[] adminList = new admin[100];
    static int adminCount = 0;

    public admins(){
        try{
            File file = new File("Files/adminList.txt"); //location must be the path where the file is saved
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

                adminList[adminCount] = new admin(name,password,gender,dob,address);
                adminCount++;
                System.out.println(adminCount+"////////////////////////////");
            }
            sc.close();   //closing the file
        }
        catch(Exception ex){
            //System.out.println(ex);
            System.out.println("File not found.");
            return;
        }
    }
    public void addadmin(admin a){
        adminList[adminCount]=a;
        adminCount++;
        //also adding them in file
        String adminDetails="Name: "+ a.getAName() + "\n";
        adminDetails+="Password: "+ a.getAPassword() + "\n";
        adminDetails+="Gender: "+ a.getAGender() + "\n";
        adminDetails+="Date of birth: "+ a.getADOB() + "\n";
        adminDetails+="Address: "+a.getAAddress() + "\n" + "\n";
        try{
            FileWriter fw = new FileWriter("Files/adminList.txt",true);
            fw.write(adminDetails);
            fw.close();
        }catch(Exception ex){
            System.out.println(ex);
        }
    }
    public admin checkAdminCredentials(int index, String pass){
        if((adminList[index].getAPassword().equals(pass))){
            return adminList[index];
        }else{return null;}
    }
    public int adminExists(String name){
        int index = -1;
        for(int i=0;i<adminCount;i++){
            if (adminList[i] != null && adminList[i].getAName().equals(name)) {
                index = i;
                break;
            }
        }
        return index;
    }




    public admin getadmin(int index){
        return adminList[index];
    }

    public void updateadmin(admin oldadmin, admin updatedadmin){

        String oldadminDetails="Name: "+ oldadmin.getAName() + "\n";
        oldadminDetails+="Password: "+ oldadmin.getAPassword() + "\n";
        oldadminDetails+="Gender: "+ oldadmin.getAGender() + "\n";
        oldadminDetails+="Date of birth: "+ oldadmin.getADOB() + "\n";
        oldadminDetails+="Address: "+oldadmin.getAAddress() + "\n";

        //deleting from file
        String updatedDetails="Name: "+ updatedadmin.getAName() + "\n";
        updatedDetails+="Password: "+ updatedadmin.getAPassword() + "\n";
        updatedDetails+="Gender: "+ updatedadmin.getAGender() + "\n";
        updatedDetails+="Date of birth: "+ updatedadmin.getADOB() + "\n";
        updatedDetails+="Address: "+updatedadmin.getAAddress() + "\n";

        try{
            String filepath = "Files/adminList.txt";
            File originalFile = new File(filepath);

            String newDetails = "";
            Scanner sc = new Scanner(originalFile);
            while(sc.hasNext()){
                String readadmin = sc.nextLine() + "\n";
                readadmin += sc.nextLine() + "\n";
                readadmin += sc.nextLine() + "\n";
                readadmin += sc.nextLine() + "\n";
                readadmin += sc.nextLine() +"\n";
                readadmin += sc.nextLine();

                System.out.println(readadmin);
                System.out.println(oldadminDetails);

                if(readadmin.equals(oldadminDetails)){
                    System.out.println("Updated");
                    newDetails += updatedDetails + "\n";
                }else{
                    System.out.println("Writing");
                    newDetails += readadmin + "\n";
                }
            } sc.close();
            FileWriter fw = new FileWriter(filepath);
            fw.write(newDetails);
            fw.close();
        }catch(Exception ex){
            System.out.println(ex);
        }
    }

    public void deleteadmin(admin u){
        int index = adminExists(u.getAName());
        for(int i=index;i<adminCount-1;i++){
            adminList[i]=adminList[i+1];
        }
        --adminCount;
        adminList[adminCount]=null;

        //deleting from file
        String adminDetails="Name: "+ u.getAName() + "\n";
        adminDetails+="Password: "+ u.getAPassword() + "\n";
        adminDetails+="Gender: "+ u.getAGender() + "\n";
        adminDetails+="Date of birth: "+ u.getADOB() + "\n";
        adminDetails+="Address: "+u.getAAddress() + "\n";

        try{
            String filepath = "Files/adminList.txt";
            File originalFile = new File(filepath);

            String newDetails = "";
            Scanner sc = new Scanner(originalFile);
            while(sc.hasNext()){
                String readadmin = sc.nextLine() + "\n";
                readadmin += sc.nextLine() + "\n";
                readadmin += sc.nextLine() + "\n";
                readadmin += sc.nextLine() + "\n";
                readadmin += sc.nextLine() +"\n";
                readadmin += sc.nextLine();

                System.out.println(readadmin);
                System.out.println(adminDetails);

                if(readadmin.equals(adminDetails)){
                    System.out.println("Equal");
                    //newDetails += updatedDetails + "\n";
                    continue;
                }
                System.out.println("Writing");
                newDetails += readadmin + "\n";
            } sc.close();
            FileWriter fw = new FileWriter(filepath);
            fw.write(newDetails);
            fw.close();
        }catch(Exception ex){
            System.out.println(ex);
        }
    }
}