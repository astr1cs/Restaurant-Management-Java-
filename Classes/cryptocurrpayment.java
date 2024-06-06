package Classes;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.FileWriter;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class cryptocurrpayment extends JFrame implements ActionListener {
    JPanel cryptocurrpayment_panel;
    JLabel image,password;
    JButton payment_goback,cryptopaymentbtn,paynow;
    JTextField addressbox,pricebox;

    JLabel addresslbl,totalprice;
    JCheckBox aggrementchkbx;
    JPasswordField passwordbox;
    ImageIcon payment_go_back_icon,cryptoicon;
    ImageIcon mainlogo,bg;
    user u;
    double store;
    users us;
    double totalAmount;
    public cryptocurrpayment( double totalAmount)
    {
        setTitle("Crypto Payment");
        setSize(1000,700);
        setResizable(false);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
this.u=u;
this.us=us;
this.totalAmount=totalAmount;
        cryptocurrpayment_panel =new JPanel();
        cryptocurrpayment_panel.setLayout(null);
//worked by meraz
        mainlogo = new ImageIcon("images\\main-logo.jpg");
        setIconImage(mainlogo.getImage());

/////////////////////////Crypto payment Buttons////////////
        cryptoicon=new ImageIcon("images\\crptopayment.png");
        cryptopaymentbtn=new JButton(cryptoicon);
        cryptopaymentbtn.setBounds(202,155,579,68);
        cryptopaymentbtn.setFocusable(false);
        cryptopaymentbtn.addActionListener(this);
        cryptocurrpayment_panel.add(cryptopaymentbtn);
/////////////////////Address //
        addresslbl=new JLabel("Token:");
        addresslbl.setFont(new Font("Raleway",Font.PLAIN,18));
        addresslbl.setBounds(325,267,75,20);
        cryptocurrpayment_panel.add(addresslbl);
        /////////password
        password=new JLabel("Password:");
        password.setFont(new Font("Raleway",Font.PLAIN,18));
        password.setBounds(297,319,90,20);
        cryptocurrpayment_panel.add(password);
//////////addressbox
        addressbox=new JTextField();
        addressbox.setFont(new Font("Raleway",Font.PLAIN,18));
        addressbox.setBounds(399,262,372,30);
        cryptocurrpayment_panel.add(addressbox);
        /////////////////////passwordbox//
        passwordbox=new JPasswordField();
        passwordbox.setFont(new Font("Raleway",Font.PLAIN,14));
        passwordbox.setBounds(399,314,157,30);
        cryptocurrpayment_panel.add(passwordbox);
        ////Total Price
        totalprice=new JLabel("Total Price:"+totalAmount);
        totalprice.setFont(new Font("Raleway",Font.PLAIN,18));
        totalprice.setBounds(290,368,400,20);
        cryptocurrpayment_panel.add(totalprice);

        //////AGREEMENT CHECK BOX
        aggrementchkbx=new JCheckBox("I have read and accept the terms of use, rules of flight and privacy policy");
        aggrementchkbx.setOpaque(false);
        aggrementchkbx.setFont(new Font("Raleway",Font.PLAIN,14));
        aggrementchkbx.setBounds(250,471,510,15);
        cryptocurrpayment_panel.add(aggrementchkbx);
        //////////PAY NOW BIG BUTTON
        paynow=new JButton("PAY NOW");
        paynow.setFont(new Font("Raleway",Font.BOLD,30));
        paynow.setBounds(225,505,565,62);
        paynow.setBackground(new Color(242,24,72));
        paynow.setForeground(Color.WHITE);
        paynow.setFocusable(false);
        paynow.addActionListener(this);
        paynow.setOpaque(true);
        cryptocurrpayment_panel.add(paynow);



//worked by meraz
        payment_go_back_icon = new ImageIcon("images\\backtest.png");
        payment_goback = new JButton(payment_go_back_icon);
        payment_goback.setBounds(895,24,78,40);
        payment_goback.setFocusable(false);
        payment_goback.addActionListener(this);
        payment_goback.setBackground(new Color(226,122,189));
        payment_goback.setOpaque(true);
        cryptocurrpayment_panel.add(payment_goback);
        cryptocurrpayment_panel.add(payment_goback);
        //IMAGE ADD
        image =new JLabel();
        bg=new ImageIcon("images\\paymentmeraz.jpg");
        image.setIcon(bg);
        image.setBounds(0,0,1000,700);
        cryptocurrpayment_panel.add(image);
        this.add(cryptocurrpayment_panel);
       // setVisible(true);
    }
    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == payment_goback) {
            this.setVisible(false);
            Payment sd = new Payment(totalAmount);
            sd.setVisible(true);
        }
        if (e.getSource() == cryptopaymentbtn) {
            this.setVisible(false);
            Payment sd = new Payment(totalAmount);
            sd.setVisible(true);
        }
        String name ="",password="",cvv="",
                mnth="",yr="",checkbox="";

        name = addressbox.getText();
        password = passwordbox.getText();
        checkbox=aggrementchkbx.getText();

        if (e.getSource() == paynow) {
            if(!name.isEmpty() && !password.isEmpty() && ! checkbox.isEmpty())

            {
                saveOrderHistory(name, totalAmount, "CryptoCurrency Payment");
             //   JOptionPane.showMessageDialog(this, "Payment successful!");
                JOptionPane.showMessageDialog(null, "Payment complete! Thank you for shopping.");
                int dialog = JOptionPane.YES_NO_OPTION;
                int result = JOptionPane.showConfirmDialog(this, "Do you want to stay on this page?", "Stay on this page?", dialog);
                if(result == 0){
                    //do nothing
                }else{
                    customerdashboard db = new customerdashboard(u,us,store);
                    db.setVisible(true);
                    dispose();
                }
            }
            else {
                JOptionPane.showMessageDialog(this, "Information missing!");
            }
        }



    }
    private void saveOrderHistory(String customerName, double orderAmount, String paymentType) {
        try (FileWriter writer = new FileWriter("Files/order_history.txt", true)) {
            SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
            String timestamp = dateFormat.format(new Date());
            String orderDetails = String.format("%s | %s | $%.2f | %s\n", timestamp, customerName, orderAmount, paymentType);
            writer.write(orderDetails);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}