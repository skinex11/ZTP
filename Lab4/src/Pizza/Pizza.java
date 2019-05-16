package Pizza;

public abstract class Pizza {
    protected String name;

    public abstract double getPrice();

    @Override
    public String toString() {
        return "Pizza"+
                name+
                ", Cena: "+
                getPrice();
    }
}
