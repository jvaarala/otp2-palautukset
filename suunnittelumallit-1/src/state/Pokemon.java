package state;

public class Pokemon {
    private State state;

    public Pokemon() {
        this.state = new Charmander(this);
    }

    public void changeState(State state) {
        this.state = state;
    }

    public void evolve() {
        this.state.onEvolve();
    }

    public void attack() {
        this.state.onAttack();
    }
}
