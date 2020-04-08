package strategy;

import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        List<String> list = new ArrayList<>();

        list.add("A");
        list.add("B");
        list.add("C");
        list.add("D");
        list.add("F");
        list.add("G");
        list.add("H");
        list.add("I");
        list.add("J");
        list.add("K");
        list.add("L");
        list.add("M");


        ListHandler listHandler = new ListHandler(new OneItemPerLine());
        System.out.println(listHandler.convertedListToString(list));


        listHandler.setListConverter(new TwoItemsPerLine());
        System.out.println(listHandler.convertedListToString(list));


        listHandler.setListConverter(new ThreeItemsPerLine());
        System.out.println(listHandler.convertedListToString(list));

    }
}
