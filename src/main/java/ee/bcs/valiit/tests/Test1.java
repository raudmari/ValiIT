package ee.bcs.valiit.tests;

import javax.print.attribute.standard.PresentationDirection;
import java.util.Arrays;


public class Test1 {
    public static void main(String[] args) {
        //System.out.println(equalsThreeSeven(21));
        //int[] array = new int[]{3, 5, 7, 2, 1};
        //System.out.println(Arrays.toString(array));
        //System.out.println(Arrays.toString(addToArray(array, 3)));
        //System.out.println(howOld("9 years old"));
        //System.out.println(nthPower(array, 3));
        System.out.println(toBinary(64));

    }

    public static boolean equalsThreeSeven(int x) {
        if (x % 3 == 0 && x % 7 != 0) {
            return true;
        } else if (x % 3 != 0 && x % 7 == 0) {
            return true;
        } else {
            return false;
        }
    }

    public static int[] addToArray(int[] array, int x) {
        int[] arrayPlusX = new int[array.length];
        for (int i = 0; i < array.length; i++) {
            arrayPlusX[i] = array[i] + x;
        }
        return arrayPlusX;
    }

    public static int howOld(String herOld) {
        String age = herOld.substring(0, 1);
        int ageInInt = Integer.parseInt(age);

        return ageInInt;
    }

    public static int nthPower(int[] array, int n) {
        if (n >= array.length || n < 0) {
            return -1;
        } else {
            array[n] = (int) Math.pow(array[n], n);
            return array[n];
        }
    }

    public static int toBinary(int x) {
        for( int i = 0; Math.pow(2,i) <= x; i++){
            System.out.println("Kordaja " + i);
        }

        return -1;
    }


}
