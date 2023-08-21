import java.util.Calendar;
import java.util.Observable;

public class ClockModel extends Observable implements Runnable {
    private boolean isRunning;

    public ClockModel() {
        isRunning = true;
    }

    @Override
    public void run() {
        while (isRunning) {
            try {
                Thread.sleep(1000); // 1秒ごとに更新
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            setChanged();
            notifyObservers(getCurrentTime());
        }
    }

    public void stopClock() {
        isRunning = false;
    }

    private String getCurrentTime() {
        // 現在の時刻を取得して文字列に変換する処理
        Calendar calendar = Calendar.getInstance();
        int hour = calendar.get(Calendar.HOUR_OF_DAY);
        int minute = calendar.get(Calendar.MINUTE);
        int second = calendar.get(Calendar.SECOND);
        return String.format("%02d:%02d:%02d", hour, minute, second);
    }
}
