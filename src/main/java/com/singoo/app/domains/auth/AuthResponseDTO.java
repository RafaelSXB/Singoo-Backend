package com.singoo.app.domains.auth;

import java.util.UUID;

public class AuthResponseDTO {
    private String token;
    private UserDto user;

    public AuthResponseDTO() {}

    public AuthResponseDTO(String token, UserDto user) {
        this.token = token;
        this.user = user;
    }

    public String getToken() { return token; }
    public void setToken(String token) { this.token = token; }

    public UserDto getUser() { return user; }
    public void setUser(UserDto user) { this.user = user; }


    public static class UserDto {
        private UUID id;
        private String email;
        private String tier;

        public UserDto() {}

        public UserDto(UUID id, String email, String tier) {
            this.id = id;
            this.email = email;
            this.tier = tier;
        }

        public UUID getId() { return id; }
        public void setId(UUID id) { this.id = id; }

        public String getEmail() { return email; }
        public void setEmail(String email) { this.email = email; }

        public String getTier() { return tier; }
        public void setTier(String tier) { this.tier = tier; }
    }
}
