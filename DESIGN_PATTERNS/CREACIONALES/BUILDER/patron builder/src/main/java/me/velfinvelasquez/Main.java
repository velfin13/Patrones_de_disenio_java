package me.velfinvelasquez;

import me.velfinvelasquez.models.UserProfile;

public class Main {
    public static void main(String[] args) {
        // Crear un perfil de usuario con todos los campos opcionales
        UserProfile userProfile1 = new UserProfile.Builder("velkin", "velkin@example.com")
                .setFirstName("Vel")
                .setLastName("Kin")
                .setPhoneNumber("0960091634")
                .setAddress("123 Main St, Anytown, USA")
                .setNewsletterSubscribed(true)
                .build();

        // Crear un perfil de usuario solo con los campos obligatorios
        UserProfile userProfile2 = new UserProfile.Builder("johndoe", "john.doe@example.com")
                .build();

        System.out.println(userProfile1);
        System.out.println(userProfile2);
    }
}