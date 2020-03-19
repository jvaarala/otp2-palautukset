package stackproject;


/**
 * @author jessevaa
 */
class Queue {
    private ListItem front = null;
    private ListItem back = null;

    private boolean isEmpty() {
        return front == null && back == null;
    }

    void push(String aData) {
        if (isEmpty()) {
            back = front = new ListItem(aData);
        } else {
            ListItem i = new ListItem(aData);
            back.setNext(i);
            back = back.getNext();
        }

    }

    ListItem pop() {
        ListItem cp = front;
        if (!isEmpty()) {
            assert front != null;
            front = front.getNext();
        }
        return cp;
    }

    void printItems() {
        ListItem helper = front;
        if (front != null) {
            do {
                System.out.println(helper.getData());
                helper = helper.getNext();
            } while (helper != null);
        } else {
            System.out.println("Pino on tyhjä!");
        }
    }

    int getSize() {
        int counter = 0;
        ListItem helper = front;
        if (front != null) {
            do {
                helper = helper.getNext();
                counter++;
            } while (helper != null);
        }

        return counter;
    }
}
