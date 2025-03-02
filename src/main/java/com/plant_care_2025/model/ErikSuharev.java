package com.plant_care_2025.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

//Model (Entity)
@Entity
public class ErikSuharev {
 @Id
 @GeneratedValue(strategy = GenerationType.IDENTITY)
 private Long id;
 private String username;
 private String email;
 private String lastVisit;

 public ErikSuharev() {}

 public ErikSuharev(String username, String email, String lastVisit) {
     this.username = username;
     this.email = email;
     this.lastVisit = lastVisit;
 }

 public Long getId() { return id; }
 public String getUsername() { return username; }
 public String getEmail() { return email; }
 public String getLastVisit() { return lastVisit; }

 public void setUsername(String username) { this.username = username; }
 public void setEmail(String email) { this.email = email; }
 public void setLastVisit(String lastVisit) { this.lastVisit = lastVisit; }
}

