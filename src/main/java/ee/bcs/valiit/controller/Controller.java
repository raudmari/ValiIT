package ee.bcs.valiit.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class Controller {
    @GetMapping("sample/hello-world/{nameInUrl}")
    public String helloWorld(@PathVariable("nameInUrl")String name, @RequestParam("action") String action){
        return action + " " + name;
    }


}
