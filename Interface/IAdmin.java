package Interface;

import Classes.*;
import java.lang.*;
public interface IAdmin{
    void addUser(admin a);
    admin getAdmin(int index, String pass);
    void deleteAdmin(admin u);
    //void updateUser(user u);
}