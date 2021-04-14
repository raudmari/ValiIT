package ee.bcs.valiit.controller;

import ee.bcs.valiit.tasks.Lesson2b;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class Lesson2bController {

    // generateArray http://localhost:8080/generateArray/9
    @GetMapping("/generateArray/{a}")
    public int[] generateArray(@PathVariable("a") int a){
        return Lesson2b.generateArray(a);
    }

    // decreasingArray http://localhost:8080/decreasingArray/3
    @GetMapping("/decreasingArray/{a}")
    public int[] decreasingArray(@PathVariable("a") int a){
        return Lesson2b.decreasingArray(a);
    }

    // yl3 http://localhost:8080/yl3/7

    @GetMapping("/yl3/{a}")
    public int[] yl3(@PathVariable("a") int a){
        return Lesson2b.yl3(a);
    }


}
