package ee.bcs.valiit.codewars;

import java.util.Arrays;
import java.util.Locale;

public class Exercise7 {
    public static void main(String[] args) {
        String phrase = "How can mirrors be real if our eyes aren't real";
        //System.out.println(Arrays.toString(toJadenCase(phrase)));
        System.out.println(toJadenCase(phrase));

    }

    public static String toJadenCase(String phrase) {
        if (phrase == "" || phrase == null) {
            return null;
        } else {
            String[] words = phrase.split(" ");
            String inUpper = "";
            for (String word : words) {
                String firstChar = word.substring(0, 1);
                String afterFirst = word.substring(1);
                inUpper += firstChar.toUpperCase() + afterFirst + " ";
            }
            return inUpper.trim();
        }
    }

    public static int[] solve (int[] arr){
        for(int i = 0; i < arr.length; i++){
            for(int j = 0; j < arr.length; j++){
                int max = arr[i];

                int min = arr[i];

            }


        }


        return arr;
    }


}
