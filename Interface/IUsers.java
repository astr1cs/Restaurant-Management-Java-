package Interface;

import Classes.*;
import java.lang.*;
public interface IUsers{
    void addUser(user u);
    user getUser(int index, String pass);
    void deleteUser(user u);
    void totalPrice(customerdashboard m);
    //void updateUser(user u);
}