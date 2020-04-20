package builder;

public class ConcreteBurgerBuilders {

    static class Hesburger extends BurgerBuilder {
        @Override
        public void rakennaSampyla() {
            burger.asetaSampyla("hesen sämpylä");
        }

        @Override
        public void rakennaPihvi() {
            burger.asetaPihvi("hesen pihvi");
        }

        @Override
        public void rakennaMuutTaytteet() {
            burger.asetaMuutTaytteet("hesen kastike");
        }
    }


    static class McDonalds extends BurgerBuilder {

        @Override
        public void rakennaSampyla() {
            burger.asetaSampyla("mäkkärin sämpylä");
        }

        @Override
        public void rakennaPihvi() {
            burger.asetaPihvi("mäkkärin pihvi");
        }

        @Override
        public void rakennaMuutTaytteet() {
            burger.asetaMuutTaytteet("mäkkärin ketsuppi");
        }
    }
}
