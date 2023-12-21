package uz.br29.appfl.service;

import org.springframework.security.core.userdetails.UserDetails;
import uz.br29.appfl.entity.User;

import java.util.HashMap;

public interface JWTService {

    String extractUserName(String token);

    String generateToken(UserDetails userDetails);

    boolean isTokenValid(String token, UserDetails userDetails);

    String generateRefreshToken(HashMap<String, Object> extraClaims, UserDetails userDetails);

}
