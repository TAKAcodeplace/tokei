import javax.swing.*;
import java.awt.*;
import java.util.Observable;
import java.util.Observer;

public class ClockView implements Observer {
    private JFrame frame;
    private JLabel timeLabel;

    public ClockView() {
        timeLabel = new JLabel("", SwingConstants.CENTER);
        timeLabel.setFont(new Font("Arial", Font.PLAIN, 36));

        frame = new JFrame("Analog Clock");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(300, 200);
        frame.add(timeLabel, BorderLayout.CENTER);
    }

    public void createAndShowGUI(ClockController controller) {
        frame.addWindowListener(controller);
        frame.setVisible(true);
    }

    @Override
    public void update(Observable o, Object arg) {
        if (o instanceof ClockModel) {
            String currentTime = (String) arg;
            SwingUtilities.invokeLater(() -> timeLabel.setText(currentTime));
        }
    }
}
