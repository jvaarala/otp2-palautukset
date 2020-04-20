package adapter;

public class Main {
    public static void main(String[] args) {

        // Ohjelma on tehty alunperin euroopan markkinoille,
        // mutta adapterin avulla tuotteiden hinnat voidaan näyttää dollareina.

        Tuote mersu = new Auto();
        TuoteHintaAdapteri bugattiVeyronAdapter = new TuoteHintaAdapteriImpl(mersu);

        System.out.println(bugattiVeyronAdapter.haeHinta());
    }
}

interface Tuote {
    // hinta EUR
    double haeHinta();
}

class Auto implements Tuote {

    @Override
    public double haeHinta() {
        return 10000;
    }
}

interface TuoteHintaAdapteri {
    // hinta USD
    double haeHinta();
}

class TuoteHintaAdapteriImpl implements TuoteHintaAdapteri {
    private Tuote tuote;

    public TuoteHintaAdapteriImpl(Tuote tuote) {
        this.tuote = tuote;
    }

    @Override
    public double haeHinta() {
        return muunnaHintaDollareiksi(tuote.haeHinta());
    }

    private double muunnaHintaDollareiksi(double eur) {
        return eur * 1.09;
    }
}

