package state;

public class Charizard extends State {
    public Charizard(Pokemon pokemon) {
        super(pokemon);
    }

    @Override
    public void onAttack() {
        System.out.println("Charizard attacks! Scent of vaporized pokemon slowly fill the air..");
    }

    @Override
    public void onEvolve() {
    }

    @Override
    public void accept(ExperienceVisitor experienceVisitor) {
        experienceVisitor.visit(this);
    }
}
