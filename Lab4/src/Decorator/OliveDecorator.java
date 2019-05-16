package Decorator;

import Pizza.Pizza;

public class OliveDecorator extends PizzaDecorator {
    public OliveDecorator(Pizza pizza) {
        super(pizza);
    }

    public double getPrice(){
        return super.getPrice()+2;
    }

    @Override
    public String toString() {
        return "Pizza"+
                super.name+
                " z dodatkowymi oliwkami,"+
                " Cena: "+
                getPrice();
    }
}
