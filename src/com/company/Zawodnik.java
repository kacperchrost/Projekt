package com.company;
import com.company.Osoba;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;
import java.util.LinkedList;

public class Zawodnik extends Osoba{
    protected LinkedList<Osoba> zawodnicy = new LinkedList<>();
    private int id=0;
    Scanner podaj=new Scanner(System.in);
    public Zawodnik(){

    }
    public void dodaj(){
        Osoba zawodnik = new Osoba();
        String imie, nazwisko;
        System.out.println("Podaj imie nowego zawodnika: ");
        imie= podaj.nextLine();
        System.out.println("Podaj nazwisko nowego zawodnika: ");
        nazwisko= podaj.nextLine();
        zawodnik.setImie(imie);
        zawodnik.setNazwisko(nazwisko);
        zawodnik.setId(++id);
        zawodnicy.add(zawodnik);
    }
    public void usun() throws Exception {
        System.out.println("Znasz Id zawodnika którego chesz usunać? ");
        System.out.println("[1] Tak ");
        System.out.println("[2] Nie ");
        int opcje, n=0;
        opcje = podaj.nextInt();
        do{
            n=0;
            switch(opcje)
            {
                case 1:
                    System.out.println("Podaj Id zawodnika do usuniecia:  ");
                    try{
                        usunPom();
                    }
                    catch(Exception e){
                        System.out.println(e.getMessage());
                    }
                    break;
                case 2:
                    System.out.println("Oto lista zawodnikow:   ");
                    przeglad();
                    System.out.println("Podaj Id zawodnika do usuniecia:  ");
                    try{
                        usunPom();
                    }
                    catch(Exception e){
                        System.out.println(e.getMessage());
                    }
                    break;
                default:
                    System.out.println("Zla opcja");
                    n=1;
            }
        }while(n==1);
    }
    public void przeglad(){
        for (Object i : zawodnicy)
        {
            System.out.println("Id:"+((Osoba)i).getId()+" "+((Osoba)i).getImie()+" "+((Osoba)i).getNazwisko());
        }
    }
    public void wczytajZPlikuS() throws FileNotFoundException {
        Scanner plik = null;
        try{
            plik = new Scanner(new File("zawodnicy.txt"));
            Scanner scan = new Scanner(String.valueOf(plik));
        }
        catch(FileNotFoundException e){
            System.out.println("Blad pliku: "+e.getMessage());
            System.exit(1);
        }
        String imie, nazwisko, zdanie;
        while(plik.hasNext())
        {
            Osoba zawodnik = new Osoba();
            zdanie=plik.nextLine();
            String[] ZdaniePom=zdanie.split(" ");
            imie=ZdaniePom[0];
            nazwisko=ZdaniePom[1];
            zawodnik.setImie(imie);
            zawodnik.setNazwisko(nazwisko);
            zawodnik.setId(++id);
            zawodnicy.add(zawodnik);
        }
    }
    public void usunPom(){
        id = podaj.nextInt();
        int usun = 0;
        for (Object i : zawodnicy)
        {
            if (id==(((Osoba)i).getId()));
            {
                usun=id;
            }
        }
        zawodnicy.remove(usun-1);
    }
}