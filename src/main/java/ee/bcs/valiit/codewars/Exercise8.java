package ee.bcs.valiit.codewars;

public class Exercise8 {

    public static void main(String[] args) {
        //System.out.println(howOld("9 years old"));
        //System.out.println(nthPower(array, 3));
        System.out.println(toBinary(256));

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

    public static String toBinary(int x) {
        String answer = "";
        while (x > 1) {
            if (x % 2 == 0) {
                answer += "0";
            } else {
                answer += "1";
                x--;
            }
            x = x / 2;
        }
        answer = answer + "1";
        return String.valueOf(answer);
    }

}





