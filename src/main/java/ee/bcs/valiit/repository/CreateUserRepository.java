package ee.bcs.valiit.repository;

import ee.bcs.valiit.controller.CreateUser;
import ee.bcs.valiit.tdoKlassid.BankAccount;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.HashMap;
import java.util.Map;

@Repository
public class CreateUserRepository {

    @Autowired
    private NamedParameterJdbcTemplate jdbcTemplate;

    public void createUser(CreateUser createUser) {
        String sql = "INSERT INTO users (username, password) VALUES (:username,:password)";
        Map<String, Object> paramMap = new HashMap<>();
        paramMap.put("username", createUser.getUsername());
        paramMap.put("password", createUser.getPassword());
        jdbcTemplate.update(sql, paramMap);
    }
}
