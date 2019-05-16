package State;

import Pizza.Pizza;

public class ReadyState extends State {
    @Override
    public void changeState(Pizza pizza) {
        pizza.setState(new MakingState()); //pizza jest niedopieczona :)
    }

    @Override
    public String getState() {
        return "Pizza gotowa!";
    }
}
