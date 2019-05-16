package Pizza;

public class Wloska extends Pizza {
    public Wloska(String name) {
        super(name);
    }

    @Override
    public double getPrice() {
        return 10.5;
    }
}
