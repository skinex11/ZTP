package Pizza;

public abstract class Pizza {
    String name;

    public abstract double getPrice();

    @Override
    public String toString() {
        return "Pizza"+
                name+
                ", Cena: "+
                getPrice();
    }
}
