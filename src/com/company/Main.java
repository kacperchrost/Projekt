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
                            Siatkowka siatkowka = new Siatkowka();
                            Zawody turniej1 = new Zawody("Siatkowka");
                            turniej1.dodajTurniej();                                 //metoda w Zawody
                            siatkowka.dodajSedziegoPomocniczego(turniej1, sedzia);
                            turniej1.rozegrajTurniej();
                            turniej1.przegladDruzyn();
                            break;
                        case 2:
                            PrzeciaganieLiny przeciaganieLiny = new PrzeciaganieLiny();
                            Zawody turniej2 = new Zawody("Dwa ognie");
                            turniej2.dodajTurniej();                                 //metoda w Zawody
                            turniej2.rozegrajTurniej();
                            turniej2.przegladDruzyn();
                            break;
                        case 3:
                            DwaOgnie dwaOgnie = new DwaOgnie();
                            Zawody turniej3 = new Zawody("Przeciaganie liny");
                            turniej3.dodajTurniej();                                 //metoda w Zawody
                            turniej3.rozegrajTurniej();
                            turniej3.przegladDruzyn();
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
                    //WynikiSpotkan.zamknijPlik();
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
