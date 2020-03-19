/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package stackproject;

/**
 * @author kamaj
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
