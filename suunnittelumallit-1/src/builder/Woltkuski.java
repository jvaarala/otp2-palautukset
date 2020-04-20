package builder;

public class Woltkuski {
    private BurgerBuilder burgerBuilder;

    public void asetaBurgerBuilder(BurgerBuilder bb) {
        burgerBuilder = bb;
    }

    public Burger tuoBurger() {
        return burgerBuilder.haeBurger();
    }

    public void rakennaBurger() {
        burgerBuilder.teeUusiBurger();
        burgerBuilder.rakennaSampyla();
        burgerBuilder.rakennaPihvi();
        burgerBuilder.rakennaMuutTaytteet();
    }
}
