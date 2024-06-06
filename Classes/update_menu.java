package Classes;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Map;

public class update_menu extends JFrame implements ActionListener {

    JPanel update_menu_panel;
    JButton update_menu_goback;
    ImageIcon update_menu_go_back_icon;
    JLabel updatemenu;
    admins as;
    admin a;
    admin_login lg;

    double store;
    ///
    private testadmin admin;

    // GUI components

    public update_menu()
    {
        setTitle("Update menu ");
        setSize(1000,700);
        setResizable(false);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        update_menu_panel =new JPanel();
        update_menu_panel.setLayout(null);
        ImageIcon mainlogo = new ImageIcon("images\\main-logo.jpg");
        setIconImage(mainlogo.getImage());
        this.a=a;
        this.as=as;
        this.lg=lg;


        update_menu_go_back_icon = new ImageIcon("images\\backtest.png");
        update_menu_goback = new JButton(update_menu_go_back_icon);
        update_menu_goback.setBounds(895,24,78,40);
        update_menu_goback.setFocusable(false);
        update_menu_goback.addActionListener(this);
        update_menu_goback.setBackground(new Color(226,122,189));
        update_menu_goback.setOpaque(true);
        update_menu_panel.add(update_menu_goback);
///////text/
        updatemenu =new JLabel("Update Menu");
        updatemenu.setBounds(468,128,225,40);
        updatemenu.setFont(new Font("Raleway",Font.PLAIN,32));
        update_menu_panel.add(updatemenu);
        /////////////wprlsss


        add(update_menu_panel);
        setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == update_menu_goback) {
            dispose();
            admindashboard uodte = new admindashboard(a,as);
            uodte.setVisible(true);
        }

        }

    }


