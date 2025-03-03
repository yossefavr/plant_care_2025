package com.plant_care_2025.model;


import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;

@Entity
@Table(name = "user") // Explicitly specify the table name
public class User {
	 @Id
	    @GeneratedValue(strategy = GenerationType.IDENTITY)
	    private Long id;

	 	@Column(name = "username", unique = true, nullable = false)
	    private String userName;

		@Column(name = "first_name", nullable = false)
	    private String firstName;


		@Column(name = "last_name", nullable = false)
	    private String lastName;

	    @Column(nullable = false)
	    private String email;

	    @Column(nullable = false)
	    private String password;

	    @ManyToOne
	    @JoinColumn(name = "authority_id") // Foreign key to authority table
	    private Authority role;

	    public Long getId() {
			return id;
		}

		public void setId(Long id) {
			this.id = id;
		}

		public String getFirstName() {
			return firstName;
		}

		public void setFirstName(String firstName) {
			this.firstName = firstName;
		}

		public String getLastName() {
			return lastName;
		}

		public void setLastName(String lastName) {
			this.lastName = lastName;
		}

		public String getEmail() {
			return email;
		}

		public void setEmail(String email) {
			this.email = email;
		}

		public String getPassword() {
			return password;
		}

		public void setPassword(String password) {
			this.password = password;
		}

		public Authority getRole() {
			return role;
		}

		public void setRole(Authority role) {
			this.role = role;
		}
		public String getUserName() {
			return userName;
		}

		public void setUserName(String userName) {
			this.userName = userName;
		}

}
