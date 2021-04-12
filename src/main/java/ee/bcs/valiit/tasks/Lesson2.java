package ee.bcs.valiit.tasks;

import java.util.Scanner;

public class Lesson2 {

    public static void main(String[] args) {
        // TODO siia saab kirjutada koodi testimiseks
      /*  int[] jada = new int[]{1, 2, 4, 5, 6, 7};
        multiplyTable(10, 10);
        System.out.println(sum(jada));
        System.out.println(Arrays.toString(jada));
        System.out.println(Arrays.toString(evenNumbers(7)));
        System.out.println(Arrays.toString(reverseArray(jada)));
        System.out.println(min(jada));
        System.out.println(max(jada));*/
        System.out.println(fibonacci(8));


    }

    // TODO loe funktsiooni sisendiks on täisarvude massiiv
    // TODO tagasta massiiv mille elemendid on vastupidises järiekorras
    public static int[] reverseArray(int[] inputArray) {
        int[] outputArray = new int[inputArray.length]; // uus massiiv on sama suurusega nagu sisedn massiiv
        int num = inputArray.length;
        for (int i = 0; i < num; i++) {
            outputArray[i] = inputArray[num - 1 - i]; // uue massiivi index on sisend massiivi suurus - 1 - iteratsioon:
        }
        return outputArray;
    }

    // TODO tagasta massiiv mis sisaldab n esimest paaris arvu
    // Näide:
    // Sisend 5
    // Väljund 2 4 6 8 10
    public static int[] evenNumbers(int n) {
        int[] evenNumbers = new int[n];
        for (int i = 2; i <= n * 2; i++) {
            if (i % 2 == 0) {
                evenNumbers[i / 2 - 1] = i;
            }
        }
        return evenNumbers;
    }
    // for(int i = 0; i < n; i++)
    //evenNumbers[i] = (i+1)*2;


    // TODO, leia massiivi kõige väiksem element
    public static int min(int[] x) {
        int min = x[0];
        for (int i = 1; i < x.length; i++) {
            if (x[i] < min) {
                min = x[i];
            }
        }

        return min;
    }

    // TODO, leia massiivi kõige suurem element
    public static int max(int[] x) {
        int max = x[0];
        for (int i = 1; i < x.length; i++) {
            if (x[i] > max) {
                max = x[i];
            }
        }
        return max;
    }

    // TODO, leia massiivi kõigi elementide summa
    public static int sum(int[] x) {
        int sum = 0;
        for (int i = 0; i < x.length; i++) {
            sum += x[i];
        }
        return sum;
    }

    // TODO trüki välja korrutustabel mis on x ühikut lai ja y ühikut kõrge
    // TODO näiteks x = 3 y = 3
    // TODO väljund
    // 1 2 3
    // 2 4 6
    // 3 6 9
    // TODO 1 trüki korrutustabeli esimene rida (numbrid 1 - x)
    // TODO 2 lisa + " " print funktsiooni ja kasuta print mitte println
    // TODO 3 trüki seda sama rida y korda
    // TODO 4 Kuskile võiks kirjutada System.out.println(),
    //  et saada taebli kuju
    // TODO 5 võrdle ridu. Kas on mingi seaduspärasus ridade vahel,
    // mis on ja mis võiks olla. Äkki tuleb mõni idee
    public static void multiplyTable(int x, int y) {
/*        int[][] nums = new int[x][y];
        for (int i = 1; i <= nums.length; i++) {
            for (int j = 1; j <= nums[i].length; j++) {
                nums[i-1][j-1] = i * j;
                System.out.print(nums[i][j] + " ");
            }
        }
        System.out.println();
    }*/

        for (int i = 1; i <= x; i++) {
            for (int j = 1; j <= y; j++) {
                System.out.print(i * j + " \t");
            }
            System.out.println();
        }
    }


    // TODO
    // Fibonacci jada on fib(n) = fib(n-1) + fib(n-2);
    // 0, 1, 1, 2, 3, 5, 8, 13, 21
    // Tagasta fibonacci jada n element. Võid eeldada, et n >= 0
    public static int fibonacci(int n) {
        int a = 0;
        int b = 1;
        if (n == 0) {           // fibonaccit ei saa arvutada ei 0st ega 1st, sellepärast tingimused on hardcodina siise antud.
            return 0;
        } else if (n == 1) {
            return 1;
        } else {
            for (int i = 2; i <= n; i++) {
                int sumOfPreviousTwo = a + b;
                a = b;
                b = sumOfPreviousTwo;

            }
            return b;
        }
    }

    // TODO
    // Kujutame ette numbrite jada, kus juhul kui number on paaris arv siis me jagame selle 2-ga
    // Kui number on paaritu arv siis me korrutame selle 3-ga ja liidame 1. (3n+1)
    // Seda tegevust teeme me niikaua kuni me saame vastuseks 1
    // Näiteks kui sisend arv on 22, siis kogu jada oleks:
    // 22 -> 11 -> 34 -> 17 -> 52 -> 26 -> 13 -> 40 -> 20 -> 10 -> 5 -> 16 -> 8 -> 4 -> 2 -> 1
    // Sellise jada pikkus on 16
    // Kirjutada programm, mis peab leidma kõige pikema jada pikkuse mis jääb kahe täis arvu vahele
    // Näiteks:
    // Sisend 10 20
    // Siis tuleb vaadata, kui pikk jada tuleb kui esimene numbr on 10. Järgmisen tuleb arvutada number 11 jada pikkus.
    // jne. kuni numbrini 20
    // Tagastada tuleb kõige pikem number
    // Näiteks sisendi 10 ja 20 puhul on vastus 20

    public static int sequence3n(int x, int y) {

        int size = y - x;           // size tähistab mitu arvulist elementi on vaja läbi loopida
        int z = 0;                  // loobi kordaja, mida kasutan järgmises luubis arvu suurendamiseks ühe võrra
        int biggest = 0;            // biggest on muutuja, mis tagastab kõige enama elementidega jada.
        while (size >= 0) {         // kõige esimene loop, mis kestab senim, kuni elementide arv == 0;
            int j = 0;              // lugeja, mis loendab jada pikkuse.
            int g = x + z;          // muutuja g tähistab arvu ja selle muutujat;
            while (g != 1) {        // loobi tingimus kuniks, arvu ei ole 1;
                if (g % 2 == 0) {   // tingimus, kui tegemist on paarisarvuga, siis tuleb, see jagada 2-ga.
                    g = g / 2;
                } else {
                    g = (3 * g) + 1; // tingimus, kui on paaritu arv, siis korrutada 3-ga ja liita juurde 1.
                }
                j++;                    // loobi loendur kasvab ühe võrra.
                System.out.print(g + " ");
            }
            z++;                      //välimise loobi loendur
            size--;                   // välimine loobi loendur väheneb 1 võrra
            if (biggest <= j) {       // tingimus, kui eelmises loobis saadud elementide arv on väiksem kui uues loobis saadud elementide arv,
                biggest = j;          // siis uues loobis saadud elementide arv asendub.
            }
        }
        return biggest + 1;            // lõppu lisame + 1, kuna arv ise tuleb ka elementide jada hulka arvestada.
    }

}







