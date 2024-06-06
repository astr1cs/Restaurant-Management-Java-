package Classes;
import java.lang.*;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class adminUpdateProfile extends JFrame implements MouseListener, ActionListener{
    JPanel panel;
    JLabel userLabel, passwordLabel, confirmPassLabel, genderLabel, dobLabel, addressLabel,customerbagg;
    JTextField userTF, addressTF;
    JPasswordField passwordTF;
    JButton updateBtn,backBtn, clearBtn, changeBtn,goback;
    JRadioButton r1,r2,r3;
    ButtonGroup bg;
    JComboBox date,month,year;
    Color myColor1, myColor2;
    Font myFont, myFont2;
    ImageIcon icon,customericon222;

    adminDashboardProfile db;
    admin_login lg;
    admins us;
    admin u;

    public adminUpdateProfile(admin u, admins us,adminDashboardProfile db,admin_login lg){
        super("Update profile");
        this.setSize(1000,700);
        icon = new ImageIcon("images/main-logo.jpg");
        this.setIconImage(icon.getImage());
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setLocationRelativeTo(null);
        this.setResizable(false);

        this.db = db;
        this.lg = lg;
        this.us = us;
        this.u = u;

        myColor1 = new Color(191,232,247);
        myColor2 = new Color(236,235,232);
        myFont = new Font("Century",Font.ITALIC, 17);
        myFont2 = new Font("Times New Roman",Font.PLAIN, 16);

        panel = new JPanel();
        panel.setLayout(null);
        panel.setBackground(myColor2);

        userLabel = new JLabel("User name:");
        userLabel.setForeground(new Color(100,85,124));
        userLabel.setBounds(207,225,150,27);
        userLabel.setFont(new Font("Raleway",Font.PLAIN,25));
        panel.add(userLabel);

        userTF = new JTextField(u.getAName());
        userTF.setBounds(375,220,250,30);
        userTF.setFont(new Font("Raleway",Font.PLAIN,20));
        // userTF.setForeground(Color.WHITE);
        panel.add(userTF);

        genderLabel = new JLabel("Gender:");
        genderLabel.setBounds(248,353,110,27);
        genderLabel.setForeground(new Color(100,85,124));
        genderLabel.setFont(new Font("Raleway",Font.PLAIN,25));
        panel.add(genderLabel);

        dobLabel = new JLabel("Date of Birth:");
        dobLabel.setBounds(190,432,150,27);
        dobLabel.setForeground(new Color(100,85,124));
        dobLabel.setFont(new Font("Raleway",Font.PLAIN,25));
        panel.add(dobLabel);

        String dates[]= {"1","2","3","4","5","6","7","8","9",
                "10","11","12","13","14","15","16","17",
                "18","19","20","21","22","23","24","25",
                "26","27","28","29","30","31"};
        date = new JComboBox(dates);
        date.setForeground(new Color(100,85,124));
        date.setBounds(375,427,84,30);
        date.setFont(new Font("Raleway",Font.PLAIN,20));
        panel.add(date);

        String months[]= {"JAN","FEB","MAR","APR","MAY","JUN","JUL","AUG", "SEP","OCT","NOV","DEC"};
        month = new JComboBox(months);
        month.setForeground(new Color(100,85,124));
        month.setBounds(475,427,84,30);
        month.setFont(new Font("Raleway",Font.PLAIN,20));
        panel.add(month);

        String years[]= {"1990","1991","1992","1993","1994",
                "1995","1996","1997","1998","1999","2000",
                "2001","2002","2003","2004","2005","2006",
                "2007","2008","2009","2010","2011","2012",
                "2013","2014","2015","2016","2017","2018",
                "2019","2020","2021","2022","2023"};
        year = new JComboBox(years);
        year.setBounds(575,427,84,30);
        year.setForeground(new Color(100,85,124));
        year.setFont(new Font("Raleway",Font.PLAIN,20));
        panel.add(year);


        addressLabel = new JLabel("Address:");
        addressLabel.setBounds(240,295,110,27);
        addressLabel.setForeground(Color.WHITE);
        addressLabel.setForeground(new Color(100,85,124));
        addressLabel.setFont(new Font("Raleway",Font.PLAIN,25));
        panel.add(addressLabel);

        addressTF = new JTextField(u.getAAddress());
        addressTF.setBounds(375,291,250,30);
        addressTF.setFont(new Font("Raleway",Font.PLAIN,20));
        panel.add(addressTF);

        r1 = new JRadioButton("Male");
        r1.setForeground(new Color(100,85,124));
        r1.setBounds(375,350,84,30);
        r1.setFont(new Font("Raleway",Font.PLAIN,20));
        panel.add(r1);

        r2 = new JRadioButton("Female");
        r2.setBounds(465,350,100,30);
        r2.setForeground(new Color(100,85,124));
        r2.setFont(new Font("Raleway",Font.PLAIN,20));
        panel.add(r2);


        r3 = new JRadioButton("Other");
        r3.setFont(new Font("Raleway",Font.PLAIN,20));
        r3.setForeground(new Color(100,85,124));
        r3.setBounds(570,350,84,30);
        panel.add(r3);

        bg = new ButtonGroup();
        bg.add(r1);
        bg.add(r2);
        bg.add(r3);

        clearBtn = new JButton("Clear all");
        clearBtn.setBounds(311,481,150,30);
        clearBtn.setFont(new Font("Raleway",Font.PLAIN,25));
        clearBtn.setBackground(new Color(100,85,124));
        clearBtn.setForeground(Color.WHITE);
        clearBtn.setFocusable(false);
        clearBtn.addMouseListener(this);
        clearBtn.addActionListener(this);
        panel.add(clearBtn);

        updateBtn = new JButton("Update");
        updateBtn.setBounds(475,481,150,30);
        updateBtn.setFont(new Font("Raleway",Font.PLAIN,25));
        updateBtn.setBackground(new Color(15,130,92));
        updateBtn.setForeground(Color.WHITE);
        updateBtn.setFocusable(false);
        updateBtn.addMouseListener(this);
        updateBtn.addActionListener(this);
        updateBtn.setFocusable(false);
        panel.add(updateBtn);


        ////Go back
        //worked by meraz
        ImageIcon go_back_icon = new ImageIcon("images\\gobackadmin.png");
        goback = new JButton(go_back_icon);
        goback.setBounds(890,22,80,55);
        goback.setFocusable(false);
        goback.addActionListener(this);
        goback.setBackground(new Color(226,122,189));
        goback.setContentAreaFilled(false);
        goback.setBorder(BorderFactory.createEmptyBorder());
        panel.add(goback);

        ////////////////////////////////BACKGROUND IMAGE///////////
        customericon222 = new ImageIcon("images\\adashboardasdas.png");
        customerbagg =new JLabel(customericon222);
        customerbagg.setBounds(0,0,1000,700);
        panel.add(customerbagg);


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
            String name ="",address="",gender="",
                    dt="",mnth="",yr="", dob="";

            name = userTF.getText();
            address = addressTF.getText();

            if(r1.isSelected()){ gender = "Male";}
            else if(r2.isSelected()){ gender = "Female";}
            else if(r3.isSelected()){ gender = "Other";}
            else{}

            dt = date.getSelectedItem().toString();
            mnth = month.getSelectedItem().toString();
            yr = year.getSelectedItem().toString();
            dob = dt+"/"+mnth+"/"+yr;

            if((!name.isEmpty()) && (!gender.isEmpty()) && (!address.isEmpty())){
                int dialog = JOptionPane.YES_NO_OPTION;
                int result = JOptionPane.showConfirmDialog(this, "Are you sure you want to update these informations?", "Profile update?", dialog);
                if(result == 0){
                    //keeping the old info
                    String oldName = u.getAName();
                    String oldPass = u.getAPassword();
                    String oldGender = u.getAGender();
                    String oldDOB = u.getADOB();
                    String oldAddress = u.getAAddress();

                    admin oldAdmin = new admin(oldName,oldPass,oldGender,oldDOB,oldAddress);

                    //updating new info
                    u.setNAme(name);
                    u.setAGender(gender);
                    u.setADOB(dob);
                    u.setAAddress(address);
                    admins us=new admins();
                    //olso updating in file
                    us.updateadmin(oldAdmin, u);

                    dialog = JOptionPane.YES_NO_OPTION;
                    result = JOptionPane.showConfirmDialog(this, "Information updated. Do you want to stay on this page?", "Stay on this page?", dialog);
                    if(result == 0){
                        //do nothing
                    }else{

                        adminDashboardProfile db = new adminDashboardProfile(u,us);
                        db.setVisible(true);
                        this.setVisible(false);
                    }
                }else{
                    //do nothing
                }
            }else{
                JOptionPane.showMessageDialog(this, "Can't update, information missing!");
            }
        }else if(goback.getText().equals(command)){
            adminDashboardProfile db = new adminDashboardProfile(u,us);
            db.setVisible(true);
            this.setVisible(false);
        }else if(clearBtn.getText().equals(command)){
            userTF.setText("");
            addressTF.setText("");
        }else{}
    }

}