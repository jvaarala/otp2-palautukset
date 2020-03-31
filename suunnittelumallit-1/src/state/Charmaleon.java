package state;

public class Charmaleon extends State {
    public Charmaleon(Pokemon pokemon) {
        super(pokemon);
    }

    @Override
    public void onAttack() {
        System.out.println("Charmaleon attacks!");
    }

    @Override
    public void onEvolve() {
        pokemon.changeState(new Charizard(pokemon));
        System.out.println("Charmaleon evolved to Charizard!");
    }
}
