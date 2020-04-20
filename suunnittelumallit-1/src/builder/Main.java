package builder;

public class Main {
    public static void main(String[] args) {
        Woltkuski waltteri = new Woltkuski();
        BurgerBuilder hesburger = new ConcreteBurgerBuilders.Hesburger();
        BurgerBuilder mcdonalds = new ConcreteBurgerBuilders.McDonalds();
        waltteri.asetaBurgerBuilder(hesburger);
        waltteri.rakennaBurger();

        Burger burger = waltteri.tuoBurger();
        System.out.println(burger.toString());

        waltteri.asetaBurgerBuilder(mcdonalds);
        waltteri.rakennaBurger();

        burger = waltteri.tuoBurger();
        System.out.println(burger.toString());
    }

}
