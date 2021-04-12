package ee.bcs.valiit.tasks;

import java.util.Arrays;

public class Lesson2b {
    public static void main(String[] args) {
        exercise1(9);
        System.out.println();

    }

    // TODO trüki välja n arvu
    // näiteks
    // sisend: 5
    // trüki välja: 1 2 3 4 5
    public static void exercise1(int n) {
        int num = 1;
        while (num <= n) {
            System.out.println(num);
            num++;

        }

        for (int i = 1; i <= n; i++) {
            System.out.println(i);
        }

    }

    // TODO tagasta massiiv milles oleks numbrid 1,2,3,4,5
    public static int[] sampleArray() {
        return new int[]{1, 2, 3, 4, 5};
    }

    // TODO loo massiiv mis saab sisendiks n ja tagastab massiivi suurusega n
    // Kus esimene element on 1 ja iga järnev arv on 1 võrra suurem
    // näiteks:
    // sisend: 5
    // vastus: {1, 2, 3, 4, 5}
    public static int[] generateArray(int n) {
        int[] array = new int[n];
        int i = 0;
        while (i < n) {
            array[i] = i + 1;
            i++;
        }
        return array;
    }

    // TODO
    // Tagastada massiiv kus oleks numbrid n-ist 0 ini
    // Näiteks: sisend: 5
    // Väljund: 5, 4, 3, 2, 1, 0
    // Näide2: siend: -3
    // Väljund: -3, -2, -1, 0
    public static int[] decreasingArray(int n) {
       /* if (n >= 0) {
            int[] array = new int[n+1];
            for (int i = 0; i <= n; i++) {
                array[i] = n - i;
            }
            return array;
        } else {
            int[] array = new int[-n +1 ];
            for (int i = n; i <= 0; i++) {
                array[-n+i] = i;
            }
            return array;
        }*/


        int[] array = new int[Math.abs(n) + 1];
        int index = 0; // määran jada indeksi

        while (n != 0) { // sean tingimuse
            array[index] = n; // esimene
            if (n > 0) {
                n = n - 1;
            } else {
                n = n + 1;
            }
            index++;
        }
        return array;
    }


    // TODO
    // tagasta massiiv pikkusega n, mille kõigi elementide väärtused on 3
    public static int[] yl3(int n) {
        int[] array = new int[n];
        for (int i = 0; i < n; i++) {
            array[i] = 3;
        }
        return array;
    }
}
