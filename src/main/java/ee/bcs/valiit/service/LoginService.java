package ee.bcs.valiit.service;

import ee.bcs.valiit.controller.CreateUser;
import ee.bcs.valiit.exception.ApplicationException;
import ee.bcs.valiit.hibernate.HibernateLoginRepository;
import ee.bcs.valiit.hibernate.LoginHibernate;
import ee.bcs.valiit.repository.CreateUserRepository;
import ee.bcs.valiit.tdoKlassid.LoginRequest;
import io.jsonwebtoken.JwtBuilder;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.Date;

@Service
public class LoginService {

    @Autowired
    private CreateUserRepository createUserRepository;

    @Autowired
    private HibernateLoginRepository hibernateLoginRepository;

    @Autowired
    private PasswordEncoder passwordEncoder;

    public String logIn(LoginRequest loginRequest) {
        LoginHibernate getPasswordByUsername = hibernateLoginRepository.findByUsername(loginRequest.getUsername());
        String rawPassword = loginRequest.getPassword();
        String encodedPassword = getPasswordByUsername.getPassword();
        if (passwordEncoder.matches(rawPassword,encodedPassword)) {
            getPasswordByUsername.setLoginTime(LocalDateTime.now());
            hibernateLoginRepository.save(getPasswordByUsername);
            Date today = new Date();
            Date tokenExpirationDate = new Date(today.getTime() + 1000 * 60 * 60);
            JwtBuilder jwtBuilder = Jwts.builder()
                    .setExpiration(tokenExpirationDate)
                    .setIssuedAt(new Date())
                    .signWith(SignatureAlgorithm.HS256, "c2VjcmV0C")
                    .claim("username", loginRequest.getUsername());

            return jwtBuilder.compact();
        } else {
            throw new ApplicationException("Vale parool");
        }
    }

    public void createUser(CreateUser createUser) {
        String newUser = createUser.getUsername();
        if (hibernateLoginRepository.findByUsername(newUser) != null) {
            throw new ApplicationException("Kasutaja juba eksisteerib!");
        } else {
            String encodedPassword = passwordEncoder.encode(createUser.getPassword());
            createUser.setPassword(encodedPassword);
            createUserRepository.createUser(createUser);
        }
    }

}
