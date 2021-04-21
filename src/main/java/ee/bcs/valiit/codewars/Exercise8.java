package ee.bcs.valiit.codewars;

import java.util.Arrays;

public class Exercise8 {

    public static void main(String[] args) {
        //System.out.println(howOld("9 years old"));
        //System.out.println(nthPower(array, 3));
        //System.out.println(toBinary(256));
        int[] array = new int[]{-3, -2, -1};
        //System.out.println(Arrays.toString(sumOfDifferences(array)));
        System.out.println(sumOfDifferences(array));

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
        int times = 0;
        int sum = 0;
        while (x > 0) {
            if (x % 2 != 0) {
                sum = (int) (sum + Math.pow(10, times));
                x--;
            }
            times++;
            x = x / 2;
        }
        return sum;
    }

    public static int sumOfDifferences(int[] array) {
        int sum = 0;
        for (int i = 1; i < array.length; i++) {
            for (int j = 1; j < array.length; j++) {
               if (array[i-1] > array[i]) {
                    int temp = array[i];
                    array[i] = array[i - 1];
                    array[i-1] = temp;
                }
            }
        }
        for (int z = 0; z < array.length-1; z++) {
            int c = array[z] - array[z + 1];
            sum = sum + Math.abs(c);
        }
        return sum;
    }
}





