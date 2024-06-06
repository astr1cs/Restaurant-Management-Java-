package Classes;
import javax.swing.*;
import java.lang.*;
import java.awt.*;
import java.awt.event.*;

public class admindashboard extends JFrame implements ActionListener {
    JPanel panel;
    JButton ohistory, myaccountbtn;
    JLabel admin,adminIcon1,label12,totalSelllabel;
    JButton logout;
    ImageIcon lgicon2,amain;
    users us;
    admins as;
    admin a;
    admin_login lg;
    double fullpayment;
    double store;

    public admindashboard(admin a,admins as)
    {
        this.setTitle("Admin Dashboard");
        this.setSize(1000,700);
        this.setDefaultCloseOperation(EXIT_ON_CLOSE);
        setResizable(false);
        setLocationRelativeTo(null);
        ImageIcon mainlogo = new ImageIcon("images\\main-logo.jpg");
        setIconImage(mainlogo.getImage());

        this.a=a;
        this.as=as;



        panel=new JPanel();
        panel.setLayout(null);
   //adm,om
        admin=new JLabel("Admin Panel");
        admin.setBounds(360  ,25,225,40);
        admin.setForeground(Color.WHITE);
        admin.setFont(new Font("Raleway",Font.BOLD,35));
        panel.add(admin);

//////////////Order History Button
        ImageIcon oh=new ImageIcon("images/orderhistory.png");
        ohistory =new JButton(oh);
        ohistory.setBounds(42  ,198,175,40);
        ohistory.setFont(new Font("Raleway",Font.PLAIN,22));
        ohistory.addActionListener(this);
        ohistory.setFocusable(false);
        ohistory.setBackground(new Color(121,64,195));
        ohistory.setContentAreaFilled(false);
        ohistory.setBorder(BorderFactory.createEmptyBorder());
        ohistory.setForeground(Color.WHITE);
        panel.add(ohistory);


////////////////Total sell label
        /////
        ImageIcon myac=new ImageIcon("images/myaccounticon.png");
        myaccountbtn =new JButton(myac);
        myaccountbtn.setFont(new Font("Raleway",Font.PLAIN,22));
        myaccountbtn.setBounds(42,285,175,40);
        myaccountbtn.setFocusable(false);
        myaccountbtn.setContentAreaFilled(false);
        myaccountbtn.setBorder(BorderFactory.createEmptyBorder());
        myaccountbtn.setBackground(new Color(121,64,195));
        myaccountbtn.setForeground(Color.WHITE);
        myaccountbtn.addActionListener(this);
        panel.add(myaccountbtn);
//button logou
        adminIcon1=new JLabel();
        logout = new JButton(lgicon2);
        logout.setBounds(835,20,137,42);
       // logout.setBackground(new Color(30,30,30));
        logout.setOpaque(true);
        logout.setBorder(BorderFactory.createEmptyBorder());
        logout.setContentAreaFilled(false);
        logout.setFocusable(false);
        logout.addActionListener(this);

        lgicon2= new ImageIcon("images\\back_btnadmindashboard.png");
        // setIconImage(lgicon.getImage());
        logout.setIcon(lgicon2);
        logout.setBackground( Color.WHITE);



        panel.add(logout);
        ///////////// BACKGROUND IMAGE ADD  /////////////////
        label12 =new JLabel();
        amain = new ImageIcon("images\\admindashboardBg.png");
        label12.setBounds(0,0,1000,700);
        label12.setIcon(amain);
        panel.add(label12);


       //setVisible(true);

        this.add(panel);
       // adminDashboardProfile aaad= new adminDashboardProfile(a,as);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if(e.getSource()== logout)
        {
            dispose();
            admin_login m= new admin_login(a,as);
            m.setVisible(true);
        }
        ///////BUTTOON WORKS//////
        if(e.getSource()== ohistory)
        {
            dispose();
            order_history_page msdf= new order_history_page();

        }

        if(e.getSource()== myaccountbtn)
        {
            dispose();
            adminDashboardProfile aaad= new adminDashboardProfile(a,as);
            aaad.setVisible(true);
        }

    }
}
