package com.company;
import com.company.Osoba;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;
import java.util.LinkedList;

public class Sedzia extends Osoba{
    protected LinkedList<Osoba> sedziowie = new LinkedList<>();
    private int id=0;
    Scanner podaj=new Scanner(System.in);
    public Sedzia(){

    }
    public void dodaj(){
        Osoba sedzia = new Osoba();
        String imie, nazwisko;
        System.out.println("Podaj imie nowego sedziego: ");
        imie= podaj.nextLine();
        System.out.println("Podaj nazwisko nowego sedziego: ");
        nazwisko= podaj.nextLine();
        sedzia.setImie(imie);
        sedzia.setNazwisko(nazwisko);
        sedzia.setId(++id);
        sedziowie.add(sedzia);
    }
    public void usun() {                       //dodać wyjątek
        System.out.println("Znasz Id sędziego którego chesz usunać? ");
        System.out.println("[1] Tak ");
        System.out.println("[2] Nie ");
        int opcje, n=0;
        opcje = podaj.nextInt();
        do{
            n=0;
            switch(opcje)
            {
                case 1:
                    System.out.println("Podaj Id sedziego do usuniecia:  ");
                    usunPom();                                                      //dodać wyjątek
                    break;
                case 2:
                    System.out.println("Oto lista sedziow:   ");
                    przeglad();
                    System.out.println("Podaj Id sedziego do usuniecia:  ");
                    usunPom();                                                       //dodać wyjątek
                    break;
                default:
                    System.out.println("Zla opcja");
                    n=1;
            }
        }while(n==1);
    }
    public void przeglad(){
        for (Object i : sedziowie)
        {
            System.out.println("Id:"+((Osoba)i).getId()+" "+((Osoba)i).getImie()+" "+((Osoba)i).getNazwisko());
        }
    }
    public void wczytajZPlikuS() throws FileNotFoundException {
        Scanner plik = new Scanner(new File("sedziowie.txt"));
        String imie, nazwisko, zdanie;
        while(plik.hasNext())
        {
            Osoba sedzia = new Osoba();
            zdanie=plik.nextLine();
            String[] ZdaniePom=zdanie.split(" ");
            imie=ZdaniePom[0];
            nazwisko=ZdaniePom[1];
            sedzia.setImie(imie);
            sedzia.setNazwisko(nazwisko);
            sedzia.setId(++id);
            sedziowie.add(sedzia);
        }
    }
    public void usunPom(){
        id = podaj.nextInt();
        int usun = 0;
        for (Object i : sedziowie)
        {
            if (id==(((Osoba)i).getId()));
            {
                usun=id;
            }
        }
        sedziowie.remove(usun-1);
    }
}