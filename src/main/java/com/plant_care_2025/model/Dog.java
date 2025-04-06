package com.plant_care_2025.model;
import jakarta.persistence.*;

@Entity
@Table(name = "dog")
public class Dog {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "DogID")
    private Long id;

    @Column(name = "name")
    private String name;

    @Column(name = "breed")
    private String breed;

    @Column(name = "Age")
    private int age;

    @Column(name = "size")
    private String size;

    @Column(name = "gender")
    private String gender;

    @Column(name = "Personality")
    private String personality;

    @Column(name = "owner")
    private String owner;

    // Default constructor (required by JPA)
    public Dog() {}

    // Full constructor (optional, but helpful)
    public Dog(Long id, String name, String breed, int age, String size, String gender, String personality, String owner) {
        this.id = id;
        this.name = name;
        this.breed = breed;
        this.age = age;
        this.size = size;
        this.gender = gender;
        this.personality = personality;
        this.owner = owner;
    }

    // Getters and setters
    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }

    public String getName() { return name; }
    public void setName(String name) { this.name = name; }

    public String getBreed() { return breed; }
    public void setBreed(String breed) { this.breed = breed; }

    public int getAge() { return age; }
    public void setAge(int age) { this.age = age; }

    public String getSize() { return size; }
    public void setSize(String size) { this.size = size; }

    public String getGender() { return gender; }
    public void setGender(String gender) { this.gender = gender; }

    public String getPersonality() { return personality; }
    public void setPersonality(String personality) { this.personality = personality; }

    public String getOwner() { return owner; }
    public void setOwner(String owner) { this.owner = owner; }
}
