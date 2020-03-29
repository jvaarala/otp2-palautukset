package iterator;

/**
 * @author jessevaa
 */
class Queue {


    private ListItem front = null;
    private ListItem back = null;
    private int size = 0;

    private boolean isEmpty() {
        return front == null;
    }


    void push(String aData) {
        if (isEmpty()) {
            back = front = new ListItem(aData);
        } else {
            ListItem i = new ListItem(aData);
            back.setNext(i);
            back = i;
        }
        size++;
    }

    public QueueIterator iterator() {
        return new QueueIterator(this);
    }

    ListItem pop() {
        if (isEmpty()) return null;
        ListItem r = front;
        front = front.getNext();
        size--;
        return r;
    }

    void printItems() {
        ListItem helper = front;
        for(int i = 0; i < size; i++) {
            System.out.println(helper.getData());
            helper = helper.getNext();
        }
    }

    int getSize() {
        return size;
    }

    public ListItem getFront() {
        return front;
    }
}
