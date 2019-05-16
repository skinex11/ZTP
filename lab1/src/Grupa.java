//polimorfizm parametryczny z ograniczem | klasa generyczna
// klasa grupa przyjmuje Pracownik i Osoba (nie przyjmie Obiekt)
public class Grupa<T extends Osoba> {
    T[] czlonkowie;

    public Grupa(T[] czlonkowie) {
        this.czlonkowie = czlonkowie;
    }

    public void wyswietlOsoby(){
        System.out.println("\n\n\nOsoby z wybranej grupy:");
        for (int i = 0; i < czlonkowie.length; i++) {
            System.out.print(czlonkowie[i].toString());
        }
    }

    @Override
    public String toString(){
        String result = "";
        for(int i=0; i <this.czlonkowie.length; i++){
            result += " | " + this.czlonkowie[i].toString();
        }
        return  result;
    }
}
