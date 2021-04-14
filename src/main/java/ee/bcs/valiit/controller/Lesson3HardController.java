package ee.bcs.valiit.controller;

import ee.bcs.valiit.tasks.Lesson3Hard;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class Lesson3HardController {

    // PlayerGuess http://localhost:8080/playerGuess/80
    @GetMapping("/playerGuess/{a}")
    public String playerGuess(@PathVariable("a") int a) {
        return Lesson3Hard.playerGuess(a);
    }

}


