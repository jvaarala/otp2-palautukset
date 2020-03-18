/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package stackproject;

/**
 *
 * @author kamaj
 */
public class Stack {
    
    private ListItem top = null;
    private int size = 0;

    // muodosta uusi lista-alkio ja vie se pinon huipulle
    public void push(String aData){
        ListItem item = new ListItem();
        item.setData(aData);
        item.setNext(top);
        top = item;
        size = size+1;
    }
    // poista ja palauta alkio pinon huipulta, 
    // jos pino tyhjä palauta null
    public ListItem pop(){
        if (size >= 1) {
            ListItem deleted = top;
            top = top.getNext();
            size = size-1;
            return deleted;
        } else {
            return null;
        }
    }

    // tulosta pinon sisältö muuttamatta pinoa
    public void printItems() {
        ListItem helper = top;
        if (top != null) {
            do {
                System.out.println(helper.getData());
                helper = helper.getNext();
            } while (helper != null);
        } else {
            System.out.println("Pino on tyhjä!");
        }
    }

    public int getSize() {
        return size;
    }
    
}
