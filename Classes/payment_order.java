package Classes;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class payment_order extends JFrame implements ActionListener {

    JPanel payment_panel;
    JButton payment_goback;
    ImageIcon paymentback_icon;
    public payment_order()
    {
        setTitle("Payment Option ");
        setSize(1000,700);
        setResizable(false);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        payment_panel =new JPanel();
        payment_panel.setLayout(null);
        ImageIcon mainlogo = new ImageIcon("images\\main-logo.jpg");
        setIconImage(mainlogo.getImage());


        paymentback_icon = new ImageIcon("images\\backtest.png");
        payment_goback = new JButton(paymentback_icon);
        payment_goback.setBounds(895,24,78,40);
        payment_goback.setFocusable(false);
        payment_goback.addActionListener(this);
        payment_goback.setBackground(new Color(226,122,189));
        payment_goback.setOpaque(true);
        payment_panel.add(payment_goback);

        add(payment_panel);
        setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == payment_goback) {
            dispose();
          //  customerdashboard wwsd = new customerdashboard();
        }
    }
}
