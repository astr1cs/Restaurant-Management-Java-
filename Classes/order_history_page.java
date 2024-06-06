package Classes;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class order_history_page extends JFrame implements ActionListener {

    JPanel order_history_panel;
    JButton orderhistory_goback;
    ImageIcon orderhistory_go_back_icon;
    JLabel order_histry;
    admins as;
    admin a;
    admin_login lg;
    double store;
    JTextArea orderHistoryTextArea;

    public order_history_page() {
        setTitle("Order History ");
        setSize(1000, 700);
        setResizable(false);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setLocationRelativeTo(null);

        order_history_panel = new JPanel(new BorderLayout());

        ImageIcon mainlogo = new ImageIcon("images\\main-logo.jpg");
        setIconImage(mainlogo.getImage());

        this.a = a;
        this.as = as;
        this.store = store;

        // Create JTextArea and add to the center of the BorderLayout
        orderHistoryTextArea = new JTextArea();
        orderHistoryTextArea.setEditable(false);
        JScrollPane scrollPane = new JScrollPane(orderHistoryTextArea);
        order_history_panel.add(scrollPane, BorderLayout.CENTER);

        loadOrderHistory();

        // Create and add the "Go Back" button to the south of the BorderLayout
        orderhistory_go_back_icon = new ImageIcon("images\\backtest.png");
        orderhistory_goback = new JButton(orderhistory_go_back_icon);
        orderhistory_goback.setFocusable(false);
        orderhistory_goback.addActionListener(this);
        orderhistory_goback.setBackground(new Color(226, 122, 189));
        orderhistory_goback.setOpaque(true);
        order_history_panel.add(orderhistory_goback, BorderLayout.SOUTH);

        // Create and add the "Order History" label to the north of the BorderLayout
        order_histry = new JLabel("Order History");
        order_histry.setFont(new Font("Raleway", Font.PLAIN, 32));
        order_history_panel.add(order_histry, BorderLayout.NORTH);

        add(order_history_panel);
        setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == orderhistory_goback) {
            dispose();
            admindashboard wwd = new admindashboard(a,as);
            wwd.setVisible(true);
        }
    }

    private void loadOrderHistory() {
        try (BufferedReader reader = new BufferedReader(new FileReader("Files/order_history.txt"))) {
            String line;
            while ((line = reader.readLine()) != null) {
                orderHistoryTextArea.append(line + "\n");
                orderHistoryTextArea.setFont(new Font("Raleway",Font.PLAIN,20));
            }
        } catch (IOException ex) {
            ex.printStackTrace();
        }
    }
}
