package Classes;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.border.EmptyBorder;
import java.io.*;
import java.util.Map;

public class customerdashboard extends JFrame implements ActionListener {
    JButton ap, main, des, addToCart;
    private DefaultListModel<String> cartListModel;
    private JList<String> cartList;

    private JLabel totalPriceLabel;
    private double totalAmount;
    private testadmin admin;
    JPanel customerpanel;
    JLabel customerWelcome, menu;
    JLabel take, din, customerTotalprice;
    JButton customerLogout, customerOrder, myaccount;
    TotalSellManager fffg;
    users us;
    user u;
    ImageIcon myacimage, lgicon, mainlogo, customericon2, BBicon;
    JLabel BBlabel, customerbg;
    admins as;
    admin_login lg;
    double store;

    public customerdashboard(user u, users us,double store) {
        // FRAME SETTINGS
        setTitle("Customer Dashboard");
        setSize(1000, 700);
        setResizable(false);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        this.setResizable(false);
        this.u = u;
        this.us = us;
        this.fffg = fffg;

        new testadmin();
        totalAmount = 0.0;

        // LOGO
        mainlogo = new ImageIcon("images\\main-logo.jpg");
        setIconImage(mainlogo.getImage());

        // PANEL SETTINGS
        customerpanel = new JPanel();
        customerpanel.setLayout(null);
///////////Tesdt

        /////////
        // WELCOME Text
        customerWelcome = new JLabel();
        customerWelcome.setText("Welcome");
        customerWelcome.setFont(new Font("Raleway", Font.BOLD, 35));
        customerWelcome.setBounds(300, 25, 400, 38);
        customerWelcome.setForeground(Color.WHITE);

        // MENU LABEL
        menu = new JLabel("MENU");
        menu.setFont(new Font("Raleway", Font.BOLD, 40));
        menu.setBounds(395, 29, 140, 44);
        menu.setForeground(Color.WHITE);
        customerpanel.add(menu);

        // LOGOUT BUTTON
        lgicon = new ImageIcon("images\\logoutsmall.png");
        customerLogout = new JButton(lgicon);
        customerLogout.setBounds(935, 29, 32, 30);
        customerLogout.setFocusable(false);
        customerLogout.addActionListener(this);
        customerLogout.setBorder(BorderFactory.createEmptyBorder());
        customerLogout.setContentAreaFilled(false);
        customerpanel.add(customerLogout);

        // Myaccount Button
        myacimage = new ImageIcon("images\\myaccount.png");
        myaccount = new JButton(myacimage);
        myaccount.setBounds(810, 29, 124, 30);
        myaccount.setContentAreaFilled(false);
        myaccount.setBorder(BorderFactory.createEmptyBorder());
        myaccount.addActionListener(this);
        myaccount.setFocusable(false);
        customerpanel.add(myaccount);

//////////////////Cart list label
        ImageIcon carticon2=new ImageIcon("images\\carticon.png");
        JLabel cartlistlabel = new JLabel(carticon2);
        cartlistlabel.setBounds(710, 158, 150, 30);
        customerpanel.add(cartlistlabel);

/////////////Appetizer LABEL
        ImageIcon mainMenuIcon =new ImageIcon("images\\mainMenu.png");
        JLabel mainlabel = new JLabel(mainMenuIcon);
        mainlabel.setBounds(27,115,120,33);
        customerpanel.add(mainlabel);

/////////////MAIN LABEL
        ImageIcon appetizerMenuIcon =new ImageIcon("images\\appetizerMenu.png");
        JLabel appetizerlabel = new JLabel(appetizerMenuIcon);
        appetizerlabel.setBounds(213,115,160,33);
        customerpanel.add(appetizerlabel);

/////////////Desert LABEL
        ImageIcon desertMenuIcon =new ImageIcon("images\\desertMenu.png");
        JLabel desertMenulabel = new JLabel(desertMenuIcon);
        desertMenulabel.setBounds(425,115,120,34);
        customerpanel.add(desertMenulabel);

/////////////Drinks LABEL
        ImageIcon drinksMenuIcon =new ImageIcon("images\\drinksicon.png");
        JLabel drinksMenulabel = new JLabel(drinksMenuIcon);
        drinksMenulabel.setBounds(423,360,120,34);
        customerpanel.add(drinksMenulabel);

        // WORKS FOR CART LIST JLIST
        cartListModel = new DefaultListModel<>();
        cartList = new JList<>(cartListModel);
        cartList.setBorder(new EmptyBorder(20, 10, 20, 10));
        cartList.setBackground(new Color(178, 160, 128));
        cartList.setOpaque(true);
        cartList.setForeground(Color.WHITE);
        cartList.setFont(new Font("Raleway", Font.PLAIN, 16));

        /////////////STICK WORKS
        ImageIcon stickicon=new ImageIcon("images\\stick.png");
        JLabel sticklabel=new JLabel(stickicon);
        sticklabel.setBounds(218,192,1,382);
        customerpanel.add(sticklabel);

        ImageIcon stickicon2=new ImageIcon("images\\stick.png");
        JLabel sticklabel2=new JLabel(stickicon2);
        sticklabel2.setBounds(412,192,1,382);
        customerpanel.add(sticklabel2);


//MEnu1111
        JLabel item1Label = new JLabel("Big Burger $280");
        item1Label.setFont(new Font("Raleway", Font.PLAIN, 18));
        item1Label.setBounds(19, 183, 146, 24);
        item1Label.setForeground(Color.WHITE);
        customerpanel.add(item1Label);

        ImageIcon plusicon=new ImageIcon("images\\plusicon.png");
        JButton cartButton1 = createCartButton(item1Label);
        cartButton1.setIcon(plusicon);
        cartButton1.setContentAreaFilled(false);
        cartButton1.setBorder(BorderFactory.createEmptyBorder());
        cartButton1.setBounds(183, 185, 30, 19);
        customerpanel.add(cartButton1);
//MEnu22
        JLabel item2Label = new JLabel("Spicy Kebab  $220");
        item2Label.setFont(new Font("Raleway", Font.PLAIN, 18));
        item2Label.setBounds(19, 230, 163, 24);
        item2Label.setForeground(Color.WHITE);
        customerpanel.add(item2Label);

        ImageIcon plusicon3=new ImageIcon("images\\plusicon.png");
        JButton cartButton2 = createCartButton(item2Label);
        cartButton2.setIcon(plusicon3);
        cartButton2.setContentAreaFilled(false);
        cartButton2.setBorder(BorderFactory.createEmptyBorder());
        cartButton2.setBounds(183, 233, 30, 19);
        customerpanel.add(cartButton2);
//MEnu3
        JLabel item3Label = new JLabel("Chicken Chap $520");
        item3Label.setFont(new Font("Raleway", Font.PLAIN, 18));
        item3Label.setBounds(19, 278, 163, 24);
        item3Label.setForeground(Color.WHITE);
        customerpanel.add(item3Label);

        ImageIcon plusicon4 =new ImageIcon("images\\plusicon.png");
        JButton cartButton3 = createCartButton(item3Label);
        cartButton3.setIcon(plusicon4);
        cartButton3.setContentAreaFilled(false);
        cartButton3.setBorder(BorderFactory.createEmptyBorder());
        cartButton3.setBounds(183, 280, 30, 19);
        customerpanel.add(cartButton3);
//MEnu4
        JLabel item4Label = new JLabel("Mutton Curry $200");
        item4Label.setFont(new Font("Raleway", Font.PLAIN, 18));
        item4Label.setBounds(19, 325, 163, 24);
        item4Label.setForeground(Color.WHITE);
        customerpanel.add(item4Label);

        ImageIcon plusicon5 =new ImageIcon("images\\plusicon.png");
        JButton cartButton4 = createCartButton(item4Label);
        cartButton4.setIcon(plusicon5);
        cartButton4.setContentAreaFilled(false);
        cartButton4.setBorder(BorderFactory.createEmptyBorder());
        cartButton4.setBounds(183, 327, 30, 19);
        customerpanel.add(cartButton4);
//MEnu5
        JLabel item5Label = new JLabel("Beef Curry   $200");
        item5Label.setFont(new Font("Raleway", Font.PLAIN, 18));
        item5Label.setBounds(19, 372, 163, 24);
        item5Label.setForeground(Color.WHITE);
        customerpanel.add(item5Label);

        ImageIcon plusicon6 =new ImageIcon("images\\plusicon.png");
        JButton cartButton5 = createCartButton(item5Label);
        cartButton5.setIcon(plusicon6);
        cartButton5.setContentAreaFilled(false);
        cartButton5.setBorder(BorderFactory.createEmptyBorder());
        cartButton5.setBounds(183, 374, 30, 19);
        customerpanel.add(cartButton5);
//MEnu6
        JLabel item6Label = new JLabel("Chicken Grill $200");
        item6Label.setFont(new Font("Raleway", Font.PLAIN, 18));
        item6Label.setBounds(19, 418, 163, 24);
        item6Label.setForeground(Color.WHITE);
        customerpanel.add(item6Label);

        ImageIcon plusicon7 =new ImageIcon("images\\plusicon.png");
        JButton cartButton6 = createCartButton(item6Label);
        cartButton6.setIcon(plusicon5);
        cartButton6.setContentAreaFilled(false);
        cartButton6.setBorder(BorderFactory.createEmptyBorder());
        cartButton6.setBounds(183, 422, 30, 19);
        customerpanel.add(cartButton6);
//MEnu7
        JLabel item7Label = new JLabel("Beef Kacchi $200");
        item7Label.setFont(new Font("Raleway", Font.PLAIN, 18));
        item7Label.setBounds(19, 466, 163, 24);
        item7Label.setForeground(Color.WHITE);
        customerpanel.add(item7Label);

        ImageIcon plusicon8 =new ImageIcon("images\\plusicon.png");
        JButton cartButton7 = createCartButton(item7Label);
        cartButton7.setIcon(plusicon8);
        cartButton7.setContentAreaFilled(false);
        cartButton7.setBorder(BorderFactory.createEmptyBorder());
        cartButton7.setBounds(183, 466, 30, 19);
        customerpanel.add(cartButton7);

        //MEnu8
        JLabel item8Label = new JLabel("Special Pizza $200");
        item8Label.setFont(new Font("Raleway", Font.PLAIN, 18));
        item8Label.setBounds(19, 513, 163, 24);
        item8Label.setForeground(Color.WHITE);
        customerpanel.add(item8Label);

        ImageIcon plusicon9 =new ImageIcon("images\\plusicon.png");
        JButton cartButton8 = createCartButton(item8Label);
        cartButton8.setIcon(plusicon9);
        cartButton8.setContentAreaFilled(false);
        cartButton8.setBorder(BorderFactory.createEmptyBorder());
        cartButton8.setBounds(183, 514, 30, 19);
        customerpanel.add(cartButton8);

        //MEnu9
        JLabel item9Label = new JLabel("Butter Nan $200");
        item9Label.setFont(new Font("Raleway", Font.PLAIN, 18));
        item9Label.setBounds(19, 560, 163, 24);
        item9Label.setForeground(Color.WHITE);
        customerpanel.add(item9Label);

        ImageIcon plusicon10 =new ImageIcon("images\\plusicon.png");
        JButton cartButton9 = createCartButton(item9Label);
        cartButton9.setIcon(plusicon10);
        cartButton9.setContentAreaFilled(false);
        cartButton9.setBorder(BorderFactory.createEmptyBorder());
        cartButton9.setBounds(183, 562, 30, 19);
        customerpanel.add(cartButton9);

        ///////////////////////////////////////////////////////////

    ///Appe1
        JLabel ap1Label = new JLabel("Nachos $280");
        ap1Label.setFont(new Font("Raleway", Font.PLAIN, 18));
        ap1Label.setBounds(230, 183, 146, 24);
        ap1Label.setForeground(Color.WHITE);
        customerpanel.add(ap1Label);

        ImageIcon plusPlusicon1=new ImageIcon("images\\plusicon.png");
        JButton cartBtn1 = createCartButton(ap1Label);
        cartBtn1.setIcon(plusPlusicon1);
        cartBtn1.setContentAreaFilled(false);
        cartBtn1.setBorder(BorderFactory.createEmptyBorder());
        cartBtn1.setBounds(381, 185, 30, 19);
        customerpanel.add(cartBtn1);

///Appe2
        JLabel ap2Label = new JLabel("Thai Soup $220");
        ap2Label.setFont(new Font("Raleway", Font.PLAIN, 18));
        ap2Label.setBounds(231, 230, 163, 24);
        ap2Label.setForeground(Color.WHITE);
        customerpanel.add(ap2Label);

        ImageIcon plusPlusicon2=new ImageIcon("images\\plusicon.png");
        JButton cartBtn2 = createCartButton(ap2Label);
        cartBtn2.setIcon(plusPlusicon2);
        cartBtn2.setContentAreaFilled(false);
        cartBtn2.setBorder(BorderFactory.createEmptyBorder());
        cartBtn2.setBounds(381, 233, 30, 19);
        customerpanel.add(cartBtn2);

///Appe3
        JLabel ap3Label = new JLabel("Wonton $520");
        ap3Label.setFont(new Font("Raleway", Font.PLAIN, 18));
        ap3Label.setBounds(231, 278, 163, 24);
        ap3Label.setForeground(Color.WHITE);
        customerpanel.add(ap3Label);

        ImageIcon plusPlusicon3 =new ImageIcon("images\\plusicon.png");
        JButton cartBtn3 = createCartButton(ap3Label);
        cartBtn3.setIcon(plusPlusicon3);
        cartBtn3.setContentAreaFilled(false);
        cartBtn3.setBorder(BorderFactory.createEmptyBorder());
        cartBtn3.setBounds(381, 280, 30, 19);
        customerpanel.add(cartBtn3);

///Appe4
        JLabel ap4Label = new JLabel("Taco $200");
        ap4Label.setFont(new Font("Raleway", Font.PLAIN, 18));
        ap4Label.setBounds(231, 325, 163, 24);
        ap4Label.setForeground(Color.WHITE);
        customerpanel.add(ap4Label);

        ImageIcon plusPlusicon4=new ImageIcon("images\\plusicon.png");
        JButton cartBtn4 = createCartButton(ap4Label);
        cartBtn4.setIcon(plusPlusicon4);
        cartBtn4.setContentAreaFilled(false);
        cartBtn4.setBorder(BorderFactory.createEmptyBorder());
        cartBtn4.setBounds(381, 327, 30, 19);
        customerpanel.add(cartBtn4);

//Appe5
        JLabel ap5Label = new JLabel("Nugget   $200");
        ap5Label.setFont(new Font("Raleway", Font.PLAIN, 18));
        ap5Label.setBounds(231, 372, 163, 24);
        ap5Label.setForeground(Color.WHITE);
        customerpanel.add(ap5Label);

        ImageIcon plusPlusicon5 =new ImageIcon("images\\plusicon.png");
        JButton cartBtn5 = createCartButton(ap5Label);
        cartBtn5.setIcon(plusPlusicon5);
        cartBtn5.setContentAreaFilled(false);
        cartBtn5.setBorder(BorderFactory.createEmptyBorder());
        cartBtn5.setBounds(381, 374, 30, 19);
        customerpanel.add(cartBtn5);

//Appe6
        JLabel ap6Label = new JLabel("Meat Ball $200");
        ap6Label.setFont(new Font("Raleway", Font.PLAIN, 18));
        ap6Label.setBounds(231, 418, 163, 24);
        ap6Label.setForeground(Color.WHITE);
        customerpanel.add(ap6Label);

        ImageIcon plusPlusicon6 =new ImageIcon("images\\plusicon.png");
        JButton cartBtn6 = createCartButton(ap6Label);
        cartBtn6.setIcon(plusPlusicon6);
        cartBtn6.setContentAreaFilled(false);
        cartBtn6.setBorder(BorderFactory.createEmptyBorder());
        cartBtn6.setBounds(381, 422, 30, 19);
        customerpanel.add(cartBtn6);

//Appe7
        JLabel ap7Label = new JLabel("Spring Roll $200");
        ap7Label.setFont(new Font("Raleway", Font.PLAIN, 18));
        ap7Label.setBounds(231, 466, 163, 24);
        ap7Label.setForeground(Color.WHITE);
        customerpanel.add(ap7Label);

        ImageIcon plusPlusicon7 =new ImageIcon("images\\plusicon.png");
        JButton cartBtn7 = createCartButton(ap7Label);
        cartBtn7.setIcon(plusPlusicon7);
        cartBtn7.setContentAreaFilled(false);
        cartBtn7.setBorder(BorderFactory.createEmptyBorder());
        cartBtn7.setBounds(381, 466, 30, 19);
        customerpanel.add(cartBtn7);

        /////////////////////////////////////////////////////////////

        /////////////Desert Menu list
///Da1
        JLabel daLabel1 = new JLabel("Nachos $280");
        daLabel1.setFont(new Font("Raleway", Font.PLAIN, 18));
        daLabel1.setBounds(425, 183, 146, 24);
        daLabel1.setForeground(Color.WHITE);
        customerpanel.add(daLabel1);

        ImageIcon daLabel1icon=new ImageIcon("images\\plusicon.png");
        JButton daBtn1 = createCartButton(daLabel1);
        daBtn1.setIcon(daLabel1icon);
        daBtn1.setContentAreaFilled(false);
        daBtn1.setBorder(BorderFactory.createEmptyBorder());
        daBtn1.setBounds(590, 185, 30, 19);
        customerpanel.add(daBtn1);

///Da2
        JLabel daLabel2 = new JLabel("Thai Soup $220");
        daLabel2.setFont(new Font("Raleway", Font.PLAIN, 18));
        daLabel2.setBounds(425, 230, 163, 24);
        daLabel2.setForeground(Color.WHITE);
        customerpanel.add(daLabel2);

        ImageIcon daLabel1icon2=new ImageIcon("images\\plusicon.png");
        JButton daBtn2 = createCartButton(daLabel2);
        daBtn2.setIcon(daLabel1icon2);
        daBtn2.setContentAreaFilled(false);
        daBtn2.setBorder(BorderFactory.createEmptyBorder());
        daBtn2.setBounds(590, 233, 30, 19);
        customerpanel.add(daBtn2);
///Da3
        JLabel daLabel3 = new JLabel("Wonton $520");
        daLabel3.setFont(new Font("Raleway", Font.PLAIN, 18));
        daLabel3.setBounds(425, 278, 163, 24);
        daLabel3.setForeground(Color.WHITE);
        customerpanel.add(daLabel3);

        ImageIcon daLabel1icon3 =new ImageIcon("images\\plusicon.png");
        JButton daBtn3 = createCartButton(daLabel3);
        daBtn3.setIcon(daLabel1icon3);
        daBtn3.setContentAreaFilled(false);
        daBtn3.setBorder(BorderFactory.createEmptyBorder());
        daBtn3.setBounds(590, 280, 30, 19);
        customerpanel.add(daBtn3);

///Da4
        JLabel daLabel4 = new JLabel("Taco $200");
        daLabel4.setFont(new Font("Raleway", Font.PLAIN, 18));
        daLabel4.setBounds(425, 325, 163, 24);
        daLabel4.setForeground(Color.WHITE);
        customerpanel.add(daLabel4);

        ImageIcon daLabel1icon4=new ImageIcon("images\\plusicon.png");
        JButton daBtn4 = createCartButton(daLabel4);
        daBtn4.setIcon(daLabel1icon4);
        daBtn4.setContentAreaFilled(false);
        daBtn4.setBorder(BorderFactory.createEmptyBorder());
        daBtn4.setBounds(590, 327, 30, 19);
        customerpanel.add(daBtn4);

////////Drinks
        ///drinks1
        JLabel drinksLabel1 = new JLabel("Soft Drinks $100");
        drinksLabel1.setFont(new Font("Raleway", Font.PLAIN, 18));
        drinksLabel1.setBounds(425, 418, 146, 24);
        drinksLabel1.setForeground(Color.WHITE);
        customerpanel.add(drinksLabel1);

        ImageIcon drinksLabel1icon=new ImageIcon("images\\plusicon.png");
        JButton drinksBtn1 = createCartButton(drinksLabel1);
        drinksBtn1.setIcon(drinksLabel1icon);
        drinksBtn1.setContentAreaFilled(false);
        drinksBtn1.setBorder(BorderFactory.createEmptyBorder());
        drinksBtn1.setBounds(590, 418, 30, 19);
        customerpanel.add(drinksBtn1);

///drinks2
        JLabel drinksLabel2 = new JLabel("MilkShake $220");
        drinksLabel2.setFont(new Font("Raleway", Font.PLAIN, 18));
        drinksLabel2.setBounds(425, 465, 163, 24);
        drinksLabel2.setForeground(Color.WHITE);
        customerpanel.add(drinksLabel2);

        ImageIcon drinksLabel1icon2=new ImageIcon("images\\plusicon.png");
        JButton drinksBtn2 = createCartButton(drinksLabel2);
        drinksBtn2.setIcon(drinksLabel1icon2);
        drinksBtn2.setContentAreaFilled(false);
        drinksBtn2.setBorder(BorderFactory.createEmptyBorder());
        drinksBtn2.setBounds(590, 462, 30, 19);
        customerpanel.add(drinksBtn2);

///drinks3
        JLabel drinksLabel3 = new JLabel("Cold Coffee $150");
        drinksLabel3.setFont(new Font("Raleway", Font.PLAIN, 18));
        drinksLabel3.setBounds(425, 512, 163, 24);
        drinksLabel3.setForeground(Color.WHITE);
        customerpanel.add(drinksLabel3);

        ImageIcon drinksLabel1icon3 =new ImageIcon("images\\plusicon.png");
        JButton drinksBtn3 = createCartButton(drinksLabel3);
        drinksBtn3.setIcon(drinksLabel1icon3);
        drinksBtn3.setContentAreaFilled(false);
        drinksBtn3.setBorder(BorderFactory.createEmptyBorder());
        drinksBtn3.setBounds(590, 510, 30, 19);
        customerpanel.add(drinksBtn3);

///drinks4
        JLabel drinksLabel4 = new JLabel("Water $20");
        drinksLabel4.setFont(new Font("Raleway", Font.PLAIN, 18));
        drinksLabel4.setBounds(425, 560, 163, 24);
        drinksLabel4.setForeground(Color.WHITE);
        customerpanel.add(drinksLabel4);

        ImageIcon drinksLabel1icon4=new ImageIcon("images\\plusicon.png");
        JButton drinksBtn4 = createCartButton(drinksLabel4);
        drinksBtn4.setIcon(drinksLabel1icon4);
        drinksBtn4.setContentAreaFilled(false);
        drinksBtn4.setBorder(BorderFactory.createEmptyBorder());
        drinksBtn4.setBounds(590, 559, 30, 19);
        customerpanel.add(drinksBtn4);


        // Remove from Cart Button
        JButton removeFromCartButton = new JButton("Remove");
        removeFromCartButton.setFocusable(false);
        removeFromCartButton.addActionListener(this);
        removeFromCartButton.setBounds(790, 585, 170, 35);
        removeFromCartButton.setBackground(new Color(255, 180, 0));
        removeFromCartButton.setOpaque(true);
        removeFromCartButton.setFont(new Font("Raleway", Font.BOLD, 20));
        removeFromCartButton.setForeground(Color.WHITE);
        customerpanel.add(removeFromCartButton);

        removeFromCartButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String selectedItem = cartList.getSelectedValue();
                if (selectedItem != null) {
                    cartListModel.removeElement(selectedItem);
                    totalAmount -= extractPrice(selectedItem);
                    totalPriceLabel.setText("Total Price: $" + totalAmount);
                }
                else {
                    JOptionPane.showMessageDialog(null, "Please select an item from the cart to remove.");
                }
            }
        });

        // ScrollPane for Cart
        JScrollPane cartScrollPane = new JScrollPane(cartList);
        cartScrollPane.setBackground(new Color(0, 0, 0, 0));
        cartScrollPane.setBounds(615, 205, 340, 320);
     //   cartScrollPane.setBorder(BorderFactory.createEmptyBorder());
        customerpanel.add(cartScrollPane);

        // Process Payment Button
        JButton paymentButton = new JButton("ORDER");
        paymentButton.setFocusable(false);
        paymentButton.addActionListener(this);
        paymentButton.setBounds(607, 585, 170, 35);
        paymentButton.setBackground(new Color(255, 180, 0));
        paymentButton.setOpaque(true);
        paymentButton.setFont(new Font("Raleway", Font.BOLD, 20));
        paymentButton.setForeground(Color.WHITE);
        customerpanel.add(paymentButton);

        paymentButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                cartListModel.clear();
              //  totalAmount = 0.0;
              //  totalPriceLabel.setText("Total Price: $0.0");
                if (e.getSource() == paymentButton) {
                    dispose();
                    double currentTotalAmount = getTotalAmount();
                    // Get the latest totalAmount
                    Payment payment = new Payment(currentTotalAmount);
                    payment.setVisible(true);

                    creditsdebitspayment wwd = new creditsdebitspayment(currentTotalAmount);
                    mobilebankingpayment wswd = new mobilebankingpayment(currentTotalAmount);
                    cryptocurrpayment wswdd = new cryptocurrpayment(currentTotalAmount);
                   //  double storage=getTotalsells();
                   // total_sell ffg=new total_sell(storage);
                }
            }
        });

        // Total Price Label
        totalPriceLabel = new JLabel("Total Price: $0.0");
        totalPriceLabel.setBounds(664, 531, 300, 22);
        totalPriceLabel.setForeground(Color.WHITE);
        totalPriceLabel.setFont(new Font("Raleway", Font.BOLD, 20));
        customerpanel.add(totalPriceLabel);



        // Adding BB LOGO
        BBicon = new ImageIcon("images\\BB_logo.png");
        BBlabel = new JLabel(BBicon);
        BBlabel.setBounds(20, 13, 140, 60);
        customerpanel.add(BBlabel);

        // BACKGROUND IMAGE
        customericon2 = new ImageIcon("images\\customerpanel.jpg");
        customerbg = new JLabel(customericon2);
        customerbg.setBounds(0, 0, 1000, 700);
        customerpanel.add(customerbg);

        this.add(customerpanel);
     //   System.out.println("TOTAL PRICE SUM IS"+gg);
    }

    private JButton createCartButton(JLabel menuItemLabel) {
        JButton cartButton = new JButton("Cart");
        cartButton.setBounds(220, menuItemLabel.getY(), 60, 20);
        cartButton.addActionListener(new CartButtonActionListener(menuItemLabel));
        return cartButton;
    }

    public class CartButtonActionListener implements ActionListener {
        private JLabel menuItemLabel;

        public CartButtonActionListener(JLabel menuItemLabel) {
            this.menuItemLabel = menuItemLabel;
        }

        @Override
        public void actionPerformed(ActionEvent e) {
            String selectedItem = menuItemLabel.getText();
            String quantityString = JOptionPane.showInputDialog(null, "Enter quantity for " + selectedItem);
            if (quantityString != null && !quantityString.isEmpty()) {
                try {
                    int quantity = Integer.parseInt(quantityString);

                    double itemPrice = extractPrice(selectedItem);
                    double totalPrice = itemPrice * quantity;
                    cartListModel.addElement(selectedItem + " x"+quantity +"  Price: "+ "$" + totalPrice);
                    totalAmount += totalPrice;
                    totalPriceLabel.setText("Total Price: $" + totalAmount);

                } catch (NumberFormatException ex) {
                    JOptionPane.showMessageDialog(null, "Invalid quantity. Please enter a valid number.");
                }

            }
        }//////////////////////////////admin sections
        public void updatePriceLabel(String selectedItem) {
            // Retrieve the current prices from the Admin class
            Map<String, Double> itemPrices = admin.getItemPrices();

            // Get the price for the selected item
            Double price = itemPrices.get(selectedItem);

            // Update the price label accordingly
            // For example:
         //    JLabel selectedLabel = findLabelForItem(selectedItem);
          //   selectedLabel.setText(selectedItem + " - Price: $" + price);
        }
////////////////////////////////////////////admin
    }
    ///set get of payment for admin
    double fg=0;
    public double getTotalAmount() {
        return totalAmount;
    }

   // public double getTotalsells() {
     //   return fg+=getTotalAmount();
  //  }






    private double extractPrice(String item) {
        String priceString = item.substring(item.lastIndexOf("$") + 1);
        return Double.parseDouble(priceString);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == customerLogout) {
            dispose();
            loginform m = new loginform(us);
            m.setVisible(true);
        }

        if (e.getSource() == myaccount) {
            dispose();
            dashBoard db = new dashBoard(u, us);
            db.setVisible(true);
        }
    }

    }

