public class Main {
    public static void main(String[] args) {
        ClockModel model = new ClockModel();
        ClockView view = new ClockView();
        ClockController controller = new ClockController(model, view);

        model.addObserver(view);
        Thread clockThread = new Thread(model);
        clockThread.start();

        view.createAndShowGUI(controller);
    }
}
