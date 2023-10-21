package cz.itnetwork;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
/*
- v konstruktoru třídy se vytvoří seznam pojištěných - ti jsou uloženi v třídě Pojisteny
- přidal jsem ještě načítání/ukládání objektů typu Pojisteny ze/do souboru
- v konstruktoru proběhne i hlavní cyklus, po ukončení se ještě uloží list pojištěných do souboru
- vyhledávání pomocí streamu a překryté metody Pojisteny.equals() (pro větší kolekce vhodnější Arrays.binarySearch)
- při přidávání nového pojištěného zadané řetězce kontroluje třída Validator (hned na vstupu)
 */
public class Evidence {
    private Scanner scanner;
    ArrayList<Pojisteny> pojisteni; // seznam všech záznamů pojištěných
    public Evidence() {
        System.out.println("---------------------------------------------------------");
        System.out.println("   Evidence pojištěných");
        System.out.println("---------------------------------------------------------\n");

        Soubor soubor = new Soubor();
        pojisteni = soubor.nactiPojistene();//seznam vytvoří třída Soubor, ať už soubor existuje a je neprázdný nebo ne
        scanner = new Scanner(System.in);

        // hlavní cyklus
        boolean pokracovat=true;
        while(pokracovat){
            vypisMenu();
            String vstup = scanner.nextLine();//konzole čeká na vstup
            // je-li zadáno číslo 1 - 4 provede příslušnou akci, jinak zpět na začátek cyklu
            //na nový výpis možných voleb a vstup
            switch (vstup){
                case "1":
                    pridejPojisteneho();break;
                case "2":
                    vypisPojistene(pojisteni);break;
                case "3":
                    vyhledat();break;
                case "4":
                    pokracovat = false;break;
            }
        }
        soubor.ulozPojistene(pojisteni);
    }
    private void pridejPojisteneho(){
        String jmeno;
        String prijmeni;
        int vek;
        String telefon;

        jmeno = Validator.text(2,15,"Zadejte jmeno pojisteneho:");
        prijmeni = Validator.text(2,15, "Zadejte příjmení pojisteneho:");
        vek = Integer.parseInt(Validator.cislo(1,2, "Zadejte věk:"));
        telefon = Validator.cislo(9, 9, "Zadejte telefonní číslo - 9 číslic bez mezer:");
        telefon = String.format("+420 %s %s %s",telefon.substring(0,3),telefon.substring(3,6),telefon.substring(6,9));
        pojisteni.add(new Pojisteny(jmeno, prijmeni, vek, telefon));
    }
    private void vypisPojistene(List<Pojisteny> list){
        for (Pojisteny p: list) System.out.println(p.toString());
    }
    private void vyhledat(){
        System.out.println("Zadej hledané křestní jmémo:");
        String jmeno = scanner.nextLine();
        System.out.println("Zadej hledané příjmení:");
        String prijmeni = scanner.nextLine();

        List<Pojisteny> hledane = pojisteni.stream().filter(x->x.equals(jmeno+prijmeni)).toList();
        vypisPojistene(hledane);
    }
    private void vypisMenu(){
        System.out.println("\nVyberte si akci:\n1 - Přidat nového pojištěného\n2 - Vypsat všechny pojištěné\n3 - Vyhledat pojištěného\n4 - Konec");
    }
}
