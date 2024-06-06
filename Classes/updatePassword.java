package Classes;
import java.lang.*;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class updatePassword extends JFrame implements MouseListener, ActionListener{
    JPanel panel;
    JLabel userLabel, passwordLabel, confirmPassLabel,setpasslabel,label1622;
    JPasswordField passwordTF, confirmPasswordTF;
    JButton searchBtn,cancelBtn,updateBtn;
    Color myColor1, myColor2, myColor3;
    Font myFont, myFont2;
    ImageIcon icon,adadd,updticon;

    users us;

    String pass="", confirmPass="", newPass="";
    int index = -1;
    double store;
    public updatePassword(users us,String name,int index){
        super("User Upadte password");
        this.setSize(1000,700);
        icon = new ImageIcon("images/main-logo.jpg");
        this.setIconImage(icon.getImage());
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setLocationRelativeTo(null);
        this.setResizable(false);
        this.us = us;
        this.index = index;

        myColor1 = new Color(191,232,247);
        myColor2 = new Color(236,235,232);
        myColor3 = new Color(50,120,0);
        myFont = new Font("Century",Font.ITALIC, 17);
        myFont2 = new Font("Times New Roman",Font.PLAIN, 17);

        panel = new JPanel();
        panel.setLayout(null);
        panel.setBackground(myColor2);
        /////////Set pass
        setpasslabel=new JLabel("Set a new password");
        setpasslabel.setBounds(380,226,240,27);
        setpasslabel.setFont(new Font("Raleway",Font.PLAIN,25));
        setpasslabel.setForeground(new Color(96,3,0));
        panel.add(setpasslabel);


        userLabel = new JLabel("Username: "+ name);
        userLabel.setFont(new Font("Raleway",Font.PLAIN,18));
        userLabel.setBounds(380,291,300,22);
        userLabel.setForeground(new Color(96,3,0));
        panel.add(userLabel);

        passwordLabel = new JLabel("New Password:");
        passwordLabel.setBounds(351,333,141,22);
        passwordLabel.setFont(new Font("Raleway",Font.PLAIN,18));
        passwordLabel.setForeground(new Color(96,3,0));

        panel.add(passwordLabel);

        passwordTF = new JPasswordField();
        passwordTF.setBounds(506,326,174,25);
        passwordTF.setEchoChar('*');
        panel.add(passwordTF);

        confirmPassLabel = new JLabel("Confirm Password:");
        confirmPassLabel.setBounds(324,374,173,22);
        confirmPassLabel.setFont(new Font("Raleway",Font.PLAIN,18));
        confirmPassLabel.setForeground(new Color(96,3,0));
        panel.add(confirmPassLabel);

        confirmPasswordTF = new JPasswordField();
        confirmPasswordTF.setBounds(506,372,174,25);
        confirmPasswordTF.setFont(myFont2);
        confirmPasswordTF.setEchoChar('*');
        panel.add(confirmPasswordTF);
//////////////update Icon
        updticon =new ImageIcon("images\\update.png");
        updateBtn = new JButton(updticon);
        updateBtn.setBounds(363,420,299,24);
        updateBtn.addMouseListener(this);
        updateBtn.addActionListener(this);
        updateBtn.setFocusable(false);

        panel.add(updateBtn);

        cancelBtn = new JButton("Back to Login");
        cancelBtn.setBounds(456,456,100,16);
        cancelBtn.setFont(new Font("Raleway",Font.PLAIN,14));
        cancelBtn.setFocusable(false);
        cancelBtn.setContentAreaFilled(false);
        cancelBtn.setBorder(BorderFactory.createEmptyBorder());
        cancelBtn.addMouseListener(this);
        cancelBtn.setForeground(new Color(96,3,0));
        cancelBtn.addActionListener(this);

        panel.add(cancelBtn);
        ///updatePass
        ///////////// BACKGROUND IMAGE ADD  /////////////////
        label1622 =new JLabel();
        adadd = new ImageIcon("images\\updatePass.png");
        label1622.setBounds(0,0,1000,700);
        label1622.setIcon(adadd);
        panel.add(label1622);
        this.add(panel);
        //this.setVisible(true);


    }

    public void mouseClicked(MouseEvent me){}
    public void mouseEntered(MouseEvent me){}
    public void mouseExited(MouseEvent me){}
    public void mousePressed(MouseEvent me){}
    public void mouseReleased(MouseEvent me){}

    public void actionPerformed(ActionEvent ae){
        String command = ae.getActionCommand();
        if(updateBtn.getText().equals(command)){
            pass = passwordTF.getText();
            confirmPass = confirmPasswordTF.getText();
            if((!pass.isEmpty()) && (!confirmPass.isEmpty()) && (pass.equals(confirmPass))){
                newPass = pass;
                user u = us.getUser(index);

                //keeping the old info
                String oldName = u.getName();
                String oldPass = u.getPassword();
                String oldGender = u.getGender();
                String oldDOB = u.getDOB();
                String oldAddress = u.getAddress();

                user oldUser = new user(oldName,oldPass,oldGender,oldDOB,oldAddress);

                //updating the password
                u.setPassword(newPass);

                //also updating in file
                us.updateUser(oldUser,u);

                JOptionPane.showMessageDialog(this, "Password updated. Please login to continue.");
                new loginform(us);
                //lg.setVisible(true);
                this.setVisible(false);
            }else{
                JOptionPane.showMessageDialog(this, "Password missmatch!");
            }
        }else if(cancelBtn.getText().equals(command)){
             new loginform(us);
            //lg.setVisible(true);
            this.setVisible(false);
        }else{}
    }
}