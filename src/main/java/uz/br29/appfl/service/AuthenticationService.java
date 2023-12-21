package uz.br29.appfl.service;

import uz.br29.appfl.config.dto.JwtAuthenticationResponse;
import uz.br29.appfl.config.dto.RefreshTokenRequest;
import uz.br29.appfl.config.dto.SignInRequest;
import uz.br29.appfl.config.dto.SignupRequest;
import uz.br29.appfl.entity.User;

public interface AuthenticationService {
    User signup(SignupRequest signupRequest);

    JwtAuthenticationResponse signin(SignInRequest request);

    JwtAuthenticationResponse refreshToken(RefreshTokenRequest refreshTokenRequest);

}
