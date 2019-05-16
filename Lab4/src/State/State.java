package State;

import Pizza.Pizza;

public abstract class State {
    public abstract void changeState(Pizza pizza);
    public abstract String getState();
}
