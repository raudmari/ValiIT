package ee.bcs.valiit.tasks;

import javax.swing.text.html.HTMLDocument;
import java.util.*;

public class Lesson3 {

    public static void main(String[] args) {
 /*       System.out.println(factorial(6));
        System.out.println(reverseString("Marion"));
        System.out.println(isPrime(7));
        System.out.println(Arrays.toString(sort(new int[]{7, 1, 8, 23, 9})));*/
        System.out.println(evenFibonacci(80));
        //System.out.println(morseCode("kuul"));
    }

    // TODO tagasta x faktoriaal.
    // Näiteks
    // x = 5
    // return 5*4*3*2*1 = 120

    public static int factorial(int x) {
        int sum = 1;                    // SUM = 1, kuna arv korda 1 on arv ise. O ei saa olla, kuna siis on kõik O.
        for (int i = x; i >= 1; i--) {  // loobin nii kaua kuni x võrdub 1ga
            sum = sum * i;              // pärast iga loopi toimub tehe sum * i
        }
        return sum;                     // tagastan summa
    }

    // TODO tagasta string tagurpidi
    public static String reverseString(String a) {
        String b = "";                              // loon tühja stringi jutumärgid, seest tühi.
        for (int i = 0; i < a.length(); i++) {      // loop, stringi pikkuse järgi
            b += a.charAt(a.length() - 1 - i);      // liidan tühja stringi elemendi, mis on sisestatud sõne kõige viimasem element.
        }                                           // iga loobiga liigub uude stringi liidetav element sisestatud sõne viimaseset elemendist
        return b;                                   // ühe võrra ette poole.
    }                                               // tagastan reversed stringi, mille lõin real 32.

    // TODO tagasta kas sisestatud arv on primaar arv (jagub ainult 1 ja iseendaga)
    public static boolean isPrime(int x) {
        if (x == 1) {                               // tingimus, kui arv on 1, siis on false
            return false;
        }
        for (int i = 2; i < x; i++) {               // loop, mis algab 2ga ja kestab kuni sisestatud arvuni x.
            if (x % i == 0) {                       // tingimus, kui arv jagub veel mõne arvuga peale iseenda, siis tagastan false
                return false;                       // algarv jagub vaid iseendaga, antud if tingimus välistab kõik muud võimalused.
            }                                       // i tähistab kõike arve peale arvu enda!
        }
        return true;                                // tagastan arvu, mis jagub vaid iseendaga
    }


    // TODO sorteeri massiiv suuruse järgi.
    // TODO kasuta tsükleid, ära kasuta ühtegi olemasolevat sort funktsiooni
    public static int[] sort(int[] a) {
        int[] array = new int[a.length];            // loon uue array, mille pikkus on sama suur kui sisend arrayil
        for (int i = 0; i < a.length; i++) {        // loon luubi, mis käib läbi loobi pikkuse
            for (int j = 0; j < a.length; j++) {    // loon teise loobi, et loopiga iga element läbi risti läbi.
                int temp = 0;                       // loon ajutise muutuja, mida kasutan, et ajutiselt määrata kõige suurema väärtusega element
                if (a[i] > array[j]) {              // loon tingimuse, mis võrdleb kas element on suurem kui
                    temp = a[i];
                    a[i] = array[j];
                    array[j] = temp;
                }
            }
        }
        return array;
    }


    // TODO liida kokku kõik paaris fibonacci arvud kuni numbrini x
    public static int evenFibonacci(int x) {
        int a = 0;
        int b = 1;
        int sum = 0;

        if (x == 0) {
            return 0;
        } else if (x == 1) {
            return 1;
        } else {
            for (int i = 2; i <= x; i++) {
                int sumOfPreviousTwo = a + b;
                a = b;
                b = sumOfPreviousTwo;
                if (a % 2 == 0) {
                    if (a <= x) {
                        sum = sum + a;
                    }
                }
            }
            return sum;
        }
    }

    // TODO kirjuta programm, mis tagastab sisestatud teksti morse koodis (https://en.wikipedia.org/wiki/Morse_code)
    // Kasuta sümboleid . ja - ning eralda kõik tähed tühikuga

    public static String morseCode(String text) {

        Map<Character,String> morseAlphabet = new HashMap<>();
        morseAlphabet.put('a', ".-");
        morseAlphabet.put('b', "-...");
        morseAlphabet.put('c', "-.-.");
        morseAlphabet.put('d', "-..");
        morseAlphabet.put('e', ".");
        morseAlphabet.put('f', "..-.");
        morseAlphabet.put('g', "--.");
        morseAlphabet.put('h', "....");
        morseAlphabet.put('i', "..");
        morseAlphabet.put('j', ".---");
        morseAlphabet.put('k', "-.-");
        morseAlphabet.put('l', ".-..");
        morseAlphabet.put('m', "--");
        morseAlphabet.put('n', "-.");
        morseAlphabet.put('o', "---");
        morseAlphabet.put('p', ".--.");
        morseAlphabet.put('q', "--.-");
        morseAlphabet.put('r', ".-.");
        morseAlphabet.put('s', "...");
        morseAlphabet.put('t', "-");
        morseAlphabet.put('u', "..-");
        morseAlphabet.put('v', "...-");
        morseAlphabet.put('w', ".--");
        morseAlphabet.put('x', "-..-");
        morseAlphabet.put('y', "-.--");
        morseAlphabet.put('z', "--..");

        String stringInMorse = "";

        for (int i = 0; i < text.length(); i++) {
            stringInMorse += morseAlphabet.get(text.charAt(i)) + " ";
                }

        return stringInMorse.trim();
    }
}

