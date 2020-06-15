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
    Scanner podaj=new Scanner(System.in);
    /**
     *
     * Konstruktor bezparametrowy tworzący listę obiektów klasy Sedzia
     */
    public Sedzia(){
        sedziowie = new LinkedList<>();
    }
    /**
     * @author Dawid Pieciul
     * Metoda dodaj() dodaje sędziego do listy obiektów klasy Sedzia,
     * prosząc o wpisanie imienia i nazwiska z klawiatury.
     * Zwieksza limit sedziów możliwych do wylosowanie o 1.
     */
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
        max++;
    }
    /**
     * @author Dawid Pieciul, implementacja Kacper Chrost
     * Metoda usun() usuwa obiekt Sedziego z listy obiektów klasy Sedzia,
     * pozwalając na wypisanie listy sedziów w razie nie znania id sedziego do usunięcia.
     * Zmniejsz limit sedziów możliwych do wylosowanie o 1.
     */
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
    /**
     * @author Dawid Pieciul
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
     * @author Dawid Pieciul, implementacja wyjątku Kacper Chrost
     * Metoda wczytajZPliku() wczytuje sedziów do listy obiektów klasy Sedzia
     * oraz ustawia limit sedziów.
     * @throws FileNotFoundException Obsługa braku pliku.
     */
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
            max++;
        }
    }
    /**
     * @author Dawid Pieciul
     *  Metoda getSedzia (getter)
     * @return Zwraca id wylosowanego sedziego
     */
    public static Sedzia getSedzia(int id)
    {
        return (Sedzia) sedziowie.get(id);
    }
    /**
     * @author Dawid Pieciul
     * Metoda usunPom() zapobiega powtarzania kodu.
     * Usuwa obiekty z listy sedziów zwskazany przez
     * niepowtarzalny numer (id)
     */
    public void usunPom(){
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
        sedziowie.remove(usun-1);
        max--;
    }
    /**
     * @author Dawid Pieciul
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