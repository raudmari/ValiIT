package ee.bcs.valiit.controller;

import ee.bcs.valiit.tasks.Lesson2;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class Lesson2Controller {

    // ReverseArray http://localhost:8080/reverseArray/2,3,4,5,6
    @GetMapping("/reverseArray/{array}")
    public int[] reverseArray(@PathVariable("array") int[] array){
        return Lesson2.reverseArray(array);
    }

    // evenNumbers http://localhost:8080/evennumbers/8evennumbers/8
    @GetMapping("/evennumbers/{a}")
    public int[] evenNumbers(@PathVariable("a") int a){
        return Lesson2.evenNumbers(a);
    }

    //min http://localhost:8080/min/3,5,6,7,8,9,1
    @GetMapping("/min/{array}")
    public int min(@PathVariable("array") int[] array){
        return Lesson2.min(array);
    }

    //max http://localhost:8080/max/3,5,6,7,8,9,1
    @GetMapping("/max/{array}")
    public int max(@PathVariable("array") int[] array){
        return Lesson2.max(array);
    }

    //sum http://localhost:8080/sum/3,5,6,7,8,9,1
    @GetMapping("/sum/{array}")
    public int sum(@PathVariable("array") int[] array){
        return Lesson2.sum(array);
    }

    //fibonacci http://localhost:8080/fibonacci/57
    @GetMapping("/fibonacci/{a}")
    public int fibonacci(@PathVariable("a") int a){
        return Lesson2.fibonacci(a);
    }

    //sequence3n http://localhost:8080/sequence3n/4/8
    @GetMapping("/sequence3n/{a}/{b}")
    public int sequence3n(@PathVariable("a")int a, @PathVariable("b") int b){
        return Lesson2.sequence3n(a,b);
    }

}
