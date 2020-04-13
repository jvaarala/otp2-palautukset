package memento;

public class Arvuuttaja {

    public Arvuuttaja() {
    }

    public Object liityPeliin(Asiakas asiakas) {
        return new Memento((int) (1+Math.random() * 10), asiakas);
    }

    public void arvaa(Object memento, int arvaus) {
        Memento m = (Memento) memento;
        if(m.MYSTEERILUKU == arvaus) {
            m.ASIAKAS.setOikeinArvattu(false);
            System.out.println(m.ASIAKAS + " arvasi oikein." + m.MYSTEERILUKU + "==" + arvaus);
        }
    }
}

class Memento {
    final int MYSTEERILUKU;
    final Asiakas ASIAKAS;

    Memento(int mysteeriluku, Asiakas asiakas) {
        this.MYSTEERILUKU = mysteeriluku;
        this.ASIAKAS = asiakas;
    }
}