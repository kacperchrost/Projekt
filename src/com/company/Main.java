package com.company;

import java.util.Scanner;
/**
 *
 * @author Dawid Pieciul, Kacper Chrost, Bartłomiej Busłowki
 * @throws Exception jezeli nie zostanie odnaleziony szukany plik lub index
 * Klasa Main programu. Pozwala na obsługę programu przez użytkownika.
 */

public class Main {
    /**
     *
     * @param args pobiera argumenty z wiersza poleceń
     * @throws Exception wyrzuca oraz obsługuje wyjątki związane z błędami plików oraz spowodowane przez użytkownika
     */
    public static void main(String[] args) throws Exception {
        Scanner scan = new Scanner(System.in);
        Sedzia sedzia = new Sedzia();
        sedzia.wczytajZPlikuS();
        String opcje;
        while (true)
        {
            System.out.println("______________________________");
            System.out.println("[1]Plazownie");
            System.out.println("[2]Turniej");
            System.out.println("[3]Wypisz ostatni turniej");
            System.out.println("[4]Tabela wynikow ostatnich turnieji");
            System.out.println("[5]Sedziowie");
            System.out.println("[0]Wyjscie");
            System.out.println("______________________________");
            opcje = scan.nextLine();
            switch(opcje)
            {
                case "1":
                    System.out.println("Milego dnia.");
                    Plazownie czill = new Plazownie();
                    czill.plazuj();
                    break;
                case "2":
                    int n;
                    do
                    {
                    System.out.println("______________________________");
                    System.out.println("Wybierz dyscypline.");
                    System.out.println("[1]Siatkowka.");
                    System.out.println("[2]Przeciąganie liny.");
                    System.out.println("[3]Dwa ognie.");
                    System.out.println("______________________________");
                    opcje = scan.nextLine();
                        n=1;
                        switch(opcje)
                        {
                            case "1":
                                Siatkowka siatkowka = new Siatkowka();
                                Zawody turniej1 = new Zawody("Siatkowka");
                                WynikiSpotkan wyniki1 = new WynikiSpotkan("Siatkowka");
                                turniej1.dodajTurniej(turniej1);
                                siatkowka.dodajSedziegoPomocniczego(sedzia, wyniki1);
                                rozgrywka(turniej1, wyniki1, sedzia);
                                break;
                            case "2":
                                PrzeciaganieLiny przeciaganieLiny = new PrzeciaganieLiny();
                                Zawody turniej2 = new Zawody("Przeciaganie liny");
                                WynikiSpotkan wyniki2 = new WynikiSpotkan("Przeciaganie liny");
                                turniej2.dodajTurniej(turniej2);
                                przeciaganieLiny.dlugoscLiny(wyniki2);
                                rozgrywka(turniej2, wyniki2, sedzia);
                                break;
                            case "3":
                                DwaOgnie dwaOgnie = new DwaOgnie();
                                Zawody turniej3 = new Zawody("Dwa ognie");
                                WynikiSpotkan wyniki3 = new WynikiSpotkan("Dwa Ognie");
                                turniej3.dodajTurniej(turniej3);
                                dwaOgnie.iloscPilek(wyniki3);
                                rozgrywka(turniej3, wyniki3, sedzia);
                                break;
                            default:
                                System.out.println("Zla opcja");
                                n=0;
                        }
                    }while(n==0);
                    break;
                case "3":
                    do
                    {
                        System.out.println("______________________________");
                        System.out.println("Z jakiej dyscypliny chcesz zobaczyc ostatni turniej?");
                        System.out.println("[1]Siatkowka.");
                        System.out.println("[2]Przeciąganie liny.");
                        System.out.println("[3]Dwa ognie.");
                        System.out.println("______________________________");
                        opcje = scan.nextLine();
                        n=1;
                        switch(opcje)
                        {
                            case "1":
                                WynikiSpotkan wyniki1 = new WynikiSpotkan();
                                wyniki1.odczytWyników("Siatkowka","-");
                                break;
                            case "2":
                                WynikiSpotkan wyniki2 = new WynikiSpotkan();
                                wyniki2.odczytWyników("Przeciaganie liny","-");
                                break;
                            case "3":
                                WynikiSpotkan wyniki3 = new WynikiSpotkan();
                                wyniki3.odczytWyników("Dwa ognie","-");
                                break;
                            default:
                                System.out.println("Zla opcja");
                                n=0;
                        }
                    }while(n==0);
                    break;
                case "4":
                    WynikiSpotkan wyniki1 = new WynikiSpotkan();
                    System.out.println("Siatkowka:");
                    wyniki1.odczytWyników("Siatkowka","*");
                    WynikiSpotkan wyniki2 = new WynikiSpotkan();
                    System.out.println("Przeciaganie liny:");
                    wyniki2.odczytWyników("Przeciaganie liny","*");
                    WynikiSpotkan wyniki3 = new WynikiSpotkan();
                    System.out.println("Dwa ognie:");
                    wyniki3.odczytWyników("Dwa ognie","*");
                    break;
                case "5":
                    do {
                        System.out.println("______________________________");
                        System.out.println("[1]Dodaj sedziego.");
                        System.out.println("[2]Usun sedziego.");
                        System.out.println("[3]Pokaz liste sedziow.");
                        System.out.println("______________________________");
                        opcje = scan.nextLine();
                        n=1;
                        switch(opcje)
                        {
                            case "1":
                                sedzia.dodaj();
                                break;
                            case "2":
                                sedzia.usun();
                                break;
                            case "3":
                                sedzia.przeglad();
                                break;
                            default:
                                System.out.println("Zla opcja");
                                n=0;
                        }
                    }while(n==0);
                    break;
                case "0":
                    return;
                default:
                    System.out.println("Zla opcja");
            }

        }
    }

    /**
     *
     * @param turniej1 pobiera obiekt zawodów
     * Metoda pozwala użytkownikowi na zamianę drużyn biorących udział w zawodach
     */
    public static void zamianaDruzyny(Zawody turniej1){
        int n;
        do {
            n=1;
            Scanner scan = new Scanner(System.in);
            String opcje;
            System.out.println("______________________________");
            System.out.println("Czy chcesz wycofac jakas druzyne i zamienic ja na inna?");
            System.out.println("[1]Tak");
            System.out.println("[2]Nie");
            System.out.println("______________________________");
            opcje = scan.nextLine();
            switch(opcje)
            {
                case "1":
                    turniej1.zamienDruzyne();
                    break;
                case "2":
                    break;
                default:
                    System.out.println("Zla opcja");
                    n=0;
            }
        }while(n==0);
    }

    /**
     *
     * @param turniej pobiera obiekt zawodów
     * @param wyniki pobiera wyniki zawodów
     * @param sedzia pobiera sędziów biorących udział w zawodach
     * Metoda obsługująca turniej. Przesyła dane o turnieju do pliku oraz je zapisuje.
     */
    public static void rozgrywka(Zawody turniej, WynikiSpotkan wyniki, Sedzia sedzia) {
        int id;
        wyniki.wyslijDoPliku(1);
        zamianaDruzyny(turniej);
        wyniki.wyslijDoPliku("Nazwa turnieju: ");
        wyniki.wyslijDoPliku(turniej.getNazwaTurnieju(),1);
        wyniki.wyslijDoPliku("Turniej sedziował: ");
        sedzia.przeslijSedziego();
        id=sedzia.przeslijSedziego();
        wyniki.wyslijDoPliku(sedzia.sedziowie.get(id).imie);
        wyniki.wyslijDoPliku(sedzia.sedziowie.get(id).nazwisko, 1);
        wyniki.wyslijDoPliku("Druzyny biorace udzial: ", 1);
        turniej.rozegrajTurniej();
        System.out.println("Turniej zakonczyl sie z nastepujacymi wynikami:");
        turniej.przegladDruzyn(wyniki);
        wyniki.wyslijDoPliku("*",1);
        turniej.topTrzy(wyniki);
        System.out.println("Szczegoly zostaly zapisane w pliku");
        wyniki.zamknijPlik();
    }
}