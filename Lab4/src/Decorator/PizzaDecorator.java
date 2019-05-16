package Decorator;

import Pizza.Pizza;

public class PizzaDecorator extends Pizza {
    protected Pizza pizza;

    public PizzaDecorator(Pizza pizza){
        super(pizza.name);
        this.pizza = pizza;
    }

    @Override
    public double getPrice() {
        return pizza.getPrice();
    }

    @Override
    public String toString(){
        return pizza.toString();
    }
}
