import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

public class ClockController extends WindowAdapter {
    private ClockModel model;
    private ClockView view;

    public ClockController(ClockModel model, ClockView view) {
        this.model = model;
        this.view = view;
    }

    @Override
    public void windowClosing(WindowEvent e) {
        model.stopClock();
    }
}
