package Classes;
import javax.swing.*;
import java.awt.*;
public class customomer_progressbar extends JFrame {
    private JPanel progressPanel;
    private JProgressBar bar;
    private JLabel loading,progres_label1;
    private ImageIcon progres_image1;
    users us;
    double store;
    user u;

    public customomer_progressbar(user u) {
        setTitle("Loading");
        setSize(1000, 700);
        progressPanel = new JPanel();
        progressPanel.setLayout(null);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        ImageIcon mainlogo = new ImageIcon("images\\main-logo.jpg");
        setIconImage(mainlogo.getImage());
        this.us=us;
        this.u=u;
///////////Loading text in screen
        loading =new JLabel();
       // loading.setText("Loading....");
        loading.setFont(new Font("Raleway",Font.BOLD,32 ));
        loading.setBounds(434,285,160,35);
        progressPanel.add(loading) ;
        /////image
        progres_label1 =new JLabel();
        progres_image1 = new ImageIcon("images\\progress_bg.jpg");
        progres_label1.setBounds(0,0,1000,700);
        progres_label1.setIcon(progres_image1);
        progressPanel.add(progres_label1);

        // LOGIN PROGRESS BAR
        bar = new JProgressBar();
        bar.setValue(0);
        bar.setBounds(328, 332, 345, 40);
        bar.setStringPainted(true);
        progressPanel.add(bar);
        bar.setString("Loading....");
        bar.setFont(new Font("Raleway",Font.BOLD,32));
        bar.setBackground(Color.WHITE);
      //  bar.setForeground(new Color(201,197,197));
        bar.setForeground(new Color(96,3,0));

        // Start a SwingWorker for the time-consuming task
        new TaskWorker().execute();

        add(progressPanel);
        setVisible(true);
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
                setVisible(false);
            customerdashboard dd = new customerdashboard(u,us,store);
            dd.setVisible(true);
            return null;

        }

        @Override
        protected void done() {
            // Task is complete; you can perform any post-processing here
        }
    }


}

