package Classes;
import Interface.*;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
public class adminUpdatePassword extends JFrame implements MouseListener, ActionListener {
    JPanel panel;
    JLabel userLabel, passwordLabel, confirmPassLabel;
    JPasswordField passwordTF, confirmPasswordTF;
    JButton searchBtn,cancelBtn,updateBtn;
    Color myColor1, myColor2, myColor3;
    Font myFont, myFont2;
    ImageIcon icon;

    admins as;
admin a;
    String pass="", confirmPass="", newPass="";
    int index = -1;

    public adminUpdatePassword(admins as,String name,int index){
        super("Admin Upadte password");
        this.setSize(1000,700);
        icon = new ImageIcon("images/main-logo.jpg");
        this.setIconImage(icon.getImage());
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setLocationRelativeTo(null);
        this.setResizable(false);

        this.as = as;
        this.a = a;
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
      JLabel  setpasslabel=new JLabel("Set a new password");
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
       ImageIcon updticon =new ImageIcon("images\\update.png");
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

        this.add(panel);
        //this.setVisible(true);
        ///////////// BACKGROUND IMAGE ADD  /////////////////
       JLabel label1622 =new JLabel();
       ImageIcon adadd = new ImageIcon("images\\updatePass.png");
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
                admin a = as.getadmin(index);

                //keeping the old info
                String oldName = a.getAName();
                String oldPass = a.getAPassword();
                String oldGender = a.getAGender();
                String oldDOB = a.getADOB();
                String oldAddress = a.getAAddress();
                admin oldAdmin = new admin(oldName,oldPass,oldGender,oldDOB,oldAddress);

                //updating the password
                a.setAPassword(newPass);

                //also updating in file
                as.updateadmin(oldAdmin,a);

                JOptionPane.showMessageDialog(this, "Password updated. Please login to continue.");
                admin_login gg= new admin_login(a,as);
                gg.setVisible(true);
                this.setVisible(false);
            }else{
                JOptionPane.showMessageDialog(this, "Password missmatch!");
            }
        }else if(cancelBtn.getText().equals(command)){
            admin_login ff= new admin_login(a,as);
            ff.setVisible(true);
            this.setVisible(false);
        }else{}
    }
}