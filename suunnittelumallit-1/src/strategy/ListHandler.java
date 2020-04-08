package strategy;

import java.util.List;

public class ListHandler {

    public ListConverter getListConverter() {
        return listConverter;
    }

    public void setListConverter(ListConverter listConverter) {
        this.listConverter = listConverter;
    }

    private ListConverter listConverter;

    public ListHandler(ListConverter listConverter) {
        this.listConverter = listConverter;
    }

    public String convertedListToString(List list) {
        return this.listConverter.listToString(list);
    }
}
