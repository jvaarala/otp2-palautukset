package builder;

abstract class BurgerBuilder {
    protected Burger burger;
    public Burger haeBurger() { return burger; }
    public void teeUusiBurger() { this.burger = new Burger(); }

    public abstract void rakennaSampyla();
    public abstract void rakennaPihvi();
    public abstract void rakennaMuutTaytteet();
}
