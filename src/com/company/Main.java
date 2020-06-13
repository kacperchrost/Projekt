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
        Zawodnik zawodnik = new Zawodnik();
        Druzyna druzyna = new Druzyna();
        Siatkowka siatkowka = new Siatkowka();
        sedzia.wczytajZPlikuS();
        int opcje;

        while (true)
        {
            System.out.println("______________________________");
            System.out.println("[1]Plazownie");
            System.out.println("[2]Turniej");
            System.out.println("[3]Wczytaj gotowy turniej");
            System.out.println("[4]Tabela wynikow");
            System.out.println("[5]Sedziowie");
            System.out.println("[0]Wyjscie");
            System.out.println("______________________________");
            opcje = scan.nextInt();

            switch(opcje)
            {
                case 1:
                    break;
                case 2:
                    System.out.println("Wybierz dyscypline.");
                    System.out.println("[1]Siatkowka.");
                    System.out.println("[2]Przeciąganie liny.");
                    System.out.println("[3]Dwa ognie.");
                    opcje = scan.nextInt();
                    switch(opcje)
                    {
                        case 1:
                            Zawody turniej = new Zawody();

                            System.out.println("[1]Przygotuj turniej.");
                            System.out.println("[2]Dodaj sedziego pomocniczego.");
                            System.out.println("[3]Rozegraj turniej.");

                            opcje = scan.nextInt();
                            switch(opcje)
                            {
                                case 1:
                                    for (int i=0; i<8; i++)
                                    {
                                        //turniej.dodajDruzyne(druzyna.dodajZawodnikow(siatkowka.getWielkoscDruzyny(), zawodnik.getZawodnicy()));
                                    }

                                    break;
                                case 2:
                                    siatkowka.dodajSedziegoPomocniczego(turniej);
                                    break;
                                case 3:
                                    turniej.rozegrajTurniej();
                                    break;
                                default:
                                    System.out.println("Zla opcja");
                            }
                            break;
                        case 2:

                            break;
                        case 3:

                            break;
                        default:
                            System.out.println("Zla opcja");
                    }
                    break;
                case 3:
                    break;
                case 4:

                    break;
                case 5:
                    System.out.println("[1]Dodaj sedziego.");
                    System.out.println("[2]Usun sedziego.");
                    System.out.println("[3]Pokaz liste sedziow.");
                    opcje = scan.nextInt();
                    switch(opcje)
                    {
                        case 1:
                            sedzia.dodaj();
                            break;
                        case 2:
                            sedzia.usun();
                            break;
                        case 3:
                            sedzia.przeglad();
                            break;
                        default:
                            System.out.println("Zla opcja");
                    }
                    break;
                case 0:
                    return;
                default:
                    System.out.println("Zla opcja");
            }
            clearSccreen();
        }
    }

    private static void clearSccreen() {
        System.out.print("\033[H\033[2J");
        System.out.flush();
    }

}
