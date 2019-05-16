public class Plant {
    private String name;

    public Plant(String name) {
        name = name;
    }

    public String getname() {
        return name;
    }

    public void setname(String name) {
        name = name;
    }

    public void water(){
        System.out.println("Twoja roslina zostala podlana!");
    }
}
