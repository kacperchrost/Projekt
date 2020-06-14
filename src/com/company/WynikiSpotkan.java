package com.company;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.sql.SQLOutput;
import java.util.LinkedList;
import java.util.Scanner;

public class WynikiSpotkan extends Zawody {
    private int idSpotkania;
    private LinkedList<Zawody> listaSpotkan; //nie wiem co tu wpisać narazie
    private String wynik;
    private String nazwapliku;
    private Scanner scan = new Scanner(System.in);
    PrintWriter wyslij = null;

    public WynikiSpotkan(String nazwa){
        listaSpotkan = new LinkedList<Zawody>();
        nazwa+=".txt";
        try{
            wyslij = new PrintWriter(new File(nazwa));
        }
        catch(FileNotFoundException ex){
            System.out.println("Blad pliku: "+ ex.getMessage());
            ex.printStackTrace();
            System.exit(1);
        }
    }

    /**
     *
     * @author KC
     * @param druzyna przekazywana druzyna, która ma zostać wpisana do pliku
     * @throws FileNotFoundException wyrzuca oraz obsługuje wyjątek gdy program ma problem z plikiem
     * Wpisuje wyniki do pliku
     */
    public void wyslijDoPliku(Druzyna druzyna) {
        wyslij.println(druzyna.getNazwa()+", liczba wygranychw etapie kazdy na kazdego : "+druzyna.getLiczbaWygranych()+" ");
    }
    public void wyslijDoPliku(String nazwa)  {
        wyslij.print(nazwa+" ");
    }
    public void wyslijDoPliku(String nazwa, int n)  {
        wyslij.println(nazwa+" ");
    }
    public void wyslijDoPliku(int n)  {
        wyslij.println();
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
    public void zamknijPlik(){
        wyslij.close();
    }
}
