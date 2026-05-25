package com.singoo.app.domains.auth;

public interface AuthServiceInterface {
    AuthResponseDTO register(RegisterRequestDTO request);
    AuthResponseDTO login(LoginRequestDTO request);
}
