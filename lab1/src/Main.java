public class Main {
    public static void main(String args[]){
        Osoba[] osoby = new Osoba[11];

        //Polimorfizm
        for (int i = 0; i < 10; i++) {
            if(i<5) osoby[i] = new Pracownik("Imie","Nazwisko",i*2+23);
            else osoby[i] = new Pracownik("Name","Surname");
        }
        osoby[10] = new Osoba("osoba","nazwisko");

        //polimorfizm inkluzyjny
        System.out.println("Wyswietlam osoby: ");
        for (int i = 0; i < 11; i++) {
            System.out.print(osoby[i]);
        }

        //Polimorfizm parametryczny
        Grupa<Osoba> grupa = new Grupa<>(osoby);
        grupa.wyswietlOsoby();
    }
}
