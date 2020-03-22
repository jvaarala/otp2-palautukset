package composite;

import java.util.ArrayList;
import java.util.List;

public class Emolevy implements Laiteosa {
    double hinta = 1;
    List<Laiteosa> laiteosaLista = new ArrayList<Laiteosa>();
    
    @Override
    public double haeHinta() {
        double lapsienHinta = 0;
        for (Laiteosa osa : laiteosaLista) {
            lapsienHinta = lapsienHinta + osa.haeHinta();
        }

        return hinta + lapsienHinta;
    }

    @Override
    public void lisaaOsa(Laiteosa lisattavaLaiteosa) {
        laiteosaLista.add(lisattavaLaiteosa);
    }
}
