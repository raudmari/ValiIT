package ee.bcs.valiit.tasks;

import javax.sound.midi.Soundbank;
import java.util.Random;
import java.util.Scanner;

public class Lesson3Hard {

    static Random random = new Random();
    static int randomNumber = random.nextInt(100);
    static int count = 0;


    // TODO kirjuta mäng mis leiab suvalise numbri 0-99, mille kasutaja peab ära arvama
    // iga kord pärast kasutaja sisestatud täis arvu peab programm ütlema kas number oli suurem või väiksem
    // ja kasutaja peab saama uuesti arvata
    // numbri ära aramise korral peab programm välja trükkima mitu katset läks numbri ära arvamiseks

    public static void main(String[] args) {
/*        Random random = new Random();
        int i = random.nextInt(100);
        // System.out.println(i);

        Scanner scanner = new Scanner(System.in);

        System.out.println("Game players guess\n" +
                "Enter random number between 0 - 99");
        int playerGuess = scanner.nextInt();
        scanner.nextLine();
        int count = 0;

        while (playerGuess != i) {
            if (playerGuess < i) {
                System.out.println("Number should be bigger. Enter new guess number");
                playerGuess = scanner.nextInt();
                scanner.nextLine();
            } else if (playerGuess > i) {
                System.out.println("Number should be smaller. Enter new guess number");
                playerGuess = scanner.nextInt();
                scanner.nextLine();
            } else {
            }
            count++;
        }
        System.out.println("Well done! Your guess is correct. You managed to guess the number on turn " + count + ".");*/
    }
    // kasutamaks esile veebis
    public static String playerGuess(int num){
        count++;
        if (num < randomNumber) {
            return "Number should be bigger.";
        } else if (num > randomNumber) {
            return "Number should be smaller.";
        } else {
            return "Well done! Your guess is correct. Arvasid ära" + count + " korda";
        }
    }


}



