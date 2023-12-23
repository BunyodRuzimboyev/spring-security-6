package uz.br29.appfl.service;

import uz.br29.appfl.dto.JwtAuthenticationResponse;
import uz.br29.appfl.dto.request.RefreshTokenRequest;
import uz.br29.appfl.dto.request.SignInRequest;
import uz.br29.appfl.dto.request.SignupRequest;
import uz.br29.appfl.entity.User;

public interface AuthenticationService {
    User signup(SignupRequest signupRequest);

    JwtAuthenticationResponse signin(SignInRequest request);

    JwtAuthenticationResponse refreshToken(RefreshTokenRequest refreshTokenRequest);

}
