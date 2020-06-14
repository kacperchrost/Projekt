package com.company;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.util.LinkedList;
import java.util.Scanner;

public class WynikiSpotkan extends Zawody {

    private LinkedList<Zawody> listaSpotkan;
    PrintWriter wyslij = null;

    public WynikiSpotkan(){

    }
    public WynikiSpotkan(String nazwa){
        listaSpotkan = new LinkedList<>();
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
        wyslij.println(druzyna.getNazwa()+", liczba wygranych w etapie kazdy na kazdego : "+druzyna.getLiczbaWygranych()+" ");
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
    public void odczytWyników(String nazwaPliku, String n) throws FileNotFoundException {
        String wynik;
        String nazwa = nazwaPliku;
        Scanner wyniki = null;
        nazwaPliku+=".txt";
        int i=0;
        try{
            wyniki = new Scanner(new File(nazwaPliku));
        }
        catch(FileNotFoundException ex){
            System.out.println("Blad pliku: "+ ex.getMessage()+" lub nie bylo jeszcze rozgrywek z dysacypliny "+nazwa);
            System.exit(1);
        }

        while(wyniki.hasNext())
        {
            wynik=wyniki.nextLine();
            if (n.equals("-")){
                System.out.println(wynik);
                i++;
            }
            if (wynik.equals("* "))n="-";
        }
        if(i<=1)
        {
            System.out.println("Nie bylo jeszcze rozgrywek z dyscypliny "+nazwa);
        }
        wyniki.close();
    }
    public void zamknijPlik(){
        wyslij.close();
    }
}
