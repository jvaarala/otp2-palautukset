package observer;

import java.text.DecimalFormat;

public class DigitalClock implements Observer {

    private ClockTimer timer;

    public DigitalClock(ClockTimer ct) {
        timer = ct;
        timer.attach(this);
        timer.tick();
    }
    @Override
    public void update(Subject changedSubject) {
        if (changedSubject.equals(timer)) {
            draw();
        }
    }

    private void draw() {
        DecimalFormat df = new DecimalFormat("000");
        System.out.println(timer.getSecond()+"."+df.format(timer.getThousands()));
    }
}
