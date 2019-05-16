package Pizza;

public class Wloska extends Pizza {
    public Wloska(String name) {
        this.name = name;
    }

    @Override
    public double getPrice() {
        return 10.5;
    }
}
