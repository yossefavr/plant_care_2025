package com.plant_care_2025.model;

import java.time.LocalDate;
import java.time.LocalDateTime;

import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.persistence.Entity;

@Entity
@Table(name = "list_of_events")
public class LiavAndItay {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    
    private String eventName;

    private LocalDate eventDate;

    private int amount;

    // Getters and Setters
    public Long getId() {
        return id;
    }
   
    public String getEventName() {
        return eventName;
    }
    public void setEventName(String eventName) {
        this.eventName = eventName;
    }
    public LocalDate  getEventDate() {
        return eventDate;
    }
    public void setEventDate(LocalDate  eventDate) {
        this.eventDate = eventDate;
    }
    public int getAmount() {
        return amount;
    }
    public void setAmount(int amount) {
        this.amount = amount;
    }
}
