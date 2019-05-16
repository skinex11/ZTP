package Pizza;

import Decorator.CheeseDecorator;
import Decorator.OliveDecorator;

public class Main {
    public static void main(String args[]){
        Pizza wloska = new Wloska("Margarita");
        Pizza polska = new Polska("Krakowska");

        System.out.println("Dekoratory:");

        System.out.println(wloska.toString());
        wloska = new OliveDecorator(wloska);
        System.out.println(wloska.toString());

        System.out.println(polska.toString());
        polska = new CheeseDecorator(polska);
        System.out.println(polska);

        System.out.println("Stany:");
        System.out.println(wloska.toString()+". Stan: "+wloska.showState());
        wloska.changeState();
        System.out.println(wloska.toString()+". Stan: "+wloska.showState());

        System.out.println("Ale klient stwierdził, że trzeba jeszcze dopiec ją");
        wloska.changeState();
        System.out.println(wloska.toString()+". Stan: "+wloska.showState());
    }
}
