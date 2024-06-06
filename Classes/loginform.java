package Classes;
import javax.swing.*;
import java.lang.*;
import java.awt.*;
import java.awt.event.*;
import java.net.URI;
public class loginform extends JFrame implements ActionListener,MouseListener{
    JPanel loginFormpanel;
    JTextField loginTextbox;
    JPasswordField loginFormPassbox;
    JLabel loginFormuser, LoginFormpass,image, loginDontaccount, loginAdminlogin,staycon, loginFormWelcome,tag, customerUserlogin, label1,imageicn1,imageicn2,test;
    ImageIcon main,logo,icon,icon2;
    JButton loginBigLogin, adminLoginbtn, customerSignupbtn,Facebook,twitter,instagram,button,fogetpasswordbtn;
    user u  ;
    users us;
    admins as;
    admin a;
    String pass="",hiddenPass="";
    JTextField hiddenPassbox;
    JProgressBar bar1;
    double store;
    public loginform(users us)
    {
  ////////////////// FRAME AND PANEL WORKS /////////////////
        setTitle("Login");
        setSize(1000,700);
        loginFormpanel = new JPanel();
        loginFormpanel.setLayout(null);
        setResizable(false);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        ////////////////// FRAME LOGO SET  /////////////////
        ImageIcon mainlogo = new ImageIcon("images\\main-logo.jpg");
        setIconImage(mainlogo.getImage());
        /////////////LOGIN PROGRESS BAR////////////////
     /*   bar=new JProgressBar();
        bar.setValue(0);
        bar.setBounds(294,327,415,45);
        bar.setStringPainted(true);
        loginFormpanel.add(bar);

      */
        this.us = us;
        this.as = as;
        this.a= a;



////////////////// PANEL WORK  /////////////////
        ////////////////// WELCOME TEXT  /////////////////
        loginFormWelcome = new JLabel("Welcome To BlissBistro!");
        loginFormWelcome.setBounds(319,205,385,35);
        loginFormWelcome.setFont(new Font("Raleway",Font.BOLD,32));
        loginFormWelcome.setForeground(new Color(96,3,0));
        loginFormpanel.add(loginFormWelcome);
        ////////////////// TAGLINE TEXT  /////////////////
        tag = new JLabel("Where Excellence Meets Every Bite");
        tag.setBounds(348,241,320,17);
        tag.setFont(new Font("Raleway",Font.PLAIN,18));
        tag.setForeground(new Color(96,3,0));
       //tag.setBackground(Color.green);
       // tag.setOpaque(true);
        loginFormpanel.add(tag);

        ///////////////// USER LOGIN TEXT  /////////////////
        customerUserlogin = new JLabel("User Login");
        customerUserlogin.setBounds(452,266,125,27);
        customerUserlogin.setFont(new Font("Raleway",Font.PLAIN,25));
        customerUserlogin.setForeground(new Color(96,3,0));
        loginFormpanel.add(customerUserlogin);

        ///////////////// USERNAME TEXT  /////////////////
        loginFormuser = new JLabel("Username:");
        loginFormuser.setBounds(348,297,101,20);
        loginFormuser.setFont(new Font("Raleway",Font.PLAIN,18));
        loginFormuser.setForeground(new Color(96,3,0));
        loginFormpanel.add(loginFormuser);

        ///////////////// USERNAME TEXTFIELD /////////////////
        loginTextbox =new JTextField();
        loginTextbox.setBounds(350,317,296,28);
        loginTextbox.setForeground(new Color(96,3,0));
        loginTextbox.setBorder(BorderFactory.createLineBorder(new Color(96,3,0),1));
        loginTextbox.setFont(new Font("Raleway",Font.PLAIN,18));
        loginFormpanel.add(loginTextbox);

        ///////////////// PASSWORD TEXT /////////////////
        LoginFormpass = new JLabel("Password:");
        LoginFormpass.setBounds(348,350,95,20);
        LoginFormpass.setFont(new Font("Raleway",Font.PLAIN,18));
        LoginFormpass.setForeground(new Color(96,3,0));
        loginFormpanel.add(LoginFormpass);
        ///////////////// PASSWORD TEXTBOX /////////////////
        loginFormPassbox =new JPasswordField();
        loginFormPassbox.setBounds(350,371,296,28);
        loginFormPassbox.setFont(new Font("Raleway",Font.PLAIN,18));
        loginFormPassbox.setBorder(BorderFactory.createLineBorder(new Color(96,3,0),1));
        loginFormpanel.add(loginFormPassbox);
        ///////////////// PASSWORD SHOWTEXTBOX /////////////////
        hiddenPassbox =new JTextField(hiddenPass);
        hiddenPassbox.setBounds(350,371,296,28);
        hiddenPassbox.setFont(new Font("Raleway",Font.PLAIN,18));
        hiddenPassbox.setBorder(BorderFactory.createLineBorder(new Color(96,3,0),1));
        loginFormpanel.add(hiddenPassbox);

        ///////////////// PASSWORD EYE BUTTON FOR SHOW AND HIDE /////////////////
            /* icon = new ImageIcon("images\\imageicon1.png");
             icon2 = new ImageIcon("images\\imageicon2.png");button = new JButton(icon);
             button.addActionListener(this);
             button.setBounds(618, 373, 26, 25);
             button.setBackground(new Color(0, 0, 0, 0));
             button.setBorder(BorderFactory.createEmptyBorder());
             button.setContentAreaFilled(false);
             add(button, BorderLayout.CENTER);

             */
        //////////////////////////password showing



        ///////////////// LOGIN BIG BUTTON /////////////////
        loginBigLogin =new JButton();
        loginBigLogin.setText("LOGIN");
        loginBigLogin.setForeground(Color.WHITE);
        loginBigLogin.addActionListener(this);
        loginBigLogin.setBackground(new Color(96,3,0));
       // lgn.setBorder(BorderFactory.createLineBorder(new Color(96,3,0),1));
        loginBigLogin.setFont(new Font("Raleway",Font.BOLD,18));
        loginBigLogin.setBounds(350,412,297,28);
        loginBigLogin.setFocusable(false);

        loginFormpanel.add(loginBigLogin);

        ///////////////// Don't have an account? Text /////////////////
            loginDontaccount =new JLabel("Don't Have An account?") ;
            loginDontaccount.setBounds(361,460,203,20);
            loginDontaccount.setFont(new Font("Raleway",Font.PLAIN,18));
            loginDontaccount.setForeground(new Color(96,3,0));
         // dontaccount.setBackground(Color.blue);
        // dontaccount.setOpaque(true);
            loginFormpanel.add(loginDontaccount);
        ///////////////// Forget Password Button /////////////////

        fogetpasswordbtn =new JButton("Forget Password?") ;
        fogetpasswordbtn.setFont(new Font("Raleway",Font.PLAIN,12));
        fogetpasswordbtn.setBounds(443,444,140,15);
        fogetpasswordbtn.setFocusable(false);
        fogetpasswordbtn.setForeground(new Color(96,3,0));
        fogetpasswordbtn.setContentAreaFilled(false);
        fogetpasswordbtn.addActionListener(this);
        loginFormpanel.add(fogetpasswordbtn);

        ///////////////// SIGNUP TEXT Text /////////////////
        customerSignupbtn =new JButton("Signup") ;
        customerSignupbtn.setFont(new Font("Raleway",Font.PLAIN,9));
        customerSignupbtn.setBounds(570,460,67,14);
        customerSignupbtn.setFocusable(false);
      //  customerSignupbtn.setBorder(BorderFactory.createLineBorder(new Color(96,3,0),1));
        customerSignupbtn.setBackground(new Color(96,3,0));
        customerSignupbtn.setForeground(Color.WHITE);
        customerSignupbtn.addActionListener(this);
        //signup.setHorizontalTextPosition(JButton.LEFT);
       // signup.setVerticalTextPosition(JButton.CENTER);
        loginFormpanel.add(customerSignupbtn);

        //////////////// Admin login here? TEXT Text /////////////////
        loginAdminlogin =new JLabel("Admin Login Here") ;
        loginAdminlogin.setBounds(410,482,155,20);
        loginAdminlogin.setFont(new Font("Raleway",Font.PLAIN,18));
        //adminlogin.setBackground(Color.blue);
        //adminlogin.setOpaque(true);
        loginAdminlogin.setForeground(new Color(96,3,0));
        loginFormpanel.add(loginAdminlogin);

        //////////////// Login Button /////////////////
        adminLoginbtn    =new JButton() ;
        adminLoginbtn.setText("Login");
        adminLoginbtn.setBounds(570,486,67,14);
        adminLoginbtn.setFont(new Font("Raleway",Font.PLAIN,9));
        adminLoginbtn.setFocusable(false);
        adminLoginbtn.setHorizontalTextPosition(JButton.LEFT);
        adminLoginbtn.setVerticalTextPosition(JButton.CENTER);
      //  adminLoginbtn.setBorder(BorderFactory.createLineBorder(new Color(96,3,0),1));
        adminLoginbtn.setBackground(new Color(96,3,0));
        adminLoginbtn.setForeground(Color.WHITE);
        adminLoginbtn.addActionListener(this);
        loginFormpanel.add(adminLoginbtn);

////////////////// stayconnected Text /////////////////
        staycon=new JLabel("Stay Connected");
        staycon.setBounds(469,504,80,11);
        staycon.setFont(new Font("Raleway",Font.PLAIN,10));
       // staycon.setBackground(Color.green);
       // staycon.setOpaque(true);
        staycon.setForeground(new Color(96,3,0));
        loginFormpanel.add(staycon);

///////////// Facebook Button /////////////////

        Facebook=new JButton("Facebook");
        Facebook.setBounds(370,520,80,15);
        Facebook.setFont(new Font("Raleway",Font.PLAIN,9));
       // Facebook.setBorder(BorderFactory.createLineBorder(new Color(96,3,0),1));
        Facebook.setBackground(new Color(96,3,0));
        Facebook.setForeground(Color.WHITE);
        Facebook.setFocusable(false);
        Facebook.addActionListener(this);
        loginFormpanel.add(Facebook);
        ///////////// Twitter Button /////////////////
        twitter=new JButton("Twitter");
        twitter.setBounds(460,520,80,15);
        twitter.setFont(new Font("Raleway",Font.PLAIN,9));
       // twitter.setBorder(BorderFactory.createLineBorder(new Color(96,3,0),1));
        twitter.setBackground(new Color(96,3,0));
        twitter.setForeground(Color.WHITE);
        twitter.setFocusable(false);
        twitter.addActionListener(this);
        loginFormpanel.add(twitter);

        ///////////// Instagram Button /////////////////
        instagram=new JButton("Instagram");
        instagram.setBounds(550,520,80,15);
        instagram.setFont(new Font("Raleway",Font.PLAIN,9));
      //  instagram.setBorder(BorderFactory.createLineBorder(new Color(96,3,0),1));
        instagram.setBackground(new Color(96,3,0));
        instagram.setForeground(Color.WHITE);
        instagram.setFocusable(false);
        instagram.addActionListener(this);
        loginFormpanel.add(instagram);



        ///////////// BACKGROUND IMAGE ADD  /////////////////
        label1 =new JLabel();
        main = new ImageIcon("images\\main-panel.jpg");
        label1.setBounds(0,0,1000,700);
        label1.setIcon(main);
        loginFormpanel.add(label1);


///////////// SET VISIBILITY TRUE  /////////////////
        this.add(loginFormpanel);
        setVisible(true);

    }



    @Override
    public void actionPerformed(ActionEvent e) {
        if(e.getSource()== loginBigLogin) {
            loginBigLogin.setForeground(new Color(93, 3, 0));
            loginBigLogin.setBackground(Color.WHITE);

            /////////signuP PROCESSES
            String name = loginTextbox.getText();
            String pass = loginFormPassbox.getText();
            users us=new users();
            int index = us.userExists(name);
                if (index != -1) {
                    u = us.checkCredentials(index, pass); //checks username and password
                    if (u != null) {
                        JOptionPane.showMessageDialog(this, "Login successfull!");
                        //dashBoard db = new dashBoard(u,us,this);
                        //db.setVisible(true);
                        dispose();
                        //customerdashboard dd = new customerdashboard(us);
                        customomer_progressbar dd=new customomer_progressbar(u);

                    } else {
                        JOptionPane.showMessageDialog(this, "Password incorrect!");
                    }}
                     else {
                        JOptionPane.showMessageDialog(this, "User doesn't exist!");
                    }


          /*  if (name.isEmpty() && pass.isEmpty()) {
                JOptionPane.showMessageDialog(this, "Information missing.") ;

            }

           */


            }





//////////////////ete vyttib
          /*  if (e.getSource() == button) {
                if (isImage1Shown) {
                    button.setIcon(icon2);
                    isImage1Shown = false;

                } else {
                    button.setIcon(icon);
                    isImage1Shown = true;
                  //  button.setBorder(BorderFactory.createEmptyBorder());
                }
            }

           */
            /////////////////////////////////////Go to ADMIN LOGIN PANEL ////////
        if (e.getSource() == adminLoginbtn) {
            dispose();
               admin_login am=new admin_login(a,as);
            am.setVisible(true);
           // admin_progressbar dd= admin_progressbar();
        }
        /////////////////////////////////////Go to SIGNUP PAGE  ////////
        if (e.getSource() == customerSignupbtn) {
            dispose();
            customer_signup_page s=new customer_signup_page(us,this);
        }
        /////////////////////////////////////Go to WEBSITES FROM BUTTONS ////////
        if (e.getSource() == Facebook) {
            try {

                Desktop.getDesktop().browse(new URI("https://www.facebook.com/profile.php?id=100088888504568"));
            } catch (Exception ex) {
                ex.printStackTrace();
            }

        }
        if (e.getSource() == twitter) {
            try {

                Desktop.getDesktop().browse(new URI("https://twitter.com"));
            } catch (Exception ex) {
                ex.printStackTrace();
            }

        }
        if (e.getSource() == instagram) {
            try {

                Desktop.getDesktop().browse(new URI("https://www.instagram.com"));
            } catch (Exception ex) {
                ex.printStackTrace();
            }
        }
        /////////Forget passbutton
                if(e.getSource() ==fogetpasswordbtn)
                {
                    dispose();
                    forgotPassword ss=new forgotPassword(us,this);
                    ss.setVisible(true);

                }

//////////////////////////////////LOGIN TO CUSTOMER PAGE USERNAME AND PASS CHECKING/////////




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










