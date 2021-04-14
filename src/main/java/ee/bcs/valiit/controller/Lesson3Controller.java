package ee.bcs.valiit.controller;

import ee.bcs.valiit.tasks.Lesson3;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class Lesson3Controller {


    // Factorial http://localhost:8080/factorial?a=8
    @GetMapping("/factorial")
    public int factorial(@RequestParam("a") int a){
        return Lesson3.factorial(a);
    }

    // reverseString http://localhost:8080/reverseString?a=kollane
    @GetMapping("/reverseString")
    public String reverseString(@RequestParam("a") String a){
        return Lesson3.reverseString(a);
    }

    // isPrime http://localhost:8080/isPrime?a=30
    @GetMapping("/isPrime")
    public boolean isPrime(@RequestParam("a") int a){
        return Lesson3.isPrime(a);
    }

    // sort http://localhost:8080/sort?a=
    @GetMapping("/sort")
    public int[] sort(@RequestParam("a") int[] a){
        return Lesson3.sort(a);
    }

    //evenFibonacci http://localhost:8080/evenFibonacci?a=7
    @GetMapping("/evenFibonacci")
    public int evenFibonacci(@RequestParam("a") int a){
        return Lesson3.evenFibonacci(a);
    }

    //morseCode http://localhost:8080/morseCode?a=kaos
    @GetMapping("/morseCode")
    public String morseCode(@RequestParam("a") String a){
        return Lesson3.morseCode(a);
    }
}
