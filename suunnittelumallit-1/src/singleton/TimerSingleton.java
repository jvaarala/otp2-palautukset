package singleton;

import java.text.DecimalFormat;
import java.util.ArrayList;

public class TimerSingleton {


    private TimerSingleton() {
    }

    private static TimerSingleton INSTANCE = new TimerSingleton();

    static TimerSingleton getINSTANCE() {
        return INSTANCE;
    }

    private DecimalFormat secondsFormat = new DecimalFormat("00");
    private DecimalFormat thousandsFormat = new DecimalFormat("000");
    private long nanotimeStart;

    public void reset() {
        nanotimeStart = System.nanoTime();
    }

    public long getNanotime() {
        return System.nanoTime() - nanotimeStart;
    }


    public String formatNanotime(long nt) {
        long thousands = (nt / 1000000) % 1000;
        long seconds = nt / 1000000000;
        return String.format("%s:%s", secondsFormat.format(seconds), thousandsFormat.format(thousands));
    }

    public String getFormattedTime() {
        long nt = getNanotime();
        return (formatNanotime(nt));
    }


}
