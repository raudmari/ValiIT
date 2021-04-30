package ee.bcs.valiit.controller;

import ee.bcs.valiit.exception.ApplicationException;
import ee.bcs.valiit.service.LoginService;
import ee.bcs.valiit.tdoKlassid.LoginRequest;
import io.jsonwebtoken.JwtBuilder;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.time.LocalDateTime;
import java.util.Date;

@RestController
public class LoginController {

    @Autowired
    private LoginService loginService;

    // http://localhost:8080/api/public/login
    @PostMapping("/api/public/login")
    public String logIn(@RequestBody LoginRequest loginRequest) {
        return loginService.logIn(loginRequest);

    }
    // http://localhost:8080/api/public/createUser
    @PostMapping("/api/public/createUser")
    public void createUser(@RequestBody CreateUser createUser) {
        loginService.createUser(createUser);
    }
}
