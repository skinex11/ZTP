package Decorator;

import Pizza.Pizza;

public class OliveDecorator extends PizzaDecorator {
    public OliveDecorator(Pizza pizza) {
        super(pizza);
        name = pizza.name;
    }

    public double getPrice(){
        return super.getPrice()+2;
    }

    @Override
    public String toString() {
        return "Pizza "+
                name+
                " z dodatkowymi oliwkami,"+
                " Cena: "+
                getPrice();
    }
}
