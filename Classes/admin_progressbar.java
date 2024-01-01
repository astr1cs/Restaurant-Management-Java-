package Classes;
import javax.swing.*;
import java.awt.*;

public class admin_progressbar extends JFrame {
    private JPanel progressPanel2;
    private JProgressBar bar;
    private JLabel loading2,progres_label2;
    ImageIcon progres_image2;
    admins as;
    admin a;
    admin_login ff ;
    double store;
   admin_login lg;
    public admin_progressbar(admin a, admins as) {
        setTitle("Loading");
        setSize(1000, 700);
        progressPanel2 = new JPanel();
        progressPanel2.setLayout(null);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        this.as=as;
        this.a=a;
        ////Images
        progres_label2 =new JLabel();
        progres_image2 = new ImageIcon("images\\progress2bg.jpg");
        progres_label2.setBounds(0,0,1000,700);
        progres_label2.setIcon(progres_image2);
        progressPanel2.add(progres_label2);

        // LOGIN PROGRESS BAR
        bar = new JProgressBar();
        bar.setValue(0);
        bar.setBounds(328, 332, 345, 40);
        bar.setStringPainted(true);
        progressPanel2.add(bar);

        bar.setString("Loading....");
        bar.setFont(new Font("Raleway",Font.BOLD,32));
        bar.setBackground(Color.WHITE);
        //  bar.setForeground(new Color(201,197,197));
        bar.setForeground(new Color(226,122,189));
        // Start a SwingWorker for the time-consuming task
        new TaskWorker().execute();

        add(progressPanel2);
      //  setVisible(true);
    }

    private class TaskWorker extends SwingWorker<Void, Void> {
        @Override
        protected Void doInBackground() throws Exception {
            int counter = 0;
            while (counter <= 100) {
                bar.setValue(counter);
                try {
                    Thread.sleep(100);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                counter += 10;
            }
            dispose();
           // admins as=new admins();
            admindashboard nn=new admindashboard(a,as);
            nn.setVisible(true);

            return null;

        }

    }


}

