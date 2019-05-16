package Pizza;

import State.State;

public abstract class Pizza {
    public String name;
    private State state;

    public abstract double getPrice();

    @Override
    public String toString() {
        return "Pizza"+
                name+
                ", Cena: "+
                getPrice();
    }

    public void setState(State state) {
        this.state = state;
    }
}
