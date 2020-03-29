package iterator;

import javafx.scene.control.ListCell;

import java.util.Iterator;

public class QueueIterator implements Iterator {

    private ListItem current;
    private Queue container;

    QueueIterator (Queue c) {
        container = c;
        current = container.getFront();
    }

    @Override
    public boolean hasNext() {
        return current != null;
    }

    @Override
    public ListItem next() {
        ListItem oldCurrent = current;
        current = current.getNext();
        return oldCurrent;
    }
}