package Classes;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class Payment extends JFrame implements ActionListener{

    JPanel order_history_panel;
    JLabel pmnt,image;

    JButton payment_goback,Credits_debits,mobile_banking,cryptocurr;
    JButton visa,paypal,mastercard,bkash,nagad,rocket,bitcoin,etherium,dogecoin;
    JLabel visalabel,paypallabel,mastercardlabel;
    ImageIcon payment_go_back_icon,Credits_debitsicon;
    ImageIcon mainlogo,bg,visaicon,mastercardicon,
            paypalicon,bkashicon,nagadicon,rocketicon,
            bitcoinicon,etheriumicon,dogecoinicon,mobile_bankingicon,cryptocurricon;
    users us;
    user u;
    double fg;
    double store;
    double totalAmount;
   public Payment(double totalAmount)
    {
        setTitle("Payment Portal");
        setSize(1000,700);
        setResizable(false);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setLocationRelativeTo(null);

        order_history_panel =new JPanel();
        order_history_panel.setLayout(null);
        this.fg=fg;
        this.u=u;
        this.totalAmount=totalAmount;
        //this.totalAmount = totalAmount;
//worked by meraz
        mainlogo = new ImageIcon("images\\main-logo.jpg");
        setIconImage(mainlogo.getImage());
/////////////////////////////Payment Methods/////////////////////////////
        pmnt =new JLabel("Payment Methods");
        pmnt.setForeground(new Color(96,3,0));
        pmnt.setBounds(374,154,260,35);
        pmnt.setFont(new Font("Raleway",Font.BOLD,30));
        order_history_panel.add(pmnt);
   /////////cardpaymentjpg
/////////////////////////Credits_debits Buttons////////////
            Credits_debitsicon=new ImageIcon("images\\creditslabel.png");
            Credits_debits=new JButton(Credits_debitsicon);
            Credits_debits.setBounds(202,225,579,68);
            Credits_debits.setFocusable(false);
            Credits_debits.addActionListener(this);
            order_history_panel.add(Credits_debits);
            ////////////////////////Next buttons icons///
/////////////////////////Mobile Banking Buttons////////////
        mobile_bankingicon=new ImageIcon("images\\bkashjpg.png");
        mobile_banking=new JButton(mobile_bankingicon);
        mobile_banking.setBounds(202,335,579,69);
        mobile_banking.setFont(new Font("Raleway",Font.PLAIN,20));
        mobile_banking.setFocusable(false);
        mobile_banking.addActionListener(this);
        order_history_panel.add(mobile_banking);
        ////////////////////////BUTTONS

/////////////////////////CryptoCurrency Buttons////////////
        cryptocurricon=new ImageIcon("images\\crptopayment.png");
        cryptocurr=new JButton(cryptocurricon);
        cryptocurr.setBounds(202,445,579,69);
        cryptocurr.setFont(new Font("Raleway",Font.PLAIN,20));
        cryptocurr.addActionListener(this);
        order_history_panel.add(cryptocurr);
        //Select label
        JLabel selectlabel =new JLabel("Please Select an option to pay-");
        selectlabel.setBounds(361,533,295,22);
        selectlabel.setFont(new Font("Raleway",Font.PLAIN,20));
        order_history_panel.add(selectlabel);
//////total billlabel
        JLabel totalbilllabel =new JLabel("Total Bill: "+totalAmount);
        totalbilllabel.setBounds(385,559,300,22);
        totalbilllabel.setFont(new Font("Raleway",Font.PLAIN,20));
        order_history_panel.add(totalbilllabel);

//worked by meraz
        payment_go_back_icon = new ImageIcon("images\\backtest.png");
        payment_goback = new JButton(payment_go_back_icon);
        payment_goback.setBounds(895,24,78,40);
        payment_goback.setFocusable(false);
        payment_goback.addActionListener(this);
        payment_goback.setBackground(new Color(226,122,189));
        payment_goback.setOpaque(true);
        order_history_panel.add(payment_goback);
        order_history_panel.add(payment_goback);
        //IMAGE ADD
        image =new JLabel();
        bg=new ImageIcon("images\\paymentmeraz.jpg");
        image.setIcon(bg);
        image.setBounds(0,0,1000,700);
        order_history_panel.add(image);
        this.add(order_history_panel);
       // setVisible(true);
    }
    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == payment_goback) {
            dispose();
            customerdashboard wwd = new customerdashboard(u,us,store);
            wwd.setVisible(true);
        }
        if (e.getSource() == Credits_debits) {
            this.setVisible(false);
            creditsdebitspayment wwd = new creditsdebitspayment(totalAmount);
            wwd.setVisible(true);
        }
        if (e.getSource() == mobile_banking) {
            this.setVisible(false);
            mobilebankingpayment wswd = new mobilebankingpayment(totalAmount);
            wswd.setVisible(true);
        }
        if (e.getSource() == cryptocurr) {
            this.setVisible(false);
            cryptocurrpayment wswdd = new cryptocurrpayment(totalAmount);
            wswdd.setVisible(true);
        }
    }
}