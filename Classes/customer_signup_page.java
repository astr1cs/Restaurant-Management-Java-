package Classes;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

public class customer_signup_page extends JFrame implements ActionListener, MouseListener {

    JPanel customer_signup_panel;
    ////
    JLabel userLabel, passwordLabel, confirmPassLabel, genderLabel, dobLabel, addressLabel;
    JTextField userTF, addressTF,cfirstnamebox,clastnamebox;
    JPasswordField passwordTF, confirmPasswordTF;
    JButton signUpBtn,backBtn;
    JRadioButton r1,r2,r3;
    ButtonGroup bg;
    JComboBox date,month,year;
    Color myColor1, myColor2;
    Font myFont, myFont2;
    ImageIcon icon;
    ImageIcon customer_go_back_icon,bgc;
    JLabel label122;
    loginform lg;
    users us;
    double store;
    JLabel adminsignup,cfirstname,afirstname;



    public customer_signup_page(users us,loginform lg)
    {
        setTitle("Customer Signup");
        setSize(1000,700);
        setResizable(false);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        customer_signup_panel =new JPanel();
        customer_signup_panel.setLayout(null);
        setVisible(true);
        ImageIcon mainlogo = new ImageIcon("images\\main-logo.jpg");
        setIconImage(mainlogo.getImage());
        this.lg =lg;
        this.us = us;

//////Colors+fonts

        myColor1 = new Color(191,232,247);
        myColor2 = new Color(236,235,232);
        myFont = new Font("Century",Font.ITALIC, 17);
        myFont2 = new Font("Raleway",Font.BOLD,30);
        ///////adminsignup
        adminsignup =new JLabel("Customer Signup");
        adminsignup.setBounds(438,78,450,62);
        adminsignup.setForeground(new Color(96,3,0));
        adminsignup.setFont(new Font("Raleway",Font.BOLD,52));
        customer_signup_panel.add(adminsignup);
///////FirstName
        cfirstname =new JLabel("First Name:");
        cfirstname.setBounds(466,175,140,28);
        cfirstname.setForeground(new Color(96,3,0));
        cfirstname.setFont(new Font("Raleway",Font.PLAIN,25));
        customer_signup_panel.add(cfirstname);
        ///////FirstName text bx
        cfirstnamebox =new JTextField();
        cfirstnamebox.setBounds(632,172,242,30);
        cfirstnamebox.setForeground(new Color(96,3,0));
        cfirstnamebox.setFont(new Font("Raleway",Font.PLAIN,25));
        customer_signup_panel.add(cfirstnamebox);
///////Last Name
        afirstname =new JLabel("Last Name:");
        afirstname.setBounds(466,224,140,28);
        afirstname.setForeground(new Color(96,3,0));
        afirstname.setFont(new Font("Raleway",Font.PLAIN,25));
        customer_signup_panel.add(afirstname);
        ///////Lastname text bx
        clastnamebox =new JTextField();
        clastnamebox.setBounds(632,219,242,30);
        clastnamebox.setForeground(new Color(96,3,0));
        clastnamebox.setFont(new Font("Raleway",Font.PLAIN,25));
        customer_signup_panel.add(clastnamebox);
        ///username
        ///username
        userLabel = new JLabel("User name:");
        userLabel.setBounds(472,270,132,28);
        userLabel.setForeground(new Color(96,3,0));
        userLabel.setFont(new Font("Raleway",Font.PLAIN,25));
        customer_signup_panel.add(userLabel);
        //user texttfield
        userTF = new JTextField();
        userTF.setForeground(new Color(96,3,0));
        userTF.setBounds(632,266,242,30);
        userTF.setFont(new Font("Raleway",Font.PLAIN,25));

        customer_signup_panel.add(userTF);
        ////
        passwordLabel = new JLabel("Password:");
        passwordLabel.setBounds(481,467,123,27);
        passwordLabel.setForeground(new Color(96,3,0));
        passwordLabel.setFont(new Font("Raleway",Font.PLAIN,25));
        customer_signup_panel.add(passwordLabel);

        passwordTF = new JPasswordField();
        passwordTF.setBounds(632,463,242,30);
        passwordTF.setFont(new Font("Raleway",Font.PLAIN,25));
        passwordTF.setEchoChar('*');
        customer_signup_panel.add(passwordTF);

        confirmPassLabel = new JLabel("Confirm Password:");
        confirmPassLabel.setForeground(new Color(96,3,0));
        confirmPassLabel.setBounds(384,521,221,28);
        confirmPassLabel.setFont(new Font("Raleway",Font.PLAIN,25));
        customer_signup_panel.add(confirmPassLabel);

        confirmPasswordTF = new JPasswordField();
        confirmPasswordTF.setBounds(632,515,242,30);
        confirmPassLabel.setFont(new Font("Raleway",Font.PLAIN,25));
        confirmPasswordTF.setEchoChar('*');
        customer_signup_panel.add(confirmPasswordTF);

        genderLabel = new JLabel("Gender: ");
        genderLabel.setBounds(512,316,100,28);
        genderLabel.setFont(new Font("Raleway",Font.PLAIN,25));
        genderLabel.setForeground(new Color(96,3,0));
        customer_signup_panel.add(genderLabel);

        dobLabel = new JLabel("Date of Birth:");
        dobLabel.setBounds(454,415,150,28);
        dobLabel.setFont(new Font("Raleway",Font.PLAIN,25));
        dobLabel.setForeground(new Color(96,3,0));
        customer_signup_panel.add(dobLabel);

        String dates[]= {"1","2","3","4","5","6","7","8","9",
                "10","11","12","13","14","15","16","17",
                "18","19","20","21","22","23","24","25",
                "26","27","28","29","30","31"};
        date = new JComboBox(dates);
        date.setBounds(632,411 ,81,30);
        date.setForeground(new Color(96,3,0));
        date.setFont(new Font("Raleway",Font.PLAIN,18));
        customer_signup_panel.add(date) ;

        String months[]= {"JAN","FEB","MAR","APR","MAY","JUN","JUL","AUG", "SEP","OCT","NOV","DEC"};
        month = new JComboBox(months);
        month.setBounds(718,411 ,81,30);
        month.setForeground(new Color(96,3,0));
        month.setFont(new Font("Raleway",Font.PLAIN,18));
        customer_signup_panel.add(month);

        String years[]= {"1990","1991","1992","1993","1994",
                "1995","1996","1997","1998","1999","2000",
                "2001","2002","2003","2004","2005","2006",
                "2007","2008","2009","2010","2011","2012",
                "2013","2014","2015","2016","2017","2018",
                "2019","2020","2021","2022","2023"};
        year = new JComboBox(years);
        year.setBounds(803,411 ,81,30);
        year.setForeground(new Color(96,3,0));
        year.setFont(new Font("Raleway",Font.PLAIN,18));
        customer_signup_panel.add(year);

        addressLabel = new JLabel("Address:");
        addressLabel.setBounds(504,365,110,27);
        addressLabel.setFont(new Font("Raleway",Font.PLAIN,25));
        addressLabel.setForeground(new Color(96,3,0));
        customer_signup_panel.add(addressLabel);

        addressTF = new JTextField();
        addressTF.setForeground(new Color(96,3,0));
        addressTF.setBounds(632,360,242,30);
        addressTF.setFont(new Font("Raleway",Font.PLAIN,25));
        customer_signup_panel.add(addressTF);

        r1 = new JRadioButton("Male");
        r1.setBounds(630,322,70,20);
        r1.setFont(new Font("Raleway",Font.PLAIN,18));
        customer_signup_panel.add(r1);

        r2 = new JRadioButton("Female");
        r2.setFont(new Font("Raleway",Font.PLAIN,18));
        r2.setBounds(705,322,100,20);
        customer_signup_panel.add(r2);

        r3 = new JRadioButton("Other");
        r3.setFont(new Font("Raleway",Font.PLAIN,18));
        r3.setBounds(810,322,100,20);
        customer_signup_panel.add(r3);

        bg = new ButtonGroup();
        bg.add(r1);
        bg.add(r2);
        bg.add(r3);

        signUpBtn = new JButton("Sign Up");
        signUpBtn.setBounds(505,564,369,40);
        signUpBtn.setFont(new Font("Raleway",Font.PLAIN,30));
        signUpBtn.setBackground(new Color(96,3,0));
        signUpBtn.setForeground(Color.WHITE);

        signUpBtn.addActionListener(this);
        signUpBtn.setFocusable(false);
        customer_signup_panel.add(signUpBtn);


        /////////goback
        icon = new ImageIcon("images\\backtest.png");
        backBtn = new JButton(icon);
        backBtn.setBounds(895,24,78,40);
        backBtn.setFocusable(false);
        backBtn.addActionListener(this);
        backBtn.setBackground(new Color(226,122,189));
        backBtn.setOpaque(true);
        customer_signup_panel.add(backBtn);


        ///////////// BACKGROUND IMAGE ADD  /////////////////
        label122 =new JLabel();
        bgc = new ImageIcon("images\\adminsignup.png");
        label122.setBounds(0,0,1000,700);
        label122.setIcon(bgc);
        customer_signup_panel.add(label122);

        this.add(customer_signup_panel);
        //this.setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        String command = e.getActionCommand();

        if(signUpBtn.getText().equals(command)){
            String name ="", firstname="", pass="", confirmPass="",address="",
                    gender="",dt="",mnth="",yr="";
            String dob="";
            String myPass="";

            name = userTF.getText();
            pass = passwordTF.getText();
            confirmPass = confirmPasswordTF.getText();
            address = addressTF.getText();
            firstname = cfirstnamebox.getText();

            if(r1.isSelected()){ gender = "Male";}
            else if(r2.isSelected()){ gender = "Female";}
            else if(r3.isSelected()){ gender = "Other";}
            else{}

            dt = date.getSelectedItem().toString();
            mnth = month.getSelectedItem().toString();
            yr = year.getSelectedItem().toString();
            dob = dt+"/"+mnth+"/"+yr;

            if((!pass.isEmpty()) && (!confirmPass.isEmpty()) && (pass.equals(confirmPass))){
                myPass = pass;
                if((!name.isEmpty()) && (!gender.isEmpty()) && (!address.isEmpty())){
                    user u = new user(name,myPass,gender,dob,address);
                    users us=new users();
                    us.addUser(u);
                    JOptionPane.showMessageDialog(this, "Sign up successfull. Please login to continue.");

                    loginform lg= new loginform(us);
                    this.setVisible(false);
                }else{
                    JOptionPane.showMessageDialog(this, "Information missing!");
                }
            }else{
                JOptionPane.showMessageDialog(this, "Password missmatch/missing!");
            }
        }
        if (e.getSource() == backBtn) {
            dispose();
            loginform am=new loginform(us);
            am.setVisible(true);
        }
    }



    @Override
    public void mouseClicked(MouseEvent e) {

    }

    @Override
    public void mousePressed(MouseEvent e) {

    }

    @Override
    public void mouseReleased(MouseEvent e) {

    }

    @Override
    public void mouseEntered(MouseEvent e) {

    }

    @Override
    public void mouseExited(MouseEvent e) {

    }
}
