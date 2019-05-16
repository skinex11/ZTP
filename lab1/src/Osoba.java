public class Osoba {
    String name, surname;

    public Osoba(String name, String surname) {
        this.name = name;
        this.surname = surname;
    }

    //polimorfizm inkluzyjny
    @Override
    public String toString() {
        return "Osoba{" +
                "Imie: '" + name + '\'' +
                ", Nazwisko: '" + surname + '\'' +
                '}';
    }
}
