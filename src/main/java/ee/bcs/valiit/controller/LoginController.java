package ee.bcs.valiit.controller;

import ee.bcs.valiit.security.LoginRequest;
import io.jsonwebtoken.JwtBuilder;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.Date;

@RestController
public class LoginController {
    // http://localhost:8080/api/public/login
    @PostMapping("/api/public/login")
    public String logIn(@RequestBody LoginRequest loginRequest){
        Date tokenExpirationDate = new Date(new Date().getTime() + 1000*60*60);
        JwtBuilder jwtBuilder = Jwts.builder()
                .setExpiration(tokenExpirationDate)
                .setIssuedAt(new Date())
                .signWith(SignatureAlgorithm.HS256, "c2VjcmV0C")
                .claim("username", loginRequest.getUsername());
        return jwtBuilder.compact();
    }
}
