package com.company;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.sql.SQLOutput;
import java.util.LinkedList;
import java.util.Scanner;

public class WynikiSpotkan extends Zawody {
    private int idSpotkania;
    private LinkedList<Zawodnik> listaSpotkan; //nie wiem co tu wpisać narazie
    private String wynik;
    private String nazwapliku;
    private Scanner scan = new Scanner(System.in);

    public WynikiSpotkan(){
        listaSpotkan = new LinkedList<Zawodnik>();
    }

    /**
     *
     * @author KC
     * @param druzyna przekazywana druzyna, która ma zostać wpisana do pliku
     * @throws FileNotFoundException wyrzuca oraz obsługuje wyjątek gdy program ma problem z plikiem
     * Wpisuje wyniki do pliku
     */
    public void wyslijDoPliku(LinkedList<Druzyna> druzyna) {
        PrintWriter wyslij = null;
        try{
            wyslij = new PrintWriter(new File("wyniki.txt"));
        }
        catch(FileNotFoundException ex){
            System.out.println("Blad pliku: "+ ex.getMessage());
            System.exit(1);
        }
        wyslij.println(druzyna);

    }

    /**
     * @author KC
     * @throws FileNotFoundException wyrzuca oraz obsługuje wyjątek gdy program nie znajdzie pliku o podanej nazwie
     * Wypisuje na ekran wyniki
     */
    public void odczytWyników() throws FileNotFoundException {
        String wynik;
        Scanner wyniki = null;
        System.out.println("Podaj nazwe pliku ktory chcesz odczytać: ");
        nazwapliku=scan.next();
        nazwapliku+=".txt";
        try{
            wyniki = new Scanner(new File(nazwapliku));
        }
        catch(FileNotFoundException ex){
            System.out.println("Blad pliku: "+ ex.getMessage());
            System.exit(1);
        }
        while(wyniki.hasNext())
        {
            wynik=wyniki.nextLine();
            System.out.println(wynik);
        }
        wyniki.close();
    }
}
