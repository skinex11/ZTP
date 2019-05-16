package Decorator;

import Pizza.Pizza;

public class CheeseDecorator extends PizzaDecorator {
    public CheeseDecorator(Pizza pizza) {
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
                " z dodatkowym serem,"+
                " Cena: "+
                getPrice();
    }
}
