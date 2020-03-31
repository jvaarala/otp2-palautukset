package decorator;

import com.sun.xml.internal.ws.api.model.wsdl.WSDLOutput;

import java.util.ArrayList;

public class ArrayAuthDecorator {

    private ArrayList<Integer> arrayList;
    String salasana;
    String tietokannastaHaettuHashattuSalasana = "salasana";

    public ArrayAuthDecorator() {
        arrayList = new ArrayList<>();
    }

    public void add(Integer data) {
        System.out.println("Anna salasana ja paina ENTER");
        salasana = Lue.rivi();
        if (salasana.equals(tietokannastaHaettuHashattuSalasana)) {
            arrayList.add(data);
            System.out.println("Lisätty: " + data);
        } else {
            System.out.println("Ei hyväksytty salasana");
        }
    }

    public void delete(Integer index) {
        System.out.println("Anna salasana ja paina ENTER");
        salasana = Lue.rivi();
        if (salasana.equals(tietokannastaHaettuHashattuSalasana)) {
            arrayList.remove(index);
            System.out.println("Poistettu tietue indeksistä: " + index);
        } else {
            System.out.println("Ei hyväksytty salasana");
        }
    }

    public ArrayList get() {
        return arrayList;
    }
}
