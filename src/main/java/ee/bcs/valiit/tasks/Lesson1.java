package ee.bcs.valiit.tasks;

import java.util.Scanner;

// TODO kasuta if/else. Ära kasuta Math librarit
public class Lesson1 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Tee valik meetodite osas: \n" +
                "0 - tagastab kahest täisarvust väiksema; \n" +
                "1 - tagastab kahest täisarvust suurima; \n" +
                "2 - tagastab absoluutarvu; \n" +
                "3 - tagastab paarisarvu; \n" +
                "4 - tagastab kolmet täisarvust väikseima; \n" +
                "5 - tagastab kolmest täisarvust suurima;");
        int num = scanner.nextInt();
        scanner.nextLine();
        switch (num) {
            case 0:
                System.out.println("Sisesta täisarv");
                int a = scanner.nextInt();
                System.out.println("Sisesta täisarv: ");
                int b = scanner.nextInt();
                System.out.println(min(a, b));
                break;
            case 1:
                System.out.println("Sisesta täisarv: ");
                int aa = scanner.nextInt();
                System.out.println("Sisesta täisarv: ");
                int bb = scanner.nextInt();
                System.out.println(max(aa, bb));
                break;
            case 2:
                System.out.println("Sisesta täisarv: ");
                int aaa = scanner.nextInt();
                System.out.println(abs(aaa));
                break;
            case 3:
                System.out.println("Sisesta täisarv: ");
                int aaaa = scanner.nextInt();
                if (isEven(aaaa)) {
                    System.out.println("Sisestatud täisarv on paarisarv");
                } else {
                    System.out.println("Sisestatud täisarv on paarituarv");
                }
                break;
            case 4:
                System.out.println("Sisesta täisarv: ");
                int amin = scanner.nextInt();
                System.out.println("Sisesta täisarv: ");
                int bmin = scanner.nextInt();
                System.out.println("Sisesta täisarv: ");
                int cmin = scanner.nextInt();
                System.out.println(min3(amin, bmin, cmin));
                break;
            case 5:
                System.out.println("Sisesta täisarv: ");
                int amax = scanner.nextInt();
                System.out.println("Sisesta täisarv: ");
                int bmax = scanner.nextInt();
                System.out.println("Sisesta täisarv: ");
                int cmax = scanner.nextInt();
                System.out.println(max3(amax, bmax, cmax));
                break;
            default:
                System.out.println("Funktsioon puudub");
        }


        // Siia sisse võid sa kirjutada koodi, et testida kas su meetodid töötavad ilusti
        // Katseta IntelliJ shortcuti. Olles intelliJ kirjuta "sout" ja siis vajuta enter
        //System.out.println(min(1, 3)); // trükib miinimumi 1 ja 3
    }

    // TODO tagasta a ja b väikseim väärtus
    public static int min(int a, int b) {
        if (a < b) {
            return a;
        } else {
            return b;
        }
    }

    // TODO tagasta a ja b suurim väärtus
    public static int max(int a, int b) {
        if (a > b) {
            return a;
        } else {
            return b;
        }
    }

    // TODO tagasta a absoluut arv
    public static int abs(int a) {
        if (a < 0) {
            return -a;
        }
        return a;

    }


    // TODO tagasta true, kui a on paaris arv
    // tagasta false kui a on paaritu arv
    public static boolean isEven(int a) {
        if (a % 2 == 0) {
            return true;
        }
        return false;
    }

    // TODO tagasta kolmest arvust kõige väiksem
    public static int min3(int a, int b, int c) {
        if (a <= b && a <= c) {
            return a;
        } else if (b <= a && b <= c) {
            return b;
        } else {
            return c;
        }
    }

    // TODO tagasta kolmest arvust kõige suurem
    public static int max3(int a, int b, int c) {
//        if (a >= b && a >= c) {
//            return a;
//        } else if (b >= c && b >= a) {
//            return b;
//        } else {
//            return c;
//        }
        return max(max(a, b), c);
    }
}
