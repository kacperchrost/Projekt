package com.company;

import java.util.LinkedList;
import java.util.List;
import java.util.Scanner;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;

public class Main {

    public static void main(String[] args) throws FileNotFoundException {
        Scanner scan = new Scanner(System.in);
        int opcje;

        //miejsce na sprawdzanie czy to działa
        Sedzia sedzia = new Sedzia();
        sedzia.wczytajZPlikuS();
        sedzia.przeglad();
        sedzia.dodaj();
        sedzia.przeglad();
        sedzia.usun();
        sedzia.przeglad();
        //koniec sprawdzania czy to działa
        while (true)
        {
            System.out.println("[1]Plazownie");
            System.out.println("[2]Turniej");
            System.out.println("[3]Wczytaj gotowy turniej");
            System.out.println("[4]Tabela wynikow");
            System.out.println("[5]Sedziowie");
            System.out.println("[0]Wyjscie");
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

                    break;
                case 0:
                    return;
                default:
                    System.out.println("Zla opcja");
            }
        }
    }
}
