package org.example.util;

import org.example.storage.GymStorage;

public class UsernameGenerator {
    private static GymStorage gymStorage;

    public static void setGymStorage(GymStorage storage) {
        gymStorage = storage;
    }

    public static String generateUsername(String firstName, String lastName) {
        // Calculate base username
        String baseUsername = firstName + "." + lastName;

        // Check if the username already exists in GymStorage
        if (gymStorage != null && gymStorage.usernameExists(baseUsername)) {
            // Append a serial number as suffix
            int serialNumber = 1;
            while (gymStorage.usernameExists(baseUsername + serialNumber)) {
                serialNumber++;
            }
            return baseUsername + serialNumber;
        } else {
            return baseUsername;
        }
    }
}
