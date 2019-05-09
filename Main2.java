// zadanie 2

// 1. W pliku `Main2.java` stwórz trzy zmienne, o nazwach: `nr1, nr2, nr3`, przechowujące liczby całkowite.
// 2. Następnie, za pomocą instrukcji warunkowej `if ... else if ... else`, wypisz w konsoli, która z nich jest największa.
// 3. Wypisany String ma być wg wzoru: `Największa z liczb 7,2,11 to 11.`. Pamiętaj, aby wypisywać liczby przy pomocy zmiennych.

public class Main2 {

    public static void main(String[] args) {
        int nr1 = 67;
        int nr2 = 78;
        int nr3 = 345;

        if (nr1 > nr2 && nr2 > nr3) ; {
            System.out.println("Największa z liczb: " + nr1 + "," + nr2 + "," + nr3 + " to liczba: " + nr1);
        } else if (nr2 > nr1 && nr1 > nr3); {
            System.out.println("Największa z liczb:" + nr1 + "," + nr2 + "," + nr3 + "to liczba: " + nr2);
        } else; {
            System.out.println ("Największa z liczb:" + nr1 + "," + nr2 + "," + nr3 + "to liczba: " + nr3);
       }
        }

    }
