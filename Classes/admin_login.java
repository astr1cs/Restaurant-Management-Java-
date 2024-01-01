package Classes;
import javax.swing.*;
import java.lang.*;
import java.awt.*;
import java.awt.event.*;

public class admin_login extends JFrame implements ActionListener{

    JPanel panel;
    JLabel username,userlgn,pass,image,dontaccount;
    JTextField textbox;
    JPasswordField passbox;
    JButton lgn,goback,signup;

    ImageIcon bg,icon;

    users us ;
    admin a = null;
    admins as;
    double store;
    admin_login lg;
    JButton forgetpassword;
    public admin_login(admin a,admins as)
    {
        setTitle("Admin Login");
        setSize(1000,700);
        setResizable(false);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        ImageIcon mainlogo = new ImageIcon("images\\main-logo.jpg");
        setIconImage(mainlogo.getImage());
       // this.as=as;
        this.us=us;
        this.as=as;
        this.a=a;
        this.lg=lg;
        panel=new JPanel();
        panel.setLayout(null);

        userlgn =new JLabel("Admin Login");
        userlgn.setForeground(new Color(96,3,0));
        userlgn.setBounds(440,200,232,51);
        userlgn.setFont(new Font("Raleway",Font.BOLD,30));
        panel.add(userlgn);
////
        username = new JLabel("Username:");
        username.setForeground(new Color(96,3,0));
        username.setBounds(365,281,101,20);
        username.setFont(new Font("Raleway",Font.PLAIN,18));
        panel.add(username);
///
        textbox =new JTextField();
        textbox.setBounds(367,305,297,28);
        textbox.setForeground(new Color(96,3,0));

        textbox.setFont(new Font("Raleway",Font.PLAIN,18));
        panel.add(textbox);
        ////
        pass = new JLabel("Password:");
        pass.setBounds(365,350,95,20);
        pass.setFont(new Font("Raleway",Font.PLAIN,18));

        panel.add(pass);
        ////forgetpassbtn
        forgetpassword =new JButton("Forget Password?") ;
        forgetpassword.setFont(new Font("Raleway",Font.PLAIN,12));
        forgetpassword.setBounds(450,490,140,15);
        forgetpassword.setFocusable(false);
        forgetpassword.setForeground(new Color(96,3,0));
        forgetpassword.setContentAreaFilled(false);
        forgetpassword.addActionListener(this);
        panel.add(forgetpassword);

        passbox =new JPasswordField();
        passbox.setBounds(365,371,296,28);
        passbox.setFont(new Font("Raleway",Font.PLAIN,18));
        panel.add(passbox);
        ////LOGIN BIG BOX
        lgn=new JButton();
        lgn.setText("LOGIN");
        lgn.setForeground((new Color(96,3,0)));
        lgn.setBackground(new Color(255,179,255));
        lgn.setBorder(BorderFactory.createLineBorder(new Color(96,3,0),1));
        lgn.setFont(new Font("Raleway",Font.BOLD,18));
        lgn.setBounds(365,426,297,28);
        lgn.setFocusable(false);
        lgn.addActionListener(this);
        panel.add(lgn);
        //////////////////////////////////
        dontaccount=new JLabel("Don't Have An account?") ;
        dontaccount.setBounds(385,465,203,20);
        dontaccount.setFont(new Font("Raleway",Font.PLAIN,18));
        dontaccount.setForeground(new Color(96,3,0));
        // dontaccount.setBackground(Color.blue);
        // dontaccount.setOpaque(true);
        panel.add(dontaccount);
        ////////////////////
        ///////////////// SIGNUP TEXT Text /////////////////
        signup=new JButton("Signup") ;
        signup.setFont(new Font("Raleway",Font.BOLD,9));
        signup.setBounds(590,466,67,16);
        signup.setFocusable(false);
        signup.setBorder(BorderFactory.createLineBorder(new Color(96,3,0),1));
        signup.setBackground(new Color(255,179,255));
        signup.setForeground(new Color(96,3,0));
        signup.addActionListener(this);
        //signup.setHorizontalTextPosition(JButton.LEFT);
        // signup.setVerticalTextPosition(JButton.CENTER);
        panel.add(signup);

//Go back with images
        icon = new ImageIcon("images\\backtest.png");
        goback = new JButton(icon);
        goback.setBounds(895,24,78,40);
        goback.setFocusable(false);
        //goback.setBackground(new Color(0, 0, 0, 0));
       // goback.setBorder(BorderFactory.createEmptyBorder());
        goback.addActionListener(this);
       // goback.setContentAreaFilled(false);
     //   goback.setBackground(new Color(181,91,239));
        goback.setBackground(new Color(226,122,189));
       // goback.setBackground( Color.BLACK);
        goback.setOpaque(true);
        add(goback);

 //IMAGE ADD
        image =new JLabel();
        bg=new ImageIcon("images\\admin-login.jpg");
        //setIconImage(bg.getImage());
        image.setIcon(bg);
        image.setBounds(0,0,1000,700);
        panel.add(image);


        this.add(panel);
///////////// SET VISIBILITY TRUE  /////////////////
    }


    @Override
    public void actionPerformed(ActionEvent e) {
        String command = e.getActionCommand();
        /////////////////////////////////////Go to MAIN LOGIN PANEL ////////
        if (e.getSource() == goback) {
            dispose();
            loginform m= new loginform(us);
            m.setVisible(true);
        }
        if (e.getSource() == signup) {
            this.setVisible(false);
            admin_signup_page wws =new admin_signup_page(as,this) ;
            wws.setVisible(true);
        }
        //forgetpass
        if(e.getSource() ==forgetpassword)
        {
            dispose();
            adminForgetPassword ss=new adminForgetPassword(as,this);
            ss.setVisible(true);

        }
        //signup process

        if(e.getSource()==lgn) {
            String aname = textbox.getText();
            String pass = passbox.getText();

            admins as=new admins();
            int index = as.adminExists(aname);
            if(index!=-1){
                a = as.checkAdminCredentials(index,pass); //checks username and password
                if(a!=null){
                    JOptionPane.showMessageDialog(this, "Login successfull!");
                    admin_progressbar f=new admin_progressbar(a,as);
                    f.setVisible(true);
                    this.setVisible(false);
                }else{
                    JOptionPane.showMessageDialog(this, "Password incorrect!");
                }
            }
            else{
                JOptionPane.showMessageDialog(this, "User doesn't exist!");
            }


        }

        }

        }

