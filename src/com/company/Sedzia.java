package com.company;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.Random;
import java.util.Scanner;
import java.util.LinkedList;

public class Sedzia extends Osoba{
    protected static LinkedList<Osoba> sedziowie;
    private int id=0;
    private int idr;
    Scanner podaj=new Scanner(System.in);
    public Sedzia(){
        sedziowie = new LinkedList<>();
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
    public void usun(){
        int opcje, n;
        do{
            System.out.println("Znasz Id sędziego którego chesz usunać? ");
            System.out.println("[1] Tak ");
            System.out.println("[2] Nie ");
            opcje = podaj.nextInt();
            n=0;
            switch(opcje)
            {
                case 1:
                    System.out.println("Podaj Id sedziego do usuniecia:  ");
                    try{
                        usunPom();
                    }
                    catch(Exception e){
                        System.out.println(e.getMessage());
                    }
                    break;
                case 2:
                    System.out.println("Oto lista sedziow:   ");
                    przeglad();
                    System.out.println("Podaj Id sedziego do usuniecia:  ");
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
        for (Object i : sedziowie)
        {
            System.out.println("Id:"+((Osoba)i).getId()+" "+((Osoba)i).getImie()+" "+((Osoba)i).getNazwisko());
        }
    }
    public void wczytajZPlikuS() throws FileNotFoundException {
        Scanner plik = null;
        try{
            plik = new Scanner(new File("sedziowie.txt"));
            Scanner scan = new Scanner(String.valueOf(plik));
        }
        catch(FileNotFoundException e){
            System.out.println("Blad pliku: "+e.getMessage());
            System.exit(1);
        }
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

    /**
     * @author KC
     * @return Zwraca id wylosowanego sedziego
     */
    public static int getRandomId()
    {
        Random random = new Random();
        //idr=random.nextInt(sedziowie.size())+1;
        //return idr;
        return random.nextInt(sedziowie.size())+1;
    }
    public static Sedzia getSedzia(int id)
    {
        return (Sedzia) sedziowie.get(id);
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