package com.company;

public class Rozgrywka extends Zawody {
    public void dodajRozgrywke(Zawody turniej){
        System.out.println("Wlasnie jest przygotowywany i za chwile zostanie rozgrywany turniej.");
        System.out.println("Podaj nazwe turnieju");
        String nazwa;
        nazwa= scan.nextLine();
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
            }
            catch(Exception ex){
                System.out.println("Nie podano nazwy druzyny.");
                i--;
            }
            druzyna.setNazwa(nazwa);
            dodajDoListy(druzyna);
        }
    }
}
