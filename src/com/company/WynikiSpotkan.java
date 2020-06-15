package com.company;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.util.LinkedList;
import java.util.Scanner;

/**
 * @author Dawid Pieciul, Kacper Chrost; implementacja wyjątków Kacper Chrost
 * Klasa WynikiSpotkan przesyła wyniki zawodów do pliku oraz odczytuje je z niego na ekran
 */

public class WynikiSpotkan extends Zawody {

    private LinkedList<Zawody> listaSpotkan;
    PrintWriter wyslij = null;

    /**
     *Konstruktor bezparametrowy
     */

    public WynikiSpotkan(){

    }

    /**
     *
     * @param nazwa przekazywanie nazwy pliku, który ma zostać otwarty
     * @throws FileNotFoundException wyrzuca oraz obsługuje wujątek gdy program ma problem z plikiem
     * Konstruktor jednoparametrowy tworzący plik o nazwie odpowiadającej dyscyplinie
     */
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
     * @param druzyna przekazywany obiekt druzyny, który ma zostać wpisany do pliku
     * Metoda wpisuje wyniki do pliku
     */
    public void wyslijDoPliku(Druzyna druzyna) {
        wyslij.println(druzyna.getNazwa()+", liczba wygranych w etapie kazdy na kazdego : "+druzyna.getLiczbaWygranych()+" ");
    }

    /**
     *
     * @param nazwa przekazywany tekst
     * Metoda wypisuje do pliku przekazany tekst
     */
    public void wyslijDoPliku(String nazwa)  {
        wyslij.print(nazwa+" ");
    }

    /**
     *
     * @param nazwa przekazywany tekst
     * @param n przekazywana liczba
     * Metoda wypisuje do pliku przekazany tekst oraz przechodzi do nowej linii
     */
    public void wyslijDoPliku(String nazwa, int n)  {
        wyslij.println(nazwa+" ");
    }

    /**
     *
     * @param n przekazywana liczba
     * Metoda sprawiające przejście do następnej linii w pliku
     */
    public void wyslijDoPliku(int n)  {
        wyslij.println();
    }
    /**
     *
     * @throws FileNotFoundException wyrzuca oraz obsługuje wyjątek gdy program nie znajdzie pliku o podanej nazwie
     * Metoda wypisuje na ekran wyniki
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

    /**
     * Metoda zamykająca plik
     */
    public void zamknijPlik(){
        wyslij.close();
    }
}