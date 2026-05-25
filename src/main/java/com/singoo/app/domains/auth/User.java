package com.singoo.app.domains.auth;

import java.time.LocalDateTime;
import java.util.UUID;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.PostPersist;
import jakarta.persistence.PrePersist;
import jakarta.persistence.Table;

@Entity
@Table(name = "users")
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private UUID id;

    @Column(name = "name", nullable = false, unique = false)
    private String name;

    @Column(name = "email", nullable = false, unique = true)
    private String email;
    
    @Column(name = "password_hash", nullable = false)
    private String passwordHash;

    @Column(name = "tier", nullable = false)
    private String tier = "FREE";

    @Column(name = "role", nullable = false)
    private String role = "USER";

    @Column(name = "total_points", nullable = false)
    private Integer totalPoints = 0;

    @Column(name = "created_at", nullable = false)
    private LocalDateTime createdAt;

    @Column(name = "updated_at", nullable = false)
    private LocalDateTime updatedAt;

    @PrePersist
    protected void onCreate() {
        createdAt = LocalDateTime.now();
        updatedAt = LocalDateTime.now();
    }

    @PostPersist
    protected void onUpdate() {
        updatedAt = LocalDateTime.now();
    }

    public User() {}

    public User(String name, String email, String passwordHash) {
        this.name = name;
        this.email = email;
        this.passwordHash = passwordHash;
    }

    public UUID getId() {
        return id;
    }

    public String getName() {  return name; }
    public void setName(String name) {  this.name = name; }

    public String getEmail() {  return email; }
    public void setEmail(String email) {  this.email = email; }

    public String getPasswordHash() {  return passwordHash; }
    public void setPasswordHash(String passwordHash) {  this.passwordHash = passwordHash;}

    public String getTier() {  return tier; }
    public void setTier(String tier) {  this.tier = tier; }

    public String getRole() {  return role; }
    public void setRole(String role) {  this.role = role; }

    public Integer getTotalPoints() {  return totalPoints; }
    public void setTotalPoints(Integer totalPoints) {  this.totalPoints = totalPoints;}

    

}
