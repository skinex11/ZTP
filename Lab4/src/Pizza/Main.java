package Pizza;

import Decorator.OliveDecorator;

public class Main {
    public static void main(String args[]){
        Pizza wloska = new Wloska("Margarita");
        Pizza polska = new Polska("Krakowska");

        System.out.println(wloska.toString());
        wloska = new OliveDecorator(wloska);
        System.out.println(wloska.toString());
    }
}
