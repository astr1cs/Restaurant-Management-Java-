package Classes;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;


public class creditsdebitspayment extends JFrame implements ActionListener {

    JPanel creditsdebitspayment_panel;
    JLabel image;

    JButton payment_goback,Credits_debits,paynow;

    JLabel cardHolderName,cardNumber,endDate,cvv,totalprice,aggrementlabel;
    JTextField cardholderbox,cardNumberbox;
    JCheckBox aggrementchkbx;
    JComboBox date,year;
    JPasswordField cvvpassbox;
    ImageIcon payment_go_back_icon,Credits_debitsicon;
    ImageIcon mainlogo,bg;
    user u;
    users us;
    admins as;
    admin_login lg;

    double totalAmount;
    customerdashboard m;
    double fg;

    public creditsdebitspayment(double totalAmount)
    {
        setTitle("Creditcard Payment");
        setSize(1000,700);
        setResizable(false);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        this.fg=fg;
        this.u=u;
        this.totalAmount=totalAmount;

        creditsdebitspayment_panel =new JPanel();
        creditsdebitspayment_panel.setLayout(null);
//worked by meraz
        mainlogo = new ImageIcon("images\\main-logo.jpg");
        setIconImage(mainlogo.getImage());

/////////////////////////////////////////////////////



/////////////////////////Credits_debits Buttons////////////
        Credits_debitsicon=new ImageIcon("images\\creditslabel.png");
        Credits_debits=new JButton(Credits_debitsicon);
        Credits_debits.setBounds(202,155,579,68);
        Credits_debits.setFocusable(false);
        Credits_debits.addActionListener(this);
        creditsdebitspayment_panel.add(Credits_debits);
/////////////////////cardHolderName //
        cardHolderName=new JLabel("Card Holder Name");
        cardHolderName.setFont(new Font("Raleway",Font.PLAIN,18));
        cardHolderName.setBounds(211,235,160,20);
        creditsdebitspayment_panel.add(cardHolderName);

        /////////////////////Card Number //
        cardNumber=new JLabel("Card Number");
        cardNumber.setFont(new Font("Raleway",Font.PLAIN,18));
        cardNumber.setBounds(211,319,115,20);
        creditsdebitspayment_panel.add(cardNumber);

 /////////////////////cardholderbox //
        cardholderbox=new JTextField();
        cardholderbox.setFont(new Font("Raleway",Font.PLAIN,18));
        cardholderbox.setBounds(209,263,565,42);
        creditsdebitspayment_panel.add(cardholderbox);
        /////////////////////cardNumberbox //
        cardNumberbox=new JTextField();
        cardNumberbox.setFont(new Font("Raleway",Font.PLAIN,18));
        cardNumberbox.setBounds(209,342,565,42);
        creditsdebitspayment_panel.add(cardNumberbox);
        /////////////////////endDate //
        endDate=new JLabel("End Date");
        endDate.setFont(new Font("Raleway",Font.PLAIN,14));
        endDate.setBounds(214,401,65,15);
        creditsdebitspayment_panel.add(endDate);
        /////////////////////CVV //
        cvv=new JLabel("CVV");
        cvv.setFont(new Font("Raleway",Font.PLAIN,14));
        cvv.setBounds(410,401,28,15);
        creditsdebitspayment_panel.add(cvv);
        /////////////////////CVV Passbox//
        cvvpassbox=new JPasswordField();
        cvvpassbox.setFont(new Font("Raleway",Font.PLAIN,14));
        cvvpassbox.setBounds(410,420,81,23);
        creditsdebitspayment_panel.add(cvvpassbox);
        ////Total Price
        totalprice=new JLabel("Total Price: "+totalAmount);
        totalprice.setFont(new Font("Raleway",Font.PLAIN,18));
        totalprice.setBounds(530,422,400,20);
        creditsdebitspayment_panel.add(totalprice);


        //////AGREEMENT CHECK BOX TEXT
       // aggrementlabel=new JLabel("I have read and accept the terms of use, rules of flight and privacy policy");
       // aggrementlabel.setFont(new Font("Raleway",Font.PLAIN,14));
        //aggrementlabel.setBounds(284,470,485,15);
        //creditsdebitspayment_panel.add(aggrementlabel);
        //////AGREEMENT CHECK BOX
        aggrementchkbx=new JCheckBox("I have read and accept the terms of use, rules of flight and privacy policy");
        aggrementchkbx.setOpaque(false);
        aggrementchkbx.setFont(new Font("Raleway",Font.PLAIN,14));
        aggrementchkbx.setBounds(250,471,510,15);
        creditsdebitspayment_panel.add(aggrementchkbx);
                //////////PAY NOW BIG BUTTON
        paynow=new JButton("PAY NOW");
        paynow.setFont(new Font("Raleway",Font.BOLD,30));
        paynow.setBounds(225,505,565,62);
        paynow.setBackground(new Color(242,24,72));
        paynow.setForeground(Color.WHITE);
        paynow.setFocusable(false);
        paynow.addActionListener(this);
        paynow.setOpaque(true);
        creditsdebitspayment_panel.add(paynow);
        /////COMBO BOX DATE
        String dates [] = {"JAN","FEB","MAR","APR","MAY","JUN","JUL","AUG","SEPT","OCT","NOV","DEC"
        } ;
        date=new JComboBox(dates) ;
        date.setBounds(213,421,81,23);
        creditsdebitspayment_panel.add(date);
        /////COMBO BOX YEAR
        String years [] = {"2023", "2024", "2025", "2026", "2027", "2028",
                "2029", "2030", "2031", "2032", "2033", "2034", "2035"} ;
        year=new JComboBox(years) ;
        year.setBounds(305,421,81,23);
        creditsdebitspayment_panel.add(year);



//worked by meraz
        payment_go_back_icon = new ImageIcon("images\\backtest.png");
        payment_goback = new JButton(payment_go_back_icon);
        payment_goback.setBounds(895,24,78,40);
        payment_goback.setFocusable(false);
        payment_goback.addActionListener(this);
        payment_goback.setBackground(new Color(226,122,189));
        payment_goback.setOpaque(true);
        creditsdebitspayment_panel.add(payment_goback);
        creditsdebitspayment_panel.add(payment_goback);
        //IMAGE ADD
        image =new JLabel();
        bg=new ImageIcon("images\\paymentmeraz.jpg");
        image.setIcon(bg);
        image.setBounds(0,0,1000,700);
        creditsdebitspayment_panel.add(image);
        this.add(creditsdebitspayment_panel);
       // setVisible(true);
        //double currentTotalAmount=0;
     //   currentTotalAmount+= getTotalAmount();

      //  System.out.println("TOTAL PRICE SUM "+ currentTotalAmount);

    }
    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == payment_goback) {
            this.setVisible(false);
            Payment sd = new Payment(totalAmount);
            sd.setVisible(true);
        }
        if (e.getSource() == Credits_debits) {
            this.setVisible(false);
            Payment sd = new Payment(totalAmount);
            sd.setVisible(true);
        }
        String name ="",cardnumber="",cvv="",
                mnth="",yr="",checkbox="";

        name = cardholderbox.getText();
        cardnumber = cardholderbox.getText();
        cvv=cvvpassbox.getText() ;
        checkbox=aggrementchkbx.getText();

        //


        if (e.getSource() == paynow) {
            if(!name.isEmpty() && !cardnumber.isEmpty() && !cvv.isEmpty() && !checkbox.isEmpty() ) {
                 JOptionPane.showMessageDialog(null, "Payment complete! Thank you for shopping.");
                double store=0;
                store+=getTotalAmount();

                saveOrderHistory(name, totalAmount, "Credits/Debits Payment");

                int dialog = JOptionPane.YES_NO_OPTION;
                int result = JOptionPane.showConfirmDialog(this, "Do you want to stay on this page?", "Stay on this page?", dialog);
                if (result == 0) {

                }
                else {
                    dispose();
                    customerdashboard db = new customerdashboard(u, us,store);
                    db.setVisible(true);

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

    public  double getTotalAmount() {
        return totalAmount;
    }

}