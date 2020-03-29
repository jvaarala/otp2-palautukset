package iterator;

/**
 * @author kamaj / jessevaa
 */
class ListItem {
    private String data;
    private ListItem next;

    ListItem() {
        next = null;
    }

    ListItem(String data) {
        next = null;
        this.data = data;
    }

    String getData() {
        return data;
    }

    void setData(String data) {
        this.data = data;
    }

    ListItem getNext() {
        return next;
    }

    void setNext(ListItem next) {
        this.next = next;
    }


}
