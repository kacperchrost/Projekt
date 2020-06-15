package com.company;

import java.util.Scanner;
/**
 * @author klasy Dawid Pieciul, implementacja wyjątku Kacper Chrost
 * Klasa odpowiedzialna za tworzenie rozgrywek z przeciągania liny
 */
public class PrzeciaganieLiny extends Rozgrywka{
    private int dlugosc;
    public PrzeciaganieLiny(){

    }
    /**
     *
     * @param wynik Obiekt Wynik przekazywany do metody jest po to aby móc wpisać dlugość liny do pliku.
     * Metoda długoscliny() odpowiada za dodanie do turnieju długości przeciąganej liny
     * Ta metoda uruchamiana jest tylko dla rozgrywek przeciągania liny.
     * Wyjątek odpowada za sprawdenie czy użytkownik podaje dodatnią wartość długosci liny
     */
    public void dlugoscLiny(WynikiSpotkan wynik){
        int n=0;
        System.out.println("Podaj dlugosc przeciaganej liny: ");
        do {
            try {
                n++;
                Scanner podaj=new Scanner(System.in);
                dlugosc = podaj.nextInt();
                if (dlugosc <= 0)
                {
                    throw new Exception();
                }
            }
            catch (Exception ex) {
                System.out.println("Podano nieprawidlowa dlugosc liny. Podaj ponownie: ");
                n=0;
            }
        }while(n==0);
        wynik.wyslijDoPliku("Przeciagana lina miala dlugosc "+getDlugosc()+" m.");
    }

    /**
     * metoda getDlugosc() (getter)
     * @return zwraca dlugość liny
     */
    public int getDlugosc() {
        return dlugosc;
    }
}
