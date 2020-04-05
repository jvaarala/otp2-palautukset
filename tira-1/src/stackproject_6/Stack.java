package stackproject_6;

import java.util.Iterator;
import java.util.LinkedList;

/**
 *
 * @author kamaj
 */
public class Stack {

    private LinkedList<String> list;
    public Stack() {
        list = new LinkedList<String>();
    }
    
    // muodosta uusi lista-alkio ja vie se pinon huipulle
    public void push(String aData){
        list.add(aData);
    }
    // poista ja palauta alkio pinon huipulta, 
    // jos pino tyhjä palauta null
    public String pop(){
        if (list.size() > 0) return list.removeLast(); else return null;
    }
    // tulosta pinon sisältö muuttamatta pinoa
    public void printItems() {
        Iterator iterator = list.descendingIterator();
        while(iterator.hasNext()) {
            System.out.println(iterator.next());
        }
    }

    public int getSize() {
        return list.size();
    }
    
}
