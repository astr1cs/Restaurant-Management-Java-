package Classes;
import java.lang.*;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class dashBoard extends JFrame implements MouseListener, ActionListener{
    JPanel panel;
    JLabel userLabel, passwordLabel, genderLabel, dobLabel, addressLabel,customerbgg;
    JButton logoutBtn, showBtn, editBtn, deleteBtn, changeBtn,goback;
    Font myFont;
    ImageIcon icon,customericon22,go_back_icon;
    String pass="",hiddenPass="";
    users us;
    user u;
    double store;
    loginform lg;
    public dashBoard(user u, users us){
        super("My dashboard");
        this.setSize(1000,700);
        icon = new ImageIcon("images/main-logo.jpg");
        this.setIconImage(icon.getImage());  //setting icon of the frame header
        this.setLocationRelativeTo(null);
        this.setResizable(false);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.u = u;
        this.us = us;
        this.lg = lg;
        myFont = new Font("Cambria", Font.PLAIN, 17);

        panel = new JPanel();
        panel.setLayout(null);

        userLabel = new JLabel("Username: "+u.getName());
        userLabel.setBounds(306,245,300,27);
        userLabel.setFont(new Font("Raleway",Font.PLAIN,25));
        userLabel.setForeground(Color.WHITE);
        panel.add(userLabel);

        pass = u.getPassword();
        int passLenghth = pass.length();
        for(int i =0;i<passLenghth;i++){
            hiddenPass += '*';
        }
        passwordLabel = new JLabel("Password: "+hiddenPass);
        passwordLabel.setBounds(315,297,300,27);
        passwordLabel.setFont(new Font("Raleway",Font.PLAIN,25));
        passwordLabel.setForeground(Color.WHITE);
        panel.add(passwordLabel);

        genderLabel = new JLabel("Gender: "+u.getGender());
        genderLabel.setBounds(339,348,200,27);
        genderLabel.setFont(new Font("Raleway",Font.PLAIN,25));
        genderLabel.setForeground(Color.WHITE);
        panel.add(genderLabel);

        dobLabel = new JLabel("Date of Birth: "+u.getDOB());
        dobLabel.setBounds(282,452,400,27);
        dobLabel.setFont(new Font("Raleway",Font.PLAIN,25));
        dobLabel.setForeground(Color.WHITE);
        panel.add(dobLabel);

        addressLabel = new JLabel("Address: "+u.getAddress());
        addressLabel.setBounds(330,400,200,27);
        addressLabel.setFont(new Font("Raleway",Font.PLAIN,25));
        addressLabel.setForeground(Color.WHITE);
        panel.add(addressLabel);




    /*    logoutBtn = new JButton("Log out");
        logoutBtn.setBounds(190,240,100,30);
        logoutBtn.setFont(myFont);
        logoutBtn.setForeground(Color.BLUE);
        logoutBtn.addActionListener(this);
        panel.add(logoutBtn);

     */

        showBtn = new JButton("Show");
        showBtn.setFont(new Font("Raleway",Font.PLAIN,25));
        showBtn.setForeground(Color.WHITE);
        showBtn.setBackground(new Color(255,180,0));
        showBtn.setBounds(680,185,100,25);
        showBtn.addMouseListener(this);
        showBtn.setFocusable(false);
        showBtn.addActionListener(this);
        panel.add(showBtn);

        editBtn =  new JButton("Edit profile");
        editBtn.setBounds(340,34,120,22);
        editBtn.setFont(new Font("Raleway",Font.PLAIN,16));
        editBtn.setForeground(Color.WHITE);
        editBtn.setFocusable(false);
        editBtn.setBackground(new Color(255,180,0));
        editBtn.addActionListener(this);
        panel.add(editBtn);

        changeBtn = new JButton("Change password");
        changeBtn.setBounds(480,34,170,22);
        changeBtn.addActionListener(this);
        changeBtn.setFont(new Font("Raleway",Font.PLAIN,16));
        changeBtn.setForeground(Color.WHITE);
        changeBtn.setBackground(new Color(255,180,0));
        changeBtn.setFocusable(false);

        panel.add(changeBtn);

        deleteBtn = new JButton("Delete profile");
        deleteBtn.setBounds(311,525,313,30);
        deleteBtn.setFont(new Font("Raleway",Font.PLAIN,25));
        deleteBtn.addMouseListener(this);
        deleteBtn.setBackground(new Color(255,180,0));
        deleteBtn.addActionListener(this);
        deleteBtn.setForeground(Color.WHITE);
        deleteBtn.setFocusable(false);
        panel.add(deleteBtn);

        //this.setVisible(true);
        //worked by meraz
        go_back_icon = new ImageIcon("images\\gobackbtn.png");
        goback = new JButton(go_back_icon);
        goback.setBounds(890,22,80,55);
        goback.setFocusable(false);
        goback.addActionListener(this);
        goback.setBackground(new Color(226,122,189));
        goback.setContentAreaFilled(false);
        goback.setBorder(BorderFactory.createEmptyBorder());
        panel.add(goback);

        ////////////////////////////////BACKGROUND IMAGE///////////
        customericon22 = new ImageIcon("images\\customerdashboardmyac.png");
        customerbgg =new JLabel(customericon22);
        customerbgg.setBounds(0,0,1000,700);
        //setIconImage(main.getImage());
        // customerbg.setIcon(customericon2);
        panel.add(customerbgg);

        this.add(panel);


    }

    public void mouseClicked(MouseEvent me){}
    public void mouseEntered(MouseEvent me){
        if(me.getSource() == deleteBtn){
            deleteBtn.setForeground(Color.RED);
        }else{}
    }
    public void mouseExited(MouseEvent me){
        if(me.getSource() == deleteBtn){
            deleteBtn.setForeground(Color.BLACK);
        }else{}
    }
    public void mousePressed(MouseEvent me){
        if(me.getSource() == showBtn){
            passwordLabel.setText("Password: " + pass);
        }
    }

    public void mouseReleased(MouseEvent me){
        if(me.getSource() == showBtn){
            passwordLabel.setText("Password: " + hiddenPass);
        }
    }
    public void actionPerformed(ActionEvent ae){
        String command = ae.getActionCommand();
        if (ae.getSource() == goback) {
            dispose();
            customerdashboard ff=new customerdashboard(u,us,store);
            ff.setVisible(true);
        }
         if(deleteBtn.getText().equals(command)){
            int dialog = JOptionPane.YES_NO_OPTION;
            int result = JOptionPane.showConfirmDialog(this, "Are you sure you want to delete your account?", "Delete account?", dialog);
            if(result == 0) {
                users us=new users();
                us.deleteUser(u);
                JOptionPane.showMessageDialog(this, "User deleted!");
                loginform lg = new loginform(us);
                lg.setVisible(true);
                this.setVisible(false);
            }else{}
        }else if(editBtn.getText().equals(command)){
             dispose();
            updateProfile upr = new updateProfile(u,us,this,lg);
            upr.setVisible(true);

        }else if(changeBtn.getText().equals(command)){
            String name =u.getName();
            users us=new users ();
            int index = us.userExists(name);
            updatePassword up = new updatePassword(us,name,index);
            up.setVisible(true);
            this.setVisible(false);
        }else{}


    }
}
