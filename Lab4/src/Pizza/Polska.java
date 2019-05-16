package Pizza;

public class Polska extends Pizza {
    public Polska(String name) {
        this.name = name;
    }

    @Override
    public double getPrice() {
        return 12.5;
    }
}
