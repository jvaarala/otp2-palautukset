package abstractfactory;

public class Main {
    /*
    2.	Abstract Factory: Jasper Java-koodaaja on koko opiskeluaikansa pukeutunut Adidas-merkkisiin
    vaatteisiin lippis ja kengät mukaan lukien. Kirjoita ohjelma, jossa Jasper pukee päällensä farmarit, t-paidan,
    lippiksen ja kengät. Tämän jälkeen Jasper luettelee ylpeänä, mitä hänellä on päällään
    (vaatekappaleet osaavat toString-metodeissaan kertoa kaiken oleellisen itsestään).

    Valmistuttuaan insinööriksi Jasper siirtyy käyttämään yksinomaan Boss-tuotteita ja osaa edelleen kertoa,
    mitä hänellä on päällään.

    Koodaa ohjelma siten, että Jasperiin ei tarvitse tehdä juuri muutoksia Adidas->Boss siirtymän takia,
    vaan ainoa muutos on tuoteperheen (tehtaan) vaihto.

    Bonus: Hyödynnä Java Reflection APIa tehtaan luonnissa.
    Tästä yksi piste lisää, jos palautus ajoissa. Myöhästyneitä palautuksia ei huomioida.
    Annetaan tehtäväksi myöhemmin.

 */
    public static void main(String[] args) {

        char select;
        boolean jasperOnInsinoori = false;
        IVaateFactory vaatevalinta = new Adidas();

        do {
            System.out.println("\n\t\t\tJoko Jasperi on insinööri?");
            System.out.println("\t\t\t0. Ei");
            System.out.println("\t\t\t1. Kyllä");
            System.out.print("\n\n");

            select = Lue.merkki();

            switch (select) {
                case '0':
                    System.out.println(".... kaikki aikanaan.\n");
                    break;
                case '1':
                    System.out.println(".... hienoa.\n");
                    vaatevalinta = new Boss();
                    jasperOnInsinoori = true;
                    break;
            }

            IFarmarit farmarit = vaatevalinta.pueFarmarit();
            IKengat kengat = vaatevalinta.pueKengat();
            ILippis lippis = vaatevalinta.pueLippis();
            ITPaita tpaita = vaatevalinta.pueTPaita();


            System.out.println("Jasperilla on päällä:\n" + farmarit + "\n" + kengat + "\n" + lippis + "\n" + tpaita + "\n");

        }
        while (!jasperOnInsinoori);
    }
}
