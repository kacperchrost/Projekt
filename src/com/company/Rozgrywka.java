package com.company;

/**
 * @author klasy Dawid Pieciul, implementacja wyjątków Kacper Chrost
 * Klasa odpowiedzialna za tworzenie rozgrywki
 */

public class Rozgrywka extends Zawody {
    /**
     *
     * @param turniej obiekt turnieju przekazywany do metody aby umożliwić dodawanie drużyn do turnieju oraz jego utworzenie
     * Metoda prosi użytkownika o podanie nazwy turnieju oraz o wprowadzenie drużyn biorących udział w zawodach
     */
    public void dodajRozgrywke(Zawody turniej){
        int k=0;
        System.out.println("Wlasnie jest przygotowywany i za chwile zostanie rozgrywany turniej.");
        System.out.println("Podaj nazwe turnieju");
        String nazwa;
        do{
            nazwa= scan.nextLine();
            try{
                k++;
                if(nazwa.isEmpty())
                {
                    throw new Exception();
                }
            }
            catch(Exception ex)
            {
                System.out.println("Nie podano nazwy turnieju. Podaj ponownie: ");
                k=0;
            }
        }while(k==0);
        turniej.setNazwaTurnieju(nazwa);
        for (int i=0; i<8; i++)
        {
            Druzyna druzyna = new Druzyna();
            System.out.println("Podaj nazwe druzyny nr: "+(i+1));
            nazwa = scan.nextLine();
            try{
                if(nazwa.isEmpty())
                {
                    throw new Exception();
                }
                druzyna.setNazwa(nazwa);
                dodajDoListy(druzyna);
            }
            catch(Exception ex){
                System.out.println("Nie podano nazwy druzyny.");
                i--;
            }
        }
    }
}