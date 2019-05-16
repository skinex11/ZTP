package State;

import Pizza.Pizza;

public class MakingState extends State {
    @Override
    public void changeState(Pizza pizza) {
        pizza.setState(new ReadyState());
    }

    @Override
    public String getState() {
        return "Piecze się...";
    }
}
