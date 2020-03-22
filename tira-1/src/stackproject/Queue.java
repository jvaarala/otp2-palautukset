package stackproject;

/**
 * @author jessevaa
 */
class Queue {
    private ListItem front = null;
    private ListItem back = null;

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

    }

    ListItem pop() {
        if (isEmpty()) return null;
        ListItem r = front;
        front = front.getNext();
        return r;
    }

    void printItems() {
        ListItem helper = front;
        if (front != null) {
            do {
                System.out.println(helper.getData());
                helper = helper.getNext();
            } while (helper != null);
        } else {
            System.out.println("Ei alkioita!");
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
