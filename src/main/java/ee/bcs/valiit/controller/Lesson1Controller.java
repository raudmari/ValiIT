package ee.bcs.valiit.controller;

import ee.bcs.valiit.tasks.Lesson1;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController

public class Lesson1Controller {
    // Minimum http://localhost:8080/min/8/10
    @GetMapping("/min/{a}/{b}")
    public int min(@PathVariable("a") int a, @PathVariable("b") int b){
        return Lesson1.min(a,b);
    }

    // Maximum http://localhost:8080/max?a=8&b=10
    @GetMapping("/max")
    public int max(@RequestParam("a") int a, @RequestParam("b") int b){
        return Lesson1.max(a,b);
    }

    //Absolut value http://localhost:8080/abs?a=-456
    @GetMapping("/abs")
    public int abs(@RequestParam("a") int a){
        return Lesson1.abs(a);
    }

    //IsEven boolean http://localhost:8080/is_even/327
    @GetMapping("/is_even/{a}")
    public boolean isEven(@PathVariable("a") int a){
        return Lesson1.isEven(a);
    }

    //Min3 int http://localhost:8080/min3/8/9/20
    @GetMapping("/min3/{a}/{b}/{c}")
    public int min3(@PathVariable("a") int a, @PathVariable("b") int b, @PathVariable("c") int c){
        return Lesson1.min3(a,b,c);
    }

    //Max3 http://localhost:8080/max3/8/9/20
    @GetMapping("max3/{a}/{b}/{c}")
    public int max3(@PathVariable("a") int a, @PathVariable("b") int b, @PathVariable("c") int c){
        return Lesson1.max3(a,b,c);
    }

}
