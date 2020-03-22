package composite;

public class Main {
    public static void main(String[] args) {

        Laiteosa emolevy = new Emolevy();
        emolevy.lisaaOsa(new Prosessori());
        emolevy.lisaaOsa(new Muistipiiri());
        emolevy.lisaaOsa(new Naytonohjain());
        emolevy.lisaaOsa(new Verkkokortti());

        Laiteosa kotelo = new Kotelo();
        kotelo.lisaaOsa(emolevy);
        kotelo.lisaaOsa(new Levyasema());
        kotelo.lisaaOsa(new Tuuletin());

        System.out.println(kotelo.haeHinta());
        System.out.println(emolevy.haeHinta());
    }
}
