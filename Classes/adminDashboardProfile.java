package Classes;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

public class adminDashboardProfile extends JFrame implements MouseListener, ActionListener {
    JPanel panel;
    JLabel userLabel, passwordLabel, genderLabel, dobLabel, addressLabel;
    JButton logoutBtn, showBtn, editBtn, deleteBtn, changeBtn;
    Font myFont;
    ImageIcon icon;
    String pass="",hiddenPass="";
    admin_login lg;
    users us;
    JButton goback;
    admins as;
    admin a;
    user u;

    public adminDashboardProfile(admin a, admins as){
        super("Admin dashboard");
        this.setSize(1000,700);
        icon = new ImageIcon("images/main-logo.jpg");
        this.setIconImage(icon.getImage());  //setting icon of the frame header
        this.setLocationRelativeTo(null);
        this.setResizable(false);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        this.a = a;
        this.lg = lg;
        this.as = as;

        myFont = new Font("Cambria", Font.PLAIN, 17);

        panel = new JPanel();
        panel.setLayout(null);

        userLabel = new JLabel("Username: "+a.getAName());
        userLabel.setBounds(306,245,300,27);
        userLabel.setFont(new Font("Raleway",Font.PLAIN,25));
        userLabel.setForeground(new Color(100,85,124));
        panel.add(userLabel);

        pass = a.getAPassword();
        int passLenghth = pass.length();
        for(int i =0;i<passLenghth;i++){
            hiddenPass += '*';
        }
        passwordLabel = new JLabel("Password: "+hiddenPass);
        passwordLabel.setBounds(315,297,300,27);
        passwordLabel.setFont(new Font("Raleway",Font.PLAIN,25));
        passwordLabel.setForeground(new Color(100,85,124));
        panel.add(passwordLabel);

        genderLabel = new JLabel("Gender: "+a.getAGender());
        genderLabel.setBounds(339,348,200,27);
        genderLabel.setFont(new Font("Raleway",Font.PLAIN,25));
        genderLabel.setForeground(new Color(100,85,124));
        panel.add(genderLabel);

        dobLabel = new JLabel("Date of Birth: "+a.getADOB());
        dobLabel.setBounds(282,452,400,27);
        dobLabel.setFont(new Font("Raleway",Font.PLAIN,25));
        dobLabel.setForeground(new Color(100,85,124));
        panel.add(dobLabel);

        addressLabel = new JLabel("Address: "+a.getAAddress());
        addressLabel.setBounds(330,400,200,27);
        addressLabel.setFont(new Font("Raleway",Font.PLAIN,25));
        addressLabel.setForeground(new Color(100,85,124));

        panel.add(addressLabel);



        showBtn = new JButton("Show");
        showBtn.setFont(new Font("Raleway",Font.PLAIN,25));
        showBtn.setForeground(Color.WHITE);
        showBtn.setBackground(new Color(100,85,124));

        showBtn.setBounds(680,185,100,25);
        showBtn.addMouseListener(this);
        showBtn.setFocusable(false);
        showBtn.addActionListener(this);
        panel.add(showBtn);

        ImageIcon sd=new ImageIcon("images\\editprofileicon.png");
        editBtn =  new JButton(sd);
        editBtn.setBounds(340,34,120,22);
        editBtn.setFont(new Font("Raleway",Font.PLAIN,16));
        editBtn.setForeground(Color.WHITE);
        editBtn.setBorder(BorderFactory.createEmptyBorder());
        editBtn.setFocusable(false);
        editBtn.setContentAreaFilled(false);
        editBtn.addActionListener(this);
        panel.add(editBtn);

        ImageIcon sdf=new ImageIcon("images\\changepassicon.png");
        changeBtn = new JButton(sdf);
        changeBtn.setBounds(480,34,170,22);
        changeBtn.addActionListener(this);
        changeBtn.setBorder(BorderFactory.createEmptyBorder());
        changeBtn.setContentAreaFilled(false);
        changeBtn.setFont(new Font("Raleway",Font.PLAIN,16));
        changeBtn.setForeground(Color.WHITE);
        changeBtn.setFocusable(false);

        panel.add(changeBtn);

        deleteBtn = new JButton("Delete profile");
        deleteBtn.setBounds(325,290,120,30);
        deleteBtn.addMouseListener(this);
        deleteBtn.addActionListener(this);
       // panel.add(deleteBtn);

        this.add(panel);
        //this.setVisible(true);
        //worked by meraz
        ImageIcon go_back_icon = new ImageIcon("images\\gobackadmin.png");
          goback = new JButton(go_back_icon);
        goback.setBounds(890,22,80,55);
        goback.setFocusable(false);
        goback.addActionListener(this);
        goback.setContentAreaFilled(false);
        goback.setBorder(BorderFactory.createEmptyBorder());
        panel.add(goback);

        deleteBtn = new JButton("Delete profile");
        deleteBtn.setBounds(311,525,313,30);
        deleteBtn.setFont(new Font("Raleway",Font.PLAIN,25));
        deleteBtn.addMouseListener(this);
        deleteBtn.setBackground(new Color(100,85,124));
        deleteBtn.addActionListener(this);
        deleteBtn.setForeground(Color.WHITE);
        deleteBtn.setFocusable(false);
        panel.add(deleteBtn);
        ////////////////////////////////BACKGROUND IMAGE///////////
        ImageIcon customericon22 = new ImageIcon("images\\adashboard22.png");
       JLabel customerbgg =new JLabel(customericon22);
        customerbgg.setBounds(0,0,1000,700);
        //setIconImage(main.getImage());
        // customerbg.setIcon(customericon2);
        panel.add(customerbgg);

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
            admindashboard ff=new admindashboard(a,as);
            ff.setVisible(true);
        }


        else if(ae.getSource()==editBtn){
            adminUpdateProfile  upr = new adminUpdateProfile(a,as,this,lg);
            upr.setVisible(true);
            this.setVisible(false);
        }else if(changeBtn.getText().equals(command)){
            String name =a.getAName();
            int index = as.adminExists(name);
            adminUpdatePassword up = new adminUpdatePassword(as,name,index);
            up.setVisible(true);
            this.setVisible(false);
        }else{}
        if(deleteBtn.getText().equals(command)){
            int dialog = JOptionPane.YES_NO_OPTION;
            int result = JOptionPane.showConfirmDialog(this, "Are you sure you want to delete your account?", "Delete account?", dialog);
            if(result == 0) {
                admins as=new admins();
                as.deleteadmin(a);
                JOptionPane.showMessageDialog(this, "Admin deleted!");
                admin_login lg = new admin_login(a,as);
                lg.setVisible(true);
                this.setVisible(false);
            }
            else{}


    }
}}
