package org.example.util;

import lombok.Getter;
import lombok.Setter;
import org.apache.logging.log4j.Logger;
import org.example.storage.GymStorage;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.Random;

@Getter
@Setter
@Component
public class PasswordGenerator {


    private Logger logger;

    @Autowired
    public void PasswordGenerator(Logger logger) {
        this.logger = logger;
    }

    public String generatePassword() {

        Random random = new Random();
        String characters = "ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz0123456789";
        StringBuilder sb = new StringBuilder(10);
        for (int i = 0; i < 10; i++) {
            sb.append(characters.charAt(random.nextInt(characters.length())));
        }
        String generatedPassword = sb.toString();
        logger.info("Generated password: {}", generatedPassword);
        return generatedPassword;
    }
}

