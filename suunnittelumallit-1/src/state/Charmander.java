package state;

public class Charmander extends State {

    Charmander(Pokemon pokemon) {
        super(pokemon);
    }

    @Override
    public void onAttack() {
        System.out.println("Charmander attacks!");
    }

    @Override
    public void onEvolve() {
        pokemon.changeState(new Charmaleon(pokemon));
        System.out.println("Charmander evolved to Charmaleon!");
    }
}
