package observer;

import java.util.HashSet;
import java.util.Set;

public abstract class Subject {
    Set<Observer> observerSet = new HashSet<Observer>();

    public void attach(Observer o) {
        observerSet.add(o);
    }

    public void detach(Observer o) {
        observerSet.remove(o);
    }

    protected void notifyObservers() {
        for (Observer o : observerSet) {
            o.update(this);
        }
    }
}
