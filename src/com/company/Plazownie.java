package com.company;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;
/**
 * @author Bartłomiej Busłowski, implementacja wyjątku Kacper Chrost
 * Klasa obsługująca plażowanie
 */
public class Plazownie {
    /**
     * @author Bartłomiej Busłowski
     * metoda plazuj() wypisuje zawartość pliku plaza.txt na ekran.
     * Wyjątek uruchamia się podczas barku pliku.
     */
    public void plazuj(){
       Scanner in = null;
       try{
           in = new Scanner(new File("plaza.txt"));
       }
       catch(FileNotFoundException ex)
       {
           System.out.println("Blad pliku: "+ex.getMessage());
           System.exit(1);
       }

        while (in.hasNext())
        {
            String linia = in.nextLine();
            System.out.println(linia);
        }
        in.close();
    }
}