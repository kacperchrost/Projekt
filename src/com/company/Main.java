package com.company;

import java.util.LinkedList;
import java.util.List;
import java.util.Scanner;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;

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
        }
    }
}
