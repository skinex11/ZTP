package Pizza;

import State.*;

public abstract class Pizza {
    public String name;
    private State state;

    public abstract double getPrice();

    public Pizza(String name){
        this.name = name;
        state = new MakingState();
    }

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

    public String showState() {
        return state.getState();
    }

    public void changeState() {
        state = new ReadyState();
    }
}
