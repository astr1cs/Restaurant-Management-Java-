package Classes;
import java.lang.*;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class forgotPassword extends JFrame implements MouseListener, ActionListener{
    JPanel panel;
    JLabel userLabel, passwordLabel, confirmPassLabel,label622;
    JTextField userTF;
    JPasswordField passwordTF, confirmPasswordTF;
    JButton searchBtn,cancelBtn;
    Color myColor1, myColor2;
    Font myFont, myFont2;
    ImageIcon icon;
    JLabel enterusernamepass;
    loginform lg;
    users us;
    user u;
    ImageIcon adad,submit;
    double store;
    public forgotPassword(users us,loginform lg){
        super("Forgot password");
        this.setSize(1000,700);
        icon = new ImageIcon("images/main-logo.jpg");
        this.setIconImage(icon.getImage());
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setLocationRelativeTo(null);

        this.lg =lg;
        this.us = us;
        this.u= u;

        myColor1 = new Color(191,232,247);
        myColor2 = new Color(236,235,232);
        myFont = new Font("Century",Font.ITALIC, 17);
        myFont2 = new Font("Times New Roman",Font.PLAIN, 17);

        panel = new JPanel();
        panel.setLayout(null);
        panel.setBackground(myColor2);

        userLabel = new JLabel("Forgot Password");
        userLabel.setBounds(395,323,220,28);
        userLabel.setFont(new Font("Raleway",Font.BOLD,25));
        userLabel.setForeground(new Color(96,3,0));
        panel.add(userLabel);
///////////enterusernamepass
        enterusernamepass=new JLabel("Enter your username to reset your password");
        enterusernamepass.setBounds(330,358,400,18);
        enterusernamepass.setForeground(new Color(96,3,0));
        enterusernamepass.setFont(new Font("Raleway",Font.PLAIN,16));
        panel.add(enterusernamepass);
        ///////////
        userTF = new JTextField();
        userTF.setBounds(344,391,314,24);
        userTF.setForeground(new Color(96,3,0));
        userTF.setFont(new Font("Raleway",Font.PLAIN,16));
        panel.add(userTF);
///////////////////search and submit
        submit =new ImageIcon("images\\submit.png") ;
        searchBtn = new JButton(submit);
        searchBtn.setBounds(380,436,242,24);
        searchBtn.setFont(new Font("Raleway",Font.PLAIN,30));
        searchBtn.setFocusable(false);
        searchBtn.addActionListener(this);
        panel.add(searchBtn);

        cancelBtn = new JButton("Back to Login");
        cancelBtn.setBounds(455,475,100,16);
        cancelBtn.setForeground(new Color(96,3,0));
        cancelBtn.setFont(new Font("Raleway",Font.PLAIN,14));
        cancelBtn.setFocusable(false);
        cancelBtn.setContentAreaFilled(false);
        cancelBtn.setBorder(BorderFactory.createEmptyBorder());
        cancelBtn.addActionListener(this);
        panel.add(cancelBtn);
///backgroun image add
                ///////////// BACKGROUND IMAGE ADD  /////////////////
                label622 =new JLabel();
        adad = new ImageIcon("images\\forgotpass.png");
        label622.setBounds(0,0,1000,700);
        label622.setIcon(adad);
        panel.add(label622);

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
        if(searchBtn.getText().equals(command)){
            String name = userTF.getText();
            users us=new users();
            int index = us.userExists(name);

            if(index!=-1){
                updatePassword up = new updatePassword(us,name,index);
                up.setVisible(true);
                this.setVisible(false);
            }else{
                JOptionPane.showMessageDialog(this, "Username doesn't exist!");
            }
        }else if(cancelBtn.getText().equals(command)){
          new loginform (us);
           // lg.setVisible(true);
            this.setVisible(false);
        }else{}
    }
}