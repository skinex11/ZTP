//Dziedziczenie
public class Pracownik extends Osoba {
    int wiek;

    //polimorfizm
    public Pracownik(String name, String surname, int wiek) {
        super(name, surname);
        this.wiek = wiek;
    }

    //przeciążanie
    public Pracownik(String name, String surname){
        super(name, surname);
        this.wiek = 100;
    }

    //polimorfizm inkluzyjny
    @Override
    public String toString() {
        return "Pracownik{" +
                "Numer: " + wiek +
                ", Imie: '" + name + '\'' +
                ", Nazwisko: '" + surname + '\'' +
                '}'+'\n';
    }
}
