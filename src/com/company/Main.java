package com.company;

import java.util.LinkedList;
import java.util.List;
import java.util.Scanner;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.io.IOException;

/**
 *
 * @author
 * @throws Exception jezeli nie zostanie odnaleziony szukany plik lub index
 *
 */

public class Main {
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
            System.out.println("[4]Tabela wynikow ostatnich turneji");
            System.out.println("[5]Sedziowie");
            System.out.println("[0]Wyjscie");
            System.out.println("______________________________");
            opcje = scan.nextLine();
            switch(opcje)
            {
                case "1":
                    System.out.println("Milego dnia.");

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
                                rozgrywka(turniej1, wyniki1);
                                break;
                            case "2":
                                PrzeciaganieLiny przeciaganieLiny = new PrzeciaganieLiny();
                                Zawody turniej2 = new Zawody("Przeciaganie liny");
                                WynikiSpotkan wyniki2 = new WynikiSpotkan("Przeciaganie liny");
                                turniej2.dodajTurniej(turniej2);
                                przeciaganieLiny.dlugoscLiny(wyniki2);
                                rozgrywka(turniej2, wyniki2);
                                break;
                            case "3":
                                DwaOgnie dwaOgnie = new DwaOgnie();
                                Zawody turniej3 = new Zawody("Dwa ognie");
                                WynikiSpotkan wyniki3 = new WynikiSpotkan("Dwa Ognie");
                                turniej3.dodajTurniej(turniej3);
                                dwaOgnie.iloscPilek(wyniki3);
                                rozgrywka(turniej3, wyniki3);
                                break;
                            default:
                                System.out.println("Zla opcja");
                                n=0;
                        }
                    }while(n==0);
                    break;
                case "3":
                    break;
                case "4":

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
                    //wyniki.zamknijPlik();
                    return;
                default:
                    System.out.println("Zla opcja");
            }

        }
    }
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
    public static void rozgrywka(Zawody turniej, WynikiSpotkan wyniki) {
        wyniki.wyslijDoPliku(1);
        zamianaDruzyny(turniej);
        wyniki.wyslijDoPliku("Nazwa turnieju: ");
        wyniki.wyslijDoPliku(turniej.getNazwaTurnieju(),1);
        wyniki.wyslijDoPliku("Druzyny biorace udzial: ", 1);
        turniej.rozegrajTurniej();
        System.out.println("Turnirj zakonczyl sie z nastepujacymi wynikami:");
        turniej.przegladDruzyn(wyniki);
        wyniki.wyslijDoPliku(1);
        turniej.topTrzy(wyniki);
        wyniki.zamknijPlik();
    }



}
