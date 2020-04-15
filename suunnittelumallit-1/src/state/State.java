package state;

public abstract class State {
    Pokemon pokemon;

    State(Pokemon pokemon) {
        this.pokemon = pokemon;
    }
    public abstract void onAttack();

    public abstract void onEvolve();

    public abstract void accept(ExperienceVisitor experienceVisitor);
}
