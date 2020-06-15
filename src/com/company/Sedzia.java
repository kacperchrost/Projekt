package com.company;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.LinkedList;
import java.util.Scanner;

/**
 * @author Dawid Pieciul, implementacja wyjatków Kacper Chrost
 * Klasa obsługująca sędziów
 */
public class Sedzia extends Osoba{
    public static LinkedList<Osoba> sedziowie;
    private int id=0;
    private int iluWyslanych=-1;
    private int max=0;
    private int a=0;
    Scanner podaj=new Scanner(System.in);
    /**
     *
     * Konstruktor bezparametrowy tworzący listę obiektów klasy Sedzia
     */
    public Sedzia(){
        sedziowie = new LinkedList<>();
    }
    /**
     *
     * Metoda dodaj() dodaje sędziego do listy obiektów klasy Sedzia,
     * prosząc o wpisanie imienia i nazwiska z klawiatury.
     * Zwieksza limit sedziów możliwych do wylosowania o 1.
     */
    public void dodaj(){
        int k=0;
        Osoba sedzia = new Osoba();
        String imie, nazwisko;
        System.out.println("Podaj imie nowego sedziego: ");
        do{
            imie= podaj.nextLine();
            try{
                k++;
                if(imie.isEmpty())
                {
                    throw new Exception();
                }
            }
            catch(Exception ex)
            {
                System.out.println("Nie podano imienia. Podaj ponownie: ");
                k=0;
            }
        }while(k==0);
        System.out.println("Podaj nazwisko nowego sedziego: ");
        do{
            nazwisko= podaj.nextLine();
            try{
                k++;
                if(nazwisko.isEmpty())
                {
                    throw new Exception();
                }
            }
            catch(Exception ex)
            {
                System.out.println("Nie podano nazwiska. Podaj ponownie: ");
                k=0;
            }
        }while(k==0);
        sedzia.setImie(imie);
        sedzia.setNazwisko(nazwisko);
        sedzia.setId(++id);
        sedziowie.add(sedzia);
        max++;
    }
    /**
     *
     * Metoda usun() usuwa obiekt Sedziego z listy obiektów klasy Sedzia,
     * pozwalając na wypisanie listy sedziów w razie nie znania id sedziego do usunięcia.
     * Zmniejsz limit sedziów możliwych do wylosowanie o 1.
     */
    public void usun(){
        int n;
        String opcje;
        do{
            System.out.println("Znasz Id sędziego którego chesz usunać? ");
            System.out.println("[1] Tak ");
            System.out.println("[2] Nie ");
            opcje = podaj.nextLine();
            n=0;
            switch(opcje)
            {
                case "1":
                    System.out.println("Podaj Id sedziego do usuniecia:  ");
                    try{
                        usunPom();
                    }
                    catch(Exception e){
                        System.out.println(e.getMessage());
                    }
                    break;
                case "2":
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
    /**
     *
     * Metoda przeglad() wypisuje id, imie,
     * nazwisko każdego sedziego z listy obiektów klasy Sedzia.
     */
    public void przeglad(){
        for (Object i : sedziowie)
        {
            System.out.println("Id:"+((Osoba)i).getId()+" "+((Osoba)i).getImie()+" "+((Osoba)i).getNazwisko());
        }
    }
    /**
     *
     * Metoda wczytajZPliku() wczytuje sedziów do listy obiektów klasy Sedzia
     * oraz ustawia limit sedziów.
     * Wyjątek uruchamia się podczas barku pliku.
     */
    public void wczytajZPlikuS() {
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
            max++;
        }
    }
    /**
     *
     * Metoda getSedzia (getter)
     * @return Zwraca id wylosowanego sedziego
     */
    public static Sedzia getSedzia(int id)
    {
        return (Sedzia) sedziowie.get(id);
    }
    /**
     *
     * Metoda usunPom() zapobiega powtarzania kodu.
     * Usuwa obiekty z listy sedziów zwskazany przez
     * niepowtarzalny numer (id)
     */
    public void usunPom(){
        a++;
        int idx;
        idx = podaj.nextInt();
        int usun = 0;
        for (Object i : sedziowie)
        {
            if (idx==(((Osoba)i).getId()));
            {
                usun=idx;
            }
        }
        sedziowie.remove(usun-a);
        max--;
    }
    /**
     *
     * Metoda przeslijSedziego() ma na celu zapobiegać wybierania
     * tych samych sędziów do różnch turnieji.
     * @return id aktualnie wysłanego sędziego do turnieju
     */
    public int przeslijSedziego(){
        if (iluWyslanych==max)iluWyslanych=-1;
        iluWyslanych++;
        return iluWyslanych;
    }
}