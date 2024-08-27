package me.velfinvelasquez.models;

import java.util.Date;

public class UserProfile {
    private String username;
    private String email;
    private String firstName;
    private String lastName;
    private String phoneNumber;
    private String address;
    private Date dateOfBirth;
    private Boolean newsletterSubscribed;

    public UserProfile(Builder builder) {
        this.username = builder.username;
        this.email = builder.email;
        this.firstName = builder.firstName;
        this.lastName = builder.lastName;
        this.phoneNumber = builder.phoneNumber;
        this.address = builder.address;
        this.dateOfBirth = builder.dateOfBirth;
        this.newsletterSubscribed = builder.newsletterSubscribed;
    }

    public String getUsername() {
        return username;
    }

    public String getEmail() {
        return email;
    }

    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public String getAddress() {
        return address;
    }

    public Date getDateOfBirth() {
        return dateOfBirth;
    }

    public Boolean getNewsletterSubscribed() {
        return newsletterSubscribed;
    }

    @Override
    public String toString() {
        return "User [username=" + username + ", email=" + email + ", firstName=" + firstName + ", lastName=" + lastName
                + ", phoneNumber=" + phoneNumber + ", address=" + address + ", dateOfBirth=" + dateOfBirth
                + ", newsletterSubscribed=" + newsletterSubscribed + "]";
    }

    public static class Builder {
        private String username;
        private String email;
        private String firstName;
        private String lastName;
        private String phoneNumber;
        private String address;
        private Date dateOfBirth;
        private Boolean newsletterSubscribed;

        // Constructor del Builder con campos obligatorios
        public Builder(String username, String email) {
            if (username == null || username.isEmpty()) {
                throw new IllegalArgumentException("Username cannot be null or empty");
            }
            if (email == null || !email.contains("@")) {
                throw new IllegalArgumentException("Invalid email");
            }
            this.username = username;
            this.email = email;
        }

        public Builder setFirstName(String firstName) {
            this.firstName = firstName;
            return this;
        }

        public Builder setLastName(String lastName) {
            this.lastName = lastName;
            return this;
        }

        public Builder setPhoneNumber(String phoneNumber) {
            this.phoneNumber = phoneNumber;
            return this;
        }

        public Builder setAddress(String address) {
            this.address = address;
            return this;
        }

        public Builder setDateOfBirth(Date dateOfBirth) {
            this.dateOfBirth = dateOfBirth;
            return this;
        }

        public Builder setNewsletterSubscribed(Boolean newsletterSubscribed) {
            this.newsletterSubscribed = newsletterSubscribed;
            return this;
        }

        public UserProfile build() {
            return new UserProfile(this);
        }

    }

}
