package observer;

import javax.security.auth.Subject;
import java.util.AbstractMap;

public abstract class ChangeManager {
    public abstract void register();
    public abstract void unregister();
    public abstract void notifyFunc();

    public AbstractMap<Observer, Subject[]> observerSubjectMapping;
}
