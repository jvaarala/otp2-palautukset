package strategy;

import java.util.Iterator;
import java.util.List;

public interface ListConverter {
    public String listToString(List list);
}

class OneItemPerLine implements ListConverter {

    @Override
    public String listToString(List list) {
        String stringToPrint = "";
        Iterator iterator = list.iterator();
        while(iterator.hasNext()) {
            stringToPrint += iterator.next() + "\n";
        }
        return stringToPrint;
    }
}

class TwoItemsPerLine implements ListConverter {

    @Override
    public String listToString(List list) {
        Object[] listAsArray = list.toArray();
        String stringToPrint = "";
        for (int i = 0; i < listAsArray.length; i++) {
            Object element = listAsArray[i];
            stringToPrint += element;
            if ((i+1) % 2 == 0) stringToPrint += "\n";
        }
        return stringToPrint;
    }
}

class ThreeItemsPerLine implements ListConverter {

    @Override
    public String listToString(List list) {
        String stringToPrint = "";
        for (int i = 0; i < list.size(); i++) {
           stringToPrint += list.get(i);
           if ((i+1) % 3 == 0) stringToPrint += "\n";
        }
        return stringToPrint;
    }
}
