package digitalclock;

import javax.swing.*;
import java.awt.*;
import java.text.SimpleDateFormat;
import java.util.Calendar;

public class DigitalClock {

    public static void main(String[] args) {
        new ClockUI();
    }
}

class ClockUI extends JFrame {

    private JLabel timeLabel;
    private JLabel dayLabel;
    private JLabel dateLabel;

    private SimpleDateFormat timeFormat = new SimpleDateFormat("hh:mm:ss a");
    private SimpleDateFormat dayFormat  = new SimpleDateFormat("EEEE");
    private SimpleDateFormat dateFormat = new SimpleDateFormat("dd MMMM, yyyy");

    public ClockUI() {

        setTitle("Modern Digital Clock");
        setSize(450, 300);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setResizable(false);


        JPanel bgPanel = new GradientPanel();
        bgPanel.setLayout(new BoxLayout(bgPanel, BoxLayout.Y_AXIS));
        bgPanel.setBorder(BorderFactory.createEmptyBorder(30, 20, 20, 20));


        timeLabel = new JLabel();
        timeLabel.setFont(new Font("Segoe UI", Font.BOLD, 50));
        timeLabel.setForeground(Color.WHITE);
        timeLabel.setAlignmentX(Component.CENTER_ALIGNMENT);


        dayLabel = new JLabel();
        dayLabel.setFont(new Font("Segoe UI", Font.PLAIN, 28));
        dayLabel.setForeground(new Color(230, 230, 230));
        dayLabel.setAlignmentX(Component.CENTER_ALIGNMENT);


        dateLabel = new JLabel();
        dateLabel.setFont(new Font("Segoe UI", Font.PLAIN, 24));
        dateLabel.setForeground(new Color(220, 220, 220));
        dateLabel.setAlignmentX(Component.CENTER_ALIGNMENT);


        bgPanel.add(timeLabel);
        bgPanel.add(Box.createVerticalStrut(10));
        bgPanel.add(dayLabel);
        bgPanel.add(Box.createVerticalStrut(5));
        bgPanel.add(dateLabel);

        add(bgPanel);
        setVisible(true);

        startClock();
    }


    private void startClock() {
        Timer timer = new Timer(1000, e -> updateClock());
        timer.start();
        updateClock();
    }

    private void updateClock() {
        Calendar now = Calendar.getInstance();

        timeLabel.setText(timeFormat.format(now.getTime()));
        dayLabel.setText(dayFormat.format(now.getTime()));
        dateLabel.setText(dateFormat.format(now.getTime()));
    }
}



class GradientPanel extends JPanel {

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);

        Graphics2D g2 = (Graphics2D) g;
        GradientPaint gp = new GradientPaint(
                0, 0, new Color(52, 73, 94),
                getWidth(), getHeight(), new Color(41, 128, 185)
        );

        g2.setPaint(gp);
        g2.fillRect(0, 0, getWidth(), getHeight());
    }
}
