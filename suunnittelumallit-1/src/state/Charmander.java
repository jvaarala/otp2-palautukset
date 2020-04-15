package state;

public class Charmander extends State {

    public Charmander(Pokemon pokemon) {
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

    @Override
    public void accept(ExperienceVisitor experienceVisitor) {
        experienceVisitor.visit(this);
    }
}
