package Classes;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.lang.*;

public class admin_signup_page extends JFrame implements ActionListener {

    JPanel admin_signup_panel;
    JLabel userLabel, passwordLabel, confirmPassLabel, genderLabel, dobLabel, addressLabel;
    JTextField userTF, addressTF;
    JPasswordField passwordTF, confirmPasswordTF;
    JButton signUpBtn;
    JRadioButton r1,r2,r3;
    ButtonGroup bg;
    JComboBox date,month,year;
    Color myColor1, myColor2;
    Font myFont, myFont2;
    ImageIcon icon;
    ImageIcon customer_go_back_icon,bgc;
    JButton admin_goback;
    ImageIcon bgca;
    JLabel label22,adminsignup,cfirstname,afirstname ;
    JTextField clastnamebox,cfirstnamebox;
    admins as;
    users us;
    admin a;
    double store;
    admin_login lgg;
    public admin_signup_page(admins as,admin_login lgg)
    {
        setTitle("Admin Signup");
        setSize(1000,700);
        setResizable(false);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        admin_signup_panel =new JPanel();
        admin_signup_panel.setLayout(null);
        ImageIcon mainlogo = new ImageIcon("main-logo.jpg");
        setIconImage(mainlogo.getImage());

        this.us=us;
        this.lgg =lgg;
        this.a=a;
        this.as=as;
//////Colors+fonts
////////////WORKED
        ///////adminsignup
        adminsignup =new JLabel("Admin Signup");
        adminsignup.setBounds(182,78,390,62);
        adminsignup.setForeground(new Color(96,3,0));
        adminsignup.setFont(new Font("Raleway",Font.BOLD,52));
        admin_signup_panel.add(adminsignup);
///////FirstName
        cfirstname =new JLabel("First Name:");
        cfirstname.setBounds(165,175,140,28);
        cfirstname.setForeground(new Color(96,3,0));
        cfirstname.setFont(new Font("Raleway",Font.PLAIN,25));
        admin_signup_panel.add(cfirstname);
        ///////FirstName text bx
        cfirstnamebox =new JTextField();
        cfirstnamebox.setBounds(331,172,242,30);
        cfirstnamebox.setForeground(new Color(96,3,0));
        cfirstnamebox.setFont(new Font("Raleway",Font.PLAIN,25));
        admin_signup_panel.add(cfirstnamebox);
///////Last Name
        afirstname =new JLabel("Last Name:");
        afirstname.setBounds(165,224,140,28);
        afirstname.setForeground(new Color(96,3,0));
        afirstname.setFont(new Font("Raleway",Font.PLAIN,25));
        admin_signup_panel.add(afirstname);
        ///////Lastname text bx
        clastnamebox =new JTextField();
        clastnamebox.setBounds(331,218,242,30);
        clastnamebox.setForeground(new Color(96,3,0));
        clastnamebox.setFont(new Font("Raleway",Font.PLAIN,25));
        admin_signup_panel.add(clastnamebox);

        ////
        myColor1 = new Color(191,232,247);
        myColor2 = new Color(236,235,232);
        myFont = new Font("Century",Font.ITALIC, 17);
        myFont2 = new Font("Times New Roman",Font.PLAIN, 16);
        ///username
        userLabel = new JLabel("User name:");
        userLabel.setBounds(168,270,132,28);
        userLabel.setForeground(new Color(96,3,0));
        userLabel.setFont(new Font("Raleway",Font.PLAIN,25));
        admin_signup_panel.add(userLabel);

        //user texttfield
        userTF = new JTextField();
        userTF.setForeground(new Color(96,3,0));
        userTF.setBounds(331,266,242,30);
        userTF.setFont(new Font("Raleway",Font.PLAIN,25));

        admin_signup_panel.add(userTF);
        ////
        passwordLabel = new JLabel("Password:");
        passwordLabel.setBounds(180,467,123,27);
        passwordLabel.setForeground(new Color(96,3,0));
        passwordLabel.setFont(new Font("Raleway",Font.PLAIN,25));
        admin_signup_panel.add(passwordLabel);
/////
        passwordTF = new JPasswordField();
        passwordTF.setBounds(331,463,242,30);
        passwordTF.setFont(new Font("Raleway",Font.PLAIN,25));
        passwordTF.setEchoChar('*');
        admin_signup_panel.add(passwordTF);

        confirmPassLabel = new JLabel("Confirm Password:");
        confirmPassLabel.setForeground(new Color(96,3,0));
        confirmPassLabel.setBounds(82,521,221,28);
        confirmPassLabel.setFont(new Font("Raleway",Font.PLAIN,25));
        admin_signup_panel.add(confirmPassLabel);

        confirmPasswordTF = new JPasswordField();
        confirmPasswordTF.setBounds(331,515,242,30);
        confirmPassLabel.setFont(new Font("Raleway",Font.PLAIN,25));
        confirmPasswordTF.setEchoChar('*');
        admin_signup_panel.add(confirmPasswordTF);

        genderLabel = new JLabel("Gender: ");
        genderLabel.setBounds(211,316,100,28);
        genderLabel.setFont(new Font("Raleway",Font.PLAIN,25));
        genderLabel.setForeground(new Color(96,3,0));
        admin_signup_panel.add(genderLabel);

        dobLabel = new JLabel("Date of Birth:");
        dobLabel.setBounds(153,415,150,28);
        dobLabel.setFont(new Font("Raleway",Font.PLAIN,25));
        dobLabel.setForeground(new Color(96,3,0));
        admin_signup_panel.add(dobLabel);

        String dates[]= {"1","2","3","4","5","6","7","8","9",
                "10","11","12","13","14","15","16","17",
                "18","19","20","21","22","23","24","25",
                "26","27","28","29","30","31"};
        date = new JComboBox(dates);
        date.setBounds(331,411 ,81,30);
        date.setForeground(new Color(96,3,0));
        date.setFont(new Font("Raleway",Font.PLAIN,18));
        admin_signup_panel.add(date) ;

        String months[]= {"JAN","FEB","MAR","APR","MAY","JUN","JUL","AUG", "SEP","OCT","NOV","DEC"};
        month = new JComboBox(months);
        month.setBounds(420,411 ,81,30);
        month.setForeground(new Color(96,3,0));
        month.setFont(new Font("Raleway",Font.PLAIN,18));
        admin_signup_panel.add(month);

        String years[]= {"1990","1991","1992","1993","1994",
                "1995","1996","1997","1998","1999","2000",
                "2001","2002","2003","2004","2005","2006",
                "2007","2008","2009","2010","2011","2012",
                "2013","2014","2015","2016","2017","2018",
                "2019","2020","2021","2022","2023"};
        year = new JComboBox(years);
        year.setBounds(515,411 ,81,30);
        year.setForeground(new Color(96,3,0));
        year.setFont(new Font("Raleway",Font.PLAIN,18));
        admin_signup_panel.add(year);

        addressLabel = new JLabel("Address:");
        addressLabel.setBounds(203,365,110,27);
        addressLabel.setFont(new Font("Raleway",Font.PLAIN,25));
        addressLabel.setForeground(new Color(96,3,0));
        admin_signup_panel.add(addressLabel);

        addressTF = new JTextField();
        addressTF.setForeground(new Color(96,3,0));
        addressTF.setBounds(331,360,242,30);
        addressTF.setFont(new Font("Raleway",Font.PLAIN,25));
        admin_signup_panel.add(addressTF);

        r1 = new JRadioButton("Male");
        r1.setBounds(330,322,70,20);
        r1.setFont(new Font("Raleway",Font.PLAIN,18));
        admin_signup_panel.add(r1);

        r2 = new JRadioButton("Female");
        r2.setFont(new Font("Raleway",Font.PLAIN,18));
        r2.setBounds(402,322,100,20);
        admin_signup_panel.add(r2);

        r3 = new JRadioButton("Other");
        r3.setFont(new Font("Raleway",Font.PLAIN,18));
        r3.setBounds(500,322,100,20);
        admin_signup_panel.add(r3);

        bg = new ButtonGroup();
        bg.add(r1);
        bg.add(r2);
        bg.add(r3);

        signUpBtn = new JButton("Sign Up");
        signUpBtn.setBounds(204,564,369,40);
        signUpBtn.setFont(new Font("Raleway",Font.PLAIN,30));
        signUpBtn.setBackground(new Color(96,3,0));
        signUpBtn.setForeground(Color.WHITE);
        signUpBtn.addActionListener(this);
        signUpBtn.setFocusable(false);
        admin_signup_panel.add(signUpBtn);



        customer_go_back_icon = new ImageIcon("images\\backtest.png");
        admin_goback = new JButton(customer_go_back_icon);
        admin_goback.setBounds(895,24,78,40);
        admin_goback.setFocusable(false);
        admin_goback.addActionListener(this);
        admin_goback.setBackground(new Color(226,122,189));
        admin_goback.setOpaque(true);
        admin_signup_panel.add(admin_goback);
        add(admin_signup_panel);
        setVisible(true);
        ///////////// BACKGROUND IMAGE ADD  /////////////////
        label22 =new JLabel();
        bgca = new ImageIcon("images\\admin-login-version2.png");
        label22.setBounds(0,0,1000,700);
        label22.setIcon(bgca);
        admin_signup_panel.add(label22);

    }

    @Override
    public void actionPerformed(ActionEvent e) {

        if(e.getSource()==signUpBtn) {
            String name = "", pass = "", confirmPass = "", address = "",
                    gender = "", dt = "", mnth = "", yr = "";
            String dob = "";
            String myPass = "";

            name = userTF.getText();
            pass = passwordTF.getText();
            confirmPass = confirmPasswordTF.getText();
            address = addressTF.getText();

            if (r1.isSelected()) {
                gender = "Male";
            } else if (r2.isSelected()) {
                gender = "Female";
            } else if (r3.isSelected()) {
                gender = "Other";
            } else {
            }

            dt = date.getSelectedItem().toString();
            mnth = month.getSelectedItem().toString();
            yr = year.getSelectedItem().toString();
            dob = dt + "/" + mnth + "/" + yr;

            if ((!pass.isEmpty()) && (!confirmPass.isEmpty()) && (pass.equals(confirmPass))) {
                myPass = pass;
                if ((!name.isEmpty()) && (!gender.isEmpty()) && (!address.isEmpty())) {
                    admin a = new admin(name, myPass, gender, dob, address);

                    admins as = new admins();
                    as.addadmin(a);
                    JOptionPane.showMessageDialog(this, "Sign up successfull. Please login to continue.");

                    lgg.setVisible(true);
                    this.setVisible(false);
                } else {
                    JOptionPane.showMessageDialog(this, "Information missing!");
                }
            } else {
                JOptionPane.showMessageDialog(this, "Password missmatch/missing!");
            }
        }
        if (e.getSource() == admin_goback) {
            admin_login aw = new admin_login(a,as);
            aw.setVisible(true);
            this.setVisible(false);
        }

    }
}
