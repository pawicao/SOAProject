package pl.edu.agh.soa.auth;

import javax.inject.Singleton;

import com.auth0.jwt.JWT;
import com.auth0.jwt.algorithms.Algorithm;
import com.auth0.jwt.exceptions.JWTCreationException;
import com.auth0.jwt.exceptions.JWTVerificationException;
import java.nio.charset.StandardCharsets;
import java.util.Random;

@Singleton
public class AuthenticationService {

    private Algorithm algorithm;

    public AuthenticationService(){
        byte[] array = new byte[15];
        new Random().nextBytes(array);
        String key = new String(array, StandardCharsets.UTF_8);
        algorithm = Algorithm.HMAC256(key);
    }

    public String generateToken() throws JWTCreationException{
        return JWT.create().withIssuer("auth0").sign(algorithm);
    }

    public void verifyToken(String token) throws JWTVerificationException {
        JWT.require(algorithm).withIssuer("auth0").build().verify(token);
    }
}
