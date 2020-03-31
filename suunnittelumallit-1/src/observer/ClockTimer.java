package observer;


import java.text.DecimalFormat;
import java.util.Timer;
import java.util.TimerTask;

public class ClockTimer extends Subject {


    private int counter;

    public int getSecond() {
        return (counter / 1000)%60;
    }

    public int getThousands() {
        return counter%1000;
    }


    public void tick() {
        TimerTask timerTask = new TimerTask() {
            @Override
            public void run() {
                counter++;
                notifyObservers();
            }
        };
        Timer timer = new Timer();
        timer.scheduleAtFixedRate(timerTask, 10, 1);
    };
}
