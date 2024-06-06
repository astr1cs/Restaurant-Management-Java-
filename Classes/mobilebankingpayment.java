package Classes;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.FileWriter;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class mobilebankingpayment extends JFrame implements ActionListener {
    JPanel mobilebankingpayment_panel;
    JLabel image;

    JButton payment_goback,mobilebankingbtn,paynow;
    JTextField phonebox;
    JLabel enterphnno,totalprice,passtext;
    JCheckBox aggrementchkbx;
    JPasswordField passwordbox;
    ImageIcon payment_go_back_icon,mobilebankingicon;
    ImageIcon mainlogo,bg;
    user u;
    users us;
    double totalAmount;
    double store;
    public mobilebankingpayment(double totalAmount)
    {
        setTitle("Mobilebanking Payment");
        setSize(1000,700);
        setResizable(false);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        this.u=u;
        this.us=us;
        this.totalAmount = totalAmount;

        mobilebankingpayment_panel =new JPanel();
        mobilebankingpayment_panel.setLayout(null);
//worked by meraz
        mainlogo = new ImageIcon("images\\main-logo.jpg");
        setIconImage(mainlogo.getImage());

/////////////////////////Mobile Banking Buttons////////////
        mobilebankingicon=new ImageIcon("images\\bkashjpg.png");
        mobilebankingbtn=new JButton(mobilebankingicon);
        mobilebankingbtn.setBounds(202,155,579,68);
        mobilebankingbtn.setFocusable(false);
        mobilebankingbtn.addActionListener(this);
        mobilebankingpayment_panel.add(mobilebankingbtn);
/////////////////////enterphnno //
        enterphnno=new JLabel("Enter Your Phone No:");
        enterphnno.setFont(new Font("Raleway",Font.PLAIN,18));
        enterphnno.setBounds(205,267,180,20);
        mobilebankingpayment_panel.add(enterphnno);
        /////////////////////enterphnno Box //
        phonebox=new JTextField();
        phonebox.setFont(new Font("Raleway",Font.PLAIN,18));
        phonebox.setBounds(399,262,372,30);
        mobilebankingpayment_panel.add(phonebox);
        //////////password text
        passtext=new JLabel("Password:");
        passtext.setFont(new Font("Raleway",Font.PLAIN,18));
        passtext.setBounds(298,319,88,20);
        mobilebankingpayment_panel.add(passtext);
        /////////////////////passwordbox//
        passwordbox=new JPasswordField();
        passwordbox.setFont(new Font("Raleway",Font.PLAIN,14));
        passwordbox.setBounds(398,314,170,30);
        mobilebankingpayment_panel.add(passwordbox);
        ////Total Price
        totalprice=new JLabel("Total Price:"+totalAmount);
        totalprice.setFont(new Font("Raleway",Font.PLAIN,18));
        totalprice.setBounds(291,368,300,20);
        mobilebankingpayment_panel.add(totalprice);

        //////AGREEMENT CHECK BOX
        aggrementchkbx=new JCheckBox("I have read and accept the terms of use, rules of flight and privacy policy");
        aggrementchkbx.setOpaque(false);
        aggrementchkbx.setFont(new Font("Raleway",Font.PLAIN,14));
        aggrementchkbx.setBounds(250,471,510,15);
        mobilebankingpayment_panel.add(aggrementchkbx);
        //////////PAY NOW BIG BUTTON
        paynow=new JButton("PAY NOW");
        paynow.setFont(new Font("Raleway",Font.BOLD,30));
        paynow.setBounds(225,505,565,62);
        paynow.setBackground(new Color(242,24,72));
        paynow.setForeground(Color.WHITE);
        paynow.setFocusable(false);
        paynow.setOpaque(true);
        paynow.addActionListener(this);
        mobilebankingpayment_panel.add(paynow);



//worked by meraz
        payment_go_back_icon = new ImageIcon("images\\backtest.png");
        payment_goback = new JButton(payment_go_back_icon);
        payment_goback.setBounds(895,24,78,40);
        payment_goback.setFocusable(false);
        payment_goback.addActionListener(this);
        payment_goback.setBackground(new Color(226,122,189));
        payment_goback.setOpaque(true);
        mobilebankingpayment_panel.add(payment_goback);
        mobilebankingpayment_panel.add(payment_goback);
        //IMAGE ADD
        image =new JLabel();
        bg=new ImageIcon("images\\paymentmeraz.jpg");
        image.setIcon(bg);
        image.setBounds(0,0,1000,700);
        mobilebankingpayment_panel.add(image);
        this.add(mobilebankingpayment_panel);
      //  setVisible(true);
    }
    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == payment_goback) {
            this.setVisible(false);
            Payment sd = new Payment(totalAmount);
            sd.setVisible(true);
        }
        if (e.getSource() == mobilebankingbtn) {
            this.setVisible(false);
            Payment sd = new Payment(totalAmount);
            sd.setVisible(true);
        }
        String name ="",password="",cvv="",
                mnth="",yr="",checkbox="";

        name = phonebox.getText();
        password = passwordbox.getText();
        checkbox=aggrementchkbx.getText();


        if (e.getSource() == paynow) {
            if(!name.isEmpty() && !password.isEmpty() && !checkbox.isEmpty() )
            {
                saveOrderHistory(name, totalAmount, "Mobile Banking Payment");
               // JOptionPane.showMessageDialog(this, "Payment successful!");
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